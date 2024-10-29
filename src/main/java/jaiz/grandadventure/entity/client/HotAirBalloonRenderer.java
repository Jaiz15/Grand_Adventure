package jaiz.grandadventure.entity.client;

import com.google.common.collect.Maps;
import jaiz.grandadventure.GrandAdventure;
import jaiz.grandadventure.entity.living_entities.HotAirBalloonEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class HotAirBalloonRenderer extends MobEntityRenderer<HotAirBalloonEntity, HotAirBalloon<HotAirBalloonEntity>> {


    public static final Map<HotAirBalloonVariant, Identifier> HOT_AIR_VARIANT =
            Util.make(Maps.newEnumMap(HotAirBalloonVariant.class), (map) -> {
                map.put(HotAirBalloonVariant.RED, Identifier.of(GrandAdventure.MOD_ID, "textures/entity/hot_air_balloon/hot_air_balloon_1.png"));
                map.put(HotAirBalloonVariant.PURPLE, Identifier.of(GrandAdventure.MOD_ID, "textures/entity/hot_air_balloon/hot_air_balloon_2.png"));
                map.put(HotAirBalloonVariant.BLUE, Identifier.of(GrandAdventure.MOD_ID, "textures/entity/hot_air_balloon/hot_air_balloon_3.png"));
                map.put(HotAirBalloonVariant.GREEN, Identifier.of(GrandAdventure.MOD_ID, "textures/entity/hot_air_balloon/hot_air_balloon_4.png"));
                map.put(HotAirBalloonVariant.ORANGE, Identifier.of(GrandAdventure.MOD_ID, "textures/entity/hot_air_balloon/hot_air_balloon_5.png"));
                map.put(HotAirBalloonVariant.PINK, Identifier.of(GrandAdventure.MOD_ID, "textures/entity/hot_air_balloon/hot_air_balloon_6.png"));
            });

    public HotAirBalloonRenderer(EntityRendererFactory.Context context) {
        super(context, new HotAirBalloon<>(context.getPart(ModModelLayers.HOT_AIR_BALLOON)), 0.35f);
    }

    @Override
    public Identifier getTexture(HotAirBalloonEntity instance) {
        return HOT_AIR_VARIANT.get(instance.getVariant());
    }

    @Override
    public void render(HotAirBalloonEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
