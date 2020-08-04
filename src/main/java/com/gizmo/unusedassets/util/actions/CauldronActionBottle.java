package com.gizmo.unusedassets.util.actions;

import com.gizmo.unusedassets.entity.tileentity.CauldronTileEntity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PotionItem;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CauldronActionBottle implements ICauldronAction {

	public ActionResultType onBlockActivated(CauldronTileEntity entity, World world, BlockPos pos, PlayerEntity player, Hand hand) {
		ItemStack itemStack = player.getHeldItemMainhand();
		if (itemStack.getItem() instanceof PotionItem) {
			if (PotionUtils.getPotionFromItem(itemStack) == Potions.WATER && entity.insertBottle(Fluids.WATER, false)) {
				if (!world.isRemote) {
					if (!player.abilities.isCreativeMode) {
						ItemStack glassBottle = new ItemStack(Items.GLASS_BOTTLE);
						player.addStat(Stats.USE_CAULDRON);
						player.setHeldItem(hand, glassBottle);
					}
					world.playSound(null, pos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
				}
				return ActionResultType.SUCCESS;
			}
		} else if (itemStack.getItem() == Items.GLASS_BOTTLE) {
			if (entity.fluid == Fluids.WATER && entity.takeBottle(true)) {
				if (!world.isRemote) {
					if (!player.abilities.isCreativeMode) {
						ItemStack waterBottleItem = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.WATER);
						player.addStat(Stats.USE_CAULDRON);
						itemStack.shrink(1);
						if (itemStack.isEmpty()) {
							player.setHeldItem(hand, waterBottleItem);
						} else if (!player.inventory.addItemStackToInventory(waterBottleItem)) {
							player.dropItem(waterBottleItem, false);
						}
					}
					entity.takeBottle(false);
					world.playSound(null, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
				}
				return ActionResultType.SUCCESS;
			}
		}
		return ActionResultType.PASS;
	}
}