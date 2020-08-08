package com.gizmo.unusedassets.entity;

import com.gizmo.unusedassets.entity.abstracts.AbstractModFishEntity;
import com.gizmo.unusedassets.init.UnusedEntities;
import com.gizmo.unusedassets.init.UnusedItems;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class FishEntity extends AbstractModFishEntity {
	public FishEntity(EntityType<? extends FishEntity> p_i50279_1_, World worldin) {
		super(UnusedEntities.FISH, worldin);
	}

	protected ItemStack getFishBucket() {
		return new ItemStack((IItemProvider) UnusedItems.FISH_BUCKET);
	}

	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_COD_AMBIENT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_COD_DEATH;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_COD_HURT;
	}

	protected SoundEvent getFlopSound() {
		return SoundEvents.ENTITY_COD_FLOP;
	}

	public ResourceLocation getTexture() {
		return new ResourceLocation("unusedassets", "textures/entity/fish.png");
	}
	
	 public static AttributeModifierMap.MutableAttribute attributes() {
	      return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233818_a_, 3.0D);
	   }
}
