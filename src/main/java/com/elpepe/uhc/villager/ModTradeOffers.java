package com.elpepe.uhc.villager;

import com.elpepe.uhc.enchantment.ModEnchantments;
import com.elpepe.uhc.item.ModItems;
import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import net.minecraft.util.math.random.Random;

public class ModTradeOffers {
   public static final Int2ObjectMap<TradeOffers.class_1652[]> MYSTERIOUS_TRADER_TRADES;

   private static Int2ObjectMap<TradeOffers.class_1652[]> registerTrades(TradeOffers.class_1652... offers) {
      return new Int2ObjectOpenHashMap(ImmutableMap.of(1, offers));
   }

   static {
      MYSTERIOUS_TRADER_TRADES = registerTrades(new EnchantedBookOfferFactory(new PurchasedItemStack(ModItems.RUBY, 15, 30), new EnchantedBookOfferFactory.BookForSell(ModEnchantments.BULLDOZER, 1, 1), 1, 1, 1.0F), new MysteriousOfferFactory(new ItemStack(ModItems.FEATHER_BOOTS, 1), 5, 10, 1, 1, 1.0F), new MysteriousOfferFactory(new ItemStack(ModItems.SLIME_BOOTS, 1), 10, 25, 1, 1, 1.0F), new MysteriousOfferFactory(new ItemStack(ModItems.MAGMA_BOOTS, 1), 25, 40, 1, 1, 1.0F), new MysteriousOfferFactory(new ItemStack(ModItems.DEATHRUN_LEGGINGS, 1), 30, 40, 1, 1, 1.0F), new MysteriousOfferFactory(new ItemStack(ModItems.POSEIDON_HELMET, 1), 10, 20, 1, 1, 1.0F), new MysteriousOfferFactory(new ItemStack(ModItems.SHARP_STONE, 1), 45, 64, 1, 1, 1.0F), new MysteriousOfferFactory(new ItemStack(ModItems.BLOODY_JAR, 1), 15, 40, 1, 1, 1.0F), new MysteriousOfferFactory(new ItemStack(ModItems.RUBY_TOTEM, 1), 40, 55, 1, 1, 1.0F), new MysteriousOfferFactory(new ItemStack(ModItems.RADAR, 1), 10, 15, 1, 1, 1.0F), new MysteriousOfferFactory(new ItemStack(ModItems.HARPOON, 1), 40, 64, 1, 1, 1.0F));
   }

   private static class EnchantedBookOfferFactory implements TradeOffers.class_1652 {
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

      public TradeOffer create(Entity entity, Random random) {
         return new TradeOffer(this.buy.get(random), this.buy2.get(random), this.sell.get(random), this.maxUses, this.experience, this.priceMultiplier);
      }

      private static record BookForSell(Enchantment enchantment, int minLevel, int maxLevel) {
         BookForSell(Enchantment enchantment, int minLevel, int maxLevel) {
            minLevel = Math.min(enchantment.getMinLevel(), minLevel);
            maxLevel = Math.min(enchantment.getMaxLevel(), maxLevel);
            this.enchantment = enchantment;
            this.minLevel = minLevel;
            this.maxLevel = maxLevel;
         }

         private ItemStack get(Random random) {
            ItemStack book = new ItemStack(Items.ENCHANTED_BOOK, 1);
            book.addEnchantment(this.enchantment, random.nextBetween(this.minLevel, this.maxLevel));
            return book;
         }

         public Enchantment enchantment() {
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

   private static record PurchasedItemStack(Item item, int minPrice, int maxPrice) implements IPurchasedItemStack {
      private static final IPurchasedItemStack EMPTY = new IPurchasedItemStack() {
         public ItemStack get(Random random) {
            return ItemStack.EMPTY;
         }
      };

      private PurchasedItemStack(Item item, int minPrice, int maxPrice) {
         this.item = item;
         this.minPrice = minPrice;
         this.maxPrice = maxPrice;
      }

      public ItemStack get(Random random) {
         return new ItemStack(this.item, this.minPrice == this.maxPrice ? this.minPrice : random.nextBetween(this.minPrice, this.maxPrice));
      }

      public Item item() {
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
      ItemStack get(Random var1);
   }

   private static class MysteriousOfferFactory implements TradeOffers.class_1652 {
      private final IPurchasedItemStack buy2;
      private final ItemStack sell;
      private final int minPrice;
      private final int maxPrice;
      private final int maxUses;
      private final int experience;
      private final float priceMultiplier;

      private MysteriousOfferFactory(IPurchasedItemStack buy2, ItemStack sell, int minPrice, int maxPrice, int maxUses, int experience, float priceMultiplier) {
         this.buy2 = buy2;
         this.sell = sell;
         this.minPrice = minPrice;
         this.maxPrice = maxPrice;
         this.maxUses = maxUses;
         this.experience = experience;
         this.priceMultiplier = priceMultiplier;
      }

      private MysteriousOfferFactory(ItemStack sell, int minPrice, int maxPrice, int maxUses, int experience, float priceMultiplier) {
         this.buy2 = ModTradeOffers.PurchasedItemStack.EMPTY;
         this.sell = sell;
         this.minPrice = minPrice;
         this.maxPrice = maxPrice;
         this.maxUses = maxUses;
         this.experience = experience;
         this.priceMultiplier = priceMultiplier;
      }

      public TradeOffer create(Entity entity, Random random) {
         return new TradeOffer(new ItemStack(ModItems.RUBY, Math.min(64, random.nextBetween(this.minPrice, this.maxPrice))), this.buy2.get(random), this.sell, this.maxUses, this.experience, this.priceMultiplier);
      }
   }

   private static class TradeOfferFactory implements TradeOffers.class_1652 {
      private final IPurchasedItemStack buy;
      private final IPurchasedItemStack buy2;
      private final ItemStack sell;
      private final int maxUses;
      private final int experience;
      private final float priceMultiplier;

      private TradeOfferFactory(IPurchasedItemStack buy, IPurchasedItemStack buy2, ItemStack sell, int maxUses, int experience, float priceMultiplier) {
         this.buy = buy;
         this.buy2 = buy2;
         this.sell = sell;
         this.maxUses = maxUses;
         this.experience = experience;
         this.priceMultiplier = priceMultiplier;
      }

      private TradeOfferFactory(IPurchasedItemStack buy, ItemStack sell, int maxUses, int experience, float priceMultiplier) {
         this.buy = buy;
         this.buy2 = ModTradeOffers.PurchasedItemStack.EMPTY;
         this.sell = sell;
         this.maxUses = maxUses;
         this.experience = experience;
         this.priceMultiplier = priceMultiplier;
      }

      public TradeOffer create(Entity entity, Random random) {
         return new TradeOffer(this.buy.get(random), this.buy2.get(random), this.sell, this.maxUses, this.experience, this.priceMultiplier);
      }
   }
}
