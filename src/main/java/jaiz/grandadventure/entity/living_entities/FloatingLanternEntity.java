package jaiz.grandadventure.entity.living_entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.World;

public class FloatingLanternEntity extends MobEntity {

    public FloatingLanternEntity(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
        this.setNoGravity(true);
    }

    public int o = 1500;

    @Override
    public void tick() {
        super.tick();

        if(o == 1500){
            this.setVelocity
                    (this.random.nextFloat() * 0.1,
                            0.05,
                            this.random.nextFloat()* 0.1);
        }
        if(this.random.nextInt(20) == 1){
        this.setVelocity
                (this.random.nextFloat() * 0.1,
                0.05,
                this.random.nextFloat()* 0.1);
        }

        if(o == 0){
            this.discard();
        }else{
            o--;
        }
    }
}
