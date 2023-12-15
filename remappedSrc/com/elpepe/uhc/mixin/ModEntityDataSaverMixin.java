package com.elpepe.uhc.mixin;

import com.elpepe.uhc.util.IEntityDataSaver;
import net.minecraft.class_1297;
import net.minecraft.class_2487;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_1297.class})
public abstract class ModEntityDataSaverMixin implements IEntityDataSaver {
   private class_2487 persistentData;

   public ModEntityDataSaverMixin() {
   }

   public class_2487 getPersistentData() {
      if (this.persistentData == null) {
         this.persistentData = new class_2487();
      }

      return this.persistentData;
   }

   @Inject(
      method = {"writeNbt"},
      at = {@At("HEAD")}
   )
   protected void writeNbt(class_2487 nbt, CallbackInfoReturnable cir) {
      if (this.persistentData != null) {
         nbt.method_10566("UhcData", this.persistentData);
      }

   }

   @Inject(
      method = {"readNbt"},
      at = {@At("HEAD")}
   )
   protected void readNbt(class_2487 nbt, CallbackInfo ci) {
      if (nbt.method_10573("UhcData", 10)) {
         this.persistentData = nbt.method_10562("UhcData");
      }

   }
}
