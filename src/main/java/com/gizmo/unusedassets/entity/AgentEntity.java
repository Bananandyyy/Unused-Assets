package com.gizmo.unusedassets.entity;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class AgentEntity extends CreatureEntity{

	public AgentEntity(EntityType<? extends AgentEntity> type, World worldIn) {
		super(type, worldIn);
	}
	
	public ResourceLocation getTexture() {
	    return new ResourceLocation("unusedassets", "textures/entity/agent.png");
	  }
	
	public static AttributeModifierMap.MutableAttribute attributes() {
	      return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233818_a_, -1.0D).func_233815_a_(Attributes.field_233820_c_, 1.0D).func_233815_a_(Attributes.field_233826_i_, 30.0D).func_233815_a_(Attributes.field_233827_j_, 20.0D);
	   }

}
