package net.rory.scotlandmod.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import net.rory.scotlandmod.ScotlandMod;
import net.rory.scotlandmod.recipe.IrnBruCanningStationRecipe;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIScotlandModPlugin implements IModPlugin {
    public static RecipeType<IrnBruCanningStationRecipe> CANNING_TYPE =
            new RecipeType<>(IrnBruCanningStationRecipeCategory.UID, IrnBruCanningStationRecipe.class);


    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(ScotlandMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                IrnBruCanningStationRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<IrnBruCanningStationRecipe> recipesCanning = rm.getAllRecipesFor(IrnBruCanningStationRecipe.Type.INSTANCE);
        registration.addRecipes(CANNING_TYPE, recipesCanning);
    }
}
