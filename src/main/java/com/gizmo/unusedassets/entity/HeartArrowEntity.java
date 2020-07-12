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

public class HeartArrowEntity extends AbstractArrowEntity{

	public HeartArrowEntity(EntityType<? extends HeartArrowEntity> p_i50279_1_, World worldIn) {
	    super(UnusedEntities.HEART_ARROW, worldIn);
	  }
	  
	  public HeartArrowEntity(World worldIn, double x, double y, double z) {
	    super(UnusedEntities.HEART_ARROW, x, y, z, worldIn);
	  }
	  
	  public HeartArrowEntity(World worldIn, LivingEntity shooter) {
	    super(UnusedEntities.HEART_ARROW, shooter, worldIn);
	  }
	  
	  public ResourceLocation getTexture() {
	    return new ResourceLocation("unusedassets", "textures/entity/heart_arrow.png");
	  }
	  
	  protected ItemStack getArrowStack() {
	    return new ItemStack((IItemProvider)UnusedItems.HEART_ARROW);
	  }
}
