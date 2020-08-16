package com.gizmo.unusedassets.entity.earth;

import com.gizmo.unusedassets.init.UnusedEntities;

import net.minecraft.block.Blocks;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class InkySheepEntity extends SingleColoredSheepEntity<InkySheepEntity>{

	public InkySheepEntity(EntityType<InkySheepEntity> type, World worldIn) {
		super(type, worldIn, new ItemStack(Blocks.BLACK_WOOL));
	}

	@Override
	public AgeableEntity func_241840_a(ServerWorld worldIn, AgeableEntity entity) {
		return UnusedEntities.INKY_SHEEP.create(worldIn);
	}
	
	public static AttributeModifierMap.MutableAttribute registerAttributes() {
	      return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 8.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.23F);
	   }

}
