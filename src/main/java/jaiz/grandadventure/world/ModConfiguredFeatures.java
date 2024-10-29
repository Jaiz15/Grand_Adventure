package jaiz.grandadventure.world;

import jaiz.grandadventure.GrandAdventure;
import jaiz.grandadventure.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> GRANDSTONE_ORE_KEY = registerKey("grandstone_ore");

    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest overworldReplacables = new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD);
        List<OreFeatureConfig.Target> grandstoneOres =
                List.of(OreFeatureConfig.createTarget(overworldReplacables, ModBlocks.GRANDSTONE.getDefaultState()));
        register(context, GRANDSTONE_ORE_KEY, Feature.ORE, new OreFeatureConfig(grandstoneOres, 32));

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(GrandAdventure.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
