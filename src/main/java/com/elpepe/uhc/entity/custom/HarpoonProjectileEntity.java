package com.elpepe.uhc.entity.custom;

import com.elpepe.uhc.entity.ModEntities;
import java.util.List;
import java.util.UUID;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1665;
import net.minecraft.class_1675;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2940;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_3218;
import net.minecraft.class_3965;
import net.minecraft.class_3966;
import net.minecraft.class_4970;
import net.minecraft.class_239.class_240;

public class HarpoonProjectileEntity extends class_1665 {
   private static final List<class_1299<?>> BIG_ENTITIES;
   private static final class_2940<Integer> CAN_FLY;
   private static final class_2940<Integer> FLEW;
   private class_1799 heldItem;
   private class_243 moveDirection;
   private boolean goesBackwards;
   private UUID caughtEntityUUID;

   public HarpoonProjectileEntity(class_1299<? extends class_1665> entityType, class_1937 world) {
      super(entityType, world);
   }

   public HarpoonProjectileEntity(class_1937 world, class_1657 player, class_1799 heldItem) {
      super(ModEntities.HARPOON_PROJECTILE, world);
      this.method_7432(player);
      this.heldItem = heldItem;
      this.moveDirection = player.method_5720();
      this.goesBackwards = false;
      this.caughtEntityUUID = null;
      this.method_5808(player.method_23317(), player.method_23318() + 1.75, player.method_23321(), this.method_36454(), this.method_36455());
      this.heldItem.method_7948().method_10567("shooting", (byte)1);
   }

   public void method_5773() {
      super.method_5773();
      if (this.field_7588 || this.field_6012 > 300) {
         this.method_31472();
      }

      if (!this.method_37908().method_8608()) {
         if (this.method_24921() != null) {
            ((class_1309)this.method_24921()).method_6092(new class_1293(class_1294.field_5909, 5, 100, false, false, false));
            this.setOwnerVelocity(new class_243(0.0, this.method_24921().method_24828() ? 0.0 : this.method_24921().method_18798().method_10214(), 0.0));
            ((class_1657)this.method_24921()).method_7357().method_7906(this.heldItem.method_7909(), 100);
         }

         if (this.getFlew() >= this.getCanFly() && this.goesBackwards) {
            this.method_31472();
         } else if (this.getFlew() >= this.getCanFly() && !this.goesBackwards) {
            this.goesBackwards = true;
            this.setFlew(0);
         }

         if (this.moveDirection != null) {
            int direction = this.goesBackwards ? -1 : 1;
            class_243 vec = this.moveDirection.method_1021(0.35).method_1021((double)direction);
            this.method_18799(vec);
            if (this.caughtEntityUUID != null) {
               class_1937 var4 = this.method_37908();
               if (var4 instanceof class_3218) {
                  class_3218 serverWorld = (class_3218)var4;
                  class_1297 entity = serverWorld.method_14190(this.caughtEntityUUID);
                  if (entity instanceof class_1309) {
                     entity.method_18799(vec.method_18805(1.0, 0.0, 1.0));
                     entity.field_6037 = true;
                  }
               }
            }
         }
      }

      class_239 hitresult = class_1675.method_49997(this, (x$0) -> {
         return this.method_26958(x$0);
      });
      if (hitresult.method_17783() != class_240.field_1333) {
         this.method_7488(hitresult);
      }

      this.method_26962();
      if (this.method_37908().method_29546(this.method_5829()).noneMatch(class_4970.class_4971::method_26215)) {
         this.method_31472();
      } else if (this.method_5816()) {
         this.method_31472();
      }

      this.setFlew(this.getFlew() + 1);
   }

   protected void method_7454(class_3966 entityHitResult) {
      if (!this.method_37908().method_8608()) {
         if (this.method_24921() == null) {
            this.method_31472();
         }

         if (entityHitResult.method_17782() == this.method_24921()) {
            return;
         }

         if (!this.goesBackwards) {
            entityHitResult.method_17782().method_5643(this.method_48923().method_48803(this, this.method_24921()), 2.0F);
         }

         if (BIG_ENTITIES.contains(entityHitResult.method_17782().method_5864())) {
            this.caughtEntityUUID = this.method_24921().method_5667();
            this.moveDirection = this.moveDirection.method_1021(-1.0);
            this.method_5648(true);
            this.method_20620(this.method_24921().method_23317(), this.method_24921().method_23318() + 1.75, this.method_24921().method_23321());
         } else {
            this.caughtEntityUUID = entityHitResult.method_17782().method_5667();
         }

         this.setCanFly(this.getFlew());
         this.setFlew(0);
         this.goesBackwards = true;
      }

   }

   protected void method_24920(class_3965 blockHitResult) {
      if (this.method_24921() != null && !this.method_37908().method_8608()) {
         class_243 vec = blockHitResult.method_17784().method_1020(this.method_24921().method_19538()).method_1029();
         this.setOwnerVelocity(vec.method_18805(2.5, 1.0, 2.5));
      }

      this.method_31472();
   }

   private void setOwnerVelocity(class_243 velocity) {
      if (this.method_24921() != null) {
         this.method_24921().method_18799(velocity);
         this.method_24921().field_6037 = true;
      }

   }

   public void setCanFly(int canFly) {
      this.field_6011.method_12778(CAN_FLY, canFly);
   }

   public void setFlew(int flew) {
      this.field_6011.method_12778(FLEW, flew);
   }

   public int getCanFly() {
      return (Integer)this.field_6011.method_12789(CAN_FLY);
   }

   public int getFlew() {
      return (Integer)this.field_6011.method_12789(FLEW);
   }

   protected void method_5693() {
      super.method_5693();
      this.field_6011.method_12784(CAN_FLY, 0);
      this.field_6011.method_12784(FLEW, 0);
   }

   protected class_1799 method_7445() {
      return class_1799.field_8037;
   }

   public boolean method_5740() {
      return true;
   }

   public void method_36209() {
      this.heldItem.method_7948().method_10567("shooting", (byte)0);
      super.method_36209();
   }

   static {
      BIG_ENTITIES = List.of(class_1299.field_6147, class_1299.field_6146, class_1299.field_6042, class_1299.field_21973, class_1299.field_23696, class_1299.field_42622, class_1299.field_40116, class_1299.field_6116, class_1299.field_6119, class_1299.field_6134);
      CAN_FLY = class_2945.method_12791(HarpoonProjectileEntity.class, class_2943.field_13327);
      FLEW = class_2945.method_12791(HarpoonProjectileEntity.class, class_2943.field_13327);
   }
}
