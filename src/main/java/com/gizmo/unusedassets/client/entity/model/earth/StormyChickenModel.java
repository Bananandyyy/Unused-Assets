package com.gizmo.unusedassets.client.entity.model.earth;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.ChickenModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class StormyChickenModel extends ChickenModel<Entity> {
	private final ModelRenderer main;
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer wings;
	private final ModelRenderer leftwing;
	private final ModelRenderer rightwing;
	private final ModelRenderer legs;
	private final ModelRenderer leftleg;
	private final ModelRenderer rightleg;

	public StormyChickenModel() {
		textureWidth = 64;
		textureHeight = 32;

		main = new ModelRenderer(this);
		main.setRotationPoint(2.0F, 22.0F, -6.0F);
		

		head = new ModelRenderer(this);
		head.setRotationPoint(-2.0F, -9.0F, 3.0F);
		main.addChild(head);
		head.setTextureOffset(0, 0).addBox(-2.0F, -4.0F, -3.0F, 4.0F, 6.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(14, 0).addBox(-2.0F, -2.0F, -5.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(15, 5).addBox(-1.0F, 0.0F, -4.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(1.0F, 2.0F, 10.0F);
		main.addChild(body);
		setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
		body.setTextureOffset(0, 9).addBox(-6.0F, -8.0F, 5.0F, 6.0F, 8.0F, 6.0F, 0.0F, false);

		wings = new ModelRenderer(this);
		wings.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(wings);
		

		leftwing = new ModelRenderer(this);
		leftwing.setRotationPoint(1.0F, -9.0F, 6.0F);
		wings.addChild(leftwing);
		leftwing.setTextureOffset(24, 13).addBox(0.0F, 0.0F, -3.0F, 1.0F, 4.0F, 6.0F, 0.0F, false);

		rightwing = new ModelRenderer(this);
		rightwing.setRotationPoint(-5.0F, -9.0F, 6.0F);
		wings.addChild(rightwing);
		rightwing.setTextureOffset(24, 13).addBox(-1.0F, 0.0F, -3.0F, 1.0F, 4.0F, 6.0F, 0.0F, true);

		legs = new ModelRenderer(this);
		legs.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(legs);
		

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(-0.5F, -3.0F, 6.0F);
		legs.addChild(leftleg);
		leftleg.setTextureOffset(36, 3).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 5.0F, 0.0F, 0.0F, false);
		leftleg.setTextureOffset(29, 0).addBox(-1.5F, 5.0F, -3.0F, 3.0F, 0.0F, 3.0F, 0.0F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(-3.5F, -3.0F, 6.0F);
		legs.addChild(rightleg);
		rightleg.setTextureOffset(36, 3).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 5.0F, 0.0F, 0.0F, true);
		rightleg.setTextureOffset(29, 0).addBox(-1.5F, 5.0F, -3.0F, 3.0F, 0.0F, 3.0F, 0.0F, true);
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