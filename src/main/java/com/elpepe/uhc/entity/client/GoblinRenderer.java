package com.elpepe.uhc.entity.client;

import com.elpepe.uhc.Uhc;
import com.elpepe.uhc.entity.ModModelLayers;
import com.elpepe.uhc.entity.custom.GoblinEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class GoblinRenderer extends MobEntityRenderer<GoblinEntity, GoblinModel<GoblinEntity>> {
    private static final Identifier TEXTURE = new Identifier(Uhc.MOD_ID, "textures/entity/goblin.png");

    public GoblinRenderer(EntityRendererFactory.Context context) {
        super(context, new GoblinModel<>(context.getPart(ModModelLayers.GOBLIN)), 0.0F);
    }

    @Override
    public Identifier getTexture(GoblinEntity entity) {
        return TEXTURE;
    }
}
