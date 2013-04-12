package mods.nordwest.common;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {
	public static void init() {
		/** Shaped recipes **/
		basePlankRecipe(CustomBlocks.customTreePlank);
		
		baseToolRecipe(CustomBlocks.customTreePlank, Item.swordWood, Item.pickaxeWood, Item.shovelWood, Item.axeWood, Item.hoeWood);
		baseToolRecipe(CustomItems.copperIngotItem, CustomItems.copperSword, CustomItems.copperPickaxe, CustomItems.copperShovel, CustomItems.copperAxe, CustomItems.copperHoe);
		baseToolRecipe(CustomItems.mythrilIngotItem, CustomItems.mythrilSword, CustomItems.mythrilPickaxe, CustomItems.mythrilShovel, CustomItems.mythrilAxe, CustomItems.mythrilHoe);
		
		baseArmorRecipe(CustomItems.copperIngotItem, CustomItems.copperHelmet, CustomItems.copperChestplate, CustomItems.copperLegs, CustomItems.copperBoots);
		baseArmorRecipe(CustomItems.mythrilIngotItem, CustomItems.mythrilHelmet, CustomItems.mythrilChestplate, CustomItems.mythrilLegs, CustomItems.mythrilBoots);
		
		addRecipe(new ItemStack(CustomBlocks.mythrilBlock, 1), new Object[] { "###", "###", "###", '#', CustomItems.mythrilIngotItem });
		addRecipe(new ItemStack(CustomBlocks.copperBlock, 1), new Object[] { "###", "###", "###", '#', CustomItems.copperIngotItem });
		
		/** Shapeless recipes **/
		GameRegistry.addShapelessRecipe(new ItemStack(Item.expBottle, 1), CustomItems.expaniteItem, Item.glassBottle);
		GameRegistry.addShapelessRecipe(new ItemStack(CustomItems.copperIngotItem, 9), new ItemStack(CustomBlocks.copperBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(CustomItems.mythrilIngotItem, 9), new ItemStack(CustomBlocks.mythrilBlock));
		for (int i = 0; i < 4; i++) {
			GameRegistry.addShapelessRecipe(new ItemStack(CustomBlocks.customTreePlank, 4, i), new ItemStack(
					CustomBlocks.customTreeWood, 1, i));
		}
		GameRegistry.addRecipe(new ItemStack(CustomBlocks.blockhome, 1), new Object[] { "x#x", "#Z#", "x#x", 'x',
				Item.paper, '#', Item.enderPearl, 'Z', CustomItems.homescroll });
		GameRegistry.addRecipe(new ItemStack(CustomItems.homescroll, 4, 0), new Object[] { "x#x", "#Z#", "x#x", 'x',
				Item.paper, '#', Item.enderPearl });
		GameRegistry.addRecipe(new ItemStack(CustomItems.homescroll, 1, 1), new Object[] { "xxx", "xzx", "xxx", 'x',
				new ItemStack(CustomItems.homescroll, 1, 0), 'z', Item.eyeOfEnder });
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

}
