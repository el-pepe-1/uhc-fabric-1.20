package com.elpepe.uhc.block.entity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

@FunctionalInterface
public interface ImplementedInventory extends SidedInventory {
    static ImplementedInventory of(DefaultedList<ItemStack> items) {
        return () -> items;
    }

    static ImplementedInventory ofSize(int size) {
        return of(DefaultedList.ofSize(size, ItemStack.EMPTY));
    }

    DefaultedList<ItemStack> getItems();

    default int[] getAvailableSlots(Direction side) {
        int[] result = new int[this.getItems().size()];

        for (int i = 0; i < result.length; result[i] = i++) {
        }

        return result;
    }

    default boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        return true;
    }

    default boolean canExtract(int slot, ItemStack stack, Direction side) {
        return true;
    }

    default int size() {
        return this.getItems().size();
    }

    default boolean isEmpty() {
        for (int i = 0; i < this.size(); ++i) {
            ItemStack stack = this.getStack(i);
            if (!stack.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    default ItemStack getStack(int slot) {
        return this.getItems().get(slot);
    }

    default ItemStack removeStack(int slot, int count) {
        ItemStack result = Inventories.splitStack(this.getItems(), slot, count);
        if (!result.isEmpty()) {
            this.markDirty();
        }

        return result;
    }

    default ItemStack removeStack(int slot) {
        return Inventories.removeStack(this.getItems(), slot);
    }

    default void setStack(int slot, ItemStack stack) {
        this.getItems().set(slot, stack);
        if (stack.getCount() > this.getMaxCountPerStack()) {
            stack.setCount(this.getMaxCountPerStack());
        }

        this.markDirty();
    }

    default void clear() {
        this.getItems().clear();
    }

    default void markDirty() {
    }

    default boolean canPlayerUse(PlayerEntity player) {
        return true;
    }
}
