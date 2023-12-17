package com.elpepe.uhc.effect;

import com.elpepe.uhc.Uhc;
import com.elpepe.uhc.entity.ModEntityAttributes;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final StatusEffect FOX_GRACE_EFFECT = registerEffect("fox_grace", new FoxGraceEffect(StatusEffectCategory.NEUTRAL)
            .addAttributeModifier(ModEntityAttributes.STEP_HEIGHT, "a0773770-69a7-42ca-8a31-7c0b49601b53", 0.5, EntityAttributeModifier.Operation.ADDITION)
            .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "7ade48be-44d0-4d92-a6cc-fd6931a38fa8", 0.01, EntityAttributeModifier.Operation.ADDITION));

    private static StatusEffect registerEffect(String name, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(Uhc.MOD_ID, name), effect);
    }

    public static void registerEffects() {
        Uhc.LOGGER.info("Registering Mod Effects for " + Uhc.MOD_ID);
    }
}
