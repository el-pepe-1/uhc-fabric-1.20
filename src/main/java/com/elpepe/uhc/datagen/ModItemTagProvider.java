package com.elpepe.uhc.datagen;

import com.elpepe.uhc.block.ModBlocks;
import com.elpepe.uhc.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.NITHRIL_HELMET)
                .add(ModItems.NITHRIL_CHESTPLATE)
                .add(ModItems.NITHRIL_LEGGINGS)
                .add(ModItems.NITHRIL_BOOTS)
                .add(ModItems.POSEIDON_HELMET)
                .add(ModItems.SLIME_BOOTS)
                .add(ModItems.DEATHRUN_LEGGINGS)
                .add(ModItems.FEATHER_BOOTS)
                .add(ModItems.MAGMA_BOOTS);
        getOrCreateTagBuilder(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.EARTHQUAKE_ARMOR_TRIM_SMITHING_TEMPLATE);
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.DEAD_PLANKS.asItem());
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.DEAD_LOG.asItem())
                .add(ModBlocks.DEAD_WOOD.asItem())
                .add(ModBlocks.STRIPPED_DEAD_LOG.asItem())
                .add(ModBlocks.STRIPPED_DEAD_WOOD.asItem());
    }
}
