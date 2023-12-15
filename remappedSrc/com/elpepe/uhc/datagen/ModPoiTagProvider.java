package com.elpepe.uhc.datagen;

import java.util.concurrent.CompletableFuture;
import net.minecraft.class_2474;
import net.minecraft.class_2960;
import net.minecraft.class_4158;
import net.minecraft.class_7225;
import net.minecraft.class_7473;
import net.minecraft.class_7784;
import net.minecraft.class_7924;

public class ModPoiTagProvider extends class_2474<class_4158> {
   public ModPoiTagProvider(class_7784 output, CompletableFuture<class_7225.class_7874> registryLookupFuture) {
      super(output, class_7924.field_41212, registryLookupFuture);
   }

   protected void method_10514(class_7225.class_7874 lookup) {
      this.method_10512(class_7473.field_39262).method_35922(new class_2960("uhc", "mysteriouspoi"));
   }
}
