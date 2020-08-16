package com.gizmo.unusedassets.client.entity.render.earth.layers;

import com.gizmo.unusedassets.client.entity.model.earth.RainbowSheepModel;
import com.gizmo.unusedassets.client.entity.model.earth.RainbowSheepWoolModel;
import com.gizmo.unusedassets.entity.earth.RainbowSheepEntity;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

public class RainbowSheepWoolLayer extends LayerRenderer<RainbowSheepEntity, RainbowSheepModel<RainbowSheepEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("unusedassets:textures/entity/earth/sheep/rainbow_sheep/rainbow_sheep_fur.png");
    private final RainbowSheepWoolModel<RainbowSheepEntity> sheepModel = new RainbowSheepWoolModel<>();

    public RainbowSheepWoolLayer(IEntityRenderer<RainbowSheepEntity, RainbowSheepModel<RainbowSheepEntity>> rendererIn) {
        super(rendererIn);
    }

    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, RainbowSheepEntity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!entitylivingbaseIn.getSheared() && !entitylivingbaseIn.isInvisible()) {
            float f = 0.9019608F;
            float f1 = 0.9019608F;
            float f2 = 0.9019608F;
            renderCopyCutoutModel(this.getEntityModel(), this.sheepModel, TEXTURE, matrixStackIn, bufferIn, packedLightIn, entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, partialTicks, f, f1, f2);
        }
    }
}