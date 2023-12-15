package com.elpepe.uhc.datagen;

import com.elpepe.uhc.block.ModBlocks;
import com.elpepe.uhc.item.ModItems;
import java.util.function.Consumer;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.class_1802;
import net.minecraft.class_1856;
import net.minecraft.class_1865;
import net.minecraft.class_1935;
import net.minecraft.class_2444;
import net.minecraft.class_2447;
import net.minecraft.class_2960;
import net.minecraft.class_7800;
import net.minecraft.class_8074;

public class ModRecipeProvider extends FabricRecipeProvider {
   public ModRecipeProvider(FabricDataOutput output) {
      super(output);
   }

   public void method_10419(Consumer<class_2444> exporter) {
      method_36448(exporter, "goat", class_1865.field_9042, 200, ModItems.GOAT_MEAT, ModItems.COOKED_GOAT_MEAT, 5.0F);
      method_36448(exporter, "horselike", class_1865.field_9042, 200, ModItems.HORSE_LIKE_MEAT, ModItems.COOKED_HORSE_LIKE_MEAT, 5.0F);
      method_36448(exporter, "llama", class_1865.field_9042, 200, ModItems.LLAMA_MEAT, ModItems.COOKED_LLAMA_MEAT, 5.0F);
      method_36448(exporter, "ravager", class_1865.field_9042, 500, ModItems.RAVAGER_MEAT, ModItems.COOKED_RAVAGER_MEAT, 25.0F);
      method_36448(exporter, "goat_smoking", class_1865.field_17085, 200, ModItems.GOAT_MEAT, ModItems.COOKED_GOAT_MEAT, 5.0F);
      method_36448(exporter, "horselike_smoking", class_1865.field_17085, 200, ModItems.HORSE_LIKE_MEAT, ModItems.COOKED_HORSE_LIKE_MEAT, 5.0F);
      method_36448(exporter, "llama_smoking", class_1865.field_17085, 200, ModItems.LLAMA_MEAT, ModItems.COOKED_LLAMA_MEAT, 5.0F);
      method_36448(exporter, "ravager_smoking", class_1865.field_17085, 500, ModItems.RAVAGER_MEAT, ModItems.COOKED_RAVAGER_MEAT, 25.0F);
      method_36445(exporter, ModBlocks.DEAD_PLANKS, ModBlocks.DEAD_LOG, "dead_log", 4);
      method_36445(exporter, ModBlocks.DEAD_PLANKS, ModBlocks.DEAD_WOOD, "dead_wood", 3);
      method_33544(ModBlocks.DEAD_PLANKS_DOOR, class_1856.method_8091(new class_1935[]{ModBlocks.DEAD_PLANKS})).method_33530(method_32807(ModBlocks.DEAD_PLANKS), method_10426(ModBlocks.DEAD_PLANKS)).method_10431(exporter);
      method_47522(exporter, class_7800.field_40634, ModBlocks.NITHRIL_BLOCK, ModItems.NITHRIL_INGOT);
      method_47522(exporter, class_7800.field_40634, ModBlocks.RAW_NITHRIL_BLOCK, ModItems.RAW_NITHRIL);
      class_2447.method_10436(class_7800.field_40639, ModItems.EMERALD_SWORD, 1).method_10439("  e").method_10439(" E ").method_10439("s  ").method_10434('s', class_1802.field_8600).method_10434('E', class_1802.field_8733).method_10434('e', class_1802.field_8687).method_10429(method_32807(class_1802.field_8733), method_10426(class_1802.field_8733)).method_10429(method_32807(class_1802.field_8687), method_10426(class_1802.field_8687)).method_17972(exporter, new class_2960(method_36450(ModItems.EMERALD_SWORD)));
      class_2447.method_10436(class_7800.field_40638, ModItems.DRAGON_PICKAXE, 1).method_10439("LHL").method_10439("EPE").method_10439("ObO").method_10434('L', class_1802.field_8055).method_10434('H', class_1802.field_8712).method_10434('E', class_1802.field_8733).method_10434('P', class_1802.field_8377).method_10434('O', class_1802.field_8281).method_10434('b', class_1802.field_8613).method_10429(method_32807(class_1802.field_8712), method_10426(class_1802.field_8712)).method_10429(method_32807(class_1802.field_8613), method_10426(class_1802.field_8613)).method_17972(exporter, new class_2960(method_36450(ModItems.DRAGON_PICKAXE)));
      class_8074.method_48535(class_1856.field_9017, class_1856.method_8091(new class_1935[]{ModItems.DRAGON_PICKAXE}), class_1856.method_8091(new class_1935[]{class_1802.field_22020}), class_7800.field_40638, ModItems.NETHERITE_COVERED_DRAGON_PICKAXE).method_48536(method_32807(ModItems.DRAGON_PICKAXE), method_10426(ModItems.DRAGON_PICKAXE)).method_48537(exporter, new class_2960(method_36450(ModItems.NETHERITE_COVERED_DRAGON_PICKAXE)));
      class_8074.method_48535(class_1856.field_9017, class_1856.method_8091(new class_1935[]{ModItems.EMERALD_SWORD}), class_1856.method_8091(new class_1935[]{ModItems.SHARP_STONE}), class_7800.field_40639, ModItems.SHARP_EMERALD_SWORD).method_48536(method_32807(ModItems.EMERALD_SWORD), method_10426(ModItems.EMERALD_SWORD)).method_48536(method_32807(ModItems.SHARP_STONE), method_10426(ModItems.SHARP_STONE)).method_48537(exporter, new class_2960(method_36450(ModItems.SHARP_EMERALD_SWORD)));
      method_48530(exporter, ModItems.EARTHQUAKE_ARMOR_TRIM_SMITHING_TEMPLATE, new class_2960(method_36450(ModItems.EARTHQUAKE_ARMOR_TRIM_SMITHING_TEMPLATE)));
   }
}
