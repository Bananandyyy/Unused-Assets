package com.gizmo.unusedassets.entity.earth;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.gizmo.unusedassets.entity.ai.goal.MelonGolemHopGoal;
import com.gizmo.unusedassets.entity.projectile.MelonSeedProjectileEntity;
import com.gizmo.unusedassets.init.blocks.EarthBlocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.IForgeShearable;

public class MelonGolemEntity extends GolemEntity implements IRangedAttackMob, IForgeShearable {
	private static final DataParameter<Byte> MELON_EQUIPPED = EntityDataManager.createKey(MelonGolemEntity.class,
			DataSerializers.BYTE);
	private static final DataParameter<Integer> SHOOTING_TICKS = EntityDataManager.createKey(MelonGolemEntity.class,
			DataSerializers.VARINT);
	private int lastBlink = 0;
	private int nextBlinkInterval = new Random().nextInt(740) + 60;
	private int remainingTick = 0;
	private int internalBlinkTick = 0;

	public MelonGolemEntity(EntityType<? extends MelonGolemEntity> type, World worldIn) {
	      super(type, worldIn);
	   }

	   protected void registerGoals() {
	      this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 20, 10.0F));
	      this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, 1.0D, 1.0000001E-5F));
	      this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 6.0F));
	      this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
	      this.goalSelector.addGoal(1, new MelonGolemHopGoal(this));
	      this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, MobEntity.class, 10, true, false, (entity) -> entity instanceof IMob && !(entity instanceof TropicalSlimeEntity)));
	   }

	   public static AttributeModifierMap.MutableAttribute registerAttributes() {
	      return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 4.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.2F);
	   }

	   protected void registerData() {
	      super.registerData();
	      this.dataManager.register(MELON_EQUIPPED, (byte)16);
	      this.dataManager.register(SHOOTING_TICKS, 0);
	   }

	   public void writeAdditional(CompoundNBT compound) {
	      super.writeAdditional(compound);
	      compound.putBoolean("Melon", this.isMelonEquipped());
	   }

	   public void readAdditional(CompoundNBT compound) {
	      super.readAdditional(compound);
	      if (compound.contains("Melon")) {
	         this.setMelonEquipped(compound.getBoolean("Melon"));
	      }

	   }
	   
	   public int getJumpDelay() {
			return this.rand.nextInt(20) + 10;
		}

	   public boolean isWaterSensitive() {
	      return true;
	   }

	   public void livingTick() {
	      super.livingTick();
	      if (!this.world.isRemote) {
	         int i = MathHelper.floor(this.getPosX());
	         int j = MathHelper.floor(this.getPosY());
	         int k = MathHelper.floor(this.getPosZ());
	         if (this.world.getBiome(new BlockPos(i, 0, k)).getTemperature(new BlockPos(i, j, k)) > 1.0F) {
	            this.attackEntityFrom(DamageSource.ON_FIRE, 1.0F);
	         }

	         if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this)) {
	            return;
	         }

	         BlockState blockstate = Blocks.SNOW.getDefaultState();

	         for(int l = 0; l < 4; ++l) {
	            i = MathHelper.floor(this.getPosX() + (double)((float)(l % 2 * 2 - 1) * 0.25F));
	            j = MathHelper.floor(this.getPosY());
	            k = MathHelper.floor(this.getPosZ() + (double)((float)(l / 2 % 2 * 2 - 1) * 0.25F));
	            BlockPos blockpos = new BlockPos(i, j, k);
	            if (this.world.isAirBlock(blockpos) && this.world.getBiome(blockpos).getTemperature(blockpos) < 0.8F && blockstate.isValidPosition(this.world, blockpos)) {
	               this.world.setBlockState(blockpos, blockstate);
	            }
	         }
	      }
	      int currentShootingTicks = this.dataManager.get(SHOOTING_TICKS);
			if (currentShootingTicks > 0) {
				this.dataManager.set(SHOOTING_TICKS, --currentShootingTicks);
			}
			if (this.remainingTick > 0) {
				--this.remainingTick;
			}
			if (this.internalBlinkTick == (this.lastBlink + this.nextBlinkInterval)) {
				this.lastBlink = this.internalBlinkTick;
				this.nextBlinkInterval = new Random().nextInt(740) + 60;
				this.remainingTick = 4;
			}
			++this.internalBlinkTick;
		}

		public int getBlinkRemainingTicks() {
			return this.remainingTick;
		}

		public boolean isShooting() {
			return this.dataManager.get(SHOOTING_TICKS) > 0;
		}

		public void setShootingTicks() {
			this.dataManager.set(SHOOTING_TICKS, 8);
		}

	   public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
	      MelonSeedProjectileEntity seedentity = new MelonSeedProjectileEntity(this.world, this);
	      double d0 = target.getPosYEye() - (double)1.1F;
	      double d1 = target.getPosX() - this.getPosX();
	      double d2 = d0 - seedentity.getPosY();
	      double d3 = target.getPosZ() - this.getPosZ();
	      float f = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F;
	      seedentity.shoot(d1, d2 + (double)f, d3, 1.6F, 12.0F);
	      this.playSound(SoundEvents.ENTITY_SNOW_GOLEM_SHOOT, 1.0F, 0.4F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
	      this.world.addEntity(seedentity);
	   }

	   protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
	      return 1.7F;
	   }

	@SuppressWarnings("unused")
	protected ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
	      ItemStack itemstack = p_230254_1_.getHeldItem(p_230254_2_);
	      if (false && itemstack.getItem() == Items.SHEARS && this.isShearable()) {
	         this.shear(SoundCategory.PLAYERS);
	         if (!this.world.isRemote) {
	            itemstack.damageItem(1, p_230254_1_, (p_213622_1_) -> {
	               p_213622_1_.sendBreakAnimation(p_230254_2_);
	            });
	         }

	         return ActionResultType.func_233537_a_(this.world.isRemote);
	      } else {
	         return ActionResultType.PASS;
	      }
	   }

	   public void shear(SoundCategory category) {
	      this.world.playMovingSound((PlayerEntity)null, this, SoundEvents.ENTITY_SNOW_GOLEM_SHEAR, category, 1.0F, 1.0F);
	      if (!this.world.isRemote()) {
	         this.setMelonEquipped(false);
	         this.entityDropItem(new ItemStack(EarthBlocks.CARVED_MELON), 1.7F);
	      }

	   }

	   public boolean isShearable() {
	      return this.isAlive() && this.isMelonEquipped();
	   }

	   public boolean isMelonEquipped() {
	      return (this.dataManager.get(MELON_EQUIPPED) & 16) != 0;
	   }

	   public void setMelonEquipped(boolean melonEquipped) {
	      byte b0 = this.dataManager.get(MELON_EQUIPPED);
	      if (melonEquipped) {
	         this.dataManager.set(MELON_EQUIPPED, (byte)(b0 | 16));
	      } else {
	         this.dataManager.set(MELON_EQUIPPED, (byte)(b0 & -17));
	      }

	   }

	   @Nullable
	   protected SoundEvent getAmbientSound() {
	      return SoundEvents.ENTITY_SNOW_GOLEM_AMBIENT;
	   }

	   @Nullable
	   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
	      return SoundEvents.ENTITY_SNOW_GOLEM_HURT;
	   }

	   @Nullable
	   protected SoundEvent getDeathSound() {
	      return SoundEvents.ENTITY_SNOW_GOLEM_DEATH;
	   }

	   @OnlyIn(Dist.CLIENT)
	   public Vector3d func_241205_ce_() {
	      return new Vector3d(0.0D, (double)(0.75F * this.getEyeHeight()), (double)(this.getWidth() * 0.4F));
	   }

	   @Override
	   public boolean isShearable(@Nonnull ItemStack item, World world, BlockPos pos) {
	      return isShearable();
	   }

	   @Nonnull
	   @Override
	   public List<ItemStack> onSheared(@Nullable PlayerEntity player, @Nonnull ItemStack item, World world, BlockPos pos, int fortune) {
	      world.playMovingSound(null, this, SoundEvents.ENTITY_SNOW_GOLEM_SHEAR, player == null ? SoundCategory.BLOCKS : SoundCategory.PLAYERS, 1.0F, 1.0F);
	      if (!world.isRemote()) {
	         setMelonEquipped(false);
	         return Collections.singletonList(new ItemStack(EarthBlocks.CARVED_MELON));
	      }
	      return Collections.emptyList();
	   }
	}