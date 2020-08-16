package com.gizmo.unusedassets.entity.ai.goal;

import com.gizmo.unusedassets.entity.earth.HornedSheepEntity;

import net.minecraft.entity.ai.goal.MeleeAttackGoal;

public class HornedSheepMeleeAttackGoal extends MeleeAttackGoal {

    private final HornedSheepEntity hornedSheepEntity;

    public HornedSheepMeleeAttackGoal(HornedSheepEntity hornedSheepEntity, HornedSheepEntity creatureIn, double speedIn, boolean useLongMemory) {
        super(creatureIn, speedIn, useLongMemory);
        this.hornedSheepEntity = hornedSheepEntity;
    }

    public boolean shouldExecute() {
        return super.shouldExecute() && hornedSheepEntity.func_233678_J__();
    }

    public boolean shouldContinueExecuting() {
        return super.shouldContinueExecuting() && hornedSheepEntity.func_233678_J__();
    }
}
