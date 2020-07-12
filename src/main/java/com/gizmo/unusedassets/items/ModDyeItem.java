package com.gizmo.unusedassets.items;

import com.gizmo.unusedassets.util.ModDyeColor;
import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.item.Item;

//Vanilla copy to allow use of custom colors
public class ModDyeItem extends Item {
  private static final Map<ModDyeColor, ModDyeItem> COLOR_DYE_ITEM_MAP = Maps.newEnumMap(ModDyeColor.class);
  
  private ModDyeColor ModDyeColor;
  
  public ModDyeItem(ModDyeColor dyeColorIn, Item.Properties builder) {
    super(builder);
    this.ModDyeColor = dyeColorIn;
    COLOR_DYE_ITEM_MAP.put(dyeColorIn, this);
  }
  
  public ModDyeColor getModDyeColor() {
    return getModDyeColor();
  }
  
  public static ModDyeItem getItem(ModDyeColor color) {
    return COLOR_DYE_ITEM_MAP.get(color);
  }
}
