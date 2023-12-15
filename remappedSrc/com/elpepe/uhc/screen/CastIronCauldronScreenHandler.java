package com.elpepe.uhc.screen;

import com.elpepe.uhc.block.entity.CastIronCauldronBlockEntity;
import net.minecraft.class_1263;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1735;
import net.minecraft.class_1799;
import net.minecraft.class_2540;
import net.minecraft.class_2586;
import net.minecraft.class_3913;
import net.minecraft.class_3919;

public class CastIronCauldronScreenHandler extends class_1703 {
   private final class_1263 inventory;
   private final class_3913 propertyDelegate;
   public final CastIronCauldronBlockEntity blockEntity;

   public CastIronCauldronScreenHandler(int syncId, class_1661 inventory, class_2540 buf) {
      this(syncId, inventory, inventory.field_7546.method_37908().method_8321(buf.method_10811()), new class_3919(2));
   }

   public CastIronCauldronScreenHandler(int syncId, class_1661 playerInventory, class_2586 blockEntity, class_3913 arrayPropertyDelegate) {
      super(ModScreenHandlers.CAST_IRON_CAULDRON_SCREEN_HANDLER, syncId);
      method_17359((class_1263)blockEntity, 2);
      this.inventory = (class_1263)blockEntity;
      playerInventory.method_5435(playerInventory.field_7546);
      this.propertyDelegate = arrayPropertyDelegate;
      this.blockEntity = (CastIronCauldronBlockEntity)blockEntity;
      this.method_7621(new class_1735(this.inventory, 0, 45, 56));
      this.method_7621(new class_1735(this.inventory, 1, 80, 45));
      this.method_7621(new class_1735(this.inventory, 2, 115, 56));

      int k;
      for(k = 0; k < 3; ++k) {
         for(int j = 0; j < 9; ++j) {
            this.method_7621(new class_1735(playerInventory, j + k * 9 + 9, 8 + j * 18, 139 + k * 18));
         }
      }

      for(k = 0; k < 9; ++k) {
         this.method_7621(new class_1735(playerInventory, k, 8 + k * 18, 197));
      }

      this.method_17360(arrayPropertyDelegate);
   }

   public boolean isCrafting() {
      return this.propertyDelegate.method_17390(0) > 0;
   }

   public class_1799 method_7601(class_1657 player, int invSlot) {
      class_1799 newStack = class_1799.field_8037;
      class_1735 slot = (class_1735)this.field_7761.get(invSlot);
      if (slot != null && slot.method_7681()) {
         class_1799 originalStack = slot.method_7677();
         newStack = originalStack.method_7972();
         if (invSlot < this.inventory.method_5439()) {
            if (!this.method_7616(originalStack, this.inventory.method_5439(), this.field_7761.size(), true)) {
               return class_1799.field_8037;
            }
         } else if (!this.method_7616(originalStack, 0, this.inventory.method_5439(), false)) {
            return class_1799.field_8037;
         }

         if (originalStack.method_7960()) {
            slot.method_48931(class_1799.field_8037);
         } else {
            slot.method_7668();
         }
      }

      return newStack;
   }

   public boolean method_7597(class_1657 player) {
      return this.inventory.method_5443(player);
   }
}
