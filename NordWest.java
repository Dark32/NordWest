package mods.mod_nw;

import java.util.logging.Level;

import mods.mod_nw.Block.*;
import mods.mod_nw.Config.BLOCK_ID;
import mods.mod_nw.Config.ITEM_ID;
import mods.mod_nw.Item.*;
import mods.mod_nw.WorldGen.OreWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
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

	public static Item lexpiItem;
	public static Item mingotItem;
	public static Item cingotItem;

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		cfg = new Config(event.getSuggestedConfigurationFile());
		proxy.registerRenderers();
		/** Item **/
		lexpiItem = new BaseItem(Config.ITEM_ID.lexpi_id).setUnlocalizedName("lexpi");
		mingotItem = new BaseItem(Config.ITEM_ID.mingot_id).setUnlocalizedName("mingot");
		cingotItem = new BaseItem(Config.ITEM_ID.cingot_id).setMaxStackSize(64).setUnlocalizedName("cingot");
		/** Block **/

		NWBlock.init();

		
	}

	// LanguageRegistry language = LanguageRegistry.instance();

	@Init
	public void load(FMLInitializationEvent event) {
		proxy.registerEvent();
		/** безформенные рецепты **/

		GameRegistry.addShapelessRecipe(new ItemStack(Item.expBottle, 1), NordWest.lexpiItem, Item.glassBottle);
		GameRegistry.addShapelessRecipe(new ItemStack(cingotItem, 9), new ItemStack(NWBlock.coperblock));
		GameRegistry.addShapelessRecipe(new ItemStack(mingotItem, 9), new ItemStack(NWBlock.blockmithri));
		/** Форменные рецепты **/
		GameRegistry.addRecipe(new ItemStack(NWBlock.blockmithri, 1), new Object[] { "111", "111", "111", '1',
				NordWest.mingotItem });
		GameRegistry.addRecipe(new ItemStack(NWBlock.coperblock, 1), new Object[] { "111", "111", "111", '1',
				NordWest.cingotItem });

		/** Рецепты печки **/
		GameRegistry.addSmelting(NWBlock.coperore.blockID, new ItemStack(cingotItem), 0.2f);
		GameRegistry.addSmelting(NWBlock.mithrilore.blockID, new ItemStack(mingotItem), 0.2f);
		/** Генераторы **/
		// GameRegistry.registerWorldGenerator(new OreWorldGenerator());
	}

	private Item MetadataBlockItem(int i, Block sakuralog2, String[] wood) {
		// TODO Auto-generated method stub
		return null;
	}

	public static final String LanguageDirectory = "/mods/mod_nw/lang/";

	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		// MinecraftForge.EVENT_BUS.register(new BonemealHandler());
		// String[] wood = new String[] {"dark","pink","yellow","gray"};
		// Item.itemsList[sakuralog.blockID] = new
		// MetadataBlockItem(sakuralog.blockID - 256,sakuralog,4);

		for (String localizationName : cfg.lang) {
			LanguageRegistry.instance().loadLocalization(LanguageDirectory + localizationName + ".xml",
					localizationName, true);
		}

	}

}