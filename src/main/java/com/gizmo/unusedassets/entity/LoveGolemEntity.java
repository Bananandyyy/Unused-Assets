package com.gizmo.unusedassets.entity;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MoveThroughVillageGoal;
import net.minecraft.entity.ai.goal.MoveTowardsRestrictionGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class LoveGolemEntity extends CreatureEntity {

	public LoveGolemEntity(EntityType<? extends LoveGolemEntity> type, World worldIn) {
		super(type, worldIn);
	}
	
	 protected void registerGoals() {
		 this.goalSelector.addGoal(0, new MoveTowardsRestrictionGoal(this, 0.6D));
	      this.goalSelector.addGoal(1, new MoveThroughVillageGoal(this, 0.6D, false, 4, () -> {
	         return false;
	      }));
	      this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, 0.6D));
	      this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 6.0F));
	      this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
	 }
	
	public ResourceLocation getTexture() {
	    return new ResourceLocation("unusedassets", "textures/entity/love_golem.png");
	  }
	
	public static AttributeModifierMap.MutableAttribute attributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 100.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D).createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 1.0D);
	}
	
	
}
