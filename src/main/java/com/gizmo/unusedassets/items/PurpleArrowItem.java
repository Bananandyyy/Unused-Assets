package com.gizmo.unusedassets.items;

import com.gizmo.unusedassets.entity.projectile.PurpleArrowEntity;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PurpleArrowItem extends Item {
	public PurpleArrowItem(Item.Properties builder) {
		super(builder);
	}

	public PurpleArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
		PurpleArrowEntity arrow = new PurpleArrowEntity(worldIn, shooter);
		return arrow;
	}

	public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.PlayerEntity player) {
		int enchant = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, bow);
		return enchant <= 0 ? false : this.getClass() == PurpleArrowItem.class;
	}
}
