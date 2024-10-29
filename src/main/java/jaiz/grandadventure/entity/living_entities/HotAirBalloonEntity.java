package jaiz.grandadventure.entity.living_entities;

import jaiz.grandadventure.entity.client.HotAirBalloonVariant;
import jaiz.grandadventure.item.ModItems;
import net.minecraft.entity.*;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class HotAirBalloonEntity extends MobEntity {

    public HotAirBalloonEntity(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
        this.disableExperienceDropping();
        this.setInvulnerable(true);
        this.setNoGravity(true);
    }

    public float h = -0.005f; //height velocity

    public boolean isUpItem(ItemStack stack) {
        return stack.isOf(Items.COAL);
    }

    public boolean isDownItem(ItemStack stack) {
        return stack.isOf(Items.SAND);
    }

    @Override
    public boolean canImmediatelyDespawn(double distanceSquared) {
        return false;
    }


    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        boolean down = this.isDownItem(player.getStackInHand(hand));
        boolean up = this.isUpItem(player.getStackInHand(hand));
        if (!this.hasPassengers() && !player.shouldCancelInteraction()) {
            if (!this.getWorld().isClient) {
                player.startRiding(this);
            }
            return ActionResult.success(this.getWorld().isClient);
        }

        if(down && !this.isOnGround()) {
            h = h - 0.005f;
            this.playSound(SoundEvents.ITEM_BRUSH_BRUSHING_SAND,1,0.5f);
            if (!player.getAbilities().creativeMode) {
                player.getStackInHand(hand).decrement(1);
            }

        } else if(up){
            h = h + 0.005f;
            this.playSound(SoundEvents.ITEM_FIRECHARGE_USE,1,0.9f);
            if (!player.getAbilities().creativeMode) {
                player.getStackInHand(hand).decrement(1);
            }
        }

        if(!down && !up && !this.hasPassengers()){
            this.dropItem(ModItems.HOT_AIR_BALLOON);
            this.discard();
        }

        return ActionResult.success(this.getWorld().isClient);

    }

    @Override
    protected Vec3d getPassengerAttachmentPos(Entity passenger, EntityDimensions dimensions, float scaleFactor) {
        return super.getPassengerAttachmentPos(passenger, dimensions, scaleFactor)
                .add(
                        new Vec3d(0.0, -3.9, 0.0)
                                .rotateY(-this.getYaw() * (float) (Math.PI / 180.0))
                );
    }


    @Override
    public void tick() {
        super.tick();

        if(h >= 0.01f){
            h = 0.01f;
        }

        if(h <= -0.01f){
            h = -0.01f;
        }

        if(this.hasPassengers()){
        this.addVelocity(0, h, 0);
        }

    }

    @Override
    public boolean isPushable() {
        return false;
    }

    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setVariant(HotAirBalloonVariant.byId(nbt.getInt("Variant")));
    }

    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(DATA_ID_TYPE_VARIANT, 0);
    }

    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(HotAirBalloonEntity.class, TrackedDataHandlerRegistry.INTEGER);

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        HotAirBalloonVariant variant = Util.getRandom(HotAirBalloonVariant.values(), this.random);
        setVariant(variant);
        return super.initialize(world, difficulty, spawnReason, entityData);
    }

    public Object getVariant() {
        return HotAirBalloonVariant.byId(this.getTypeVariant() & 255);
    }

    public int getTypeVariant() {
        return this.dataTracker.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(HotAirBalloonVariant variant) {
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    @Nullable
    @Override
    public LivingEntity getControllingPassenger() {
            Entity var2 = this.getFirstPassenger();
        if(!this.isOnGround()){
            if (var2 instanceof PlayerEntity) {
                return (PlayerEntity)var2;
            }
        }
        return super.getControllingPassenger();
    }

    @Override
    protected void tickControlled(PlayerEntity controllingPlayer, Vec3d movementInput) {
            this.setRotation(controllingPlayer.getYaw(), controllingPlayer.getPitch() * 0.5f);
            this.bodyYaw = this.headYaw = this.getYaw();
            this.prevYaw = this.headYaw;
            super.tickControlled(controllingPlayer, movementInput);
    }

    @Override
    protected float getSaddledSpeed(PlayerEntity controllingPlayer) {
        return 0.125f;
    }

    @Override
    protected Vec3d getControlledMovementInput(PlayerEntity controllingPlayer, Vec3d movementInput) {
        this.updateVelocity(this.getMovementSpeed(), movementInput);
        return new Vec3d(0.0, 0.0, 1.0);
    }

    @Override
    public void travel(Vec3d movementInput) {
            super.travel(movementInput);
    }

}
