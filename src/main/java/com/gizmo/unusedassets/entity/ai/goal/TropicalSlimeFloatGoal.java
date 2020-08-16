package com.gizmo.unusedassets.entity.ai.goal;

import java.util.EnumSet;

import com.gizmo.unusedassets.entity.ai.controller.TropicalSlimeMovementController;
import com.gizmo.unusedassets.entity.earth.TropicalSlimeEntity;

import net.minecraft.entity.ai.goal.Goal;

public class TropicalSlimeFloatGoal extends Goal {
    private final TropicalSlimeEntity slime;

    public TropicalSlimeFloatGoal(TropicalSlimeEntity slimeIn) {
        this.slime = slimeIn;
        this.setMutexFlags(EnumSet.of(Flag.JUMP, Flag.MOVE));
        slimeIn.getNavigator().setCanSwim(true);
    }

    public boolean shouldExecute() {
        return (this.slime.isInWater() || this.slime.isInLava()) && this.slime.getMoveHelper() instanceof TropicalSlimeMovementController;
    }

    public void tick() {
        if (this.slime.getRNG().nextFloat() < 0.8F) {
            this.slime.getJumpController().setJumping();
        }
        ((TropicalSlimeMovementController) this.slime.getMoveHelper()).setSpeed(1.2D);
    }
}
