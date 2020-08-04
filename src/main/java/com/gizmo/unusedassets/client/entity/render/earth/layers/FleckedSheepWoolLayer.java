package com.gizmo.unusedassets.client.entity.render.earth.layers;

import com.gizmo.unusedassets.client.entity.model.earth.FleckedSheepModel;
import com.gizmo.unusedassets.client.entity.model.earth.wools.FleckedSheepWoolModel;
import com.gizmo.unusedassets.entity.earth.FleckedSheepEntity;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

public class FleckedSheepWoolLayer extends LayerRenderer<FleckedSheepEntity, FleckedSheepModel<FleckedSheepEntity>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation("unusedassets",
			"textures/entity/earth/flecked_sheep_fur.png");
	private final FleckedSheepWoolModel<FleckedSheepEntity> sheepModel = new FleckedSheepWoolModel<>();

	public FleckedSheepWoolLayer(
			IEntityRenderer<FleckedSheepEntity, FleckedSheepModel<FleckedSheepEntity>> rendererIn) {
		super(rendererIn);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn,
			FleckedSheepEntity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks,
			float ageInTicks, float netHeadYaw, float headPitch) {
		if (!entitylivingbaseIn.getSheared() && !entitylivingbaseIn.isInvisible()) {
			renderCopyCutoutModel(this.getEntityModel(), this.sheepModel, TEXTURE, matrixStackIn, bufferIn,
					packedLightIn, entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch,
					partialTicks, 1.0F, 1.0F, 1.0F);
		}

	}

}
