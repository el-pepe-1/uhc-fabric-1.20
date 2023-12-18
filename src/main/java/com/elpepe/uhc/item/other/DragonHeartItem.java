package com.elpepe.uhc.item.other;

import com.elpepe.uhc.util.IEntityDataSaver;
import com.elpepe.uhc.util.UhcLivesData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class DragonHeartItem extends Item {
    public DragonHeartItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {
            ItemStack stack = user.getStackInHand(hand);
            UhcLivesData.setLives((ServerPlayerEntity) user, UhcLivesData.getLives((IEntityDataSaver) user) + 3);
            stack.damage(1, user, entity -> entity.sendToolBreakStatus(hand));
        }

        return super.use(world, user, hand);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }
}
