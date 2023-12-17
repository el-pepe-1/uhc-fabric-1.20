package com.elpepe.uhc.entity.client;

import com.elpepe.uhc.Uhc;
import com.elpepe.uhc.entity.ModModelLayers;
import com.elpepe.uhc.entity.custom.LavaSwordProjectileEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class LavaSwordProjectileRenderer extends MobEntityRenderer<LavaSwordProjectileEntity, LavaSwordProjectileModel<LavaSwordProjectileEntity>> {
    private static final Identifier TEXTURE = new Identifier(Uhc.MOD_ID, "textures/entity/lava_sword_projectile.png");

    public LavaSwordProjectileRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new LavaSwordProjectileModel<>(ctx.getPart(ModModelLayers.LAVA_SWORD_PROJECTILE)), 0.0F);
    }

    public void render(LavaSwordProjectileEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        matrices.scale(4.0F, 4.0F, 4.0F);
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public Identifier getTexture(LavaSwordProjectileEntity entity) {
        return TEXTURE;
    }
}
