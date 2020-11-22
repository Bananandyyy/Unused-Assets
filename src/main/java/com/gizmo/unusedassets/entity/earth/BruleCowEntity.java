package com.gizmo.unusedassets.entity.earth;

import com.gizmo.unusedassets.entity.earth.base.CowBase;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.world.World;

public class BruleCowEntity extends CowBase<BruleCowEntity> {

	public BruleCowEntity(EntityType<BruleCowEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public static AttributeModifierMap.MutableAttribute registerAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 10.0D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, (double) 0.2F)
				.createMutableAttribute(Attributes.FOLLOW_RANGE, 16.0D);
	}
	
}
