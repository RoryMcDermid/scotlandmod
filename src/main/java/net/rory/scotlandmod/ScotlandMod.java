package net.rory.scotlandmod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.rory.scotlandmod.block.ModBlocks;
import net.rory.scotlandmod.block.entity.ModBlockEntities;
import net.rory.scotlandmod.effect.ModEffects;
import net.rory.scotlandmod.item.ModItems;
import net.rory.scotlandmod.loot.ModLootModifiers;
import net.rory.scotlandmod.recipe.ModRecipes;
import net.rory.scotlandmod.screen.IrnBruCanningStationScreen;
import net.rory.scotlandmod.screen.ModMenuTypes;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ScotlandMod.MOD_ID)
public class ScotlandMod
{
    public static final String MOD_ID = "scotlandmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ScotlandMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);

        ModBlocks.register(modEventBus);

        ModLootModifiers.register(modEventBus);

        ModEffects.register(modEventBus);


        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        ModRecipes.register(modEventBus);


        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }




    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            MenuScreens.register(ModMenuTypes.IRN_BRU_CANNING_STATION_MENU.get(), IrnBruCanningStationScreen::new);
        }




    }
}
