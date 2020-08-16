package com.gizmo.unusedassets.entity.ai.goal;

import com.gizmo.unusedassets.entity.ai.controller.MelonGolemMovementController;
import com.gizmo.unusedassets.entity.earth.MelonGolemEntity;

import net.minecraft.entity.ai.goal.RangedAttackGoal;

public class MelonGolemRangedAttackGoal extends RangedAttackGoal {
    private final MelonGolemEntity rangedAttackEntityHost;

    public MelonGolemRangedAttackGoal(MelonGolemEntity attacker, double movespeed, int maxAttackTime, float maxAttackDistanceIn) {
        super(attacker, movespeed, maxAttackTime, maxAttackDistanceIn);
        this.rangedAttackEntityHost = attacker;
    }

    public MelonGolemRangedAttackGoal(MelonGolemEntity attacker, double movespeed, int p_i1650_4_, int maxAttackTime, float maxAttackDistanceIn) {
        super(attacker, movespeed, p_i1650_4_, maxAttackTime, maxAttackDistanceIn);
        this.rangedAttackEntityHost = attacker;
    }

    @Override
    public void tick() {
        super.tick();
        ((MelonGolemMovementController) this.rangedAttackEntityHost.getMoveHelper()).setDirection(this.rangedAttackEntityHost.rotationYaw, true);
    }
}
