package com.gizmo.unusedassets.entity.dungeons;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.AnimationController;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.animation.controller.EntityAnimationController.IEntityAnimationPredicate;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

public class NamelessEntity extends MonsterEntity implements IAnimatedEntity {

	private EntityAnimationManager manager = new EntityAnimationManager();
	private AnimationController idle = new EntityAnimationController(this, "moveController", 10F, this::moveController);
	
	private <E extends NamelessEntity> boolean moveController(AnimationTestEvent<E> event) {
		if(event.isWalking() == false) {
			idle.setAnimation(new AnimationBuilder().addAnimation("animation.nameless.idlestart").addAnimation("animation.nameless.idleloop", true));
		} else {
			idle.setAnimation(new AnimationBuilder().addAnimation("animation.nameless.summon"));
		}	
		return false;
	}
	
	
	public ResourceLocation getTexture() {
	    return new ResourceLocation("unusedassets", "textures/entity/dungeons/nameless_king.png");
	  }
	
	public NamelessEntity(EntityType<? extends MonsterEntity> entityTypeIn, World worldIn) {
		super(entityTypeIn, worldIn);
		registerControllers();
	}
	
	public static AttributeModifierMap.MutableAttribute attributes() {
	      return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233818_a_, 300.0D);
	}
	
	@Override
	public EntityAnimationManager getAnimationManager() {
		return manager;
	}
	
	public void registerControllers() {
		manager.addAnimationController(idle);
	}
	
	

}
