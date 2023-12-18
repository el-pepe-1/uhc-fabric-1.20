package com.elpepe.uhc.entity.goal;

import net.minecraft.util.math.BlockPos;

public interface EntityWithHome {
    BlockPos getHome();

    void setHome(BlockPos home);
}
