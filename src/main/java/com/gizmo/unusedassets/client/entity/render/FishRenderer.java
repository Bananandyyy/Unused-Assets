package com.gizmo.unusedassets.client.entity.render;

import com.gizmo.unusedassets.client.entity.model.FishModel;
import com.gizmo.unusedassets.entity.FishEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;

public class FishRenderer extends MobRenderer<FishEntity, FishModel<FishEntity>> {
  public FishRenderer(EntityRendererManager renderManagerIn) {
    super(renderManagerIn, new FishModel<>(), 0.3F);
  }
  
  public ResourceLocation getEntityTexture(FishEntity entity) {
    return entity.getTexture();
  }
  
  protected void applyRotations(FishEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
    super.applyRotations((FishEntity)entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
    float f = 4.3F * MathHelper.sin(0.6F * ageInTicks);
    matrixStackIn.rotate(Vector3f.YP.rotationDegrees(f));
    if (!entityLiving.isInWater()) {
      matrixStackIn.translate(0.10000000149011612D, 0.10000000149011612D, -0.10000000149011612D);
      matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90.0F));
    } 
  }
}
