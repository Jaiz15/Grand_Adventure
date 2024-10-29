package jaiz.grandadventure.item;

import jaiz.grandadventure.GrandAdventure;
import jaiz.grandadventure.block.ModBlocks;
import jaiz.grandadventure.block.custom.HatBlock;
import jaiz.grandadventure.entity.ModEntities;
import jaiz.grandadventure.item.custom.*;
import jaiz.grandadventure.sound.ModSounds;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.world.gen.structure.Structure;

import static jaiz.grandadventure.block.ModBlocks.registerBlock;
import static net.minecraft.item.Items.register;

public class ModItems {

    TagKey<Structure> ON_ANCIENT_CASTLE_MAPS = of("ancient_castle");

    private static TagKey<Structure> of(String id) {
        return TagKey.of(RegistryKeys.STRUCTURE, Identifier.ofVanilla(id));
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(GrandAdventure.MOD_ID, name), item);
    }

    public static final Item KOI_SPAWN_EGG = registerItem("koi_spawn_egg", new SpawnEggItem(ModEntities.KOI,
            0xf5edd1, 0xec5905, new Item.Settings()));

    public static final Item GRANDSTONE_GUARDIAN_SPAWN_EGG = registerItem("grandstone_guardian_spawn_egg", new SpawnEggItem(ModEntities.GRANDSTONE_GUARDIAN,
            0xeddcce, 0xa78a7d, new Item.Settings()));

    public static final Item GRAND_CANNON_SPAWN_EGG = registerItem("grand_cannon_spawn_egg", new SpawnEggItem(ModEntities.GRAND_CANNON,
            0xeddcca, 0xa78a7a, new Item.Settings()));

    public static final Item GRANDSTONE_MITE_SPAWN_EGG = registerItem("grandstone_mite_spawn_egg", new SpawnEggItem(ModEntities.GRANDSTONE_MITE,
            0xaddcca, 0xc78b7a, new Item.Settings()));



    public static final Item HOT_AIR_BALLOON = registerItem("hot_air_balloon", new SpawnEggItem(ModEntities.HOT_AIR_BALLOON,
            0xFFFFFF, 0xFFFFFF, new Item.Settings()));

    public static final Item KOI_BUCKET = registerItem(
            "koi_bucket",
            new EntityBucketItem(
                    ModEntities.KOI,
                    Fluids.WATER,
                    SoundEvents.ITEM_BUCKET_EMPTY_FISH,
                    new Item.Settings().maxCount(1).component(DataComponentTypes.BUCKET_ENTITY_DATA, NbtComponent.DEFAULT)
            )
    );

    public static final Item BH_HAT = registerItem(
            "bh_adventure_hat",
            new HatBlock(new Item.Settings())
    );

    public static final Item DUCKWEED = register(new PlaceableOnWaterItem(ModBlocks.DUCKWEED, new Item.Settings()));

    public static final Item RUST = register(new BlockItem(ModBlocks.RUST, new Item.Settings()));

    public static final Item ROPE_LADDER = register(new BlockItem(ModBlocks.ROPE_LADDER, new Item.Settings()));

    public static final Item MUSIC_DISC_POOLS_OF_LIFE = registerItem("music_disc_pools_of_life", new Item(new Item.Settings().jukeboxPlayable(ModSounds.of("pools_of_life")).rarity(Rarity.RARE).maxCount(1)));

    public static final Item MUSIC_DISC_SLUM_SPACE = registerItem("music_disc_slum_space", new Item(new Item.Settings().jukeboxPlayable(ModSounds.of("slum_space")).rarity(Rarity.RARE).maxCount(1)));

    public static final Item MUSIC_DISC_SURVIVORS_MELODY = registerItem("music_disc_survivors_melody", new Item(new Item.Settings().jukeboxPlayable(ModSounds.of("survivors_melody")).rarity(Rarity.RARE).maxCount(1)));

    public static final Item MUSIC_DISC_INDUSTRIAL_DEVOLUTION = registerItem("music_disc_industrial_devolution", new Item(new Item.Settings().jukeboxPlayable(ModSounds.of("industrial_devolution")).rarity(Rarity.RARE).maxCount(1)));


    public static final Item FLOATING_LANTERN = register(new PlaceableOnWaterItem(ModBlocks.FLOATING_LANTERN_BLOCK, new Item.Settings()));



    public static final Item TOTEM_OF_CREATION = registerItem("totem_of_creation", new TotemOfCreationItem(new Item.Settings().maxCount(1).rarity(Rarity.EPIC).fireproof()));

    public static final Item DRUM = registerItem("drum", new DrumItem(new Item.Settings()));
    public static final Item MARACA = registerItem("maraca", new MaracaItem(new Item.Settings()));
    public static final Item GUITAR = registerItem("guitar", new GuitarItem(new Item.Settings()));

    public static final Item DYNAMITE = registerItem("dynamite", new DynamiteItem(new Item.Settings()));
    public static final Item ROCK = registerItem("rock", new ThrownRockItem(new Item.Settings()));
    public static final Item FISH_FOOD = registerItem("fish_food", new FishFoodItem(new Item.Settings()));

    public static void registerModItems() {
        GrandAdventure.LOGGER.info("Registering Mod Items for " + GrandAdventure.MOD_ID);
    }

}
