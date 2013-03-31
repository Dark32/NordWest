package mods.mod_nw;

import java.util.logging.Level;

import mods.mod_nw.Block.*;
import mods.mod_nw.Config.BLOCK_ID;
import mods.mod_nw.Config.ITEM_ID;
import mods.mod_nw.Item.BaseItem;
import mods.mod_nw.WorldGen.OreWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "NordWest", name = "mod for mcnw.ru", version = "1.0.0")
// @NetworkMod(channels = { "NordWest" }, clientSideRequired = true,
// serverSideRequired = false, packetHandler = PacketHandler.class)
public class NordWest {
	@Instance("mod_nw")
	public static NordWest instance;
	@SidedProxy(clientSide = "mods.mod_nw.client.ClientProxy", serverSide = "mods.mod_nw.CommonProxy")
	public static CommonProxy proxy;
	public static CreativeTabs tabNord = new CreativeTabs("tabNord") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Item.eyeOfEnder, 1, 0);
		}
	};
	public static Config cfg = null;
	public static Block lexpo;
	public static Block ore0;
	public static Block ore1;
	public static Block ore2;
	public static Block ore3;
	public static Block ore4;
	public static Block coperore;
	public static Block coperblock;
	public static Block mithrilore;

	public static Item lexpiItem;
	public static Item mingotItem;
	public static Item cingotItem;
	public static Block blockmithri;

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		cfg = new Config(event.getSuggestedConfigurationFile());
	}

//	LanguageRegistry language = LanguageRegistry.instance();

	@Init
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
		/** Item **/
		lexpiItem = new BaseItem(Config.ITEM_ID.lexpi_id).setUnlocalizedName("lexpi");
		mingotItem = new BaseItem(Config.ITEM_ID.mingot_id).setUnlocalizedName("mingot");
		cingotItem = new BaseItem(Config.ITEM_ID.cingot_id).setMaxStackSize(64).setUnlocalizedName("cingot");
		/** Block **/
		lexpo = new BaseOre(Config.BLOCK_ID.lexpo_id, Material.rock, lexpiItem.itemID, 5).setHardness(3F).setResistance(5F)
				.setUnlocalizedName("lexpo");
		GameRegistry.registerBlock(lexpo, "lexpo");


		ore0 = new BlockStone(Config.BLOCK_ID.ore0_id).setHardness(1.5F).setResistance(10.0F)
				.setStepSound(Block.soundStoneFootstep).setUnlocalizedName("stone");
		ore1 = new BlockStone(Config.BLOCK_ID.ore1_id).setHardness(1.5F).setResistance(10.0F)
				.setStepSound(Block.soundStoneFootstep).setUnlocalizedName("stone");
		ore2 = new BlockStone(Config.BLOCK_ID.ore2_id).setHardness(1.5F).setResistance(10.0F)
				.setStepSound(Block.soundStoneFootstep).setUnlocalizedName("stone");
		ore3 = new BlockStone(Config.BLOCK_ID.ore3_id).setHardness(1.5F).setResistance(10.0F)
				.setStepSound(Block.soundStoneFootstep).setUnlocalizedName("stone");
		ore4 = new BlockStone(Config.BLOCK_ID.ore4_id).setHardness(1.5F).setResistance(10.0F)
				.setStepSound(Block.soundStoneFootstep).setUnlocalizedName("stone");
		GameRegistry.registerBlock(ore0, "ore0");
		GameRegistry.registerBlock(ore1, "ore1");
		GameRegistry.registerBlock(ore2, "ore2");
		GameRegistry.registerBlock(ore3, "ore3");
		GameRegistry.registerBlock(ore4, "ore4");

		coperore = new BaseBlock(Config.BLOCK_ID.coper_ore_id, Material.rock).setHardness(3F).setResistance(5F)
				.setUnlocalizedName("coperore");
		GameRegistry.registerBlock(coperore, "coperore");
		coperblock = new BaseBlock(Config.BLOCK_ID.coperblock_id, Material.rock).setHardness(3F).setResistance(5F)
				.setUnlocalizedName("coperblock");
		GameRegistry.registerBlock(coperblock, "coperblock");

		mithrilore = new BaseBlock(Config.BLOCK_ID.mithrilore_id, Material.rock).setHardness(3F).setResistance(5F)
				.setUnlocalizedName("mithrilore");
		GameRegistry.registerBlock(mithrilore, "mithrilore");

		blockmithri = new BaseBlock(Config.BLOCK_ID.blockmithri_id, Material.rock).setHardness(3F).setResistance(5F)
				.setUnlocalizedName("blockmithri");
		GameRegistry.registerBlock(blockmithri, "blockmithri");
		/** безформенные рецепты **/

		GameRegistry.addShapelessRecipe(new ItemStack(Item.expBottle, 1), NordWest.lexpiItem, Item.glassBottle);
		GameRegistry.addShapelessRecipe(new ItemStack(cingotItem, 9), new ItemStack(coperblock));
		GameRegistry.addShapelessRecipe(new ItemStack(mingotItem, 9), new ItemStack(blockmithri));
		/** Форменные рецепты **/
		GameRegistry.addRecipe(new ItemStack(blockmithri, 1), new Object[] { "111", "111", "111", '1',
				NordWest.mingotItem });
		GameRegistry.addRecipe(new ItemStack(coperblock, 1), new Object[] { "111", "111", "111", '1',
				NordWest.cingotItem });
		/** Рецепты печки **/
		GameRegistry.addSmelting(coperore.blockID, new ItemStack(cingotItem), 0.2f);
		GameRegistry.addSmelting(mithrilore.blockID, new ItemStack(mingotItem), 0.2f);
		/** Генераторы **/
		//GameRegistry.registerWorldGenerator(new OreWorldGenerator());
	}
	public static final String LanguageDirectory = "/mods/mod_nw/lang/";
	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		System.out.printf(cingotItem.getUnlocalizedName());
		for (String localizationName : cfg.lang) {
            LanguageRegistry.instance().loadLocalization(LanguageDirectory + localizationName +".xml",localizationName, true);
        }
	}

}
