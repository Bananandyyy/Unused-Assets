package com.gizmo.unusedassets.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.gizmo.unusedassets.util.hooks.TEHooks;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.PistonTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.tileentity.PistonTileEntity;
import net.minecraft.tileentity.TileEntity;

@Mixin(PistonTileEntityRenderer.class)
public class PistonTileEntityRendererMixin {

    @Inject(
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/tileentity/PistonTileEntityRenderer;func_228876_a_(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;Lcom/mojang/blaze3d/matrix/MatrixStack;Lnet/minecraft/client/renderer/IRenderTypeBuffer;Lnet/minecraft/world/World;ZI)V"),
            method = "render"
    )
    private void renderTileEntity(PistonTileEntity pistonTileEntity, float f, MatrixStack matrixStack, IRenderTypeBuffer vertexConsumerProvider, int i, int j, CallbackInfo ci) {
        if (pistonTileEntity.getPistonState().hasTileEntity()) {
            TileEntity te = pistonTileEntity.getPistonState().createTileEntity(pistonTileEntity.getWorld());
            if (te != null && TileEntityRendererDispatcher.instance.getRenderer(te) != null) {
                te.setWorldAndPos(pistonTileEntity.getWorld(), pistonTileEntity.getPos());
                ((TEHooks)te).setCachedState(pistonTileEntity.getPistonState());
                TileEntityRendererDispatcher.instance.renderTileEntity(te, f, matrixStack, vertexConsumerProvider);
                te.remove();
            }
        }
    }
}
