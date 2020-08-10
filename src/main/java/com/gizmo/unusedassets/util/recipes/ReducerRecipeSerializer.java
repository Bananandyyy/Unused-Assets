package com.gizmo.unusedassets.util.recipes;

import com.google.gson.JsonObject;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class ReducerRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<ReducerRecipe>{

	@Override
	public ReducerRecipe read(ResourceLocation recipeId, JsonObject json) {
		ItemStack output1 = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, "output1"), true);
		ItemStack output2 = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, "output2"), true);
		ItemStack output3 = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, "output3"), true);
		ItemStack output4 = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, "output4"), true);
		ItemStack output5 = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, "output5"), true);
		ItemStack output6 = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, "output6"), true);
		ItemStack output7 = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, "output7"), true);
		ItemStack output8 = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, "output8"), true);
		ItemStack output9 = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, "output9"), true);
		Ingredient input = Ingredient.deserialize(JSONUtils.getJsonObject(json, "input"));
		
		return new ReducerRecipe(recipeId, input, output1, output2, output3, output4, output5, output6, output7, output8, output9);
	}

	@Override
	public ReducerRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
		ItemStack output1 = buffer.readItemStack();
		ItemStack output2 = buffer.readItemStack();
		ItemStack output3 = buffer.readItemStack();
		ItemStack output4 = buffer.readItemStack();
		ItemStack output5 = buffer.readItemStack();
		ItemStack output6 = buffer.readItemStack();
		ItemStack output7 = buffer.readItemStack();
		ItemStack output8 = buffer.readItemStack();
		ItemStack output9 = buffer.readItemStack();
		Ingredient input = Ingredient.read(buffer);
		
		return new ReducerRecipe(recipeId, input, output1, output2, output3, output4, output5, output6, output7, output8, output9);
	}

	@Override
	public void write(PacketBuffer buffer, ReducerRecipe recipe) {
		Ingredient input = recipe.getIngredients().get(0);
		input.write(buffer);
		
		buffer.writeItemStack(recipe.getRecipeOutput(), false);
		
	}

	
}
