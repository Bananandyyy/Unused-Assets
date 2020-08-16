package com.gizmo.unusedassets.entity.ai.goal;

import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.gizmo.unusedassets.entity.earth.FurnaceGolemEntity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;

public final class FurnaceGolemNearestAttackableTargetGoal extends NearestAttackableTargetGoal<LivingEntity> {
    FurnaceGolemEntity golem;

    public FurnaceGolemNearestAttackableTargetGoal(FurnaceGolemEntity entity, Class targetClassIn, int targetChanceIn, boolean checkSight, boolean nearbyOnlyIn, @Nullable Predicate targetPredicate) {
        super(entity, targetClassIn, targetChanceIn, checkSight, nearbyOnlyIn, targetPredicate);
        this.golem = entity;
    }

    public void startExecuting() {
        this.golem.setAngry(true);
        super.startExecuting();
    }

    public void resetTask() {
        this.golem.setAngry(false);
        super.resetTask();
    }
}
