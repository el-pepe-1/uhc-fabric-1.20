package com.elpepe.uhc.client;

import com.elpepe.uhc.Uhc;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.Identifier;

public class UhcLivesHudOverlay implements HudRenderCallback {
    private static final Identifier UHC_HEART = new Identifier(Uhc.MOD_ID, "textures/item/dragon_heart.png");

    public void onHudRender(DrawContext drawContext, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client != null) {
            int width = drawContext.getScaledWindowWidth();
            int height = drawContext.getScaledWindowHeight();
            int x = width / 4;
            int y = height - 25;
            if (client.player != null && UhcClientData.uhcEnabled) {
                RenderSystem.enableBlend();
                drawContext.drawTexture(UHC_HEART, x, y, 0.0F, 0.0F, 16, 16, 16, 16);
                drawContext.drawTextWithShadow(client.textRenderer, String.valueOf(UhcClientData.uhcLives), x + 20, y + 4, 16777215);
            }
        }

    }
}
