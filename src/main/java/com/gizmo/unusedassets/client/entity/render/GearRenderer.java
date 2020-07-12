package com.gizmo.unusedassets.client.entity.render;

import com.gizmo.unusedassets.UnusedAssets;
import com.gizmo.unusedassets.blocks.GearWireBlock.EnumFaces;
import com.gizmo.unusedassets.client.entity.model.GearModel;
import com.gizmo.unusedassets.entity.tileentity.GearTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;

public class GearRenderer extends TileEntityRenderer<GearTileEntity>
{
	private static final GearModel MODEL = new GearModel();
	private static final ResourceLocation TEXTURE = new ResourceLocation(UnusedAssets.MOD_ID, "textures/block/gear.png");

	public GearRenderer(TileEntityRendererDispatcher rendererDispatcherIn)
	{
		super(rendererDispatcherIn);
	}

	@Override
	public void render(GearTileEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn)
	{
		matrixStackIn.push();
		IVertexBuilder ivertexbuilder = ItemRenderer.getBuffer(bufferIn, RenderType.getEntityCutout(TEXTURE), false, false);
		matrixStackIn.translate(0.5, 0.5, 0.5);
		RenderSystem.disableLighting();
		double scale = 1.1D;
		matrixStackIn.scale((float) scale, (float) scale, (float) scale);

		for (EnumFaces enumFace : EnumFaces.values())
		{
			matrixStackIn.push();
			matrixStackIn.rotate(new Vector3f(1.0F, 0.0F, 1.0F).rotationDegrees(0.25F));

			switch (enumFace)
			{
			case NORTH:
				matrixStackIn.rotate(Vector3f.XP.rotationDegrees(90));
				break;
			case SOUTH:
				matrixStackIn.rotate(Vector3f.XP.rotationDegrees(-90));
				break;
			case EAST:
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90));
				break;
			case WEST:
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(-90));
				break;
			case UP:
				matrixStackIn.rotate(Vector3f.XP.rotationDegrees(180));
				break;
			default:
				break;
			}

			matrixStackIn.rotate(Vector3f.YP.rotationDegrees(tileEntityIn.getAngle(enumFace.direction)));

			if (tileEntityIn.getBlockState().get(enumFace.face).exists())
				MODEL.render(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);

			matrixStackIn.pop();
		}

		RenderSystem.enableLighting();
		matrixStackIn.pop();

	}
}