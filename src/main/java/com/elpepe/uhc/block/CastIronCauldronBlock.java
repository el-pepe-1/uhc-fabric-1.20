package com.elpepe.uhc.block;

import com.elpepe.uhc.block.entity.CastIronCauldronBlockEntity;
import com.elpepe.uhc.block.entity.ModBlockEntities;
import com.elpepe.uhc.item.food.JamFoodItem;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

public class CastIronCauldronBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final BooleanProperty ABOVE_CAMPFIRE = BooleanProperty.of("above_campfire");
    public static final IntProperty WATER_LEVEL = IntProperty.of("water_level", 0, 3);
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    private static final VoxelShape SHAPE = Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 8.0, 13.0);
    private static final HashMap<Item, BlockInteraction<CastIronCauldronBlockEntity>> interactions = CastIronCauldronInteractions.DEFAULT_INTERACTIONS;
    private static final HashMap<Item, Item> foodContainers = CastIronCauldronInteractions.DEFAULT_FOOD_CONTAINERS;

    public CastIronCauldronBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx).with(FACING, ctx.getHorizontalPlayerFacing().getOpposite()).with(ABOVE_CAMPFIRE, false);
    }

    @Override
    @SuppressWarnings("deprecation")
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    @SuppressWarnings("deprecation")
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ABOVE_CAMPFIRE, WATER_LEVEL, FACING);
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CastIronCauldronBlockEntity(pos, state);
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof CastIronCauldronBlockEntity) {
                ItemScatterer.spawn(world, pos, (CastIronCauldronBlockEntity) blockEntity);
                world.updateComparators(pos, this);
            }

            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient()) {
            CastIronCauldronBlockEntity blockEntity = (CastIronCauldronBlockEntity) world.getBlockEntity(pos);
            if (blockEntity != null) {
                ItemStack stack = player.getStackInHand(hand);
                if (blockEntity.getOutputItemStack().isEmpty()) {
                    if (interactions.containsKey(stack.getItem())) {
                        interactions.get(stack.getItem()).interact(world, pos, state, blockEntity, player, hand);
                    } else {
                        player.openHandledScreen(blockEntity);
                    }
                } else {
                    if (!this.playerHasCorrectContainer(stack, blockEntity.getOutputItemStack().getItem())) {
                        return ActionResult.FAIL;
                    }

                    stack.decrement(1);
                    player.giveItemStack(blockEntity.getOutputItemStack().copyWithCount(1));
                    blockEntity.decrementOutputSlot();
                    world.setBlockState(pos, state.with(WATER_LEVEL, state.get(WATER_LEVEL) - 1));
                }
            }
        }

        return ActionResult.SUCCESS;
    }

    private boolean playerHasCorrectContainer(ItemStack handStack, Item outputItem) {
        Item resultContainer = Items.AIR;
        if (foodContainers.containsKey(outputItem)) {
            resultContainer = foodContainers.get(outputItem);
        } else if (outputItem instanceof StewItem) {
            resultContainer = Items.BOWL;
        } else if (outputItem instanceof JamFoodItem) {
            resultContainer = Items.GLASS_BOTTLE;
        }

        return handStack.isOf(resultContainer) || resultContainer == Items.AIR;
    }

    private void getItemStackFromOutputSlot(PlayerEntity player, CastIronCauldronBlockEntity blockEntity) {
    }

    @Override
    public <T extends BlockEntity> @Nullable BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.CAST_IRON_CAULDRON_BLOCK_ENTITY_BLOCK_ENTITY, (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
    }
}
