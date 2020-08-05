package com.gizmo.unusedassets.entity.earth;

import com.gizmo.unusedassets.init.UnusedEntities;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.world.World;

public class HornedSheepEntity extends SheepEntity{

	public HornedSheepEntity(EntityType<? extends HornedSheepEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public SheepEntity createChild(AgeableEntity ageable) {
		return UnusedEntities.HORNED_SHEEP.create(this.world);
	}
	
	public static AttributeModifierMap.MutableAttribute attributes() {
	      return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233818_a_, 8.0D).func_233815_a_(Attributes.field_233821_d_, (double)0.23F);
	   }

}
