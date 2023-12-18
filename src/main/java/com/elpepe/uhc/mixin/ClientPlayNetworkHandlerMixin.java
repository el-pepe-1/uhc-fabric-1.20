package com.elpepe.uhc.mixin;

import com.elpepe.uhc.item.ModItems;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.listener.TickablePacketListener;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientPlayNetworkHandler.class)
public abstract class ClientPlayNetworkHandlerMixin implements TickablePacketListener, ClientPlayPacketListener {

    @Inject(method = "getActiveTotemOfUndying", at = @At("HEAD"), cancellable = true)
    private static void getActiveTotemOfUndying(PlayerEntity player, CallbackInfoReturnable<ItemStack> cir) {
        for (Hand hand : Hand.values()) {
            ItemStack itemStack = player.getStackInHand(hand);
            if (itemStack.isOf(ModItems.RUBY_TOTEM)) {
                cir.setReturnValue(itemStack);
            }
        }

    }
}
