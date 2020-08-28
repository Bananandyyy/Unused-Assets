package com.gizmo.unusedassets.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.gizmo.unusedassets.util.villagers.ExtraVillagerTasks;
import com.gizmo.unusedassets.util.villagers.OtherActivity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.merchant.villager.VillagerData;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

//@Mixin(VillagerEntity.class)
public abstract class MixinVillagerEntity extends Entity {

	private static final DataParameter<VillagerData> VILLAGER_DATA = EntityDataManager.createKey(VillagerEntity.class,
			DataSerializers.VILLAGER_DATA);

	public MixinVillagerEntity(EntityType<?> entityTypeIn, World worldIn) {
		super(entityTypeIn, worldIn);
	}

	/*@Inject(method = "Lnet/minecraft/entity/merchant/villager/VillagerEntity;initBrain(Lnet/minecraft/entity/ai/brain/Brain;)", at = @At("HEAD"))
	private void initBrain(Brain<VillagerEntity> villagerBrain, CallbackInfo ci) {
		VillagerProfession villagerprofession = this.getVillagerData().getProfession();
		villagerBrain.registerActivity(OtherActivity.STRANGE_PANIC, ExtraVillagerTasks.strangepanic(villagerprofession, 0.5F));
	}
	
	public VillagerData getVillagerData() {
	      return this.dataManager.get(VILLAGER_DATA);
	   }*/
}
