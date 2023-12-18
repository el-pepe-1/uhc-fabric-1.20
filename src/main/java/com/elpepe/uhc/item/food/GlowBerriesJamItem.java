package com.elpepe.uhc.item.food;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class GlowBerriesJamItem extends JamFoodItem {
    public GlowBerriesJamItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        List<LivingEntity> entities = world.getEntitiesByClass(LivingEntity.class, user.getBoundingBox().offset(0.0, -1.5, 0.0).expand(25.0), entity -> entity instanceof LivingEntity);

        for (LivingEntity entity : entities) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 200, 0, true, false, false));
        }

        return super.finishUsing(stack, world, user);
    }
}
