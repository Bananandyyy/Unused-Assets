package com.gizmo.unusedassets.entity.earth;

import com.gizmo.unusedassets.init.UnusedEntities;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class PiebaldPigEntity extends PigEntity {

	public PiebaldPigEntity(EntityType<? extends PigEntity> p_i50250_1_, World p_i50250_2_) {
		super(p_i50250_1_, p_i50250_2_);
	}
	
	public static AttributeModifierMap.MutableAttribute attributes() {
	      return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 10.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D);
	   }
	
	@Override
	public PigEntity func_241840_a(ServerWorld worldIn, AgeableEntity entity) {
		return UnusedEntities.PIEBALD_PIG.create(worldIn);
	}


}
