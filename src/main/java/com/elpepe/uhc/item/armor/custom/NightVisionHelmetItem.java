package com.elpepe.uhc.item.armor.custom;

import com.elpepe.uhc.item.armor.EffectArmor;
import java.util.List;
import net.minecraft.class_124;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1738;
import net.minecraft.class_1741;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1836;
import net.minecraft.class_1937;
import net.minecraft.class_2561;
import net.minecraft.class_437;
import org.jetbrains.annotations.Nullable;

public class NightVisionHelmetItem extends EffectArmor {
   public NightVisionHelmetItem(class_1741 material, class_1738.class_8051 type, class_1792.class_1793 settings) {
      super(material, type, settings);
   }

   public void tick(class_1309 user) {
      class_1799 stack = user.method_6118(class_1304.field_6169);
      if (isBroken(stack)) {
         user.method_5673(class_1304.field_6169, class_1799.field_8037);
         if (user instanceof class_1657) {
            class_1657 player = (class_1657)user;
            player.method_7270(stack.method_7972());
         }
      }

      if (user.method_6051().method_39332(1, 3) == 3) {
         stack.method_7956(1, user, (entity) -> {
            entity.method_20235(class_1304.field_6169);
         });
      }

      super.tick(user);
   }

   public void method_7851(class_1799 stack, @Nullable class_1937 world, List<class_2561> tooltip, class_1836 context) {
      if (class_437.method_25442()) {
         tooltip.add(class_2561.method_43470("▶ ").method_27692(class_124.field_1065).method_10852(class_2561.method_43471("tooltip.uhc.night_vision_helmet_1")));
         tooltip.add(class_2561.method_43470(" "));
         tooltip.add(class_2561.method_43470("▶ ").method_27692(class_124.field_1065).method_10852(class_2561.method_43471("tooltip.uhc.night_vision_helmet_2")));
      } else {
         tooltip.add(class_2561.method_43471("tooltip.uhc.press_for_info"));
      }

   }

   public static boolean isBroken(class_1799 stack) {
      return stack.method_7919() >= stack.method_7936() - 1;
   }
}
