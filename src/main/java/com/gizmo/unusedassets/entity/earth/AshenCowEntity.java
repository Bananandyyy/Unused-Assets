package com.gizmo.unusedassets.entity.earth;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.world.World;

public class AshenCowEntity extends CowEntity{

	public AshenCowEntity(EntityType<? extends CowEntity> type, World worldIn) {
		super(type, worldIn);
	}
	
	 public static AttributeModifierMap.MutableAttribute attributes() {
	      return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233818_a_, 10.0D).func_233815_a_(Attributes.field_233821_d_, (double)0.2F);
	   }

}
