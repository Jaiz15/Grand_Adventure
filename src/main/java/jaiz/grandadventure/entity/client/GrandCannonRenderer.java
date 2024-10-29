package jaiz.grandadventure.entity.client;

import jaiz.grandadventure.GrandAdventure;
import jaiz.grandadventure.entity.living_entities.GrandCannonEntity;
import jaiz.grandadventure.entity.living_entities.GrandstoneGuardianEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class GrandCannonRenderer extends MobEntityRenderer<GrandCannonEntity, GrandCannon<GrandCannonEntity>> {
    private static final Identifier TEXTURE = Identifier.of(GrandAdventure.MOD_ID, "textures/entity/grand_cannon.png");

    public GrandCannonRenderer(EntityRendererFactory.Context context) {
        super(context, new GrandCannon<>(context.getPart(ModModelLayers.GRAND_CANNON)), 0.0f);
    }

    @Override
    public Identifier getTexture(GrandCannonEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(GrandCannonEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
