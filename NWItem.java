package mods.mod_nw;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;
import mods.mod_nw.Item.BaseItem;
import mods.mod_nw.Item.CustomArmor;
import mods.mod_nw.Item.ScrollItem;

public class NWItem {
	static Item lexpiItem;
	static Item mingotItem;
	static Item cingotItem;
	static Item homescroll;
	static Item copperHelmet;
	static Item copperChestplate;
	static Item copperLegs;
	static Item copperBoots;
	static Item mythrilHelmet;
	static Item mythrilChestplate;
	static Item mythrilLegs;
	static Item mythrilBoots;

	/**
	 * Use following syntaxes: (Material Name, Durability, ReductionAmounts, Enchantability). 
	 * Reduction Amount is a main armor feature. 
	 * Vanilla Reduction Amounts :
	 * 	 Leather: {1, 3, 2, 1},
	 * 	 Chain: {2, 5, 4, 1}, 
	 *   Iron: {2, 6, 5, 2}, 
	 * 	 Gold: {2, 6, 5, 2}, 
	 * 	 Diamond: {3, 8, 6, 3}; 
	 * Vanilla Enchantabilities :
	 *  Leather: 15, 
	 *  Chain: 12, 
	 *  Iron: 9, 
	 *  Gold: 25, 
	 *  Diamond: 10; 
	 * Vanilla Durability - Leather: 5, Chain: 15, Iron: 15, Gold: 7, Diamond: 33.
	 */
	static EnumArmorMaterial copperArmorMaterial = EnumHelper.addArmorMaterial("copperArmorMaterial", 15, new int[] {
			2, 5, 4, 1 }, 9);
	static EnumArmorMaterial mythrilArmorMaterial = EnumHelper.addArmorMaterial("mythrilArmorMaterial", 40, new int[] {
			3, 8, 6, 3 }, 12);

	/** Renders **/
	private static int renderCOPERArmour;
	private static int renderMithrilArmour;

	public static void render() {
		/** Renders **/
		renderCOPERArmour = NordWest.proxy.addArmor("COPER");
		renderMithrilArmour = NordWest.proxy.addArmor("Mithril");
	}

	public static void init() {

		/** Item **/
		lexpiItem = new BaseItem(Config.ITEM_ID.lexpi_id).setUnlocalizedName("lexpi");
		mingotItem = new BaseItem(Config.ITEM_ID.mingot_id).setUnlocalizedName("mingot");
		cingotItem = new BaseItem(Config.ITEM_ID.cingot_id).setMaxStackSize(64).setUnlocalizedName("cingot");
		homescroll = new ScrollItem(Config.ITEM_ID.homescroll).setUnlocalizedName("homescroll");

		copperHelmet = new CustomArmor(Config.ITEM_ID.copperHelmet, copperArmorMaterial, renderCOPERArmour, 0)
				.setUnlocalizedName("copperHelmet");
		copperChestplate = new CustomArmor(Config.ITEM_ID.copperChestplate, copperArmorMaterial, renderCOPERArmour, 1)
				.setUnlocalizedName("copperChestplate");
		copperLegs = new CustomArmor(Config.ITEM_ID.copperLegs, copperArmorMaterial, renderCOPERArmour, 2)
				.setUnlocalizedName("copperLegs");
		copperBoots = new CustomArmor(Config.ITEM_ID.copperBoots, copperArmorMaterial, renderCOPERArmour, 3)
				.setUnlocalizedName("copperBoots");

		mythrilHelmet = new CustomArmor(Config.ITEM_ID.mythrilHelmet, mythrilArmorMaterial, renderMithrilArmour, 0)
				.setUnlocalizedName("mythrilHelmet");
		mythrilChestplate = new CustomArmor(Config.ITEM_ID.mythrilChestplate, mythrilArmorMaterial,
				renderMithrilArmour, 1).setUnlocalizedName("mythrilChestplate");
		mythrilLegs = new CustomArmor(Config.ITEM_ID.mythrilLegs, mythrilArmorMaterial, renderMithrilArmour, 2)
				.setUnlocalizedName("mythrilLegs");
		mythrilBoots = new CustomArmor(Config.ITEM_ID.mythrilBoots, mythrilArmorMaterial, renderMithrilArmour, 3)
				.setUnlocalizedName("mythrilBoots");

	}
}
