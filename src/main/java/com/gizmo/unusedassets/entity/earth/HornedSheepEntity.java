package com.gizmo.unusedassets.entity.earth;

import com.gizmo.unusedassets.init.UnusedEntities;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class HornedSheepEntity extends SheepEntity {

	public HornedSheepEntity(EntityType<? extends HornedSheepEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public SheepEntity func_241840_a(ServerWorld worldIn, AgeableEntity entity) {
		return UnusedEntities.HORNED_SHEEP.create(worldIn);
	}
	
	public static AttributeModifierMap.MutableAttribute attributes() {
	      return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 8.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.23F);
	   }

}
