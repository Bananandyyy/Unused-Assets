package com.gizmo.unusedassets.client.entity.model.earth;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class FancyChickenModel<T extends Entity> extends AgeableModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer tail;
	private final ModelRenderer head;
	private final ModelRenderer frill;
	private final ModelRenderer comb;
	private final ModelRenderer beak;
	private final ModelRenderer leg0;
	private final ModelRenderer leg1;
	private final ModelRenderer wing0;
	private final ModelRenderer wing1;

	public FancyChickenModel() {
		textureWidth = 64;
		textureHeight = 32;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 16.0F, 0.0F);
		setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
		body.setTextureOffset(40, 14).addBox(-3.0F, -4.0F, -3.0F, 6.0F, 8.0F, 6.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, -1.0F, 4.0F);
		body.addChild(tail);
		setRotationAngle(tail, -1.5708F, 0.0F, 0.0F);
		tail.setTextureOffset(19, 4).addBox(0.0F, -7.0F, 5.0F, 0.0F, 10.0F, 7.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 15.0F, -4.0F);
		head.setTextureOffset(0, 23).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 3.0F, 0.0F, false);

		frill = new ModelRenderer(this);
		frill.setRotationPoint(0.0F, -5.0F, 2.0F);
		head.addChild(frill);
		setRotationAngle(frill, 0.0F, 3.1416F, 0.0F);
		frill.setTextureOffset(14, 22).addBox(0.0F, -5.0F, 0.0F, 0.0F, 5.0F, 5.0F, 0.0F, false);

		comb = new ModelRenderer(this);
		comb.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(comb);
		comb.setTextureOffset(0, 9).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		beak = new ModelRenderer(this);
		beak.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(beak);
		beak.setTextureOffset(14, 23).addBox(-2.0F, -4.0F, -4.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		leg0 = new ModelRenderer(this);
		leg0.setRotationPoint(-2.0F, 19.0F, 1.0F);
		leg0.setTextureOffset(38, 4).addBox(-1.0F, 0.0F, -3.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(1.0F, 19.0F, 1.0F);
		leg1.setTextureOffset(38, 4).addBox(-1.0F, 0.0F, -3.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);

		wing0 = new ModelRenderer(this);
		wing0.setRotationPoint(-3.0F, 13.0F, 0.0F);
		wing0.setTextureOffset(32, 22).addBox(-1.0F, 0.0F, -3.0F, 1.0F, 4.0F, 6.0F, 0.0F, false);

		wing1 = new ModelRenderer(this);
		wing1.setRotationPoint(3.0F, 13.0F, 0.0F);
		wing1.setTextureOffset(32, 22).addBox(0.0F, 0.0F, -3.0F, 1.0F, 4.0F, 6.0F, 0.0F, false);
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
		return ImmutableList.of(this.body, this.leg0, this.leg1, this.wing0, this.wing1);
	}
	
	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
        this.body.rotateAngleX = ((float) Math.PI / 2F);
        this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg0.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.wing0.rotateAngleZ = ageInTicks;
        this.wing1.rotateAngleZ = -ageInTicks;
    }
}