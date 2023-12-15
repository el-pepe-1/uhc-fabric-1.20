package com.elpepe.uhc.entity.client;

import com.elpepe.uhc.entity.ModModelLayers;
import com.elpepe.uhc.entity.custom.LavaSwordProjectileEntity;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_5617;
import net.minecraft.class_927;

public class LavaSwordProjectileRenderer extends class_927<LavaSwordProjectileEntity, LavaSwordProjectileModel<LavaSwordProjectileEntity>> {
   private static final class_2960 TEXTURE = new class_2960("uhc", "textures/entity/lava_sword_projectile.png");

   public LavaSwordProjectileRenderer(class_5617.class_5618 ctx) {
      super(ctx, new LavaSwordProjectileModel(ctx.method_32167(ModModelLayers.LAVA_SWORD_PROJECTILE)), 0.0F);
   }

   public void render(LavaSwordProjectileEntity entity, float yaw, float tickDelta, class_4587 matrices, class_4597 vertexConsumers, int light) {
      matrices.method_22905(4.0F, 4.0F, 4.0F);
      super.method_4072(entity, yaw, tickDelta, matrices, vertexConsumers, light);
   }

   public class_2960 getTexture(LavaSwordProjectileEntity entity) {
      return TEXTURE;
   }
}
