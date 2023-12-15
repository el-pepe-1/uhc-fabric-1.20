package com.elpepe.uhc.block.entity;

import com.elpepe.uhc.block.CastIronCauldronBlock;
import com.elpepe.uhc.recipe.CastIronCauldronRecipe;
import com.elpepe.uhc.screen.CastIronCauldronScreenHandler;
import java.util.Optional;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2371;
import net.minecraft.class_2487;
import net.minecraft.class_2540;
import net.minecraft.class_2561;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_3222;
import net.minecraft.class_3913;
import net.minecraft.class_3922;
import net.minecraft.class_5455;
import org.jetbrains.annotations.Nullable;

public class CastIronCauldronBlockEntity extends class_2586 implements ExtendedScreenHandlerFactory, ImplementedInventory {
   private final class_2371<class_1799> inventory;
   private static final int INPUT_SLOT_1 = 0;
   private static final int INPUT_SLOT_2 = 1;
   private static final int INPUT_SLOT_3 = 2;
   private static final int OUTPUT_SLOT = 3;
   protected final class_3913 propertyDelegate;
   private int progress;
   private int maxProgres;
   private boolean aboveCampfire;

   public CastIronCauldronBlockEntity(class_2338 pos, class_2680 state) {
      super(ModBlockEntities.CAST_IRON_CAULDRON_BLOCK_ENTITY_BLOCK_ENTITY, pos, state);
      this.inventory = class_2371.method_10213(4, class_1799.field_8037);
      this.progress = 0;
      this.maxProgres = 72;
      this.propertyDelegate = new class_3913() {
         public int method_17390(int index) {
            int var10000;
            switch (index) {
               case 0:
                  var10000 = CastIronCauldronBlockEntity.this.progress;
                  break;
               case 1:
                  var10000 = CastIronCauldronBlockEntity.this.maxProgres;
                  break;
               default:
                  var10000 = 0;
            }

            return var10000;
         }

         public void method_17391(int index, int value) {
            switch (index) {
               case 0:
                  CastIronCauldronBlockEntity.this.progress = value;
                  break;
               case 1:
                  CastIronCauldronBlockEntity.this.maxProgres = value;
            }

         }

         public int method_17389() {
            return 2;
         }
      };
   }

   protected void method_11007(class_2487 nbt) {
      super.method_11007(nbt);
      Inventories.method_5426(nbt, this.inventory);
      nbt.method_10569("progress", this.progress);
   }

   public void method_11014(class_2487 nbt) {
      super.method_11014(nbt);
      Inventories.method_5429(nbt, this.inventory);
      this.progress = nbt.method_10550("progress");
   }

   public class_1799 getOutputItemStack() {
      return this.method_5438(3);
   }

   public void decrementOutputSlot() {
      this.method_5438(3).method_7934(1);
   }

   public class_2371<class_1799> getItems() {
      return this.inventory;
   }

   public void writeScreenOpeningData(class_3222 player, class_2540 buf) {
      buf.method_10807(this.field_11867);
   }

   public class_2561 method_5476() {
      return class_2561.method_43471("blockentity.uhc.cast_iron_cauldron");
   }

   public @Nullable $ createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
      return new CastIronCauldronScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
   }

   public void tick(class_1937 world, class_2338 pos, class_2680 state) {
      if (!world.method_8608()) {
         updateAboveCampfireValues(world, pos, state, this);
         if (this.isOutputSlotEmptyOrReceivable()) {
            if (this.hasRecipe(state)) {
               this.increaseCraftProgress();
               method_31663(world, pos, state);
               if (this.hasCraftingFinished()) {
                  this.craftItem(world, state, pos);
                  this.resetProgress();
               }
            } else {
               this.resetProgress();
            }
         } else {
            this.resetProgress();
            method_31663(world, pos, state);
         }

      }
   }

   private static void updateAboveCampfireValues(class_1937 world, class_2338 pos, class_2680 state, CastIronCauldronBlockEntity blockEntity) {
      class_2680 blockStateBelow = world.method_8320(pos.method_10074());
      if ((Boolean)state.method_11654(CastIronCauldronBlock.ABOVE_CAMPFIRE)) {
         if (!blockStateBelow.method_27852(class_2246.field_17350)) {
            world.method_8501(pos, (class_2680)state.method_11657(CastIronCauldronBlock.ABOVE_CAMPFIRE, false));
         }
      } else if (blockStateBelow.method_27852(class_2246.field_17350)) {
         world.method_8501(pos, (class_2680)state.method_11657(CastIronCauldronBlock.ABOVE_CAMPFIRE, true));
      }

      if (blockEntity.aboveCampfire) {
         if (!blockStateBelow.method_27852(class_2246.field_17350) || !(Boolean)blockStateBelow.method_11654(class_3922.field_17352)) {
            blockEntity.aboveCampfire = false;
         }
      } else if (blockStateBelow.method_27852(class_2246.field_17350) && (Boolean)blockStateBelow.method_11654(class_3922.field_17352)) {
         blockEntity.aboveCampfire = true;
      }

   }

   private void resetProgress() {
      this.progress = 0;
   }

   private void craftItem(class_1937 world, class_2680 state, class_2338 pos) {
      Optional<CastIronCauldronRecipe> recipe = this.getCurrentRecipe();
      this.method_5438(0).method_7934(1);
      this.method_5438(1).method_7934(1);
      this.method_5438(2).method_7934(1);
      this.method_5447(3, new class_1799(((CastIronCauldronRecipe)recipe.get()).getResult((class_5455)null).method_7909(), ((CastIronCauldronRecipe)recipe.get()).getResult((class_5455)null).method_7947() * (Integer)state.method_11654(CastIronCauldronBlock.WATER_LEVEL)));
   }

   private boolean hasCraftingFinished() {
      return this.progress >= this.maxProgres;
   }

   private void increaseCraftProgress() {
      ++this.progress;
   }

   private boolean hasRecipe(class_2680 state) {
      Optional<CastIronCauldronRecipe> recipe = this.getCurrentRecipe();
      return recipe.isPresent() && this.canInsertAmountIntoOutputSlot(((CastIronCauldronRecipe)recipe.get()).getResult((class_5455)null)) && this.canInsertItemIntoOutputSlot(((CastIronCauldronRecipe)recipe.get()).getResult((class_5455)null).method_7909()) && this.hasWater(state) && this.onFire();
   }

   private boolean hasWater(class_2680 state) {
      return (Integer)state.method_11654(CastIronCauldronBlock.WATER_LEVEL) > 0;
   }

   private boolean onFire() {
      return this.aboveCampfire;
   }

   private Optional<CastIronCauldronRecipe> getCurrentRecipe() {
      SimpleInventory inv = new SimpleInventory(this.method_5439());

      for(int i = 0; i < this.method_5439(); ++i) {
         inv.method_5447(i, this.method_5438(i));
      }

      return this.method_10997().method_8433().method_8132(CastIronCauldronRecipe.Type.INSTANCE, inv, this.method_10997());
   }

   private boolean canInsertItemIntoOutputSlot(class_1792 item) {
      return this.method_5438(3).method_7909() == item || this.method_5438(3).method_7960();
   }

   private boolean canInsertAmountIntoOutputSlot(class_1799 result) {
      return this.method_5438(3).method_7947() + result.method_7947() <= this.method_5438(3).method_7914();
   }

   private boolean isOutputSlotEmptyOrReceivable() {
      return this.method_5438(3).method_7960() || this.method_5438(3).method_7947() < this.method_5438(3).method_7914();
   }
}
