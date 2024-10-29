package jaiz.grandadventure.entity.client;

import jaiz.grandadventure.GrandAdventure;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer GRANDSTONE_GUARDIAN =
            new EntityModelLayer(Identifier.of(GrandAdventure.MOD_ID, "grandstone_guardian"), "main");

    public static final EntityModelLayer GRANDSTONE_MITE =
            new EntityModelLayer(Identifier.of(GrandAdventure.MOD_ID, "grandstone_mite"), "main");

    public static final EntityModelLayer GRAND_CANNON =
            new EntityModelLayer(Identifier.of(GrandAdventure.MOD_ID, "grand_cannon"), "main");

    public static final EntityModelLayer KOI =
            new EntityModelLayer(Identifier.of(GrandAdventure.MOD_ID, "koi"), "main");

    public static final EntityModelLayer FLOATING_LANTERN =
            new EntityModelLayer(Identifier.of(GrandAdventure.MOD_ID, "floating_lantern"), "main");

    public static final EntityModelLayer HOT_AIR_BALLOON =
            new EntityModelLayer(Identifier.of(GrandAdventure.MOD_ID, "hot_air_balloon"), "main");

}
