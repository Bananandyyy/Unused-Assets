package com.gizmo.unusedassets.entity.earth;

import com.gizmo.unusedassets.entity.earth.base.ChickenBase;
import com.gizmo.unusedassets.init.UnusedEntities;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class MidnightChickenEntity extends ChickenBase<MidnightChickenEntity> {

	public MidnightChickenEntity(EntityType<MidnightChickenEntity> type, World worldIn) {
		super(type, worldIn);
	}
	
	public static AttributeModifierMap.MutableAttribute attributes() {
	      return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 4.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D);
	   }
	
	@Override
	public ChickenEntity createChild(ServerWorld worldIn, AgeableEntity entity) {
		return UnusedEntities.MIDNIGHT_CHICKEN.create(worldIn);
	}

}

