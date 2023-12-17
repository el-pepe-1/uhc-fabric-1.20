package com.elpepe.uhc.datagen;

import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryKeys;

public class ModWorldGeneration extends FabricDynamicRegistryProvider {
   public ModWorldGeneration(FabricDataOutput output, CompletableFuture<RegistryWrapper.class_7874> registriesFuture) {
      super(output, registriesFuture);
   }

   protected void configure(RegistryWrapper.class_7874 registries, FabricDynamicRegistryProvider.Entries entries) {
      entries.addAll(registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE));
      entries.addAll(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE));
      entries.addAll(registries.getWrapperOrThrow(RegistryKeys.BIOME));
      entries.addAll(registries.getWrapperOrThrow(RegistryKeys.DIMENSION_TYPE));
   }

   public String getName() {
      return "World Gen";
   }
}
