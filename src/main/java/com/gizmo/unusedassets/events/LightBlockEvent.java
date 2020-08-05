package com.gizmo.unusedassets.events;

import com.gizmo.unusedassets.init.UnusedItems;
import com.gizmo.unusedassets.init.blocks.BedrockBlocks;
import net.minecraft.util.Hand;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = "unusedassets", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LightBlockEvent {

	@SubscribeEvent
	public static void LightBlock1(PlayerInteractEvent.RightClickBlock event) {
		if (event.getPlayer().getHeldItem(Hand.MAIN_HAND).getItem() == UnusedItems.LIGHT_BLOCK_TWEAKER && event.getWorld().getBlockState(event.getPos()).getBlock() == BedrockBlocks.LIGHT_1) {
			event.getWorld().setBlockState(event.getPos(), BedrockBlocks.LIGHT_2.getDefaultState());
		}
	}
	
	@SubscribeEvent
	public static void LightBlock2(PlayerInteractEvent.RightClickBlock event) {
		if (event.getPlayer().getHeldItem(Hand.MAIN_HAND).getItem() == UnusedItems.LIGHT_BLOCK_TWEAKER && event.getWorld().getBlockState(event.getPos()).getBlock() == BedrockBlocks.LIGHT_2) {
			  event.getWorld().setBlockState(event.getPos(), BedrockBlocks.LIGHT_3.getDefaultState());
		}
	}
	
	@SubscribeEvent
	public static void LightBlock3(PlayerInteractEvent.RightClickBlock event) {
		if (event.getPlayer().getHeldItem(Hand.MAIN_HAND).getItem() == UnusedItems.LIGHT_BLOCK_TWEAKER && event.getWorld().getBlockState(event.getPos()).getBlock() == BedrockBlocks.LIGHT_3) {
			  event.getWorld().setBlockState(event.getPos(), BedrockBlocks.LIGHT_4.getDefaultState());
		}
	}
	
	@SubscribeEvent
	public static void LightBlock4(PlayerInteractEvent.RightClickBlock event) {
		if (event.getPlayer().getHeldItem(Hand.MAIN_HAND).getItem() == UnusedItems.LIGHT_BLOCK_TWEAKER && event.getWorld().getBlockState(event.getPos()).getBlock() == BedrockBlocks.LIGHT_4) {
			  event.getWorld().setBlockState(event.getPos(), BedrockBlocks.LIGHT_5.getDefaultState());
		}
	}
	
	@SubscribeEvent
	public static void LightBlock5(PlayerInteractEvent.RightClickBlock event) {
		if (event.getPlayer().getHeldItem(Hand.MAIN_HAND).getItem() == UnusedItems.LIGHT_BLOCK_TWEAKER && event.getWorld().getBlockState(event.getPos()).getBlock() == BedrockBlocks.LIGHT_5) {
			  event.getWorld().setBlockState(event.getPos(), BedrockBlocks.LIGHT_6.getDefaultState());
		}
	}
	
	@SubscribeEvent
	public static void LightBlock6(PlayerInteractEvent.RightClickBlock event) {
		if (event.getPlayer().getHeldItem(Hand.MAIN_HAND).getItem() == UnusedItems.LIGHT_BLOCK_TWEAKER && event.getWorld().getBlockState(event.getPos()).getBlock() == BedrockBlocks.LIGHT_6) {
			  event.getWorld().setBlockState(event.getPos(), BedrockBlocks.LIGHT_7.getDefaultState());
		}
	}
	
	@SubscribeEvent
	public static void LightBlock7(PlayerInteractEvent.RightClickBlock event) {
		if (event.getPlayer().getHeldItem(Hand.MAIN_HAND).getItem() == UnusedItems.LIGHT_BLOCK_TWEAKER && event.getWorld().getBlockState(event.getPos()).getBlock() == BedrockBlocks.LIGHT_7) {
			  event.getWorld().setBlockState(event.getPos(), BedrockBlocks.LIGHT_8.getDefaultState());
		}
	}
	
	@SubscribeEvent
	public static void LightBlock8(PlayerInteractEvent.RightClickBlock event) {
		if (event.getPlayer().getHeldItem(Hand.MAIN_HAND).getItem() == UnusedItems.LIGHT_BLOCK_TWEAKER && event.getWorld().getBlockState(event.getPos()).getBlock() == BedrockBlocks.LIGHT_8) {
			  event.getWorld().setBlockState(event.getPos(), BedrockBlocks.LIGHT_9.getDefaultState());
		}
	}
	
	@SubscribeEvent
	public static void LightBlock9(PlayerInteractEvent.RightClickBlock event) {
		if (event.getPlayer().getHeldItem(Hand.MAIN_HAND).getItem() == UnusedItems.LIGHT_BLOCK_TWEAKER && event.getWorld().getBlockState(event.getPos()).getBlock() == BedrockBlocks.LIGHT_9) {
			  event.getWorld().setBlockState(event.getPos(), BedrockBlocks.LIGHT_10.getDefaultState());
		}
	}
	
	@SubscribeEvent
	public static void LightBlock10(PlayerInteractEvent.RightClickBlock event) {
		if (event.getPlayer().getHeldItem(Hand.MAIN_HAND).getItem() == UnusedItems.LIGHT_BLOCK_TWEAKER && event.getWorld().getBlockState(event.getPos()).getBlock() == BedrockBlocks.LIGHT_10) {
			  event.getWorld().setBlockState(event.getPos(), BedrockBlocks.LIGHT_11.getDefaultState());
		}
	}
	
	@SubscribeEvent
	public static void LightBlock11(PlayerInteractEvent.RightClickBlock event) {
		if (event.getPlayer().getHeldItem(Hand.MAIN_HAND).getItem() == UnusedItems.LIGHT_BLOCK_TWEAKER && event.getWorld().getBlockState(event.getPos()).getBlock() == BedrockBlocks.LIGHT_11) {
			  event.getWorld().setBlockState(event.getPos(), BedrockBlocks.LIGHT_12.getDefaultState());
		}
	}
	
	@SubscribeEvent
	public static void LightBlock12(PlayerInteractEvent.RightClickBlock event) {
		if (event.getPlayer().getHeldItem(Hand.MAIN_HAND).getItem() == UnusedItems.LIGHT_BLOCK_TWEAKER && event.getWorld().getBlockState(event.getPos()).getBlock() == BedrockBlocks.LIGHT_11) {
			  event.getWorld().setBlockState(event.getPos(), BedrockBlocks.LIGHT_12.getDefaultState());
		}
	}
	
	@SubscribeEvent
	public static void LightBlock13(PlayerInteractEvent.RightClickBlock event) {
		if (event.getPlayer().getHeldItem(Hand.MAIN_HAND).getItem() == UnusedItems.LIGHT_BLOCK_TWEAKER && event.getWorld().getBlockState(event.getPos()).getBlock() == BedrockBlocks.LIGHT_12) {
			  event.getWorld().setBlockState(event.getPos(), BedrockBlocks.LIGHT_13.getDefaultState());
		}
	}
	
	@SubscribeEvent
	public static void LightBlock14(PlayerInteractEvent.RightClickBlock event) {
		if (event.getPlayer().getHeldItem(Hand.MAIN_HAND).getItem() == UnusedItems.LIGHT_BLOCK_TWEAKER && event.getWorld().getBlockState(event.getPos()).getBlock() == BedrockBlocks.LIGHT_13) {
			  event.getWorld().setBlockState(event.getPos(), BedrockBlocks.LIGHT_14.getDefaultState());
		}
	}
	
	@SubscribeEvent
	public static void LightBlock15(PlayerInteractEvent.RightClickBlock event) {
		if (event.getPlayer().getHeldItem(Hand.MAIN_HAND).getItem() == UnusedItems.LIGHT_BLOCK_TWEAKER && event.getWorld().getBlockState(event.getPos()).getBlock() == BedrockBlocks.LIGHT_14) {
			  event.getWorld().setBlockState(event.getPos(), BedrockBlocks.LIGHT_15.getDefaultState());
		}
	}
	
	@SubscribeEvent
	public static void LightBlock0(PlayerInteractEvent.RightClickBlock event) {
		if (event.getPlayer().getHeldItem(Hand.MAIN_HAND).getItem() == UnusedItems.LIGHT_BLOCK_TWEAKER && event.getWorld().getBlockState(event.getPos()).getBlock() == BedrockBlocks.LIGHT_15) {
			  event.getWorld().setBlockState(event.getPos(), BedrockBlocks.LIGHT_0.getDefaultState());
		}
	}
	
}
