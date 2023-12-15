package com.elpepe.uhc.villager;

import com.elpepe.uhc.enchantment.ModEnchantments;
import com.elpepe.uhc.item.ModItems;
import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.class_1297;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1887;
import net.minecraft.class_1914;
import net.minecraft.class_3853;
import net.minecraft.class_5819;

public class ModTradeOffers {
   public static final Int2ObjectMap<class_3853.class_1652[]> MYSTERIOUS_TRADER_TRADES;

   public ModTradeOffers() {
   }

   private static Int2ObjectMap<class_3853.class_1652[]> registerTrades(class_3853.class_1652... offers) {
      return new Int2ObjectOpenHashMap(ImmutableMap.of(1, offers));
   }

   static {
      MYSTERIOUS_TRADER_TRADES = registerTrades(new EnchantedBookOfferFactory(new PurchasedItemStack(ModItems.RUBY, 15, 30), new EnchantedBookOfferFactory.BookForSell(ModEnchantments.BULLDOZER, 1, 1), 1, 1, 1.0F), new MysteriousOfferFactory(new class_1799(ModItems.FEATHER_BOOTS, 1), 5, 10, 1, 1, 1.0F), new MysteriousOfferFactory(new class_1799(ModItems.SLIME_BOOTS, 1), 10, 25, 1, 1, 1.0F), new MysteriousOfferFactory(new class_1799(ModItems.MAGMA_BOOTS, 1), 25, 40, 1, 1, 1.0F), new MysteriousOfferFactory(new class_1799(ModItems.DEATHRUN_LEGGINGS, 1), 30, 40, 1, 1, 1.0F), new MysteriousOfferFactory(new class_1799(ModItems.POSEIDON_HELMET, 1), 10, 20, 1, 1, 1.0F), new MysteriousOfferFactory(new class_1799(ModItems.SHARP_STONE, 1), 45, 64, 1, 1, 1.0F), new MysteriousOfferFactory(new class_1799(ModItems.BLOODY_JAR, 1), 15, 40, 1, 1, 1.0F), new MysteriousOfferFactory(new class_1799(ModItems.RUBY_TOTEM, 1), 40, 55, 1, 1, 1.0F), new MysteriousOfferFactory(new class_1799(ModItems.RADAR, 1), 10, 15, 1, 1, 1.0F), new MysteriousOfferFactory(new class_1799(ModItems.HARPOON, 1), 40, 64, 1, 1, 1.0F));
   }

   private static class EnchantedBookOfferFactory implements class_3853.class_1652 {
      private final IPurchasedItemStack buy;
      private final IPurchasedItemStack buy2;
      private final BookForSell sell;
      private final int maxUses;
      private final int experience;
      private final float priceMultiplier;

      private EnchantedBookOfferFactory(IPurchasedItemStack buy, IPurchasedItemStack buy2, BookForSell sell, int maxUses, int experience, float priceMultiplier) {
         this.buy = buy;
         this.buy2 = buy2;
         this.sell = sell;
         this.maxUses = maxUses;
         this.experience = experience;
         this.priceMultiplier = priceMultiplier;
      }

      private EnchantedBookOfferFactory(IPurchasedItemStack buy, BookForSell sell, int maxUses, int experience, float priceMultiplier) {
         this.buy = buy;
         this.buy2 = ModTradeOffers.PurchasedItemStack.EMPTY;
         this.sell = sell;
         this.maxUses = maxUses;
         this.experience = experience;
         this.priceMultiplier = priceMultiplier;
      }

      public class_1914 method_7246(class_1297 entity, class_5819 random) {
         return new class_1914(this.buy.get(random), this.buy2.get(random), this.sell.get(random), this.maxUses, this.experience, this.priceMultiplier);
      }

      private static record BookForSell(class_1887 enchantment, int minLevel, int maxLevel) {
         BookForSell(class_1887 enchantment, int minLevel, int maxLevel) {
            minLevel = Math.min(enchantment.method_8187(), minLevel);
            maxLevel = Math.min(enchantment.method_8183(), maxLevel);
            this.enchantment = enchantment;
            this.minLevel = minLevel;
            this.maxLevel = maxLevel;
         }

         private class_1799 get(class_5819 random) {
            class_1799 book = new class_1799(class_1802.field_8598, 1);
            book.method_7978(this.enchantment, random.method_39332(this.minLevel, this.maxLevel));
            return book;
         }

         public class_1887 enchantment() {
            return this.enchantment;
         }

         public int minLevel() {
            return this.minLevel;
         }

         public int maxLevel() {
            return this.maxLevel;
         }
      }
   }

   private static record PurchasedItemStack(class_1792 item, int minPrice, int maxPrice) implements IPurchasedItemStack {
      private static final IPurchasedItemStack EMPTY = new IPurchasedItemStack() {
         public class_1799 get(class_5819 random) {
            return class_1799.field_8037;
         }
      };

      private PurchasedItemStack(class_1792 item, int minPrice, int maxPrice) {
         this.item = item;
         this.minPrice = minPrice;
         this.maxPrice = maxPrice;
      }

      public class_1799 get(class_5819 random) {
         return new class_1799(this.item, this.minPrice == this.maxPrice ? this.minPrice : random.method_39332(this.minPrice, this.maxPrice));
      }

      public class_1792 item() {
         return this.item;
      }

      public int minPrice() {
         return this.minPrice;
      }

      public int maxPrice() {
         return this.maxPrice;
      }
   }

   private interface IPurchasedItemStack {
      class_1799 get(class_5819 var1);
   }

   private static class MysteriousOfferFactory implements class_3853.class_1652 {
      private final IPurchasedItemStack buy2;
      private final class_1799 sell;
      private final int minPrice;
      private final int maxPrice;
      private final int maxUses;
      private final int experience;
      private final float priceMultiplier;

      private MysteriousOfferFactory(IPurchasedItemStack buy2, class_1799 sell, int minPrice, int maxPrice, int maxUses, int experience, float priceMultiplier) {
         this.buy2 = buy2;
         this.sell = sell;
         this.minPrice = minPrice;
         this.maxPrice = maxPrice;
         this.maxUses = maxUses;
         this.experience = experience;
         this.priceMultiplier = priceMultiplier;
      }

      private MysteriousOfferFactory(class_1799 sell, int minPrice, int maxPrice, int maxUses, int experience, float priceMultiplier) {
         this.buy2 = ModTradeOffers.PurchasedItemStack.EMPTY;
         this.sell = sell;
         this.minPrice = minPrice;
         this.maxPrice = maxPrice;
         this.maxUses = maxUses;
         this.experience = experience;
         this.priceMultiplier = priceMultiplier;
      }

      public class_1914 method_7246(class_1297 entity, class_5819 random) {
         return new class_1914(new class_1799(ModItems.RUBY, Math.min(64, random.method_39332(this.minPrice, this.maxPrice))), this.buy2.get(random), this.sell, this.maxUses, this.experience, this.priceMultiplier);
      }
   }

   private static class TradeOfferFactory implements class_3853.class_1652 {
      private final IPurchasedItemStack buy;
      private final IPurchasedItemStack buy2;
      private final class_1799 sell;
      private final int maxUses;
      private final int experience;
      private final float priceMultiplier;

      private TradeOfferFactory(IPurchasedItemStack buy, IPurchasedItemStack buy2, class_1799 sell, int maxUses, int experience, float priceMultiplier) {
         this.buy = buy;
         this.buy2 = buy2;
         this.sell = sell;
         this.maxUses = maxUses;
         this.experience = experience;
         this.priceMultiplier = priceMultiplier;
      }

      private TradeOfferFactory(IPurchasedItemStack buy, class_1799 sell, int maxUses, int experience, float priceMultiplier) {
         this.buy = buy;
         this.buy2 = ModTradeOffers.PurchasedItemStack.EMPTY;
         this.sell = sell;
         this.maxUses = maxUses;
         this.experience = experience;
         this.priceMultiplier = priceMultiplier;
      }

      public class_1914 method_7246(class_1297 entity, class_5819 random) {
         return new class_1914(this.buy.get(random), this.buy2.get(random), this.sell, this.maxUses, this.experience, this.priceMultiplier);
      }
   }
}
