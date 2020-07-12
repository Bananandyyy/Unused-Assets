package com.gizmo.unusedassets.client.gui;

import com.gizmo.unusedassets.UnusedAssets;
import com.gizmo.unusedassets.inventory.container.ElementContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

//TODO: fix this. Its so broken after converting to 1.16
@OnlyIn(Dist.CLIENT)
public class ElementScreen extends ContainerScreen<ElementContainer>{

	public static final ResourceLocation CONSTRUCTOR = new ResourceLocation(UnusedAssets.MOD_ID, "textures/gui/element_constructor.png");
	
	public ElementScreen(ElementContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
		this.guiLeft = 0;
		this.guiTop = 0;
		this.xSize = 219;
		this.ySize = 249;
	}
	
	public void render(MatrixStack ms, int x, int y, float ticks) {
	      this.func_230446_a_(ms);
	      super.func_230430_a_(ms, x, y, ticks);
	      this.func_230459_a_(ms, x, y);
	   }

	protected void func_231160_c_() {
	      super.func_231160_c_();
	      this.field_238742_p_ = (this.xSize - this.field_230712_o_.func_238414_a_(this.field_230704_d_)) / 2;
	   }
	
	protected void func_230450_a_(MatrixStack p_230450_1_, float p_230450_2_, int p_230450_3_, int p_230450_4_) {
	      RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
	      this.field_230706_i_.getTextureManager().bindTexture(CONSTRUCTOR);
	      int i = (this.field_230708_k_ - this.xSize) / 2;
	      int j = (this.field_230709_l_ - this.ySize) / 2;
	      this.func_238474_b_(p_230450_1_, i, j, 0, 0, this.xSize, this.ySize);
	   }

}
