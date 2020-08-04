package com.gizmo.unusedassets.util;

import java.util.Collection;

import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.SpriteMap;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SMHeight extends SpriteMap {

	private final SMHeight.Info info;
	
	public SMHeight(Collection<AtlasTexture> atlasTexturesIn, SMHeight.Info info) {
		super(atlasTexturesIn);
		int i = info.width;
	    int j = info.height;
		this.info = new SMHeight.Info(info.id, i, j);	
	}
	
	@OnlyIn(Dist.CLIENT)
	public static final class Info {
	      private final ResourceLocation id;
	      private final int width;
	      private final int height;

	      public Info(ResourceLocation id, int width, int height) {
	         this.id = id;
	         this.width = width;
	         this.height = height;
	      }

	      public ResourceLocation getId() {
	         return this.id;
	      }

	      public float getWidth() {
	         return this.width;
	      }

	      public float getHeight() {
	         return this.height;
	      }
	   }

	public int getWidth() {
      return this.info.width;
   }

   public int getHeight() {
      return this.info.height;
   }

}
