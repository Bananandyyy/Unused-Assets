package com.gizmo.unusedassets.client.entity.render.earth.layers;

import com.gizmo.unusedassets.client.entity.model.earth.VilerWitchModel;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.CrossedArmsItemLayer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.vector.Vector3f;

public class VilerWitchItemLayer<T extends LivingEntity> extends CrossedArmsItemLayer<T, VilerWitchModel<T>> {
	public VilerWitchItemLayer(IEntityRenderer<T, VilerWitchModel<T>> p_i50916_1_) {
		super(p_i50916_1_);
	}

	public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn,
			float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw,
			float headPitch) {
		ItemStack itemstack = entitylivingbaseIn.getHeldItemMainhand();
		matrixStackIn.push();
		if (itemstack.getItem() == Items.POTION) {
			this.getEntityModel().getModelHead().translateRotate(matrixStackIn);
			this.getEntityModel().getNose().translateRotate(matrixStackIn);
			matrixStackIn.translate(0.0625D, 0.25D, 0.0D);
			matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(180.0F));
			matrixStackIn.rotate(Vector3f.XP.rotationDegrees(140.0F));
			matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(10.0F));
			matrixStackIn.translate(0.0D, (double) -0.4F, (double) 0.4F);
		}

		super.render(matrixStackIn, bufferIn, packedLightIn, entitylivingbaseIn, limbSwing, limbSwingAmount,
				partialTicks, ageInTicks, netHeadYaw, headPitch);
		matrixStackIn.pop();
	}
}
