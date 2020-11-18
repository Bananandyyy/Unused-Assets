package com.gizmo.unusedassets.client.entity.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class LoveGolemModel<T extends LivingEntity> extends SegmentedModel<T> {
	
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer leftarm;
	private final ModelRenderer rightarm;
	private final ModelRenderer leftleg;
	private final ModelRenderer rightleg;

	public LoveGolemModel() {
		textureWidth = 128;
		textureHeight = 128;

		this.head = (new ModelRenderer(this)).setTextureSize(128, 128);
	      this.head.setRotationPoint(0.0F, -7.0F, -2.0F);
	      this.head.setTextureOffset(0, 0).addBox(-4.0F, -12.0F, -5.5F, 8.0F, 10.0F, 8.0F, 0.0F);
	      this.head.setTextureOffset(24, 0).addBox(-1.0F, -5.0F, -7.5F, 2.0F, 4.0F, 2.0F, 0.0F);
	      this.body = (new ModelRenderer(this)).setTextureSize(128, 128);
	      this.body.setRotationPoint(0.0F, -7.0F, 0.0F);
	      this.body.setTextureOffset(0, 40).addBox(-9.0F, -2.0F, -6.0F, 18.0F, 12.0F, 11.0F, 0.0F);
	      this.body.setTextureOffset(0, 70).addBox(-4.5F, 10.0F, -3.0F, 9.0F, 5.0F, 6.0F, 0.5F);
	      this.rightarm = (new ModelRenderer(this)).setTextureSize(128, 128);
	      this.rightarm.setRotationPoint(0.0F, -7.0F, 0.0F);
	      this.rightarm.setTextureOffset(60, 21).addBox(-13.0F, -2.5F, -3.0F, 4.0F, 30.0F, 6.0F, 0.0F);
	      this.leftarm = (new ModelRenderer(this)).setTextureSize(128, 128);
	      this.leftarm.setRotationPoint(0.0F, -7.0F, 0.0F);
	      this.leftarm.setTextureOffset(60, 58).addBox(9.0F, -2.5F, -3.0F, 4.0F, 30.0F, 6.0F, 0.0F);
	      this.leftleg = (new ModelRenderer(this, 0, 22)).setTextureSize(128, 128);
	      this.leftleg.setRotationPoint(-4.0F, 11.0F, 0.0F);
	      this.leftleg.setTextureOffset(37, 0).addBox(-3.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F, 0.0F);
	      this.rightleg = (new ModelRenderer(this, 0, 22)).setTextureSize(128, 128);
	      this.rightleg.mirror = true;
	      this.rightleg.setTextureOffset(60, 0).setRotationPoint(5.0F, 11.0F, 0.0F);
	      this.rightleg.addBox(-3.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F, 0.0F);
	}
	
	@Override
	public Iterable<ModelRenderer> getParts() {
		return (Iterable<ModelRenderer>)ImmutableList.of(this.head, this.body, this.leftarm, this.rightarm, this.leftleg, this.rightleg);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	      this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
	      this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
	      this.leftleg.rotateAngleX = -1.5F * this.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
	      this.rightleg.rotateAngleX = 1.5F * this.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
	      this.leftleg.rotateAngleY = 0.0F;
	      this.rightleg.rotateAngleY = 0.0F;
	   }
	
	private float triangleWave(float rot1, float rot2) {
	      return (Math.abs(rot1 % rot2 - rot2 * 0.5F) - rot2 * 0.25F) / (rot2 * 0.25F);
	   }
}
