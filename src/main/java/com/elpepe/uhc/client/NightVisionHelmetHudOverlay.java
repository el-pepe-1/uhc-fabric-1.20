package com.elpepe.uhc.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.Identifier;

public class NightVisionHelmetHudOverlay implements HudRenderCallback {
    private static final Identifier HEART = new Identifier("textures/gui/icons.png");

    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client != null) {
            int width = drawContext.getScaledWindowWidth();
            int height = drawContext.getScaledWindowHeight();
            int x = width / 2 - 4;
            int y = height / 2 + 20;
            if (UhcClientData.renderDamageAmountTime > 0) {
                RenderSystem.enableBlend();
                drawContext.drawTexture(HEART, x, y + 2, 52, 0, 8, 8);
                x += 9;
                drawContext.drawTextWithShadow(client.textRenderer, String.format("%.1f", UhcClientData.damageAmount), x + 4, y, 16777215);
                --UhcClientData.renderDamageAmountTime;
            }
        }

    }
}
