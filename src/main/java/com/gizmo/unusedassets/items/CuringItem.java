package com.gizmo.unusedassets.items;

import java.util.List;

import javax.annotation.Nullable;

import com.gizmo.unusedassets.init.UnusedItems.CureItems;
import com.gizmo.unusedassets.init.UnusedSounds;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CuringItem extends Item {

	private final CureItems cure;

	public CuringItem(CureItems cure, Properties properties) {
		super(properties);
		this.cure = cure;
	}

	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip,
			ITooltipFlag flagIn) {
		switch (cure) {
		case ANTIDOTE:
			tooltip.add(new TranslationTextComponent("items.antidote.effect").mergeStyle(TextFormatting.DARK_GREEN));
			break;
		case ELIXIR:
			tooltip.add(new TranslationTextComponent("items.elixir.effect").mergeStyle(TextFormatting.DARK_GREEN));
			break;
		case EYEDROPS:
			tooltip.add(new TranslationTextComponent("items.eyedrops.effect").mergeStyle(TextFormatting.DARK_GREEN));
			break;
		case TONIC:
			tooltip.add(new TranslationTextComponent("items.tonic.effect").mergeStyle(TextFormatting.DARK_GREEN));
			break;
		default:
			break;
		}
	}

	public UseAction getUseAction(ItemStack stack) {
		return UseAction.DRINK;
	}

	public int getUseDuration(ItemStack stack) {
		return 10;
	}

	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		return DrinkHelper.startDrinking(worldIn, playerIn, handIn);
	}

	@Override
	public SoundEvent getDrinkSound() {
		if (cure == CureItems.EYEDROPS) {
			return UnusedSounds.DRIP;
		}
		return UnusedSounds.GULP;
	}

	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		PlayerEntity playerentity = entityLiving instanceof PlayerEntity ? (PlayerEntity) entityLiving : null;
		if (playerentity instanceof ServerPlayerEntity) {
			CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayerEntity) playerentity, stack);
		}

		if (!worldIn.isRemote) {
			switch (cure) {
			case ANTIDOTE:
				playerentity.removePotionEffect(Effects.POISON);
				break;
			case ELIXIR:
				playerentity.removePotionEffect(Effects.WEAKNESS);
				break;
			case EYEDROPS:
				playerentity.removePotionEffect(Effects.BLINDNESS);
				break;
			case TONIC:
				playerentity.removePotionEffect(Effects.NAUSEA);
				break;
			default:
				break;
			}
		}
		return stack;
	}

}
