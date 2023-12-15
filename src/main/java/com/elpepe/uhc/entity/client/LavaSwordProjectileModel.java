package com.elpepe.uhc.entity.client;

import com.elpepe.uhc.entity.animations.ModAnimations;
import com.elpepe.uhc.entity.custom.LavaSwordProjectileEntity;
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

public class LavaSwordProjectileModel<T extends LavaSwordProjectileEntity> extends class_5597<T> {
   private final class_630 lava_sword_projectile;

   public LavaSwordProjectileModel(class_630 root) {
      this.lava_sword_projectile = root.method_32086("lava_sword_projectile");
   }

   public static class_5607 getTexturedModelData() {
      class_5609 modelData = new class_5609();
      class_5610 modelPartData = modelData.method_32111();
      class_5610 lava_sword_projectile = modelPartData.method_32117("lava_sword_projectile", class_5606.method_32108(), class_5603.method_32090(0.0F, 24.0F, 0.0F));
      lava_sword_projectile.method_32117("ring", class_5606.method_32108().method_32101(0, 0).method_32098(-4.0F, -3.0F, 0.0F, 8.0F, 8.0F, 0.0F, new class_5605(0.0F)), class_5603.method_32090(0.0F, 0.0F, 0.0F));
      class_5610 ring2 = lava_sword_projectile.method_32117("ring2", class_5606.method_32108(), class_5603.method_32091(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
      ring2.method_32117("cube_r1", class_5606.method_32108().method_32101(0, 0).method_32098(-4.0F, -3.0F, 0.0F, 8.0F, 8.0F, 0.1F, new class_5605(0.0F)), class_5603.method_32091(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));
      class_5610 ring3 = lava_sword_projectile.method_32117("ring3", class_5606.method_32108(), class_5603.method_32090(0.0F, 0.0F, 0.0F));
      ring3.method_32117("cube_r2", class_5606.method_32108().method_32101(0, 0).method_32098(-4.0F, -3.0F, 0.0F, 8.0F, 8.0F, 0.1F, new class_5605(0.0F)), class_5603.method_32091(0.0F, 0.0F, 0.0F, 0.0F, 2.0944F, 0.0F));
      class_5610 heart = lava_sword_projectile.method_32117("heart", class_5606.method_32108().method_32101(0, 8).method_32098(-1.5F, -0.5F, 0.0F, 3.0F, 3.0F, 0.1F, new class_5605(0.0F)), class_5603.method_32090(0.0F, 0.0F, 0.0F));
      heart.method_32117("cube_r3", class_5606.method_32108().method_32101(0, 8).method_32098(-1.5F, -0.5F, 0.0F, 3.0F, 3.0F, 0.1F, new class_5605(0.0F)), class_5603.method_32091(0.0F, 0.0F, 0.0F, 0.0F, -2.0944F, 0.0F));
      heart.method_32117("cube_r4", class_5606.method_32108().method_32101(0, 8).method_32098(-1.5F, -0.5F, 0.0F, 3.0F, 3.0F, 0.1F, new class_5605(0.0F)), class_5603.method_32091(0.0F, 0.0F, 0.0F, 0.0F, 2.0944F, 0.0F));
      return class_5607.method_32110(modelData, 16, 16);
   }

   public void method_2828(class_4587 matrices, class_4588 vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
      this.lava_sword_projectile.method_22699(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
   }

   public class_630 method_32008() {
      return this.lava_sword_projectile;
   }

   public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
      this.method_32008().method_32088().forEach(class_630::method_41923);
      this.method_43782(entity.idleAnimationState, ModAnimations.LAVA_SWORD_PROJECTILE_IDLE, animationProgress, 1.0F);
   }
}
