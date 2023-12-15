package com.elpepe.uhc.entity.client;

import com.elpepe.uhc.entity.ModModelLayers;
import com.elpepe.uhc.entity.custom.GoblinEntity;
import net.minecraft.class_2960;
import net.minecraft.class_5617;
import net.minecraft.class_927;

public class GoblinRenderer extends class_927<GoblinEntity, GoblinModel<GoblinEntity>> {
   private static final class_2960 TEXTURE = new class_2960("uhc", "textures/entity/goblin.png");

   public GoblinRenderer(class_5617.class_5618 context) {
      super(context, new GoblinModel(context.method_32167(ModModelLayers.GOBLIN)), 0.0F);
   }

   public class_2960 getTexture(GoblinEntity entity) {
      return TEXTURE;
   }
}
