package com.elpepe.uhc.block;

import com.elpepe.uhc.Uhc;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.class_1747;
import net.minecraft.class_1792;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2269;
import net.minecraft.class_2323;
import net.minecraft.class_2349;
import net.minecraft.class_2354;
import net.minecraft.class_2378;
import net.minecraft.class_2440;
import net.minecraft.class_2465;
import net.minecraft.class_2482;
import net.minecraft.class_2510;
import net.minecraft.class_2533;
import net.minecraft.class_2544;
import net.minecraft.class_2960;
import net.minecraft.class_4719;
import net.minecraft.class_7923;
import net.minecraft.class_8177;
import net.minecraft.class_2440.class_2441;

public class ModBlocks {
   public static final class_2248 CAST_IRON_CAULDRON;
   public static final class_2248 RADAR_BLOCK;
   public static final class_2248 GRAY_ICE;
   public static final class_2248 NITHRIL_ORE;
   public static final class_2248 NITHRIL_BLOCK;
   public static final class_2248 RAW_NITHRIL_BLOCK;
   public static final class_2248 CRYOGENIC_STONE;
   public static final class_2248 CRYOGENIC_STONE_STAIRS;
   public static final class_2248 CRYOGENIC_STONE_SLAB;
   public static final class_2248 CRYOGENIC_STONE_WALL;
   public static final class_2248 CRYOGENIC_STONE_BUTTON;
   public static final class_2248 CRYOGENIC_STONE_PRESSURE_PLATE;
   public static final class_2248 COBBLED_CRYOGENIC_STONE;
   public static final class_2248 COBBLED_CRYOGENIC_STONE_STAIRS;
   public static final class_2248 COBBLED_CRYOGENIC_STONE_SLAB;
   public static final class_2248 COBBLED_CRYOGENIC_STONE_WALL;
   public static final class_2248 COBBLED_CRYOGENIC_STONE_BUTTON;
   public static final class_2248 COBBLED_CRYOGENIC_STONE_PRESSURE_PLATE;
   public static final class_2248 DEAD_LOG;
   public static final class_2248 DEAD_WOOD;
   public static final class_2248 STRIPPED_DEAD_LOG;
   public static final class_2248 STRIPPED_DEAD_WOOD;
   public static final class_2248 DEAD_PLANKS;
   public static final class_2248 DEAD_PLANKS_STAIRS;
   public static final class_2248 DEAD_PLANKS_SLAB;
   public static final class_2248 DEAD_PLANKS_BUTTON;
   public static final class_2248 DEAD_PLANKS_PRESSURE_PLATE;
   public static final class_2248 DEAD_PLANKS_FENCE;
   public static final class_2248 DEAD_PLANKS_FENCE_GATE;
   public static final class_2248 DEAD_PLANKS_DOOR;
   public static final class_2248 DEAD_PLANKS_TRAPDOOR;

   public ModBlocks() {
   }

   private static class_2248 registerBlock(String name, class_2248 block) {
      return (class_2248)class_2378.method_10230(class_7923.field_41175, new class_2960("uhc", name), block);
   }

   private static class_2248 registerBlockWithItem(String name, class_2248 block) {
      registerBlockItem(name, block);
      return (class_2248)class_2378.method_10230(class_7923.field_41175, new class_2960("uhc", name), block);
   }

   private static class_1792 registerBlockItem(String name, class_2248 block) {
      return (class_1792)class_2378.method_10230(class_7923.field_41178, new class_2960("uhc", name), new class_1747(block, new FabricItemSettings()));
   }

   public static void registerBlocks() {
      Uhc.LOGGER.info("Registering mod block for uhc");
   }

   static {
      CAST_IRON_CAULDRON = registerBlock("cast_iron_cauldron", new CastIronCauldronBlock(FabricBlockSettings.copyOf(class_2246.field_10593).nonOpaque().strength(0.1F)));
      RADAR_BLOCK = registerBlockWithItem("radar_block", new RadarBlock(FabricBlockSettings.copyOf(class_2246.field_10179).strength(0.1F)));
      GRAY_ICE = registerBlockWithItem("gray_ice", new class_2248(FabricBlockSettings.copyOf(class_2246.field_10225).strength(0.1F, 5.0F)));
      NITHRIL_ORE = registerBlockWithItem("nithril_ore", new class_2248(FabricBlockSettings.copyOf(class_2246.field_10212).strength(25.0F, 40.0F)));
      NITHRIL_BLOCK = registerBlockWithItem("nithril_block", new class_2248(FabricBlockSettings.copyOf(class_2246.field_10085).strength(30.0F, 50.0F)));
      RAW_NITHRIL_BLOCK = registerBlockWithItem("raw_nithril_block", new class_2248(FabricBlockSettings.copyOf(class_2246.field_33508)));
      CRYOGENIC_STONE = registerBlockWithItem("cryogenic_stone", new class_2248(FabricBlockSettings.copyOf(class_2246.field_10340).strength(0.25F, 30.0F)));
      CRYOGENIC_STONE_STAIRS = registerBlockWithItem("cryogenic_stone_stairs", new class_2510(CRYOGENIC_STONE.method_9564(), FabricBlockSettings.copyOf(CRYOGENIC_STONE)));
      CRYOGENIC_STONE_SLAB = registerBlockWithItem("cryogenic_stone_slab", new class_2482(FabricBlockSettings.copyOf(CRYOGENIC_STONE)));
      CRYOGENIC_STONE_WALL = registerBlockWithItem("cryogenic_stone_wall", new class_2544(FabricBlockSettings.copyOf(CRYOGENIC_STONE)));
      CRYOGENIC_STONE_BUTTON = registerBlockWithItem("cryogenic_stone_button", new class_2269(FabricBlockSettings.copyOf(CRYOGENIC_STONE), class_8177.field_42821, 10, true));
      CRYOGENIC_STONE_PRESSURE_PLATE = registerBlockWithItem("cryogenic_stone_pressure_plate", new class_2440(class_2441.field_11361, FabricBlockSettings.copyOf(CRYOGENIC_STONE), class_8177.field_42821));
      COBBLED_CRYOGENIC_STONE = registerBlockWithItem("cobbled_cryogenic_stone", new class_2248(FabricBlockSettings.copyOf(CRYOGENIC_STONE)));
      COBBLED_CRYOGENIC_STONE_STAIRS = registerBlockWithItem("cobbled_cryogenic_stone_stairs", new class_2510(COBBLED_CRYOGENIC_STONE.method_9564(), FabricBlockSettings.copyOf(COBBLED_CRYOGENIC_STONE)));
      COBBLED_CRYOGENIC_STONE_SLAB = registerBlockWithItem("cobbled_cryogenic_stone_slab", new class_2482(FabricBlockSettings.copyOf(COBBLED_CRYOGENIC_STONE)));
      COBBLED_CRYOGENIC_STONE_WALL = registerBlockWithItem("cobbled_cryogenic_stone_wall", new class_2544(FabricBlockSettings.copyOf(COBBLED_CRYOGENIC_STONE)));
      COBBLED_CRYOGENIC_STONE_BUTTON = registerBlockWithItem("cobbled_cryogenic_stone_button", new class_2269(FabricBlockSettings.copyOf(COBBLED_CRYOGENIC_STONE), class_8177.field_42821, 20, false));
      COBBLED_CRYOGENIC_STONE_PRESSURE_PLATE = registerBlockWithItem("cobbled_cryogenic_stone_pressure_plate", new class_2440(class_2441.field_11361, FabricBlockSettings.copyOf(COBBLED_CRYOGENIC_STONE), class_8177.field_42821));
      DEAD_LOG = registerBlockWithItem("dead_log", new class_2465(FabricBlockSettings.copyOf(class_2246.field_10431).strength(4.0F)));
      DEAD_WOOD = registerBlockWithItem("dead_wood", new class_2465(FabricBlockSettings.copyOf(class_2246.field_10126).strength(4.0F)));
      STRIPPED_DEAD_LOG = registerBlockWithItem("stripped_dead_log", new class_2465(FabricBlockSettings.copyOf(class_2246.field_10519).strength(4.0F)));
      STRIPPED_DEAD_WOOD = registerBlockWithItem("stripped_dead_wood", new class_2465(FabricBlockSettings.copyOf(class_2246.field_10250).strength(4.0F)));
      DEAD_PLANKS = registerBlockWithItem("dead_planks", new class_2248(FabricBlockSettings.copyOf(class_2246.field_10161).strength(4.0F)));
      DEAD_PLANKS_STAIRS = registerBlockWithItem("dead_planks_stairs", new class_2510(DEAD_PLANKS.method_9564(), FabricBlockSettings.copyOf(DEAD_PLANKS)));
      DEAD_PLANKS_SLAB = registerBlockWithItem("dead_planks_slab", new class_2482(FabricBlockSettings.copyOf(DEAD_PLANKS)));
      DEAD_PLANKS_BUTTON = registerBlockWithItem("dead_planks_button", new class_2269(FabricBlockSettings.copyOf(DEAD_PLANKS), class_8177.field_42823, 20, true));
      DEAD_PLANKS_PRESSURE_PLATE = registerBlockWithItem("dead_planks_pressure_plate", new class_2440(class_2441.field_11361, FabricBlockSettings.copyOf(DEAD_PLANKS), class_8177.field_42823));
      DEAD_PLANKS_FENCE = registerBlockWithItem("dead_planks_fence", new class_2354(FabricBlockSettings.copyOf(DEAD_PLANKS)));
      DEAD_PLANKS_FENCE_GATE = registerBlockWithItem("dead_planks_fence_gate", new class_2349(FabricBlockSettings.copyOf(DEAD_PLANKS), class_4719.field_21676));
      DEAD_PLANKS_DOOR = registerBlockWithItem("dead_planks_door", new class_2323(FabricBlockSettings.copyOf(DEAD_PLANKS), class_8177.field_42823));
      DEAD_PLANKS_TRAPDOOR = registerBlockWithItem("dead_planks_trapdoor", new class_2533(FabricBlockSettings.copyOf(DEAD_PLANKS), class_8177.field_42823));
   }
}
