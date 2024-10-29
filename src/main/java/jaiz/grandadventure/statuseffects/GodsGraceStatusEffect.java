package jaiz.grandadventure.statuseffects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class GodsGraceStatusEffect extends StatusEffect {

    public int i = 60;

    protected GodsGraceStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);

    }

    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.getWorld().playSound(null, entity.getX(), entity.getY() + 0.5f,
                entity.getZ(), SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER,
                SoundCategory.PLAYERS, 10.0f, 0.5f);
        entity.getWorld().createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(),
                25, World.ExplosionSourceType.MOB);
        return true;
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration == 1;
    }
}




