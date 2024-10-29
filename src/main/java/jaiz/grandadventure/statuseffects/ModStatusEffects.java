package jaiz.grandadventure.statuseffects;

import jaiz.grandadventure.GrandAdventure;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModStatusEffects {

    public static RegistryEntry.Reference<StatusEffect> CALMING;
    public static RegistryEntry.Reference<StatusEffect> GODS_GRACE;


    public static RegistryEntry.Reference<StatusEffect> registerCalmingStatusEffect(String name) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(GrandAdventure.MOD_ID, name),
                new CalmingStatusEffect(StatusEffectCategory.NEUTRAL, 9740385));
    }

    public static RegistryEntry.Reference<StatusEffect> registerGraceStatusEffect(String name) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(GrandAdventure.MOD_ID, name),
                new GodsGraceStatusEffect(StatusEffectCategory.BENEFICIAL, 9740385));
    }


    public static void registerModEffects() {
        CALMING = registerCalmingStatusEffect("calming");
        GODS_GRACE = registerGraceStatusEffect("gods_grace");
        GrandAdventure.LOGGER.info("Registering Mod Effects for " + GrandAdventure.MOD_ID);
    }
}
