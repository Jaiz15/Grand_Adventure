package jaiz.grandadventure.block.custom;

import jaiz.grandadventure.entity.ModEntities;
import jaiz.grandadventure.entity.living_entities.FloatingLanternEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CarpetBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class FloatingLanternBlock extends Block {

    private static final VoxelShape SHAPE = Block.createCuboidShape(4, 0, 4, 12, 12, 12);

    public FloatingLanternBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state,
                                             World world, BlockPos pos,
                                             PlayerEntity player, Hand hand,
                                             BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        FloatingLanternEntity lanternEntity = ModEntities.FLOATING_LANTERN.create(world);
        if (FloatingLanternBlock.lighterItem(itemStack)) {
            world.playSound(null, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 0.7f, 1.0f);
            lanternEntity.refreshPositionAndAngles((double)pos.getX() + 0.5,
                    pos.getY(), (double)pos.getZ() + 0.5, 0.0f, 0.0f);
            world.spawnEntity(lanternEntity);
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
            world.breakBlock(pos, false);
        }
        return super.onUseWithItem(stack, state, world, pos, player, hand, hit);

    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return !world.isAir(pos.down());
    }



    private static boolean lighterItem(ItemStack stack) {
        return stack.isOf(Items.TORCH);
    }

}
