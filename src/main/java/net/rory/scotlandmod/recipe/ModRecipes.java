package net.rory.scotlandmod.recipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rory.scotlandmod.ScotlandMod;

public class ModRecipes {

    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ScotlandMod.MOD_ID);

    public static final RegistryObject<RecipeSerializer<IrnBruCanningStationRecipe>> IRN_BRU_CANNING_SERIALIZER =
            SERIALIZERS.register("irn_bru_canning", () -> IrnBruCanningStationRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus){
        SERIALIZERS.register(eventBus);
    }
}
