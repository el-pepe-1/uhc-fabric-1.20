package com.elpepe.uhc.datagen;

import com.elpepe.uhc.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
   public ModLootTableProvider(FabricDataOutput dataOutput) {
      super(dataOutput);
   }

   public void generate() {
      this.addDrop(ModBlocks.CAST_IRON_CAULDRON);
      this.addDrop(ModBlocks.RADAR_BLOCK);
      this.addDrop(ModBlocks.GRAY_ICE);
      this.addDrop(ModBlocks.CRYOGENIC_STONE);
      this.addDrop(ModBlocks.CRYOGENIC_STONE_STAIRS);
      this.addDrop(ModBlocks.CRYOGENIC_STONE_BUTTON);
      this.addDrop(ModBlocks.CRYOGENIC_STONE_PRESSURE_PLATE);
      this.addDrop(ModBlocks.CRYOGENIC_STONE_WALL);
      this.addDrop(ModBlocks.CRYOGENIC_STONE_SLAB, this.slabDrops(ModBlocks.CRYOGENIC_STONE_SLAB));
      this.addDrop(ModBlocks.COBBLED_CRYOGENIC_STONE);
      this.addDrop(ModBlocks.COBBLED_CRYOGENIC_STONE_STAIRS);
      this.addDrop(ModBlocks.COBBLED_CRYOGENIC_STONE_BUTTON);
      this.addDrop(ModBlocks.COBBLED_CRYOGENIC_STONE_PRESSURE_PLATE);
      this.addDrop(ModBlocks.COBBLED_CRYOGENIC_STONE_WALL);
      this.addDrop(ModBlocks.COBBLED_CRYOGENIC_STONE_SLAB, this.slabDrops(ModBlocks.COBBLED_CRYOGENIC_STONE_SLAB));
      this.addDrop(ModBlocks.DEAD_LOG);
      this.addDrop(ModBlocks.DEAD_WOOD);
      this.addDrop(ModBlocks.STRIPPED_DEAD_LOG);
      this.addDrop(ModBlocks.STRIPPED_DEAD_WOOD);
      this.addDrop(ModBlocks.DEAD_PLANKS);
      this.addDrop(ModBlocks.DEAD_PLANKS_STAIRS);
      this.addDrop(ModBlocks.DEAD_PLANKS_TRAPDOOR);
      this.addDrop(ModBlocks.DEAD_PLANKS_FENCE);
      this.addDrop(ModBlocks.DEAD_PLANKS_FENCE_GATE);
      this.addDrop(ModBlocks.DEAD_PLANKS_BUTTON);
      this.addDrop(ModBlocks.DEAD_PLANKS_PRESSURE_PLATE);
      this.addDrop(ModBlocks.DEAD_PLANKS_DOOR, this.doorDrops(ModBlocks.DEAD_PLANKS_DOOR));
      this.addDrop(ModBlocks.DEAD_PLANKS_SLAB, this.slabDrops(ModBlocks.DEAD_PLANKS_SLAB));
   }
}
