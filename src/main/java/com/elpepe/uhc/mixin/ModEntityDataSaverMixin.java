package com.elpepe.uhc.mixin;

import com.elpepe.uhc.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({Entity.class})
public abstract class ModEntityDataSaverMixin implements IEntityDataSaver {
   private NbtCompound persistentData;

   public NbtCompound getPersistentData() {
      if (this.persistentData == null) {
         this.persistentData = new NbtCompound();
      }

      return this.persistentData;
   }

   @Inject(
      method = {"writeNbt"},
      at = {@At("HEAD")}
   )
   protected void writeNbt(NbtCompound nbt, CallbackInfoReturnable cir) {
      if (this.persistentData != null) {
         nbt.put("UhcData", this.persistentData);
      }

   }

   @Inject(
      method = {"readNbt"},
      at = {@At("HEAD")}
   )
   protected void readNbt(NbtCompound nbt, CallbackInfo ci) {
      if (nbt.contains("UhcData", 10)) {
         this.persistentData = nbt.getCompound("UhcData");
      }

   }
}
