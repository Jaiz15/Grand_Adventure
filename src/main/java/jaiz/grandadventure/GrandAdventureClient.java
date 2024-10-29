package jaiz.grandadventure;

import jaiz.grandadventure.block.ModBlocks;
import jaiz.grandadventure.entity.ModEntities;
import jaiz.grandadventure.entity.client.*;
import jaiz.grandadventure.entity.living_entities.GrandstoneGuardianEntity;
import jaiz.grandadventure.item.ModModelPredicateProvider;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class GrandAdventureClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {

		EntityRendererRegistry.register(ModEntities.ROCK, FlyingItemEntityRenderer::new);
		EntityRendererRegistry.register(ModEntities.DYNAMITE, FlyingItemEntityRenderer::new);
		EntityRendererRegistry.register(ModEntities.FISH_FOOD, FlyingItemEntityRenderer::new);

		ModModelPredicateProvider.registerModModels();

		EntityRendererRegistry.register(ModEntities.KOI, KoiRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.KOI, Koi::getTexturedModelData);

		EntityRendererRegistry.register(ModEntities.GRANDSTONE_GUARDIAN, GrandstoneGuardianRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.GRANDSTONE_GUARDIAN, GrandstoneGuardian::getTexturedModelData);

		EntityRendererRegistry.register(ModEntities.GRANDSTONE_MITE, GrandstoneMiteRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.GRANDSTONE_MITE, GrandstoneMite::getTexturedModelData);

		EntityRendererRegistry.register(ModEntities.FLOATING_LANTERN, FloatingLanternRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.FLOATING_LANTERN, FloatingLantern::getTexturedModelData);

		EntityRendererRegistry.register(ModEntities.HOT_AIR_BALLOON, HotAirBalloonRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.HOT_AIR_BALLOON, HotAirBalloon::getTexturedModelData);

		EntityRendererRegistry.register(ModEntities.GRAND_CANNON, GrandCannonRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.GRAND_CANNON, GrandCannon::getTexturedModelData);

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FLOATING_LANTERN_BLOCK, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FAIRY_LIGHTS, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHINESE_LANTERN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILD_WHEAT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TARP_SHADE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SPIKE_TRAP, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TIRE_BLOCK, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TOTEM_CHAMBER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HEADLIGHT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GROWTH_MOSS, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DUCKWEED, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUST, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ROPE_LADDER, RenderLayer.getTranslucent());
	}
}