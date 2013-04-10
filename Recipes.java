package mods.mod_nw;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {
	public static void init() {
		/** Shaped recipes **/
		basePlankRecipe(NWBlock.customTreePlank);
		// woodenToolsRecipe(NWBlock.customTreePlank, Item.stick,
		// Item.swordWood, Item.pickaxeWood, Item.shovelWood,
		// Item.axeWood, Item.hoeWood);
		baseToolRecipe(NWBlock.customTreePlank, Item.swordWood, Item.pickaxeWood, Item.shovelWood, Item.axeWood,
				Item.hoeWood);
		baseToolRecipe(NWItem.cingotItem, Item.swordSteel, Item.pickaxeSteel, Item.shovelSteel, Item.axeSteel,
				Item.hoeSteel);
		baseArmorRecipe(NWItem.cingotItem, NWItem.copperHelmet, NWItem.copperChestplate, NWItem.copperLegs,
				NWItem.copperBoots);
		baseArmorRecipe(NWItem.mingotItem, NWItem.mythrilHelmet, NWItem.mythrilChestplate, NWItem.mythrilLegs,
				NWItem.mythrilBoots);
		// Example ends here! This is really easy to understand, isn't it?
		addRecipe(new ItemStack(NWBlock.blockmithri, 1), new Object[] { "###", "###", "###", '#', NWItem.mingotItem });
		addRecipe(new ItemStack(NWBlock.coperblock, 1), new Object[] { "###", "###", "###", '#', NWItem.cingotItem });
		/** Shapeless recipes **/
		GameRegistry.addShapelessRecipe(new ItemStack(Item.expBottle, 1), NWItem.lexpiItem, Item.glassBottle);
		GameRegistry.addShapelessRecipe(new ItemStack(NWItem.cingotItem, 9), new ItemStack(NWBlock.coperblock));
		GameRegistry.addShapelessRecipe(new ItemStack(NWItem.mingotItem, 9), new ItemStack(NWBlock.blockmithri));
		for (int i = 0; i < 4; i++) {
			GameRegistry.addShapelessRecipe(new ItemStack(NWBlock.customTreePlank, 4, i), new ItemStack(
					NWBlock.customTreeWood, 1, i));
		}
		GameRegistry.addRecipe(new ItemStack(NWBlock.blockhome, 1), new Object[] { "x#x", "#Z#", "x#x", 'x',
				Item.paper, '#', Item.enderPearl, 'Z', NWItem.homescroll });
		GameRegistry.addRecipe(new ItemStack(NWItem.homescroll, 4, 0), new Object[] { "x#x", "#Z#", "x#x", 'x',
				Item.paper, '#', Item.enderPearl });
		GameRegistry.addRecipe(new ItemStack(NWItem.homescroll, 1, 1), new Object[] { "xxx", "xzx", "xxx", 'x',
				new ItemStack(NWItem.homescroll, 1, 0), 'z', Item.eyeOfEnder });
	}

	/**
	 * Регестрирует базавые рецепты из дерева
	 * 
	 * @param plank - блок, который считать за доски дерева
	 * 
	 */
	private static void basePlankRecipe(Block plank) {

		addRecipe(new ItemStack(Item.bed, 1), new Object[] { "###", "XXX", '#', Block.cloth, 'X', plank });
		addRecipe(new ItemStack(Block.fenceGate, 1), new Object[] { "#W#", "#W#", '#', Item.stick, 'W', plank });
		addRecipe(new ItemStack(Item.doorWood, 1), new Object[] { "##", "##", "##", '#', plank });
		addRecipe(new ItemStack(Block.trapdoor, 2), new Object[] { "###", "###", '#', plank });
		addRecipe(new ItemStack(Item.sign, 3), new Object[] { "###", "###", " X ", '#', plank, 'X', Item.stick });
		addRecipe(new ItemStack(Item.bowlEmpty, 4), new Object[] { "# #", " # ", '#', plank });
		addRecipe(new ItemStack(Item.boat, 1), new Object[] { "# #", "###", '#', plank });
		addRecipe(new ItemStack(Block.tripWireSource, 2), new Object[] { "I", "S", "#", '#', plank, 'S', Item.stick,
				'I', Item.ingotIron });
		addRecipe(new ItemStack(Block.workbench, 1), new Object[] { "##", "##", '#', plank });
		addRecipe(new ItemStack(Block.woodenButton, 1), new Object[] { "#", '#', plank });
		addRecipe(new ItemStack(Block.pressurePlatePlanks, 1), new Object[] { "##", '#', plank });
		addRecipe(new ItemStack(Block.jukebox, 1), new Object[] { "###", "#X#", "###", '#', plank, 'X', Item.diamond });
		addRecipe(new ItemStack(Block.music, 1), new Object[] { "###", "#X#", "###", '#', plank, 'X', Item.redstone });
		addRecipe(new ItemStack(Block.bookShelf, 1), new Object[] { "###", "XXX", "###", '#', plank, 'X', Item.book });
		addRecipe(new ItemStack(Block.chest), new Object[] { "###", "# #", "###", '#', plank });
		addRecipe(new ItemStack(Item.stick, 4), new Object[] { "#", "#", '#', plank });
	}

	/**
	 * Регистрирует набор инструментов
	 * 
	 * @param material - из чего
	 * @param sword - меч
	 * @param pickaxe - кирка
	 * @param shovel - лопата
	 * @param axe - топор
	 * @param hoe - тяпка
	 */
	private static void baseToolRecipe(ItemStack material, Item sword, Item pickaxe, Item shovel, Item axe, Item hoe) {
		addRecipe(new ItemStack(sword, 1), new Object[] { "X", "X", "#", '#', Item.stick, 'X', material });
		addRecipe(new ItemStack(pickaxe, 1), new Object[] { "XXX", " # ", " # ", '#', Item.stick, 'X', material });
		addRecipe(new ItemStack(shovel, 1), new Object[] { "X", "#", "#", '#', Item.stick, 'X', material });
		addRecipe(new ItemStack(axe, 1), new Object[] { "XX", "X#", " #", '#', Item.stick, 'X', material });
		addRecipe(new ItemStack(hoe, 1), new Object[] { "XX", " #", " #", '#', Item.stick, 'X', material });
	}

	private static void baseToolRecipe(Item material, Item sword, Item pickaxe, Item shovel, Item axe, Item hoe) {
		baseToolRecipe(new ItemStack(material), sword, pickaxe, shovel, axe, hoe);
	}

	private static void baseToolRecipe(Block material, Item sword, Item pickaxe, Item shovel, Item axe, Item hoe) {
		baseToolRecipe(new ItemStack(material), sword, pickaxe, shovel, axe, hoe);
	}

	/**
	 * Регестрирует комплект брони
	 * 
	 * @param material - из чего
	 * @param helmet - шлем
	 * @param chestplate - грудь
	 * @param legs - штаны
	 * @param boots - сапоги
	 */
	private static void baseArmorRecipe(Item material, Item helmet, Item chestplate, Item legs, Item boots) {
		addRecipe(new ItemStack(helmet, 1), new Object[] { "XXX", "X X", 'X', material });
		addRecipe(new ItemStack(chestplate, 1), new Object[] { "X X", "XXX", "XXX", 'X', material });
		addRecipe(new ItemStack(legs, 1), new Object[] { "XXX", "X X", "X X", 'X', material });
		addRecipe(new ItemStack(boots, 1), new Object[] { "X X", "X X", 'X', material });
	}

	/**
	 * Будет удалено Регестрирует базавые инструменты из дополнителнього дерева
	 * 
	 * @param material - дополнительное дерево
	 * @param stick - дополнительная палочка
	 * @param sword
	 * @param pickaxe
	 * @param shovel
	 * @param axe
	 * @param hoe
	 */
	@Deprecated
	private static void woodenToolsRecipe(Block material, Item stick, Item sword, Item pickaxe, Item shovel, Item axe,
			Item hoe) {
		addRecipe(new ItemStack(sword, 1), new Object[] { "X", "X", "#", '#', stick, 'X', material });
		addRecipe(new ItemStack(pickaxe, 1), new Object[] { "XXX", " # ", " # ", '#', stick, 'X', material });
		addRecipe(new ItemStack(shovel, 1), new Object[] { "X", "#", "#", '#', stick, 'X', material });
		addRecipe(new ItemStack(axe, 1), new Object[] { "XX", "X#", " #", '#', stick, 'X', material });
		addRecipe(new ItemStack(hoe, 1), new Object[] { "XX", " #", " #", '#', stick, 'X', material });
	}

	private static void addRecipe(ItemStack output, Object... params) {
		GameRegistry.addRecipe(output, params);
	}

}
