package com.elpepe.uhc.item;

import com.elpepe.uhc.Uhc;
import com.elpepe.uhc.entity.ModEntities;
import com.elpepe.uhc.item.armor.EffectArmorItem;
import com.elpepe.uhc.item.armor.ModArmorMaterials;
import com.elpepe.uhc.item.armor.custom.*;
import com.elpepe.uhc.item.food.GlowBerriesJamItem;
import com.elpepe.uhc.item.food.JamFoodItem;
import com.elpepe.uhc.item.food.ModFoodComponents;
import com.elpepe.uhc.item.food.RavagerMeatItem;
import com.elpepe.uhc.item.other.CastIronCauldronBlockItem;
import com.elpepe.uhc.item.other.DragonHeartItem;
import com.elpepe.uhc.item.other.HealthJarItem;
import com.elpepe.uhc.item.other.RadarItem;
import com.elpepe.uhc.item.tool.HarpoonItem;
import com.elpepe.uhc.item.tool.ModToolMaterial;
import com.elpepe.uhc.item.weapon.LavaSwordItem;
import com.elpepe.uhc.item.weapon.SharpEmeraldSwordItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.item.ArmorItem.Type;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    public static final List<Identifier> armorTrimEmptyBaseSlotTextures = List.of(
            new Identifier("item/empty_armor_slot_helmet"),
            new Identifier("item/empty_armor_slot_chestplate"),
            new Identifier("item/empty_armor_slot_leggings"),
            new Identifier("item/empty_armor_slot_boots")
    );
    public static final List<Identifier> armorTrimEmptyAdditionsSlotTextures = List.of(
            new Identifier("item/empty_slot_ingot"),
            new Identifier("item/empty_slot_redstone_dust"),
            new Identifier("item/empty_slot_quartz"),
            new Identifier("item/empty_slot_emerald"),
            new Identifier("item/empty_slot_diamond"),
            new Identifier("item/empty_slot_lapis_lazuli"),
            new Identifier("item/empty_slot_amethyst_shard")
    );

    public static final Text APPLIES_TO = Text.translatable("item.minecraft.smithing_template.armor_trim.applies_to").formatted(Formatting.BLUE);
    public static final Text INGREDIENTS = Text.translatable("item.minecraft.smithing_template.armor_trim.ingredients").formatted(Formatting.BLUE);
    public static final Text BASE_SLOT_DESC = Text.translatable("item.minecraft.smithing_template.armor_trim.base_slot_description");
    public static final Text ADDITIONS_SLOT_DESC = Text.translatable("item.minecraft.smithing_template.armor_trim.additions_slot_description");
    public static final Formatting DESC_FORMATTING = Formatting.GRAY;

    public static final Item RAW_NITHRIL = registerItem("raw_nithril", new Item(new FabricItemSettings()));
    public static final Item NITHRIL_INGOT = registerItem("nithril_ingot", new Item(new FabricItemSettings()));
    public static final Item NITHRIL_PLATE = registerItem("nithril_plate", new Item(new FabricItemSettings()));
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item SHARP_STONE = registerItem("stone_of_sharpness", new Item((new FabricItemSettings()).maxCount(1)));
    public static final Item BLOODY_JAR = registerItem("bloody_jar", new Item((new FabricItemSettings()).maxCount(16)));
    public static final Item HEALTH_JAR = registerItem("health_jar", new HealthJarItem((new FabricItemSettings()).maxCount(1)));
    public static final Item RUBY_TOTEM = registerItem("ruby_totem", new Item((new FabricItemSettings()).maxCount(1).maxDamage(2)));
    public static final Item RADAR = registerItem("radar", new RadarItem((new FabricItemSettings()).maxCount(1).maxDamage(3)));
    public static final Item DRAGON_HEART = registerItem("dragon_heart", new DragonHeartItem((new FabricItemSettings()).maxDamage(1)));
    public static final Item HARPOON = registerItem("harpoon", new HarpoonItem((new FabricItemSettings()).maxCount(1)));
    public static final Item LAVA_SWORD = registerItem("lava_sword", new LavaSwordItem(ModToolMaterial.LAVA, 0, -2.4F, new FabricItemSettings()));
    public static final Item EMERALD_SWORD = registerItem("emerald_sword", new SwordItem(ModToolMaterial.EMERALD, 0, -2.3F, new FabricItemSettings()));
    public static final Item SHARP_EMERALD_SWORD = registerItem("sharp_emerald_sword", new SharpEmeraldSwordItem(ModToolMaterial.EMERALD, 4, -2.3F, new FabricItemSettings()));
    public static final Item DRAGON_PICKAXE = registerItem("dragon_pickaxe", new PickaxeItem(ModToolMaterial.DRAGON, -1, -2.8F, new FabricItemSettings()));
    public static final Item NETHERITE_COVERED_DRAGON_PICKAXE = registerItem("netherite_covered_dragon_pickaxe", new PickaxeItem(ModToolMaterial.DRAGON, -1, -2.8F, (new FabricItemSettings()).fireproof()));
    public static final Item NIGHT_VISION_HELMET = registerItem("night_vision_helmet", (new NightVisionHelmetItem(ModArmorMaterials.NIGHT_VISION, Type.HELMET, new FabricItemSettings())).addArmorEffect(new EffectArmorItem.ArmorEffect(StatusEffects.NIGHT_VISION, 260, 0)));
    public static final Item AIRTAG = registerItem("airtag", new AirtagItem(ModArmorMaterials.AIRTAG, Type.HELMET, new FabricItemSettings()));
    public static final Item POSEIDON_HELMET = registerItem("poseidon_helmet", new PoseidonHelmetItem(ModArmorMaterials.POSEIDON, Type.HELMET, new FabricItemSettings()));
    public static final Item FEATHER_BOOTS = registerItem("feather_boots", new EffectArmorItem(ModArmorMaterials.FEATHER, Type.BOOTS, new FabricItemSettings()).addArmorEffect(StatusEffects.SLOW_FALLING, 1).addTooltip("tooltip.uhc.feather_boots"));
    public static final Item SLIME_BOOTS = registerItem("slime_boots", new SlimeBootsItem(ModArmorMaterials.SLIME, Type.BOOTS, new FabricItemSettings()).addArmorEffect(StatusEffects.JUMP_BOOST, 3).addTooltip("tooltip.uhc.slime_boots"));
    public static final Item DEATHRUN_LEGGINGS = registerItem("deathrun_leggings", new DeathrunLeggingsItem(ModArmorMaterials.DEATHRUN, Type.LEGGINGS, new FabricItemSettings()));
    public static final Item MAGMA_BOOTS = registerItem("magma_boots", new MagmaBootsItem(ModArmorMaterials.MAGMA, Type.BOOTS, new FabricItemSettings()));
    public static final Item SWEET_BERRIES_JAM = registerItem("sweet_berries_jam", new JamFoodItem(new FabricItemSettings().maxCount(4).food(ModFoodComponents.SWEET_BERRIES_JAM)));
    public static final Item GLOW_BERRIES_JAM = registerItem("glow_berries_jam", new GlowBerriesJamItem(new FabricItemSettings().maxCount(4).food(ModFoodComponents.GLOW_BERRIES_JAM)));
    public static final Item POISONOUS_SOUP = registerItem("poisonous_soup", new StewItem(new FabricItemSettings().maxCount(4).food(ModFoodComponents.POISONOUS_SOUP)));
    public static final Item SEAFOOD_SOUP = registerItem("seafood_soup", new StewItem(new FabricItemSettings().maxCount(4).food(ModFoodComponents.SEAFOOD_SOUP)));
    public static final Item GOAT_MEAT = registerItem("goat_meat", new Item(new FabricItemSettings().food(ModFoodComponents.GOAT_MEAT)));
    public static final Item COOKED_GOAT_MEAT = registerItem("cooked_goat_meat", new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_GOAT_MEAT)));
    public static final Item HORSE_LIKE_MEAT = registerItem("horse_like_meat", new Item(new FabricItemSettings().food(ModFoodComponents.HORSE_LIKE_MEAT)));
    public static final Item COOKED_HORSE_LIKE_MEAT = registerItem("cooked_horse_like_meat", new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_HORSE_LIKE_MEAT)));
    public static final Item LLAMA_MEAT = registerItem("llama_meat", new Item(new FabricItemSettings().food(ModFoodComponents.LLAMA_MEAT)));
    public static final Item COOKED_LLAMA_MEAT = registerItem("cooked_llama_meat", new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_LLAMA_MEAT)));
    public static final Item RAVAGER_MEAT = registerItem("ravager_meat", new RavagerMeatItem(new FabricItemSettings().food(ModFoodComponents.RAVAGER_MEAT)));
    public static final Item COOKED_RAVAGER_MEAT = registerItem("cooked_ravager_meat", new RavagerMeatItem(new FabricItemSettings().food(ModFoodComponents.COOKED_RAVAGER_MEAT)));
    public static final Item CAST_IRON_CAULDRON_BLOCK_ITEM = registerItem("cast_iron_cauldron", new CastIronCauldronBlockItem(new FabricItemSettings(), 2.0F));
    public static final Item EARTHQUAKE_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("earthquake_armor_trim_smithing_template", new SmithingTemplateItem(APPLIES_TO, INGREDIENTS,
            Text.translatable("trim_pattern.uhc.earthquake").formatted(DESC_FORMATTING), BASE_SLOT_DESC, ADDITIONS_SLOT_DESC, armorTrimEmptyBaseSlotTextures, armorTrimEmptyAdditionsSlotTextures));
    public static final Item GOBLIN_SPAWN_EGG = registerItem("goblin_spawn_egg", new SpawnEggItem(ModEntities.GOBLIN_ENTITY, 4762932, 13825987, new FabricItemSettings()));
    public static final Item MYSTERIOUS_TRADER_SPAWN_EGG = registerItem("mysterious_trader_spawn_egg", new SpawnEggItem(ModEntities.MYSTERIOUS_TRADER, 14358031, 11347203, new FabricItemSettings()));
    public static final Item NITHRIL_HELMET = registerItem("nithril_helmet", new ArmorItem(ModArmorMaterials.NITHRIL, Type.HELMET, new FabricItemSettings()));
    public static final Item NITHRIL_CHESTPLATE = registerItem("nithril_chestplate", new ArmorItem(ModArmorMaterials.NITHRIL, Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item NITHRIL_LEGGINGS = registerItem("nithril_leggings", new ArmorItem(ModArmorMaterials.NITHRIL, Type.LEGGINGS, new FabricItemSettings()));
    public static final Item NITHRIL_BOOTS = registerItem("nithril_boots", new ArmorItem(ModArmorMaterials.NITHRIL, Type.BOOTS, new FabricItemSettings()));
    public static final Item NITHRIL_SWORD = registerItem("nithril_sword", new SwordItem(ModToolMaterial.NITHRIL, 5, -2.4F, new FabricItemSettings()));
    public static final Item NITHRIL_PICKAXE = registerItem("nithril_pickaxe", new PickaxeItem(ModToolMaterial.NITHRIL, 3, -2.8F, new FabricItemSettings()));
    public static final Item NITHRIL_AXE = registerItem("nithril_axe", new AxeItem(ModToolMaterial.NITHRIL, 8.0F, -3.0F, new FabricItemSettings()));
    public static final Item NITHRIL_SHOVEL = registerItem("nithril_shovel", new ShovelItem(ModToolMaterial.NITHRIL, 2.0F, -3.0F, new FabricItemSettings()));
    public static final Item NITHRIL_HOE = registerItem("nithril_hoe", new HoeItem(ModToolMaterial.NITHRIL, -1, 0.0F, new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Uhc.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Uhc.LOGGER.info("Registering Mod Items for " + Uhc.MOD_ID);
    }

}
