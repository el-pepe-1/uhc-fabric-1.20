package com.elpepe.uhc;

import com.elpepe.uhc.datagen.ModBlockTagProvider;
import com.elpepe.uhc.datagen.ModItemTagProvider;
import com.elpepe.uhc.datagen.ModLootTableProvider;
import com.elpepe.uhc.datagen.ModModelProvider;
import com.elpepe.uhc.datagen.ModPoiTagProvider;
import com.elpepe.uhc.datagen.ModRecipeProvider;
import com.elpepe.uhc.datagen.ModWorldGeneration;
import com.elpepe.uhc.world.ModConfiguredFeatures;
import com.elpepe.uhc.world.ModPlacedFeature;
import com.elpepe.uhc.world.biome.ModBiomes;
import com.elpepe.uhc.world.dimension.ModDimensions;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class UhcDataGenerator implements DataGeneratorEntrypoint {
   public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
      FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
      pack.addProvider(ModBlockTagProvider::new);
      pack.addProvider(ModItemTagProvider::new);
      pack.addProvider(ModLootTableProvider::new);
      pack.addProvider(ModModelProvider::new);
      pack.addProvider(ModRecipeProvider::new);
      pack.addProvider(ModPoiTagProvider::new);
      pack.addProvider(ModWorldGeneration::new);
   }

   public void buildRegistry(RegistryBuilder registryBuilder) {
      registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
      registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeature::bootstrap);
      registryBuilder.addRegistry(RegistryKeys.BIOME, ModBiomes::bootstrap);
      registryBuilder.addRegistry(RegistryKeys.DIMENSION_TYPE, ModDimensions::bootstrapType);
   }
}
