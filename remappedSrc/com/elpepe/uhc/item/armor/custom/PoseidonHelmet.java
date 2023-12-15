package com.elpepe.uhc.item.armor.custom;

import com.elpepe.uhc.item.armor.TickableArmor;
import java.util.List;
import net.minecraft.class_124;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1309;
import net.minecraft.class_1738;
import net.minecraft.class_1741;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1836;
import net.minecraft.class_1937;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_437;
import org.jetbrains.annotations.Nullable;

public class PoseidonHelmet extends class_1738 implements TickableArmor {
   public PoseidonHelmet(class_1741 material, class_1738.class_8051 type, class_1792.class_1793 settings) {
      super(material, type, settings);
   }

   public void tick(class_1309 user) {
      class_1937 world = user.method_37908();
      if (!world.method_8608() && user.method_5721()) {
         user.method_6092(new class_1293(class_1294.field_5923, 5, 0, true, false, false));
         user.method_6092(new class_1293(class_1294.field_5900, 5, 0, true, false, false));
         user.method_6092(new class_1293(class_1294.field_5927, 5, 0, true, false, false));
         user.method_6092(new class_1293(class_1294.field_5910, 5, 0, true, false, false));
         user.method_6092(new class_1293(class_1294.field_5904, 5, 0, true, false, false));
      }

   }

   public void method_7851(class_1799 stack, @Nullable class_1937 world, List<class_2561> tooltip, class_1836 context) {
      if (class_437.method_25442()) {
         class_2583 style = class_2583.field_24360.method_10977(class_124.field_1075);
         tooltip.add(class_2561.method_43471("tooltip.uhc.poseidon_helmet").method_10862(style));
      } else {
         tooltip.add(class_2561.method_43469("tooltip.uhc.press_for_info", new Object[]{""}));
      }

      super.method_7851(stack, world, tooltip, context);
   }
}
