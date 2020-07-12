package com.gizmo.unusedassets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gizmo.unusedassets.init.UnusedItems;
import com.gizmo.unusedassets.init.blocks.BedrockBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

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
	}

	public void clientSetup(FMLClientSetupEvent e) {
	}

}