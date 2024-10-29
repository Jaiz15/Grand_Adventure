package jaiz.grandadventure.entity;


import jaiz.grandadventure.GrandAdventure;
import jaiz.grandadventure.entity.living_entities.*;
import jaiz.grandadventure.entity.thrown_entities.DynamiteEntity;
import jaiz.grandadventure.entity.thrown_entities.FishFoodEntity;
import jaiz.grandadventure.entity.thrown_entities.ThrownRockEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static final EntityType<ThrownRockEntity> ROCK = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(GrandAdventure.MOD_ID, "rock"),
            FabricEntityTypeBuilder.<ThrownRockEntity>create(SpawnGroup.MISC, ThrownRockEntity::new).dimensions(EntityDimensions.fixed(0.4f, 0.4f)).build());

    public static final EntityType<DynamiteEntity> DYNAMITE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(GrandAdventure.MOD_ID, "dynamite"),
            FabricEntityTypeBuilder.<DynamiteEntity>create(SpawnGroup.MISC, DynamiteEntity::new).dimensions(EntityDimensions.fixed(0.4f, 0.4f)).build());

    public static final EntityType<FishFoodEntity> FISH_FOOD = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(GrandAdventure.MOD_ID, "fish_food"),
            FabricEntityTypeBuilder.<FishFoodEntity>create(SpawnGroup.MISC, FishFoodEntity::new).dimensions(EntityDimensions.fixed(0.3f, 0.3f)).build());

    public static final EntityType<KoiEntity> KOI = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(GrandAdventure.MOD_ID, "koi"),
            FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, KoiEntity::new).dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());

    public static final EntityType<GrandstoneGuardianEntity> GRANDSTONE_GUARDIAN = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(GrandAdventure.MOD_ID, "grandstone_guardian"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, GrandstoneGuardianEntity::new).dimensions(EntityDimensions.fixed(0.5f, 2.0f)).build());

    public static final EntityType<GrandstoneMiteEntity> GRANDSTONE_MITE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(GrandAdventure.MOD_ID, "grandstone_mite"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, GrandstoneMiteEntity::new).dimensions(EntityDimensions.fixed(1.0f, 1.0f)).build());


    public static final EntityType<GrandCannonEntity> GRAND_CANNON = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(GrandAdventure.MOD_ID, "grand_cannon"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, GrandCannonEntity::new).dimensions(EntityDimensions.fixed(1.0f, 1.6f)).build());


    public static final EntityType<FloatingLanternEntity> FLOATING_LANTERN = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(GrandAdventure.MOD_ID, "floating_lantern"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, FloatingLanternEntity::new).dimensions(EntityDimensions.fixed(0.4f, 0.6f)).build());

    public static final EntityType<HotAirBalloonEntity> HOT_AIR_BALLOON = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(GrandAdventure.MOD_ID, "hot_air_balloon"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, HotAirBalloonEntity::new).dimensions(EntityDimensions.fixed(1.0f, 4.5f)).build());

    }
