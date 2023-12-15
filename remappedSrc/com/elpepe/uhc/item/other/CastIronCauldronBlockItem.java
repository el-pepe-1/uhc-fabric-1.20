package com.elpepe.uhc.item.other;

import com.elpepe.uhc.block.ModBlocks;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.class_1304;
import net.minecraft.class_1320;
import net.minecraft.class_1322;
import net.minecraft.class_1747;
import net.minecraft.class_1792;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_5134;
import net.minecraft.class_5151;
import net.minecraft.class_1322.class_1323;

public class CastIronCauldronBlockItem extends class_1747 implements class_5151 {
   private final Multimap<class_1320, class_1322> defaultModifiers;

   public CastIronCauldronBlockItem(class_1792.class_1793 settings, float protection) {
      super(ModBlocks.CAST_IRON_CAULDRON, settings);
      ImmutableMultimap.Builder<class_1320, class_1322> builder = ImmutableMultimap.builder();
      builder.put(class_5134.field_23724, new class_1322("Armor modifier", (double)protection, class_1323.field_6328));
      this.defaultModifiers = builder.build();
   }

   public Multimap<class_1320, class_1322> method_7844(class_1304 slot) {
      return slot == this.method_7685() ? this.defaultModifiers : super.method_7844(slot);
   }

   public class_1304 method_7685() {
      return class_1304.field_6169;
   }

   public class_3414 method_31570() {
      return class_3417.field_14785;
   }
}
