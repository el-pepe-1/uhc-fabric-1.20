package com.elpepe.uhc.entity.client;

import com.elpepe.uhc.entity.ModModelLayers;
import com.elpepe.uhc.entity.custom.HarpoonProjectileEntity;
import net.minecraft.class_2960;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_4608;
import net.minecraft.class_5617;
import net.minecraft.class_7833;
import net.minecraft.class_897;
import net.minecraft.class_918;

public class HarpoonProjectileRenderer extends class_897<HarpoonProjectileEntity> {
   public static final class_2960 TEXTURE = new class_2960("uhc", "textures/entity/harpoon_projectile.png");
   protected HarpoonProjectileModel model;

   public HarpoonProjectileRenderer(class_5617.class_5618 ctx) {
      super(ctx);
      this.model = new HarpoonProjectileModel(ctx.method_32167(ModModelLayers.HARPOON_PROJECTILE));
   }

   public void render(HarpoonProjectileEntity entity, float yaw, float tickDelta, class_4587 matrices, class_4597 vertexConsumers, int light) {
      matrices.method_22903();
      matrices.method_22904(0.0, -1.25, 0.0);
      matrices.method_22905(1.0F, 1.1F, 1.0F);
      matrices.method_22907(class_7833.field_40716.rotationDegrees(class_3532.method_16439(tickDelta, entity.field_5982, entity.method_36454()) - 90.0F));
      matrices.method_22907(class_7833.field_40718.rotationDegrees(class_3532.method_16439(tickDelta, entity.field_6004, entity.method_36455()) + 90.0F));
      class_4588 vertexconsumer = class_918.method_29711(vertexConsumers, this.model.method_23500(TEXTURE), false, false);
      this.model.method_2828(matrices, vertexconsumer, light, class_4608.field_21444, 1.0F, 1.0F, 1.0F, 1.0F);
      matrices.method_22909();
      super.method_3936(entity, yaw, tickDelta, matrices, vertexConsumers, light);
   }

   public class_2960 getTexture(HarpoonProjectileEntity entity) {
      return TEXTURE;
   }
}
