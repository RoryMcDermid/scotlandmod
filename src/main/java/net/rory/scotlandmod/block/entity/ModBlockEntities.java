package net.rory.scotlandmod.block.entity;

import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rory.scotlandmod.ScotlandMod;
import net.rory.scotlandmod.block.ModBlocks;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ScotlandMod.MOD_ID);


    public static final RegistryObject<BlockEntityType<IrnBruCanningStationEntity>> CANNING_STATION = BLOCK_ENTITIES.register("canning_station", () ->
            BlockEntityType.Builder.of(IrnBruCanningStationEntity::new, ModBlocks.IRN_BRU_CANNING_STATION.get()).build(null));


    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }

}
