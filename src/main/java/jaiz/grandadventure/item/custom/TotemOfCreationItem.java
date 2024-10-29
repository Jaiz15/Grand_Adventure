package jaiz.grandadventure.item.custom;

import jaiz.grandadventure.statuseffects.ModStatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.GameMode;
import net.minecraft.world.World;

import static net.minecraft.entity.projectile.AbstractWindChargeEntity.EXPLOSION_BEHAVIOR;

public class TotemOfCreationItem extends Item {
    public TotemOfCreationItem(Settings settings) {
        super(settings);

    }
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {

            user.getWorld()
                    .createExplosion(
                            user,
                            null,
                            EXPLOSION_BEHAVIOR,
                            user.getX(),
                            user.getY(),
                            user.getZ(),
                            20.0F,
                            false,
                            World.ExplosionSourceType.TRIGGER,
                            ParticleTypes.GUST_EMITTER_SMALL,
                            ParticleTypes.GUST_EMITTER_LARGE,
                            SoundEvents.ENTITY_WIND_CHARGE_WIND_BURST
                    );
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 170, 3, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 280, 1, false, false));
            user.addStatusEffect(new StatusEffectInstance(ModStatusEffects.GODS_GRACE, 160, 0, false, false));
            user.addVelocity(0, 0.2, 0.1);

            ServerPlayerEntity player = (ServerPlayerEntity)world.getClosestPlayer(user.getX(), user.getY() + 5.0, user.getZ(), 10.0, EntityPredicates.VALID_ENTITY);
            assert player != null;

            if (!player.isCreative()) {
                player.changeGameMode(GameMode.CREATIVE);
            }

            world.playSound(null, user.getX(), user.getY() + 0.5f, user.getZ(), SoundEvents.ITEM_TOTEM_USE, SoundCategory.PLAYERS, 15.0f, 0.5f);
            user.getStackInHand(Hand.MAIN_HAND).decrement(1);


        }
        return super.use(world, user, hand);
    }
}
