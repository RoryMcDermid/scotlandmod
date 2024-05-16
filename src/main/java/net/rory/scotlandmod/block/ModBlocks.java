package net.rory.scotlandmod.block;

import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rory.scotlandmod.ScotlandMod;
import net.rory.scotlandmod.block.custom.IrnBruCanningStation;
import net.rory.scotlandmod.item.ModCreativeModeTabs;
import net.rory.scotlandmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ScotlandMod.MOD_ID);


    public static final RegistryObject<SlabBlock> IRN_BRU_SLAB = registerBlock("irn_bru_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2f).sound(SoundType.SCAFFOLDING)));
    public static final RegistryObject<SlabBlock> IRN_BRU_SLAB_SUGAR_FREE = registerBlock("irn_bru_slab_sugar_free",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2f).sound(SoundType.SCAFFOLDING)));
    public static final RegistryObject<SlabBlock> IRN_BRU_SLAB_1901 = registerBlock("irn_bru_slab_1901",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2f).sound(SoundType.SCAFFOLDING)));
    public static final RegistryObject<IrnBruCanningStation> IRN_BRU_CANNING_STATION = registerBlock("irn_bru_canning_station",
            () -> new IrnBruCanningStation(BlockBehaviour.Properties.of(Material.WOOD).strength(2f).sound(SoundType.SCAFFOLDING)));






    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
