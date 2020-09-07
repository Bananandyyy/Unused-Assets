package com.gizmo.unusedassets.client.entity.render;

import com.gizmo.unusedassets.client.entity.model.SteveVillagerModel;
import com.gizmo.unusedassets.entity.SteveVillagerEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HeadLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SteveVillagerRenderer extends MobRenderer<SteveVillagerEntity, SteveVillagerModel<SteveVillagerEntity>> {
  public SteveVillagerRenderer(EntityRendererManager renderManagerIn) {
    super(renderManagerIn, new SteveVillagerModel<SteveVillagerEntity>(), 0.5F);
    this.addLayer(new HeadLayer<>(this));
  }
  
  public ResourceLocation getEntityTexture(SteveVillagerEntity entity) {
    return entity.getTexture();
  }
  
  protected void preRenderCallback(SteveVillagerEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
    float f = 0.9375F;
    if (entitylivingbaseIn.isChild()) {
      f = (float)(f * 0.5D);
      this.shadowSize = 0.25F;
    } else {
      this.shadowSize = 0.5F;
    } 
    matrixStackIn.scale(f, f, f);
  }
}
