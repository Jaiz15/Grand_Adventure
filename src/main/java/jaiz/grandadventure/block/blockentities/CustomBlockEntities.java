package jaiz.grandadventure.block.blockentities;

import jaiz.grandadventure.block.ModBlocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CustomBlockEntities {


    public static final BlockEntityType<TotemChamberBlockEntity> TOTEM_CHAMBER_BLOCK_ENTITY =
            register("ticking_block", BlockEntityType.Builder.create(TotemChamberBlockEntity::new, ModBlocks.TOTEM_CHAMBER).build());

    public static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType<T> type){
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(name), type);
    }

    public static void registerBlockEntities(){

    }


}
