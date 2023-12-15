package com.elpepe.uhc.world;

import java.util.List;
import net.minecraft.class_5450;
import net.minecraft.class_6792;
import net.minecraft.class_6793;
import net.minecraft.class_6797;
import net.minecraft.class_6799;

public class ModOrePlacement {
   public ModOrePlacement() {
   }

   public static List<class_6797> modifiers(class_6797 countModifier, class_6797 heightModifier) {
      return List.of(countModifier, class_5450.method_39639(), heightModifier, class_6792.method_39614());
   }

   public static List<class_6797> modifiersWithCount(int count, class_6797 heightModifier) {
      return modifiers(class_6793.method_39623(count), heightModifier);
   }

   public static List<class_6797> modifiersWithRarity(int chance, class_6797 heightModifier) {
      return modifiers(class_6799.method_39659(chance), heightModifier);
   }
}
