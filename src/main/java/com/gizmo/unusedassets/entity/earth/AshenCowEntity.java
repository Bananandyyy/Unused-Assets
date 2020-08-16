package com.gizmo.unusedassets.entity.earth;

import com.gizmo.unusedassets.entity.earth.base.CowBase;
import com.gizmo.unusedassets.init.UnusedEntities;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class AshenCowEntity extends CowBase<AshenCowEntity> {

	public AshenCowEntity(EntityType<AshenCowEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public static AttributeModifierMap.MutableAttribute registerAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 10.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, (double) 0.2F);
	}


	@Override
	public CowEntity createChild(ServerWorld worldIn, AgeableEntity entityIn) {
		return UnusedEntities.ASHEN_COW.create(worldIn);
	}

}
