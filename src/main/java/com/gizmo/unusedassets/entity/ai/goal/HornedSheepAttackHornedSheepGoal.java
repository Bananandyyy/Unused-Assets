package com.gizmo.unusedassets.entity.ai.goal;

import com.gizmo.unusedassets.entity.earth.HornedSheepEntity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;

public class HornedSheepAttackHornedSheepGoal extends NearestAttackableTargetGoal<HornedSheepEntity> {
    public HornedSheepAttackHornedSheepGoal(HornedSheepEntity sheepEntity) {
    	//TODO: shouldnt be null
        super(sheepEntity, HornedSheepEntity.class, 10, true, true, null);
    }

    public boolean shouldExecute() {
        LivingEntity target = this.goalOwner.getAttackTarget();
        if (target != null) {
            if (target.isChild()) {
                return false;
            }
        }
        boolean chance = this.goalOwner.getRNG().nextInt(100) < 15;
        return chance && super.shouldExecute();
    }

    public boolean shouldContinueExecuting() {
        boolean chanceToStop = this.goalOwner.getRNG().nextInt(100) < 5;
        if (this.goalOwner.getAttackTarget() != null) {
            return super.shouldContinueExecuting();
        } else if (chanceToStop) {
            return false;
        } else {
            this.target = null;
            return false;
        }
    }

}
