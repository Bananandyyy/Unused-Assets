package com.gizmo.unusedassets.util;

import com.gizmo.unusedassets.items.ModDyeItem;
import java.util.Arrays;
import javax.annotation.Nullable;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

//Vanilla Copy
public enum ModDyeColor implements IStringSerializable {
	CHARTREUSE(0, "chartreuse", 9142344, ModMaterialColor.CHARTREUSE, 9142344, 9142344),
	SPRING_GREEN(1, "spring_green", 4882569, ModMaterialColor.SPRING_GREEN, 4882569, 4882569),
	CAPRI(2, "capri", 8800386, ModMaterialColor.CAPRI, 8800386, 8800386),
	ULTRAMARINE(3, "ultramarine", 9737858, ModMaterialColor.ULTRAMARINE, 9737858, 9737858),
	VIOLET(4, "violet", 8997504, ModMaterialColor.VIOLET, 8997504, 8997504),
	ROSE(5, "rose", 41961609, ModMaterialColor.ROSE, 41961609, 41961609);

	private static final ModDyeColor[] VALUES = Arrays.stream(values()).sorted().toArray((p_199795_0_) -> {
		return new ModDyeColor[p_199795_0_];
	});
	
	 private final int id;
	   private final String translationKey;
	   private final ModMaterialColor mapColor;
	   private final int colorValue;
	   private final int swappedColorValue;
	   private final float[] colorComponentValues;
	   private final int fireworkColor;
	   private final net.minecraft.tags.ITag<Item> tag;
	   private final int textColor;

	 private ModDyeColor(int idIn, String translationKeyIn, int colorValueIn, ModMaterialColor color, int fireworkColorIn, int textColorIn) {
	      this.id = idIn;
	      this.translationKey = translationKeyIn;
	      this.colorValue = colorValueIn;
	      this.mapColor = color;
	      this.textColor = textColorIn;
	      int i = (colorValueIn & 16711680) >> 16;
	      int j = (colorValueIn & '\uff00') >> 8;
	      int k = (colorValueIn & 255) >> 0;
	      this.swappedColorValue = k << 16 | j << 8 | i << 0;
	      this.tag = net.minecraft.tags.ItemTags.makeWrapperTag("unusedassets:dyes/" + translationKeyIn);
	      this.colorComponentValues = new float[]{(float)i / 255.0F, (float)j / 255.0F, (float)k / 255.0F};
	      this.fireworkColor = fireworkColorIn;
	   }

	   public int getId() {
	      return this.id;
	   }

	   public String getTranslationKey() {
	      return this.translationKey;
	   }

	   /**
	    * Gets an array containing 3 floats ranging from 0.0 to 1.0: the red, green, and blue components of the
	    * corresponding color.
	    */
	   public float[] getColorComponentValues() {
	      return this.colorComponentValues;
	   }

	   public ModMaterialColor getMapColor() {
	      return this.mapColor;
	   }

	   public int getFireworkColor() {
	      return this.fireworkColor;
	   }

	   public int getTextColor() {
	      return this.textColor;
	   }

	   public static ModDyeColor byId(int colorId) {
	      if (colorId < 0 || colorId >= VALUES.length) {
	         colorId = 0;
	      }

	      return VALUES[colorId];
	   }

	   public static ModDyeColor byTranslationKey(String translationKeyIn, ModDyeColor fallback) {
	      for(ModDyeColor dyecolor : values()) {
	         if (dyecolor.translationKey.equals(translationKeyIn)) {
	            return dyecolor;
	         }
	      }

	      return fallback;
	   }

	   public String toString() {
	      return this.translationKey;
	   }

	   public String func_176610_l() {
	      return this.translationKey;
	   }

	   public int getColorValue() {
	      return colorValue;
	   }

	   public net.minecraft.tags.ITag<Item> getTag() {
	      return tag;
	   }

	   @Nullable
	   public static ModDyeColor getColor(ItemStack stack) {
	      if (stack.getItem() instanceof ModDyeItem)
	         return ((ModDyeItem)stack.getItem()).getModDyeColor();

	      for (ModDyeColor color : VALUES) {
	         if (stack.getItem().isIn(color.getTag()))
	             return color;
	      }

	      return null;
	   }
	}