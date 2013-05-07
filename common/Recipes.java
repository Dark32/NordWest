package mods.nordwest.common;

import java.util.ArrayList;
import java.util.HashMap;

import mods.nordwest.utils.Dictionary;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.RecipesArmorDyes;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {
	public static void init() {
		/** Shaped recipes **/
		basePlankRecipe(CustomBlocks.customTreePlank);
		GameRegistry.addRecipe(new RecipesCustomArmorDyes());
		baseToolRecipe(Dictionary.ingotCopper, CustomItems.copperSword, CustomItems.copperPickaxe, CustomItems.copperShovel, CustomItems.copperAxe, CustomItems.copperHoe);
		baseToolRecipe(Dictionary.ingotMythril, CustomItems.mythrilSword, CustomItems.mythrilPickaxe, CustomItems.mythrilShovel, CustomItems.mythrilAxe, CustomItems.mythrilHoe);
		baseToolRecipe(Dictionary.woodPlank, Item.swordWood, Item.pickaxeWood, Item.shovelWood, Item.axeWood, Item.hoeWood);

		baseArmorRecipe(Dictionary.ingotCopper, CustomItems.copperHelmet, CustomItems.copperChestplate, CustomItems.copperLegs, CustomItems.copperBoots);
		baseArmorRecipe(Dictionary.ingotMythril, CustomItems.mythrilHelmet, CustomItems.mythrilChestplate, CustomItems.mythrilLegs, CustomItems.mythrilBoots);
		
		baseDaggerRecipe(Dictionary.woodPlank, CustomItems.woodDagger);
		baseDaggerRecipe(Block.planks, CustomItems.woodDagger);
		baseDaggerRecipe(Block.cobblestone, CustomItems.stoneDagger);
		baseDaggerRecipe(Item.ingotIron, CustomItems.ironDagger);
		baseDaggerRecipe(Item.ingotGold, CustomItems.goldDagger);
		baseDaggerRecipe(Item.diamond, CustomItems.diamondDagger);
		baseDaggerRecipe(Dictionary.ingotCopper, CustomItems.copperDagger);
		baseDaggerRecipe(Dictionary.ingotMythril, CustomItems.mythrilDagger);
		
		addRecipe(new ItemStack(CustomBlocks.mythrilBlock, 1), new Object[] { "###", "###", "###", '#', CustomItems.mythrilIngotItem });
		addRecipe(new ItemStack(CustomBlocks.copperBlock, 1), new Object[] { "###", "###", "###", '#', CustomItems.copperIngotItem });
		addRecipe(new ItemStack(CustomBlocks.blockhome, 1), new Object[] { "x#x", "#Z#", "x#x", 'x', Item.paper, '#', Item.enderPearl, 'Z', CustomItems.homescroll });
		addRecipe(new ItemStack(CustomItems.homescroll, 4, 0), new Object[] { "x#x", "#Z#", "x#x", 'x', Item.paper, '#', Item.enderPearl });
		addRecipe(new ItemStack(CustomItems.homescroll, 1, 1), new Object[] { "xxx", "xzx", "xxx", 'x', new ItemStack(CustomItems.homescroll, 1, 0), 'z', Item.eyeOfEnder });
		for (int i = 0; i < 8; i++) {
			addRecipe(new ItemStack(CustomBlocks.blockWoolHalf1, 6, i), new Object[] { "xxx", 'x', new ItemStack(Block.cloth, 1, i) });
			addRecipe(new ItemStack(CustomBlocks.blockWoolHalf2, 6, i), new Object[] { "xxx", 'x', new ItemStack(Block.cloth, 1, i + 8) });

		}
		addRecipe(new ItemStack(CustomBlocks.redBlock, 1, 0), new Object[] { "xxx", "xzx", "xxx", 'x', new ItemStack(Item.redstone, 1, 0) });
		addRecipe(new ItemStack(CustomBlocks.slimeBlock, 1), new Object[] { "###", "###", "###", '#', Item.slimeBall });
		addRecipe(new ItemStack(CustomBlocks.candle, 1), new Object[] { "#X#", "#X#", "#X#", '#', CustomItems.wax, 'X', Item.silk });

		/** Shapeless recipes **/
		GameRegistry.addShapelessRecipe(new ItemStack(Item.expBottle, 1), CustomItems.expaniteItem, Item.glassBottle);
		GameRegistry.addShapelessRecipe(new ItemStack(CustomItems.copperIngotItem, 9), new ItemStack(CustomBlocks.copperBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(CustomItems.mythrilIngotItem, 9), new ItemStack(CustomBlocks.mythrilBlock));
		for (int i = 0; i < 4; i++) {
			GameRegistry.addShapelessRecipe(new ItemStack(CustomBlocks.customTreePlank, 4, i), new ItemStack(CustomBlocks.customTreeWood, 1, i));
			GameRegistry.addShapelessRecipe(new ItemStack(CustomBlocks.magicTreePlank, 4, i), new ItemStack(CustomBlocks.magicTreeWood, 1, i));
		}
		for (int i = 0, a = 15; i < 16; i++, a--) {
			GameRegistry.addShapelessRecipe(new ItemStack(CustomBlocks.candle, 1, i), new ItemStack(CustomBlocks.candle, 1), new ItemStack(Item.dyePowder, 1, a));
			GameRegistry.addShapelessRecipe(new ItemStack(CustomBlocks.candle, 1), new ItemStack(CustomBlocks.candle, 1, i), new ItemStack(Item.dyePowder, 1, 15));
		}
		GameRegistry.addShapelessRecipe(new ItemStack(Item.redstone, 8), new ItemStack(CustomBlocks.redBlock, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.redstone, 8), new ItemStack(CustomBlocks.redBlock, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.dyePowder, 9, 4), new ItemStack(CustomBlocks.redBlock, 1, 2));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.slimeBall, 9), CustomBlocks.slimeBlock);
		customStoneRecipe(CustomBlocks.customStone1);
		customStoneRecipe(CustomBlocks.customStone2);
		customStoneRecipe(CustomBlocks.customStone3);
		customStoneRecipe(CustomBlocks.customStone4);
		customStoneRecipe(CustomBlocks.customStone5);
		customStoneRecipe(CustomBlocks.customStone6);
		customStoneRecipe(CustomBlocks.customStone7);
		customStoneRecipe(CustomBlocks.customStone8);
		addRecipe(new ItemStack(CustomBlocks.customSlabHalf, 6, 0), new Object[] { "XXX", 'X', new ItemStack(CustomBlocks.customStone1, 1, 3) });
		addRecipe(new ItemStack(CustomBlocks.customSlabHalf, 6, 1), new Object[] { "XXX", 'X', new ItemStack(CustomBlocks.customStone2, 1, 3) });
		addRecipe(new ItemStack(CustomBlocks.customSlabHalf, 6, 2), new Object[] { "XXX", 'X', new ItemStack(CustomBlocks.customStone3, 1, 3) });
		addRecipe(new ItemStack(CustomBlocks.customSlabHalf, 6, 3), new Object[] { "XXX", 'X', new ItemStack(CustomBlocks.customStone4, 1, 3) });
		addRecipe(new ItemStack(CustomBlocks.customSlabHalf, 6, 4), new Object[] { "XXX", 'X', new ItemStack(CustomBlocks.customStone5, 1, 3) });
		addRecipe(new ItemStack(CustomBlocks.customSlabHalf, 6, 5), new Object[] { "XXX", 'X', new ItemStack(CustomBlocks.customStone6, 1, 3) });
		addRecipe(new ItemStack(CustomBlocks.customSlabHalf, 6, 6), new Object[] { "XXX", 'X', new ItemStack(CustomBlocks.customStone7, 1, 3) });
		addRecipe(new ItemStack(CustomBlocks.customSlabHalf, 6, 7), new Object[] { "XXX", 'X', new ItemStack(CustomBlocks.customStone8, 1, 3) });

		addRecipe(new ItemStack(CustomBlocks.customSlabHalf2, 6, 0), new Object[] { "XXX", 'X', new ItemStack(CustomBlocks.customStone1, 1, 5) });
		addRecipe(new ItemStack(CustomBlocks.customSlabHalf2, 6, 1), new Object[] { "XXX", 'X', new ItemStack(CustomBlocks.customStone2, 1, 5) });
		addRecipe(new ItemStack(CustomBlocks.customSlabHalf2, 6, 2), new Object[] { "XXX", 'X', new ItemStack(CustomBlocks.customStone3, 1, 5) });
		addRecipe(new ItemStack(CustomBlocks.customSlabHalf2, 6, 3), new Object[] { "XXX", 'X', new ItemStack(CustomBlocks.customStone4, 1, 5) });
		addRecipe(new ItemStack(CustomBlocks.customSlabHalf2, 6, 4), new Object[] { "XXX", 'X', new ItemStack(CustomBlocks.customStone5, 1, 5) });
		addRecipe(new ItemStack(CustomBlocks.customSlabHalf2, 6, 5), new Object[] { "XXX", 'X', new ItemStack(CustomBlocks.customStone6, 1, 5) });
		addRecipe(new ItemStack(CustomBlocks.customSlabHalf2, 6, 6), new Object[] { "XXX", 'X', new ItemStack(CustomBlocks.customStone7, 1, 5) });
		addRecipe(new ItemStack(CustomBlocks.customSlabHalf2, 6, 7), new Object[] { "XXX", 'X', new ItemStack(CustomBlocks.customStone8, 1, 5) });

		addRecipe(new ItemStack(CustomBlocks.customSlabHalf3, 6, 0), new Object[] { "XXX", 'X', new ItemStack(CustomBlocks.customStone1, 1, 8) });
		addRecipe(new ItemStack(CustomBlocks.customSlabHalf3, 6, 1), new Object[] { "XXX", 'X', new ItemStack(CustomBlocks.customStone2, 1, 8) });
		addRecipe(new ItemStack(CustomBlocks.customSlabHalf3, 6, 2), new Object[] { "XXX", 'X', new ItemStack(CustomBlocks.customStone3, 1, 8) });
		addRecipe(new ItemStack(CustomBlocks.customSlabHalf3, 6, 3), new Object[] { "XXX", 'X', new ItemStack(CustomBlocks.customStone4, 1, 8) });
		addRecipe(new ItemStack(CustomBlocks.customSlabHalf3, 6, 4), new Object[] { "XXX", 'X', new ItemStack(CustomBlocks.customStone5, 1, 8) });
		addRecipe(new ItemStack(CustomBlocks.customSlabHalf3, 6, 5), new Object[] { "XXX", 'X', new ItemStack(CustomBlocks.customStone6, 1, 8) });
		addRecipe(new ItemStack(CustomBlocks.customSlabHalf3, 6, 6), new Object[] { "XXX", 'X', new ItemStack(CustomBlocks.customStone7, 1, 8) });
		addRecipe(new ItemStack(CustomBlocks.customSlabHalf3, 6, 7), new Object[] { "XXX", 'X', new ItemStack(CustomBlocks.customStone8, 1, 8) });

		addRecipe(new ItemStack(CustomBlocks.customStone1, 1, 1), new Object[] { "XXX", "XZX", "XXX", 'X', Item.stick, 'Z', new ItemStack(Block.cobblestone) });
		addRecipe(new ItemStack(CustomBlocks.customStone7, 1, 1), new Object[] { "XXX", "XZX", "XXX", 'X', Item.stick, 'Z', new ItemStack(Block.cobblestoneMossy) });
		addRecipe(new ItemStack(CustomBlocks.customStone8, 1, 1), new Object[] { "XXX", "XZX", "XXX", 'X', Item.stick, 'Z', new ItemStack(Block.obsidian) });

	}

	private static void basePlankRecipe(Block plank) {

		addRecipe(new ItemStack(Item.bed, 1), new Object[] { "###", "XXX", '#', Block.cloth, 'X', plank });
		addRecipe(new ItemStack(Block.fenceGate, 1), new Object[] { "#W#", "#W#", '#', Item.stick, 'W', plank });
		addRecipe(new ItemStack(Item.doorWood, 1), new Object[] { "##", "##", "##", '#', plank });
		addRecipe(new ItemStack(Block.trapdoor, 2), new Object[] { "###", "###", '#', plank });
		addRecipe(new ItemStack(Item.sign, 3), new Object[] { "###", "###", " X ", '#', plank, 'X', Item.stick });
		addRecipe(new ItemStack(Item.bowlEmpty, 4), new Object[] { "# #", " # ", '#', plank });
		addRecipe(new ItemStack(Item.boat, 1), new Object[] { "# #", "###", '#', plank });
		addRecipe(new ItemStack(Block.tripWireSource, 2), new Object[] { "I", "S", "#", '#', plank, 'S', Item.stick, 'I', Item.ingotIron });
		addRecipe(new ItemStack(Block.workbench, 1), new Object[] { "##", "##", '#', plank });
		addRecipe(new ItemStack(Block.woodenButton, 1), new Object[] { "#", '#', plank });
		addRecipe(new ItemStack(Block.pressurePlatePlanks, 1), new Object[] { "##", '#', plank });
		addRecipe(new ItemStack(Block.jukebox, 1), new Object[] { "###", "#X#", "###", '#', plank, 'X', Item.diamond });
		addRecipe(new ItemStack(Block.music, 1), new Object[] { "###", "#X#", "###", '#', plank, 'X', Item.redstone });
		addRecipe(new ItemStack(Block.bookShelf, 1), new Object[] { "###", "XXX", "###", '#', plank, 'X', Item.book });
		addRecipe(new ItemStack(Block.chest), new Object[] { "###", "# #", "###", '#', plank });
		addRecipe(new ItemStack(Item.stick, 4), new Object[] { "#", "#", '#', plank });
	}

	private static void baseToolRecipe(Object mat, Item sword, Item pickaxe, Item shovel, Item axe, Item hoe) {
		Object material = null;
		mat = getAnyCraftablyMateryal(mat);
		//if (material instanceof Item || material instanceof Block || material instanceof Integer || material instanceof ItemStack) {
		if (mat instanceof ArrayList<?>) {
			material = (ArrayList<?>) mat;
			for (ItemStack _mat : (ArrayList<ItemStack>) material) {
				baseToolRecipe(_mat, sword, pickaxe, shovel, axe, hoe);
			}
			return;
		} else {
			material = mat;
		}
		if (material != null) {

			addRecipe(new ItemStack(sword, 1), new Object[] { "X", "X", "#", '#', Item.stick, 'X', material });
			addRecipe(new ItemStack(pickaxe, 1), new Object[] { "XXX", " # ", " # ", '#', Item.stick, 'X', material });
			addRecipe(new ItemStack(shovel, 1), new Object[] { "X", "#", "#", '#', Item.stick, 'X', material });
			addRecipe(new ItemStack(axe, 1), new Object[] { "XX", "X#", " #", '#', Item.stick, 'X', material });
			addRecipe(new ItemStack(hoe, 1), new Object[] { "XX", " #", " #", '#', Item.stick, 'X', material });
		}
	}

	private static void baseDaggerRecipe(Object mat, Item dagger) {
		Object material = null;
		mat = getAnyCraftablyMateryal(mat);

		if (mat instanceof ArrayList<?>) {
			material = (ArrayList<?>) mat;
			for (ItemStack _mat : (ArrayList<ItemStack>) material) {
				baseDaggerRecipe(_mat, dagger);
			}
			return;
		} else {
			material = mat;
		}
		if (material != null) {
			addRecipe(new ItemStack(dagger, 1), new Object[] { "X", "#", '#', Item.stick, 'X', mat });
		}

	}

	private static void customStoneRecipe(Block material) {
		addSmelting(new ItemStack(material, 1, 1), new ItemStack(material, 1, 0), 0.1f);
		addSmelting(new ItemStack(material, 2, 1), new ItemStack(material, 1, 0), 0.1f);
		addRecipe(new ItemStack(material, 1, 2), new Object[] { "XXX", "XZX", "XXX", 'X', Item.stick, 'Z', new ItemStack(material, 1, 1) });
		addRecipe(new ItemStack(material, 4, 3), new Object[] { "XX", "XX", 'X', new ItemStack(material, 1, 0) });
		addRecipe(new ItemStack(material, 4, 5), new Object[] { "XX", "XX", 'X', new ItemStack(material, 1, 3) });
		addRecipe(new ItemStack(material, 4, 8), new Object[] { "XX", "XX", 'X', new ItemStack(material, 1, 5) });
	}

	private static void baseArmorRecipe(Object mat, Item helmet, Item chestplate, Item legs, Item boots) {
		Object material = null;
		mat = getAnyCraftablyMateryal(mat);
		if (mat instanceof ArrayList<?>) {
			material = (ArrayList<?>) mat;
			for (ItemStack _mat : (ArrayList<ItemStack>) material) {
				baseArmorRecipe(_mat, helmet, chestplate, legs, boots);
			}
			return;
		} else {
			material = mat;
		}
		if (material != null) {

			addRecipe(new ItemStack(helmet, 1), new Object[] { "XXX", "X X", 'X', material });
			addRecipe(new ItemStack(chestplate, 1), new Object[] { "X X", "XXX", "XXX", 'X', material });
			addRecipe(new ItemStack(legs, 1), new Object[] { "XXX", "X X", "X X", 'X', material });
			addRecipe(new ItemStack(boots, 1), new Object[] { "X X", "X X", 'X', material });
		}
	}

	private static void addRecipe(ItemStack output, Object... params) {
		GameRegistry.addRecipe(output, params);
	}

	private static void addSmelting(ItemStack input, ItemStack output, Float exp) {
		FurnaceRecipes.smelting().addSmelting(input.itemID, input.getItemDamage(), output, exp);

	}

	/**
	 * Метод позваляет добавлять рецепты экстракторы
	 * @param input входной стак
	 * @param output выходной стак
	 * @param chance шанс бонуса
	 * @param bonus бонусный стак
	 * @param exp опыт
	 */
	private static void addExtracting(ItemStack input, ItemStack output, int chance, ItemStack bonus, Float exp) {
		ExtractorRecipes.extracting().addExtracting(input.itemID, input.getItemDamage(), output, chance, bonus, exp);
	}

	/**
	 * Крайне не безопасный метод получения Вещи, блока, Стака или нескольких видов стаков по за ранее не определённому параметру
	 * @param mat Число, Блок, стак, Вещь, лист стаков или строка, остальные типы вызовут проблемы
	 * @return Блок, Вещь, стак, лист стаков
	 */
	private static Object getAnyCraftablyMateryal(Object mat) {
		boolean debug = false;
		if (debug)
			System.out.print("Try get  " + mat.toString() + "\n");
		Object material = null;
		if (mat instanceof Item) {
			return (Item) mat;
		} else if (mat instanceof Block) {
			return (Block) mat;
		}
		if (mat instanceof Integer) {
			/** Прошу, не передавайти числа в чистом виде, я не уверен насчёт этой кадабры **/
			if ((Integer) mat < 4096 && Block.blocksList[(Integer) mat] != null) {
				return Block.blocksList[(Integer) mat];
			} else {
				return Item.itemsList[(Integer) mat];
			}
		} else if (mat instanceof String) {
			return (ArrayList<ItemStack>) (OreDictionary.getOres((String) mat));
		} else if (mat instanceof ItemStack) {
			return (ItemStack) mat;
		} else if (mat instanceof ArrayList<?>) {
			return (ArrayList<ItemStack>) mat;
		}
		if (mat == null) {
			if (debug)
				System.out.print("Fail get: null  \n");
		} else {
			if (debug)
				System.out.print("Got  " + mat.toString() + ", but i unknow it\n");
		}
		return material;
	}
}
