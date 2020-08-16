package com.gizmo.unusedassets.entity;

import com.gizmo.unusedassets.entity.abstracts.AbstractModVillagerEntity;
import com.gizmo.unusedassets.init.UnusedEntities;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class SteveVillagerEntity extends AbstractModVillagerEntity {
	public SteveVillagerEntity(EntityType<SteveVillagerEntity> steveVillagerHybrid, World worldIn) {
		super(steveVillagerHybrid, worldIn);
	}

	public ResourceLocation getTexture() {
		return new ResourceLocation("unusedassets", "textures/entity/stevevillager.png");
	}
	
	 public static AttributeModifierMap.MutableAttribute registerAttributes() {
	      return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.5D).createMutableAttribute(Attributes.FOLLOW_RANGE, 48.0D);
	   }

	@Override
	public AgeableEntity func_241840_a(ServerWorld worldIn, AgeableEntity entity) {
		return UnusedEntities.STEVE_VILLAGER_HYBRID.create(worldIn);
	}
}
