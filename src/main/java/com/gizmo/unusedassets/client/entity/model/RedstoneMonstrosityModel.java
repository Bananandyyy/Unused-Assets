package com.gizmo.unusedassets.client.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class RedstoneMonstrosityModel extends EntityModel<Entity> {
	private final ModelRenderer main;
	private final ModelRenderer head;
	private final ModelRenderer mouth;
	private final ModelRenderer lefthorn;
	private final ModelRenderer righthorn;
	private final ModelRenderer body;
	private final ModelRenderer leftarm;
	private final ModelRenderer finger1;
	private final ModelRenderer finger2;
	private final ModelRenderer finger3;
	private final ModelRenderer rightarm;
	private final ModelRenderer finger4;
	private final ModelRenderer finger5;
	private final ModelRenderer finger6;
	private final ModelRenderer leftleg;
	private final ModelRenderer rightleg;

	public RedstoneMonstrosityModel() {
		textureWidth = 512;
		textureHeight = 512;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(head);
		head.setTextureOffset(204, 144).addBox(-12.0F, -99.0F, -38.0F, 28.0F, 31.0F, 22.0F, 0.1F, false);
		head.setTextureOffset(0, 331).addBox(-12.0F, -80.0F, -38.2F, 4.0F, 4.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 331).addBox(12.0F, -80.0F, -38.2F, 4.0F, 4.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(14, 331).addBox(0.0F, -83.0F, -38.2F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		mouth = new ModelRenderer(this);
		mouth.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(mouth);
		mouth.setTextureOffset(92, 251).addBox(-12.0F, -73.0F, -38.0F, 28.0F, 7.0F, 22.0F, 0.0F, false);
		mouth.setTextureOffset(246, 280).addBox(-12.0F, -67.0F, -38.0F, 28.0F, 1.0F, 22.0F, 0.0F, false);

		lefthorn = new ModelRenderer(this);
		lefthorn.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(lefthorn);
		lefthorn.setTextureOffset(0, 304).addBox(-32.0F, -94.0F, -34.0F, 20.0F, 13.0F, 13.0F, 0.0F, false);
		lefthorn.setTextureOffset(66, 304).addBox(-32.0F, -109.0F, -34.0F, 8.0F, 15.0F, 13.0F, 0.0F, false);

		righthorn = new ModelRenderer(this);
		righthorn.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(righthorn);
		righthorn.setTextureOffset(284, 251).addBox(16.0F, -94.0F, -34.0F, 20.0F, 13.0F, 13.0F, 0.0F, false);
		righthorn.setTextureOffset(108, 304).addBox(28.0F, -109.0F, -34.0F, 8.0F, 15.0F, 13.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(body);
		body.setTextureOffset(0, 0).addBox(-37.0F, -99.0F, -16.0F, 74.0F, 59.0F, 32.0F, 0.0F, false);
		body.setTextureOffset(192, 251).addBox(-13.0F, -40.0F, -9.0F, 26.0F, 11.0F, 18.0F, 0.0F, false);

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(leftarm);
		leftarm.setTextureOffset(0, 91).addBox(-74.0F, -94.0F, -15.0F, 37.0F, 22.0F, 31.0F, 0.0F, false);
		leftarm.setTextureOffset(0, 144).addBox(-57.0F, -117.0F, -15.0F, 20.0F, 23.0F, 31.0F, 0.0F, false);
		leftarm.setTextureOffset(0, 250).addBox(-67.0F, -73.0F, -9.0F, 23.0F, 30.0F, 23.0F, 0.0F, false);
		leftarm.setTextureOffset(136, 91).addBox(-70.0F, -43.0F, -13.0F, 30.0F, 20.0F, 30.0F, 0.0F, false);

		finger1 = new ModelRenderer(this);
		finger1.setRotationPoint(-50.0F, -11.0F, 3.0F);
		leftarm.addChild(finger1);
		setRotationAngle(finger1, 0.0F, 0.0F, 0.2618F);
		finger1.setTextureOffset(214, 304).addBox(-3.0F, -17.0F, -3.0F, 6.0F, 15.0F, 5.0F, 0.0F, true);

		finger2 = new ModelRenderer(this);
		finger2.setRotationPoint(-60.0F, -13.0F, 6.0F);
		leftarm.addChild(finger2);
		setRotationAngle(finger2, 0.0F, 0.0F, -0.3491F);
		finger2.setTextureOffset(214, 304).addBox(-2.0F, -13.0F, -2.0F, 6.0F, 15.0F, 5.0F, 0.0F, false);

		finger3 = new ModelRenderer(this);
		finger3.setRotationPoint(-60.0F, -13.0F, -3.0F);
		leftarm.addChild(finger3);
		setRotationAngle(finger3, 0.0F, 0.0F, -0.3491F);
		finger3.setTextureOffset(214, 304).addBox(-2.0F, -13.0F, -2.0F, 6.0F, 15.0F, 5.0F, 0.0F, false);

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(rightarm);
		rightarm.setTextureOffset(0, 91).addBox(37.0F, -94.0F, -15.0F, 37.0F, 22.0F, 31.0F, 0.0F, true);
		rightarm.setTextureOffset(0, 144).addBox(37.0F, -117.0F, -15.0F, 20.0F, 23.0F, 31.0F, 0.0F, true);
		rightarm.setTextureOffset(0, 250).addBox(44.0F, -73.0F, -9.0F, 23.0F, 30.0F, 23.0F, 0.0F, true);
		rightarm.setTextureOffset(136, 91).addBox(40.0F, -43.0F, -13.0F, 30.0F, 20.0F, 30.0F, 0.0F, true);

		finger4 = new ModelRenderer(this);
		finger4.setRotationPoint(50.0F, -11.0F, 3.0F);
		rightarm.addChild(finger4);
		setRotationAngle(finger4, 0.0F, 0.0F, -0.2618F);
		finger4.setTextureOffset(214, 304).addBox(-3.0F, -17.0F, -3.0F, 6.0F, 15.0F, 5.0F, 0.0F, false);

		finger5 = new ModelRenderer(this);
		finger5.setRotationPoint(60.0F, -13.0F, 6.0F);
		rightarm.addChild(finger5);
		setRotationAngle(finger5, 0.0F, 0.0F, 0.3491F);
		finger5.setTextureOffset(214, 304).addBox(-4.0F, -13.0F, -2.0F, 6.0F, 15.0F, 5.0F, 0.0F, true);

		finger6 = new ModelRenderer(this);
		finger6.setRotationPoint(60.0F, -13.0F, -3.0F);
		rightarm.addChild(finger6);
		setRotationAngle(finger6, 0.0F, 0.0F, 0.3491F);
		finger6.setTextureOffset(214, 304).addBox(-4.0F, -13.0F, -2.0F, 6.0F, 15.0F, 5.0F, 0.0F, true);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(leftleg);
		leftleg.setTextureOffset(0, 198).addBox(-35.0F, -29.0F, -9.0F, 24.0F, 29.0F, 24.0F, 0.0F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(rightleg);
		rightleg.setTextureOffset(0, 198).addBox(11.0F, -29.0F, -9.0F, 24.0F, 29.0F, 24.0F, 0.0F, true);
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