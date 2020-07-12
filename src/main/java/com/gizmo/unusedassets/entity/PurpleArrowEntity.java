package com.gizmo.unusedassets.entity;

import com.gizmo.unusedassets.init.UnusedEntities;
import com.gizmo.unusedassets.init.UnusedItems;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class PurpleArrowEntity extends AbstractArrowEntity {
  public PurpleArrowEntity(EntityType<? extends PurpleArrowEntity> p_i50279_1_, World worldIn) {
    super(UnusedEntities.PURPLE_ARROW, worldIn);
  }
  
  public PurpleArrowEntity(World worldIn, double x, double y, double z) {
    super(UnusedEntities.PURPLE_ARROW, x, y, z, worldIn);
  }
  
  public PurpleArrowEntity(World worldIn, LivingEntity shooter) {
    super(UnusedEntities.PURPLE_ARROW, shooter, worldIn);
  }
  
  public ResourceLocation getTexture() {
    return new ResourceLocation("unusedassets", "textures/entity/purple_arrow.png");
  }
  
  protected ItemStack getArrowStack() {
    return new ItemStack((IItemProvider)UnusedItems.PURPLE_ARROW);
  }
}
