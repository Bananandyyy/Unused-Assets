package com.gizmo.unusedassets.items;

import com.gizmo.unusedassets.entity.HeartArrowEntity;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class HeartArrowItem extends Item {

	public HeartArrowItem(Item.Properties properties) {
		super(properties);
	}

	public HeartArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
		HeartArrowEntity arrow = new HeartArrowEntity(worldIn, shooter);
		return arrow;
	}

	public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.PlayerEntity player) {
		int enchant = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, bow);
		return enchant <= 0 ? false : this.getClass() == HeartArrowItem.class;
	}
}
