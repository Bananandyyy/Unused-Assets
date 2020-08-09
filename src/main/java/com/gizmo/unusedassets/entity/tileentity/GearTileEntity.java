package com.gizmo.unusedassets.entity.tileentity;

import java.util.ArrayList;

import javax.annotation.Nullable;

import com.gizmo.unusedassets.blocks.GearWireBlock.EnumFaces;
import com.gizmo.unusedassets.init.UnusedTileEntities;
import com.gizmo.unusedassets.init.blocks.UnusedBlocks;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

public class GearTileEntity extends TileEntity implements ITickableTileEntity
{
	private int[] powers = new int[] { 0, 0, 0, 0, 0, 0 };
		private int[] angles = new int[] { 0, 0, 0, 0, 0, 0 };

	private Source[] sources = Source.arrayOf(6, new Source(BlockPos.ZERO, -1));

	public GearTileEntity()
	{
		super(UnusedTileEntities.GEAR);
	}

	public GearTileEntity(TileEntityType<?> tileEntityTypeIn)
	{
		super(tileEntityTypeIn);
	}

	@Override
	public void tick()
	{
		// Update the gear's angle so it animates nice
		for (int i = 0; i < 6; i++)
		{
			if (powers[i] != 0)
				this.addAngle(i, (powers[i] / 2) + (powers[i] > 0 ? 1 : -1));
		}

		// Handles the gears setting their power and triggering other gears
		if (this.world.getBlockState(pos).getBlock() == UnusedBlocks.GEAR && !world.isRemote)
		{
			BlockState gear = this.world.getBlockState(pos);

			for (EnumFaces enumFace : EnumFaces.values())
			{
				if (gear.get(enumFace.face).exists())
				{
					Direction direction = enumFace.direction;
					BlockState offsetState = this.world.getBlockState(pos.offset(direction));

					int redstoneStrength = world.getRedstonePower(pos.offset(direction).offset(direction), direction);

					/*if (isConverterPowered(offsetState, direction) && !this.isPowered(direction))
					{
						this.setPower(direction, redstoneStrength);
						this.updateConnectedGears(pos, direction, redstoneStrength, false);
					}

					if (!(isConverterPowered(offsetState, direction) || isSourcePowered(direction)) && this.isPowered(direction))
					{
						this.setPower(direction, 0);
						this.updateConnectedGears(pos, direction, 0, true);
					}*/
				}
			}
		}
	}

	/*public boolean isConverterPowered(BlockState state, Direction direction)
	{
		return state.getBlock() == RediscoveredBlocks.rotational_converter && state.get(RotationalConverterBlock.FACING) == direction.getOpposite() && state.get(RotationalConverterBlock.MODE) == Mode.REDSTONE_TO_GEAR && state.get(RotationalConverterBlock.POWERED) == true;

	}*/

	public boolean isSourcePowered(Direction direction)
	{
		TileEntity sourceTile = world.getTileEntity(this.getSource(direction).pos);
		if (sourceTile != null && sourceTile instanceof GearTileEntity)
		{
			Direction sourceDirection = this.getSource(direction).getDirection();
			if (sourceDirection != null)
				return ((GearTileEntity) sourceTile).isPowered(sourceDirection);
		}

		return false;
	}

	/**
	 * Spins gears connected to the current tile entity if they are not already
	 * spinning. This method is recursive, so it will call itself.
	 * 
	 * @param fromPos
	 * @param fromDirection
	 * @param power
	 * @param clearSource
	 */
	public void updateConnectedGears(BlockPos fromPos, Direction fromDirection, int power, boolean clearSource)
	{
		power = -power;
		for (Direction direction : Direction.values())
		{
			if (direction.getAxis() != fromDirection.getAxis())
			{
				Source source = clearSource ? new Source() : new Source(fromPos, fromDirection);

				// Within same block
				if (this.getBlockState().get(EnumFaces.get(direction).face).exists() && Math.abs(this.getPower(direction)) != Math.abs(power))
				{
					this.setPowerAndSource(direction, power, source);
					this.updateConnectedGears(this.pos, direction, power, clearSource);
				}

				// Wrap around block
				BlockPos offset = pos.offset(fromDirection).offset(direction);
				TileEntity tile = world.getTileEntity(offset);
				BlockState state = world.getBlockState(offset);
				if (tile instanceof GearTileEntity && state.getBlock() == UnusedBlocks.GEAR)
				{
					if (state.get(EnumFaces.get(direction.getOpposite()).face).exists() && Math.abs(((GearTileEntity) tile).getPower(direction.getOpposite())) != Math.abs(power))
					{
						((GearTileEntity) tile).setPowerAndSource(direction.getOpposite(), power, source);
						((GearTileEntity) tile).updateConnectedGears(offset, direction.getOpposite(), power, clearSource);
					}
				}

				// Adjacent gears
				offset = pos.offset(direction);
				tile = world.getTileEntity(offset);
				state = world.getBlockState(offset);
				if (tile instanceof GearTileEntity && state.getBlock() == UnusedBlocks.GEAR)
				{
					if (state.get(EnumFaces.get(fromDirection).face).exists() && Math.abs(((GearTileEntity) tile).getPower(fromDirection)) != Math.abs(power))
					{
						((GearTileEntity) tile).setPowerAndSource(fromDirection, power, source);
						((GearTileEntity) tile).updateConnectedGears(offset, fromDirection, power, clearSource);
					}
				}
			}
		}
	}

	public void updateConverter(Direction direction)
	{
		BlockState state = world.getBlockState(this.pos.offset(direction));
		/*if (!this.world.isRemote && state.getBlock() == RediscoveredBlocks.rotational_converter)
		{
			world.getPendingBlockTicks().scheduleTick(this.pos.offset(direction), state.getBlock(), 2);
		}*/
	}

	/*public void read(CompoundNBT compound)
	{
		super.read(compound);
		this.powers = compound.getIntArray("Powers");
		this.angles = compound.getIntArray("Angles");
		CompoundNBT sourcesNBT = compound.getCompound("Sources");
		for (int i = 0; i < Direction.values().length; i++)
			this.sources[i] = new Source(sourcesNBT.getIntArray(Direction.values()[i].toString()));
	}*/

	public CompoundNBT write(CompoundNBT compound)
	{
		super.write(compound);
		compound.putIntArray("Powers", powers);
		compound.putIntArray("Angles", angles);
		CompoundNBT sourcesNBT = new CompoundNBT();
		for (int i = 0; i < Direction.values().length; i++)
			sourcesNBT.putIntArray(Direction.values()[i].toString(), new int[] { sources[i].pos.getX(), sources[i].pos.getY(), sources[i].pos.getZ(), sources[i].directionIndex });
		compound.put("Sources", sourcesNBT);
		return compound;
	}

	public CompoundNBT getUpdateTag()
	{
		return write(new CompoundNBT());
	}

	/*public void handleUpdateTag(CompoundNBT tag)
	{
		getTileEntity().read(tag);
	}*/

	public final SUpdateTileEntityPacket getUpdatePacket()
	{
		return new SUpdateTileEntityPacket(this.pos, -999, serializeNBT());
	}

	/*public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket packet)
	{
		read(packet.getNbtCompound());
	}*/

	public int[] getPowers()
	{
		return this.powers;
	}

	// Gets the power of the face specified.
	public int getPower(Direction direction)
	{
		return this.powers[direction.getIndex()];
	}

	public boolean isPowered(Direction direction)
	{
		return this.getPower(direction) != 0;
	}

	// Sets the power of the face specified, keeping it between -15 and 15.
	public void setPower(Direction direction, int power)
	{
		if (power < -15)
			power = -15;
		if (power > 15)
			power = 15;
		if (Math.abs(this.getPower(direction)) != Math.abs(power))
			this.updateConverter(direction);
		this.powers[direction.getIndex()] = power;
	}

	public int[] getAngles()
	{
		return this.angles;
	}

	// Gets the angle of the face specified.
	public int getAngle(Direction direction)
	{
		return this.angles[direction.getIndex()];
	}

	// Gets the angle of the face specified.
	public void setAngle(Direction direction, int angle)
	{
		if (angle < 0)
			angle = 0;
		if (angle > 359)
			angle = 359;
		this.angles[direction.getIndex()] = angle;
	}

	// Adds to the angle specified, making sure it's within 0 and 359 inclusive.
	public void addAngle(int direction, int amount)
	{
		this.angles[direction] += (amount % 360);
		if (this.angles[direction] > 359)
			this.angles[direction] -= 360;
		if (this.angles[direction] < 0)
			this.angles[direction] += 360;
	}

	public void addAngle(Direction direction, int amount)
	{
		this.addAngle(direction.getIndex(), amount);
	}

	public Source[] getSources()
	{
		return this.sources;
	}

	public Source getSource(Direction direction)
	{
		return sources[direction.getIndex()];
	}

	public void setSource(Direction direction, Source source)
	{
		this.sources[direction.getIndex()] = source;
	}

	public void setPowerAndSource(Direction direction, int power, Source source)
	{
		this.setPower(direction, power);
		this.setSource(direction, source);
	}

	public static class Source
	{
		private final BlockPos pos;
		private final int directionIndex;

		public Source(BlockPos pos, int directionIndex)
		{
			this.pos = new BlockPos(pos);
			this.directionIndex = directionIndex;
		}

		public Source(BlockPos pos, Direction direction)
		{
			this(pos, direction.getIndex());
		}

		public Source(int[] array)
		{
			this(new BlockPos(array[0], array[1], array[2]), array[3]);
		}

		public Source()
		{
			this(BlockPos.ZERO, -1);
		}

		public BlockPos getPos()
		{
			return pos;
		}

		@Nullable
		public Direction getDirection()
		{
			if (directionIndex >= 0 && directionIndex <= 5)
				return Direction.byIndex(directionIndex);
			else
				return null;
		}

		public static Source[] arrayOf(int size, Source source)
		{
			ArrayList<Source> list = new ArrayList<>();
			for (int i = 0; i < size; i++)
				list.add(source);
			return list.toArray(new Source[] {});
		}
	}
	
	 public ResourceLocation getTexture() {
		    return new ResourceLocation("unusedassets", "textures/block/gear.png");
		  }
}
