package com.elpepe.uhc.item.armor;

import net.minecraft.entity.LivingEntity;

public interface TickableArmor {
    void tick(LivingEntity user);
}
