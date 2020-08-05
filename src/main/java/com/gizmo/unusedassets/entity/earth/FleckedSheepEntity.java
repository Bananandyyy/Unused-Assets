package com.gizmo.unusedassets.entity.earth;

import com.gizmo.unusedassets.init.UnusedEntities;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.world.World;

public class FleckedSheepEntity extends SingleColoredSheepEntity {

	public static Block getWoolColor = Blocks.BROWN_WOOL;

	public FleckedSheepEntity(EntityType<? extends FleckedSheepEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public FleckedSheepEntity createChild(AgeableEntity ageable) {
		return UnusedEntities.FLECKED_SHEEP.create(this.world);
	}
	
	public static AttributeModifierMap.MutableAttribute attributes() {
	      return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233818_a_, 8.0D).func_233815_a_(Attributes.field_233821_d_, (double)0.23F);
	   }
}
