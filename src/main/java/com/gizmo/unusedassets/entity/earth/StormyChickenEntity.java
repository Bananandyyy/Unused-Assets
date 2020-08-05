package com.gizmo.unusedassets.entity.earth;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.world.World;

public class StormyChickenEntity extends ChickenEntity {

	public StormyChickenEntity(EntityType<? extends ChickenEntity> type, World worldIn) {
		super(type, worldIn);
	}
	
	public static AttributeModifierMap.MutableAttribute attributes() {
	      return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233818_a_, 4.0D).func_233815_a_(Attributes.field_233821_d_, 0.25D);
	   }

}
