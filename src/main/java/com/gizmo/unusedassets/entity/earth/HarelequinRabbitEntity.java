package com.gizmo.unusedassets.entity.earth;

import com.gizmo.unusedassets.entity.earth.base.RabbitBase;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.world.World;

public class HarelequinRabbitEntity extends RabbitBase<HarelequinRabbitEntity> {

    public HarelequinRabbitEntity(EntityType<HarelequinRabbitEntity> type, World world) {
        super(type, world);
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 3.0D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, (double) 0.3F).createMutableAttribute(Attributes.FOLLOW_RANGE, 16.0D);
	}
}
