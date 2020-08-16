package com.gizmo.unusedassets.entity.ai.goal;

import java.util.EnumSet;

import com.gizmo.unusedassets.entity.ai.controller.TropicalSlimeMovementController;
import com.gizmo.unusedassets.entity.earth.TropicalSlimeEntity;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.potion.Effects;

public class TropicalSlimeFaceRandomGoal extends Goal {
    private final TropicalSlimeEntity slime;
    private float chosenDegrees;
    private int nextRandomizeTime;

    public TropicalSlimeFaceRandomGoal(TropicalSlimeEntity slimeIn) {
        this.slime = slimeIn;
        this.setMutexFlags(EnumSet.of(Flag.LOOK));
    }

    public boolean shouldExecute() {
        return this.slime.getAttackTarget() == null && (this.slime.attackable()/*FIXME is this right?*/ || this.slime.isInWater() || this.slime.isInLava() || this.slime.isPotionActive(Effects.LEVITATION)) && this.slime.getMoveHelper() instanceof TropicalSlimeMovementController;
    }

    public void tick() {
        if (--this.nextRandomizeTime <= 0) {
            this.nextRandomizeTime = 40 + this.slime.getRNG().nextInt(60);
            this.chosenDegrees = (float) this.slime.getRNG().nextInt(360);
        }
        ((TropicalSlimeMovementController) this.slime.getMoveHelper()).setDirection(this.chosenDegrees, false);
    }

}
