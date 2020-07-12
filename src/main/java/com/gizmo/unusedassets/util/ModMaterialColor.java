package com.gizmo.unusedassets.util;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

//Vanilla Copy
public class ModMaterialColor {
	public static final ModMaterialColor[] COLORS = new ModMaterialColor[16];

	public static final ModMaterialColor WHITE = new ModMaterialColor(0, 268435455);
	public static final ModMaterialColor LIGHT_GRAY = new ModMaterialColor(1, 9737364);
	public static final ModMaterialColor GRAY = new ModMaterialColor(2, 5197647);
	public static final ModMaterialColor RED = new ModMaterialColor(3, 14822958);
	public static final ModMaterialColor ORANGE = new ModMaterialColor(4, 14846510);
	public static final ModMaterialColor YELLOW = new ModMaterialColor(5, 14869038);
	public static final ModMaterialColor CHARTREUSE = new ModMaterialColor(6, 9101870);
	public static final ModMaterialColor GREEN = new ModMaterialColor(7, 3072558);
	public static final ModMaterialColor SPRING_GREEN = new ModMaterialColor(8, 3072650);
	public static final ModMaterialColor CYAN = new ModMaterialColor(9, 3072738);
	public static final ModMaterialColor CAPRI = new ModMaterialColor(10, 6923744);
	public static final ModMaterialColor ULTRAMARINE = new ModMaterialColor(11, 8026850);
	public static final ModMaterialColor VIOLET = new ModMaterialColor(12, 9055970);
	public static final ModMaterialColor PURPLE = new ModMaterialColor(13, 11684578);
	public static final ModMaterialColor MAGENTA = new ModMaterialColor(14, 14823138);
	public static final ModMaterialColor ROSE = new ModMaterialColor(15, 14823050);

	public final int colorValue;

	public final int colorIndex;

	public ModMaterialColor(int index, int color) {
		if (index >= 0 && index <= 16) {
			this.colorIndex = index;
			this.colorValue = color;
			COLORS[index] = this;
		} else {
			throw new IndexOutOfBoundsException("You have more than 63 colors, you dumbass");
		}
	}

	@OnlyIn(Dist.CLIENT)
	public int getMapColor(int index) {
		int i = 220;
		if (index == 3)
			i = 135;
		if (index == 2)
			i = 255;
		if (index == 1)
			i = 220;
		if (index == 0)
			i = 180;
		int j = (this.colorValue >> 16 & 0xFF) * i / 255;
		int k = (this.colorValue >> 8 & 0xFF) * i / 255;
		int l = (this.colorValue & 0xFF) * i / 255;
		return 0xFF000000 | l << 16 | k << 8 | j;
	}
}
