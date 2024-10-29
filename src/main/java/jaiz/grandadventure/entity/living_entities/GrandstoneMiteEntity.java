package jaiz.grandadventure.entity.living_entities;

import jaiz.grandadventure.entity.ai.GrandstoneStatuesAttackGoal;
import jaiz.grandadventure.statuseffects.ModStatusEffects;
import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GrandstoneMiteEntity extends PathAwareEntity {

    public GrandstoneMiteEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.initCustomGoals();
    }

    @Override
    public boolean canImmediatelyDespawn(double distanceSquared) {
        return false;
    }


    protected void initCustomGoals() {
        this.targetSelector.add(3, new GrandstoneStatuesAttackGoal(this, PlayerEntity.class, true));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1D, true));
    }


    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }

    @Override
    public void tick() {
        super.tick();
        if(this.hasStatusEffect(ModStatusEffects.CALMING)){
            this.setTarget(null);
            this.setInvulnerable(true);
        } else {
            this.setInvulnerable(false);
        }

    }


    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_GUARDIAN_AMBIENT;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.BLOCK_STONE_PLACE, 0.3f, 0.7f);
    }

    @Override
    public boolean isPushable() {
        return !this.hasStatusEffect(ModStatusEffects.CALMING);
    }

    public static DefaultAttributeContainer.Builder createGrandstoneAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 8)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.225f)
                .add(EntityAttributes.GENERIC_ARMOR, 0.4f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.9f)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 0.2);

    }

}
