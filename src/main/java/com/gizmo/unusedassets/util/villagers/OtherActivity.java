package com.gizmo.unusedassets.util.villagers;

import net.minecraft.entity.ai.brain.schedule.Activity;
import net.minecraft.util.registry.Registry;

public class OtherActivity extends Activity {

	public static final Activity STRANGE_PANIC = register("strange_panic");
	
	public OtherActivity(String key) {
		super(key);
	}
	
	private static Activity register(String key) {
	      return Registry.register(Registry.ACTIVITY, key, new Activity(key));
	   }

}
