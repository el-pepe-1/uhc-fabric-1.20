package com.elpepe.uhc.villager.custom;

import com.elpepe.uhc.Uhc;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.feature.VillagerHeldItemFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.VillagerResemblingModel;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.HeadFeatureRenderer;

public class MysteriousTraderRenderer extends MobEntityRenderer<MysteriousTraderEntity, VillagerResemblingModel<MysteriousTraderEntity>> {
   private static final Identifier TEXTURE = new Identifier(Uhc.MOD_ID, "textures/entity/mysterious_trader.png");

   public MysteriousTraderRenderer(EntityRendererFactory.Context context) {
      super(context, new VillagerResemblingModel<>(context.getPart(EntityModelLayers.WANDERING_TRADER)), 0.5F);
      this.addFeature(new HeadFeatureRenderer<>(this, context.getModelLoader(), context.getHeldItemRenderer()));
      this.addFeature(new VillagerHeldItemFeatureRenderer<>(this, context.getHeldItemRenderer()));
   }

   @Override
   public Identifier getTexture(MysteriousTraderEntity wanderingTraderEntity) {
      return TEXTURE;
   }

   @Override
   protected void scale(MysteriousTraderEntity wanderingTraderEntity, MatrixStack matrixStack, float f) {
      float g = 0.9375F;
      matrixStack.scale(g, g, g);
   }
}
