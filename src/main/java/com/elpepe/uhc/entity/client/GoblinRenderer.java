package com.elpepe.uhc.entity.client;

import com.elpepe.uhc.entity.ModModelLayers;
import com.elpepe.uhc.entity.custom.GoblinEntity;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;

public class GoblinRenderer extends MobEntityRenderer<GoblinEntity, GoblinModel<GoblinEntity>> {
   private static final Identifier TEXTURE = new Identifier(Uhc.MOD_ID, "textures/entity/goblin.png");

   public GoblinRenderer(EntityRendererFactory.class_5618 context) {
      super(context, new GoblinModel(context.getPart(ModModelLayers.GOBLIN)), 0.0F);
   }

   public Identifier getTexture(GoblinEntity entity) {
      return TEXTURE;
   }
}
