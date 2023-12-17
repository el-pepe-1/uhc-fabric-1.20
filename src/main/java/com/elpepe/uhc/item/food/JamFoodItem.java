package com.elpepe.uhc.item.food;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class JamFoodItem extends Item {
    private static final int DEFAULT_USAGE_TIME = 60;
    private final int maxUsageTime;

    public JamFoodItem(Item.Settings settings) {
        super(settings);
        this.maxUsageTime = DEFAULT_USAGE_TIME;
    }

    public JamFoodItem(Item.Settings settings, int maxUsageTime) {
        super(settings);
        this.maxUsageTime = maxUsageTime;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (!world.isClient()) {
            user.eatFood(world, stack);
            if (user instanceof PlayerEntity player) {
                if (!player.isCreative()) {
                    if (stack.getCount() == 1) {
                        return new ItemStack(Items.GLASS_BOTTLE);
                    }

                    player.giveItemStack(new ItemStack(Items.GLASS_BOTTLE));
                    stack.decrement(1);
                    return stack;
                }
            }
        }

        return super.finishUsing(stack, world, user);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return ItemUsage.consumeHeldItem(world, user, hand);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return this.maxUsageTime;
    }

    @Override
    public SoundEvent getDrinkSound() {
        return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
    }

    @Override
    public SoundEvent getEatSound() {
        return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
    }
}
