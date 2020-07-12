package com.gizmo.unusedassets.blocks;

import com.gizmo.unusedassets.state.properties.ModBlockStateProperties;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BannerItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.IDyeableArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.pathfinding.PathType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.BannerTileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BetterCauldronBlock extends Block {
	public static final IntegerProperty WATER_LEVEL = ModBlockStateProperties.WATER_LEVEL;
	public static final IntegerProperty LAVA_LEVEL = ModBlockStateProperties.LAVA_LEVEL;
	public static final IntegerProperty POTION_LEVEL = ModBlockStateProperties.POTION_LEVEL;

	private static final VoxelShape INSIDE = makeCuboidShape(2.0D, 4.0D, 2.0D, 14.0D, 16.0D, 14.0D);
	protected static final VoxelShape SHAPE = VoxelShapes.combineAndSimplify(VoxelShapes.fullCube(),
			VoxelShapes.or(makeCuboidShape(0.0D, 0.0D, 4.0D, 16.0D, 3.0D, 12.0D),
					makeCuboidShape(4.0D, 0.0D, 0.0D, 12.0D, 3.0D, 16.0D),
					makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 3.0D, 14.0D), INSIDE),
			IBooleanFunction.ONLY_FIRST);

	public BetterCauldronBlock(Block.Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(WATER_LEVEL, Integer.valueOf(0)));
	}

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}

	public VoxelShape getRaytraceShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return INSIDE;
	}

	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		int i = state.get(WATER_LEVEL);
		float f = (float) pos.getY() + (6.0F + (float) (3 * i)) / 16.0F;
		if (!worldIn.isRemote && entityIn.isBurning() && i > 0 && entityIn.getPosY() <= (double) f) {
			entityIn.extinguish();
			this.setWaterLevel(worldIn, pos, state, i - 1);
		}

	}

	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult p_225533_6_) {
		ItemStack itemstack = player.getHeldItem(handIn);
		if (itemstack.isEmpty()) {
			return ActionResultType.PASS;
		} else {
			int i = state.get(WATER_LEVEL);
			Item item = itemstack.getItem();
			if (item == Items.WATER_BUCKET) {
				if (i < 3 && !worldIn.isRemote) {
					if (!player.abilities.isCreativeMode) {
						player.setHeldItem(handIn, new ItemStack(Items.BUCKET));
					}

					player.addStat(Stats.FILL_CAULDRON);
					this.setWaterLevel(worldIn, pos, state, 3);
					worldIn.playSound((PlayerEntity) null, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS,
							1.0F, 1.0F);
				}

				return ActionResultType.SUCCESS;
			} else if (item == Items.BUCKET) {
				if (i == 3 && !worldIn.isRemote) {
					if (!player.abilities.isCreativeMode) {
						itemstack.shrink(1);
						if (itemstack.isEmpty()) {
							player.setHeldItem(handIn, new ItemStack(Items.WATER_BUCKET));
						} else if (!player.inventory.addItemStackToInventory(new ItemStack(Items.WATER_BUCKET))) {
							player.dropItem(new ItemStack(Items.WATER_BUCKET), false);
						}
					}

					player.addStat(Stats.USE_CAULDRON);
					this.setWaterLevel(worldIn, pos, state, 0);
					worldIn.playSound((PlayerEntity) null, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS,
							1.0F, 1.0F);
				}

				return ActionResultType.SUCCESS;
			} else if (item == Items.GLASS_BOTTLE) {
				if (i > 0 && !worldIn.isRemote) {
					if (!player.abilities.isCreativeMode) {
						ItemStack itemstack4 = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION),
								Potions.WATER);
						player.addStat(Stats.USE_CAULDRON);
						itemstack.shrink(1);
						if (itemstack.isEmpty()) {
							player.setHeldItem(handIn, itemstack4);
						} else if (!player.inventory.addItemStackToInventory(itemstack4)) {
							player.dropItem(itemstack4, false);
						} else if (player instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) player).sendContainerToPlayer(player.container);
						}
					}

					worldIn.playSound((PlayerEntity) null, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS,
							1.0F, 1.0F);
					this.setWaterLevel(worldIn, pos, state, i - 1);
				}

				return ActionResultType.SUCCESS;
			} else if (item == Items.POTION && PotionUtils.getPotionFromItem(itemstack) == Potions.WATER) {
				if (i < 3 && !worldIn.isRemote) {
					if (!player.abilities.isCreativeMode) {
						ItemStack itemstack3 = new ItemStack(Items.GLASS_BOTTLE);
						player.addStat(Stats.USE_CAULDRON);
						player.setHeldItem(handIn, itemstack3);
						if (player instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) player).sendContainerToPlayer(player.container);
						}
					}

					worldIn.playSound((PlayerEntity) null, pos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS,
							1.0F, 1.0F);
					this.setWaterLevel(worldIn, pos, state, i + 1);
				}

				return ActionResultType.SUCCESS;
			} else {
				if (i > 0 && item instanceof IDyeableArmorItem) {
					IDyeableArmorItem idyeablearmoritem = (IDyeableArmorItem) item;
					if (idyeablearmoritem.hasColor(itemstack) && !worldIn.isRemote) {
						idyeablearmoritem.removeColor(itemstack);
						this.setWaterLevel(worldIn, pos, state, i - 1);
						player.addStat(Stats.CLEAN_ARMOR);
						return ActionResultType.SUCCESS;
					}
				}

				if (i > 0 && item instanceof BannerItem) {
					if (BannerTileEntity.getPatterns(itemstack) > 0 && !worldIn.isRemote) {
						ItemStack itemstack2 = itemstack.copy();
						itemstack2.setCount(1);
						BannerTileEntity.removeBannerData(itemstack2);
						player.addStat(Stats.CLEAN_BANNER);
						if (!player.abilities.isCreativeMode) {
							itemstack.shrink(1);
							this.setWaterLevel(worldIn, pos, state, i - 1);
						}

						if (itemstack.isEmpty()) {
							player.setHeldItem(handIn, itemstack2);
						} else if (!player.inventory.addItemStackToInventory(itemstack2)) {
							player.dropItem(itemstack2, false);
						} else if (player instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) player).sendContainerToPlayer(player.container);
						}
					}

					return ActionResultType.SUCCESS;
				} else if (i > 0 && item instanceof BlockItem) {
					Block block = ((BlockItem) item).getBlock();
					if (block instanceof ShulkerBoxBlock && !worldIn.isRemote()) {
						ItemStack itemstack1 = new ItemStack(Blocks.SHULKER_BOX, 1);
						if (itemstack.hasTag()) {
							itemstack1.setTag(itemstack.getTag().copy());
						}

						player.setHeldItem(handIn, itemstack1);
						this.setWaterLevel(worldIn, pos, state, i - 1);
						player.addStat(Stats.CLEAN_SHULKER_BOX);
						return ActionResultType.SUCCESS;
					} else {
						return ActionResultType.CONSUME;
					}
				} else {
					return ActionResultType.PASS;
				}
			}
		}
	}

	public ActionResultType fillWithLava(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult result) {
		ItemStack itemstack = player.getHeldItem(handIn);
		if (itemstack.isEmpty()) {
			return ActionResultType.PASS;
		} else {
			int l = state.get(LAVA_LEVEL);
			Item item = itemstack.getItem();
			if (item == Items.LAVA_BUCKET) {
				if (l < 1 && !worldIn.isRemote) {
					if (!player.abilities.isCreativeMode) {
						player.setHeldItem(handIn, new ItemStack(Items.BUCKET));
					}
					player.addStat(Stats.FILL_CAULDRON);
					this.setLavaLevel(worldIn, pos, state, 1);
					worldIn.playSound((PlayerEntity) null, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS,
							1.0F, 1.0F);
				}
				return ActionResultType.SUCCESS;
			} else if (item == Items.BUCKET) {
				if (l == 1 && !worldIn.isRemote) {
					if (!player.abilities.isCreativeMode) {
						itemstack.shrink(1);
						if (itemstack.isEmpty()) {
							player.setHeldItem(handIn, new ItemStack(Items.LAVA_BUCKET));
						} else if (!player.inventory.addItemStackToInventory(new ItemStack(Items.LAVA_BUCKET))) {
							player.dropItem(new ItemStack(Items.LAVA_BUCKET), false);
						}
					}
					player.addStat(Stats.USE_CAULDRON);
					this.setWaterLevel(worldIn, pos, state, 0);
					worldIn.playSound((PlayerEntity) null, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS,
							1.0F, 1.0F);
				}
				return ActionResultType.SUCCESS;
			}
		}
		return ActionResultType.PASS;
	}

	public void setWaterLevel(World worldIn, BlockPos pos, BlockState state, int level) {
		worldIn.setBlockState(pos, state.with(WATER_LEVEL, Integer.valueOf(MathHelper.clamp(level, 0, 3))), 2);
		worldIn.updateComparatorOutputLevel(pos, this);
	}

	public void setLavaLevel(World worldIn, BlockPos pos, BlockState state, int level) {
		worldIn.setBlockState(pos, state.with(LAVA_LEVEL, Integer.valueOf(MathHelper.clamp(level, 0, 1))), 1);
		worldIn.updateComparatorOutputLevel(pos, this);
	}

	public void fillWithRain(World worldIn, BlockPos pos, BlockState blockState) {
		if (blockState.get(LAVA_LEVEL) >= 0 || blockState.get(POTION_LEVEL) >= 0) {
			if (worldIn.rand.nextInt(20) == 1) {
				float f = worldIn.getBiome(pos).getTemperature(pos);
				if (!(f < 0.15F)) {
					BlockState blockstate = worldIn.getBlockState(pos);
					if (blockstate.get(WATER_LEVEL) < 3) {
						worldIn.setBlockState(pos, blockstate.func_235896_a_(WATER_LEVEL), 2);
					}

				}
			}
		}
	}

	public boolean hasComparatorInputOverride(BlockState state) {
		return true;
	}

	public int getWaterComparatorInputOverride(BlockState blockState, World worldIn, BlockPos pos) {
		return blockState.get(WATER_LEVEL);
	}

	public int getLavaComparatorInputOverride(BlockState blockState, World worldIn, BlockPos pos) {
		return blockState.get(LAVA_LEVEL);
	}

	public int getPotionComparatorInputOverride(BlockState blockState, World worldIn, BlockPos pos) {
		return blockState.get(POTION_LEVEL);
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(WATER_LEVEL, LAVA_LEVEL, POTION_LEVEL);
	}

	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		return false;
	}

}
