package com.gizmo.unusedassets.entity.abstracts;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public abstract class AbstractModFishEntity extends AbstractGroupFishEntity {
  protected AbstractModFishEntity(EntityType<? extends AbstractGroupFishEntity> type, World worldIn) {
    super(type, worldIn);
  }
  
  public abstract ResourceLocation getTexture();
}
