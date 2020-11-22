package com.gizmo.unusedassets.entity.earth;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.gizmo.unusedassets.entity.ai.goal.MoolipPlaceBlockGoal;
import com.gizmo.unusedassets.entity.earth.base.CowBase;
import com.gizmo.unusedassets.init.blocks.EarthBlocks;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IForgeShearable;
import net.minecraftforge.fml.network.NetworkHooks;

public class MoolipEntity extends CowBase<MoolipEntity> implements IForgeShearable {

	public MoolipEntity(EntityType<MoolipEntity> type, World worldIn) {
		super(type, worldIn);
	}
	
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 2.0D));
		this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.25D, Ingredient.fromItems(Items.WHEAT), false));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(8, new MoolipPlaceBlockGoal(this));
	}

	public boolean isShearable(@Nonnull ItemStack item, World world, BlockPos pos) {
		return this.isAlive() && !this.isChild();
	}

	public static AttributeModifierMap.MutableAttribute registerAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 10.0D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, (double) 0.2F)
				.createMutableAttribute(Attributes.FOLLOW_RANGE, 16.0D);
	}

	@Nonnull
	public java.util.List<ItemStack> onSheared(@Nullable PlayerEntity player, @Nonnull ItemStack item, World world, BlockPos pos, int fortune) {
		world.playMovingSound(null, this, SoundEvents.ENTITY_MOOSHROOM_SHEAR,
				player == null ? SoundCategory.BLOCKS : SoundCategory.PLAYERS, 1.0F, 1.0F);
		if (!this.world.isRemote) {
			((ServerWorld) this.world).spawnParticle(ParticleTypes.EXPLOSION, this.getPosX(), this.getPosYHeight(0.5D),
					this.getPosZ(), 1, 0.0D, 0.0D, 0.0D, 0.0D);
			this.remove();
			CowEntity cowentity = EntityType.COW.create(this.world);
			cowentity.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw,
					this.rotationPitch);
			cowentity.setHealth(this.getHealth());
			cowentity.renderYawOffset = this.renderYawOffset;
			if (this.hasCustomName()) {
				cowentity.setCustomName(this.getCustomName());
				cowentity.setCustomNameVisible(this.isCustomNameVisible());
			}
			if (this.isNoDespawnRequired()) {
				cowentity.enablePersistence();
			}
			cowentity.setInvulnerable(this.isInvulnerable());
			this.world.addEntity(cowentity);
			java.util.List<ItemStack> ret = new java.util.ArrayList<>();
			for (int i = 0; i < 5; ++i) {
				ret.add(new ItemStack(EarthBlocks.PINK_DAISY));
			}
		}
		return java.util.Collections.emptyList();
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}


}
