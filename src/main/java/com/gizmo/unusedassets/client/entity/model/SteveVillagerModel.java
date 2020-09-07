package com.gizmo.unusedassets.client.entity.model;

import com.gizmo.unusedassets.entity.SteveVillagerEntity;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.IHasHead;
import net.minecraft.client.renderer.entity.model.IHeadToggle;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class SteveVillagerModel<T extends SteveVillagerEntity> extends SegmentedModel<T> implements IHasHead, IHeadToggle {
	private final ModelRenderer body;
	private final ModelRenderer robe;
	private final ModelRenderer head;
	private final ModelRenderer Arms;
	private final ModelRenderer leftarm;
	private final ModelRenderer rightarm;
	private final ModelRenderer connector;
	private final ModelRenderer Legs;
	private final ModelRenderer leftleg;
	private final ModelRenderer rightleg;

	public SteveVillagerModel() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(0, 17).addBox(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

		robe = new ModelRenderer(this);
		robe.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(robe);
		robe.setTextureOffset(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 20.0F, 6.0F, 0.2F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -23.5F, 0.5F);
		body.addChild(head);
		head.setTextureOffset(0, 0).addBox(-4.0F, -8.5F, -4.5F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(25, 1).addBox(-1.0F, -3.5F, -6.5F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		Arms = new ModelRenderer(this);
		Arms.setRotationPoint(0.0F, -20.0F, 0.0F);
		body.addChild(Arms);
		setRotationAngle(Arms, -0.5236F, 0.0F, 0.0F);
		

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(4.0F, -2.0F, -1.0F);
		Arms.addChild(leftarm);
		leftarm.setTextureOffset(44, 40).addBox(0.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(-3.0F, -2.0F, -1.0F);
		Arms.addChild(rightarm);
		rightarm.setTextureOffset(44, 40).addBox(-5.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);

		connector = new ModelRenderer(this);
		connector.setRotationPoint(0.0F, 0.0F, 0.0F);
		Arms.addChild(connector);
		connector.setTextureOffset(40, 56).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 4.0F, 4.0F, 0.0F, false);

		Legs = new ModelRenderer(this);
		Legs.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(Legs);
		

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(2.0F, -12.0F, 0.0F);
		Legs.addChild(leftleg);
		leftleg.setTextureOffset(48, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(-2.0F, -12.0F, 0.0F);
		Legs.addChild(rightleg);
		rightleg.setTextureOffset(48, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	      this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
	      this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
	      this.head.rotateAngleZ = 0.0F;

	      this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
	      this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;
	      this.rightleg.rotateAngleY = 0.0F;
	      this.leftleg.rotateAngleY = 0.0F;
	   }

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void func_217146_a(boolean p_217146_1_) {
		this.head.showModel = p_217146_1_;
	}

	@Override
	public ModelRenderer getModelHead() {
		return this.head;
	}

	@Override
	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.head, this.body, this.rightleg, this.leftleg, this.leftarm, this.rightarm, this.connector);
	}
}