package com.elpepe.uhc.entity.goal;

import net.minecraft.class_1352;

public abstract class IntervalGoal extends class_1352 {
   protected int cooldown;

   public IntervalGoal() {
   }

   public boolean method_6264() {
      if (this.cooldown > 0) {
         --this.cooldown;
         return false;
      } else {
         this.cooldown = this.getInterval();
         return true;
      }
   }

   public boolean method_38846() {
      return true;
   }

   protected abstract int getInterval();
}
