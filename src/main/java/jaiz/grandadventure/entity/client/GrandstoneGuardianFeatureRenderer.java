package jaiz.grandadventure.entity.client;

import jaiz.grandadventure.GrandAdventure;
import jaiz.grandadventure.entity.living_entities.FloatingLanternEntity;
import jaiz.grandadventure.entity.living_entities.GrandstoneGuardianEntity;
import jaiz.grandadventure.statuseffects.ModStatusEffects;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.util.Identifier;

@Environment(value = EnvType.CLIENT)
public class GrandstoneGuardianFeatureRenderer<T extends GrandstoneGuardianEntity>
        extends EyesFeatureRenderer<T, GrandstoneGuardian<T>> {
    private static final RenderLayer SKIN = RenderLayer.getEyes(Identifier.of(GrandAdventure.MOD_ID, "textures/entity/statues/grandstone_guardian_glow.png"));
    public GrandstoneGuardianFeatureRenderer(FeatureRendererContext<T, GrandstoneGuardian<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderLayer getEyesTexture() {
        return SKIN;
    }

}

