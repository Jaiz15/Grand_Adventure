package jaiz.grandadventure.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LanternBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.util.stream.Stream;

public class ChineseLanternBlock extends LanternBlock {

    public ChineseLanternBlock(Settings settings) {
        super(settings);
    }

    protected static final VoxelShape STANDING_SHAPE = Stream.of(
            Block.createCuboidShape(6, 0, 6, 10, 2, 10),
            Block.createCuboidShape(6, 10, 6, 10, 11, 10),
            Block.createCuboidShape(3, 2, 3, 13, 10, 13)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    protected static final VoxelShape HANGING_SHAPE = Stream.of(
            Block.createCuboidShape(6, 2, 6, 10, 4, 10),
            Block.createCuboidShape(6, 12, 6, 10, 13, 10),
            Block.createCuboidShape(3, 4, 3, 13, 12, 13)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(HANGING) ? HANGING_SHAPE : STANDING_SHAPE;
    }

}
