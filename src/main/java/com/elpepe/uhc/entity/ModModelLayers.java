package com.elpepe.uhc.entity;

import com.elpepe.uhc.Uhc;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer HARPOON_PROJECTILE = new EntityModelLayer(new Identifier(Uhc.MOD_ID, "harpoon_projectile"), "main");
    public static final EntityModelLayer LAVA_SWORD_PROJECTILE = new EntityModelLayer(new Identifier(Uhc.MOD_ID, "lava_sword_projectile"), "main");
    public static final EntityModelLayer GOBLIN = new EntityModelLayer(new Identifier(Uhc.MOD_ID, "goblin"), "main");
}
