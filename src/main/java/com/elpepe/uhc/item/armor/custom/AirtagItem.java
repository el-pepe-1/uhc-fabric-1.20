package com.elpepe.uhc.item.armor.custom;

import com.elpepe.uhc.sound.ModSounds;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AirtagItem extends ArmorItem {
    public AirtagItem(ArmorMaterial material, ArmorItem.Type type, Item.Settings settings) {
        super(material, type, settings);
    }

    public static void onDetected(PlayerEntity wearer, ItemStack stack) {
        wearer.playSound(ModSounds.AIRTAG_ALARM, SoundCategory.MASTER, 1.0F, 1.0F);
        stack.damage(1, wearer, (entity) -> entity.sendEquipmentBreakStatus(EquipmentSlot.HEAD));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.uhc.airtag"));
        } else {
            tooltip.add(Text.translatable("tooltip.uhc.press_for_info"));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }
}
