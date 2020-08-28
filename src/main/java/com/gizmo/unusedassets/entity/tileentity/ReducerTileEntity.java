package com.gizmo.unusedassets.entity.tileentity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import com.gizmo.unusedassets.init.UnusedRecipes;
import com.gizmo.unusedassets.init.UnusedTileEntities;
import com.gizmo.unusedassets.inventory.container.ReducerContainer;
import com.gizmo.unusedassets.util.recipes.ReducerRecipe;

import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class ReducerTileEntity extends TileEntity implements INamedContainerProvider {

	private ReducerItemHandler inventory;
	
	public ReducerTileEntity(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
		this.inventory = new ReducerItemHandler(10);
	}

	public ReducerTileEntity() {
		this(UnusedTileEntities.MATERIAL_REDUCER);
	}

	public Container createMenu(int id, PlayerInventory player, PlayerEntity entity) {
		return new ReducerContainer(id, player, this);
	}

	public ITextComponent getDisplayName() {
		return new TranslationTextComponent("container.material_reducer");
	}

	@Nullable
	private ReducerRecipe getRecipe(ItemStack stack) {
		if(stack == null) {
			return null;
		}
		Set<IRecipe<?>> recipes = findRecipeByType(UnusedRecipes.REDUCER_SERIALIZER, this.world)
		for (IRecipe<?> iRecipe : recipes) {
			ReducerRecipe recipe = (ReducerRecipe)iRecipe;
			if (recipe.matches(new RecipeWrapper(this.inventory), this.world)) {
				return recipe;
			}
		}
		return null;
	}

	public static Set<IRecipe<?>> findRecipeByType(IRecipeSerializer<ReducerRecipe> typeIn, World world) {
		return world != null ? world.getRecipeManager().getRecipes().stream().filter(recipe -> recipe.getType() == typeIn).collect(Collectors.toSet()) : Collections.emptySet();
	}
	
	@OnlyIn(Dist.CLIENT)
	public static Set<IRecipe<?>> findRecipeByType(IRecipeSerializer<ReducerRecipe> typeIn) {
		ClientWorld world = Minecraft.getInstance().world;
		return world != null ? world.getRecipeManager().getRecipes().stream().filter(recipe -> recipe.getType() == typeIn).collect(Collectors.toSet()) : Collections.emptySet();
	}
	
	public static Set<ItemStack> getRecipeInputs(IRecipeSerializer<ReducerRecipe> typeIn, World worldIn) {
		Set<ItemStack> inputs = new HashSet<ItemStack>();
		Set<IRecipe<?>> recipes = findRecipeByType(typeIn, worldIn);
		for (IRecipe<?> recipe : recipes) {
			NonNullList<Ingredient> ingredients = recipe.getIngredients();
			ingredients.forEach(ingredient -> {
				for(ItemStack stack : ingredient.getMatchingStacks()) {
					inputs.add(stack);
				}
			});
		}
		return inputs;
	}
}
