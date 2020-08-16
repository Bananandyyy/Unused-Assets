package com.gizmo.unusedassets.client.entity.render.earth.layers;

import com.gizmo.unusedassets.entity.earth.base.PigBase;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.PigModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.util.ResourceLocation;

public class BasePigSaddleLayer extends LayerRenderer<PigBase<? extends PigEntity>, PigModel<PigBase<? extends PigEntity>>> {
    private final ResourceLocation TEXTURE = new ResourceLocation("textures/entity/pig/pig_saddle.png");
    private final PigModel<PigBase<? extends PigEntity>> pigModel = new PigModel<>(0.5F);

    public BasePigSaddleLayer(IEntityRenderer<PigBase<? extends PigEntity>, PigModel<PigBase<? extends PigEntity>>> p_i50927_1_) {
        super(p_i50927_1_);
    }

    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, PigBase<? extends PigEntity> entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entitylivingbaseIn.isHorseSaddled()) {
            this.getEntityModel().copyModelAttributesTo(this.pigModel);
            this.pigModel.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
            this.pigModel.setRotationAngles(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntityCutoutNoCull(TEXTURE));
            this.pigModel.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
}
