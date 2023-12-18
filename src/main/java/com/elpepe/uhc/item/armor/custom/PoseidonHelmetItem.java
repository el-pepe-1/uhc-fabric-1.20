package com.elpepe.uhc.item.armor.custom;

import com.elpepe.uhc.item.armor.TickableArmor;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PoseidonHelmetItem extends ArmorItem implements TickableArmor {
    public PoseidonHelmetItem(ArmorMaterial material, ArmorItem.Type type, Item.Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void tick(LivingEntity user) {
        World world = user.getWorld();
        if (!world.isClient() && user.isTouchingWaterOrRain()) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 5, 0, true, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 5, 0, true, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 5, 0, true, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 5, 0, true, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 5, 0, true, false, false));
        }

    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.uhc.poseidon_helmet").formatted(Formatting.AQUA));
        } else {
            tooltip.add(Text.translatable("tooltip.uhc.press_for_info", ""));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }
}
