package com.elpepe.uhc.enchantment;

import com.elpepe.uhc.util.ServerUtils;
import java.util.List;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1799;
import net.minecraft.class_1886;
import net.minecraft.class_1887;
import net.minecraft.class_1937;
import net.minecraft.class_238;
import net.minecraft.class_2487;
import net.minecraft.class_2561;
import net.minecraft.class_3218;
import net.minecraft.class_3417;
import net.minecraft.class_3419;

public class CreepEnchantment extends class_1887 {
   private static final String NBT_KEY = "creepEnchantmentHits";

   public CreepEnchantment(class_1887.class_1888 weight, class_1304... slotTypes) {
      super(weight, class_1886.field_9074, slotTypes);
   }

   public void method_8189(class_1309 user, class_1297 target, int level) {
      if (!user.method_37908().method_8608()) {
         class_1799 stack = user.method_5998(class_1268.field_5808);
         class_2487 nbt = stack.method_7948();
         if (nbt.method_10550("creepEnchantmentHits") >= 10) {
            this.explode(user, target, user.method_37908());
            nbt.method_10569("creepEnchantmentHits", 0);
         } else {
            user.method_43496(class_2561.method_43470("increased"));
            nbt.method_10569("creepEnchantmentHits", nbt.method_10550("creepEnchantmentHits") + 1);
         }
      }

   }

   private void explode(class_1309 user, class_1297 target, class_1937 world) {
      class_3218 serverWorld = (class_3218)world;
      ServerUtils.playSound(serverWorld, class_3417.field_15152, class_3419.field_15250, 15.0, user.method_23317(), user.method_23318(), user.method_23321(), 1.0F, 1.0F);
      List<class_1297> affectedEntities = world.method_8333(user, new class_238(target.method_19538().method_1023(4.0, 4.0, 4.0), target.method_19538().method_1031(4.0, 4.0, 4.0)), (entity) -> {
         return entity.method_5709();
      });
      affectedEntities.forEach((entity) -> {
         if (entity instanceof class_1309 livingEntity) {
            livingEntity.method_5643(user.method_48923().method_48819(entity, user), 9.0F);
         }

      });
   }
}
