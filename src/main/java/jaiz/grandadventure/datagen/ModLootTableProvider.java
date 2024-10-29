package jaiz.grandadventure.datagen;

import jaiz.grandadventure.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {


    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {

        addDrop(ModBlocks.GRANDSTONE);
        addDrop(ModBlocks.SMOOTH_GRANDSTONE);
        addDrop(ModBlocks.CHISELED_GRANDSTONE);
        addDrop(ModBlocks.GRANDSTONE_BRICKS);
        addDrop(ModBlocks.GRANDSTONE_SLAB);
        addDrop(ModBlocks.GRANDSTONE_BRICK_SLAB);
        addDrop(ModBlocks.GRANDSTONE_WALL);
        addDrop(ModBlocks.GRANDSTONE_BRICK_WALL);
        addDrop(ModBlocks.GRANDSTONE_STAIRS);
        addDrop(ModBlocks.GRANDSTONE_BRICK_STAIRS);

        addDrop(ModBlocks.TARP);
        addDrop(ModBlocks.FAIRY_LIGHTS);
        addDrop(ModBlocks.FLOATING_LANTERN_BLOCK);
        addDrop(ModBlocks.CHINESE_LANTERN);
        addDrop(ModBlocks.TARP_SHADE);
        addDrop(ModBlocks.HEADLIGHT);
        addDrop(ModBlocks.TIRE_BLOCK);
        addDrop(ModBlocks.STACKED_TIRES);
        addDrop(ModBlocks.DUCKWEED);
        addDrop(ModBlocks.SPIKE_TRAP);
        addDrop(ModBlocks.RUST);
        addDrop(ModBlocks.ROPE_LADDER);

        addDrop(ModBlocks.GROWTH_MOSS, dropsWithShears(ModBlocks.GROWTH_MOSS));
















    }
}
