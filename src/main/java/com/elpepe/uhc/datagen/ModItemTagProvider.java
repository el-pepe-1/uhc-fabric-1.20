package com.elpepe.uhc.datagen;

import com.elpepe.uhc.block.ModBlocks;
import com.elpepe.uhc.item.ModItems;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.RegistryWrapper;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
   public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.class_7874> completableFuture) {
      super(output, completableFuture);
   }

   protected void configure(RegistryWrapper.class_7874 arg) {
      this.getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR).add(ModItems.NITHRIL_HELMET).add(ModItems.NITHRIL_CHESTPLATE).add(ModItems.NITHRIL_LEGGINGS).add(ModItems.NITHRIL_BOOTS).add(ModItems.POSEIDON_HELMET).add(ModItems.SLIME_BOOTS).add(ModItems.DEATHRUN_LEGGINGS).add(ModItems.FEATHER_BOOTS).add(ModItems.MAGMA_BOOTS);
      this.getOrCreateTagBuilder(ItemTags.TRIM_TEMPLATES).add(ModItems.EARTHQUAKE_ARMOR_TRIM_SMITHING_TEMPLATE);
      this.getOrCreateTagBuilder(ItemTags.PLANKS).add(ModBlocks.DEAD_PLANKS.asItem());
      this.getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN).add(ModBlocks.DEAD_LOG.asItem()).add(ModBlocks.DEAD_WOOD.asItem()).add(ModBlocks.STRIPPED_DEAD_LOG.asItem()).add(ModBlocks.STRIPPED_DEAD_WOOD.asItem());
   }
}
