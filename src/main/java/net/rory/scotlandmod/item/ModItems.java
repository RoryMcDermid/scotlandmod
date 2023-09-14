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
import net.rory.scotlandmod.item.custom.DrinkItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ScotlandMod.MOD_ID);

    public static final RegistryObject<Item> HAGGIS = ITEMS.register("haggis",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.SCOTLAND_TAB).food(Foods.HAGGIS_PROPERTIES)));
    public static final RegistryObject<Item> IRN_BRU = ITEMS.register("irn_bru",
            () -> new DrinkItem(new Item.Properties().tab(ModCreativeModTab.SCOTLAND_TAB).food(Foods.Irn_Bru_PROPERTIES)));
    public static final RegistryObject<Item> PREPARED_STONE = ITEMS.register("prepared_stone",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.SCOTLAND_TAB)));
    public static final RegistryObject<Item> ENTRAIL = ITEMS.register("entrail",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.SCOTLAND_TAB)));



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
                .effect(() -> new MobEffectInstance(MobEffects.HARM, 1), 0.5f)
                .build();
        public static final FoodProperties Irn_Bru_PROPERTIES = new FoodProperties.Builder()
                .nutrition(0)
                .saturationMod(0.0f)
                .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 1), 1f)
                .fast()
                .alwaysEat()
                .build();
    }

}
