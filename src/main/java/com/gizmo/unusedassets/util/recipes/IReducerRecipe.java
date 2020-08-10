package com.gizmo.unusedassets.util.recipes;

import javax.annotation.Nonnull;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public interface IReducerRecipe extends IRecipe<RecipeWrapper> {

	ResourceLocation ID = new ResourceLocation("unusedassets", "reducer");

	@Nonnull
	@Override
	default IRecipeType<?> getType() {
		return Registry.RECIPE_TYPE.getValue(ID).get();
	}

	@Override
	default boolean canFit(int width, int height) {
		return false;
	}
	
	Ingredient getInput();
}
