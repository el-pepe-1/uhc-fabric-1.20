package com.elpepe.uhc.block;

import com.elpepe.uhc.block.entity.CastIronCauldronBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

public class CastIronCauldronInteractions {
    public static final HashMap<Item, Item> DEFAULT_FOOD_CONTAINERS = new HashMap<>() {
    };
    public static final HashMap<Item, BlockInteraction<CastIronCauldronBlockEntity>> DEFAULT_INTERACTIONS = new HashMap<>() {
        {
            this.put(Items.POTION, (world, pos, state, blockEntity, player, hand) ->
                    CastIronCauldronInteractions.fillPot(world, pos, state, 1, player, hand, SoundEvents.ITEM_BOTTLE_EMPTY, new ItemStack(Items.GLASS_BOTTLE)));
            this.put(Items.WATER_BUCKET, (world, pos, state, blockEntity, player, hand) ->
                    CastIronCauldronInteractions.fillPot(world, pos, state, 3, player, hand, SoundEvents.ITEM_BUCKET_EMPTY, new ItemStack(Items.BUCKET)));
            this.put(Items.GLASS_BOTTLE, (world, pos, state, blockEntity, player, hand) ->
                    CastIronCauldronInteractions.getWaterFromPot(world, pos, state, 1, player, hand, SoundEvents.ITEM_BOTTLE_FILL, PotionUtil.setPotion(new ItemStack(Items.POTION), Potions.WATER)));
            this.put(Items.BUCKET, (world, pos, state, blockEntity, player, hand) ->
                    CastIronCauldronInteractions.getWaterFromPot(world, pos, state, 3, player, hand, SoundEvents.ITEM_BUCKET_FILL, new ItemStack(Items.WATER_BUCKET)));
        }
    };
    private static final int WATER_LEVELS_IN_BUCKET = 3;
    private static final int WATER_LEVELS_IN_BOTTLE = 1;

    private static void fillPot(World world, BlockPos pos, BlockState state, int toFill, PlayerEntity player, Hand hand, @Nullable SoundEvent sound, @Nullable ItemStack itemAfterFilling) {
        int currentLevel = state.get(CastIronCauldronBlock.WATER_LEVEL);
        if (currentLevel + toFill <= 3) {
            world.setBlockState(pos, state.with(CastIronCauldronBlock.WATER_LEVEL, currentLevel + toFill));
            if (sound != null) {
                world.playSound(null, pos, sound, SoundCategory.BLOCKS, 1.0F, 1.0F);
            }

            if (itemAfterFilling != null) {
                player.setStackInHand(hand, itemAfterFilling);
            }
        }

    }

    private static void getWaterFromPot(World world, BlockPos pos, BlockState state, int toGet, PlayerEntity player, Hand hand, @Nullable SoundEvent sound, @Nullable ItemStack itemAfterGetting) {
        int currentLevel = state.get(CastIronCauldronBlock.WATER_LEVEL);
        if (currentLevel - toGet >= 0) {
            world.setBlockState(pos, state.with(CastIronCauldronBlock.WATER_LEVEL, currentLevel - toGet));
            if (sound != null) {
                world.playSound(null, pos, sound, SoundCategory.BLOCKS, 1.0F, 1.0F);
            }

            if (itemAfterGetting != null) {
                player.setStackInHand(hand, itemAfterGetting);
            }
        }
    }
}
