package com.gizmo.unusedassets.entity.ai.goal;

import java.util.EnumSet;

import com.gizmo.unusedassets.entity.earth.FurnaceGolemEntity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.DefendVillageTargetGoal;

public class FurnaceGolemDefendVillageTargetGoal extends DefendVillageTargetGoal {
    private final FurnaceGolemEntity golem;
    private LivingEntity villageAgressorTarget;

    public FurnaceGolemDefendVillageTargetGoal(FurnaceGolemEntity ironGolemIn) {
        super(ironGolemIn);
        this.golem = ironGolemIn;
        this.setMutexFlags(EnumSet.of(Flag.TARGET));
    }

    public void startExecuting() {
        this.golem.setAngry(true);
        this.golem.setAttackTarget(this.villageAgressorTarget);
        super.startExecuting();
    }

    public void resetTask() {
        this.golem.setAngry(false);
        super.resetTask();
    }
}
