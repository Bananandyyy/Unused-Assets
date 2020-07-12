package com.gizmo.unusedassets.particles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.Item;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class LightBlockParticle extends SpriteTexturedParticle {

	private LightBlockParticle(ClientWorld world, double x, double y, double z, IItemProvider provider) {
		super(world, x, y, z);
		this.setSprite(Minecraft.getInstance().getItemRenderer().getItemModelMesher().getParticleIcon(provider));
		this.particleGravity = 0.0F;
		this.maxAge = 80;
		this.canCollide = false;
	}

	public IParticleRenderType getRenderType() {
		return IParticleRenderType.TERRAIN_SHEET;
	}

	public float getScale(float scale) {
		return 0.5F;
	}

	@OnlyIn(Dist.CLIENT)
	public static class Factory implements IParticleFactory<BasicParticleType> {

		private Item theItem;

		public Factory(Item item) {
			theItem = item;
		}

		public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z,
				double xSpeed, double ySpeed, double zSpeed) {
			return new LightBlockParticle(worldIn, x, y, z, theItem);
		}
	}

}