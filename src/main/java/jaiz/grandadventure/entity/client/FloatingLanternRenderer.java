package jaiz.grandadventure.entity.client;

import jaiz.grandadventure.GrandAdventure;
import jaiz.grandadventure.entity.living_entities.FloatingLanternEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class FloatingLanternRenderer extends MobEntityRenderer<FloatingLanternEntity, FloatingLantern<FloatingLanternEntity>> {
    private static final Identifier TEXTURE = Identifier.of(GrandAdventure.MOD_ID, "textures/block/floatinglantern_lit_opacity.png");

    public FloatingLanternRenderer(EntityRendererFactory.Context context) {
        super(context, new FloatingLantern<>(context.getPart(ModModelLayers.FLOATING_LANTERN)), 0.3f);
        this.addFeature(new FloatingLanternFeatureRenderer<>(this));
    }

    @Override
    public Identifier getTexture(FloatingLanternEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(FloatingLanternEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
