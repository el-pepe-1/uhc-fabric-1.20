package com.elpepe.uhc.villager.custom;

import com.elpepe.uhc.entity.ModEntities;
import com.elpepe.uhc.entity.goal.EntityWithHome;
import com.elpepe.uhc.entity.goal.FindHomeGoal;
import com.elpepe.uhc.entity.goal.SleepGoal;
import com.elpepe.uhc.villager.ModTradeOffers;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1296;
import net.minecraft.class_1299;
import net.minecraft.class_1303;
import net.minecraft.class_1308;
import net.minecraft.class_1361;
import net.minecraft.class_1374;
import net.minecraft.class_1376;
import net.minecraft.class_1394;
import net.minecraft.class_1409;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1914;
import net.minecraft.class_1916;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2487;
import net.minecraft.class_2512;
import net.minecraft.class_3218;
import net.minecraft.class_3468;
import net.minecraft.class_3853;
import net.minecraft.class_3988;
import net.minecraft.class_4255;
import net.minecraft.class_5132;
import net.minecraft.class_5134;
import org.jetbrains.annotations.Nullable;

public class MysteriousTraderEntity extends class_3988 implements EntityWithHome {
   private class_2338 bed;

   public MysteriousTraderEntity(class_1299<? extends class_3988> entityType, class_1937 world) {
      super(entityType, world);
      this.bed = class_2338.field_10980;
      ((class_1409)this.method_5942()).method_6363(true);
      this.method_5942().method_6354(true);
   }

   public MysteriousTraderEntity(class_1937 world) {
      super(ModEntities.MYSTERIOUS_TRADER, world);
      this.bed = class_2338.field_10980;
      ((class_1409)this.method_5942()).method_6363(true);
      this.method_5942().method_6354(true);
   }

   public static class_5132.class_5133 createMysteriousTraderAttributes() {
      return class_1308.method_26828().method_26868(class_5134.field_23716, 20.0).method_26868(class_5134.field_23719, 0.5).method_26868(class_5134.field_23724, 0.5).method_26868(class_5134.field_23721, 1.0).method_26868(class_5134.field_23717, 48.0);
   }

   protected void method_5959() {
      this.field_6201.method_6277(6, new SleepGoal(this, 0.65F));
      this.field_6201.method_6277(5, new class_1374(this, 0.6499999761581421));
      this.field_6201.method_6277(5, new FindHomeGoal(this, 32, 40));
      this.field_6201.method_6277(4, new class_1394(this, 0.5));
      this.field_6201.method_6277(3, new class_1376(this));
      this.field_6201.method_6277(2, new class_1361(this, class_1657.class, 6.0F));
      this.field_6201.method_6277(1, new class_4255(this, true));
      super.method_5959();
   }

   public void method_5652(class_2487 nbt) {
      super.method_5652(nbt);
      nbt.method_10566("home", class_2512.method_10692(this.getHome()));
   }

   public void method_5749(class_2487 nbt) {
      super.method_5749(nbt);
      this.setHome(class_2512.method_10691(nbt.method_10562("home")));
   }

   public class_1269 method_5992(class_1657 player, class_1268 hand) {
      class_1799 itemStack = player.method_5998(hand);
      if (!itemStack.method_31574(class_1802.field_8086) && this.method_5805() && !this.method_18009() && !this.method_6109()) {
         if (hand == class_1268.field_5808) {
            player.method_7281(class_3468.field_15384);
         }

         if (this.method_8264().isEmpty()) {
            return class_1269.method_29236(this.method_37908().field_9236);
         } else {
            if (!this.method_37908().field_9236) {
               this.method_8259(player);
               this.method_17449(player, this.method_5476(), 1);
            }

            return class_1269.method_29236(this.method_37908().field_9236);
         }
      } else {
         return super.method_5992(player, hand);
      }
   }

   protected void method_18008(class_1914 offer) {
      if (offer.method_8256()) {
         int i = 3 + this.field_5974.method_43048(4);
         this.method_37908().method_8649(new class_1303(this.method_37908(), this.method_23317(), this.method_23318() + 0.5, this.method_23321(), i));
      }

   }

   protected void method_7237() {
      class_3853.class_1652[] factorys = (class_3853.class_1652[])ModTradeOffers.MYSTERIOUS_TRADER_TRADES.get(1);
      if (factorys != null) {
         class_1916 tradeOfferList = this.method_8264();
         this.method_19170(tradeOfferList, factorys, 3);
      }
   }

   public @Nullable class_1296 method_5613(class_3218 world, class_1296 entity) {
      return null;
   }

   public boolean method_5947() {
      return true;
   }

   public void setHome(class_2338 home) {
      this.bed = home;
   }

   public class_2338 getHome() {
      return this.bed;
   }
}
