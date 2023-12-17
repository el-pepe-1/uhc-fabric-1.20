package com.elpepe.uhc.entity;

import com.elpepe.uhc.Uhc;
import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntityAttributes {
    public static final EntityAttribute STEP_HEIGHT = registerAttribute("step_height", new ClampedEntityAttribute("generic.step_height", 0.6, 0.0, 128.0).setTracked(true));

    private static EntityAttribute registerAttribute(String name, EntityAttribute attribute) {
        return Registry.register(Registries.ATTRIBUTE, new Identifier(Uhc.MOD_ID, name), attribute);
    }

    public static void registerAttributes() {
        Uhc.LOGGER.info("Registering Mod Attributes for " + Uhc.MOD_ID);
    }
}
