package com.elpepe.uhc.item.armor;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class EffectArmorItem extends ArmorItem implements TickableArmor {
    private final List<ArmorEffect> armorEffects = new ArrayList<>();
    private final List<String> tooltips = new ArrayList<>();

    public EffectArmorItem(ArmorMaterial material, ArmorItem.Type type, Item.Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void tick(LivingEntity user) {
        if (!user.getWorld().isClient()) {
            this.armorEffects.forEach(armorEffect -> user.addStatusEffect(new StatusEffectInstance(armorEffect.effect, armorEffect.duration, armorEffect.amplifier, true, false, false)));
        }
    }

    public EffectArmorItem addArmorEffect(StatusEffect effect, int amplifier) {
        return this.addArmorEffect(new ArmorEffect(effect, 5, amplifier));
    }

    public EffectArmorItem addArmorEffect(ArmorEffect effect) {
        this.armorEffects.add(effect);
        return this;
    }

    public EffectArmorItem addTooltip(String translationKey) {
        this.tooltips.add(translationKey);
        return this;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            this.tooltips.forEach(tip -> tooltip.add(Text.translatable(tip)));
        } else {
            tooltip.add(Text.translatable("tooltip.uhc.press_for_info"));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }

    public record ArmorEffect(StatusEffect effect, int duration, int amplifier) {

        public StatusEffect effect() {
            return this.effect;
        }

        public int duration() {
            return this.duration;
        }

        public int amplifier() {
            return this.amplifier;
        }
    }
}
