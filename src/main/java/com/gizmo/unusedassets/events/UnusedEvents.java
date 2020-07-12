package com.gizmo.unusedassets.events;

import com.gizmo.unusedassets.UnusedAssets;
import com.gizmo.unusedassets.entity.AgentEntity;
import com.gizmo.unusedassets.init.blocks.BedrockBlocks;
import com.gizmo.unusedassets.init.blocks.UnusedBlocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.brewing.PotionBrewEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = "unusedassets", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class UnusedEvents {
	
	@SubscribeEvent
	public static void ReactorActivation(PlayerInteractEvent.RightClickBlock event) {
	  
	  if(event.getWorld().getBlockState(event.getPos()).getBlock() == BedrockBlocks.NETHER_CORE && event.getPlayer().getHeldItem(Hand.MAIN_HAND).isEmpty()) {
		  UnusedAssets.LOGGER.info("Nether Core was tapped!");
		  event.getPlayer().sendMessage(new StringTextComponent("Active!"), null);
		  //TODO: check structure and spawn spire
	  }
	  
  }
  
  public static void RandomPotionMixin(PotionBrewEvent.Post event) {
	  
	  //TODO: How can I make it so there is a random chance a dud potion is brewed?
  }
  
  @SubscribeEvent
  public static void FillBuckets(PlayerInteractEvent.RightClickBlock event) {
	  
	  if (event.getPlayer().getHeldItem(Hand.MAIN_HAND).getItem() == Items.BUCKET && event.getWorld().getBlockState(event.getPos()).getBlock() == UnusedBlocks.INFINITE_LAVA) {
		  if (!event.getPlayer().isCreative()) {
			  event.getItemStack().shrink(1);
			  event.getPlayer().addItemStackToInventory(new ItemStack(Items.LAVA_BUCKET));
		  }
	  }
	  if (event.getPlayer().getHeldItem(Hand.MAIN_HAND).getItem() == Items.BUCKET && event.getWorld().getBlockState(event.getPos()).getBlock() == UnusedBlocks.INFINITE_WATER) {
		  if (!event.getPlayer().isCreative()) {
			  event.getItemStack().shrink(1);
			  event.getPlayer().addItemStackToInventory(new ItemStack(Items.WATER_BUCKET));
		  }
	  }
  }
  
  @SubscribeEvent
  public static void CancelAgentDamage(LivingHurtEvent event) {
	  if (event.getEntity() instanceof AgentEntity) {
		  if (!event.getSource().isCreativePlayer()) {
			  if(event.isCancelable())
				  event.setCanceled(true);
		  }
	  }
  }
  
  /*@SubscribeEvent
  public static void ChangeLightValue (PlayerInteractEvent.RightClickBlock event) {
	  if (event.getPlayer().getHeldItem(Hand.MAIN_HAND).getItem() == BedrockBlocks.LIGHT_BLOCK.asItem() && event.getWorld().getBlockState(event.getPos()).getBlock() == BedrockBlocks.LIGHT_BLOCK) {
		  event.getWorld().setBlockState(event.getPos(), BedrockBlocks.LIGHT_BLOCK);
	  }
  }*/
  
  
  
  //Armor Stand GUI thing
/*  @SubscribeEvent
	public static void onPlayerEntityInteractSpecific(PlayerInteractEvent.EntityInteractSpecific event)
	{
		if (event.getTarget() instanceof ArmorStandEntity)
		{
			ArmorStandEntity armorstand = (ArmorStandEntity)event.getTarget();
			boolean isKeyDown = ArmorUtil.getFlag(event.getPlayer(), 2);

			if (ModConfiguration.enableConfigGui && isKeyDown)
			{
				if (event.getHand() == Hand.MAIN_HAND && event.getWorld().isRemote)
				{
					FMLNetworkHandler.openGui(event.getPlayer(), ArmorStand.INSTANCE, GuiHandler.GUI_ARMOR_STAND, event.getWorld(), armorstand.getEntityId(), 0, 0);
				}
				event.setCanceled(true);
				return;
			}

			if (ModConfiguration.enableNameTags && !isKeyDown && !event.getPlayer().isCrouching())
			{
				ItemStack stack = event.getPlayer().getHeldItem(Hand.MAIN_HAND);
				if (!stack.isEmpty() && stack.getItem() == Items.NAME_TAG && stack.hasDisplayName())
				{
					cancelRightClick = true;
					if (event.getHand() == Hand.MAIN_HAND && !event.getWorld().isRemote)
					{
						armorstand.setCustomName(stack.getDisplayName());
						armorstand.setAlwaysRenderNameTag(true);
					}
					event.setCanceled(true);
					return;
				}
			}

			if (ModConfiguration.overrideEntityInteract && !isKeyDown && !event.getPlayer().isSneaking())
			{
				cancelRightClick = true;
				if (event.getHand() == Hand.MAIN_HAND)
				{
					ArmorStandHooks.applyPlayerInteraction(armorstand, event.getPlayer(), event.getLocalPos(), event.getItemStack(), event.getHand());
				}
				event.setCanceled(true);
				return;
			}
		}
	}

	@SubscribeEvent
	public static void onPlayerRightClickItem(PlayerInteractEvent.RightClickItem event)
	{
		if (cancelRightClick)
		{
			cancelRightClick = false;
			event.setCanceled(true);
		}
	}*/

}

