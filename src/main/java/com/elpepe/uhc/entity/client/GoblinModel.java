package com.elpepe.uhc.entity.client;

import com.elpepe.uhc.entity.custom.GoblinEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class GoblinModel<T extends GoblinEntity> extends SinglePartEntityModel<T> {
    private final ModelPart body;
    private final ModelPart mask;

    public GoblinModel(ModelPart root) {
        this.body = root.getChild("body");
        this.mask = root.getChild("mask");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 15)
                .cuboid(-3.5F, -4.7572F, -2.4455F, 7.0F, 10.0F, 4.0F, new Dilation(0.0F)).uv(0, 0)
                .cuboid(-3.75F, -4.8572F, -2.6945F, 7.5F, 10.0F, 4.5F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.5572F, 0.0445F));
        body.addChild("arm_l", ModelPartBuilder.create().uv(45, 44)
                .cuboid(0.1F, -0.7572F, -1.4445F, 3.0F, 10.0F, 3.0F, new Dilation(0.0F)).uv(16, 33)
                .cuboid(-0.15F, -1.0072F, -1.6945F, 3.5F, 10.25F, 3.5F, new Dilation(0.0F)), ModelTransform.pivot(3.4F, -4.0F, -0.5F));
        body.addChild("arm_r", ModelPartBuilder.create().uv(0, 41)
                .cuboid(-3.0F, -0.0572F, -1.4445F, 3.0F, 10.0F, 3.0F, new Dilation(0.0F)).uv(32, 33)
                .cuboid(-3.25F, -0.3072F, -1.6945F, 3.5F, 10.25F, 3.5F, new Dilation(0.0F)), ModelTransform.pivot(-3.5F, -4.7F, -0.5F));
        body.addChild("leg_l", ModelPartBuilder.create().uv(40, 0)
                .cuboid(-1.8F, 0.0428F, -1.7945F, 3.5F, 8.0F, 3.5F, new Dilation(0.0F)).uv(22, 21)
                .cuboid(-2.05F, -0.0572F, -2.0445F, 4.0F, 8.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(1.8F, 5.2F, -0.4F));
        body.addChild("leg_r", ModelPartBuilder.create().uv(38, 21)
                .cuboid(-1.7F, 0.0428F, -1.7945F, 3.5F, 8.0F, 3.5F, new Dilation(0.0F)).uv(0, 29)
                .cuboid(-1.95F, -0.0572F, -2.0445F, 4.0F, 8.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.8F, 5.2F, -0.4F));
        ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(22, 9)
                .cuboid(-3.0F, -4.8F, -4.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F)).uv(25, 4)
                .cuboid(-1.0F, -1.7F, -5.5F, 2.0F, 3.0F, 1.9F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -4.7572F, -1.0445F));
        ModelPartData ear_l = head.addChild("ear_l", ModelPartBuilder.create(), ModelTransform.pivot(3.0F, -2.3F, -0.2F));
        ear_l.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0)
                .cuboid(-0.75F, 0.5F, 1.85F, 1.5F, 1.5F, 0.01F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.6109F, 0.0F));
        ear_l.addChild("cube_r2", ModelPartBuilder.create().uv(12, 29)
                .cuboid(0.0F, -2.2F, -0.005F, 4.0F, 4.0F, 0.01F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.2F, -0.045F, 0.0F, -0.9599F, 0.0F));
        ModelPartData ear_r = head.addChild("ear_r", ModelPartBuilder.create(), ModelTransform.pivot(-3.0F, -2.3F, -0.2F));
        ear_r.addChild("cube_r3", ModelPartBuilder.create().uv(16, 47)
                .cuboid(-4.0F, -2.2F, -0.005F, 4.0F, 4.0F, 0.01F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.2F, -0.045F, 0.0F, 0.9599F, 0.0F));
        ModelPartData mask = modelPartData.addChild("mask", ModelPartBuilder.create().uv(0, 57)
                .cuboid(-3.0F, -27.0F, -5.0F, 6.0F, 6.0F, 1.0F, new Dilation(0.0F)).uv(13, 58)
                .cuboid(-1.1F, -24.0F, -6.5F, 2.2F, 3.2F, 1.6F, new Dilation(0.0F)).uv(35, 62)
                .cuboid(-3.1F, -21.0F, -5.0F, 6.2F, 0.1F, 1.0F, new Dilation(0.0F)).uv(18, 55)
                .cuboid(-3.1F, -27.1F, -5.0F, 6.2F, 0.1F, 1.0F, new Dilation(0.0F)).uv(28, 57).mirrored()
                .cuboid(-3.1F, -27.0F, -5.0F, 0.1F, 6.0F, 1.0F, new Dilation(0.0F)).mirrored(false).uv(22, 57)
                .cuboid(3.0F, -27.0F, -5.0F, 0.1F, 6.0F, 1.0F, new Dilation(0.0F)).uv(52, 62)
                .cuboid(-3.1F, -26.0F, 1.2F, 6.2F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, -0.1F));
        mask.addChild("stripe3_r1", ModelPartBuilder.create().uv(52, 62).mirrored()
                .cuboid(0.0F, -1.0F, 3.101F, 5.5F, 2.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -25.0F, 1.2F, 0.0F, 1.5708F, 0.0F));
        mask.addChild("stripe2_r1", ModelPartBuilder.create().uv(53, 62)
                .cuboid(-5.5F, -1.0F, 3.101F, 5.5F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -25.0F, 1.2F, 0.0F, -1.5708F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        this.body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        this.mask.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return this.body;
    }
}
