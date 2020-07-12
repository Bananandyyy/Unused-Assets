package com.gizmo.unusedassets.util;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IndirectEntityDamageSource;

public class ModDamageSources {

	 public static DamageSource causeArrowDamage(AbstractArrowEntity arrow, @Nullable Entity indirectEntityIn) {
	      return (new IndirectEntityDamageSource("arrow", arrow, indirectEntityIn)).setProjectile();
	   }
}
