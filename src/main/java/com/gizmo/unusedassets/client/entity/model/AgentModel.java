package com.gizmo.unusedassets.client.entity.model;

import com.gizmo.unusedassets.entity.AgentEntity;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class AgentModel <T extends AgentEntity> extends SegmentedModel<T>{
	
	private final ModelRenderer Agent;
	private final ModelRenderer head;
	private final ModelRenderer nose;
	private final ModelRenderer body;
	private final ModelRenderer bodytop;
	private final ModelRenderer bodybottom;
	private final ModelRenderer arms;
	private final ModelRenderer leftarm;
	private final ModelRenderer rightarm;
	private final ModelRenderer legs;
	private final ModelRenderer leftleg;
	private final ModelRenderer rightleg;

	public AgentModel() {
		textureWidth = 32;
		textureHeight = 32;

		Agent = new ModelRenderer(this);
		Agent.setRotationPoint(0.0F, 24.0F, 0.0F);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Agent.addChild(head);
		head.setTextureOffset(0, 0).addBox(-3.0F, -16.0F, -3.0F, 6, 7, 5, 0.0F, false);

		nose = new ModelRenderer(this);
		nose.setRotationPoint(0.0F, 0.0F, 0.0F);
		Agent.addChild(nose);

		nose.setTextureOffset(17, 1).addBox(-1.0F, -12.0F, -4.0F, 2, 3, 1, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Agent.addChild(body);

		bodytop = new ModelRenderer(this);
		bodytop.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(bodytop);
		bodytop.setTextureOffset(0, 12).addBox(-4.0F, -9.0F, -2.0F, 8, 4, 4, 0.0F, false);
		
		bodybottom = new ModelRenderer(this);
		bodybottom.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(bodybottom);
		bodybottom.setTextureOffset(0, 20).addBox(-3.0F, -5.0F, -2.0F, 6, 2, 4, 0.0F, false);
		
		arms = new ModelRenderer(this);
		arms.setRotationPoint(0.0F, 0.0F, 0.0F);
		Agent.addChild(arms);

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(0.0F, 0.0F, 0.0F);
		arms.addChild(leftarm);
		leftarm.setTextureOffset(24, 0).addBox(4.0F, -9.0F, -1.0F, 2, 9, 2, 0.0F, false);
		
		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(0.0F, 0.0F, 0.0F);
		arms.addChild(rightarm);
		rightarm.setTextureOffset(24, 11).addBox(-6.0F, -9.0F, -1.0F, 2, 9, 2, 0.0F, false);
		
		legs = new ModelRenderer(this);
		legs.setRotationPoint(0.0F, 0.0F, 0.0F);
		Agent.addChild(legs);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(0.0F, 0.0F, 0.0F);
		legs.addChild(leftleg);
		leftleg.setTextureOffset(0, 26).addBox(1.0F, -3.0F, -1.0F, 2, 3, 2, 0.0F, false);
		
		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(0.0F, 0.0F, 0.0F);
		legs.addChild(rightleg);
		rightleg.setTextureOffset(8, 26).addBox(-3.0F, -3.0F, -1.0F, 2, 3, 2, 0.0F, false);
	}

	 public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		 this.Agent.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	 }

	@Override
	public Iterable<ModelRenderer> getParts() {
		return (Iterable<ModelRenderer>)ImmutableList.of(this.head, this.body, this.arms, this.legs, this.nose);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		
	}
}
