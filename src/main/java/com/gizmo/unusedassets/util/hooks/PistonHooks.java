package com.gizmo.unusedassets.util.hooks;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.PistonTileEntity;

public interface PistonHooks {

    Map<PistonTileEntity, CompoundNBT> tileEntityTags = new HashMap<>();

    default Map<PistonTileEntity, CompoundNBT> getBlockEntityTags() {
        return tileEntityTags;
    }
}