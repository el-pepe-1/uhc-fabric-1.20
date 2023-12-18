package com.elpepe.uhc.block.entity;

import com.elpepe.uhc.Uhc;
import com.elpepe.uhc.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
   public static final BlockEntityType<CastIronCauldronBlockEntity> CAST_IRON_CAULDRON_BLOCK_ENTITY_BLOCK_ENTITY =
           Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Uhc.MOD_ID, "cast_iron_cauldron_be"),
                   FabricBlockEntityTypeBuilder.create(CastIronCauldronBlockEntity::new, new Block[]{ModBlocks.CAST_IRON_CAULDRON}).build());

   public static void registerBlockEntities() {
      Uhc.LOGGER.info("Registering Block Entities for " + Uhc.MOD_ID);
   }
}
