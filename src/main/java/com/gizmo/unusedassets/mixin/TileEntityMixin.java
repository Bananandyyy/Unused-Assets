package com.gizmo.unusedassets.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import com.gizmo.unusedassets.util.hooks.TEHooks;

import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;

@Mixin(TileEntity.class)
public class TileEntityMixin implements TEHooks {

    @Shadow private BlockState cachedBlockState;

    @Override
    public void setCachedState(BlockState state) {
        cachedBlockState = state;
    }
}

