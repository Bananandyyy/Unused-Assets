package com.gizmo.unusedassets.entity.earth;

import com.gizmo.unusedassets.entity.earth.base.ChickenBase;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.world.World;

public class FancyChickenEntity extends ChickenBase<FancyChickenEntity> {

	public FancyChickenEntity(EntityType<FancyChickenEntity> type, World worldIn) {
		super(type, worldIn);
	}
	
	public static AttributeModifierMap.MutableAttribute registerAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 4.0D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D).createMutableAttribute(Attributes.FOLLOW_RANGE, 16.0D);
	}

}
