package com.elpepe.uhc.mixin;

import com.elpepe.uhc.item.ModItems;
import net.minecraft.util.Hand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.listener.TickablePacketListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({ClientPlayNetworkHandler.class})
public abstract class ClientPlayNetworkHandlerMixin implements TickablePacketListener, ClientPlayPacketListener {

   @Inject(
      method = {"getActiveTotemOfUndying"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private static void getActiveTotemOfUndying(PlayerEntity player, CallbackInfoReturnable<ItemStack> cir) {
      Hand[] var2 = Hand.values();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Hand hand = var2[var4];
         ItemStack itemStack = player.getStackInHand(hand);
         if (itemStack.isOf(ModItems.RUBY_TOTEM)) {
            cir.setReturnValue(itemStack);
         }
      }

   }
}
