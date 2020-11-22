package com.gizmo.unusedassets.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

@OnlyIn(Dist.CLIENT)
public class LightingClient {
	
	public static void init()
	{
		MinecraftForge.EVENT_BUS.addListener((LivingUpdateEvent event) -> DynamicLightingManager.tick(event.getEntityLiving()));
	}

}
