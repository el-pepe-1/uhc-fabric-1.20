package com.elpepe.uhc.util;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;

public class FeatureUtils {
    public static void setBlock(StructureWorldAccess world, BlockPos pos, BlockState state) {
        if (world.getBlockState(pos).isAir()) {
            world.setBlockState(pos, state, 3);
        }
    }
}
