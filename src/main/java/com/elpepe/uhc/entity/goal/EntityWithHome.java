package com.elpepe.uhc.entity.goal;

import net.minecraft.util.math.BlockPos;

public interface EntityWithHome {
   void setHome(BlockPos var1);

   BlockPos getHome();
}
