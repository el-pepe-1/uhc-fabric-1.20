package com.elpepe.uhc.entity.client;

import net.minecraft.class_1297;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_5603;
import net.minecraft.class_5605;
import net.minecraft.class_5606;
import net.minecraft.class_5607;
import net.minecraft.class_5609;
import net.minecraft.class_5610;
import net.minecraft.class_583;
import net.minecraft.class_630;

public class HarpoonProjectileModel extends class_583<class_1297> {
   private final class_630 bb_main;

   public HarpoonProjectileModel(class_630 root) {
      this.bb_main = root.method_32086("bb_main");
   }

   public static class_5607 getTexturedModelData() {
      class_5609 modelData = new class_5609();
      class_5610 modelPartData = modelData.method_32111();
      modelPartData.method_32117("bb_main", class_5606.method_32108().method_32101(0, 0).method_32098(-1.0F, 0.0F, -3.0F, 2.0F, 0.0F, 6.0F, new class_5605(0.0F)), class_5603.method_32090(0.0F, 24.0F, 0.0F));
      return class_5607.method_32110(modelData, 16, 16);
   }

   public void method_2819(class_1297 entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }

   public void method_2828(class_4587 matrices, class_4588 vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
      this.bb_main.method_22699(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
   }
}
