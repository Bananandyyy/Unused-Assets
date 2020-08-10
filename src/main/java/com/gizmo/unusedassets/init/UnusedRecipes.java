package com.gizmo.unusedassets.init;

import java.util.ArrayList;

import com.gizmo.unusedassets.util.recipes.IReducerRecipe;
import com.gizmo.unusedassets.util.recipes.ReducerRecipe;
import com.gizmo.unusedassets.util.recipes.ReducerRecipeSerializer;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = "unusedassets", bus = Mod.EventBusSubscriber.Bus.MOD)
public class UnusedRecipes {

	private static final ArrayList<IRecipeSerializer<?>> RECIPES = new ArrayList<>();

	public static IRecipeSerializer<ReducerRecipe> REDUCER_SERIALIZER = register(new ResourceLocation("unusedassets", "reducer_serializer"), new ReducerRecipeSerializer());
	IRecipeType<IReducerRecipe> CRAFTING = registerType("reducer");
	
	
	static <S extends IRecipeSerializer<T>, T extends IRecipe<?>> S register(ResourceLocation id, S recipeSerializer)
    {
        S type = recipeSerializer;
        type.setRegistryName(id);
        RECIPES.add(type);
        return type;
    }
	
	 static <T extends IRecipe<?>> IRecipeType<T> registerType(final String key) {
	      return Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(key), new IRecipeType<T>() {
	         public String toString() {
	            return key;
	         }
	      });
	   }
	
	 @SubscribeEvent
	    public static void registerTypes(final RegistryEvent.Register<IRecipeSerializer<?>> event)
	    {
	        RECIPES.forEach(type -> event.getRegistry().register(type));
	        RECIPES.clear();
	    }

}
