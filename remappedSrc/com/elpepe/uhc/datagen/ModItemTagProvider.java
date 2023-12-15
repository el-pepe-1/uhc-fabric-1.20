package com.elpepe.uhc.datagen;

import com.elpepe.uhc.block.ModBlocks;
import com.elpepe.uhc.item.ModItems;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.class_3489;
import net.minecraft.class_7225;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
   public ModItemTagProvider(FabricDataOutput output, CompletableFuture<class_7225.class_7874> completableFuture) {
      super(output, completableFuture);
   }

   protected void method_10514(class_7225.class_7874 arg) {
      this.getOrCreateTagBuilder(class_3489.field_41890).add(ModItems.NITHRIL_HELMET).add(ModItems.NITHRIL_CHESTPLATE).add(ModItems.NITHRIL_LEGGINGS).add(ModItems.NITHRIL_BOOTS).add(ModItems.POSEIDON_HELMET).add(ModItems.SLIME_BOOTS).add(ModItems.DEATHRUN_LEGGINGS).add(ModItems.FEATHER_BOOTS).add(ModItems.MAGMA_BOOTS);
      this.getOrCreateTagBuilder(class_3489.field_41892).add(ModItems.EARTHQUAKE_ARMOR_TRIM_SMITHING_TEMPLATE);
      this.getOrCreateTagBuilder(class_3489.field_15537).add(ModBlocks.DEAD_PLANKS.method_8389());
      this.getOrCreateTagBuilder(class_3489.field_23212).add(ModBlocks.DEAD_LOG.method_8389()).add(ModBlocks.DEAD_WOOD.method_8389()).add(ModBlocks.STRIPPED_DEAD_LOG.method_8389()).add(ModBlocks.STRIPPED_DEAD_WOOD.method_8389());
   }
}
