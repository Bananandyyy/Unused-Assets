package com.gizmo.unusedassets.util.actions;

import com.gizmo.unusedassets.entity.tileentity.CauldronTileEntity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface ICauldronAction {
	ActionResultType onBlockActivated(CauldronTileEntity entity, World world, BlockPos pos, PlayerEntity player, Hand hand);
}
