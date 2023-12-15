package com.elpepe.uhc.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;

public class UhcLivesHudOverlay implements HudRenderCallback {
   private static final class_2960 UHC_HEART = new class_2960("uhc", "textures/item/dragon_heart.png");

   public UhcLivesHudOverlay() {
   }

   public void onHudRender(class_332 drawContext, float tickDelta) {
      int x = false;
      int y = false;
      class_310 client = class_310.method_1551();
      if (client != null) {
         int width = drawContext.method_51421();
         int height = drawContext.method_51443();
         int x = width / 4;
         int y = height - 25;
         if (client.field_1724 != null && UhcClientData.uhcEnabled) {
            RenderSystem.enableBlend();
            drawContext.method_25290(UHC_HEART, x, y, 0.0F, 0.0F, 16, 16, 16, 16);
            drawContext.method_25303(client.field_1772, String.valueOf(UhcClientData.uhcLives), x + 20, y + 4, 16777215);
         }
      }

   }
}
