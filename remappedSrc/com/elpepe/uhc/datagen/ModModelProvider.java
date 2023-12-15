package com.elpepe.uhc.datagen;

import com.elpepe.uhc.block.ModBlocks;
import com.elpepe.uhc.item.ModItems;
import java.util.Optional;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.class_1738;
import net.minecraft.class_2960;
import net.minecraft.class_4910;
import net.minecraft.class_4915;
import net.minecraft.class_4942;
import net.minecraft.class_4943;
import net.minecraft.class_4945;

public class ModModelProvider extends FabricModelProvider {
   public ModModelProvider(FabricDataOutput output) {
      super(output);
   }

   public void generateBlockStateModels(class_4910 blockStateModelGenerator) {
      blockStateModelGenerator.method_25641(ModBlocks.NITHRIL_ORE);
      blockStateModelGenerator.method_25641(ModBlocks.NITHRIL_BLOCK);
      blockStateModelGenerator.method_25641(ModBlocks.RAW_NITHRIL_BLOCK);
      blockStateModelGenerator.method_25641(ModBlocks.GRAY_ICE);
      class_4910.class_4912 cryogenicStonePool = blockStateModelGenerator.method_25650(ModBlocks.CRYOGENIC_STONE);
      cryogenicStonePool.method_25725(ModBlocks.CRYOGENIC_STONE_STAIRS);
      cryogenicStonePool.method_25724(ModBlocks.CRYOGENIC_STONE_SLAB);
      cryogenicStonePool.method_25716(ModBlocks.CRYOGENIC_STONE_BUTTON);
      cryogenicStonePool.method_25723(ModBlocks.CRYOGENIC_STONE_PRESSURE_PLATE);
      cryogenicStonePool.method_25720(ModBlocks.CRYOGENIC_STONE_WALL);
      class_4910.class_4912 cobbledCryogenicStonePool = blockStateModelGenerator.method_25650(ModBlocks.COBBLED_CRYOGENIC_STONE);
      cobbledCryogenicStonePool.method_25725(ModBlocks.COBBLED_CRYOGENIC_STONE_STAIRS);
      cobbledCryogenicStonePool.method_25724(ModBlocks.COBBLED_CRYOGENIC_STONE_SLAB);
      cobbledCryogenicStonePool.method_25716(ModBlocks.COBBLED_CRYOGENIC_STONE_BUTTON);
      cobbledCryogenicStonePool.method_25723(ModBlocks.COBBLED_CRYOGENIC_STONE_PRESSURE_PLATE);
      cobbledCryogenicStonePool.method_25720(ModBlocks.COBBLED_CRYOGENIC_STONE_WALL);
      blockStateModelGenerator.method_25676(ModBlocks.DEAD_LOG).method_25730(ModBlocks.DEAD_LOG).method_25728(ModBlocks.DEAD_WOOD);
      blockStateModelGenerator.method_25676(ModBlocks.STRIPPED_DEAD_LOG).method_25730(ModBlocks.STRIPPED_DEAD_LOG).method_25728(ModBlocks.STRIPPED_DEAD_WOOD);
      class_4910.class_4912 deadPlanksPool = blockStateModelGenerator.method_25650(ModBlocks.DEAD_PLANKS);
      deadPlanksPool.method_25725(ModBlocks.DEAD_PLANKS_STAIRS);
      deadPlanksPool.method_25724(ModBlocks.DEAD_PLANKS_SLAB);
      deadPlanksPool.method_25716(ModBlocks.DEAD_PLANKS_BUTTON);
      deadPlanksPool.method_25723(ModBlocks.DEAD_PLANKS_PRESSURE_PLATE);
      deadPlanksPool.method_25721(ModBlocks.DEAD_PLANKS_FENCE);
      deadPlanksPool.method_25722(ModBlocks.DEAD_PLANKS_FENCE_GATE);
      blockStateModelGenerator.method_25658(ModBlocks.DEAD_PLANKS_DOOR);
      blockStateModelGenerator.method_25671(ModBlocks.DEAD_PLANKS_TRAPDOOR);
   }

   public void generateItemModels(class_4915 itemModelGenerator) {
      itemModelGenerator.method_25733(ModItems.RAW_NITHRIL, class_4943.field_22938);
      itemModelGenerator.method_25733(ModItems.NITHRIL_INGOT, class_4943.field_22938);
      itemModelGenerator.method_25733(ModItems.NITHRIL_PLATE, class_4943.field_22938);
      itemModelGenerator.method_25733(ModItems.RUBY, class_4943.field_22938);
      itemModelGenerator.method_25733(ModItems.SHARP_STONE, class_4943.field_22938);
      itemModelGenerator.method_25733(ModItems.BLOODY_JAR, class_4943.field_22938);
      itemModelGenerator.method_25733(ModItems.HEALTH_JAR, class_4943.field_22938);
      itemModelGenerator.method_25733(ModItems.RUBY_TOTEM, class_4943.field_22938);
      itemModelGenerator.method_25733(ModItems.RADAR, class_4943.field_22938);
      itemModelGenerator.method_25733(ModItems.DRAGON_HEART, class_4943.field_22938);
      itemModelGenerator.method_25733(ModItems.EMERALD_SWORD, class_4943.field_22939);
      itemModelGenerator.method_25732(ModItems.SHARP_EMERALD_SWORD, ModItems.EMERALD_SWORD, class_4943.field_22939);
      itemModelGenerator.method_25733(ModItems.DRAGON_PICKAXE, class_4943.field_22939);
      itemModelGenerator.method_25733(ModItems.NETHERITE_COVERED_DRAGON_PICKAXE, class_4943.field_22939);
      itemModelGenerator.method_25733(ModItems.NITHRIL_SWORD, class_4943.field_22939);
      itemModelGenerator.method_25733(ModItems.NITHRIL_PICKAXE, class_4943.field_22939);
      itemModelGenerator.method_25733(ModItems.NITHRIL_AXE, class_4943.field_22939);
      itemModelGenerator.method_25733(ModItems.NITHRIL_SHOVEL, class_4943.field_22939);
      itemModelGenerator.method_25733(ModItems.NITHRIL_HOE, class_4943.field_22939);
      itemModelGenerator.method_48523((class_1738)ModItems.NITHRIL_HELMET);
      itemModelGenerator.method_48523((class_1738)ModItems.NITHRIL_CHESTPLATE);
      itemModelGenerator.method_48523((class_1738)ModItems.NITHRIL_LEGGINGS);
      itemModelGenerator.method_48523((class_1738)ModItems.NITHRIL_BOOTS);
      itemModelGenerator.method_48523((class_1738)ModItems.AIRTAG);
      itemModelGenerator.method_48523((class_1738)ModItems.POSEIDON_HELMET);
      itemModelGenerator.method_48523((class_1738)ModItems.SLIME_BOOTS);
      itemModelGenerator.method_48523((class_1738)ModItems.DEATHRUN_LEGGINGS);
      itemModelGenerator.method_48523((class_1738)ModItems.MAGMA_BOOTS);
      itemModelGenerator.method_48523((class_1738)ModItems.FEATHER_BOOTS);
      itemModelGenerator.method_25733(ModItems.SWEET_BERRIES_JAM, class_4943.field_22938);
      itemModelGenerator.method_25733(ModItems.GLOW_BERRIES_JAM, class_4943.field_22938);
      itemModelGenerator.method_25733(ModItems.POISONOUS_SOUP, class_4943.field_22938);
      itemModelGenerator.method_25733(ModItems.SEAFOOD_SOUP, class_4943.field_22938);
      itemModelGenerator.method_25733(ModItems.GOAT_MEAT, class_4943.field_22938);
      itemModelGenerator.method_25733(ModItems.COOKED_GOAT_MEAT, class_4943.field_22938);
      itemModelGenerator.method_25733(ModItems.HORSE_LIKE_MEAT, class_4943.field_22938);
      itemModelGenerator.method_25733(ModItems.COOKED_HORSE_LIKE_MEAT, class_4943.field_22938);
      itemModelGenerator.method_25733(ModItems.LLAMA_MEAT, class_4943.field_22938);
      itemModelGenerator.method_25733(ModItems.COOKED_LLAMA_MEAT, class_4943.field_22938);
      itemModelGenerator.method_25733(ModItems.RAVAGER_MEAT, class_4943.field_22938);
      itemModelGenerator.method_25733(ModItems.COOKED_RAVAGER_MEAT, class_4943.field_22938);
      itemModelGenerator.method_25733(ModItems.EARTHQUAKE_ARMOR_TRIM_SMITHING_TEMPLATE, class_4943.field_22938);
      itemModelGenerator.method_25733(ModItems.MYSTERIOUS_TRADER_SPAWN_EGG, new class_4942(Optional.of(new class_2960("item/template_spawn_egg")), Optional.empty(), new class_4945[0]));
      itemModelGenerator.method_25733(ModItems.GOBLIN_SPAWN_EGG, new class_4942(Optional.of(new class_2960("item/template_spawn_egg")), Optional.empty(), new class_4945[0]));
   }
}
