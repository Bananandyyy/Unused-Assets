package com.gizmo.unusedassets.entity.ai.goal;

import com.gizmo.unusedassets.entity.earth.MuddyPigEntity;
import com.gizmo.unusedassets.init.blocks.EarthBlocks;

import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class MoveToMudGoal extends MoveToBlockGoal {
    private final MuddyPigEntity muddyPig;

    public MoveToMudGoal(MuddyPigEntity entity, double speedIn) {
        super(entity, speedIn, 16, 3);
        this.muddyPig = entity;
        this.field_203112_e = -1;
    }

    public boolean shouldExecute() {
        return !this.muddyPig.isInMuddyState() && super.shouldExecute();
    }

    public boolean shouldContinueExecuting() {
        return !this.muddyPig.isInMuddyState() && this.timeoutCounter <= 600 && this.shouldMoveTo(this.muddyPig.world, this.destinationBlock);
    }

    public boolean shouldMove() {
        return this.timeoutCounter % 100 == 0;
    }

    @Override
    protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos).isIn(EarthBlocks.MUD_BLOCK);
    }
}
