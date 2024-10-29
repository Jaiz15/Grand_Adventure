package jaiz.grandadventure.datagen;

import jaiz.grandadventure.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.GRANDSTONE)
                .add(ModBlocks.GRANDSTONE_BRICKS)
                .add(ModBlocks.CHISELED_GRANDSTONE)
                .add(ModBlocks.SMOOTH_GRANDSTONE)
                .add(ModBlocks.GRANDSTONE_SLAB)
                .add(ModBlocks.GRANDSTONE_BRICK_SLAB)
                .add(ModBlocks.GRANDSTONE_BRICK_STAIRS)
                .add(ModBlocks.GRANDSTONE_BRICK_WALL)
                .add(ModBlocks.GRANDSTONE_WALL)
                .add(ModBlocks.GRANDSTONE_STAIRS)
                .add(ModBlocks.SPIKE_TRAP);

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModBlocks.GRANDSTONE_BRICK_SLAB)
                .add(ModBlocks.GRANDSTONE_SLAB);


        getOrCreateTagBuilder(BlockTags.TALL_FLOWERS)
                .add(ModBlocks.WILD_WHEAT);

        getOrCreateTagBuilder(BlockTags.REPLACEABLE)
                .add(ModBlocks.WILD_WHEAT);

        getOrCreateTagBuilder(BlockTags.CLIMBABLE)
                .add(ModBlocks.ROPE_LADDER)
                .add(Blocks.OAK_TRAPDOOR)
                .add(Blocks.BIRCH_TRAPDOOR)
                .add(Blocks.CHERRY_TRAPDOOR)
                .add(Blocks.DARK_OAK_TRAPDOOR)
                .add(Blocks.MANGROVE_TRAPDOOR)
                .add(Blocks.WARPED_TRAPDOOR)
                .add(Blocks.CRIMSON_TRAPDOOR)
                .add(Blocks.ACACIA_TRAPDOOR)
                .add(Blocks.COPPER_TRAPDOOR)
                .add(Blocks.EXPOSED_COPPER_TRAPDOOR)
                .add(Blocks.OXIDIZED_COPPER_TRAPDOOR)
                .add(Blocks.WEATHERED_COPPER_TRAPDOOR)
                .add(Blocks.COPPER_TRAPDOOR)
                .add(Blocks.WAXED_EXPOSED_COPPER_TRAPDOOR)
                .add(Blocks.WAXED_OXIDIZED_COPPER_TRAPDOOR)
                .add(Blocks.WAXED_WEATHERED_COPPER_TRAPDOOR)
                .add(Blocks.SPRUCE_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.STONE_BRICKS)
                .add(ModBlocks.GRANDSTONE_BRICKS);

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.GRANDSTONE_BRICK_STAIRS)
                .add(ModBlocks.GRANDSTONE_STAIRS);

        getOrCreateTagBuilder(BlockTags.WOOL_CARPETS)
                .add(ModBlocks.TARP);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.GRANDSTONE_BRICK_WALL)
                .add(ModBlocks.GRANDSTONE_WALL);








    }
}
