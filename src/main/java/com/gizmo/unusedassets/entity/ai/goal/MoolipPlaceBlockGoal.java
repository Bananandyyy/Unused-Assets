package com.gizmo.unusedassets.entity.ai.goal;

import com.gizmo.unusedassets.entity.earth.MoolipEntity;
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

public class MoolipPlaceBlockGoal extends Goal {
    private final MoolipEntity moolip;

    public MoolipPlaceBlockGoal(MoolipEntity p_i45843_1_) {
        this.moolip = p_i45843_1_;
    }

    public boolean shouldExecute() {
        return this.moolip.getRNG().nextInt(2000) == 0;
    }

    public boolean canPlace(IWorldReader world, BlockState target, BlockPos targetPos, BlockState downTarget, BlockPos downTargetPos) {
        return !downTarget.isAir(world, downTargetPos) && downTarget.isOpaqueCube(world, downTargetPos) && target.isValidPosition(world, targetPos);
    }

    public void tick() {
        IWorld iworld = this.moolip.world;
        int i = MathHelper.floor(this.moolip.getPosX());
        int j = MathHelper.floor(this.moolip.getPosY());
        int k = MathHelper.floor(this.moolip.getPosZ());
        Block flower = Math.random() > 0.8 ? Blocks.SUNFLOWER : EarthBlocks.BUTTERCUP;
        BlockPos blockPos = new BlockPos(i, j, k);
        BlockState blockState = flower.getDefaultState();
        BlockPos blockDownPos = blockPos.down();
        BlockState blockDownState = iworld.getBlockState(blockDownPos);
        if (canPlace(iworld, blockState, blockPos, blockDownState, blockDownPos) && !net.minecraftforge.event.ForgeEventFactory.onBlockPlace(moolip, BlockSnapshot.create(null, iworld, blockDownPos), net.minecraft.util.Direction.UP)) {
            iworld.destroyBlock(blockPos, false);
            iworld.setBlockState(blockPos, blockState, 3);
        }
    }
}