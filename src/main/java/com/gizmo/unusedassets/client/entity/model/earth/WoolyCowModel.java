package com.gizmo.unusedassets.client.entity.model.earth;

import com.gizmo.unusedassets.entity.earth.WoolyCowEntity;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class WoolyCowModel<T extends WoolyCowEntity> extends AgeableModel<T> {
	private final ModelRenderer main;
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer legs;
	private final ModelRenderer rightfront;
	private final ModelRenderer rightback;
	private final ModelRenderer leftfront;
	private final ModelRenderer leftback;

	public WoolyCowModel() {
		textureWidth = 64;
		textureHeight = 32;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 24.0F, 0.0F);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -14.0F, -8.0F);
		main.addChild(head);
		head.setTextureOffset(0, 0).addBox(-4.0F, -10.0F, -7.0F, 8.0F, 8.0F, 6.0F, 0.0F, false);
		head.setTextureOffset(22, 0).addBox(4.0F, -11.0F, -4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(22, 0).addBox(-5.0F, -11.0F, -4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(6.0F, -10.0F, 11.0F);
		main.addChild(body);
		setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
		body.setTextureOffset(18, 4).addBox(-12.0F, -20.0F, 2.0F, 12.0F, 18.0F, 10.0F, 0.0F, false);

		legs = new ModelRenderer(this);
		legs.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(legs);

		rightfront = new ModelRenderer(this);
		rightfront.setRotationPoint(-4.0F, -11.0F, -6.0F);
		legs.addChild(rightfront);
		rightfront.setTextureOffset(0, 16).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		rightback = new ModelRenderer(this);
		rightback.setRotationPoint(-5.0F, -11.0F, 6.0F);
		legs.addChild(rightback);
		rightback.setTextureOffset(0, 16).addBox(-1.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		leftfront = new ModelRenderer(this);
		leftfront.setRotationPoint(4.0F, -11.0F, -6.0F);
		legs.addChild(leftfront);
		leftfront.setTextureOffset(0, 16).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		leftback = new ModelRenderer(this);
		leftback.setRotationPoint(4.0F, -11.0F, 6.0F);
		legs.addChild(leftback);
		leftback.setTextureOffset(0, 16).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	protected Iterable<ModelRenderer> getHeadParts() {
		return ImmutableList.of(this.head);
	}

	@Override
	protected Iterable<ModelRenderer> getBodyParts() {
		return ImmutableList.of(this.body, this.legs);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		this.head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		this.body.rotateAngleX = ((float) Math.PI / 2F);
		this.rightback.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftback.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.rightfront.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leftfront.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}
}