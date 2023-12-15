package net.rory.scotlandmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rory.scotlandmod.ScotlandMod;
import net.rory.scotlandmod.effect.ModEffects;
import net.rory.scotlandmod.item.custom.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ScotlandMod.MOD_ID);

    public static final RegistryObject<Item> HAGGIS = ITEMS.register("haggis",
            () -> new Item(new Item.Properties().food(Foods.HAGGIS_PROPERTIES)));
    public static final RegistryObject<Item> SAUSAGE = ITEMS.register("sausage",
            () -> new Item(new Item.Properties().food(Foods.SAUSAGE_PROPERTIES)));
    public static final RegistryObject<Item> IRN_BRU = ITEMS.register("irn_bru",
            () -> new DrinkItem(new Item.Properties().food(Foods.Irn_Bru_PROPERTIES)));
    public static final RegistryObject<Item> IRN_BRU_1901 = ITEMS.register("irn_bru_1901",
            () -> new DrinkItem(new Item.Properties().food(Foods.Irn_Bru_1901_PROPERTIES)));


    public static final RegistryObject<Item> PREPARED_STONE = ITEMS.register("prepared_stone",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ENTRAIL = ITEMS.register("entrail",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Can = ITEMS.register("can",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> KILT = ITEMS.register("kilt",
            () -> new KiltArmorItem(ModArmorMaterials.KILT, ArmorItem.Type.LEGGINGS, new Item.Properties(), 0));
    public static final RegistryObject<Item> Bunnet = ITEMS.register("bunnet",
            () -> new BunnetArmorItem(ModArmorMaterials.KILT, ArmorItem.Type.HELMET, new Item.Properties(), 0));
    public static final RegistryObject<Item> Creative_Bunnet = ITEMS.register("creative_bunnet",
            () -> new BunnetArmorItem(ModArmorMaterials.KILT, ArmorItem.Type.HELMET, new Item.Properties(), 99));

    public static final RegistryObject<Item> Caberette = ITEMS.register("caberette",
            () -> new CaberetteItem(Tiers.WOOD, 4, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> Stone_Banded_Caberette = ITEMS.register("stone_caberette",
            () -> new CaberetteItem(Tiers.STONE, 4, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> Iron_Banded_Caberette = ITEMS.register("iron_caberette",
            () -> new CaberetteItem(Tiers.IRON, 4, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> Gold_Banded_Caberette = ITEMS.register("gold_caberette",
            () -> new CaberetteItem(Tiers.GOLD, 4, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> Diamond_Banded_Caberette = ITEMS.register("diamond_caberette",
            () -> new CaberetteItem(Tiers.DIAMOND, 4, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> Netherite_Banded_Caberette = ITEMS.register("netherite_caberette",
            () -> new CaberetteItem(Tiers.DIAMOND, 4, -2.8F, new Item.Properties()));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

    //this is for creating food, make a new static final FoodProperties inside Foods to make a new food
    //look into how saturation works
    public static class Foods {
        public static final FoodProperties HAGGIS_PROPERTIES = new FoodProperties.Builder()
                .nutrition(6)
                .saturationMod(0.6f)
                .meat()
                .build();
        public static final FoodProperties SAUSAGE_PROPERTIES = new FoodProperties.Builder()
                .nutrition(8)
                .saturationMod(0.6f)
                .meat()
                .build();
        public static final FoodProperties Irn_Bru_PROPERTIES = new FoodProperties.Builder()
                .nutrition(0)
                .saturationMod(0.0f)
                .effect(() -> new MobEffectInstance(ModEffects.SCOTTISH_EFFECT.get(), 2400, 0), 1f)
                .fast()
                .alwaysEat()
                .build();
        public static final FoodProperties Irn_Bru_1901_PROPERTIES = new FoodProperties.Builder()
                .nutrition(0)
                .saturationMod(0.0f)
                .effect(() -> new MobEffectInstance(ModEffects.SCOTTISH_EFFECT.get(), 1200, 1), 1f)
                .fast()
                .alwaysEat()
                .build();
    }

}
