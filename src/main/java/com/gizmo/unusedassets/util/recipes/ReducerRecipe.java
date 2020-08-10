package com.gizmo.unusedassets.util.recipes;

import com.gizmo.unusedassets.init.UnusedRecipes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class ReducerRecipe implements IReducerRecipe {

	private final ResourceLocation id;
	private Ingredient input;
	private final ItemStack output1;
	private final ItemStack output2;
	private final ItemStack output3;
	private final ItemStack output4;
	private final ItemStack output5;
	private final ItemStack output6;
	private final ItemStack output7;
	private final ItemStack output8;
	private final ItemStack output9;
	
	public ReducerRecipe(ResourceLocation id, Ingredient input, ItemStack output1, ItemStack output2, ItemStack output3, ItemStack output4, ItemStack output5, ItemStack output6, ItemStack output7, ItemStack output8, ItemStack output9) {
		this.id = id;
		this.input = input; 
		this.output1 = output1; this.output2 = output2; this.output3 = output3; this.output4 = output4;
		this.output5 = output5; this.output6 = output6; this.output7 = output7; this.output8 = output8; 
		this.output9 = output9;
		
	}
	
	@Override
	public boolean matches(RecipeWrapper inv, World worldIn) {
		if (this.input.test(inv.getStackInSlot(0))) {
			return true;
		}
		return false;
	}

	@Override
	public ItemStack getCraftingResult(RecipeWrapper inv) {
		return this.output1;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return this.output1;
	}

	@Override
	public ResourceLocation getId() {
		return this.id;
	}

	@Override
	public IRecipeSerializer<?> getSerializer() {
		return UnusedRecipes.REDUCER_SERIALIZER;
	}

	@Override
	public Ingredient getInput() {
		return this.input;
	}
	
	public NonNullList<Ingredient> getIngredient() {
		return NonNullList.from(null, this.input);
	}

}
