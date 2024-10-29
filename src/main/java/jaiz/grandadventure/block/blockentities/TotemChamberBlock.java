package jaiz.grandadventure.block.blockentities;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class TotemChamberBlock extends Block implements BlockEntityProvider {
    int y = 15;

    public TotemChamberBlock(Settings settings) {
        super(settings);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return CustomBlockEntities.TOTEM_CHAMBER_BLOCK_ENTITY.instantiate(pos, state);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return TickableBlockEntity.getTicker(world);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {

        if (y == 0) {
            y=15;
            world.playSound((double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, SoundEvents.ENTITY_ELDER_GUARDIAN_AMBIENT, SoundCategory.BLOCKS, 3.0f, 0.8f, false);
        } else {
            y--;
        }


        if(random.nextInt(20) == 1){
        Direction direction = Direction.random(random);
        if (direction == Direction.UP) {
            return;
        }
        BlockPos blockPos = pos.offset(direction);
        BlockState blockState = world.getBlockState(blockPos);
        if (state.isOpaque() && blockState.isSideSolidFullSquare(world, blockPos, direction.getOpposite())) {
            return;
        }
        double d = direction.getOffsetX() == 0 ? random.nextDouble() : 0.2 + (double)direction.getOffsetX() * 0.2;
        double e = direction.getOffsetY() == 0 ? random.nextDouble() : 0.2 + (double)direction.getOffsetY() * 0.2;
        double f = direction.getOffsetZ() == 0 ? random.nextDouble() : 0.2 + (double)direction.getOffsetZ() * 0.2;
        world.addParticle(ParticleTypes.END_ROD, (double)pos.getX() + d, (double)pos.getY() + e, (double)pos.getZ() + f, 0.0 + random.nextDouble() * 0.1, 0.0 + random.nextDouble() * 0.1, 0.0 + random.nextDouble() * 0.1);

    }}
}
