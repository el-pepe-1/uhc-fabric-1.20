package com.elpepe.uhc.client;

import com.elpepe.uhc.Uhc;
import com.elpepe.uhc.effect.ModEffects;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.Identifier;

public class FoxGraceHudOverlay implements HudRenderCallback {
    private static final Identifier JUMP_STRENGTH_BAR = new Identifier(Uhc.MOD_ID, "textures/gui/jump_strength_bar.png");
    private static final Identifier JUMP_STRENGTH_BAR_BG = new Identifier(Uhc.MOD_ID, "textures/gui/jump_strength_bar_background.png");

    public void onHudRender(DrawContext drawContext, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client != null) {
            int width = drawContext.getScaledWindowWidth();
            int height = drawContext.getScaledWindowHeight();
            int x = width / 3 + 26;
            int y = height - 30;
            if (client.player != null && client.player.hasStatusEffect(ModEffects.FOX_GRACE_EFFECT)) {
                y -= 26;
                RenderSystem.enableBlend();
                int jumpStrengthMaxWidth = 24;
                int jumpStrengthWidth = UhcClientData.jumpStrength * jumpStrengthMaxWidth / 80;
                drawContext.drawTexture(JUMP_STRENGTH_BAR, x + 1, y + 1, 1, 0.0F, 0.0F, jumpStrengthWidth, 4, jumpStrengthWidth, 4);
                drawContext.drawTexture(JUMP_STRENGTH_BAR_BG, x, y, 0, 0.0F, 0.0F, 26, 6, 26, 6);
            }
        }
    }
}
