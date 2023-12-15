package com.elpepe.uhc.item.tool;

import com.elpepe.uhc.entity.custom.HarpoonProjectileEntity;
import java.util.List;
import net.minecraft.class_1268;
import net.minecraft.class_1271;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1836;
import net.minecraft.class_1937;
import net.minecraft.class_2561;
import net.minecraft.class_437;
import org.jetbrains.annotations.Nullable;

public class HarpoonItem extends class_1792 {
   public HarpoonItem(class_1792.class_1793 settings) {
      super(settings);
   }

   public class_1271<class_1799> method_7836(class_1937 world, class_1657 user, class_1268 hand) {
      if (!world.method_8608()) {
         class_1799 stack = user.method_5998(hand);
         HarpoonProjectileEntity projectile = new HarpoonProjectileEntity(world, user, stack);
         projectile.setCanFly(80);
         world.method_8649(projectile);
      }

      user.method_7357().method_7906(this, 20);
      return super.method_7836(world, user, hand);
   }

   public void method_7851(class_1799 stack, @Nullable class_1937 world, List<class_2561> tooltip, class_1836 context) {
      if (class_437.method_25442()) {
         tooltip.add(class_2561.method_43471("tooltip.uhc.harpoon"));
      } else {
         tooltip.add(class_2561.method_43471("tooltip.uhc.press_for_info"));
      }

      super.method_7851(stack, world, tooltip, context);
   }
}
