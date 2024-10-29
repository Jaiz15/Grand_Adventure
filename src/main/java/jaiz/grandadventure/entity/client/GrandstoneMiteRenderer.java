package jaiz.grandadventure.entity.client;

import jaiz.grandadventure.GrandAdventure;
import jaiz.grandadventure.entity.living_entities.FloatingLanternEntity;
import jaiz.grandadventure.entity.living_entities.GrandstoneGuardianEntity;
import jaiz.grandadventure.entity.living_entities.GrandstoneMiteEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class GrandstoneMiteRenderer extends MobEntityRenderer<GrandstoneMiteEntity, GrandstoneMite<GrandstoneMiteEntity>> {
    private static final Identifier TEXTURE = Identifier.of(GrandAdventure.MOD_ID, "textures/entity/grandstone_mite.png");

    public GrandstoneMiteRenderer(EntityRendererFactory.Context context) {
        super(context, new GrandstoneMite<>(context.getPart(ModModelLayers.GRANDSTONE_MITE)), 0.0f);
        this.addFeature(new GrandstoneMiteFeatureRenderer<>(this));
    }

    @Override
    public Identifier getTexture(GrandstoneMiteEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(GrandstoneMiteEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
