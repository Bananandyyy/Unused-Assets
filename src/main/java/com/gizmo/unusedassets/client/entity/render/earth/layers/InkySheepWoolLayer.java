package com.gizmo.unusedassets.client.entity.render.earth.layers;

import com.gizmo.unusedassets.client.entity.model.earth.InkySheepModel;
import com.gizmo.unusedassets.client.entity.model.earth.wools.InkySheepWoolModel;
import com.gizmo.unusedassets.entity.earth.InkySheepEntity;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

public class InkySheepWoolLayer extends LayerRenderer<InkySheepEntity, InkySheepModel<InkySheepEntity>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation("unusedassets",
			"textures/entity/earth/inky_sheep_fur.png");
	private final InkySheepWoolModel<InkySheepEntity> sheepModel = new InkySheepWoolModel<>();

	public InkySheepWoolLayer(IEntityRenderer<InkySheepEntity, InkySheepModel<InkySheepEntity>> rendererIn) {
		super(rendererIn);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn,
			InkySheepEntity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks,
			float ageInTicks, float netHeadYaw, float headPitch) {
		if (!entitylivingbaseIn.getSheared() && !entitylivingbaseIn.isInvisible()) {
			renderCopyCutoutModel(this.getEntityModel(), this.sheepModel, TEXTURE, matrixStackIn, bufferIn,
					packedLightIn, entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch,
					partialTicks, 1.0F, 1.0F, 1.0F);
		}

	}

}
