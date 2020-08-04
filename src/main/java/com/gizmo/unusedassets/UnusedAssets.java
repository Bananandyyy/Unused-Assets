package com.gizmo.unusedassets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gizmo.unusedassets.client.UnusedDimensionsRenderInfo;
import com.gizmo.unusedassets.init.UnusedDimensions;
import com.gizmo.unusedassets.init.UnusedEntities;
import com.gizmo.unusedassets.init.UnusedItems;
import com.gizmo.unusedassets.init.blocks.BedrockBlocks;
import com.gizmo.unusedassets.util.actions.CauldronActionBottle;
import com.gizmo.unusedassets.util.actions.CauldronActionBucket;
import com.gizmo.unusedassets.util.actions.CauldronActionClean;
import com.gizmo.unusedassets.util.actions.CauldronActionDye;
import com.gizmo.unusedassets.util.actions.CauldronActions;

import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("unusedassets")
public final class UnusedAssets {

	public static final Logger LOGGER = LogManager.getLogger();

	public static final String MOD_ID = "unusedassets";
	public static final String NAME = "Unused Assets Mod";
	public static final ItemGroup java = new UnusedItemGroup("java");
	public static final ItemGroup bedrock = new BedrockItemGroup("bedrock");
	public static final ItemGroup education = new EducationItemGroup("education");
	public static final ItemGroup earth = new EarthItemGroup("earth");
	public static final ItemGroup dungeons = new DungeonsItemGroup("dungeons");

	public UnusedAssets() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
	}

	public static class UnusedItemGroup extends ItemGroup {
		public UnusedItemGroup(String label) {
			super(label);
		}

		public ItemStack createIcon() {
			return new ItemStack((IItemProvider) UnusedItems.FISH_BUCKET);
		}
	}

	public static class BedrockItemGroup extends ItemGroup {
		public BedrockItemGroup(String label) {
			super(label);
		}

		public ItemStack createIcon() {
			return new ItemStack((IItemProvider) BedrockBlocks.NETHER_CORE);
		}
	}

	public static class EducationItemGroup extends ItemGroup {
		public EducationItemGroup(String label) {
			super(label);
		}

		public ItemStack createIcon() {
			return new ItemStack((IItemProvider) UnusedItems.PORTFOLIO);
		}
	}

	public static class EarthItemGroup extends ItemGroup {
		public EarthItemGroup(String label) {
			super(label);
		}

		public ItemStack createIcon() {
			return new ItemStack((IItemProvider) UnusedItems.GARBAGE);
		}
	}

	public static class DungeonsItemGroup extends ItemGroup {
		public DungeonsItemGroup(String label) {
			super(label);
		}

		public ItemStack createIcon() {
			return new ItemStack((IItemProvider) UnusedItems.GARBAGE);
		}
	}
	
	public void commonSetup(FMLCommonSetupEvent e) {
		UnusedEntities.entityAttributes();
	}

	public void clientSetup(FMLClientSetupEvent e) {
		CauldronActions.addAction(new CauldronActionBucket());
		CauldronActions.addAction(new CauldronActionBottle());
		CauldronActions.addAction(new CauldronActionClean());
		CauldronActions.addAction(new CauldronActionDye());
		
		UnusedDimensionsRenderInfo dimensionRenderInfo = new UnusedDimensionsRenderInfo();
		DimensionRenderInfo.field_239208_a_.put(UnusedDimensions.dungeons, dimensionRenderInfo);
//		DimesionRenderInfo.hungy_kitty.3659_.put(bogchongul.69)42*10_pigchoongoo_HungyBoi
	}

}