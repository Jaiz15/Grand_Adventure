package jaiz.grandadventure.block;

import com.mojang.serialization.MapCodec;
import jaiz.grandadventure.GrandAdventure;
import jaiz.grandadventure.block.blockentities.TotemChamberBlock;
import jaiz.grandadventure.block.custom.*;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final IntProperty STAB = IntProperty.of("stab", 0, 1);

    public static final Block GRANDSTONE = registerBlock("grandstone",
            new Block(AbstractBlock.Settings.copy(Blocks.SANDSTONE).requiresTool()));

    public static final TotemChamberBlock TOTEM_CHAMBER = (TotemChamberBlock) registerBlock("totem_chamber",
            new TotemChamberBlock(AbstractBlock.Settings.create().luminance(state -> 10).strength(2.0f).sounds(BlockSoundGroup.HEAVY_CORE).nonOpaque()));

    public static final Block SPIKE_TRAP = registerBlock("spike_trap",
            new SpikeTrapBlock(AbstractBlock.Settings.copy(Blocks.STONE).requiresTool().ticksRandomly().nonOpaque()));

    public static final Block GROWTH_MOSS = registerBlock("growth_moss",
            new GlowLichenBlock(AbstractBlock.Settings.copy(Blocks.VINE).nonOpaque()));

    public static final Block ROPE_LADDER = registerBlockWithCustomItem("rope_ladder",
            new ThinPillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque().noCollision()));

    public static final Block RUST = registerBlockWithCustomItem("rust",
            new GlowLichenBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque().breakInstantly().noCollision().sounds(BlockSoundGroup.METAL)));

    public static final Block FAIRY_LIGHTS = registerBlock("fairy_lights",
            new PaneBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).luminance(state -> 15).strength(0.2f)));

    public static final Block CHINESE_LANTERN = registerBlock("chinese_lantern",
            new ChineseLanternBlock(AbstractBlock.Settings.copy(Blocks.HAY_BLOCK).luminance(state -> 15).sounds(BlockSoundGroup.LANTERN)));

    public static final Block TARP_SHADE = registerBlock("tarp_shade",
            new TarpShadeBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()));

    public static final Block TARP = registerBlock("tarp",
            new CarpetBlock(AbstractBlock.Settings.copy(Blocks.GREEN_CARPET).nonOpaque()));

    public static final Block TARP_BLOCK = registerBlock("tarp_block",
            new Block(AbstractBlock.Settings.copy(Blocks.GREEN_WOOL).nonOpaque()));

    public static final Block HEADLIGHT = registerBlock("headlight",
            new MultifaceGrowthBlock(AbstractBlock.Settings.copy(Blocks.GLOWSTONE).nonOpaque()) {
                @Override
                protected MapCodec<? extends MultifaceGrowthBlock> getCodec() {
                    return null;
                }

                @Override
                public LichenGrower getGrower() {
                    return null;
                }
            });

    public static final Block FLOATING_LANTERN_BLOCK = registerBlockWithCustomItem("floating_lantern",
            new FloatingLanternBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()
                    .sounds(BlockSoundGroup.LANTERN)
                    .breakInstantly().luminance(state -> 15).nonOpaque()));


    public static final Block TIRE_BLOCK = registerBlock("tire_block",
            new TireBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).nonOpaque().sounds(BlockSoundGroup.STONE)));

    public static final Block STACKED_TIRES = registerBlock("stacked_tires",
            new BouncyPillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).sounds(BlockSoundGroup.STONE)));

    public static final Block CHISELED_GRANDSTONE = registerBlock("chiseled_grandstone",
            new Block(AbstractBlock.Settings.copy(Blocks.SANDSTONE).requiresTool()));

    public static final Block GRANDSTONE_BRICKS = registerBlock("grandstone_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.SANDSTONE).requiresTool()));

    public static final Block SMOOTH_GRANDSTONE = registerBlock("smooth_grandstone",
            new Block(AbstractBlock.Settings.copy(Blocks.SANDSTONE).requiresTool()));

    public static final BlockFamily GRANDSTONE_FAMILY = BlockFamilies.register(ModBlocks.GRANDSTONE)
            .group("grandstone").build();

    public static final Block WILD_WHEAT = registerBlock("wild_wheat",
            new TallFlowerBlock(AbstractBlock.Settings.create().mapColor(MapColor.GOLD).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).burnable().pistonBehavior(PistonBehavior.DESTROY)));


    public static final Block GRANDSTONE_STAIRS = registerBlock("grandstone_stairs",
            new StairsBlock(ModBlocks.GRANDSTONE.getDefaultState(), AbstractBlock.Settings.copy(Blocks.STONE_BRICK_STAIRS).requiresTool()));

    public static final Block GRANDSTONE_SLAB = registerBlock("grandstone_slab",
            new SlabBlock(AbstractBlock.Settings.copy(ModBlocks.GRANDSTONE).requiresTool()));

    public static final Block GRANDSTONE_WALL= registerBlock("grandstone_wall",
            new WallBlock(AbstractBlock.Settings.copy(ModBlocks.GRANDSTONE).requiresTool()));



    public static final BlockFamily GRANDSTONE_BRICK_FAMILY = BlockFamilies.register(ModBlocks.GRANDSTONE_BRICKS)
            .group("grandstone_brick").build();

    public static final Block GRANDSTONE_BRICK_STAIRS = registerBlock("grandstone_brick_stairs",
            new StairsBlock(ModBlocks.GRANDSTONE_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.STONE_BRICK_STAIRS).requiresTool()));

    public static final Block GRANDSTONE_BRICK_SLAB = registerBlock("grandstone_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(ModBlocks.GRANDSTONE_BRICKS).requiresTool()));

    public static final Block GRANDSTONE_BRICK_WALL= registerBlock("grandstone_brick_wall",
            new WallBlock(AbstractBlock.Settings.copy(ModBlocks.GRANDSTONE_BRICKS).requiresTool()));

    public static final Block DUCKWEED = registerBlockWithCustomItem("duckweed",
            new DuckweedBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .breakInstantly()
                    .sounds(BlockSoundGroup.LILY_PAD)
                    .nonOpaque()
                    .noCollision()
                    .pistonBehavior(PistonBehavior.DESTROY)));



    //Main Bits

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(GrandAdventure.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(GrandAdventure.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static Block registerBlockWithCustomItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(GrandAdventure.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        GrandAdventure.LOGGER.info("Registering ModBlocks for " + GrandAdventure.MOD_ID);
    }

}
