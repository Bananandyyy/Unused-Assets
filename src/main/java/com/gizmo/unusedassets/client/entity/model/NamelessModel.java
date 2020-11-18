package com.gizmo.unusedassets.client.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class NamelessModel<T extends LivingEntity> extends SegmentedModel<T> {
	private final ModelRenderer main;
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer cape;
	private final ModelRenderer backcape;
	private final ModelRenderer rightarm;
	private final ModelRenderer leftarm;
	private final ModelRenderer cloak;
	private final ModelRenderer wand;

	public NamelessModel() {
		textureWidth = 128;
		textureHeight = 128;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(head);
		head.setTextureOffset(0, 0).addBox(-4.0F, -30.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(0, 16).addBox(-4.0F, -31.5F, -4.0F, 8.0F, 5.0F, 8.0F, 0.1F, false);
		head.setTextureOffset(40, 10).addBox(-3.0F, -27.0F, -4.05F, 6.0F, 3.0F, 1.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(body);
		body.setTextureOffset(0, 30).addBox(-4.0F, -22.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

		cape = new ModelRenderer(this);
		cape.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(cape);
		setRotationAngle(cape, 0.0F, 1.5708F, 0.0F);
		cape.setTextureOffset(27, 71).addBox(-3.0F, -23.0F, -9.0F, 6.0F, 5.0F, 6.0F, 0.0F, false);
		cape.setTextureOffset(26, 83).addBox(-3.0F, -23.0F, 3.0F, 6.0F, 5.0F, 6.0F, 0.0F, false);

		backcape = new ModelRenderer(this);
		backcape.setRotationPoint(-2.0F, -23.0F, 0.0F);
		cape.addChild(backcape);
		setRotationAngle(backcape, 0.0F, 0.0F, 0.0873F);
		backcape.setTextureOffset(0, 93).addBox(0.0F, 0.0F, -6.0F, 4.0F, 22.0F, 12.0F, 0.1F, false);

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(-5.0F, -16.0F, 0.0F);
		main.addChild(rightarm);
		setRotationAngle(rightarm, -0.0873F, 0.0F, 0.0F);
		rightarm.setTextureOffset(0, 46).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(5.0F, -21.0F, 0.0F);
		main.addChild(leftarm);
		setRotationAngle(leftarm, -0.3491F, 0.0F, 0.0F);
		leftarm.setTextureOffset(0, 46).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);

		cloak = new ModelRenderer(this);
		cloak.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(cloak);
		cloak.setTextureOffset(0, 60).addBox(-4.0F, -10.0F, -2.0F, 8.0F, 10.0F, 4.0F, 0.0F, false);

		wand = new ModelRenderer(this);
		wand.setRotationPoint(5.0F, -13.0F, -3.0F);
		main.addChild(wand);
		setRotationAngle(wand, 0.2618F, 0.3491F, 0.0873F);
		wand.setTextureOffset(0, 74).addBox(-0.3F, -12.0F, -1.0F, 1.0F, 26.0F, 1.0F, 0.0F, false);
		wand.setTextureOffset(11, 54).addBox(-1.3F, -15.0F, -2.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
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

	@Override
	public Iterable<ModelRenderer> getParts() {
		return (Iterable<ModelRenderer>)ImmutableList.of(this.head, this.body, this.leftarm, this.rightarm, this.cape, this.cloak, this.backcape, this.wand);
	}

}