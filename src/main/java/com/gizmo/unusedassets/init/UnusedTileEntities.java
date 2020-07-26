package com.gizmo.unusedassets.init;

import java.util.ArrayList;

import com.gizmo.unusedassets.entity.tileentity.CompoundTileEntity;
import com.gizmo.unusedassets.entity.tileentity.ElementTileEntity;
import com.gizmo.unusedassets.entity.tileentity.GearTileEntity;
import com.gizmo.unusedassets.entity.tileentity.ReducerTileEntity;
import com.gizmo.unusedassets.entity.tileentity.TableTileEntity;
import com.gizmo.unusedassets.init.blocks.EducationBlocks;
import com.gizmo.unusedassets.init.blocks.UnusedBlocks;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = "unusedassets", bus = Mod.EventBusSubscriber.Bus.MOD)
public class UnusedTileEntities {

	private static final ArrayList<TileEntityType<?>> TILE_ENTITY_TYPES = new ArrayList<>();

	public static final TileEntityType<ElementTileEntity> ELEMENT_CONSTRUCTOR = register("element_constructor", TileEntityType.Builder.create(ElementTileEntity::new, EducationBlocks.ELEMENT_CONSTRUCTOR));
	public static final TileEntityType<CompoundTileEntity> COMPOUND_CREATOR = register("compound_creator", TileEntityType.Builder.create(CompoundTileEntity::new, EducationBlocks.COMPOUND_CREATOR));
	public static final TileEntityType<ReducerTileEntity> MATERIAL_REDUCER = register("material_reducer", TileEntityType.Builder.create(ReducerTileEntity::new, EducationBlocks.MATERIAL_REDUCER));
	public static final TileEntityType<TableTileEntity> LAB_TABLE = register("lab_table", TileEntityType.Builder.create(TableTileEntity::new, EducationBlocks.LAB_TABLE));

	
	public static final TileEntityType<GearTileEntity> GEAR = register("gear", TileEntityType.Builder.create(GearTileEntity::new, UnusedBlocks.GEAR));

	
	private static <T extends TileEntity> TileEntityType<T> register(String id, TileEntityType.Builder<T> builder)
    {
        TileEntityType<T> type = builder.build(null);
        type.setRegistryName(id);
        TILE_ENTITY_TYPES.add(type);
        return type;
    }

    @SubscribeEvent
    public static void registerTypes(final RegistryEvent.Register<TileEntityType<?>> event)
    {
        TILE_ENTITY_TYPES.forEach(type -> event.getRegistry().register(type));
        TILE_ENTITY_TYPES.clear();
    }
}
