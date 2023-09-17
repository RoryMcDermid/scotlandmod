package net.rory.scotlandmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModTab {
    public static final CreativeModeTab SCOTLAND_TAB = new CreativeModeTab("scotlandtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.IRN_BRU.get());
        }
    };
}
