package jaiz.grandadventure.datagen;

import jaiz.grandadventure.block.ModBlocks;
import jaiz.grandadventure.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) { super(output);}

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {


        BlockStateModelGenerator.BlockTexturePool grandstone_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GRANDSTONE);
        grandstone_pool.family(ModBlocks.GRANDSTONE_FAMILY);
        grandstone_pool.stairs(ModBlocks.GRANDSTONE_STAIRS);
        grandstone_pool.slab(ModBlocks.GRANDSTONE_SLAB);
        grandstone_pool.wall(ModBlocks.GRANDSTONE_WALL);

        blockStateModelGenerator.registerDoubleBlock(ModBlocks.WILD_WHEAT, BlockStateModelGenerator.TintType.NOT_TINTED);

        BlockStateModelGenerator.BlockTexturePool grandstone_bricks_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GRANDSTONE_BRICKS);
        grandstone_bricks_pool.family(ModBlocks.GRANDSTONE_BRICK_FAMILY);
        grandstone_bricks_pool.stairs(ModBlocks.GRANDSTONE_BRICK_STAIRS);
        grandstone_bricks_pool.slab(ModBlocks.GRANDSTONE_BRICK_SLAB);
        grandstone_bricks_pool.wall(ModBlocks.GRANDSTONE_BRICK_WALL);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_GRANDSTONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SMOOTH_GRANDSTONE);

        blockStateModelGenerator.registerTintableCross(ModBlocks.ROPE_LADDER, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerWallPlant(ModBlocks.GROWTH_MOSS);

        blockStateModelGenerator.registerWoolAndCarpet(ModBlocks.TARP_BLOCK, ModBlocks.TARP);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.KOI_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.GRANDSTONE_GUARDIAN_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.GRAND_CANNON_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.GRANDSTONE_MITE_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));

        itemModelGenerator.register(ModItems.ROCK, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.FISH_FOOD, Models.GENERATED);
        itemModelGenerator.register(ModItems.HOT_AIR_BALLOON, Models.GENERATED);
        itemModelGenerator.register(ModItems.KOI_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.DYNAMITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOTEM_OF_CREATION, Models.GENERATED);
        itemModelGenerator.register(ModItems.MUSIC_DISC_SLUM_SPACE, Models.GENERATED);
        itemModelGenerator.register(ModItems.MUSIC_DISC_POOLS_OF_LIFE, Models.GENERATED);
        itemModelGenerator.register(ModItems.MUSIC_DISC_SURVIVORS_MELODY, Models.GENERATED);
        itemModelGenerator.register(ModItems.MUSIC_DISC_INDUSTRIAL_DEVOLUTION, Models.GENERATED);
    }
}
