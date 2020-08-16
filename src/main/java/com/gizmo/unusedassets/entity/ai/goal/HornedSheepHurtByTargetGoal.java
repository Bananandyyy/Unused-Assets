package com.gizmo.unusedassets.entity.ai.goal;

import com.gizmo.unusedassets.entity.earth.HornedSheepEntity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;

public class HornedSheepHurtByTargetGoal extends HurtByTargetGoal {

    public HornedSheepHurtByTargetGoal(HornedSheepEntity sheepIn) {
        super(sheepIn);
    }

    protected void setAttackTarget(MobEntity mobIn, LivingEntity targetIn) {
        if (mobIn instanceof HornedSheepEntity && this.goalOwner.canEntityBeSeen(targetIn) && ((HornedSheepEntity) mobIn).setSheepAttacker(targetIn)) {
            mobIn.setAttackTarget(targetIn);
        }
    }
}
