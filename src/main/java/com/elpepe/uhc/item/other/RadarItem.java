package com.elpepe.uhc.item.other;

import com.elpepe.uhc.item.ModItems;
import com.elpepe.uhc.item.armor.custom.AirtagItem;
import net.minecraft.class_124;
import net.minecraft.class_1268;
import net.minecraft.class_1271;
import net.minecraft.class_1304;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_4051;

public class RadarItem extends class_1792 {
   public RadarItem(class_1792.class_1793 settings) {
      super(settings);
   }

   public class_1271<class_1799> method_7836(class_1937 world, class_1657 user, class_1268 hand) {
      if (!world.method_8608()) {
         class_1799 stack = user.method_5998(hand);
         class_1657 nearestPlayer = world.method_18462(class_4051.field_18092.method_18420((entity) -> {
            return entity instanceof class_1657 && !((class_1657)entity).method_7325() && !((class_1657)entity).method_7337();
         }), user);
         if (nearestPlayer != null) {
            class_1799 nearestHeadStack = nearestPlayer.method_6118(class_1304.field_6169);
            class_243 nearestPos = nearestPlayer.method_19538();
            if (nearestHeadStack.method_31574(ModItems.AIRTAG)) {
               AirtagItem.onDetected(nearestPlayer, nearestHeadStack);
            }

            user.method_43496(class_2561.method_43471("item_message.uhc.radar_item_found_player").method_10852(class_2561.method_43470("X: " + nearestPos.field_1352 + "Y: " + nearestPos.field_1351 + "Z: " + nearestPos.field_1350).method_27692(class_124.field_1065)));
         } else {
            user.method_43496(class_2561.method_43471("item_message.uhc.radar_item_player_not_found"));
         }

         stack.method_7956(1, user, (entity) -> {
            entity.method_20236(hand);
         });
         user.method_7357().method_7906(this, 40);
      }

      return super.method_7836(world, user, hand);
   }
}
