package com.elpepe.uhc.entity.goal;

import java.util.Optional;
import net.minecraft.class_1314;
import net.minecraft.class_2338;
import net.minecraft.class_3218;
import net.minecraft.class_3481;
import net.minecraft.class_7477;
import net.minecraft.class_4153.class_4155;

public class FindHomeGoal<E extends class_1314 & EntityWithHome> extends IntervalGoal {
   private final E entity;
   private final int radius;
   private final int interval;

   public FindHomeGoal(E entity, int radius, int interval) {
      this.entity = entity;
      this.radius = radius;
      this.interval = interval;
   }

   public boolean method_6264() {
      return (((EntityWithHome)this.entity).getHome() == class_2338.field_10980 || !this.entity.method_37908().method_8320(((EntityWithHome)this.entity).getHome()).method_26164(class_3481.field_16443)) && super.method_6264();
   }

   public void method_6269() {
      this.tryFindHome();
      super.method_6269();
   }

   protected int getInterval() {
      return this.interval;
   }

   private void tryFindHome() {
      class_3218 serverWorld = (class_3218)this.entity.method_37908();
      class_2338 blockPos = this.entity.method_24515();
      Optional<class_2338> optional = serverWorld.method_19494().method_20005((registryEntry) -> {
         return registryEntry.method_40225(class_7477.field_39291);
      }, (pos) -> {
         return true;
      }, class_4155.field_18487, blockPos, this.radius, this.entity.method_6051());
      if (optional.isEmpty()) {
         ((EntityWithHome)this.entity).setHome(class_2338.field_10980);
      }

      optional.ifPresent((pos) -> {
         ((EntityWithHome)this.entity).setHome(pos.method_10062());
      });
   }
}
