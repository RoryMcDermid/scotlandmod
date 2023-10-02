package net.rory.scotlandmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rory.scotlandmod.ScotlandMod;
import net.rory.scotlandmod.effect.ModEffects;
import net.rory.scotlandmod.item.custom.DrinkItem;
import net.rory.scotlandmod.item.custom.HaggisItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ScotlandMod.MOD_ID);

    public static final RegistryObject<Item> HAGGIS = ITEMS.register("haggis",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SCOTLAND_TAB).food(Foods.HAGGIS_PROPERTIES)));
    public static final RegistryObject<Item> SAUSAGE = ITEMS.register("sausage",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SCOTLAND_TAB).food(Foods.SAUSAGE_PROPERTIES)));
    public static final RegistryObject<Item> IRN_BRU = ITEMS.register("irn_bru",
            () -> new DrinkItem(new Item.Properties().tab(ModCreativeModeTab.SCOTLAND_TAB).food(Foods.Irn_Bru_PROPERTIES)));
    public static final RegistryObject<Item> PREPARED_STONE = ITEMS.register("prepared_stone",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SCOTLAND_TAB)));
    public static final RegistryObject<Item> ENTRAIL = ITEMS.register("entrail",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SCOTLAND_TAB)));



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
    }

}
