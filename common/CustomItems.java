package mods.nordwest.common;

import net.minecraft.block.Block;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import mods.nordwest.items.*;

public class CustomItems {
	public static Item expaniteItem;
	public static Item mythrilIngotItem;
	public static Item copperIngotItem;
	public static Item homescroll;
	public static Item wax;
	
	public static Item copperHelmet;
	public static Item copperChestplate;
	public static Item copperLegs;
	public static Item copperBoots;
	public static Item mythrilHelmet;
	public static Item mythrilChestplate;
	public static Item mythrilLegs;
	public static Item mythrilBoots;

	public static Item copperPickaxe;
	public static Item copperAxe;
	public static Item copperShovel;
	public static Item copperHoe;
	public static Item copperSword;
	public static Item mythrilPickaxe;
	public static Item mythrilAxe;
	public static Item mythrilShovel;
	public static Item mythrilHoe;
	public static Item mythrilSword;
	public static Item samuraiHelmet;
	public static Item samuraiChestplate;
	public static Item samuraiLegs;
	public static Item samuraiBoots;
	public static Item seedRye;
	public static Item cropRye;
	public static Item seedRice;
	public static Item seedBlackRice;
	public static Item basefood;
	public static Item woodDagger;
	public static Item stoneDagger;
	public static Item ironDagger;
	public static Item goldDagger;
	public static Item diamondDagger;
	public static Item copperDagger;
	public static Item mythrilDagger;
	/**
	 * Armor Materials:
	 * Use following syntaxes: (Material Name, Durability, ReductionAmounts, Enchantability). 
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
	public static EnumArmorMaterial copperArmorMaterial = EnumHelper.addArmorMaterial("copperArmorMaterial", 15, new int[] { 2, 5, 4, 1 }, 9);
	public static EnumArmorMaterial mythrilArmorMaterial = EnumHelper.addArmorMaterial("mythrilArmorMaterial", 40, new int[] { 3, 8, 6, 3 }, 12);
	public static EnumArmorMaterial samuraiArmorMaterial = EnumHelper.addArmorMaterial("samuraiArmorMaterial", 10, new int[] { 2, 6, 5, 2 }, 18);
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
	private static int renderSamuraiArmour;
	
	
	
	

	public static void render() {
		renderCopperArmour = NordWest.proxy.addArmor("Copper");
		renderMythrilArmour = NordWest.proxy.addArmor("Mythril");
		renderSamuraiArmour = NordWest.proxy.addArmor("Samurai");
	}

	public static void init() {
		/** set Repair material **/
		copperArmorMaterial.customCraftingMaterial = copperIngotItem;
		mythrilToolMaterial.customCraftingMaterial = mythrilIngotItem;
		/** Items **/
		wax = new BaseItem(Config.ITEM_ID.wax).setUnlocalizedName("wax");
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

		samuraiHelmet = new CustomColoredArmor(Config.ITEM_ID.samuraiHelmet, samuraiArmorMaterial, renderSamuraiArmour, 0).setUnlocalizedName("samuraiHelmet");
		samuraiChestplate = new CustomColoredArmor(Config.ITEM_ID.samuraiChestplate, samuraiArmorMaterial, renderSamuraiArmour, 1).setUnlocalizedName("samuraiChestplate");
		samuraiLegs = new CustomColoredArmor(Config.ITEM_ID.samuraiLegs, samuraiArmorMaterial, renderSamuraiArmour, 2).setUnlocalizedName("samuraiLegs");
		samuraiBoots = new CustomColoredArmor(Config.ITEM_ID.samuraiBoots, samuraiArmorMaterial, renderSamuraiArmour, 3).setUnlocalizedName("samuraiBoots");

		cropRye = new BaseItem(Config.ITEM_ID.cropRye).setUnlocalizedName("cropRye");
		seedRye = new BaseSeed(Config.ITEM_ID.seedRye, Config.BLOCK_ID.ryeCrop).setUnlocalizedName("seedRye");
		seedRice = new BaseSeed(Config.ITEM_ID.seedRice, Config.BLOCK_ID.riceCrop).setUnlocalizedName("rice");
		seedBlackRice = new BaseSeed(Config.ITEM_ID.seedBlackRice, Config.BLOCK_ID.blackriceCrop).setUnlocalizedName("blackrice");
		BaseFood.addFoodStats("cherry", 0, 2);
		BaseFood.addFoodStats("goldenCherry", 3, 5, EnumRarity.rare);
		BaseFood.addFoodStats("goldenCherry", 3, 5, EnumRarity.epic, new PotionEffect(Potion.regeneration.id, 600, 3));
		
		basefood = new BaseFood(Config.ITEM_ID.basefood).setUnlocalizedName("basefood");
		woodDagger = new CustomSword(Config.ITEM_ID.woodDagger, EnumToolMaterial.WOOD, 0.5f).setUnlocalizedName("woodDagger");
		stoneDagger = new CustomSword(Config.ITEM_ID.stoneDagger, EnumToolMaterial.STONE, 0.5f).setUnlocalizedName("stoneDagger");
		ironDagger = new CustomSword(Config.ITEM_ID.ironDagger, EnumToolMaterial.IRON, 0.5f).setUnlocalizedName("ironDagger");
		goldDagger = new CustomSword(Config.ITEM_ID.goldDagger, EnumToolMaterial.GOLD, 0.5f).setUnlocalizedName("goldDagger");
		diamondDagger = new CustomSword(Config.ITEM_ID.diamondDagger, EnumToolMaterial.EMERALD, 0.5f).setUnlocalizedName("diamondDagger");
		copperDagger = new CustomSword(Config.ITEM_ID.copperDagger, copperToolMaterial, 0.5f).setUnlocalizedName("copperDagger");
		mythrilDagger = new CustomSword(Config.ITEM_ID.mythrilDagger, mythrilToolMaterial, 0.5f).setUnlocalizedName("mythrilDagger");
		
		
	}

	public static void posBlockInit() {

	}

	public static void setToolClass() {
		MinecraftForge.setToolClass(copperPickaxe, "pickaxe", 1);
		MinecraftForge.setToolClass(copperShovel, "shovel", 1);
		MinecraftForge.setToolClass(copperAxe, "axe", 1);
		MinecraftForge.setToolClass(mythrilPickaxe, "pickaxe", 3);
		MinecraftForge.setToolClass(mythrilShovel, "shovel", 3);
		MinecraftForge.setToolClass(mythrilAxe, "axe", 3);

	}
}
