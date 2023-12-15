package com.elpepe.uhc.item;

import com.elpepe.uhc.Uhc;
import com.elpepe.uhc.block.ModBlocks;
import com.elpepe.uhc.enchantment.ModEnchantments;
import net.minecraft.class_1761;
import net.minecraft.class_1772;
import net.minecraft.class_1799;
import net.minecraft.class_1889;
import net.minecraft.class_2378;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_7923;
import net.minecraft.class_1761.class_7915;

public class ModItemGroups {
   public static final class_1761 UHC_FOOD_GROUP;
   public static final class_1761 UHC_ITEMS_GROUP;
   public static final class_1761 UHC_BLOCKS;

   public ModItemGroups() {
   }

   public static void registerItemGroups() {
      Uhc.LOGGER.info("Registering Item Groups for uhc");
   }

   static {
      UHC_FOOD_GROUP = (class_1761)class_2378.method_10230(class_7923.field_44687, new class_2960("uhc", "uhc_food"), class_1761.method_47307(class_7915.field_41049, 0).method_47321(class_2561.method_43471("itemgroup.uhc_food")).method_47320(() -> {
         return new class_1799(ModItems.SWEET_BERRIES_JAM);
      }).method_47317((displayContext, entries) -> {
         entries.method_45421(ModItems.GOAT_MEAT);
         entries.method_45421(ModItems.COOKED_GOAT_MEAT);
         entries.method_45421(ModItems.HORSE_LIKE_MEAT);
         entries.method_45421(ModItems.COOKED_HORSE_LIKE_MEAT);
         entries.method_45421(ModItems.LLAMA_MEAT);
         entries.method_45421(ModItems.COOKED_LLAMA_MEAT);
         entries.method_45421(ModItems.RAVAGER_MEAT);
         entries.method_45421(ModItems.COOKED_RAVAGER_MEAT);
         entries.method_45421(ModItems.POISONOUS_SOUP);
         entries.method_45421(ModItems.SEAFOOD_SOUP);
         entries.method_45421(ModItems.GLOW_BERRIES_JAM);
         entries.method_45421(ModItems.SWEET_BERRIES_JAM);
      }).method_47324());
      UHC_ITEMS_GROUP = (class_1761)class_2378.method_10230(class_7923.field_44687, new class_2960("uhc", "uhc_items"), class_1761.method_47307(class_7915.field_41049, 1).method_47321(class_2561.method_43471("itemgroup.uhc_items")).method_47320(() -> {
         return new class_1799(ModItems.RUBY_TOTEM);
      }).method_47317((displayContext, entries) -> {
         entries.method_45421(ModItems.RAW_NITHRIL);
         entries.method_45421(ModItems.NITHRIL_INGOT);
         entries.method_45421(ModItems.NITHRIL_PLATE);
         entries.method_45421(ModItems.RUBY);
         entries.method_45421(ModItems.SHARP_STONE);
         entries.method_45421(ModItems.BLOODY_JAR);
         entries.method_45421(ModItems.HEALTH_JAR);
         entries.method_45421(ModItems.RUBY_TOTEM);
         entries.method_45421(ModItems.RADAR);
         entries.method_45421(ModItems.DRAGON_HEART);
         entries.method_45421(ModItems.EARTHQUAKE_ARMOR_TRIM_SMITHING_TEMPLATE);
         entries.method_45421(ModItems.HARPOON);
         entries.method_45421(ModItems.EMERALD_SWORD);
         entries.method_45421(ModItems.SHARP_EMERALD_SWORD);
         entries.method_45421(ModItems.LAVA_SWORD);
         entries.method_45421(ModItems.DRAGON_PICKAXE);
         entries.method_45421(ModItems.NETHERITE_COVERED_DRAGON_PICKAXE);
         entries.method_45421(ModItems.NITHRIL_SWORD);
         entries.method_45421(ModItems.NITHRIL_PICKAXE);
         entries.method_45421(ModItems.NITHRIL_AXE);
         entries.method_45421(ModItems.NITHRIL_SHOVEL);
         entries.method_45421(ModItems.NITHRIL_HOE);
         entries.method_45421(ModItems.NITHRIL_HELMET);
         entries.method_45421(ModItems.NITHRIL_CHESTPLATE);
         entries.method_45421(ModItems.NITHRIL_LEGGINGS);
         entries.method_45421(ModItems.NITHRIL_BOOTS);
         entries.method_45421(ModItems.AIRTAG);
         entries.method_45421(ModItems.NIGHT_VISION_HELMET);
         entries.method_45421(ModItems.POSEIDON_HELMET);
         entries.method_45421(ModItems.DEATHRUN_LEGGINGS);
         entries.method_45421(ModItems.MAGMA_BOOTS);
         entries.method_45421(ModItems.SLIME_BOOTS);
         entries.method_45421(ModItems.FEATHER_BOOTS);
         entries.method_45420(class_1772.method_7808(new class_1889(ModEnchantments.BULLDOZER, 1)));
         entries.method_45420(class_1772.method_7808(new class_1889(ModEnchantments.CREEP_ENCHANTMENT, 1)));
         entries.method_45421(ModItems.GOBLIN_SPAWN_EGG);
         entries.method_45421(ModItems.MYSTERIOUS_TRADER_SPAWN_EGG);
      }).method_47324());
      UHC_BLOCKS = (class_1761)class_2378.method_10230(class_7923.field_44687, new class_2960("uhc", "uhc_blocks"), class_1761.method_47307(class_7915.field_41049, 2).method_47321(class_2561.method_43471("itemgroup.uhc_blocks")).method_47320(() -> {
         return new class_1799(ModItems.CAST_IRON_CAULDRON_BLOCK_ITEM);
      }).method_47317((displayContext, entries) -> {
         entries.method_45421(ModBlocks.NITHRIL_ORE);
         entries.method_45421(ModBlocks.RAW_NITHRIL_BLOCK);
         entries.method_45421(ModBlocks.NITHRIL_BLOCK);
         entries.method_45421(ModBlocks.CAST_IRON_CAULDRON);
         entries.method_45421(ModBlocks.RADAR_BLOCK);
         entries.method_45421(ModBlocks.GRAY_ICE);
         entries.method_45421(ModBlocks.CRYOGENIC_STONE);
         entries.method_45421(ModBlocks.CRYOGENIC_STONE_STAIRS);
         entries.method_45421(ModBlocks.CRYOGENIC_STONE_SLAB);
         entries.method_45421(ModBlocks.CRYOGENIC_STONE_BUTTON);
         entries.method_45421(ModBlocks.CRYOGENIC_STONE_PRESSURE_PLATE);
         entries.method_45421(ModBlocks.CRYOGENIC_STONE_WALL);
         entries.method_45421(ModBlocks.COBBLED_CRYOGENIC_STONE);
         entries.method_45421(ModBlocks.COBBLED_CRYOGENIC_STONE_STAIRS);
         entries.method_45421(ModBlocks.COBBLED_CRYOGENIC_STONE_SLAB);
         entries.method_45421(ModBlocks.COBBLED_CRYOGENIC_STONE_BUTTON);
         entries.method_45421(ModBlocks.COBBLED_CRYOGENIC_STONE_PRESSURE_PLATE);
         entries.method_45421(ModBlocks.COBBLED_CRYOGENIC_STONE_WALL);
         entries.method_45421(ModBlocks.DEAD_LOG);
         entries.method_45421(ModBlocks.DEAD_WOOD);
         entries.method_45421(ModBlocks.STRIPPED_DEAD_LOG);
         entries.method_45421(ModBlocks.STRIPPED_DEAD_WOOD);
         entries.method_45421(ModBlocks.DEAD_PLANKS);
         entries.method_45421(ModBlocks.DEAD_PLANKS_STAIRS);
         entries.method_45421(ModBlocks.DEAD_PLANKS_SLAB);
         entries.method_45421(ModBlocks.DEAD_PLANKS_BUTTON);
         entries.method_45421(ModBlocks.DEAD_PLANKS_PRESSURE_PLATE);
         entries.method_45421(ModBlocks.DEAD_PLANKS_FENCE);
         entries.method_45421(ModBlocks.DEAD_PLANKS_FENCE_GATE);
         entries.method_45421(ModBlocks.DEAD_PLANKS_DOOR);
         entries.method_45421(ModBlocks.DEAD_PLANKS_TRAPDOOR);
      }).method_47324());
   }
}
