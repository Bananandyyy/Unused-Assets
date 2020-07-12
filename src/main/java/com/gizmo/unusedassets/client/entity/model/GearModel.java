package com.gizmo.unusedassets.client.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;

public class GearModel extends Model
{
	ModelRenderer down;

	public GearModel()
	{
		super(RenderType::getEntityCutoutNoCull);
		this.textureHeight = 16;
		this.textureWidth = 16;

		down = new ModelRenderer(this, 0, 0);
		down.addBox(-8, -6.5f, -8, 16, 0, 16);
		down.setRotationPoint(0, 0, 0);
		down.setTextureSize(16, 16);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha)
	{
		this.down.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
	}
}