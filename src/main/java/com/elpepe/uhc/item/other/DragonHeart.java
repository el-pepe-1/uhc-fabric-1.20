package com.elpepe.uhc.item.other;

import com.elpepe.uhc.util.IEntityDataSaver;
import com.elpepe.uhc.util.UhcLivesData;
import net.minecraft.class_1268;
import net.minecraft.class_1271;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_3222;

public class DragonHeart extends class_1792 {
   public DragonHeart(class_1792.class_1793 settings) {
      super(settings);
   }

   public class_1271<class_1799> method_7836(class_1937 world, class_1657 user, class_1268 hand) {
      if (!world.method_8608()) {
         class_1799 stack = user.method_5998(hand);
         UhcLivesData.setLives((class_3222)user, UhcLivesData.getLives((IEntityDataSaver)user) + 3);
         stack.method_7956(1, user, (entity) -> {
            entity.method_20236(hand);
         });
      }

      return super.method_7836(world, user, hand);
   }

   public boolean method_7870(class_1799 stack) {
      return false;
   }
}
