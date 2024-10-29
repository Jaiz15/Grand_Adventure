package jaiz.grandadventure.entity.living_entities;

import jaiz.grandadventure.entity.ModEntities;
import jaiz.grandadventure.entity.ai.GrandstoneStatuesAttackGoal;
import jaiz.grandadventure.statuseffects.ModStatusEffects;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class GrandCannonEntity extends PathAwareEntity implements RangedAttackMob {

    public GrandCannonEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
        this.disableExperienceDropping();
    }


    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    protected void initGoals() {
        this.initCustomGoals();
    }

    protected void initCustomGoals() {
        this.targetSelector.add(3, new GrandstoneStatuesAttackGoal(this, PlayerEntity.class, true));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.goalSelector.add(1, new ProjectileAttackGoal(this, 1.25, 20, 64.0F));
    }


    @Override
    public boolean canImmediatelyDespawn(double distanceSquared) {
        return false;
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


    public static DefaultAttributeContainer.Builder createGrandstoneAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 160)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.0f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 48)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0f)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 0.4);
    }

    @Override
    public void shootAt(LivingEntity target, float pullProgress) {
        ItemStack itemStack = Items.BOW.getDefaultStack();
        PersistentProjectileEntity persistentProjectileEntity = ProjectileUtil.createArrowProjectile(this, itemStack, 1, itemStack);
        double d = target.getEyeY() - 1.1F;
        double e = target.getX() - this.getX();
        double f = d - persistentProjectileEntity.getY();
        double g = target.getZ() - this.getZ();
        double h = Math.sqrt(e * e + g * g) * 0.2F;
        persistentProjectileEntity.setVelocity(e, f + h, g, 1.9F, 2.0F);
        this.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.getWorld().spawnEntity(persistentProjectileEntity);
    }

}
