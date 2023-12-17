package com.elpepe.uhc.datagen;

import com.elpepe.uhc.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.GRAY_ICE)
                .add(ModBlocks.CAST_IRON_CAULDRON)
                .add(ModBlocks.CRYOGENIC_STONE);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.DEAD_LOG)
                .add(ModBlocks.DEAD_WOOD)
                .add(ModBlocks.STRIPPED_DEAD_LOG)
                .add(ModBlocks.STRIPPED_DEAD_WOOD);
        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.DEAD_PLANKS_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.DEAD_PLANKS_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.COBBLED_CRYOGENIC_STONE_WALL)
                .add(ModBlocks.CRYOGENIC_STONE_WALL);
    }
}
