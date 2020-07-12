package com.gizmo.unusedassets.entity.abstracts;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public abstract class AbstractModVillagerEntity extends AgeableEntity {
  public AbstractModVillagerEntity(EntityType<? extends AgeableEntity> type, World worldIn) {
    super(type, worldIn);
  }
}
