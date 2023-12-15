package com.elpepe.uhc.block.entity;

import com.elpepe.uhc.Uhc;
import com.elpepe.uhc.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.class_2248;
import net.minecraft.class_2378;
import net.minecraft.class_2591;
import net.minecraft.class_2960;
import net.minecraft.class_7923;

public class ModBlockEntities {
   public static final class_2591<CastIronCauldronBlockEntity> CAST_IRON_CAULDRON_BLOCK_ENTITY_BLOCK_ENTITY;

   public ModBlockEntities() {
   }

   public static void registerBlockEntities() {
      Uhc.LOGGER.info("Registering Block Entities for uhc");
   }

   static {
      CAST_IRON_CAULDRON_BLOCK_ENTITY_BLOCK_ENTITY = (class_2591)class_2378.method_10230(class_7923.field_41181, new class_2960("uhc", "cast_iron_cauldron_be"), FabricBlockEntityTypeBuilder.create(CastIronCauldronBlockEntity::new, new class_2248[]{ModBlocks.CAST_IRON_CAULDRON}).build());
   }
}
