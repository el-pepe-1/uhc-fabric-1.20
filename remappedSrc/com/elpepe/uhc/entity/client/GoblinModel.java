package com.elpepe.uhc.entity.client;

import com.elpepe.uhc.entity.custom.GoblinEntity;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_5597;
import net.minecraft.class_5603;
import net.minecraft.class_5605;
import net.minecraft.class_5606;
import net.minecraft.class_5607;
import net.minecraft.class_5609;
import net.minecraft.class_5610;
import net.minecraft.class_630;

public class GoblinModel<T extends GoblinEntity> extends class_5597<T> {
   private final class_630 body;
   private final class_630 mask;

   public GoblinModel(class_630 root) {
      this.body = root.method_32086("body");
      this.mask = root.method_32086("mask");
   }

   public static class_5607 getTexturedModelData() {
      class_5609 modelData = new class_5609();
      class_5610 modelPartData = modelData.method_32111();
      class_5610 body = modelPartData.method_32117("body", class_5606.method_32108().method_32101(0, 15).method_32098(-3.5F, -4.7572F, -2.4455F, 7.0F, 10.0F, 4.0F, new class_5605(0.0F)).method_32101(0, 0).method_32098(-3.75F, -4.8572F, -2.6945F, 7.5F, 10.0F, 4.5F, new class_5605(0.0F)), class_5603.method_32090(0.0F, 6.5572F, 0.0445F));
      body.method_32117("arm_l", class_5606.method_32108().method_32101(45, 44).method_32098(0.1F, -0.7572F, -1.4445F, 3.0F, 10.0F, 3.0F, new class_5605(0.0F)).method_32101(16, 33).method_32098(-0.15F, -1.0072F, -1.6945F, 3.5F, 10.25F, 3.5F, new class_5605(0.0F)), class_5603.method_32090(3.4F, -4.0F, -0.5F));
      body.method_32117("arm_r", class_5606.method_32108().method_32101(0, 41).method_32098(-3.0F, -0.0572F, -1.4445F, 3.0F, 10.0F, 3.0F, new class_5605(0.0F)).method_32101(32, 33).method_32098(-3.25F, -0.3072F, -1.6945F, 3.5F, 10.25F, 3.5F, new class_5605(0.0F)), class_5603.method_32090(-3.5F, -4.7F, -0.5F));
      body.method_32117("leg_l", class_5606.method_32108().method_32101(40, 0).method_32098(-1.8F, 0.0428F, -1.7945F, 3.5F, 8.0F, 3.5F, new class_5605(0.0F)).method_32101(22, 21).method_32098(-2.05F, -0.0572F, -2.0445F, 4.0F, 8.0F, 4.0F, new class_5605(0.0F)), class_5603.method_32090(1.8F, 5.2F, -0.4F));
      body.method_32117("leg_r", class_5606.method_32108().method_32101(38, 21).method_32098(-1.7F, 0.0428F, -1.7945F, 3.5F, 8.0F, 3.5F, new class_5605(0.0F)).method_32101(0, 29).method_32098(-1.95F, -0.0572F, -2.0445F, 4.0F, 8.0F, 4.0F, new class_5605(0.0F)), class_5603.method_32090(-1.8F, 5.2F, -0.4F));
      class_5610 head = body.method_32117("head", class_5606.method_32108().method_32101(22, 9).method_32098(-3.0F, -4.8F, -4.0F, 6.0F, 6.0F, 6.0F, new class_5605(0.0F)).method_32101(25, 4).method_32098(-1.0F, -1.7F, -5.5F, 2.0F, 3.0F, 1.9F, new class_5605(0.0F)), class_5603.method_32090(0.0F, -4.7572F, -1.0445F));
      class_5610 ear_l = head.method_32117("ear_l", class_5606.method_32108(), class_5603.method_32090(3.0F, -2.3F, -0.2F));
      ear_l.method_32117("cube_r1", class_5606.method_32108().method_32101(0, 0).method_32098(-0.75F, 0.5F, 1.85F, 1.5F, 1.5F, 0.01F, new class_5605(0.0F)), class_5603.method_32091(0.0F, 0.0F, 0.0F, 0.0F, 0.6109F, 0.0F));
      ear_l.method_32117("cube_r2", class_5606.method_32108().method_32101(12, 29).method_32098(0.0F, -2.2F, -0.005F, 4.0F, 4.0F, 0.01F, new class_5605(0.0F)), class_5603.method_32091(0.0F, 1.2F, -0.045F, 0.0F, -0.9599F, 0.0F));
      class_5610 ear_r = head.method_32117("ear_r", class_5606.method_32108(), class_5603.method_32090(-3.0F, -2.3F, -0.2F));
      ear_r.method_32117("cube_r3", class_5606.method_32108().method_32101(16, 47).method_32098(-4.0F, -2.2F, -0.005F, 4.0F, 4.0F, 0.01F, new class_5605(0.0F)), class_5603.method_32091(0.0F, 1.2F, -0.045F, 0.0F, 0.9599F, 0.0F));
      class_5610 mask = modelPartData.method_32117("mask", class_5606.method_32108().method_32101(0, 57).method_32098(-3.0F, -27.0F, -5.0F, 6.0F, 6.0F, 1.0F, new class_5605(0.0F)).method_32101(13, 58).method_32098(-1.1F, -24.0F, -6.5F, 2.2F, 3.2F, 1.6F, new class_5605(0.0F)).method_32101(35, 62).method_32098(-3.1F, -21.0F, -5.0F, 6.2F, 0.1F, 1.0F, new class_5605(0.0F)).method_32101(18, 55).method_32098(-3.1F, -27.1F, -5.0F, 6.2F, 0.1F, 1.0F, new class_5605(0.0F)).method_32101(28, 57).method_32096().method_32098(-3.1F, -27.0F, -5.0F, 0.1F, 6.0F, 1.0F, new class_5605(0.0F)).method_32106(false).method_32101(22, 57).method_32098(3.0F, -27.0F, -5.0F, 0.1F, 6.0F, 1.0F, new class_5605(0.0F)).method_32101(52, 62).method_32098(-3.1F, -26.0F, 1.2F, 6.2F, 2.0F, 0.0F, new class_5605(0.0F)), class_5603.method_32090(0.0F, 24.0F, -0.1F));
      mask.method_32117("stripe3_r1", class_5606.method_32108().method_32101(52, 62).method_32096().method_32098(0.0F, -1.0F, 3.101F, 5.5F, 2.0F, 0.0F, new class_5605(0.0F)).method_32106(false), class_5603.method_32091(0.0F, -25.0F, 1.2F, 0.0F, 1.5708F, 0.0F));
      mask.method_32117("stripe2_r1", class_5606.method_32108().method_32101(53, 62).method_32098(-5.5F, -1.0F, 3.101F, 5.5F, 2.0F, 0.0F, new class_5605(0.0F)), class_5603.method_32091(0.0F, -25.0F, 1.2F, 0.0F, -1.5708F, 0.0F));
      return class_5607.method_32110(modelData, 64, 64);
   }

   public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }

   public void method_2828(class_4587 matrices, class_4588 vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
      this.body.method_22699(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
      this.mask.method_22699(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
   }

   public class_630 method_32008() {
      return this.body;
   }
}
