package com.elpepe.uhc.client;

import com.elpepe.uhc.effect.ModEffects;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;

public class FoxGraceHudOverlay implements HudRenderCallback {
   private static final class_2960 JUMP_STRENGTH_BAR = new class_2960("uhc", "textures/gui/jump_strength_bar.png");
   private static final class_2960 JUMP_STRENGTH_BAR_BG = new class_2960("uhc", "textures/gui/jump_strength_bar_background.png");

   public FoxGraceHudOverlay() {
   }

   public void onHudRender(class_332 drawContext, float tickDelta) {
      int x = false;
      int y = false;
      class_310 client = class_310.method_1551();
      if (client != null) {
         int width = drawContext.method_51421();
         int height = drawContext.method_51443();
         int x = width / 3 + 26;
         int y = height - 30;
         if (client.field_1724 != null && client.field_1724.method_6059(ModEffects.FOX_GRACE_EFFECT)) {
            y -= 26;
            RenderSystem.enableBlend();
            int jumpStrengthMaxWidth = 24;
            int jumpStrengthWidth = UhcClientData.jumpStrength * jumpStrengthMaxWidth / 80;
            drawContext.method_25291(JUMP_STRENGTH_BAR, x + 1, y + 1, 1, 0.0F, 0.0F, jumpStrengthWidth, 4, jumpStrengthWidth, 4);
            drawContext.method_25291(JUMP_STRENGTH_BAR_BG, x, y, 0, 0.0F, 0.0F, 26, 6, 26, 6);
         }
      }

   }
}
