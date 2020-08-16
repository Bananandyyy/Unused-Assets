package com.gizmo.unusedassets.client.entity.render.earth.layers;

import com.gizmo.unusedassets.client.entity.model.earth.SingleColorSheepModel;
import com.gizmo.unusedassets.client.entity.model.earth.SingleColorWoolModel;
import com.gizmo.unusedassets.entity.earth.SingleColoredSheepEntity;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SingleColorSheepWoolLayer<T extends SingleColoredSheepEntity<T>> extends LayerRenderer<T, SingleColorSheepModel<T>> {
    private final SingleColorWoolModel<T> sheepModel = new SingleColorWoolModel<>();

    private ResourceLocation texture;

    public SingleColorSheepWoolLayer(IEntityRenderer<T, SingleColorSheepModel<T>> rendererIn, String texture) {
        super(rendererIn);
        this.texture = new ResourceLocation(texture);
    }

    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!entitylivingbaseIn.getSheared() && !entitylivingbaseIn.isInvisible()) {
            float f = 0.9019608F;
            float f1 = 0.9019608F;
            float f2 = 0.9019608F;
            renderCopyCutoutModel(this.getEntityModel(), this.sheepModel, texture, matrixStackIn, bufferIn, packedLightIn, entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, partialTicks, f, f1, f2);
        }
    }
}
