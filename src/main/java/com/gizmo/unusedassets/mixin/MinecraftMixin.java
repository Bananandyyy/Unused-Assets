package com.gizmo.unusedassets.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.gizmo.unusedassets.client.DynamicLightingManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;

@Mixin(Minecraft.class)
public class MinecraftMixin
{
	@Inject(at = @At("HEAD"), method = "unloadWorld(Lnet/minecraft/client/gui/screen/Screen;)V")
	private void unloadWorld(Screen screenIn, CallbackInfo callback)
	{
		DynamicLightingManager.cleanUp();
	}
}
