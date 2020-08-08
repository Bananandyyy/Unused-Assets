package com.gizmo.unusedassets.entity;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.OcelotEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class HappyCreeperEntity extends CreatureEntity {

	public HappyCreeperEntity(EntityType<? extends HappyCreeperEntity> type, World worldIn) {
		super(type, worldIn);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(1, new SwimGoal(this));
		this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, OcelotEntity.class, 6.0F, 1.0D, 1.2D));
		this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, CatEntity.class, 6.0F, 1.0D, 1.2D));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
		this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(4, new LookRandomlyGoal(this));

	}

	public static AttributeModifierMap.MutableAttribute attributes() {
		return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233821_d_, 0.25D);
	}

	public ResourceLocation getTexture() {
		return new ResourceLocation("unusedassets", "textures/entity/happy_creeper.png");
	}

}
