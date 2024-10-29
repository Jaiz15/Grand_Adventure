package jaiz.grandadventure.item;

import jaiz.grandadventure.GrandAdventure;
import jaiz.grandadventure.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup ADVENTURE_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(GrandAdventure.MOD_ID, "grandadventure"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.grandadventure"))
                    .icon(() -> new ItemStack(ModBlocks.GRANDSTONE)).entries((displayContext, entries) -> {
                        // things go here
                        entries.add(ModItems.ROCK);
                        entries.add(ModItems.DYNAMITE);
                        entries.add(ModItems.MARACA);
                        entries.add(ModItems.DRUM);
                        entries.add(ModItems.GUITAR);
                        entries.add(ModItems.FISH_FOOD);
                        entries.add(ModItems.KOI_BUCKET);
                        entries.add(ModItems.KOI_SPAWN_EGG);
                        entries.add(ModItems.GRANDSTONE_GUARDIAN_SPAWN_EGG);
                        entries.add(ModItems.GRAND_CANNON_SPAWN_EGG);
                        entries.add(ModItems.GRANDSTONE_MITE_SPAWN_EGG);
                        entries.add(ModItems.FLOATING_LANTERN);
                        entries.add(ModItems.HOT_AIR_BALLOON);
                        entries.add(ModBlocks.GRANDSTONE);
                        entries.add(ModBlocks.GRANDSTONE_WALL);
                        entries.add(ModBlocks.GRANDSTONE_STAIRS);
                        entries.add(ModBlocks.GRANDSTONE_SLAB);
                        entries.add(ModBlocks.GRANDSTONE_BRICKS);
                        entries.add(ModBlocks.GRANDSTONE_BRICK_SLAB);
                        entries.add(ModBlocks.GRANDSTONE_BRICK_STAIRS);
                        entries.add(ModBlocks.GRANDSTONE_BRICK_WALL);
                        entries.add(ModBlocks.SMOOTH_GRANDSTONE);
                        entries.add(ModBlocks.CHISELED_GRANDSTONE);
                        entries.add(ModBlocks.TARP_SHADE);
                        entries.add(ModBlocks.TARP);
                        entries.add(ModBlocks.SPIKE_TRAP);
                        entries.add(ModBlocks.TIRE_BLOCK);
                        entries.add(ModBlocks.GROWTH_MOSS);
                        entries.add(ModBlocks.RUST);
                        entries.add(ModItems.ROPE_LADDER);
                        entries.add(ModItems.DUCKWEED);
                        entries.add(ModBlocks.WILD_WHEAT);
                        entries.add(ModBlocks.STACKED_TIRES);
                        entries.add(ModBlocks.HEADLIGHT);
                        entries.add(ModBlocks.FAIRY_LIGHTS);
                        entries.add(ModBlocks.CHINESE_LANTERN);
                        entries.add(ModItems.BH_HAT);
                        entries.add(ModItems.MUSIC_DISC_SLUM_SPACE);
                        entries.add(ModItems.MUSIC_DISC_POOLS_OF_LIFE);
                        entries.add(ModItems.MUSIC_DISC_SURVIVORS_MELODY);
                        entries.add(ModItems.MUSIC_DISC_INDUSTRIAL_DEVOLUTION);
                        entries.add(ModBlocks.TOTEM_CHAMBER);
                        entries.add(ModItems.TOTEM_OF_CREATION);

                    }).build());

    public static void registerItemGroups() {
        GrandAdventure.LOGGER.info("Registering Item Groups");
    }
}
