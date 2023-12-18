package com.elpepe.uhc.item.other;

import com.elpepe.uhc.item.ModItems;
import com.elpepe.uhc.item.armor.custom.AirtagItem;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class RadarItem extends Item {
    public RadarItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {
            ItemStack stack = user.getStackInHand(hand);
            PlayerEntity nearestPlayer = world.getClosestPlayer(TargetPredicate.DEFAULT.setPredicate(entity -> entity instanceof PlayerEntity playerEntity && !entity.isSpectator() && !playerEntity.isCreative()), user);
            if (nearestPlayer != null) {
                ItemStack nearestHeadStack = nearestPlayer.getEquippedStack(EquipmentSlot.HEAD);
                Vec3d nearestPos = nearestPlayer.getPos();
                if (nearestHeadStack.isOf(ModItems.AIRTAG)) {
                    AirtagItem.onDetected(nearestPlayer, nearestHeadStack);
                }

                user.sendMessage(Text.translatable("item_message.uhc.radar_item_found_player").append(Text.literal(String.format("X: %s Y: %s Z: %s", nearestPos.x, nearestPos.y, nearestPos.y)).formatted(Formatting.GOLD)));
            } else {
                user.sendMessage(Text.translatable("item_message.uhc.radar_item_player_not_found"));
            }

            stack.damage(1, user, entity -> entity.sendToolBreakStatus(hand));
            user.getItemCooldownManager().set(this, 40);
        }

        return super.use(world, user, hand);
    }
}
