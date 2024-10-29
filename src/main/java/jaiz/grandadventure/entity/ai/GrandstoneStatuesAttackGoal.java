package jaiz.grandadventure.entity.ai;

import jaiz.grandadventure.statuseffects.ModStatusEffects;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;

public class GrandstoneStatuesAttackGoal extends ActiveTargetGoal {


    public GrandstoneStatuesAttackGoal(MobEntity mob, Class targetClass, boolean checkVisibility) {
        super(mob, targetClass, checkVisibility);
    }

    @Override
    public boolean canStart() {
        if(this.mob.hasStatusEffect(ModStatusEffects.CALMING)){
            this.mob.setTarget(null);
            return false;
        }
        this.findClosestTarget();
        return this.targetEntity != null;
    }

}
