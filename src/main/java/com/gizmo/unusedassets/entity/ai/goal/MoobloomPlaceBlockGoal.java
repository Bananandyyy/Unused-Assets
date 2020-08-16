package com.gizmo.unusedassets.entity.ai.goal;

import com.gizmo.unusedassets.entity.earth.MoobloomEntity;
import com.gizmo.unusedassets.init.blocks.EarthBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.util.BlockSnapshot;

public class MoobloomPlaceBlockGoal extends Goal {
    private final MoobloomEntity moobloom;

    public MoobloomPlaceBlockGoal(MoobloomEntity p_i45843_1_) {
        this.moobloom = p_i45843_1_;
    }

    public boolean shouldExecute() {
        return this.moobloom.getRNG().nextInt(2000) == 0;
    }

    public boolean canPlace(IWorldReader world, BlockState target, BlockPos targetPos, BlockState downTarget, BlockPos downTargetPos) {
        return !downTarget.isAir(world, downTargetPos) && downTarget.isOpaqueCube(world, downTargetPos) && target.isValidPosition(world, targetPos);
    }

    public void tick() {
        IWorld iworld = this.moobloom.world;
        int i = MathHelper.floor(this.moobloom.getPosX());
        int j = MathHelper.floor(this.moobloom.getPosY());
        int k = MathHelper.floor(this.moobloom.getPosZ());
        Block flower = Math.random() > 0.8 ? Blocks.SUNFLOWER : EarthBlocks.BUTTERCUP;
        BlockPos blockPos = new BlockPos(i, j, k);
        BlockState blockState = flower.getDefaultState();
        BlockPos blockDownPos = blockPos.down();
        BlockState blockDownState = iworld.getBlockState(blockDownPos);
        if (canPlace(iworld, blockState, blockPos, blockDownState, blockDownPos) && !net.minecraftforge.event.ForgeEventFactory.onBlockPlace(moobloom, BlockSnapshot.create(null, iworld, blockDownPos), net.minecraft.util.Direction.UP)) {
            iworld.destroyBlock(blockPos, false);
            iworld.setBlockState(blockPos, blockState, 3);
        }
    }
}
