package com.gizmo.unusedassets.util.actions;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = "unusedassets", bus = Mod.EventBusSubscriber.Bus.MOD)
public class CauldronActions {

	 private static final List<ICauldronAction> cauldronActionList = new ArrayList<ICauldronAction>();

	    public static void addAction(ICauldronAction action){
	        cauldronActionList.add(action);
	    }

	    public static ImmutableList<ICauldronAction> getCauldronActions(){
	        return ImmutableList.copyOf(cauldronActionList);
	    }
}
