package com.gizmo.unusedassets.entity.ai.goal;

import java.util.EnumSet;

import com.gizmo.unusedassets.entity.ai.controller.MelonGolemMovementController;
import com.gizmo.unusedassets.entity.earth.MelonGolemEntity;

import net.minecraft.entity.ai.goal.Goal;

public class MelonGolemHopGoal extends Goal {
    private final MelonGolemEntity melonGolem;

    public MelonGolemHopGoal(MelonGolemEntity entity) {
        this.melonGolem = entity;
        this.setMutexFlags(EnumSet.of(Flag.JUMP, Flag.MOVE));
    }

    public boolean shouldExecute() {
        return !this.melonGolem.isPassenger();
    }

    public void tick() {
       // ((MelonGolemMovementController) this.melonGolem.getMoveHelper()).setSpeed(1.0D);
    }
}
