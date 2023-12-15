package com.elpepe.uhc.entity.goal;

import net.minecraft.class_1314;
import net.minecraft.class_1352;
import net.minecraft.class_2338;
import net.minecraft.class_3481;

public class SleepGoal<E extends class_1314 & EntityWithHome> extends class_1352 {
   private final E entity;
   private final float speed;
   private boolean reached;

   public SleepGoal(E entity, float speed) {
      this.entity = entity;
      this.speed = speed;
   }

   public boolean method_6264() {
      return this.entity.method_37908().method_23886() && ((EntityWithHome)this.entity).getHome() != class_2338.field_10980 && this.entity.method_37908().method_8320(((EntityWithHome)this.entity).getHome()).method_26164(class_3481.field_16443);
   }

   public double getDesiredDistanceToTarget() {
      return 2.0;
   }

   public void method_6268() {
      class_2338 pos = ((EntityWithHome)this.entity).getHome();
      boolean withinDistance = pos.method_10084().method_19769(this.entity.method_19538(), this.getDesiredDistanceToTarget());
      if (!withinDistance) {
         this.reached = false;
         this.entity.method_5942().method_6337((double)pos.method_10263(), (double)pos.method_10264(), (double)pos.method_10260(), (double)this.speed);
      } else {
         this.reached = true;
         this.entity.method_18403(((EntityWithHome)this.entity).getHome());
      }

      super.method_6268();
   }

   public void method_6270() {
      super.method_6270();
      this.reached = false;
      this.entity.method_18400();
   }

   public boolean method_38846() {
      return true;
   }
}
