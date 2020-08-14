package com.gizmo.unusedassets.client.gui;

import com.gizmo.unusedassets.UnusedAssets;
import com.gizmo.unusedassets.inventory.container.ReducerContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


@OnlyIn(Dist.CLIENT)
public class ReducerScreen extends ModScreen<ReducerContainer>{

	public static final ResourceLocation REDUCER = new ResourceLocation(UnusedAssets.MOD_ID, "textures/gui/material_reducer.png");
	
	public ReducerScreen(ReducerContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
		this.guiLeft = 0;
		this.guiTop = 0;
		this.xSize = 175;
		this.ySize = 186;
	}
	
	public void render(MatrixStack ms, int x, int y, float ticks) {
	      this.renderBackground(ms);
	      super.render(ms, x, y, ticks);
	      this.drawGuiContainerForegroundLayer(ms, x, y);
	   }

	protected void drawGuiContainerBackgroundLayer(MatrixStack p_230450_1_, float p_230450_2_, int p_230450_3_, int p_230450_4_) {
	      RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
	      this.minecraft.getTextureManager().bindTexture(REDUCER);
	      int i = (this.guiLeft - this.xSize) / 2;
	      int j = (this.guiTop - this.ySize) / 2;
	      this.blit(p_230450_1_, i, j, 0, 0, this.xSize, this.ySize);
	   }

}
