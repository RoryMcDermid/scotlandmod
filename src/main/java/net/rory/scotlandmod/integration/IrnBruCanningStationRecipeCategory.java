package net.rory.scotlandmod.integration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.rory.scotlandmod.ScotlandMod;
import net.rory.scotlandmod.block.ModBlocks;
import net.rory.scotlandmod.recipe.IrnBruCanningStationRecipe;

public class IrnBruCanningStationRecipeCategory implements IRecipeCategory<IrnBruCanningStationRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(ScotlandMod.MOD_ID, "irn_bru_canning");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(ScotlandMod.MOD_ID, "textures/gui/irn_bru_canning_station_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public IrnBruCanningStationRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.IRN_BRU_CANNING_STATION.get()));
    }

    @Override
    public RecipeType<IrnBruCanningStationRecipe> getRecipeType() {
        return JEIScotlandModPlugin.CANNING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Irn Bru Canning Station");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    //may need altered if recipes change
    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, IrnBruCanningStationRecipe recipe, IFocusGroup focuses) {
        //render item 0 in the ingredients to 86, 15
        builder.addSlot(RecipeIngredientRole.INPUT, 86, 15).addIngredients(recipe.getIngredients().get(0));

        //render the result item at 86, 60
        builder.addSlot(RecipeIngredientRole.OUTPUT, 86, 60).addItemStack(recipe.getResultItem());
    }
}
