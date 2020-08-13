package com.gizmo.unusedassets.entity.earth;

import com.gizmo.unusedassets.init.UnusedEntities;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class RockySheepEntity extends SingleColoredSheepEntity {

	public RockySheepEntity(EntityType<? extends RockySheepEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public AgeableEntity func_241840_a(ServerWorld worldIn, AgeableEntity entity) {
		return UnusedEntities.ROCKY_SHEEP.create(worldIn);
	}
	
	public static AttributeModifierMap.MutableAttribute attributes() {
	      return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233818_a_, 8.0D).func_233815_a_(Attributes.field_233821_d_, (double)0.23F);
	   }

}
