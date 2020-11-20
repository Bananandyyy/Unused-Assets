package com.gizmo.unusedassets.entity.earth;

import com.gizmo.unusedassets.init.UnusedEntities;
import com.gizmo.unusedassets.init.blocks.EarthBlocks;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class RainbowSheepEntity extends SingleColoredSheepEntity<RainbowSheepEntity> {
    public RainbowSheepEntity(EntityType<RainbowSheepEntity> type, World world) {
        super(type, world, new ItemStack(EarthBlocks.RAINBOW_WOOL));
    }
    
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 8.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.23F).createMutableAttribute(Attributes.FOLLOW_RANGE, 16.0D);
    }

	@Override
	public AgeableEntity func_241840_a(ServerWorld worldIn, AgeableEntity ageable) {
		return UnusedEntities.RAINBOW_SHEEP.create(worldIn);
	}
}
