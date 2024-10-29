package jaiz.grandadventure.entity.thrown_entities;

import jaiz.grandadventure.entity.ModEntities;
import jaiz.grandadventure.entity.living_entities.KoiEntity;
import jaiz.grandadventure.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.FishEntity;
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


public class FishFoodEntity extends ThrownItemEntity {
    public FishFoodEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public int j = 600;

    public FishFoodEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.FISH_FOOD, livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.FISH_FOOD;
    }


    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        if(entity instanceof FishEntity) {
            ((FishEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 40, 1));
            this.getWorld().sendEntityStatus(this, EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES);
            this.discard();
        }
        super.onEntityHit(entityHitResult);
    }

    @Override
    public void tick() {
        super.tick();
        j--;
        if(j == 0){
            this.discard();
        }
    }


    private ParticleEffect getParticleParameters() {
        ItemStack itemStack = this.getStack();
        return !itemStack.isEmpty() && !itemStack.isOf(this.getDefaultItem())
                ? new ItemStackParticleEffect(ParticleTypes.ITEM, itemStack)
                : ParticleTypes.HEART;
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
            this.playSound(SoundEvents.BLOCK_ROOTED_DIRT_BREAK, 1.0f, 1.0f);
            this.discard();
        }
    }

    @Override
    public boolean isPushedByFluids() {
        return false;
    }

}
