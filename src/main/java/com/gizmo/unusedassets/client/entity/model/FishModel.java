package com.gizmo.unusedassets.client.entity.model;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FishModel<T extends LivingEntity> extends SegmentedModel<T> {
  public ModelRenderer body;
  
  public ModelRenderer upper_fin;
  
  public ModelRenderer back_fin;
  
  public ModelRenderer left_fin;
  
  public ModelRenderer right_fin;
  
  public FishModel() {
    this.textureWidth = 64;
    this.textureHeight = 32;
    this.body = new ModelRenderer((Model)this, 0, 0);
    this.body.setRotationPoint(0.0F, 22.0F, 0.0F);
    this.body.addBox(-1.0F, -2.0F, -4.0F, 2.0F, 4.0F, 8.0F);
    this.upper_fin = new ModelRenderer((Model)this, 0, 10);
    this.upper_fin.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.upper_fin.addBox(0.0F, 18.0F, -3.0F, 0.0F, 2.0F, 7.0F);
    this.back_fin = new ModelRenderer((Model)this, 0, 15);
    this.back_fin.addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 5.0F);
    this.back_fin.setRotationPoint(0.0F, 22.0F, 4.0F);
    this.right_fin = new ModelRenderer((Model)this, 0, 10);
    this.right_fin.setRotationPoint(-1.0F, 23.0F, 0.0F);
    this.right_fin.addBox(-0.1F, -1.0F, -2.0F, 0.0F, 2.0F, 4.0F);
    setRotateAngle(this.right_fin, 0.0F, -0.08726646F, 0.0F);
    this.left_fin = new ModelRenderer((Model)this, 0, 10);
    this.left_fin.setRotationPoint(1.0F, 23.0F, 0.0F);
    this.left_fin.addBox(0.1F, -1.0F, -2.0F, 0.0F, 2.0F, 4.0F);
    setRotateAngle(this.left_fin, 0.0F, 0.08726646F, 0.0F);
  }
  
  public Iterable<ModelRenderer> getParts() {
    return (Iterable<ModelRenderer>)ImmutableList.of(this.body, this.body, this.upper_fin, this.right_fin, this.left_fin, this.back_fin);
  }
  
  public void setRotateAngle(ModelRenderer ModelRendererer, float x, float y, float z) {
    ModelRendererer.rotateAngleX = x;
    ModelRendererer.rotateAngleY = y;
    ModelRendererer.rotateAngleZ = z;
  }
  
  public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    float f = 1.0F;
    if (!entityIn.isInWater())
      f = 1.5F; 
    this.back_fin.rotateAngleY = -f * 0.45F * MathHelper.sin(0.6F * ageInTicks);
  }
}