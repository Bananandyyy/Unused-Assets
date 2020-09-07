package com.gizmo.unusedassets.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.gizmo.unusedassets.util.villagers.ExtraMemoryModule;
import com.gizmo.unusedassets.util.villagers.ExtraVillagerTasks;
import com.gizmo.unusedassets.util.villagers.OtherActivity;
import com.google.common.collect.ImmutableList;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.entity.merchant.villager.VillagerData;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

@Mixin(VillagerEntity.class)
public abstract class MixinVillagerEntity extends Entity {

	private static final DataParameter<VillagerData> VILLAGER_DATA = EntityDataManager.createKey(VillagerEntity.class,
			DataSerializers.VILLAGER_DATA);

	public MixinVillagerEntity(EntityType<?> entityTypeIn, World worldIn) {
		super(entityTypeIn, worldIn);
	}
	
	@Shadow
	@Final
	private static final ImmutableList<MemoryModuleType<?>> MEMORY_TYPES = ImmutableList.of(ExtraMemoryModule.STRANGE_PANIC, MemoryModuleType.HOME, MemoryModuleType.JOB_SITE, MemoryModuleType.POTENTIAL_JOB_SITE, MemoryModuleType.MEETING_POINT, MemoryModuleType.MOBS, MemoryModuleType.VISIBLE_MOBS, MemoryModuleType.VISIBLE_VILLAGER_BABIES, MemoryModuleType.NEAREST_PLAYERS, MemoryModuleType.NEAREST_VISIBLE_PLAYER, MemoryModuleType.NEAREST_VISIBLE_TARGETABLE_PLAYER, MemoryModuleType.NEAREST_VISIBLE_WANTED_ITEM, MemoryModuleType.WALK_TARGET, MemoryModuleType.LOOK_TARGET, MemoryModuleType.INTERACTION_TARGET, MemoryModuleType.BREED_TARGET, MemoryModuleType.PATH, MemoryModuleType.OPENED_DOORS, MemoryModuleType.NEAREST_BED, MemoryModuleType.HURT_BY, MemoryModuleType.HURT_BY_ENTITY, MemoryModuleType.NEAREST_HOSTILE, MemoryModuleType.SECONDARY_JOB_SITE, MemoryModuleType.HIDING_PLACE, MemoryModuleType.HEARD_BELL_TIME, MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE, MemoryModuleType.LAST_SLEPT, MemoryModuleType.LAST_WOKEN, MemoryModuleType.LAST_WORKED_AT_POI, MemoryModuleType.field_242309_E);


	@Inject(method = "initBrain(Lnet/minecraft/entity/ai/brain/Brain;)V", at = @At("HEAD"))
	private void initBrain(Brain<VillagerEntity> villagerBrain, CallbackInfo ci) {
		VillagerProfession villagerprofession = this.getVillagerData().getProfession();
		villagerBrain.registerActivity(OtherActivity.STRANGE_PANIC, ExtraVillagerTasks.strangepanic(villagerprofession, 0.5F));
	}
	
	public VillagerData getVillagerData() {
	      return this.dataManager.get(VILLAGER_DATA);
	   }
}
