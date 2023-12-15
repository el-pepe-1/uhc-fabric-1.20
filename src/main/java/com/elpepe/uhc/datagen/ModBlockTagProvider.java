package com.elpepe.uhc.datagen;

import com.elpepe.uhc.block.ModBlocks;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.class_3481;
import net.minecraft.class_7225;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
   public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<class_7225.class_7874> registriesFuture) {
      super(output, registriesFuture);
   }

   protected void method_10514(class_7225.class_7874 arg) {
      this.getOrCreateTagBuilder(class_3481.field_33715).add(ModBlocks.GRAY_ICE).add(ModBlocks.CAST_IRON_CAULDRON).add(ModBlocks.CRYOGENIC_STONE);
      this.getOrCreateTagBuilder(class_3481.field_23210).add(ModBlocks.DEAD_LOG).add(ModBlocks.DEAD_WOOD).add(ModBlocks.STRIPPED_DEAD_LOG).add(ModBlocks.STRIPPED_DEAD_WOOD);
      this.getOrCreateTagBuilder(class_3481.field_16584).add(ModBlocks.DEAD_PLANKS_FENCE);
      this.getOrCreateTagBuilder(class_3481.field_25147).add(ModBlocks.DEAD_PLANKS_FENCE_GATE);
      this.getOrCreateTagBuilder(class_3481.field_15504).add(ModBlocks.COBBLED_CRYOGENIC_STONE_WALL).add(ModBlocks.CRYOGENIC_STONE_WALL);
   }
}
