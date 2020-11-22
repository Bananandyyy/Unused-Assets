package com.gizmo.unusedassets.client.entity.model.earth;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class VilerWitchModel<T extends Entity> extends SegmentedModel<T> {
	private final ModelRenderer head;
	private final ModelRenderer nose;
	private final ModelRenderer hat;
	private final ModelRenderer hat2;
	private final ModelRenderer hat3;
	private final ModelRenderer hat4;
	private final ModelRenderer body;
	private final ModelRenderer arms;
	private final ModelRenderer leg0;
	private final ModelRenderer leg1;
	private boolean holdingItem;

	public VilerWitchModel() {
		textureWidth = 128;
		textureHeight = 128;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.setTextureOffset(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(28, 47).addBox(-4.5F, -4.0F, -4.5F, 9.0F, 4.0F, 9.0F, 0.0F, false);

		nose = new ModelRenderer(this);
		nose.setRotationPoint(0.0F, 24.0F, 0.0F);
		head.addChild(nose);
		nose.setTextureOffset(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		nose.setTextureOffset(0, 0).addBox(0.0F, -0.0F, -6.75F, 1.0F, 1.0F, 1.0F, -0.25F, false);

		hat = new ModelRenderer(this);
		hat.setRotationPoint(-5.0F, -8.0313F, -5.0F);
		head.addChild(hat);
		hat.setTextureOffset(14, 106).addBox(-5.0F, -2.0187F, -5.0F, 20.0F, 2.0F, 20.0F, 0.0F, false);

		hat2 = new ModelRenderer(this);
		hat2.setRotationPoint(6.75F, 0.0313F, 7.0F);
		hat.addChild(hat2);
		setRotationAngle(hat2, -0.0524F, 0.0F, 0.0262F);
		hat2.setTextureOffset(0, 76).addBox(-5.0F, -5.5F, -5.0F, 7.0F, 4.0F, 7.0F, 0.0F, false);

		hat3 = new ModelRenderer(this);
		hat3.setRotationPoint(0.0F, -3.0F, 0.0F);
		hat2.addChild(hat3);
		setRotationAngle(hat3, -0.1047F, 0.0F, 0.0524F);
		hat3.setTextureOffset(0, 87).addBox(-3.25F, -5.5F, -3.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

		hat4 = new ModelRenderer(this);
		hat4.setRotationPoint(0.0F, -3.0F, 0.0F);
		hat3.addChild(hat4);
		setRotationAngle(hat4, -0.2094F, 0.0F, 0.1047F);
		hat4.setTextureOffset(0, 95).addBox(-1.5F, -4.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.25F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, 0.0F, false);
		body.setTextureOffset(0, 95).addBox(-5.0F, -24.0F, -3.0F, 10.0F, 18.0F, 7.0F, 0.5F, false);

		arms = new ModelRenderer(this);
		arms.setRotationPoint(0.0F, 2.0F, 0.0F);
		setRotationAngle(arms, -0.7854F, 0.0F, 0.0F);
		arms.setTextureOffset(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, 0.0F, false);
		arms.setTextureOffset(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
		arms.setTextureOffset(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
		arms.setTextureOffset(33, 1).addBox(-9.0F, -2.4142F, -2.5F, 5.0F, 5.0F, 5.0F, 0.2F, false);
		arms.setTextureOffset(33, 1).addBox(4.0F, -2.4142F, -2.5F, 5.0F, 5.0F, 5.0F, 0.2F, true);

		leg0 = new ModelRenderer(this);
		leg0.setRotationPoint(-2.0F, 12.0F, 0.0F);
		leg0.setTextureOffset(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(2.0F, 12.0F, 0.0F);
		leg1.setTextureOffset(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
	      this.nose.setRotationPoint(0.0F, -2.0F, 0.0F);
	      float f = 0.01F * (float)(entity.getEntityId() % 10);
	      this.nose.rotateAngleX = MathHelper.sin((float)entity.ticksExisted * f) * 4.5F * ((float)Math.PI / 180F);
	      this.nose.rotateAngleY = 0.0F;
	      this.nose.rotateAngleZ = MathHelper.cos((float)entity.ticksExisted * f) * 2.5F * ((float)Math.PI / 180F);
	      if (this.holdingItem) {
	         this.nose.setRotationPoint(0.0F, 1.0F, -1.5F);
	         this.nose.rotateAngleX = -0.9F;
	      }
	      this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
	      this.leg0.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;
	      this.leg1.rotateAngleY = 0.0F;
	      this.leg0.rotateAngleY = 0.0F;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		arms.render(matrixStack, buffer, packedLight, packedOverlay);
		leg0.render(matrixStack, buffer, packedLight, packedOverlay);
		leg1.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.head, this.body, this.arms, this.leg0, this.leg1);
	}

	public ModelRenderer getModelHead() {
		return this.head;
	}

	public ModelRenderer getNose() {
		return this.nose;
	}
}