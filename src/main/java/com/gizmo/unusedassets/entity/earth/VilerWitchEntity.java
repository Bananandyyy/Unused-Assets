package com.gizmo.unusedassets.entity.earth;

import com.gizmo.unusedassets.entity.earth.base.WitchBase;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.World;

public class VilerWitchEntity extends WitchBase<VilerWitchEntity> {

	public VilerWitchEntity(EntityType<VilerWitchEntity> typeIn, World worldIn) {
		super(typeIn, worldIn);
	}

	public static AttributeModifierMap.MutableAttribute registerAttributes() {
	      return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, 26.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D);
	   }
}
