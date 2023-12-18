package com.elpepe.uhc.datagen;

import com.elpepe.uhc.block.ModBlocks;
import com.elpepe.uhc.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NITHRIL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NITHRIL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_NITHRIL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRAY_ICE);

        BlockStateModelGenerator.BlockTexturePool cryogenicStonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CRYOGENIC_STONE);
        cryogenicStonePool.stairs(ModBlocks.CRYOGENIC_STONE_STAIRS);
        cryogenicStonePool.slab(ModBlocks.CRYOGENIC_STONE_SLAB);
        cryogenicStonePool.button(ModBlocks.CRYOGENIC_STONE_BUTTON);
        cryogenicStonePool.pressurePlate(ModBlocks.CRYOGENIC_STONE_PRESSURE_PLATE);
        cryogenicStonePool.wall(ModBlocks.CRYOGENIC_STONE_WALL);

        BlockStateModelGenerator.BlockTexturePool cobbledCryogenicStonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.COBBLED_CRYOGENIC_STONE);
        cobbledCryogenicStonePool.stairs(ModBlocks.COBBLED_CRYOGENIC_STONE_STAIRS);
        cobbledCryogenicStonePool.slab(ModBlocks.COBBLED_CRYOGENIC_STONE_SLAB);
        cobbledCryogenicStonePool.button(ModBlocks.COBBLED_CRYOGENIC_STONE_BUTTON);
        cobbledCryogenicStonePool.pressurePlate(ModBlocks.COBBLED_CRYOGENIC_STONE_PRESSURE_PLATE);
        cobbledCryogenicStonePool.wall(ModBlocks.COBBLED_CRYOGENIC_STONE_WALL);

        blockStateModelGenerator.registerLog(ModBlocks.DEAD_LOG).log(ModBlocks.DEAD_LOG).wood(ModBlocks.DEAD_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_DEAD_LOG).log(ModBlocks.STRIPPED_DEAD_LOG).wood(ModBlocks.STRIPPED_DEAD_WOOD);

        BlockStateModelGenerator.BlockTexturePool deadPlanksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DEAD_PLANKS);
        deadPlanksPool.stairs(ModBlocks.DEAD_PLANKS_STAIRS);
        deadPlanksPool.slab(ModBlocks.DEAD_PLANKS_SLAB);
        deadPlanksPool.button(ModBlocks.DEAD_PLANKS_BUTTON);
        deadPlanksPool.pressurePlate(ModBlocks.DEAD_PLANKS_PRESSURE_PLATE);
        deadPlanksPool.fence(ModBlocks.DEAD_PLANKS_FENCE);
        deadPlanksPool.fenceGate(ModBlocks.DEAD_PLANKS_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.DEAD_PLANKS_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.DEAD_PLANKS_TRAPDOOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_NITHRIL, Models.GENERATED);
        itemModelGenerator.register(ModItems.NITHRIL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.NITHRIL_PLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHARP_STONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOODY_JAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEALTH_JAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_TOTEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RADAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.DRAGON_HEART, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMERALD_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SHARP_EMERALD_SWORD, ModItems.EMERALD_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DRAGON_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NETHERITE_COVERED_DRAGON_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NITHRIL_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NITHRIL_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NITHRIL_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NITHRIL_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NITHRIL_HOE, Models.HANDHELD);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.NITHRIL_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.NITHRIL_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.NITHRIL_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.NITHRIL_BOOTS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.AIRTAG);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.POSEIDON_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.SLIME_BOOTS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.DEATHRUN_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.MAGMA_BOOTS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.FEATHER_BOOTS);
        itemModelGenerator.register(ModItems.SWEET_BERRIES_JAM, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLOW_BERRIES_JAM, Models.GENERATED);
        itemModelGenerator.register(ModItems.POISONOUS_SOUP, Models.GENERATED);
        itemModelGenerator.register(ModItems.SEAFOOD_SOUP, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOAT_MEAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_GOAT_MEAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.HORSE_LIKE_MEAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_HORSE_LIKE_MEAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.LLAMA_MEAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_LLAMA_MEAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAVAGER_MEAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_RAVAGER_MEAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.EARTHQUAKE_ARMOR_TRIM_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.MYSTERIOUS_TRADER_SPAWN_EGG, new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.GOBLIN_SPAWN_EGG, new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
    }
}
