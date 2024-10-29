package jaiz.grandadventure.entity.client;

import jaiz.grandadventure.GrandAdventure;
import jaiz.grandadventure.entity.living_entities.FloatingLanternEntity;
import jaiz.grandadventure.entity.living_entities.GrandstoneGuardianEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class GrandstoneGuardianRenderer extends MobEntityRenderer<GrandstoneGuardianEntity, GrandstoneGuardian<GrandstoneGuardianEntity>> {
    private static final Identifier TEXTURE = Identifier.of(GrandAdventure.MOD_ID, "textures/entity/statues/grandstone_guardian.png");

    public GrandstoneGuardianRenderer(EntityRendererFactory.Context context) {
        super(context, new GrandstoneGuardian<>(context.getPart(ModModelLayers.GRANDSTONE_GUARDIAN)), 0.0f);
        this.addFeature(new GrandstoneGuardianFeatureRenderer<>(this));
    }

    @Override
    public Identifier getTexture(GrandstoneGuardianEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(GrandstoneGuardianEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
