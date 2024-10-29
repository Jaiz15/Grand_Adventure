package jaiz.grandadventure.entity.living_entities;

import jaiz.grandadventure.entity.client.KoiVariant;
import jaiz.grandadventure.item.ModItems;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.*;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectUtil;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.GuardianEntity;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.*;
import org.jetbrains.annotations.Nullable;

public class KoiEntity extends FishEntity {


    public AnimationState swimAnimationState = new AnimationState();
    private int swimAnimationTimeout = 0;

    private void swimAnimationStates() {
        if (this.swimAnimationTimeout <= 0) {
            this.swimAnimationTimeout = 20;
            this.swimAnimationState.start(this.age);
        } else {
            --this.swimAnimationTimeout;
        }

    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient()) {
            swimAnimationStates();
        }

    }

    @Override
    protected void mobTick() {
        ServerWorld serverWorld = (ServerWorld)this.getWorld();
        super.mobTick();
        if (this.random.nextInt(750) == 1) {
            addRegenToClosePlayers(serverWorld, this.getPos(), this, 5);
        }
    }

    public static void addRegenToClosePlayers(ServerWorld world, Vec3d pos, @Nullable Entity entity, int range) {
        StatusEffectInstance statusEffectInstance = new StatusEffectInstance(StatusEffects.REGENERATION, 100, 0, false, false);
        StatusEffectUtil.addEffectToPlayersWithinDistance(world, entity, pos, (double)range, statusEffectInstance, 100);

    }

    public static boolean canSpawn(EntityType<? extends net.minecraft.entity.mob.WaterCreatureEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return (random.nextInt(20) == 0 || !world.isSkyVisibleAllowingSea(pos))
                && (SpawnReason.isAnySpawner(spawnReason) || world.getFluidState(pos).isIn(FluidTags.WATER))
                && world.getFluidState(pos.down()).isIn(FluidTags.WATER);
    }

    public KoiEntity(EntityType<? extends FishEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected SoundEvent getFlopSound() {
        return null;
    }

    @Override
    public ItemStack getBucketItem() {
        return new ItemStack(ModItems.KOI_BUCKET);
    }


    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setVariant(KoiVariant.byId(nbt.getInt("Variant")));
    }

    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(DATA_ID_TYPE_VARIANT, 0);
    }

    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(KoiEntity.class, TrackedDataHandlerRegistry.INTEGER);

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        KoiVariant variant = Util.getRandom(KoiVariant.values(), this.random);
        setVariant(variant);
        return super.initialize(world, difficulty, spawnReason, entityData);
    }

    public Object getVariant() {
        return KoiVariant.byId(this.getTypeVariant() & 255);
    }

    public int getTypeVariant() {
        return this.dataTracker.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(KoiVariant variant) {
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    private int getKoiFishVariant() {
        return this.dataTracker.get(DATA_ID_TYPE_VARIANT);
    }

    @Override
    public void copyDataToStack(ItemStack stack) {
        super.copyDataToStack(stack);
        NbtComponent.set(DataComponentTypes.BUCKET_ENTITY_DATA, stack, nbtCompound -> nbtCompound.putInt("BucketVariantTag", this.getKoiFishVariant()));
    }

    @Override
    public void copyDataFromNbt(NbtCompound nbt) {
        super.copyDataFromNbt(nbt);
        if (nbt.contains("BucketVariantTag", NbtElement.INT_TYPE)) {
            this.setVariant(KoiVariant.byId(nbt.getInt("BucketVariantTag")));
        }
    }
}
