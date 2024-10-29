package jaiz.grandadventure.datagen;


import jaiz.grandadventure.GrandAdventure;
import jaiz.grandadventure.block.ModBlocks;
import jaiz.grandadventure.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.StonecuttingRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;


public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_GRANDSTONE, 4)
                .pattern("RR")
                .pattern("RR")
                .input('R', ModBlocks.GRANDSTONE)
                .criterion(hasItem(ModBlocks.GRANDSTONE), conditionsFromItem(ModBlocks.GRANDSTONE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.SMOOTH_GRANDSTONE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANDSTONE_BRICKS, 4)
                .pattern("RR")
                .pattern("RR")
                .input('R', ModBlocks.SMOOTH_GRANDSTONE)
                .criterion(hasItem(ModBlocks.SMOOTH_GRANDSTONE), conditionsFromItem(ModBlocks.SMOOTH_GRANDSTONE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.GRANDSTONE_BRICKS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_GRANDSTONE, 4)
                .pattern("RR")
                .pattern("RR")
                .input('R', ModBlocks.GRANDSTONE_BRICKS)
                .criterion(hasItem(ModBlocks.GRANDSTONE_BRICKS), conditionsFromItem(ModBlocks.GRANDSTONE_BRICKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.CHISELED_GRANDSTONE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANDSTONE_WALL, 6)
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModBlocks.GRANDSTONE)
                .criterion(hasItem(ModBlocks.GRANDSTONE), conditionsFromItem(ModBlocks.GRANDSTONE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.GRANDSTONE_WALL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANDSTONE_SLAB, 6)
                .pattern("RRR")
                .input('R', ModBlocks.GRANDSTONE)
                .criterion(hasItem(ModBlocks.GRANDSTONE), conditionsFromItem(ModBlocks.GRANDSTONE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.GRANDSTONE_SLAB)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANDSTONE_STAIRS, 4)
                .pattern("R  ")
                .pattern("RR ")
                .pattern("RRR")
                .input('R', ModBlocks.GRANDSTONE)
                .criterion(hasItem(ModBlocks.GRANDSTONE), conditionsFromItem(ModBlocks.GRANDSTONE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.GRANDSTONE_STAIRS)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANDSTONE_BRICK_WALL, 6)
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModBlocks.GRANDSTONE_BRICKS)
                .criterion(hasItem(ModBlocks.GRANDSTONE_BRICKS), conditionsFromItem(ModBlocks.GRANDSTONE_BRICKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.GRANDSTONE_BRICK_WALL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANDSTONE_BRICK_SLAB, 6)
                .pattern("RRR")
                .input('R', ModBlocks.GRANDSTONE_BRICKS)
                .criterion(hasItem(ModBlocks.GRANDSTONE_BRICKS), conditionsFromItem(ModBlocks.GRANDSTONE_BRICKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.GRANDSTONE_BRICK_SLAB)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANDSTONE_BRICK_STAIRS, 4)
                .pattern("R  ")
                .pattern("RR ")
                .pattern("RRR")
                .input('R', ModBlocks.GRANDSTONE_BRICKS)
                .criterion(hasItem(ModBlocks.GRANDSTONE_BRICKS), conditionsFromItem(ModBlocks.GRANDSTONE_BRICKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.GRANDSTONE_BRICK_STAIRS)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FISH_FOOD, 4)
                .input(Items.BONE_MEAL)
                .input(Items.WHEAT_SEEDS)
                .input(Items.CARROT)
                .criterion(hasItem(Items.BONE_MEAL), conditionsFromItem(Items.BONE_MEAL))
                .criterion(hasItem(Items.WHEAT_SEEDS), conditionsFromItem(Items.WHEAT_SEEDS))
                .criterion(hasItem(Items.CARROT), conditionsFromItem(Items.CARROT))
                .offerTo(exporter, Identifier.of(GrandAdventure.MOD_ID, "fish_food_carrot"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FISH_FOOD, 4)
                .input(Items.BONE_MEAL)
                .input(Items.WHEAT_SEEDS)
                .input(Items.BEETROOT)
                .criterion(hasItem(Items.BONE_MEAL), conditionsFromItem(Items.BONE_MEAL))
                .criterion(hasItem(Items.WHEAT_SEEDS), conditionsFromItem(Items.WHEAT_SEEDS))
                .criterion(hasItem(Items.BEETROOT), conditionsFromItem(Items.BEETROOT))
                .offerTo(exporter, Identifier.of(GrandAdventure.MOD_ID, "fish_food_beet"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FISH_FOOD, 4)
                .input(Items.BONE_MEAL)
                .input(Items.WHEAT_SEEDS)
                .input(Items.POTATO)
                .criterion(hasItem(Items.BONE_MEAL), conditionsFromItem(Items.BONE_MEAL))
                .criterion(hasItem(Items.WHEAT_SEEDS), conditionsFromItem(Items.WHEAT_SEEDS))
                .criterion(hasItem(Items.POTATO), conditionsFromItem(Items.POTATO))
                .offerTo(exporter, Identifier.of(GrandAdventure.MOD_ID, "fish_food_potato"));



        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.STACKED_TIRES, 1)
                .input(ModBlocks.TIRE_BLOCK)
                .input(ModBlocks.TIRE_BLOCK)
                .criterion(hasItem(ModBlocks.TIRE_BLOCK), conditionsFromItem(ModBlocks.TIRE_BLOCK))
                .criterion(hasItem(ModBlocks.STACKED_TIRES), conditionsFromItem(ModBlocks.STACKED_TIRES))
                .offerTo(exporter, Identifier.of(GrandAdventure.MOD_ID, "stacked_tires"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ROCK, 4)
                .input(Blocks.COBBLESTONE)
                .criterion(hasItem(Blocks.COBBLESTONE), conditionsFromItem(Blocks.COBBLESTONE))
                .criterion(hasItem(ModItems.ROCK), conditionsFromItem(ModItems.ROCK))
                .offerTo(exporter, Identifier.of(GrandAdventure.MOD_ID, "rock_from_cobble"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TIRE_BLOCK, 8)
                .pattern("RRR")
                .pattern("RLR")
                .pattern("RRR")
                .input('R', Items.BLACK_CONCRETE_POWDER)
                .input('L', Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.BLACK_CONCRETE_POWDER), conditionsFromItem(Items.BLACK_CONCRETE_POWDER))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.TIRE_BLOCK)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HEADLIGHT, 1)
                .pattern("RRR")
                .pattern("RLR")
                .pattern("RRR")
                .input('R', Items.GLOWSTONE_DUST)
                .input('L', Items.IRON_NUGGET)
                .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
                .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.HEADLIGHT)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModItems.FLOATING_LANTERN, 1)
                .pattern("RRR")
                .pattern("R R")
                .pattern("RVR")
                .input('R', Items.PAPER)
                .input('V', Items.CANDLE)
                .criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
                .criterion(hasItem(Items.CANDLE), conditionsFromItem(Items.CANDLE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.FLOATING_LANTERN)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TARP_SHADE, 1)
                .pattern("RRR")
                .pattern("L L")
                .input('R', ModBlocks.TARP)
                .input('L', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.TARP_SHADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModItems.ROPE_LADDER, 6)
                .pattern("L L")
                .pattern("LRL")
                .pattern("L L")
                .input('R', Items.STICK)
                .input('L', Items.STRING)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.ROPE_LADDER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FAIRY_LIGHTS, 4)
                .pattern("RRR")
                .pattern(" L ")
                .input('R', Items.STRING)
                .input('L', Items.GLOWSTONE_DUST)
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FAIRY_LIGHTS)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DYNAMITE, 1)
                .input(Items.PAPER)
                .input(Items.STRING)
                .input(Items.GUNPOWDER)
                .criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
                .criterion(hasItem(ModItems.DYNAMITE), conditionsFromItem(ModItems.DYNAMITE))
                .offerTo(exporter, Identifier.of(GrandAdventure.MOD_ID, "dynamite"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUST, 4)
                .input(Items.IRON_INGOT)
                .input(Items.SLIME_BALL)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.SLIME_BALL), conditionsFromItem(Items.SLIME_BALL))
                .criterion(hasItem(ModItems.RUST), conditionsFromItem(ModItems.RUST))
                .offerTo(exporter, Identifier.of(GrandAdventure.MOD_ID, "rust"));

        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBlocks.GRANDSTONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANDSTONE_BRICKS, 1)
                .criterion(hasItem(ModBlocks.GRANDSTONE), conditionsFromItem(ModBlocks.GRANDSTONE))
                .criterion(hasItem(ModBlocks.GRANDSTONE_BRICKS), conditionsFromItem(ModBlocks.GRANDSTONE_BRICKS))
                .offerTo(exporter, Identifier.of(GrandAdventure.MOD_ID, "grandstone_bricks_from_stone_cutter"));

        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBlocks.GRANDSTONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_GRANDSTONE, 1)
                .criterion(hasItem(ModBlocks.GRANDSTONE), conditionsFromItem(ModBlocks.GRANDSTONE))
                .criterion(hasItem(ModBlocks.SMOOTH_GRANDSTONE), conditionsFromItem(ModBlocks.SMOOTH_GRANDSTONE))
                .offerTo(exporter, Identifier.of(GrandAdventure.MOD_ID, "grandstone_smooth_from_stone_cutter"));

        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBlocks.GRANDSTONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_GRANDSTONE, 1)
                .criterion(hasItem(ModBlocks.GRANDSTONE), conditionsFromItem(ModBlocks.GRANDSTONE))
                .criterion(hasItem(ModBlocks.CHISELED_GRANDSTONE), conditionsFromItem(ModBlocks.CHISELED_GRANDSTONE))
                .offerTo(exporter, Identifier.of(GrandAdventure.MOD_ID, "grandstone_chiseled_from_stone_cutter"));

        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBlocks.GRANDSTONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANDSTONE_WALL, 1)
                .criterion(hasItem(ModBlocks.GRANDSTONE), conditionsFromItem(ModBlocks.GRANDSTONE))
                .criterion(hasItem(ModBlocks.GRANDSTONE_WALL), conditionsFromItem(ModBlocks.GRANDSTONE_WALL))
                .offerTo(exporter, Identifier.of(GrandAdventure.MOD_ID, "grandstone_wall_from_stone_cutter"));

        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBlocks.GRANDSTONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANDSTONE_STAIRS, 1)
                .criterion(hasItem(ModBlocks.GRANDSTONE), conditionsFromItem(ModBlocks.GRANDSTONE))
                .criterion(hasItem(ModBlocks.GRANDSTONE_STAIRS), conditionsFromItem(ModBlocks.GRANDSTONE_STAIRS))
                .offerTo(exporter, Identifier.of(GrandAdventure.MOD_ID, "grandstone_stairs_from_stone_cutter"));

        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBlocks.GRANDSTONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANDSTONE_SLAB, 1)
                .criterion(hasItem(ModBlocks.GRANDSTONE), conditionsFromItem(ModBlocks.GRANDSTONE))
                .criterion(hasItem(ModBlocks.GRANDSTONE_SLAB), conditionsFromItem(ModBlocks.GRANDSTONE_SLAB))
                .offerTo(exporter, Identifier.of(GrandAdventure.MOD_ID, "grandstone_slab_from_stone_cutter"));


        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBlocks.GRANDSTONE_BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANDSTONE_BRICK_WALL, 1)
                .criterion(hasItem(ModBlocks.GRANDSTONE_BRICKS), conditionsFromItem(ModBlocks.GRANDSTONE_BRICKS))
                .criterion(hasItem(ModBlocks.GRANDSTONE_BRICK_WALL), conditionsFromItem(ModBlocks.GRANDSTONE_BRICK_WALL))
                .offerTo(exporter, Identifier.of(GrandAdventure.MOD_ID, "grandstone_brick_wall_from_stone_cutter"));

        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBlocks.GRANDSTONE_BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANDSTONE_BRICK_STAIRS, 1)
                .criterion(hasItem(ModBlocks.GRANDSTONE_BRICKS), conditionsFromItem(ModBlocks.GRANDSTONE_BRICKS))
                .criterion(hasItem(ModBlocks.GRANDSTONE_BRICK_STAIRS), conditionsFromItem(ModBlocks.GRANDSTONE_BRICK_STAIRS))
                .offerTo(exporter, Identifier.of(GrandAdventure.MOD_ID, "grandstone_brick_stairs_from_stone_cutter"));

        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBlocks.GRANDSTONE_BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANDSTONE_BRICK_SLAB, 1)
                .criterion(hasItem(ModBlocks.GRANDSTONE_BRICKS), conditionsFromItem(ModBlocks.GRANDSTONE_BRICKS))
                .criterion(hasItem(ModBlocks.GRANDSTONE_BRICK_SLAB), conditionsFromItem(ModBlocks.GRANDSTONE_BRICK_SLAB))
                .offerTo(exporter, Identifier.of(GrandAdventure.MOD_ID, "grandstone_brick_slab_from_stone_cutter"));

        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBlocks.GRANDSTONE_BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_GRANDSTONE, 1)
                .criterion(hasItem(ModBlocks.GRANDSTONE_BRICKS), conditionsFromItem(ModBlocks.GRANDSTONE_BRICKS))
                .criterion(hasItem(ModBlocks.CHISELED_GRANDSTONE), conditionsFromItem(ModBlocks.CHISELED_GRANDSTONE))
                .offerTo(exporter, Identifier.of(GrandAdventure.MOD_ID, "grandstone_chisled_from_bricks_from_stone_cutter"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModItems.HOT_AIR_BALLOON, 1)
                .pattern("RRR")
                .pattern("RKR")
                .pattern("LOL")
                .input('R', ItemTags.WOOL)
                .input('K', Items.CAMPFIRE)
                .input('L', Items.STRING)
                .input('O', Items.BARREL)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.HOT_AIR_BALLOON)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHINESE_LANTERN, 1)
                .pattern("RRR")
                .pattern("RKR")
                .pattern("RRR")
                .input('R', Items.PAPER)
                .input('K', Items.TORCH)
                .criterion(hasItem(Items.TORCH), conditionsFromItem(Items.TORCH))
                .criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.CHINESE_LANTERN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.SPIKE_TRAP, 1)
                .pattern("LLL")
                .pattern("RKR")
                .pattern("RRR")
                .input('R', Items.COBBLESTONE)
                .input('L', Items.POINTED_DRIPSTONE)
                .input('K', Items.PISTON)
                .criterion(hasItem(Items.POINTED_DRIPSTONE), conditionsFromItem(Items.POINTED_DRIPSTONE))
                .criterion(hasItem(Items.PISTON), conditionsFromItem(Items.PISTON))
                .criterion(hasItem(Items.COBBLESTONE), conditionsFromItem(Items.COBBLESTONE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.SPIKE_TRAP)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TARP, 2)
                .pattern("RR")
                .input('R', ItemTags.WOOL_CARPETS)
                .criterion(hasItem(Items.GREEN_CARPET), conditionsFromItem(Items.GREEN_CARPET))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.TARP)));

    }
}