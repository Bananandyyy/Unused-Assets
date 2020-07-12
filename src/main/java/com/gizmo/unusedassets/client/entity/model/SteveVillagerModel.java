package com.gizmo.unusedassets.client.entity.model;

import com.gizmo.unusedassets.entity.SteveVillagerEntity;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.IHasHead;
import net.minecraft.client.renderer.entity.model.IHeadToggle;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class SteveVillagerModel<T extends SteveVillagerEntity> extends SegmentedModel<T> implements IHasHead, IHeadToggle {
  private final ModelRenderer Body;
  
  private final ModelRenderer robe;
  
  private final ModelRenderer head;
  
  private final ModelRenderer nose;
  
  private final ModelRenderer Arms;
  
  private final ModelRenderer leftarm;
  
  private final ModelRenderer rightarm;
  
  private final ModelRenderer connector;
  
  private final ModelRenderer Legs;
  
  private final ModelRenderer leftleg;
  
  private final ModelRenderer rightleg;
  
  public SteveVillagerModel(float scale) {
    this(scale, 64, 64);
  }
  
  public SteveVillagerModel(float scale, int i, int j) {
    this.Body = (new ModelRenderer((Model)this)).setTextureSize(i, j);
    this.Body.setRotationPoint(0.0F, 24.0F, 0.0F);
    this.Body.setTextureOffset(0, 17).addBox(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
    this.robe = (new ModelRenderer((Model)this)).setTextureSize(i, j);
    this.robe.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.Body.addChild(this.robe);
    this.robe.setTextureOffset(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 20.0F, 6.0F, 0.5F, false);
    this.head = (new ModelRenderer((Model)this)).setTextureSize(i, j);
    this.head.setRotationPoint(0.0F, -26.5F, -2.5F);
    this.Body.addChild(this.head);
    this.head.setTextureOffset(0, 0).addBox(-4.0F, -5.5F, -1.5F, 8.0F, 8.0F, 8.0F, 0.0F, false);
    this.nose = (new ModelRenderer((Model)this)).setTextureSize(i, j);
    this.nose.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.Body.addChild(this.nose);
    this.nose.setTextureOffset(25, 1).addBox(-1.0F, -27.0F, -6.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
    this.Arms = (new ModelRenderer((Model)this)).setTextureSize(i, j);
    this.Arms.setRotationPoint(0.0F, 2.0F, 0.0F);
    this.Body.addChild(this.Arms);
    this.leftarm = (new ModelRenderer((Model)this)).setTextureSize(i, j);
    this.leftarm.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.Arms.addChild(this.leftarm);
    this.leftarm.setTextureOffset(44, 40).addBox(4.0F, -21.0F, -19.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
    this.rightarm = (new ModelRenderer((Model)this)).setTextureSize(i, j);
    this.rightarm.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.Arms.addChild(this.rightarm);
    this.rightarm.setTextureOffset(44, 40).addBox(-8.0F, -21.0F, -19.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
    this.connector = (new ModelRenderer((Model)this)).setTextureSize(i, j);
    this.connector.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.Arms.addChild(this.connector);
    this.connector.setTextureOffset(40, 56).addBox(-4.0F, -17.0F, -19.0F, 8.0F, 4.0F, 4.0F, 0.0F, false);
    this.Legs = (new ModelRenderer((Model)this)).setTextureSize(i, j);
    this.Legs.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.Body.addChild(this.Legs);
    this.leftleg = (new ModelRenderer((Model)this)).setTextureSize(i, j);
    this.leftleg.setRotationPoint(0.0F, -12.0F, 0.0F);
    this.Legs.addChild(this.leftleg);
    this.leftleg.setTextureOffset(48, 16).addBox(0.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
    this.rightleg = (new ModelRenderer((Model)this)).setTextureSize(i, j);
    this.rightleg.setRotationPoint(0.0F, -12.0F, 0.0F);
    this.Legs.addChild(this.rightleg);
    this.rightleg.setTextureOffset(48, 16).addBox(-4.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
  }
  
  public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
    this.Body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
  }
  
  public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    this.head.rotateAngleY = netHeadYaw * 0.017453292F;
    this.head.rotateAngleX = headPitch * 0.017453292F;
    this.Arms.rotationPointY = 3.0F;
    this.Arms.rotationPointZ = -1.0F;
    this.Arms.rotateAngleX = -0.75F;
    this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
    this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount * 0.5F;
    this.rightleg.rotateAngleY = 0.0F;
    this.leftleg.rotateAngleY = 0.0F;
  }
  
  public ModelRenderer getModelHead() {
    return this.head;
  }
  
  public void func_217146_a(boolean p_217146_1_) {
    this.head.showModel = p_217146_1_;
  }
  
  public Iterable<ModelRenderer> getParts() {
    return (Iterable<ModelRenderer>)ImmutableList.of(this.head, this.Body, this.Arms, this.Legs, this.nose);
  }
}
