package com.gizmo.unusedassets.events;

import java.util.Random;
import java.util.function.Predicate;

import com.gizmo.unusedassets.entity.AgentEntity;
import com.gizmo.unusedassets.entity.earth.FurnaceGolemEntity;
import com.gizmo.unusedassets.init.UnusedEntities;
import com.gizmo.unusedassets.init.blocks.EarthBlocks;
import com.gizmo.unusedassets.init.blocks.UnusedBlocks;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.pattern.BlockMaterialMatcher;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.EggEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.CachedBlockInfo;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.brewing.PotionBrewEvent;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = "unusedassets", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class UnusedEvents {

/*	@SubscribeEvent
	public static void ReactorActivation(PlayerInteractEvent.RightClickBlock event) {

		if (event.getWorld().getBlockState(event.getPos()).getBlock() == BedrockBlocks.NETHER_CORE
				&& event.getPlayer().getHeldItem(Hand.MAIN_HAND).isEmpty()) {
			UnusedAssets.LOGGER.info("Nether Core was tapped!");
			event.getPlayer().sendMessage(new StringTextComponent("Active!"), null);
			// TODO: check structure and spawn spire
		}

	}*/

	public static void RandomPotionMixin(PotionBrewEvent.Post event) {

		// TODO: How can I make it so there is a random chance a dud potion is brewed?
	}

	@SubscribeEvent
	public static void FillBuckets(PlayerInteractEvent.RightClickBlock event) {

		if (event.getPlayer().getHeldItem(Hand.MAIN_HAND).getItem() == Items.BUCKET
				&& event.getWorld().getBlockState(event.getPos()).getBlock() == UnusedBlocks.INFINITE_LAVA) {
			if (!event.getPlayer().isCreative()) {
				event.getItemStack().shrink(1);
				event.getPlayer().addItemStackToInventory(new ItemStack(Items.LAVA_BUCKET));
			}
		}
		if (event.getPlayer().getHeldItem(Hand.MAIN_HAND).getItem() == Items.BUCKET
				&& event.getWorld().getBlockState(event.getPos()).getBlock() == UnusedBlocks.INFINITE_WATER) {
			if (!event.getPlayer().isCreative()) {
				event.getItemStack().shrink(1);
				event.getPlayer().addItemStackToInventory(new ItemStack(Items.WATER_BUCKET));
			}
		}
	}

	@SubscribeEvent
	public static void CancelAgentDamage(LivingHurtEvent event) {
		if (event.getEntity() instanceof AgentEntity) {
			if (!event.getSource().isCreativePlayer()) {
				if (event.isCancelable())
					event.setCanceled(true);
			}
		}
	}

	private static final Predicate<BlockState> IS_PUMPKIN = (blockState) -> blockState != null
			&& (blockState.getBlock() == Blocks.CARVED_PUMPKIN || blockState.getBlock() == Blocks.JACK_O_LANTERN);

	@SubscribeEvent
	public static void onEggThrown(ProjectileImpactEvent.Throwable event) {
		ThrowableEntity throwable = event.getThrowable();
		World world = throwable.world;
		if (throwable instanceof EggEntity) {
			if (!world.isRemote) {
				if (new Random().nextInt(8) == 0) {
					int i = 1;
					if (new Random().nextInt(32) == 0) {
						i = 4;
					}
					for (int j = 0; j < i; ++j) {
						ChickenEntity chickenentity = getChickenEntity(world);
						chickenentity.setGrowingAge(-24000);
						chickenentity.setLocationAndAngles(throwable.getPosX(), throwable.getPosY(),
								throwable.getPosZ(), throwable.rotationYaw, 0.0F);
						world.addEntity(chickenentity);
					}
				}
				world.setEntityState(throwable, (byte) 3);
				throwable.remove();
			}
		}
	}

	private static ChickenEntity getChickenEntity(World world) {
		int chickenType = new Random().nextInt(6);
		ChickenEntity chickenentity;
		switch (chickenType) {
		case 0:
			chickenentity = UnusedEntities.AMBER_CHICKEN.create(world);
			break;
		case 2:
			chickenentity = UnusedEntities.MIDNIGHT_CHICKEN.create(world);
			break;
		case 4:
			chickenentity = UnusedEntities.STORMY_CHICKEN.create(world);
			break;
		default:
			chickenentity = EntityType.CHICKEN.create(world);
			break;
		}
		return chickenentity;
	}

	@SubscribeEvent
	public static void onCarvingMelon(PlayerInteractEvent.RightClickBlock event) {
		PlayerEntity player = event.getPlayer();
		BlockPos pos = event.getPos();
		Hand hand = event.getHand();
		ItemStack itemstack = player.getHeldItem(hand);
		World worldIn = player.world;
		BlockState blockState = worldIn.getBlockState(pos);
		Block block = blockState.getBlock();
		if (itemstack.getItem() == Items.SHEARS && block == Blocks.MELON) {
			if (!worldIn.isRemote) {
				Direction direction = event.getFace();
				Direction direction1 = direction.getAxis() == Direction.Axis.Y
						? player.getHorizontalFacing().getOpposite()
						: direction;
				worldIn.playSound((PlayerEntity) null, pos, SoundEvents.BLOCK_PUMPKIN_CARVE, SoundCategory.BLOCKS, 1.0F,
						1.0F);
				worldIn.setBlockState(pos,
						EarthBlocks.CARVED_MELON.getDefaultState().with(CarvedPumpkinBlock.FACING, direction1), 11);
				ItemEntity itementity = new ItemEntity(worldIn,
						(double) pos.getX() + 0.5D + (double) direction1.getXOffset() * 0.65D,
						(double) pos.getY() + 0.1D,
						(double) pos.getZ() + 0.5D + (double) direction1.getZOffset() * 0.65D,
						new ItemStack(Items.MELON_SEEDS, 4));
				itementity.setMotion(0.05D * (double) direction1.getXOffset() + worldIn.rand.nextDouble() * 0.02D,
						0.05D, 0.05D * (double) direction1.getZOffset() + worldIn.rand.nextDouble() * 0.02D);
				worldIn.addEntity(itementity);
				itemstack.damageItem(1, player, (entity) -> {
					entity.sendBreakAnimation(hand);
				});
			}
		}
	}

	@SubscribeEvent
	public static void onFurnaceGolemCreation(BlockEvent.EntityPlaceEvent event) {
		BlockState blockState = event.getPlacedBlock();
		Block block = blockState.getBlock();
		World world = (World) event.getWorld();
		if (block == Blocks.IRON_BLOCK || block == Blocks.BLAST_FURNACE || block == Blocks.JACK_O_LANTERN
				|| block == Blocks.CARVED_PUMPKIN) {
			BlockPos pos = event.getPos();
			BlockPattern golemPattern = BlockPatternBuilder.start().aisle("~^~", "#@#", "~#~")
					.where('^', CachedBlockInfo.hasState(IS_PUMPKIN))
					.where('#', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(Blocks.IRON_BLOCK)))
					.where('@', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(Blocks.BLAST_FURNACE)))
					.where('~', CachedBlockInfo.hasState(BlockMaterialMatcher.forMaterial(Material.AIR))).build();
			BlockPattern.PatternHelper patternHelper = golemPattern.match(world, pos);
			if (patternHelper != null) {
				for (int j = 0; j < golemPattern.getPalmLength(); ++j) {
					for (int k = 0; k < golemPattern.getThumbLength(); ++k) {
						CachedBlockInfo cachedBlockInfo = patternHelper.translateOffset(j, k, 0);
						world.setBlockState(cachedBlockInfo.getPos(), Blocks.AIR.getDefaultState(), 2);
						world.playEvent(2001, cachedBlockInfo.getPos(),
								Block.getStateId(cachedBlockInfo.getBlockState()));
					}
				}
				BlockPos blockpos = patternHelper.translateOffset(1, 2, 0).getPos();
				FurnaceGolemEntity furnaceGolemEntity = UnusedEntities.FURNACE_GOLEM.create(world);
				furnaceGolemEntity.setPlayerCreated(true);
				furnaceGolemEntity.setLocationAndAngles((double) blockpos.getX() + 0.5D,
						(double) blockpos.getY() + 0.05D, (double) blockpos.getZ() + 0.5D, 0.0F, 0.0F);
				world.addEntity(furnaceGolemEntity);
				for (ServerPlayerEntity serverplayerentity1 : world.getEntitiesWithinAABB(ServerPlayerEntity.class,
						furnaceGolemEntity.getBoundingBox().grow(5.0D))) {
					CriteriaTriggers.SUMMONED_ENTITY.trigger(serverplayerentity1, furnaceGolemEntity);
				}
				for (int i1 = 0; i1 < golemPattern.getPalmLength(); ++i1) {
					for (int j1 = 0; j1 < golemPattern.getThumbLength(); ++j1) {
						CachedBlockInfo cachedblockinfo1 = patternHelper.translateOffset(i1, j1, 0);
						world.func_230547_a_(cachedblockinfo1.getPos(), Blocks.AIR);
					}
				}
			}
		}
	}

}
