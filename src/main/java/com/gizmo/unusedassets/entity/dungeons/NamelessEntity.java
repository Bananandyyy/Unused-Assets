package com.gizmo.unusedassets.entity.dungeons;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class NamelessEntity extends CreatureEntity {

	public NamelessEntity(EntityType<? extends CreatureEntity> entityTypeIn, World worldIn) {
		super(entityTypeIn, worldIn);
	}

	public void registerGoals() {
		this.goalSelector.addGoal(0, new LookRandomlyGoal(this));
	}

	public ResourceLocation getTexture() {
		return new ResourceLocation("unusedassets", "textures/entity/dungeons/nameless_king.png");
	}

	public static AttributeModifierMap.MutableAttribute attributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 300.0D);
	}

}
