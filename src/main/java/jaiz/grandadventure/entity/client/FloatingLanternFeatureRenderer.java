package jaiz.grandadventure.entity.client;

import jaiz.grandadventure.GrandAdventure;
import jaiz.grandadventure.entity.living_entities.FloatingLanternEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.util.Identifier;

@Environment(value = EnvType.CLIENT)
public class FloatingLanternFeatureRenderer<T extends FloatingLanternEntity>
        extends EyesFeatureRenderer<T, FloatingLantern<T>> {
    private static final RenderLayer SKIN = RenderLayer.getEyes(Identifier.of(GrandAdventure.MOD_ID, "textures/block/floatinglantern_lit_opacity.png"));

    public FloatingLanternFeatureRenderer(FeatureRendererContext<T, FloatingLantern<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderLayer getEyesTexture() {
        return SKIN;
    }
}

