package com.gizmo.unusedassets.entity.tileentity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.gizmo.unusedassets.util.SMHeight;
import com.gizmo.unusedassets.util.fabric.*;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Matrix3f;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.registry.Registry;

public class CauldronTER extends TileEntityRenderer<CauldronTileEntity> {
    
	public CauldronTER(TileEntityRendererDispatcher dispatcher) {
        super(dispatcher);
    }

    public void render(CauldronTileEntity blockEntity, float tickDelta, MatrixStack matrices, IRenderTypeBuffer buffer, int light, int overlay) {
        if(blockEntity.fluid == Fluids.EMPTY) return;
        matrices.push();

        float itemScale = (float)blockEntity.brewTimeLeft / 200.f;

        matrices.translate(0.5, 0.8, 0.5);
        matrices.scale(itemScale, itemScale, itemScale);
        Minecraft.getInstance().getItemRenderer().renderItem(blockEntity.ingredient, TransformType.GROUND, light, overlay, matrices, buffer);

        matrices.pop();
        matrices.push();

        Fluid fluid = blockEntity.fluid;
        int fluidId = Registry.FLUID.getId(fluid);

        FluidBlockRenderer fluidHandler = FluidBlockRendererRegistry.INSTANCE.get(fluid);
        BlockState fluidBlock = fluid.getDefaultState().getBlockState();
        int fluidColor = fluidHandler.getFluidColor(null, null, fluid.getDefaultState());
        if(blockEntity.dyed){
            fluidColor = blockEntity.dyeColor;
        }

        int fluidR = (fluidColor >> 16) & 0xFF;
        int fluidG = (fluidColor >> 8) & 0xFF;
        int fluidB = (fluidColor) & 0xFF;

        float height = (0.25f) + ((0.7f) * ((float)blockEntity.level_numerator / (float)blockEntity.level_denominator));
        int fluidLight = fluidBlock.getLightValue() > 0 ? 15728880 : light;

        SMHeight fluidSprite = fluidHandler.getFluidSprites(null, null, fluid.getDefaultState())[0];

        IVertexBuilder builder = buffer.getBuffer(RenderType.getEntityTranslucent(new ResourceLocation("unusedassets", "textures/" + fluidSprite.toString() + ".png")));
        MatrixStack.Entry matrixEntry = matrices.getLast();
        Matrix4f model = matrixEntry.getMatrix();
        Matrix3f normal = matrixEntry.getNormal();

        builder.pos(model,0, height, 0).color(fluidR, fluidG, fluidB, 255).tex(0, 0).overlay(OverlayTexture.NO_OVERLAY).lightmap(fluidLight).normal(normal, 0, 1, 0).endVertex();
        builder.pos(model,1, height, 0).color(fluidR, fluidG, fluidB, 255).tex(1, 0).overlay(OverlayTexture.NO_OVERLAY).lightmap(fluidLight).normal(normal, 0, 1, 0).endVertex();
        builder.pos(model,1, height, 1).color(fluidR, fluidG, fluidB, 255).tex(1.F, 1.F / fluidSprite.getHeight()).overlay(OverlayTexture.NO_OVERLAY).lightmap(fluidLight).normal(normal, 0, 1, 0).endVertex();
        builder.pos(model,0, height, 1).color(fluidR, fluidG, fluidB, 255).tex(0.F, 1.F / fluidSprite.getHeight()).overlay(OverlayTexture.NO_OVERLAY).lightmap(fluidLight).normal(normal, 0, 1, 0).endVertex();

        matrices.pop();
    }
}