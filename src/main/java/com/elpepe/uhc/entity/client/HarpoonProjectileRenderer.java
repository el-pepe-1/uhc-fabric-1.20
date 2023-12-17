package com.elpepe.uhc.entity.client;

import com.elpepe.uhc.entity.ModModelLayers;
import com.elpepe.uhc.entity.custom.HarpoonProjectileEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.item.ItemRenderer;

public class HarpoonProjectileRenderer extends EntityRenderer<HarpoonProjectileEntity> {
   public static final Identifier TEXTURE = new Identifier(Uhc.MOD_ID, "textures/entity/harpoon_projectile.png");
   protected HarpoonProjectileModel model;

   public HarpoonProjectileRenderer(EntityRendererFactory.class_5618 ctx) {
      super(ctx);
      this.model = new HarpoonProjectileModel(ctx.getPart(ModModelLayers.HARPOON_PROJECTILE));
   }

   public void render(HarpoonProjectileEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
      matrices.push();
      matrices.translate(0.0, -1.25, 0.0);
      matrices.scale(1.0F, 1.1F, 1.0F);
      matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(tickDelta, entity.prevYaw, entity.getYaw()) - 90.0F));
      matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(tickDelta, entity.prevPitch, entity.getPitch()) + 90.0F));
      VertexConsumer vertexconsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers, this.model.getLayer(TEXTURE), false, false);
      this.model.render(matrices, vertexconsumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
      matrices.pop();
      super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
   }

   public Identifier getTexture(HarpoonProjectileEntity entity) {
      return TEXTURE;
   }
}
