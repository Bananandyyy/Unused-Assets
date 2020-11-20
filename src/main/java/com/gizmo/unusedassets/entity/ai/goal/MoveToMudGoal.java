package com.gizmo.unusedassets.entity.ai.goal;

import com.gizmo.unusedassets.entity.earth.MuddyPigEntity;
import com.gizmo.unusedassets.init.UnusedTags;
import com.gizmo.unusedassets.init.blocks.EarthBlocks;

import net.minecraft.block.Block;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class MoveToMudGoal extends MoveToBlockGoal {
    private final PigEntity pig;

    public MoveToMudGoal(PigEntity pig, double speed) {
        super(pig, speed, 12);
        this.pig = pig;
    }

    public boolean shouldContinueExecuting() {
        return !this.pig.handleFluidAcceleration(UnusedTags.Fluids.MUD, 0.014D) && this.timeoutCounter <= 1200 && this.shouldMoveTo(this.pig.world, this.destinationBlock);
    }

    public boolean shouldExecute() {
        if (!this.pig.handleFluidAcceleration(UnusedTags.Fluids.MUD, 0.014D)) {
            return super.shouldExecute();
        } else {
            return false;
        }
    }

    @Override
    public void startExecuting() {
        super.startExecuting();
        if (this.pig instanceof MuddyPigEntity) {
            ((MuddyPigEntity) this.pig).setSprinting(true);
        }
    }

    @Override
    public void resetTask() {
        super.resetTask();
        if (this.pig instanceof MuddyPigEntity) {
            ((MuddyPigEntity) this.pig).setSprinting(false);
        }
    }

    public boolean shouldMove() {
        return this.timeoutCounter % 160 == 0;
    }

    protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
        Block block = worldIn.getBlockState(pos).getBlock();
        return block == EarthBlocks.MUD_BLOCK;
    }
}