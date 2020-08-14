package com.gizmo.unusedassets.client.gui;

import com.gizmo.unusedassets.UnusedAssets;
import com.gizmo.unusedassets.inventory.container.ElementContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

//TODO: fix this. Its so broken after converting to 1.16
@OnlyIn(Dist.CLIENT)
public class ElementScreen extends ModScreen<ElementContainer> {

	public static final ResourceLocation CONSTRUCTOR = new ResourceLocation(UnusedAssets.MOD_ID, "textures/gui/element_constructor.png");

	public ElementScreen(ElementContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
		this.guiLeft = 0;
		this.guiTop = 0;
		this.xSize = 250;
		this.ySize = 220;
	}

	public void render(MatrixStack ms, int x, int y, float ticks) {
		this.renderBackground(ms);
		super.render(ms, x, y, ticks);
		this.drawGuiContainerForegroundLayer(ms, x, y);
	}

	protected void drawGuiContainerBackgroundLayer(MatrixStack p_230450_1_, float p_230450_2_, int p_230450_3_,
			int p_230450_4_) {
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.minecraft.getTextureManager().bindTexture(CONSTRUCTOR);
		int i = (this.guiLeft - this.xSize) / 2;
		int j = (this.guiTop - this.ySize) / 2;
		this.blit(p_230450_1_, i, j, 0, 0, this.xSize, this.ySize);
	}

}
