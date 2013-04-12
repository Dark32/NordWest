package mods.nordwest.common;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import mods.nordwest.items.*;

public class CustomItems {
	static Item expaniteItem;
	static Item mythrilIngotItem;
	static Item copperIngotItem;
	static Item homescroll;
	
	static Item copperHelmet;
	static Item copperChestplate;
	static Item copperLegs;
	static Item copperBoots;
	static Item mythrilHelmet;
	static Item mythrilChestplate;
	static Item mythrilLegs;
	static Item mythrilBoots;
	
	static Item copperPickaxe;
	static Item copperAxe;
	static Item copperShovel;
	static Item copperHoe;
	static Item copperSword;
	static Item mythrilPickaxe;
	static Item mythrilAxe;
	static Item mythrilShovel;
	static Item mythrilHoe;
	static Item mythrilSword;

	 /**
	 * Armor Materials:
	 * Use following syntaxes: (Material Name, Durability, ReductionAmounts, Enchantability). 
	 * Vanilla Durability - Leather: 5, Chain: 15, Iron: 15, Gold: 7, Diamond: 33.
	 * Reduction Amount is a main armor feature. 
	 * Vanilla Reduction Amounts:
	 * 	 Leather: {1, 3, 2, 1},
	 * 	 Chain: {2, 5, 4, 1}, 
	 *   Iron: {2, 6, 5, 2}, 
	 * 	 Gold: {2, 6, 5, 2}, 
	 * 	 Diamond: {3, 8, 6, 3}.
	 * Vanilla Enchantabilities:
	 *   Leather: 15, 
	 *   Chain: 12, 
	 *   Iron: 9, 
	 *   Gold: 25, 
	 *   Diamond: 10.
	 */
	static EnumArmorMaterial copperArmorMaterial = EnumHelper.addArmorMaterial("copperArmorMaterial", 15, new int[] {2, 5, 4, 1 }, 9);
	static EnumArmorMaterial mythrilArmorMaterial = EnumHelper.addArmorMaterial("mythrilArmorMaterial", 40, new int[] {3, 8, 6, 3 }, 12);
	
	 /**
	 * Tool Materials:
	 * Use following syntaxes: (Material Name, Harvest Level (See Below), Durability (Max Uses), Speed, Entities Damage, Enchantability). 
	 * Vanilla Harvest Levels:
	 * 3 = DIAMOND (Everything + Obsidian); 
	 * 2 = IRON (Everything);
	 * 1 = STONE (Everything except Diamonds, Emeralds, Redstone);
	 * 0 = WOOD/GOLD (Everything except Diamonds, Emeralds, Redstone, Lapis, Gold & Iron).
	 * Vanilla Durabilities - Wood: 59, Stone: 131, Iron: 250, Diamond: 1561, Gold: 32.
	 * Vanilla Entities Damage - Diamond: 3, Iron: 2, Stone: 1, Wood/Gold: 0.
	 * Vanilla Enchantabilities -  Wood: 15, Stone: 5, Iron: 14, Diamond: 10, Gold: 22.
	 */
	static EnumToolMaterial mythrilToolMaterial = EnumHelper.addToolMaterial("mythrilToolMaterial", 3, 1561, 10.5F, 3, 22);
	static EnumToolMaterial copperToolMaterial = EnumHelper.addToolMaterial("copperToolMaterial", 2, 180, 6.5F, 2, 8);

	/** Renders **/
	private static int renderCopperArmour;
	private static int renderMythrilArmour;

	public static void render() {
		renderCopperArmour = NordWest.proxy.addArmor("Copper");
		renderMythrilArmour = NordWest.proxy.addArmor("Mythril");
	}

	public static void init() {

		/** Items **/
		expaniteItem = new BaseItem(Config.ITEM_ID.expanite_id).setUnlocalizedName("expanite");
		mythrilIngotItem = new BaseItem(Config.ITEM_ID.mythrilIngot_id).setUnlocalizedName("mythrilIngot");
		copperIngotItem = new BaseItem(Config.ITEM_ID.copperIngot_id).setMaxStackSize(64).setUnlocalizedName("copperIngot");
		homescroll = new ScrollItem(Config.ITEM_ID.homescroll).setUnlocalizedName("homescroll");

		copperHelmet = new CustomArmor(Config.ITEM_ID.copperHelmet, copperArmorMaterial, renderCopperArmour, 0).setUnlocalizedName("copperHelmet");
		copperChestplate = new CustomArmor(Config.ITEM_ID.copperChestplate, copperArmorMaterial, renderCopperArmour, 1).setUnlocalizedName("copperChestplate");
		copperLegs = new CustomArmor(Config.ITEM_ID.copperLegs, copperArmorMaterial, renderCopperArmour, 2).setUnlocalizedName("copperLegs");
		copperBoots = new CustomArmor(Config.ITEM_ID.copperBoots, copperArmorMaterial, renderCopperArmour, 3).setUnlocalizedName("copperBoots");

		mythrilHelmet = new CustomArmor(Config.ITEM_ID.mythrilHelmet, mythrilArmorMaterial, renderMythrilArmour, 0).setUnlocalizedName("mythrilHelmet");
		mythrilChestplate = new CustomArmor(Config.ITEM_ID.mythrilChestplate, mythrilArmorMaterial, renderMythrilArmour, 1).setUnlocalizedName("mythrilChestplate");
		mythrilLegs = new CustomArmor(Config.ITEM_ID.mythrilLegs, mythrilArmorMaterial, renderMythrilArmour, 2).setUnlocalizedName("mythrilLegs");
		mythrilBoots = new CustomArmor(Config.ITEM_ID.mythrilBoots, mythrilArmorMaterial, renderMythrilArmour, 3).setUnlocalizedName("mythrilBoots");
		
		copperPickaxe = new CustomPickaxe(Config.ITEM_ID.copperPickaxe, copperToolMaterial).setUnlocalizedName("copperPickaxe");
		copperAxe = new CustomAxe(Config.ITEM_ID.copperAxe, copperToolMaterial).setUnlocalizedName("copperAxe");
		copperShovel = new CustomShovel(Config.ITEM_ID.copperShovel, copperToolMaterial).setUnlocalizedName("copperShovel");
		copperSword = new CustomSword(Config.ITEM_ID.copperSword, copperToolMaterial).setUnlocalizedName("copperSword");
		copperHoe = new CustomHoe(Config.ITEM_ID.copperHoe, copperToolMaterial).setUnlocalizedName("copperHoe");
		
		mythrilPickaxe = new CustomPickaxe(Config.ITEM_ID.mythrilPickaxe, mythrilToolMaterial).setUnlocalizedName("mythrilPickaxe");
		mythrilAxe = new CustomAxe(Config.ITEM_ID.mythrilAxe, mythrilToolMaterial).setUnlocalizedName("mythrilAxe");
		mythrilShovel = new CustomShovel(Config.ITEM_ID.mythrilShovel, mythrilToolMaterial).setUnlocalizedName("mythrilShovel");
		mythrilSword = new CustomSword(Config.ITEM_ID.mythrilSword, mythrilToolMaterial).setUnlocalizedName("mythrilSword");
		mythrilHoe = new CustomHoe(Config.ITEM_ID.mythrilHoe, mythrilToolMaterial).setUnlocalizedName("mythrilHoe");

	}
	public static void setToolClass(){
		MinecraftForge.setToolClass(copperPickaxe, "pickaxe", 1);
		MinecraftForge.setToolClass(copperShovel, "shovel", 1);
		MinecraftForge.setToolClass(copperAxe, "axe", 1);
		MinecraftForge.setToolClass(mythrilPickaxe, "pickaxe", 3);
		MinecraftForge.setToolClass(mythrilShovel, "shovel", 3);
		MinecraftForge.setToolClass(mythrilAxe, "axe", 3);
	
	}
}
