package com.gizmo.unusedassets.entity;

import com.gizmo.unusedassets.entity.abstracts.AbstractModVillagerEntity;
import com.gizmo.unusedassets.init.UnusedEntities;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class SteveVillagerEntity extends AbstractModVillagerEntity {
	public SteveVillagerEntity(EntityType<SteveVillagerEntity> steveVillagerHybrid, World worldIn) {
		super(steveVillagerHybrid, worldIn);
	}

	public ResourceLocation getTexture() {
		return new ResourceLocation("unusedassets", "textures/entity/stevevillager.png");
	}

	public AgeableEntity createChild(AgeableEntity ageable) {
		SteveVillagerEntity villagerentity = new SteveVillagerEntity(UnusedEntities.STEVE_VILLAGER_HYBRID, this.world);
		villagerentity.onInitialSpawn((IWorld) this.world,
				this.world.getDifficultyForLocation(villagerentity.func_233580_cy_()), SpawnReason.BREEDING, null,
				null);
		return (AgeableEntity) villagerentity;
	}
	
	 public static AttributeModifierMap.MutableAttribute attributes() {
	      return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233821_d_, 0.5D).func_233815_a_(Attributes.field_233819_b_, 48.0D);
	   }
}
