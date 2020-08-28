package com.gizmo.unusedassets.items.crafting;

import java.util.function.Consumer;

import com.gizmo.unusedassets.init.UnusedItems;
import com.gizmo.unusedassets.init.blocks.UnusedBlocks;

import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;

public class CraftingGen extends RecipeProvider {

	public CraftingGen(DataGenerator generatorIn) {
		super(generatorIn);
	}
	
	private void javaRecipes(Consumer<IFinishedRecipe> consumer) {
		//new vanilla recipes
		ShapedRecipeBuilder.shapedRecipe(Items.IRON_HORSE_ARMOR)
		.patternLine("  i")
		.patternLine("iwi")
		.patternLine("iii")
		.key('i', Ingredient.fromItems(Items.IRON_INGOT))
		.key('w', Ingredient.fromItems(Blocks.WHITE_WOOL))
		.build(consumer);
		
		ShapedRecipeBuilder.shapedRecipe(Items.GOLDEN_HORSE_ARMOR)
		.patternLine("  i")
		.patternLine("iwi")
		.patternLine("iii")
		.key('i', Ingredient.fromItems(Items.GOLD_INGOT))
		.key('w', Ingredient.fromItems(Blocks.WHITE_WOOL))
		.build(consumer);
		
		ShapedRecipeBuilder.shapedRecipe(Items.DIAMOND_HORSE_ARMOR)
		.patternLine("  i")
		.patternLine("iwi")
		.patternLine("iii")
		.key('i', Ingredient.fromItems(Items.DIAMOND))
		.key('w', Ingredient.fromItems(Blocks.WHITE_WOOL))
		.build(consumer);
		
		ShapedRecipeBuilder.shapedRecipe(Items.SADDLE)
		.patternLine("lll")
		.patternLine("t t")
		.key('l', Ingredient.fromItems(Items.LEATHER))
		.key('t', Ingredient.fromItems(Blocks.TRIPWIRE_HOOK))
		.build(consumer);
		
		ShapedRecipeBuilder.shapedRecipe(Items.ENCHANTED_GOLDEN_APPLE)
		.patternLine("ggg")
		.patternLine("gag")
		.patternLine("ggg")
		.key('a', Ingredient.fromItems(Items.APPLE))
		.key('g', Ingredient.fromItems(Blocks.GOLD_BLOCK))
		.build(consumer);
		
		//haha yes dyes
		ShapelessRecipeBuilder.shapelessRecipe(UnusedItems.CAPRI_DYE)
		.addIngredient(Ingredient.fromItems(Items.CYAN_DYE))
		.addIngredient(Ingredient.fromItems(Items.LIGHT_GRAY_DYE))
		.build(consumer);
		
		ShapelessRecipeBuilder.shapelessRecipe(UnusedItems.CHARTREUSE_DYE)
		.addIngredient(Ingredient.fromItems(Items.GREEN_DYE))
		.addIngredient(Ingredient.fromItems(Items.LIGHT_GRAY_DYE))
		.addIngredient(Ingredient.fromItems(Items.WHITE_DYE))
		.build(consumer);
		
		ShapelessRecipeBuilder.shapelessRecipe(UnusedItems.ROSE_DYE)
		.addIngredient(Ingredient.fromItems(Items.RED_DYE))
		.addIngredient(Ingredient.fromItems(Items.LIGHT_GRAY_DYE))
		.build(consumer);
		
		ShapelessRecipeBuilder.shapelessRecipe(UnusedItems.ROSE_DYE)
		.addIngredient(Ingredient.fromItems(UnusedBlocks.ROSE))
		.build(consumer);
		
		ShapelessRecipeBuilder.shapelessRecipe(UnusedItems.SPRING_GREEN_DYE)
		.addIngredient(Ingredient.fromItems(Items.GREEN_DYE))
		.addIngredient(Ingredient.fromItems(Items.LIGHT_GRAY_DYE))
		.build(consumer);
		
		ShapelessRecipeBuilder.shapelessRecipe(UnusedItems.ULTRAMARINE_DYE)
		.addIngredient(Ingredient.fromItems(Items.CYAN_DYE))
		.addIngredient(Ingredient.fromItems(Items.GRAY_DYE))
		.build(consumer);
	}

}
