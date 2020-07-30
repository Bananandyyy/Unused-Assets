package com.gizmo.unusedassets.util.villagers;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.entity.ai.brain.task.ClearHurtTask;
import net.minecraft.entity.ai.brain.task.FindWalkTargetTask;
import net.minecraft.entity.ai.brain.task.RunAwayTask;
import net.minecraft.entity.ai.brain.task.Task;
import net.minecraft.entity.ai.brain.task.VillagerTasks;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.merchant.villager.VillagerProfession;

public class ExtraVillagerTasks extends VillagerTasks{

	public static ImmutableList<Pair<Integer, ? extends Task<? super VillagerEntity>>> strangepanic(VillagerProfession profession, float p_220636_1_) {
	      float f = p_220636_1_ * 1.5F;
	      return ImmutableList.of(Pair.of(0, new ClearHurtTask()), Pair.of(1, RunAwayTask.func_233965_b_(ExtraMemoryModule.STRANGE_PANIC, f, 6, false)), Pair.of(3, new FindWalkTargetTask(f, 2, 2)));
	   }
}
