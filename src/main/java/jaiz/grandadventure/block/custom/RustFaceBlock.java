package jaiz.grandadventure.block.custom;

import com.mojang.serialization.MapCodec;
import jaiz.grandadventure.block.ModBlocks;
import jaiz.grandadventure.entity.ModEntities;
import jaiz.grandadventure.entity.living_entities.FloatingLanternEntity;
import jaiz.grandadventure.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.LichenGrower;
import net.minecraft.block.MultifaceGrowthBlock;
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
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class RustFaceBlock extends MultifaceGrowthBlock {

    private final LichenGrower grower = new LichenGrower(this);
    public RustFaceBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends MultifaceGrowthBlock> getCodec() {
        return null;
    }

    @Override
    public LichenGrower getGrower() {
        return null;
    }


    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (RustFaceBlock.rusterItem(itemStack)) {
            world.playSound(null, pos, SoundEvents.ITEM_HONEYCOMB_WAX_ON, SoundCategory.BLOCKS, 0.7f, 1.0f);
            RustFaceBlock.dropStack(world, pos, new ItemStack(ModBlocks.RUST));
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }

        }
        return super.onUseWithItem(stack, state, world, pos, player, hand, hit);

    }

    private static boolean rusterItem(ItemStack stack) {
        return stack.isOf(Items.SLIME_BALL);
    }


}
