package com.gizmo.unusedassets.entity.ai.goal;

import com.gizmo.unusedassets.entity.earth.HornedSheepEntity;

import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.player.PlayerEntity;

public class HornedSheepAttackPlayerGoal extends NearestAttackableTargetGoal<PlayerEntity> {
    public HornedSheepAttackPlayerGoal(HornedSheepEntity sheepEntity) {
        super(sheepEntity, PlayerEntity.class, 10, true, false, null);
    }

    public boolean shouldExecute() {
        return this.canCharge() && super.shouldExecute();
    }

    public boolean shouldContinueExecuting() {
        boolean flag = this.canCharge();
        if (flag && this.goalOwner.getAttackTarget() != null) {
            return super.shouldContinueExecuting();
        } else {
            this.target = null;
            return false;
        }
    }

    private boolean canCharge() {
        HornedSheepEntity sheepEntity = (HornedSheepEntity) this.goalOwner;
       //FIXME is this right?
        return sheepEntity.func_233678_J__();
    }
}
