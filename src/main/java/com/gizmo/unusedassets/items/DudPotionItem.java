package com.gizmo.unusedassets.items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.world.World;

//Copied from Vanilla in most aspects, just took ouit the potion effects part
public class DudPotionItem extends Item {
  public DudPotionItem(Item.Properties builder) {
    super(builder);
  }
  
  public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
    PlayerEntity playerentity = (entityLiving instanceof PlayerEntity) ? (PlayerEntity)entityLiving : null;
    if (playerentity instanceof ServerPlayerEntity)
      CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayerEntity)playerentity, stack); 
    if (playerentity != null) {
      playerentity.addStat(Stats.ITEM_USED.get(this));
      if (!playerentity.abilities.isCreativeMode)
        stack.shrink(1); 
    } 
    if (playerentity == null || !playerentity.abilities.isCreativeMode) {
      if (stack.isEmpty())
        return new ItemStack((IItemProvider)Items.GLASS_BOTTLE); 
      if (playerentity != null)
        playerentity.inventory.addItemStackToInventory(new ItemStack((IItemProvider)Items.GLASS_BOTTLE)); 
    } 
    return stack;
  }
  
  public int getUseDuration(ItemStack stack) {
    return 32;
  }
  
  public UseAction getUseAction(ItemStack stack) {
    return UseAction.DRINK;
  }
  
  public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
    playerIn.setActiveHand(handIn);
    return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
  }
}
