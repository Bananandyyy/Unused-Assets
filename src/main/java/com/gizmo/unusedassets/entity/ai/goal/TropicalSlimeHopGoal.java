package com.gizmo.unusedassets.entity.ai.goal;

import java.util.EnumSet;

import com.gizmo.unusedassets.entity.ai.controller.TropicalSlimeMovementController;
import com.gizmo.unusedassets.entity.earth.TropicalSlimeEntity;

import net.minecraft.entity.ai.goal.Goal;

public class TropicalSlimeHopGoal extends Goal {
    private final TropicalSlimeEntity slime;

    public TropicalSlimeHopGoal(TropicalSlimeEntity slimeIn) {
        this.slime = slimeIn;
        this.setMutexFlags(EnumSet.of(Flag.JUMP, Flag.MOVE));
    }

    public boolean shouldExecute() {
        return !this.slime.isPassenger();
    }

    public void tick() {
        ((TropicalSlimeMovementController) this.slime.getMoveHelper()).setSpeed(1.0D);
    }
}
