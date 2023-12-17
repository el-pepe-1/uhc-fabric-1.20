package com.elpepe.uhc.entity.client;

import com.elpepe.uhc.entity.animations.ModAnimations;
import com.elpepe.uhc.entity.custom.LavaSwordProjectileEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class LavaSwordProjectileModel<T extends LavaSwordProjectileEntity> extends SinglePartEntityModel<T> {
    private final ModelPart lava_sword_projectile;

    public LavaSwordProjectileModel(ModelPart root) {
        this.lava_sword_projectile = root.getChild("lava_sword_projectile");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData lava_sword_projectile = modelPartData.addChild("lava_sword_projectile", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        lava_sword_projectile.addChild("ring", ModelPartBuilder.create().uv(0, 0)
                .cuboid(-4.0F, -3.0F, 0.0F, 8.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        ModelPartData ring2 = lava_sword_projectile.addChild("ring2", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
        ring2.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0)
                .cuboid(-4.0F, -3.0F, 0.0F, 8.0F, 8.0F, 0.1F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));
        ModelPartData ring3 = lava_sword_projectile.addChild("ring3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        ring3.addChild("cube_r2", ModelPartBuilder.create().uv(0, 0)
                .cuboid(-4.0F, -3.0F, 0.0F, 8.0F, 8.0F, 0.1F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 2.0944F, 0.0F));
        ModelPartData heart = lava_sword_projectile.addChild("heart", ModelPartBuilder.create().uv(0, 8)
                .cuboid(-1.5F, -0.5F, 0.0F, 3.0F, 3.0F, 0.1F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        heart.addChild("cube_r3", ModelPartBuilder.create().uv(0, 8)
                .cuboid(-1.5F, -0.5F, 0.0F, 3.0F, 3.0F, 0.1F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -2.0944F, 0.0F));
        heart.addChild("cube_r4", ModelPartBuilder.create().uv(0, 8)
                .cuboid(-1.5F, -0.5F, 0.0F, 3.0F, 3.0F, 0.1F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 2.0944F, 0.0F));
        return TexturedModelData.of(modelData, 16, 16);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        this.lava_sword_projectile.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return this.lava_sword_projectile;
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.updateAnimation(entity.idleAnimationState, ModAnimations.LAVA_SWORD_PROJECTILE_IDLE, animationProgress, 1.0F);
    }
}
