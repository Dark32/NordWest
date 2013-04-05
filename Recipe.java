package mods.mod_nw;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipe {
	public static void init() {
		/** Форменные рецепты **/
		basePlankRecipe(NWBlock.sakuraPlank);
		addRecipe(new ItemStack(NWBlock.blockmithri, 1), new Object[] { "111", "111", "111", '1', NordWest.mingotItem });
		addRecipe(new ItemStack(NWBlock.coperblock, 1), new Object[] { "111", "111", "111", '1', NordWest.cingotItem });
		/** безформенные рецепты **/
		GameRegistry.addShapelessRecipe(new ItemStack(Item.expBottle, 1), NordWest.lexpiItem, Item.glassBottle);
		GameRegistry.addShapelessRecipe(new ItemStack(NordWest.cingotItem, 9), new ItemStack(NWBlock.coperblock));
		GameRegistry.addShapelessRecipe(new ItemStack(NordWest.mingotItem, 9), new ItemStack(NWBlock.blockmithri));
		for (int i = 0; i < 4; i++) {
			GameRegistry.addShapelessRecipe(new ItemStack(NWBlock.sakuraPlank, 4, i), new ItemStack(
					NWBlock.dsakuraWood, 1, i));

		}

	}

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
		addRecipe(new ItemStack(Block.woodenButton, 1), new Object[] { "#", '#', plank });
		addRecipe(new ItemStack(Block.pressurePlatePlanks, 1), new Object[] { "##", '#', plank });
		addRecipe(new ItemStack(Block.jukebox, 1), new Object[] { "###", "#X#", "###", '#', plank, 'X', Item.diamond });
		addRecipe(new ItemStack(Block.music, 1), new Object[] { "###", "#X#", "###", '#', plank, 'X', Item.redstone });
		addRecipe(new ItemStack(Block.bookShelf, 1), new Object[] { "###", "XXX", "###", '#', plank, 'X', Item.book });
		addRecipe(new ItemStack(Block.chest), new Object[] { "###", "# #", "###", '#', plank });
		addRecipe(new ItemStack(Item.stick, 4), new Object[] { "#", "#", '#', plank });
	}

	private static void addRecipe(ItemStack output, Object... params) {
		GameRegistry.addRecipe(output, params);
	}
}
