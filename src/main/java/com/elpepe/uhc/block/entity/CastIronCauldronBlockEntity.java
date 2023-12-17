package com.elpepe.uhc.block.entity;

import com.elpepe.uhc.block.CastIronCauldronBlock;
import com.elpepe.uhc.recipe.CastIronCauldronRecipe;
import com.elpepe.uhc.screen.CastIronCauldronScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class CastIronCauldronBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private static final int INPUT_SLOT_1 = 0;
    private static final int INPUT_SLOT_2 = 1;
    private static final int INPUT_SLOT_3 = 2;
    private static final int OUTPUT_SLOT = 3;
    protected final PropertyDelegate propertyDelegate;
    private final DefaultedList<ItemStack> inventory;
    private int progress;
    private int maxProgress;
    private boolean aboveCampfire;

    public CastIronCauldronBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CAST_IRON_CAULDRON_BLOCK_ENTITY_BLOCK_ENTITY, pos, state);
        this.inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);
        this.progress = 0;
        this.maxProgress = 72;
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                return switch (index) {
                    case 0 -> CastIronCauldronBlockEntity.this.progress;
                    case 1 -> CastIronCauldronBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0:
                        CastIronCauldronBlockEntity.this.progress = value;
                        break;
                    case 1:
                        CastIronCauldronBlockEntity.this.maxProgress = value;
                }

            }

            public int size() {
                return 2;
            }
        };
    }

    private static void updateAboveCampfireValues(World world, BlockPos pos, BlockState state, CastIronCauldronBlockEntity blockEntity) {
        BlockState blockStateBelow = world.getBlockState(pos.down());
        if (state.get(CastIronCauldronBlock.ABOVE_CAMPFIRE)) {
            if (!blockStateBelow.isOf(Blocks.CAMPFIRE)) {
                world.setBlockState(pos, state.with(CastIronCauldronBlock.ABOVE_CAMPFIRE, false));
            }
        } else if (blockStateBelow.isOf(Blocks.CAMPFIRE)) {
            world.setBlockState(pos, state.with(CastIronCauldronBlock.ABOVE_CAMPFIRE, true));
        }

        if (blockEntity.aboveCampfire) {
            if (!blockStateBelow.isOf(Blocks.CAMPFIRE) || !(Boolean) blockStateBelow.get(CampfireBlock.LIT)) {
                blockEntity.aboveCampfire = false;
            }
        } else if (blockStateBelow.isOf(Blocks.CAMPFIRE) && blockStateBelow.get(CampfireBlock.LIT)) {
            blockEntity.aboveCampfire = true;
        }

    }

    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, this.inventory);
        nbt.putInt("progress", this.progress);
    }

    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, this.inventory);
        this.progress = nbt.getInt("progress");
    }

    public ItemStack getOutputItemStack() {
        return this.getStack(3);
    }

    public void decrementOutputSlot() {
        this.getStack(3).decrement(1);
    }

    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    public Text getDisplayName() {
        return Text.translatable("blockentity.uhc.cast_iron_cauldron");
    }

    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new CastIronCauldronScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if (!world.isClient()) {
            updateAboveCampfireValues(world, pos, state, this);
            if (this.isOutputSlotEmptyOrReceivable()) {
                if (this.hasRecipe(state)) {
                    this.increaseCraftProgress();
                    markDirty(world, pos, state);
                    if (this.hasCraftingFinished()) {
                        this.craftItem(world, state, pos);
                        this.resetProgress();
                    }
                } else {
                    this.resetProgress();
                }
            } else {
                this.resetProgress();
                markDirty(world, pos, state);
            }

        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private void craftItem(World world, BlockState state, BlockPos pos) {
        Optional<CastIronCauldronRecipe> recipe = this.getCurrentRecipe();
        this.getStack(0).decrement(1);
        this.getStack(1).decrement(1);
        this.getStack(2).decrement(1);
        this.setStack(3, new ItemStack(recipe.get().getResult(null).getItem(), recipe.get().getResult(null).getCount() * state.get(CastIronCauldronBlock.WATER_LEVEL)));
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftProgress() {
        ++this.progress;
    }

    private boolean hasRecipe(BlockState state) {
        Optional<CastIronCauldronRecipe> recipe = this.getCurrentRecipe();
        return recipe.isPresent() && this.canInsertAmountIntoOutputSlot(recipe.get().getResult(null)) &&
                this.canInsertItemIntoOutputSlot(recipe.get().getResult(null).getItem()) && this.hasWater(state) && this.onFire();
    }

    private boolean hasWater(BlockState state) {
        return state.get(CastIronCauldronBlock.WATER_LEVEL) > 0;
    }

    private boolean onFire() {
        return this.aboveCampfire;
    }

    private Optional<CastIronCauldronRecipe> getCurrentRecipe() {
        SimpleInventory inv = new SimpleInventory(this.size());

        for (int i = 0; i < this.size(); ++i) {
            inv.setStack(i, this.getStack(i));
        }

        return this.getWorld().getRecipeManager().getFirstMatch(CastIronCauldronRecipe.Type.INSTANCE, inv, this.getWorld());
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.getStack(3).getItem() == item || this.getStack(3).isEmpty();
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
        return this.getStack(3).getCount() + result.getCount() <= this.getStack(3).getMaxCount();
    }

    private boolean isOutputSlotEmptyOrReceivable() {
        return this.getStack(3).isEmpty() || this.getStack(3).getCount() < this.getStack(3).getMaxCount();
    }
}
