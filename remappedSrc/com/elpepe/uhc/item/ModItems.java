package com.elpepe.uhc.item;

import com.elpepe.uhc.Uhc;
import com.elpepe.uhc.entity.ModEntities;
import com.elpepe.uhc.item.armor.EffectArmor;
import com.elpepe.uhc.item.armor.ModArmorMaterials;
import com.elpepe.uhc.item.armor.custom.AirtagItem;
import com.elpepe.uhc.item.armor.custom.DeathrunLeggings;
import com.elpepe.uhc.item.armor.custom.MagmaBoots;
import com.elpepe.uhc.item.armor.custom.NightVisionHelmetItem;
import com.elpepe.uhc.item.armor.custom.PoseidonHelmet;
import com.elpepe.uhc.item.armor.custom.SlimeBoots;
import com.elpepe.uhc.item.food.GlowBerriesJam;
import com.elpepe.uhc.item.food.JamFood;
import com.elpepe.uhc.item.food.ModFoodComponents;
import com.elpepe.uhc.item.food.RavagerMeat;
import com.elpepe.uhc.item.other.CastIronCauldronBlockItem;
import com.elpepe.uhc.item.other.DragonHeart;
import com.elpepe.uhc.item.other.HealthJar;
import com.elpepe.uhc.item.other.RadarItem;
import com.elpepe.uhc.item.tool.HarpoonItem;
import com.elpepe.uhc.item.tool.ModToolMaterial;
import com.elpepe.uhc.item.weapon.LavaSword;
import com.elpepe.uhc.item.weapon.SharpEmeraldSword;
import java.util.List;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.class_124;
import net.minecraft.class_1294;
import net.minecraft.class_1738;
import net.minecraft.class_1743;
import net.minecraft.class_1756;
import net.minecraft.class_1792;
import net.minecraft.class_1794;
import net.minecraft.class_1810;
import net.minecraft.class_1821;
import net.minecraft.class_1826;
import net.minecraft.class_1829;
import net.minecraft.class_2378;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_7923;
import net.minecraft.class_8052;
import net.minecraft.class_1738.class_8051;

public class ModItems {
   public static final List<class_2960> armorTrimEmptyBaseSlotTextures = List.of(new class_2960("item/empty_armor_slot_helmet"), new class_2960("item/empty_armor_slot_chestplate"), new class_2960("item/empty_armor_slot_leggings"), new class_2960("item/empty_armor_slot_boots"));
   public static final List<class_2960> armorTrimEmptyAdditionsSlotTextures = List.of(new class_2960("item/empty_slot_ingot"), new class_2960("item/empty_slot_redstone_dust"), new class_2960("item/empty_slot_quartz"), new class_2960("item/empty_slot_emerald"), new class_2960("item/empty_slot_diamond"), new class_2960("item/empty_slot_lapis_lazuli"), new class_2960("item/empty_slot_amethyst_shard"));
   public static final class_2561 APPLIES_TO;
   public static final class_2561 INGREDIENTS;
   public static final class_2561 BASE_SLOT_DESC;
   public static final class_2561 ADDITIONS_SLOT_DESC;
   public static final class_124 DESC_FORMATTING;
   public static final class_1792 RAW_NITHRIL;
   public static final class_1792 NITHRIL_INGOT;
   public static final class_1792 NITHRIL_PLATE;
   public static final class_1792 RUBY;
   public static final class_1792 SHARP_STONE;
   public static final class_1792 BLOODY_JAR;
   public static final class_1792 HEALTH_JAR;
   public static final class_1792 RUBY_TOTEM;
   public static final class_1792 RADAR;
   public static final class_1792 DRAGON_HEART;
   public static final class_1792 HARPOON;
   public static final class_1792 LAVA_SWORD;
   public static final class_1792 EMERALD_SWORD;
   public static final class_1792 SHARP_EMERALD_SWORD;
   public static final class_1792 DRAGON_PICKAXE;
   public static final class_1792 NETHERITE_COVERED_DRAGON_PICKAXE;
   public static final class_1792 NIGHT_VISION_HELMET;
   public static final class_1792 AIRTAG;
   public static final class_1792 POSEIDON_HELMET;
   public static final class_1792 FEATHER_BOOTS;
   public static final class_1792 SLIME_BOOTS;
   public static final class_1792 DEATHRUN_LEGGINGS;
   public static final class_1792 MAGMA_BOOTS;
   public static final class_1792 SWEET_BERRIES_JAM;
   public static final class_1792 GLOW_BERRIES_JAM;
   public static final class_1792 POISONOUS_SOUP;
   public static final class_1792 SEAFOOD_SOUP;
   public static final class_1792 GOAT_MEAT;
   public static final class_1792 COOKED_GOAT_MEAT;
   public static final class_1792 HORSE_LIKE_MEAT;
   public static final class_1792 COOKED_HORSE_LIKE_MEAT;
   public static final class_1792 LLAMA_MEAT;
   public static final class_1792 COOKED_LLAMA_MEAT;
   public static final class_1792 RAVAGER_MEAT;
   public static final class_1792 COOKED_RAVAGER_MEAT;
   public static final class_1792 CAST_IRON_CAULDRON_BLOCK_ITEM;
   public static final class_1792 EARTHQUAKE_ARMOR_TRIM_SMITHING_TEMPLATE;
   public static final class_1792 GOBLIN_SPAWN_EGG;
   public static final class_1792 MYSTERIOUS_TRADER_SPAWN_EGG;
   public static final class_1792 NITHRIL_HELMET;
   public static final class_1792 NITHRIL_CHESTPLATE;
   public static final class_1792 NITHRIL_LEGGINGS;
   public static final class_1792 NITHRIL_BOOTS;
   public static final class_1792 NITHRIL_SWORD;
   public static final class_1792 NITHRIL_PICKAXE;
   public static final class_1792 NITHRIL_AXE;
   public static final class_1792 NITHRIL_SHOVEL;
   public static final class_1792 NITHRIL_HOE;

   public ModItems() {
   }

   private static class_1792 registerItem(String name, class_1792 item) {
      return (class_1792)class_2378.method_10230(class_7923.field_41178, new class_2960("uhc", name), item);
   }

   public static void registerModItems() {
      Uhc.LOGGER.debug("Registering Mod Items for uhc");
   }

   static {
      APPLIES_TO = class_2561.method_43471("item.minecraft.smithing_template.armor_trim.applies_to").method_27692(class_124.field_1078);
      INGREDIENTS = class_2561.method_43471("item.minecraft.smithing_template.armor_trim.ingredients").method_27692(class_124.field_1078);
      BASE_SLOT_DESC = class_2561.method_43471("item.minecraft.smithing_template.armor_trim.base_slot_description");
      ADDITIONS_SLOT_DESC = class_2561.method_43471("item.minecraft.smithing_template.armor_trim.additions_slot_description");
      DESC_FORMATTING = class_124.field_1080;
      RAW_NITHRIL = registerItem("raw_nithril", new class_1792(new FabricItemSettings()));
      NITHRIL_INGOT = registerItem("nithril_ingot", new class_1792(new FabricItemSettings()));
      NITHRIL_PLATE = registerItem("nithril_plate", new class_1792(new FabricItemSettings()));
      RUBY = registerItem("ruby", new class_1792(new FabricItemSettings()));
      SHARP_STONE = registerItem("stone_of_sharpness", new class_1792((new FabricItemSettings()).maxCount(1)));
      BLOODY_JAR = registerItem("bloody_jar", new class_1792((new FabricItemSettings()).maxCount(16)));
      HEALTH_JAR = registerItem("health_jar", new HealthJar((new FabricItemSettings()).maxCount(1)));
      RUBY_TOTEM = registerItem("ruby_totem", new class_1792((new FabricItemSettings()).maxCount(1).maxDamage(2)));
      RADAR = registerItem("radar", new RadarItem((new FabricItemSettings()).maxCount(1).maxDamage(3)));
      DRAGON_HEART = registerItem("dragon_heart", new DragonHeart((new FabricItemSettings()).maxDamage(1)));
      HARPOON = registerItem("harpoon", new HarpoonItem((new FabricItemSettings()).maxCount(1)));
      LAVA_SWORD = registerItem("lava_sword", new LavaSword(ModToolMaterial.LAVA, 0, -2.4F, new FabricItemSettings()));
      EMERALD_SWORD = registerItem("emerald_sword", new class_1829(ModToolMaterial.EMERALD, 0, -2.3F, new FabricItemSettings()));
      SHARP_EMERALD_SWORD = registerItem("sharp_emerald_sword", new SharpEmeraldSword(ModToolMaterial.EMERALD, 4, -2.3F, new FabricItemSettings()));
      DRAGON_PICKAXE = registerItem("dragon_pickaxe", new class_1810(ModToolMaterial.DRAGON, -1, -2.8F, new FabricItemSettings()));
      NETHERITE_COVERED_DRAGON_PICKAXE = registerItem("netherite_covered_dragon_pickaxe", new class_1810(ModToolMaterial.DRAGON, -1, -2.8F, (new FabricItemSettings()).fireproof()));
      NIGHT_VISION_HELMET = registerItem("night_vision_helmet", (new NightVisionHelmetItem(ModArmorMaterials.NIGHT_VISION, class_8051.field_41934, new FabricItemSettings())).addArmorEffect(new EffectArmor.ArmorEffect(class_1294.field_5925, 260, 0)));
      AIRTAG = registerItem("airtag", new AirtagItem(ModArmorMaterials.AIRTAG, class_8051.field_41934, new FabricItemSettings()));
      POSEIDON_HELMET = registerItem("poseidon_helmet", new PoseidonHelmet(ModArmorMaterials.POSEIDON, class_8051.field_41934, new FabricItemSettings()));
      FEATHER_BOOTS = registerItem("feather_boots", (new EffectArmor(ModArmorMaterials.FEATHER, class_8051.field_41937, new FabricItemSettings())).addArmorEffect(class_1294.field_5906, 1).addTooltip("tooltip.uhc.feather_boots"));
      SLIME_BOOTS = registerItem("slime_boots", (new SlimeBoots(ModArmorMaterials.SLIME, class_8051.field_41937, new FabricItemSettings())).addArmorEffect(class_1294.field_5913, 3).addTooltip("tooltip.uhc.slime_boots"));
      DEATHRUN_LEGGINGS = registerItem("deathrun_leggings", new DeathrunLeggings(ModArmorMaterials.DEATHRUN, class_8051.field_41936, new FabricItemSettings()));
      MAGMA_BOOTS = registerItem("magma_boots", new MagmaBoots(ModArmorMaterials.MAGMA, class_8051.field_41937, new FabricItemSettings()));
      SWEET_BERRIES_JAM = registerItem("sweet_berries_jam", new JamFood((new FabricItemSettings()).maxCount(4).food(ModFoodComponents.SWEET_BERRIES_JAM)));
      GLOW_BERRIES_JAM = registerItem("glow_berries_jam", new GlowBerriesJam((new FabricItemSettings()).maxCount(4).food(ModFoodComponents.GLOW_BERRIES_JAM)));
      POISONOUS_SOUP = registerItem("poisonous_soup", new class_1756((new FabricItemSettings()).maxCount(4).food(ModFoodComponents.POISONOUS_SOUP)));
      SEAFOOD_SOUP = registerItem("seafood_soup", new class_1756((new FabricItemSettings()).maxCount(4).food(ModFoodComponents.SEAFOOD_SOUP)));
      GOAT_MEAT = registerItem("goat_meat", new class_1792((new FabricItemSettings()).food(ModFoodComponents.GOAT_MEAT)));
      COOKED_GOAT_MEAT = registerItem("cooked_goat_meat", new class_1792((new FabricItemSettings()).food(ModFoodComponents.COOKED_GOAT_MEAT)));
      HORSE_LIKE_MEAT = registerItem("horse_like_meat", new class_1792((new FabricItemSettings()).food(ModFoodComponents.HORSE_LIKE_MEAT)));
      COOKED_HORSE_LIKE_MEAT = registerItem("cooked_horse_like_meat", new class_1792((new FabricItemSettings()).food(ModFoodComponents.COOKED_HORSE_LIKE_MEAT)));
      LLAMA_MEAT = registerItem("llama_meat", new class_1792((new FabricItemSettings()).food(ModFoodComponents.LLAMA_MEAT)));
      COOKED_LLAMA_MEAT = registerItem("cooked_llama_meat", new class_1792((new FabricItemSettings()).food(ModFoodComponents.COOKED_LLAMA_MEAT)));
      RAVAGER_MEAT = registerItem("ravager_meat", new RavagerMeat((new FabricItemSettings()).food(ModFoodComponents.RAVAGER_MEAT)));
      COOKED_RAVAGER_MEAT = registerItem("cooked_ravager_meat", new RavagerMeat((new FabricItemSettings()).food(ModFoodComponents.COOKED_RAVAGER_MEAT)));
      CAST_IRON_CAULDRON_BLOCK_ITEM = registerItem("cast_iron_cauldron", new CastIronCauldronBlockItem(new FabricItemSettings(), 2.0F));
      EARTHQUAKE_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("earthquake_armor_trim_smithing_template", new class_8052(APPLIES_TO, INGREDIENTS, class_2561.method_43471("trim_pattern.uhc.earthquake").method_27692(DESC_FORMATTING), BASE_SLOT_DESC, ADDITIONS_SLOT_DESC, armorTrimEmptyBaseSlotTextures, armorTrimEmptyAdditionsSlotTextures));
      GOBLIN_SPAWN_EGG = registerItem("goblin_spawn_egg", new class_1826(ModEntities.GOBLIN_ENTITY, 4762932, 13825987, new FabricItemSettings()));
      MYSTERIOUS_TRADER_SPAWN_EGG = registerItem("mysterious_trader_spawn_egg", new class_1826(ModEntities.MYSTERIOUS_TRADER, 14358031, 11347203, new FabricItemSettings()));
      NITHRIL_HELMET = registerItem("nithril_helmet", new class_1738(ModArmorMaterials.NITHRIL, class_8051.field_41934, new FabricItemSettings()));
      NITHRIL_CHESTPLATE = registerItem("nithril_chestplate", new class_1738(ModArmorMaterials.NITHRIL, class_8051.field_41935, new FabricItemSettings()));
      NITHRIL_LEGGINGS = registerItem("nithril_leggings", new class_1738(ModArmorMaterials.NITHRIL, class_8051.field_41936, new FabricItemSettings()));
      NITHRIL_BOOTS = registerItem("nithril_boots", new class_1738(ModArmorMaterials.NITHRIL, class_8051.field_41937, new FabricItemSettings()));
      NITHRIL_SWORD = registerItem("nithril_sword", new class_1829(ModToolMaterial.NITHRIL, 5, -2.4F, new FabricItemSettings()));
      NITHRIL_PICKAXE = registerItem("nithril_pickaxe", new class_1810(ModToolMaterial.NITHRIL, 3, -2.8F, new FabricItemSettings()));
      NITHRIL_AXE = registerItem("nithril_axe", new class_1743(ModToolMaterial.NITHRIL, 8.0F, -3.0F, new FabricItemSettings()));
      NITHRIL_SHOVEL = registerItem("nithril_shovel", new class_1821(ModToolMaterial.NITHRIL, 2.0F, -3.0F, new FabricItemSettings()));
      NITHRIL_HOE = registerItem("nithril_hoe", new class_1794(ModToolMaterial.NITHRIL, -1, 0.0F, new FabricItemSettings()));
   }
}
