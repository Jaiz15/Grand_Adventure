package jaiz.grandadventure.entity.client;

import jaiz.grandadventure.GrandAdventure;
import jaiz.grandadventure.entity.living_entities.GrandstoneGuardianEntity;
import jaiz.grandadventure.entity.living_entities.GrandstoneMiteEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.util.Identifier;

@Environment(value = EnvType.CLIENT)
public class GrandstoneMiteFeatureRenderer<T extends GrandstoneMiteEntity>
        extends EyesFeatureRenderer<T, GrandstoneMite<T>> {
    private static final RenderLayer SKIN = RenderLayer.getEyes(Identifier.of(GrandAdventure.MOD_ID, "textures/entity/grandstone_mite_glow.png"));
    public GrandstoneMiteFeatureRenderer(FeatureRendererContext<T, GrandstoneMite<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderLayer getEyesTexture() {
        return SKIN;
    }

}

