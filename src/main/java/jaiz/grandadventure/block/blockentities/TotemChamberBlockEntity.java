package jaiz.grandadventure.block.blockentities;

import jaiz.grandadventure.statuseffects.ModStatusEffects;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;

import java.util.List;

public class TotemChamberBlockEntity extends BlockEntity implements TickableBlockEntity {

    public TotemChamberBlockEntity(BlockPos pos, BlockState state) {
        super(CustomBlockEntities.TOTEM_CHAMBER_BLOCK_ENTITY, pos, state);
    }

    @Override
    public void tick() {
        if(this.world == null || this.world.isClient) {return;}
                Box box = (new Box(pos).expand(150).stretch(0.0, world.getHeight(), 0.0));
        List<LivingEntity> list = world.getNonSpectatingEntities(LivingEntity.class, box);
        for (LivingEntity livingEntity  : list) {
            livingEntity.addStatusEffect(new StatusEffectInstance(ModStatusEffects.CALMING,
                    90, 0, false, false));
        }
    }
}
