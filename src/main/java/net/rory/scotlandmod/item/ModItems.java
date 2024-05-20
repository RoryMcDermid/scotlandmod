package net.rory.scotlandmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
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
            () -> new Item(new Item.Properties().food(Foods.HAGGIS_PROPERTIES).tab(ModCreativeModeTab.SCOTLAND_TAB)));
    public static final RegistryObject<Item> SAUSAGE = ITEMS.register("sausage",
            () -> new Item(new Item.Properties().food(Foods.SAUSAGE_PROPERTIES).tab(ModCreativeModeTab.SCOTLAND_TAB)));
    public static final RegistryObject<Item> IRN_BRU = ITEMS.register("irn_bru",
            () -> new DrinkItem(new Item.Properties().food(Foods.Irn_Bru_PROPERTIES).tab(ModCreativeModeTab.SCOTLAND_TAB)));
    public static final RegistryObject<Item> IRN_BRU_1901 = ITEMS.register("irn_bru_1901",
            () -> new DrinkItem(new Item.Properties().food(Foods.Irn_Bru_1901_PROPERTIES).tab(ModCreativeModeTab.SCOTLAND_TAB)));
    public static final RegistryObject<Item> IRN_BRU_SUGAR_FREE = ITEMS.register("irn_bru_sugar_free",
            () -> new DrinkItem(new Item.Properties().food(Foods.Irn_Bru_SUGAR_FREE_PROPERTIES).tab(ModCreativeModeTab.SCOTLAND_TAB)));


    public static final RegistryObject<Item> PREPARED_STONE = ITEMS.register("prepared_stone",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SCOTLAND_TAB)));
    public static final RegistryObject<Item> ENTRAIL = ITEMS.register("entrail",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SCOTLAND_TAB)));
    public static final RegistryObject<Item> Can = ITEMS.register("can",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SCOTLAND_TAB)));
    public static final RegistryObject<Item> TWINE = ITEMS.register("twine",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SCOTLAND_TAB)));
    public static final RegistryObject<Item> IRN_BRU_CRYSTAL = ITEMS.register("irn_bru_crystal",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SCOTLAND_TAB)));
    public static final RegistryObject<Item> IRN_BRU_CRYSTAL_SUGAR_FREE = ITEMS.register("irn_bru_crystal_sugar_free",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SCOTLAND_TAB)));



    public static final RegistryObject<Item> KILT = ITEMS.register("kilt",
            () -> new KiltArmorItem(ModArmorMaterials.WOOLEN, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeModeTab.SCOTLAND_TAB), 0));
    public static final RegistryObject<Item> CHAIN_KILT = ITEMS.register("chain_kilt",
            () -> new KiltArmorItem(ModArmorMaterials.CHAIN_WOOLEN, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeModeTab.SCOTLAND_TAB), 0));
    public static final RegistryObject<Item> IRON_KILT = ITEMS.register("iron_kilt",
            () -> new KiltArmorItem(ModArmorMaterials.IRON_WOOLEN, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeModeTab.SCOTLAND_TAB), 0));
    public static final RegistryObject<Item> GOLD_KILT = ITEMS.register("gold_kilt",
            () -> new KiltArmorItem(ModArmorMaterials.GOLD_WOOLEN, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeModeTab.SCOTLAND_TAB), 1));
    public static final RegistryObject<Item> DIAMOND_KILT = ITEMS.register("diamond_kilt",
            () -> new KiltArmorItem(ModArmorMaterials.DIAMOND_WOOLEN, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeModeTab.SCOTLAND_TAB), 0));
    public static final RegistryObject<Item> NETHERITE_KILT = ITEMS.register("netherite_kilt",
            () -> new KiltArmorItem(ModArmorMaterials.NETHERITE_WOOLEN, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeModeTab.SCOTLAND_TAB), 0));
    public static final RegistryObject<Item> BUNNET = ITEMS.register("bunnet",
            () -> new ScottishArmorItem(ModArmorMaterials.WOOLEN, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeModeTab.SCOTLAND_TAB), 0));
    public static final RegistryObject<Item> CREATIVE_BUNNET = ITEMS.register("creative_bunnet",
            () -> new ScottishArmorItem(ModArmorMaterials.CREATIVE_WOOLEN, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeModeTab.SCOTLAND_TAB), 99));


    public static final RegistryObject<Item> Caberette = ITEMS.register("caberette",
            () -> new CaberetteItem(Tiers.WOOD, 4, -2.8F, new Item.Properties().tab(ModCreativeModeTab.SCOTLAND_TAB)));
    public static final RegistryObject<Item> Stone_Banded_Caberette = ITEMS.register("stone_caberette",
            () -> new CaberetteItem(Tiers.STONE, 4, -2.8F, new Item.Properties().tab(ModCreativeModeTab.SCOTLAND_TAB)));
    public static final RegistryObject<Item> Iron_Banded_Caberette = ITEMS.register("iron_caberette",
            () -> new CaberetteItem(Tiers.IRON, 4, -2.8F, new Item.Properties().tab(ModCreativeModeTab.SCOTLAND_TAB)));
    public static final RegistryObject<Item> Gold_Banded_Caberette = ITEMS.register("gold_caberette",
            () -> new CaberetteItem(Tiers.GOLD, 4, -2.8F, new Item.Properties().tab(ModCreativeModeTab.SCOTLAND_TAB)));
    public static final RegistryObject<Item> Diamond_Banded_Caberette = ITEMS.register("diamond_caberette",
            () -> new CaberetteItem(Tiers.DIAMOND, 4, -2.8F, new Item.Properties().tab(ModCreativeModeTab.SCOTLAND_TAB)));
    public static final RegistryObject<Item> Netherite_Banded_Caberette = ITEMS.register("netherite_caberette",
            () -> new CaberetteItem(Tiers.DIAMOND, 4, -2.8F, new Item.Properties().tab(ModCreativeModeTab.SCOTLAND_TAB)));


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
                .effect(() -> new MobEffectInstance(ModEffects.SCOTTISH_EFFECT.get(), 200, 0), 1f)
                .fast()
                .alwaysEat()
                .build();
        public static final FoodProperties Irn_Bru_1901_PROPERTIES = new FoodProperties.Builder()
                .nutrition(0)
                .saturationMod(0.0f)
                .effect(() -> new MobEffectInstance(ModEffects.SCOTTISH_EFFECT.get(), 2400, 2), 1f)
                .fast()
                .alwaysEat()
                .build();
        public static final FoodProperties Irn_Bru_SUGAR_FREE_PROPERTIES = new FoodProperties.Builder()
                .nutrition(0)
                .saturationMod(0.0f)
                .effect(() -> new MobEffectInstance(ModEffects.SCOTTISH_EFFECT.get(), 1800, 0), 1f)
                .fast()
                .alwaysEat()
                .build();
    }
 
}
