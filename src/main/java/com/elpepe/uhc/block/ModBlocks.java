package com.elpepe.uhc.block;

import com.elpepe.uhc.Uhc;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block CAST_IRON_CAULDRON = registerBlock("cast_iron_cauldron", new CastIronCauldronBlock(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque().strength(0.1F)));
    public static final Block RADAR_BLOCK = registerBlockWithItem("radar_block", new RadarBlock(FabricBlockSettings.copyOf(Blocks.NOTE_BLOCK).strength(0.1F)));
    public static final Block GRAY_ICE = registerBlockWithItem("gray_ice", new Block(FabricBlockSettings.copyOf(Blocks.PACKED_ICE).strength(0.1F, 5.0F)));
    public static final Block NITHRIL_ORE = registerBlockWithItem("nithril_ore", new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE).strength(25.0F, 40.0F)));
    public static final Block NITHRIL_BLOCK = registerBlockWithItem("nithril_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(30.0F, 50.0F)));
    public static final Block RAW_NITHRIL_BLOCK = registerBlockWithItem("raw_nithril_block", new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));
    public static final Block CRYOGENIC_STONE = registerBlockWithItem("cryogenic_stone", new Block(FabricBlockSettings.copyOf(Blocks.STONE).strength(0.25F, 30.0F)));
    public static final Block CRYOGENIC_STONE_STAIRS = registerBlockWithItem("cryogenic_stone_stairs", new StairsBlock(CRYOGENIC_STONE.getDefaultState(), FabricBlockSettings.copyOf(CRYOGENIC_STONE)));
    public static final Block CRYOGENIC_STONE_SLAB = registerBlockWithItem("cryogenic_stone_slab", new SlabBlock(FabricBlockSettings.copyOf(CRYOGENIC_STONE)));
    public static final Block CRYOGENIC_STONE_WALL = registerBlockWithItem("cryogenic_stone_wall", new WallBlock(FabricBlockSettings.copyOf(CRYOGENIC_STONE)));
    public static final Block CRYOGENIC_STONE_BUTTON = registerBlockWithItem("cryogenic_stone_button", new ButtonBlock(FabricBlockSettings.copyOf(CRYOGENIC_STONE), BlockSetType.STONE, 10, true));
    public static final Block CRYOGENIC_STONE_PRESSURE_PLATE = registerBlockWithItem("cryogenic_stone_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(CRYOGENIC_STONE), BlockSetType.STONE));
    public static final Block COBBLED_CRYOGENIC_STONE = registerBlockWithItem("cobbled_cryogenic_stone", new Block(FabricBlockSettings.copyOf(CRYOGENIC_STONE)));
    public static final Block COBBLED_CRYOGENIC_STONE_STAIRS = registerBlockWithItem("cobbled_cryogenic_stone_stairs",
            new StairsBlock(COBBLED_CRYOGENIC_STONE.getDefaultState(), FabricBlockSettings.copyOf(COBBLED_CRYOGENIC_STONE)));
    public static final Block COBBLED_CRYOGENIC_STONE_SLAB = registerBlockWithItem("cobbled_cryogenic_stone_slab", new SlabBlock(FabricBlockSettings.copyOf(COBBLED_CRYOGENIC_STONE)));
    public static final Block COBBLED_CRYOGENIC_STONE_WALL = registerBlockWithItem("cobbled_cryogenic_stone_wall", new WallBlock(FabricBlockSettings.copyOf(COBBLED_CRYOGENIC_STONE)));
    public static final Block COBBLED_CRYOGENIC_STONE_BUTTON = registerBlockWithItem("cobbled_cryogenic_stone_button",
            new ButtonBlock(FabricBlockSettings.copyOf(COBBLED_CRYOGENIC_STONE), BlockSetType.STONE, 20, false));
    public static final Block COBBLED_CRYOGENIC_STONE_PRESSURE_PLATE = registerBlockWithItem("cobbled_cryogenic_stone_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(COBBLED_CRYOGENIC_STONE), BlockSetType.STONE));
    public static final Block DEAD_LOG = registerBlockWithItem("dead_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(4.0F)));
    public static final Block DEAD_WOOD = registerBlockWithItem("dead_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(4.0F)));
    public static final Block STRIPPED_DEAD_LOG = registerBlockWithItem("stripped_dead_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).strength(4.0F)));
    public static final Block STRIPPED_DEAD_WOOD = registerBlockWithItem("stripped_dead_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(4.0F)));
    public static final Block DEAD_PLANKS = registerBlockWithItem("dead_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4.0F)));
    public static final Block DEAD_PLANKS_STAIRS = registerBlockWithItem("dead_planks_stairs", new StairsBlock(DEAD_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(DEAD_PLANKS)));
    public static final Block DEAD_PLANKS_SLAB = registerBlockWithItem("dead_planks_slab", new SlabBlock(FabricBlockSettings.copyOf(DEAD_PLANKS)));
    public static final Block DEAD_PLANKS_BUTTON = registerBlockWithItem("dead_planks_button", new ButtonBlock(FabricBlockSettings.copyOf(DEAD_PLANKS), BlockSetType.OAK, 20, true));
    public static final Block DEAD_PLANKS_PRESSURE_PLATE = registerBlockWithItem("dead_planks_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(DEAD_PLANKS), BlockSetType.OAK));
    public static final Block DEAD_PLANKS_FENCE = registerBlockWithItem("dead_planks_fence", new FenceBlock(FabricBlockSettings.copyOf(DEAD_PLANKS)));
    public static final Block DEAD_PLANKS_FENCE_GATE = registerBlockWithItem("dead_planks_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(DEAD_PLANKS), WoodType.OAK));
    public static final Block DEAD_PLANKS_DOOR = registerBlockWithItem("dead_planks_door", new DoorBlock(FabricBlockSettings.copyOf(DEAD_PLANKS), BlockSetType.OAK));
    public static final Block DEAD_PLANKS_TRAPDOOR = registerBlockWithItem("dead_planks_trapdoor", new TrapdoorBlock(FabricBlockSettings.copyOf(DEAD_PLANKS), BlockSetType.OAK));

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Uhc.MOD_ID, name), block);
    }

    private static Block registerBlockWithItem(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Uhc.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Uhc.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerBlocks() {
        Uhc.LOGGER.info("Registering Mod Blocks for " + Uhc.MOD_ID);
    }
}
