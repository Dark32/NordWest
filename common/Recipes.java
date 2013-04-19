package mods.nordwest.common;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.RecipesArmorDyes;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {
	public static void init() {
		/** Shaped recipes **/
		basePlankRecipe(CustomBlocks.customTreePlank);
		GameRegistry.addRecipe(new RecipesCustomArmorDyes());
		baseToolRecipe(CustomBlocks.customTreePlank, Item.swordWood, Item.pickaxeWood, Item.shovelWood, Item.axeWood, Item.hoeWood);
		baseToolRecipe(CustomItems.copperIngotItem, CustomItems.copperSword, CustomItems.copperPickaxe, CustomItems.copperShovel, CustomItems.copperAxe, CustomItems.copperHoe);
		baseToolRecipe(CustomItems.mythrilIngotItem, CustomItems.mythrilSword, CustomItems.mythrilPickaxe, CustomItems.mythrilShovel, CustomItems.mythrilAxe, CustomItems.mythrilHoe);

		baseArmorRecipe(CustomItems.copperIngotItem, CustomItems.copperHelmet, CustomItems.copperChestplate, CustomItems.copperLegs, CustomItems.copperBoots);
		baseArmorRecipe(CustomItems.mythrilIngotItem, CustomItems.mythrilHelmet, CustomItems.mythrilChestplate, CustomItems.mythrilLegs, CustomItems.mythrilBoots);

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

	private static void baseToolRecipe(ItemStack material, Item sword, Item pickaxe, Item shovel, Item axe, Item hoe) {
		addRecipe(new ItemStack(sword, 1), new Object[] { "X", "X", "#", '#', Item.stick, 'X', material });
		addRecipe(new ItemStack(pickaxe, 1), new Object[] { "XXX", " # ", " # ", '#', Item.stick, 'X', material });
		addRecipe(new ItemStack(shovel, 1), new Object[] { "X", "#", "#", '#', Item.stick, 'X', material });
		addRecipe(new ItemStack(axe, 1), new Object[] { "XX", "X#", " #", '#', Item.stick, 'X', material });
		addRecipe(new ItemStack(hoe, 1), new Object[] { "XX", " #", " #", '#', Item.stick, 'X', material });
	}

	private static void customStoneRecipe(Block material) {
		addSmelting(new ItemStack(material, 1, 1), new ItemStack(material, 1, 0), 0.1f);
		addSmelting(new ItemStack(material, 2, 1), new ItemStack(material, 1, 0), 0.1f);
		addRecipe(new ItemStack(material, 1, 2), new Object[] { "XXX", "XZX", "XXX", 'X', Item.stick, 'Z', new ItemStack(material, 1, 1) });
		addRecipe(new ItemStack(material, 4, 3), new Object[] { "XX", "XX", 'X', new ItemStack(material, 1, 0) });
		addRecipe(new ItemStack(material, 4, 5), new Object[] { "XX", "XX", 'X', new ItemStack(material, 1, 3) });
		addRecipe(new ItemStack(material, 4, 8), new Object[] { "XX", "XX", 'X', new ItemStack(material, 1, 5) });
	}

	private static void baseToolRecipe(Item material, Item sword, Item pickaxe, Item shovel, Item axe, Item hoe) {
		baseToolRecipe(new ItemStack(material), sword, pickaxe, shovel, axe, hoe);
	}

	private static void baseToolRecipe(Block material, Item sword, Item pickaxe, Item shovel, Item axe, Item hoe) {
		baseToolRecipe(new ItemStack(material), sword, pickaxe, shovel, axe, hoe);
	}

	private static void baseArmorRecipe(Item material, Item helmet, Item chestplate, Item legs, Item boots) {
		addRecipe(new ItemStack(helmet, 1), new Object[] { "XXX", "X X", 'X', material });
		addRecipe(new ItemStack(chestplate, 1), new Object[] { "X X", "XXX", "XXX", 'X', material });
		addRecipe(new ItemStack(legs, 1), new Object[] { "XXX", "X X", "X X", 'X', material });
		addRecipe(new ItemStack(boots, 1), new Object[] { "X X", "X X", 'X', material });
	}

	private static void addRecipe(ItemStack output, Object... params) {
		GameRegistry.addRecipe(output, params);
	}

	private static void addSmelting(ItemStack input, ItemStack output, Float exp) {
		FurnaceRecipes.smelting().addSmelting(input.itemID, input.getItemDamage(), output, exp);

	}
}
