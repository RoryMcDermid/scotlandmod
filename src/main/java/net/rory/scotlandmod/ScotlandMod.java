package net.rory.scotlandmod;

import com.mojang.logging.LogUtils;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.rory.scotlandmod.block.ModBlocks;
import net.rory.scotlandmod.effect.ModEffects;
import net.rory.scotlandmod.item.ModCreativeModeTabs;
import net.rory.scotlandmod.item.ModItems;
import net.rory.scotlandmod.loot.ModLootModifiers;
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

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == ModCreativeModeTabs.SCOTLAND_TAB){
            event.accept(ModItems.IRN_BRU);
            event.accept(ModItems.IRN_BRU_1901);
            event.accept(ModItems.IRN_BRU_SUGAR_FREE);
            event.accept(ModItems.BUNNET);
            event.accept(ModItems.CREATIVE_BUNNET);
            event.accept(ModItems.KILT);
            event.accept(ModItems.CHAIN_KILT);
            event.accept(ModItems.IRON_KILT);
            event.accept(ModItems.GOLD_KILT);
            event.accept(ModItems.DIAMOND_KILT);
            event.accept(ModItems.NETHERITE_KILT);
            event.accept(ModItems.Caberette);
            event.accept(ModItems.Stone_Banded_Caberette);
            event.accept(ModItems.Iron_Banded_Caberette);
            event.accept(ModItems.Gold_Banded_Caberette);
            event.accept(ModItems.Diamond_Banded_Caberette);
            event.accept(ModItems.Netherite_Banded_Caberette);
            event.accept(ModItems.Can);
            event.accept(ModItems.TWINE);
            event.accept(ModItems.ENTRAIL);
            event.accept(ModItems.HAGGIS);
            event.accept(ModItems.SAUSAGE);
            event.accept(ModItems.PREPARED_STONE);
            event.accept(ModBlocks.IRN_BRU_SLAB);
        }
    }



    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }




    }
}
