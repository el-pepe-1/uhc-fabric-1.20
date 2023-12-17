package com.elpepe.uhc.enchantment;

import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BulldozerEnchantment extends Enchantment {
    protected BulldozerEnchantment(Enchantment.Rarity rarity, EquipmentSlot... slotTypes) {
        super(rarity, EnchantmentTarget.DIGGER, slotTypes);
    }

    public static void postMine(World world, BlockPos pos, LivingEntity miner, ItemStack stack, BlockState minedBlock) {
        if (miner instanceof PlayerEntity player) {
            if (!miner.isSneaking()) {
                switch (miner.getHorizontalFacing()) {
                    case NORTH:
                    case SOUTH:
                        mineBlock(player, world, pos.east(), stack, minedBlock);
                        mineBlock(player, world, pos.west(), stack, minedBlock);
                        mineBlock(player, world, pos.up(), stack, minedBlock);
                        mineBlock(player, world, pos.up().east(), stack, minedBlock);
                        mineBlock(player, world, pos.up().west(), stack, minedBlock);
                        mineBlock(player, world, pos.down(), stack, minedBlock);
                        mineBlock(player, world, pos.down().east(), stack, minedBlock);
                        mineBlock(player, world, pos.down().west(), stack, minedBlock);
                        break;
                    case EAST:
                    case WEST:
                        mineBlock(player, world, pos.south(), stack, minedBlock);
                        mineBlock(player, world, pos.north(), stack, minedBlock);
                        mineBlock(player, world, pos.up(), stack, minedBlock);
                        mineBlock(player, world, pos.up().south(), stack, minedBlock);
                        mineBlock(player, world, pos.up().north(), stack, minedBlock);
                        mineBlock(player, world, pos.down(), stack, minedBlock);
                        mineBlock(player, world, pos.down().south(), stack, minedBlock);
                        mineBlock(player, world, pos.down().north(), stack, minedBlock);
                }
            }
        }

    }

    private static void mineBlock(PlayerEntity miner, World world, BlockPos pos, ItemStack stack, BlockState minedBlock) {
        if (blocksAreSame(minedBlock, world.getBlockState(pos))) {
            world.breakBlock(pos, true, miner);
            stack.damage(1, miner, (entity) -> entity.sendToolBreakStatus(Hand.MAIN_HAND));
        }

    }

    private static boolean blocksAreSame(BlockState minedBlock, BlockState second) {
        if (minedBlock.isIn(BlockTags.BASE_STONE_OVERWORLD) && second.isIn(BlockTags.BASE_STONE_OVERWORLD)) {
            return true;
        } else {
            return minedBlock.isIn(BlockTags.BASE_STONE_NETHER) && second.isIn(BlockTags.BASE_STONE_NETHER) || minedBlock.isOf(second.getBlock());
        }
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof PickaxeItem;
    }
}
