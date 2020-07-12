package com.gizmo.unusedassets.init;

import java.util.ArrayList;

import com.gizmo.unusedassets.entity.tileentity.CompoundTileEntity;
import com.gizmo.unusedassets.entity.tileentity.ElementTileEntity;
import com.gizmo.unusedassets.inventory.container.CompoundContainer;
import com.gizmo.unusedassets.inventory.container.ElementContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.network.IContainerFactory;

@EventBusSubscriber(modid = "unusedassets", bus = Mod.EventBusSubscriber.Bus.MOD)
public class UnusedContainers {

	private static final ArrayList<ContainerType<?>> CONTAINER_TYPES = new ArrayList<>();
	
	public static final ContainerType<ElementContainer> ELEMENT_CONSTRUCTOR = register("element_constructor", (IContainerFactory<ElementContainer>) (windowId, playerInventory, data) -> {
        ElementTileEntity TileEntity = (ElementTileEntity) playerInventory.player.world.getTileEntity(data.readBlockPos());
        return new ElementContainer(windowId, playerInventory, TileEntity);
    });
	
	public static final ContainerType<CompoundContainer> COMPOUND_CREATOR = register("compound_creator", (IContainerFactory<CompoundContainer>) (windowId, playerInventory, data) -> {
        CompoundTileEntity TileEntity = (CompoundTileEntity) playerInventory.player.world.getTileEntity(data.readBlockPos());
        return new CompoundContainer(windowId, playerInventory, TileEntity);
    });
	 
	 
	 private static <T extends Container> ContainerType<T> register(String key, ContainerType.IFactory<T> factory)
	    {
	        ContainerType<T> type = new ContainerType<>(factory);
	        type.setRegistryName(key);
	        CONTAINER_TYPES.add(type);
	        return type;
	    }

	    @SubscribeEvent
	    public static void registerTypes(final RegistryEvent.Register<ContainerType<?>> event)
	    {
	        CONTAINER_TYPES.forEach(type -> event.getRegistry().register(type));
	        CONTAINER_TYPES.clear();
	    }
}
