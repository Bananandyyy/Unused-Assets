package com.gizmo.unusedassets.entity.ai.goal;

import com.gizmo.unusedassets.entity.earth.CluckShroomEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

public class CluckshroomPlaceBlockGoal extends Goal {
    private final CluckShroomEntity cluckshroom;

    public CluckshroomPlaceBlockGoal(CluckShroomEntity p_i45843_1_) {
        this.cluckshroom = p_i45843_1_;
    }

    public boolean shouldExecute() {
        return this.cluckshroom.getRNG().nextInt(2000) == 0;
    }

    public boolean canPlace(IWorldReader world, BlockState target, BlockPos targetPos, BlockState downTarget, BlockPos downTargetPos) {
        return !downTarget.isAir(world, downTargetPos) && downTarget.isOpaqueCube(world, downTargetPos) && target.isValidPosition(world, targetPos);
    }

    public void tick() {
        IWorld iworld = this.cluckshroom.world;
        int i = MathHelper.floor(this.cluckshroom.getPosX());
        int j = MathHelper.floor(this.cluckshroom.getPosY());
        int k = MathHelper.floor(this.cluckshroom.getPosZ());
        Block mushroom = Blocks.RED_MUSHROOM;
        BlockPos blockPos = new BlockPos(i, j, k);
        BlockState blockState = mushroom.getDefaultState();
        BlockPos blockDownPos = blockPos.down();
        BlockState blockDownState = iworld.getBlockState(blockDownPos);
        if (canPlace(iworld, blockState, blockPos, blockDownState, blockDownPos) && !net.minecraftforge.event.ForgeEventFactory.onBlockPlace(cluckshroom, net.minecraftforge.common.util.BlockSnapshot.create(null, iworld, blockDownPos), net.minecraft.util.Direction.UP)) {
            iworld.destroyBlock(blockPos, false);
            iworld.setBlockState(blockPos, blockState, 3);
        }
    }
}
