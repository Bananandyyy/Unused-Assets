package com.gizmo.unusedassets.entity.dungeons;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class NamelessEntity { //extends MonsterEntity implements IAnimatedEntity{

/*	public EntityAnimationManager manager = new EntityAnimationManager();
	public AnimationController<NamelessEntity> idle = new EntityAnimationController<NamelessEntity>(this, "idlecontroller", 20, this.animationPredicate(null));
	
	public ResourceLocation getTexture() {
	    return new ResourceLocation("unusedassets", "textures/entity/dungeons/nameless_king.png");
	  }
	
	public NamelessEntity(EntityType<? extends NamelessEntity> entityTypeIn, World worldIn) {
		super(entityTypeIn, worldIn);
		registerControllers();
	}

	@Override
	public EntityAnimationManager getAnimationManager() {
		return manager;
	}
	
	public void registerControllers() {
		manager.addAnimationController(idle);
	}
	
	private <E extends NamelessEntity> IEntityAnimationPredicate<NamelessEntity> animationPredicate(AnimationTestEvent<E> event) {
		if(!event.isWalking()) {
			idle.setAnimation(new AnimationBuilder().addAnimation("animation.nameless.idlestart").addAnimation("animation.nameless.idleloop", true));
//			return true;
		} else {
			idle.setAnimation(new AnimationBuilder().addAnimation("animation.nameless.summon"));
//			return false;
		}
		return null;	
	}
	
	
*/
}
