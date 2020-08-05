package com.gizmo.unusedassets.entity;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class AgentEntity extends CreatureEntity{

	public AgentEntity(EntityType<? extends AgentEntity> type, World worldIn) {
		super(type, worldIn);
	}
	
	public ResourceLocation getTexture() {
	    return new ResourceLocation("unusedassets", "textures/entity/agent.png");
	  }
	
	/*public void registerAttributes() {
	      super.registerAttributes();
	      this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(-1.0D);
	      this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0D);
	      this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(30.0D);
	      this.getAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).setBaseValue(20.0D);
	   }*/

}
