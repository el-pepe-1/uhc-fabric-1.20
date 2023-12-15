package com.elpepe.uhc.entity.custom;

import com.elpepe.uhc.entity.ModEntities;
import com.elpepe.uhc.entity.goal.EntityWithHome;
import com.elpepe.uhc.entity.goal.FindHomeGoal;
import com.elpepe.uhc.entity.goal.SleepGoal;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1361;
import net.minecraft.class_1376;
import net.minecraft.class_1394;
import net.minecraft.class_1588;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_5132;
import net.minecraft.class_5134;

public class GoblinEntity extends class_1588 implements EntityWithHome {
   private class_2338 home;

   public GoblinEntity(class_1299<? extends class_1588> entityType, class_1937 world) {
      super(entityType, world);
      this.home = class_2338.field_10980;
   }

   public GoblinEntity(class_1937 world) {
      super(ModEntities.GOBLIN_ENTITY, world);
      this.home = class_2338.field_10980;
   }

   public static class_5132.class_5133 createGoblinAttributes() {
      return class_1308.method_26828().method_26868(class_5134.field_23716, 20.0).method_26868(class_5134.field_23719, 0.5).method_26868(class_5134.field_23724, 0.5).method_26868(class_5134.field_23721, 1.0).method_26868(class_5134.field_23717, 48.0);
   }

   protected void method_5959() {
      this.field_6201.method_6277(5, new SleepGoal(this, 0.5F));
      this.field_6201.method_6277(4, new FindHomeGoal(this, 32, 40));
      this.field_6201.method_6277(3, new class_1394(this, 0.5));
      this.field_6201.method_6277(2, new class_1376(this));
      this.field_6201.method_6277(1, new class_1361(this, class_1657.class, 6.0F));
      super.method_5959();
   }

   public void setHome(class_2338 home) {
      this.home = home;
   }

   public class_2338 getHome() {
      return this.home;
   }
}
