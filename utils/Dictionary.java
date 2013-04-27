package mods.nordwest.utils;

import java.util.ArrayList;

import mods.nordwest.common.CustomBlocks;
import mods.nordwest.common.CustomItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class Dictionary {
	public static final String oreCopper = "oreCopper";
	public static final String oreMythril = "oreMythril";
	public static final String woodLog = "woodLog";
	public static final String woodPlank = "woodPlank";
	public static final String leavesTree = "leavesTree";
	public static final String saplingTree = "saplingTree";
	public static final String ingotCopper = "ingotCopper";
	public static final String ingotMythril = "ingotMythril";

	public static void init() {
		OreDictionary.registerOre(oreCopper, new ItemStack(CustomBlocks.copperOre));
		OreDictionary.registerOre(oreMythril, new ItemStack(CustomBlocks.mythrilOre));
		for (int i = 0; i < 4; i++) {
			OreDictionary.registerOre(woodLog, new ItemStack(CustomBlocks.customTreeWood, 1, i));
			OreDictionary.registerOre(woodPlank, new ItemStack(CustomBlocks.customTreePlank, 1, i));
			OreDictionary.registerOre(leavesTree, new ItemStack(CustomBlocks.customTreeLeaves, 1, i));
			OreDictionary.registerOre(saplingTree, new ItemStack(CustomBlocks.customTreeSapling, 1, i));
		}
		OreDictionary.registerOre(ingotCopper, new ItemStack(CustomItems.copperIngotItem));
		OreDictionary.registerOre(ingotMythril, new ItemStack(CustomItems.mythrilIngotItem));
	}
}
