package com.gizmo.unusedassets.client.entity.model.earth;

import com.gizmo.unusedassets.entity.earth.FleckedSheepEntity;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class FleckedSheepModel<T extends FleckedSheepEntity> extends AgeableModel<T> {
	private final ModelRenderer main;
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer legs;
	private final ModelRenderer leftfront;
	private final ModelRenderer leftback;
	private final ModelRenderer rightfront;
	private final ModelRenderer rightback;

	public FleckedSheepModel() {
		textureWidth = 64;
		textureHeight = 32;

		main = new ModelRenderer(this);
		main.setRotationPoint(4.0F, 16.0F, -4.0F);
		

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(head);
		head.setTextureOffset(0, 0).addBox(-6.0F, -13.0F, -11.0F, 6.0F, 6.0F, 8.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(1.0F, -4.0F, 11.0F);
		main.addChild(body);
		setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
		body.setTextureOffset(28, 8).addBox(-8.0F, -16.0F, 0.0F, 8.0F, 16.0F, 6.0F, 0.0F, false);

		legs = new ModelRenderer(this);
		legs.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(legs);
		

		leftfront = new ModelRenderer(this);
		leftfront.setRotationPoint(0.0F, -3.0F, -2.0F);
		legs.addChild(leftfront);
		leftfront.setTextureOffset(0, 16).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		leftback = new ModelRenderer(this);
		leftback.setRotationPoint(0.0F, -3.0F, 10.0F);
		legs.addChild(leftback);
		leftback.setTextureOffset(0, 16).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		rightfront = new ModelRenderer(this);
		rightfront.setRotationPoint(-6.0F, -3.0F, -2.0F);
		legs.addChild(rightfront);
		rightfront.setTextureOffset(0, 16).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		rightback = new ModelRenderer(this);
		rightback.setRotationPoint(-6.0F, -3.0F, 10.0F);
		legs.addChild(rightback);
		rightback.setTextureOffset(0, 16).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
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
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){

	}

}