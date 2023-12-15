package net.rory.scotlandmod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.rory.scotlandmod.ScotlandMod;

@Mod.EventBusSubscriber(modid = ScotlandMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab SCOTLAND_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event){
        SCOTLAND_TAB = event.registerCreativeModeTab(new ResourceLocation(ScotlandMod.MOD_ID, "scotland_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.IRN_BRU.get()))
                        .title(Component.translatable("creativemodetab.scotland_tab")));
    }


}
