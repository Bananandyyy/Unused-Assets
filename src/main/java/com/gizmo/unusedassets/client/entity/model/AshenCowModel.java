package com.gizmo.unusedassets.client.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.CowModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class AshenCowModel extends CowModel<Entity> {
	private final ModelRenderer main;
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer legs;
	private final ModelRenderer rightfront;
	private final ModelRenderer rightback;
	private final ModelRenderer leftfront;
	private final ModelRenderer leftback;

	public AshenCowModel() {
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
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
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
}