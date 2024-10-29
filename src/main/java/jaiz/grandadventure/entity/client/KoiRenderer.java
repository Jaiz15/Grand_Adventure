package jaiz.grandadventure.entity.client;

import com.google.common.collect.Maps;
import jaiz.grandadventure.GrandAdventure;
import jaiz.grandadventure.entity.living_entities.KoiEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class KoiRenderer extends MobEntityRenderer<KoiEntity, Koi<KoiEntity>> {


    public static final Map<KoiVariant, Identifier> KOI_VARIANT =
            Util.make(Maps.newEnumMap(KoiVariant.class), (map) -> {
                map.put(KoiVariant.KOI_1, Identifier.of(GrandAdventure.MOD_ID, "textures/entity/koi/koi_1.png"));
                map.put(KoiVariant.KOI_2, Identifier.of(GrandAdventure.MOD_ID, "textures/entity/koi/koi_2.png"));
                map.put(KoiVariant.KOI_3, Identifier.of(GrandAdventure.MOD_ID, "textures/entity/koi/koi_3.png"));
                map.put(KoiVariant.KOI_4, Identifier.of(GrandAdventure.MOD_ID, "textures/entity/koi/koi_4.png"));
                map.put(KoiVariant.KOI_5, Identifier.of(GrandAdventure.MOD_ID, "textures/entity/koi/koi_5.png"));
                map.put(KoiVariant.KOI_6, Identifier.of(GrandAdventure.MOD_ID, "textures/entity/koi/koi_6.png"));
                map.put(KoiVariant.KOI_7, Identifier.of(GrandAdventure.MOD_ID, "textures/entity/koi/koi_7.png"));
                map.put(KoiVariant.KOI_8, Identifier.of(GrandAdventure.MOD_ID, "textures/entity/koi/koi_8.png"));
                map.put(KoiVariant.KOI_9, Identifier.of(GrandAdventure.MOD_ID, "textures/entity/koi/koi_9.png"));
                map.put(KoiVariant.KOI_10, Identifier.of(GrandAdventure.MOD_ID, "textures/entity/koi/koi_10.png"));
            });

    public KoiRenderer(EntityRendererFactory.Context context) {
        super(context, new Koi<>(context.getPart(ModModelLayers.KOI)), 0.35f);
    }

    @Override
    public Identifier getTexture(KoiEntity instance) {
        return KOI_VARIANT.get(instance.getVariant());
    }

    @Override
    public void render(KoiEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
