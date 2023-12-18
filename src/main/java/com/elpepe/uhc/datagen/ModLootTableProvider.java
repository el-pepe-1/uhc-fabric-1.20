package com.elpepe.uhc.datagen;

import com.elpepe.uhc.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.CAST_IRON_CAULDRON);
        addDrop(ModBlocks.RADAR_BLOCK);
        addDrop(ModBlocks.GRAY_ICE);
        addDrop(ModBlocks.CRYOGENIC_STONE);
        addDrop(ModBlocks.CRYOGENIC_STONE_STAIRS);
        addDrop(ModBlocks.CRYOGENIC_STONE_BUTTON);
        addDrop(ModBlocks.CRYOGENIC_STONE_PRESSURE_PLATE);
        addDrop(ModBlocks.CRYOGENIC_STONE_WALL);
        addDrop(ModBlocks.CRYOGENIC_STONE_SLAB, slabDrops(ModBlocks.CRYOGENIC_STONE_SLAB));
        addDrop(ModBlocks.COBBLED_CRYOGENIC_STONE);
        addDrop(ModBlocks.COBBLED_CRYOGENIC_STONE_STAIRS);
        addDrop(ModBlocks.COBBLED_CRYOGENIC_STONE_BUTTON);
        addDrop(ModBlocks.COBBLED_CRYOGENIC_STONE_PRESSURE_PLATE);
        addDrop(ModBlocks.COBBLED_CRYOGENIC_STONE_WALL);
        addDrop(ModBlocks.COBBLED_CRYOGENIC_STONE_SLAB, slabDrops(ModBlocks.COBBLED_CRYOGENIC_STONE_SLAB));
        addDrop(ModBlocks.DEAD_LOG);
        addDrop(ModBlocks.DEAD_WOOD);
        addDrop(ModBlocks.STRIPPED_DEAD_LOG);
        addDrop(ModBlocks.STRIPPED_DEAD_WOOD);
        addDrop(ModBlocks.DEAD_PLANKS);
        addDrop(ModBlocks.DEAD_PLANKS_STAIRS);
        addDrop(ModBlocks.DEAD_PLANKS_TRAPDOOR);
        addDrop(ModBlocks.DEAD_PLANKS_FENCE);
        addDrop(ModBlocks.DEAD_PLANKS_FENCE_GATE);
        addDrop(ModBlocks.DEAD_PLANKS_BUTTON);
        addDrop(ModBlocks.DEAD_PLANKS_PRESSURE_PLATE);
        addDrop(ModBlocks.DEAD_PLANKS_DOOR, doorDrops(ModBlocks.DEAD_PLANKS_DOOR));
        addDrop(ModBlocks.DEAD_PLANKS_SLAB, slabDrops(ModBlocks.DEAD_PLANKS_SLAB));
    }
}
