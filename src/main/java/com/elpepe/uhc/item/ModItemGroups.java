package com.elpepe.uhc.item;

import com.elpepe.uhc.Uhc;
import com.elpepe.uhc.block.ModBlocks;
import com.elpepe.uhc.enchantment.ModEnchantments;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.item.ItemGroup.class_7915;

public class ModItemGroups {
   public static final ItemGroup UHC_FOOD_GROUP;
   public static final ItemGroup UHC_ITEMS_GROUP;
   public static final ItemGroup UHC_BLOCKS;

   public static void registerItemGroups() {
      Uhc.LOGGER.info("Registering Item Groups for " + Uhc.MOD_ID);
   }

   static {
      UHC_FOOD_GROUP = (ItemGroup)Registry.register(Registries.ITEM_GROUP, new Identifier(Uhc.MOD_ID, "uhc_food"), ItemGroup.create(class_7915.TOP, 0).displayName(Text.translatable("itemgroup.uhc_food")).icon(() -> {
         return new ItemStack(ModItems.SWEET_BERRIES_JAM);
      }).entries((displayContext, entries) -> {
         entries.add(ModItems.GOAT_MEAT);
         entries.add(ModItems.COOKED_GOAT_MEAT);
         entries.add(ModItems.HORSE_LIKE_MEAT);
         entries.add(ModItems.COOKED_HORSE_LIKE_MEAT);
         entries.add(ModItems.LLAMA_MEAT);
         entries.add(ModItems.COOKED_LLAMA_MEAT);
         entries.add(ModItems.RAVAGER_MEAT);
         entries.add(ModItems.COOKED_RAVAGER_MEAT);
         entries.add(ModItems.POISONOUS_SOUP);
         entries.add(ModItems.SEAFOOD_SOUP);
         entries.add(ModItems.GLOW_BERRIES_JAM);
         entries.add(ModItems.SWEET_BERRIES_JAM);
      }).build());
      UHC_ITEMS_GROUP = (ItemGroup)Registry.register(Registries.ITEM_GROUP, new Identifier(Uhc.MOD_ID, "uhc_items"), ItemGroup.create(class_7915.TOP, 1).displayName(Text.translatable("itemgroup.uhc_items")).icon(() -> {
         return new ItemStack(ModItems.RUBY_TOTEM);
      }).entries((displayContext, entries) -> {
         entries.add(ModItems.RAW_NITHRIL);
         entries.add(ModItems.NITHRIL_INGOT);
         entries.add(ModItems.NITHRIL_PLATE);
         entries.add(ModItems.RUBY);
         entries.add(ModItems.SHARP_STONE);
         entries.add(ModItems.BLOODY_JAR);
         entries.add(ModItems.HEALTH_JAR);
         entries.add(ModItems.RUBY_TOTEM);
         entries.add(ModItems.RADAR);
         entries.add(ModItems.DRAGON_HEART);
         entries.add(ModItems.EARTHQUAKE_ARMOR_TRIM_SMITHING_TEMPLATE);
         entries.add(ModItems.HARPOON);
         entries.add(ModItems.EMERALD_SWORD);
         entries.add(ModItems.SHARP_EMERALD_SWORD);
         entries.add(ModItems.LAVA_SWORD);
         entries.add(ModItems.DRAGON_PICKAXE);
         entries.add(ModItems.NETHERITE_COVERED_DRAGON_PICKAXE);
         entries.add(ModItems.NITHRIL_SWORD);
         entries.add(ModItems.NITHRIL_PICKAXE);
         entries.add(ModItems.NITHRIL_AXE);
         entries.add(ModItems.NITHRIL_SHOVEL);
         entries.add(ModItems.NITHRIL_HOE);
         entries.add(ModItems.NITHRIL_HELMET);
         entries.add(ModItems.NITHRIL_CHESTPLATE);
         entries.add(ModItems.NITHRIL_LEGGINGS);
         entries.add(ModItems.NITHRIL_BOOTS);
         entries.add(ModItems.AIRTAG);
         entries.add(ModItems.NIGHT_VISION_HELMET);
         entries.add(ModItems.POSEIDON_HELMET);
         entries.add(ModItems.DEATHRUN_LEGGINGS);
         entries.add(ModItems.MAGMA_BOOTS);
         entries.add(ModItems.SLIME_BOOTS);
         entries.add(ModItems.FEATHER_BOOTS);
         entries.add(EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(ModEnchantments.BULLDOZER, 1)));
         entries.add(EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(ModEnchantments.CREEP_ENCHANTMENT, 1)));
         entries.add(ModItems.GOBLIN_SPAWN_EGG);
         entries.add(ModItems.MYSTERIOUS_TRADER_SPAWN_EGG);
      }).build());
      UHC_BLOCKS = (ItemGroup)Registry.register(Registries.ITEM_GROUP, new Identifier(Uhc.MOD_ID, "uhc_blocks"), ItemGroup.create(class_7915.TOP, 2).displayName(Text.translatable("itemgroup.uhc_blocks")).icon(() -> {
         return new ItemStack(ModItems.CAST_IRON_CAULDRON_BLOCK_ITEM);
      }).entries((displayContext, entries) -> {
         entries.add(ModBlocks.NITHRIL_ORE);
         entries.add(ModBlocks.RAW_NITHRIL_BLOCK);
         entries.add(ModBlocks.NITHRIL_BLOCK);
         entries.add(ModBlocks.CAST_IRON_CAULDRON);
         entries.add(ModBlocks.RADAR_BLOCK);
         entries.add(ModBlocks.GRAY_ICE);
         entries.add(ModBlocks.CRYOGENIC_STONE);
         entries.add(ModBlocks.CRYOGENIC_STONE_STAIRS);
         entries.add(ModBlocks.CRYOGENIC_STONE_SLAB);
         entries.add(ModBlocks.CRYOGENIC_STONE_BUTTON);
         entries.add(ModBlocks.CRYOGENIC_STONE_PRESSURE_PLATE);
         entries.add(ModBlocks.CRYOGENIC_STONE_WALL);
         entries.add(ModBlocks.COBBLED_CRYOGENIC_STONE);
         entries.add(ModBlocks.COBBLED_CRYOGENIC_STONE_STAIRS);
         entries.add(ModBlocks.COBBLED_CRYOGENIC_STONE_SLAB);
         entries.add(ModBlocks.COBBLED_CRYOGENIC_STONE_BUTTON);
         entries.add(ModBlocks.COBBLED_CRYOGENIC_STONE_PRESSURE_PLATE);
         entries.add(ModBlocks.COBBLED_CRYOGENIC_STONE_WALL);
         entries.add(ModBlocks.DEAD_LOG);
         entries.add(ModBlocks.DEAD_WOOD);
         entries.add(ModBlocks.STRIPPED_DEAD_LOG);
         entries.add(ModBlocks.STRIPPED_DEAD_WOOD);
         entries.add(ModBlocks.DEAD_PLANKS);
         entries.add(ModBlocks.DEAD_PLANKS_STAIRS);
         entries.add(ModBlocks.DEAD_PLANKS_SLAB);
         entries.add(ModBlocks.DEAD_PLANKS_BUTTON);
         entries.add(ModBlocks.DEAD_PLANKS_PRESSURE_PLATE);
         entries.add(ModBlocks.DEAD_PLANKS_FENCE);
         entries.add(ModBlocks.DEAD_PLANKS_FENCE_GATE);
         entries.add(ModBlocks.DEAD_PLANKS_DOOR);
         entries.add(ModBlocks.DEAD_PLANKS_TRAPDOOR);
      }).build());
   }
}
