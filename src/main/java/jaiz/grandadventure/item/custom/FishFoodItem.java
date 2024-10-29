package jaiz.grandadventure.item.custom;

import jaiz.grandadventure.entity.thrown_entities.FishFoodEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class FishFoodItem extends Item {

    public FishFoodItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, SoundCategory.NEUTRAL, 0.1f, 0.2f / (world.getRandom().nextFloat() * 0.4f + 0.8f));

        if (!world.isClient) {
            FishFoodEntity fishFoodEntity = new FishFoodEntity(user, world);
            fishFoodEntity.setItem(itemStack);
            fishFoodEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 0.4f, 1.0f);
            world.spawnEntity(fishFoodEntity);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }

}
