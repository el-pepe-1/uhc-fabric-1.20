package com.elpepe.uhc.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@FunctionalInterface
public interface BlockInteraction<T extends BlockEntity> {
   void interact(World world, BlockPos blockPos, BlockState blockState, T blockEntity, PlayerEntity playerEntity, Hand hand);
}
