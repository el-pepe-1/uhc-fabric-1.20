package com.elpepe.uhc.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;

public class NightVisionHelmetHudOverlay implements HudRenderCallback {
   private static final class_2960 HEART = new class_2960("textures/gui/icons.png");

   public NightVisionHelmetHudOverlay() {
   }

   public void onHudRender(class_332 drawContext, float tickDelta) {
      int x = false;
      int y = false;
      class_310 client = class_310.method_1551();
      if (client != null) {
         int width = drawContext.method_51421();
         int height = drawContext.method_51443();
         int x = width / 2 - 4;
         int y = height / 2 + 20;
         if (UhcClientData.renderDamageAmountTime > 0) {
            RenderSystem.enableBlend();
            drawContext.method_25302(HEART, x, y + 2, 52, 0, 8, 8);
            x += 9;
            drawContext.method_25303(client.field_1772, String.format("%.1f", UhcClientData.damageAmount), x + 4, y, 16777215);
            --UhcClientData.renderDamageAmountTime;
         }
      }

   }
}
