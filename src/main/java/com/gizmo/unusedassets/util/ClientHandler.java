package com.gizmo.unusedassets.util;

import com.gizmo.unusedassets.client.entity.render.*;
import com.gizmo.unusedassets.client.entity.render.earth.*;
import com.gizmo.unusedassets.client.gui.*;
import com.gizmo.unusedassets.entity.tileentity.CauldronTER;
import com.gizmo.unusedassets.init.UnusedContainers;
import com.gizmo.unusedassets.init.UnusedEntities;
import com.gizmo.unusedassets.init.UnusedTileEntities;
import com.gizmo.unusedassets.init.blocks.BedrockBlocks;
import com.gizmo.unusedassets.init.blocks.EducationBlocks;
import com.gizmo.unusedassets.init.blocks.UnusedBlocks;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = "unusedassets", bus = Mod.EventBusSubscriber.Bus.MOD)
@OnlyIn(Dist.CLIENT)
public class ClientHandler {

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		
		ScreenManager.registerFactory(UnusedContainers.ELEMENT_CONSTRUCTOR, ElementScreen::new);
		ScreenManager.registerFactory(UnusedContainers.COMPOUND_CREATOR, CompoundScreen::new);
		ScreenManager.registerFactory(UnusedContainers.MATERIAL_REDUCER, ReducerScreen::new);
		ScreenManager.registerFactory(UnusedContainers.LAB_TABLE, TableScreen::new);
		
		
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.FISH, FishRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.PURPLE_ARROW, PurpleArrowRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.HEART_ARROW, HeartArrowRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.STEVE_VILLAGER_HYBRID, SteveVillagerRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.AGENT, AgentRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.LOVE_GOLEM, LoveGolemRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.HAPPY_CREEPER, HappyCreeperRenderer::new);
//		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.NAMELESS_ONE, NamelessRenderer::new);
		
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.ALBINO_COW, AlbinoCowRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.AMBER_CHICKEN, AmberChickenRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.ASHEN_COW, AshenCowRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.CLUCK_SHROOM, CluckShroomRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.FLECKED_SHEEP, FleckedSheepRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.HORNED_SHEEP, HornedSheepRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.INKY_SHEEP, InkySheepRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.MIDNIGHT_CHICKEN, MidnightChickenRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.ROCKY_SHEEP, RockySheepRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.STORMY_CHICKEN, StormyChickenRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(UnusedEntities.SUNSET_COW, SunsetCowRenderer::new);
		
		
		ClientRegistry.bindTileEntityRenderer(UnusedTileEntities.GEAR, GearRenderer::new);
		ClientRegistry.bindTileEntityRenderer(UnusedTileEntities.CAULDRON, CauldronTER::new);

		
		RenderTypeLookup.setRenderLayer(BedrockBlocks.CYAN_FLOWER, RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(UnusedBlocks.GEAR, RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(UnusedBlocks.ROSE, RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(UnusedBlocks.PAEONIA, RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EducationBlocks.RED_TORCH, RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EducationBlocks.GREEN_TORCH, RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EducationBlocks.BLUE_TORCH, RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EducationBlocks.PURPLE_TORCH, RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(EducationBlocks.UNDERWATER_TORCH, RenderType.getCutout());
		
		
	}
	
}