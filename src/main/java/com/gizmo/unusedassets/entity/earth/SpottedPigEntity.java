package com.gizmo.unusedassets.entity.earth;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.world.World;

public class SpottedPigEntity extends PigEntity{

	public SpottedPigEntity(EntityType<? extends PigEntity> p_i50250_1_, World p_i50250_2_) {
		super(p_i50250_1_, p_i50250_2_);
	}
	
	public static AttributeModifierMap.MutableAttribute attributes() {
	      return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233818_a_, 10.0D).func_233815_a_(Attributes.field_233821_d_, 0.25D);
	   }

}
