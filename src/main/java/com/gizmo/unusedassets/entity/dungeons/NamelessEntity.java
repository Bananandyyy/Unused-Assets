package com.gizmo.unusedassets.entity.dungeons;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.AnimationController;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

public class NamelessEntity extends CreatureEntity implements IAnimatedEntity {

	EntityAnimationManager manager = new EntityAnimationManager();
	AnimationController<NamelessEntity> idle = new EntityAnimationController<NamelessEntity>(this, "moveController", 10,
			this::moveController);

	private <E extends Entity> boolean moveController(AnimationTestEvent<E> event) {
		if (event.isWalking() == false) {
			idle.setAnimation(new AnimationBuilder().addAnimation("animation.nameless.idlestart")
					.addAnimation("animation.nameless.idleloop", true));
		} else {
			idle.setAnimation(new AnimationBuilder().addAnimation("animation.nameless.summon"));
		}
		return true;
	}

	public NamelessEntity(EntityType<? extends CreatureEntity> entityTypeIn, World worldIn) {
		super(entityTypeIn, worldIn);
		registerControllers();
		manager.addAnimationController(idle);
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

	@Override
	public EntityAnimationManager getAnimationManager() {
		return manager;
	}

	public void registerControllers() {
		manager.addAnimationController(idle);
	}

}
