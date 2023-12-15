package com.elpepe.uhc.item.armor.custom;

import com.elpepe.uhc.item.armor.EffectArmor;
import java.util.Random;
import net.minecraft.class_1309;
import net.minecraft.class_1738;
import net.minecraft.class_1741;
import net.minecraft.class_1792;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2388;
import net.minecraft.class_2398;
import net.minecraft.class_243;
import net.minecraft.class_3417;
import net.minecraft.class_3419;

public class SlimeBoots extends EffectArmor {
   public SlimeBoots(class_1741 material, class_1738.class_8051 type, class_1792.class_1793 settings) {
      super(material, type, settings);
   }

   public static void onJump(class_1937 world, class_1309 user) {
      world.method_8486(user.method_23317(), user.method_23318(), user.method_23321(), class_3417.field_15194, class_3419.field_15248, 1.0F, 1.0F, true);
   }

   public static void slimeParticles(class_1937 world, class_243 pos) {
      Random rand = new Random();
      int particlesCount = rand.nextInt(10, 20);

      for(int i = 0; i < particlesCount; ++i) {
         double d = 1.5;
         class_243 vec = new class_243(rand.nextDouble(-d, d), rand.nextDouble(-d, d), rand.nextDouble(-d, d));
         world.method_8406(new class_2388(class_2398.field_11217, class_2246.field_10030.method_9564()), pos.field_1352, pos.field_1351, pos.field_1350, vec.field_1352, vec.field_1351, vec.field_1350);
      }

   }
}
