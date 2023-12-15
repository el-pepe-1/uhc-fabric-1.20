package com.elpepe.uhc.world.biome;

import com.elpepe.uhc.sound.ModSounds;
import com.elpepe.uhc.world.ModPlacedFeature;
import net.minecraft.class_1143;
import net.minecraft.class_1299;
import net.minecraft.class_1311;
import net.minecraft.class_1959;
import net.minecraft.class_2960;
import net.minecraft.class_3864;
import net.minecraft.class_4763;
import net.minecraft.class_4968;
import net.minecraft.class_5321;
import net.minecraft.class_5483;
import net.minecraft.class_5485;
import net.minecraft.class_6880;
import net.minecraft.class_7891;
import net.minecraft.class_7924;
import net.minecraft.class_2893.class_2895;

public class ModBiomes {
   public static final class_5321<class_1959> PURPLE_CLIFFS = register("purple_cliffs");
   public static final class_5321<class_1959> ICY_WASTELAND = register("icy_wasteland");
   public static final class_5321<class_1959> DEAD_FOREST = register("dead_forest");

   public ModBiomes() {
   }

   public static class_5321<class_1959> register(String name) {
      return class_5321.method_29179(class_7924.field_41236, new class_2960("uhc", name));
   }

   public static void bootstrap(class_7891<class_1959> context) {
      context.method_46838(PURPLE_CLIFFS, purpleCliffs(context));
      context.method_46838(DEAD_FOREST, deadForest(context));
      context.method_46838(ICY_WASTELAND, icyWasteland(context));
   }

   public static class_1959 icyWasteland(class_7891<class_1959> context) {
      class_5483.class_5496 spawnBuilder = new class_5483.class_5496();
      spawnBuilder.method_31011(class_1311.field_6302, new class_5483.class_1964(class_1299.field_6098, 5, 1, 4));
      class_5485.class_5495 biomeBuilder = new class_5485.class_5495(context.method_46799(class_7924.field_41245), context.method_46799(class_7924.field_41238));
      biomeBuilder.method_30992(class_2895.field_13179, ModPlacedFeature.BIG_ROCK_PLACED_KEY);
      class_3864.method_16999(biomeBuilder);
      return (new class_1959.class_1960()).method_48164(true).method_8727(0.0F).method_8747(-1.0F).method_30973(biomeBuilder.method_46671()).method_30974(spawnBuilder.method_31007()).method_24379((new class_4763.class_4764()).method_24395(3026478).method_24397(3026478).method_30820(10263708).method_30822(3026478).method_30821(3026478).method_24392(5723991).method_24943(class_4968.field_23146).method_27346(class_1143.method_27283(class_6880.method_40223(ModSounds.AIRTAG_ALARM))).method_24391()).method_30972();
   }

   public static class_1959 deadForest(class_7891<class_1959> context) {
      class_5483.class_5496 spawnBuilder = new class_5483.class_5496();
      class_5485.class_5495 biomeBuilder = new class_5485.class_5495(context.method_46799(class_7924.field_41245), context.method_46799(class_7924.field_41238));
      biomeBuilder.method_30992(class_2895.field_13179, ModPlacedFeature.DEAD_TREE_PLACED_KEY);
      class_3864.method_16999(biomeBuilder);
      return (new class_1959.class_1960()).method_48164(true).method_8727(0.4F).method_8747(-1.0F).method_30973(biomeBuilder.method_46671()).method_30974(spawnBuilder.method_31007()).method_24379((new class_4763.class_4764()).method_24395(3026478).method_24397(3026478).method_30820(986895).method_30822(3026478).method_30821(3026478).method_24392(986895).method_24391()).method_30972();
   }

   public static class_1959 purpleCliffs(class_7891<class_1959> context) {
      class_5483.class_5496 spawnBuilder = new class_5483.class_5496();
      class_5485.class_5495 biomeBuilder = new class_5485.class_5495(context.method_46799(class_7924.field_41245), context.method_46799(class_7924.field_41238));
      class_3864.method_16983(biomeBuilder);
      class_3864.method_16999(biomeBuilder);
      return (new class_1959.class_1960()).method_48164(true).method_8727(2.0F).method_8747(-1.0F).method_30973(biomeBuilder.method_46671()).method_30974(spawnBuilder.method_31007()).method_24379((new class_4763.class_4764()).method_24395(3026478).method_24397(3026478).method_30820(986895).method_30822(3026478).method_30821(3026478).method_24392(986895).method_24391()).method_30972();
   }
}
