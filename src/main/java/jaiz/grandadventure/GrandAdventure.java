package jaiz.grandadventure;

import jaiz.grandadventure.block.ModBlocks;
import jaiz.grandadventure.block.blockentities.CustomBlockEntities;
import jaiz.grandadventure.block.custom.FloatingLanternBlock;
import jaiz.grandadventure.entity.ModEntities;
import jaiz.grandadventure.entity.living_entities.*;
import jaiz.grandadventure.item.ModItemGroups;
import jaiz.grandadventure.item.ModItems;
import jaiz.grandadventure.item.ModModelPredicateProvider;
import jaiz.grandadventure.sound.ModSounds;
import jaiz.grandadventure.statuseffects.ModStatusEffects;
import jaiz.grandadventure.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GrandAdventure implements ModInitializer {

	public static final String MOD_ID = "grandadventure";
    public static final Logger LOGGER = LoggerFactory.getLogger("grandadventure");

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModSounds.registerSounds();
		ModItems.registerModItems();
		ModWorldGeneration.generateModWorldGen();
		ModItemGroups.registerItemGroups();
		ModStatusEffects.registerModEffects();
		CustomBlockEntities.registerBlockEntities();

		FabricDefaultAttributeRegistry.register(ModEntities.KOI, KoiEntity.createFishAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.GRANDSTONE_MITE, GrandstoneMiteEntity.createGrandstoneAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.GRAND_CANNON, GrandCannonEntity.createGrandstoneAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.GRANDSTONE_GUARDIAN, GrandstoneGuardianEntity.createGrandstoneAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.HOT_AIR_BALLOON, HotAirBalloonEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.FLOATING_LANTERN, FloatingLanternEntity.createMobAttributes());
	}
}