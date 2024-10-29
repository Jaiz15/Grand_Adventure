package jaiz.grandadventure.item;

import net.minecraft.client.item.CompassAnglePredicateProvider;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LodestoneTrackerComponent;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.GlobalPos;

public class ModModelPredicateProvider {

    public static void registerModModels() {

        ModelPredicateProviderRegistry.register(Items.COMPASS, Identifier.of("angle"), new CompassAnglePredicateProvider((world, stack, entity) -> {
            LodestoneTrackerComponent lodestoneTrackerComponent = stack.get(DataComponentTypes.LODESTONE_TRACKER);
            return lodestoneTrackerComponent != null ? lodestoneTrackerComponent.target().orElse(null) : GlobalPos.create(world.getRegistryKey(), entity.getBlockPos().add(0, 0, -64));
        }));
    }
}
