package com.elpepe.uhc.villager.custom;

import net.minecraft.class_2960;
import net.minecraft.class_4004;
import net.minecraft.class_4587;
import net.minecraft.class_5602;
import net.minecraft.class_5617;
import net.minecraft.class_620;
import net.minecraft.class_927;
import net.minecraft.class_976;

public class MysteriousTraderRenderer extends class_927<MysteriousTraderEntity, class_620<MysteriousTraderEntity>> {
   private static final class_2960 TEXTURE = new class_2960("uhc", "textures/entity/mysterious_trader.png");

   public MysteriousTraderRenderer(class_5617.class_5618 context) {
      super(context, new class_620(context.method_32167(class_5602.field_27627)), 0.5F);
      this.method_4046(new class_976(this, context.method_32170(), context.method_43338()));
      this.method_4046(new class_4004(this, context.method_43338()));
   }

   public class_2960 getTexture(MysteriousTraderEntity wanderingTraderEntity) {
      return TEXTURE;
   }

   protected void scale(MysteriousTraderEntity wanderingTraderEntity, class_4587 matrixStack, float f) {
      float g = 0.9375F;
      matrixStack.method_22905(0.9375F, 0.9375F, 0.9375F);
   }
}
