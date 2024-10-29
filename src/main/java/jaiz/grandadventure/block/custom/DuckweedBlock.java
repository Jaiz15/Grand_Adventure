package jaiz.grandadventure.block.custom;

import com.mojang.serialization.MapCodec;
import jaiz.grandadventure.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class DuckweedBlock extends PlantBlock implements Fertilizable{
    public static final MapCodec<DuckweedBlock> CODEC = createCodec(DuckweedBlock::new);
    protected static final VoxelShape SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 1.5, 16.0);

    @Override
    public MapCodec<DuckweedBlock> getCodec() {
        return CODEC;
    }

    public DuckweedBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        super.onEntityCollision(state, world, pos, entity);
        if (world instanceof ServerWorld && entity instanceof BoatEntity) {
            world.breakBlock(new BlockPos(pos), true, entity);
        }
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        FluidState fluidState = world.getFluidState(pos);
        FluidState fluidState2 = world.getFluidState(pos.up());
        return (fluidState.getFluid() == Fluids.WATER || floor.getBlock() instanceof IceBlock) && fluidState2.getFluid() == Fluids.EMPTY;
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        BlockPos blockPos2 = pos.east();
        BlockPos blockPos3 = pos.west();
        BlockPos blockPos4 = pos.north();
        BlockPos blockPos5 = pos.south();

        BlockPos blockPos21 = pos.east().down();
        BlockPos blockPos31 = pos.west().down();
        BlockPos blockPos41 = pos.north().down();
        BlockPos blockPos51 = pos.south().down();

        BlockState blockState2 = world.getBlockState(blockPos2);
        BlockState blockState3 = world.getBlockState(blockPos3);
        BlockState blockState4 = world.getBlockState(blockPos4);
        BlockState blockState5 = world.getBlockState(blockPos5);

        BlockState blockState21 = world.getBlockState(blockPos21);
        BlockState blockState31 = world.getBlockState(blockPos31);
        BlockState blockState41 = world.getBlockState(blockPos41);
        BlockState blockState51 = world.getBlockState(blockPos51);

        BlockState blockStategrowth = ModBlocks.DUCKWEED.getDefaultState();

        if (blockState2.isIn(BlockTags.AIR)) {
            if (blockState21.isOf(Blocks.WATER)) {
                world.setBlockState(blockPos2, blockStategrowth);
            }
        }
        if (blockState3.isIn(BlockTags.AIR)) {
            if (blockState31.isOf(Blocks.WATER)) {
                world.setBlockState(blockPos3, blockStategrowth);
            }
        }
        if (blockState4.isIn(BlockTags.AIR)) {
            if (blockState41.isOf(Blocks.WATER)) {
                world.setBlockState(blockPos4, blockStategrowth);
            }
        }
        if (blockState5.isIn(BlockTags.AIR)) {
            if (blockState51.isOf(Blocks.WATER)) {
                world.setBlockState(blockPos5, blockStategrowth);
            }
        }



    }

}