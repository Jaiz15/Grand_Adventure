package jaiz.grandadventure.entity.thrown_entities;

import jaiz.grandadventure.entity.ModEntities;
import jaiz.grandadventure.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;


public class ThrownRockEntity extends ThrownItemEntity {
    public ThrownRockEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public int i = random.nextInt(15);
    public int k = 1;
    public int j = 15;

    public ThrownRockEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.ROCK, livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.ROCK;
    }


    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        entity.damage(this.getDamageSources().thrown(this, this.getOwner()), 2);
        super.onEntityHit(entityHitResult);
    }

    @Override
    public void tick() {
        super.tick();
        this.setRotation(this.getYaw(),this.getPitch());
        if(this.isTouchingWater() && k == 1) {
            this.dropItem(ModItems.ROCK);
            this.discard();
        } else {
            k++;
        }
        if(j == 0){
            this.discard();
        }
        if(this.isTouchingWater() && i >= 1){
            j--;
            if(this.random.nextInt(80) == 1){
                this.discard();
            } else{
                if (i >= 15){
                    this.setVelocity(this, this.getPitch(), this.getYaw(), 0.0f, 0.1f, 0.0f);
                    this.addVelocity(0, 0.2, 0);
                } else if (i >= 12){
                    this.setVelocity(this, this.getPitch(), this.getYaw(), 0.0f, 0.1f, 0.0f);
                    this.addVelocity(0, 0.2, 0);
                } else if (i >= 9){
                    this.setVelocity(this, this.getPitch(), this.getYaw(), 0.0f, 0.1f, 0.0f);
                    this.addVelocity(0, 0.2, 0);
                }else if (i >= 6){
                    this.setVelocity(this, this.getPitch(), this.getYaw(), 0.0f, 0.1f, 0.0f);
                    this.addVelocity(0, 0.2, 0);
                }else if (i >= 3){
                    this.setVelocity(this, this.getPitch(), this.getYaw(), 0.0f, 0.1f, 0.0f);
                    this.addVelocity(0, 0.2, 0);
                } else {
                    this.setVelocity(this, this.getPitch(), this.getYaw(), 0.0f, 0.1f, 0.0f);
                    this.addVelocity(0, 0.2, 0);
                }
                i--;}} else if(this.isTouchingWater()){
            this.discard();} else {j = 15;}
    }


    private ParticleEffect getParticleParameters() {
        ItemStack itemStack = this.getStack();
        return !itemStack.isEmpty() && !itemStack.isOf(this.getDefaultItem())
                ? new ItemStackParticleEffect(ParticleTypes.ITEM, itemStack)
                : ParticleTypes.POOF;
    }

    @Override
    public void handleStatus(byte status) {
        if (status == EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES) {
            ParticleEffect particleEffect = this.getParticleParameters();

            for (int i = 0; i < 2; i++) {
                this.getWorld().addParticle(particleEffect, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
            }
        }
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) {
            this.playSound(SoundEvents.BLOCK_STONE_BREAK, 1.0f, 1.0f);
            this.getWorld().sendEntityStatus(this,
                    EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES);
            this.discard();
        }
    }

    @Override
    public boolean isPushedByFluids() {
        return false;
    }

}
