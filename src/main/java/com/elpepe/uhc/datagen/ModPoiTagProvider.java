package com.elpepe.uhc.datagen;

import java.util.concurrent.CompletableFuture;
import net.minecraft.data.server.tag.TagProvider;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.PointOfInterestTypeTags;
import net.minecraft.data.DataOutput;
import net.minecraft.registry.RegistryKeys;

public class ModPoiTagProvider extends TagProvider<PointOfInterestType> {
   public ModPoiTagProvider(DataOutput output, CompletableFuture<RegistryWrapper.class_7874> registryLookupFuture) {
      super(output, RegistryKeys.POINT_OF_INTEREST_TYPE, registryLookupFuture);
   }

   protected void configure(RegistryWrapper.class_7874 lookup) {
      this.getOrCreateTagBuilder(PointOfInterestTypeTags.ACQUIRABLE_JOB_SITE).addOptional(new Identifier(Uhc.MOD_ID, "mysteriouspoi"));
   }
}
