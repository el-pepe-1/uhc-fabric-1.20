package com.elpepe.uhc.item.food;

import java.util.Iterator;
import java.util.List;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1937;

public class GlowBerriesJam extends JamFood {
   public GlowBerriesJam(class_1792.class_1793 settings) {
      super(settings);
   }

   public class_1799 method_7861(class_1799 stack, class_1937 world, class_1309 user) {
      List<class_1297> entities = world.method_8333(user, user.method_5829().method_989(0.0, -1.5, 0.0).method_1014(25.0), (entityx) -> {
         return entityx instanceof class_1309;
      });
      Iterator var5 = entities.iterator();

      while(var5.hasNext()) {
         class_1297 entity = (class_1297)var5.next();
         if (entity instanceof class_1309 livingEntity) {
            livingEntity.method_6092(new class_1293(class_1294.field_5912, 200, 0, true, false, false));
         }
      }

      return super.method_7861(stack, world, user);
   }
}
