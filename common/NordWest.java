package mods.nordwest.common;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.minecraftforge.common.EnumHelper;
import mods.nordwest.common.GuiHandler;
import mods.nordwest.blocks.*;
import mods.nordwest.common.Config.BLOCK_ID;
import mods.nordwest.common.Config.ITEM_ID;
import mods.nordwest.generators.CustomTreeWorldGenerator;
import mods.nordwest.generators.OreWorldGenerator;
import mods.nordwest.items.*;
import mods.nordwest.utils.Dictionary;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.oredict.OreDictionary;
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
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "NordWest", name = "Minecraft NordWest", version = "0.1.a")
@NetworkMod(channels = { "NordWest" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class NordWest {

	public static Logger logger = Logger.getLogger("Minecraft");

	@Instance("NordWest")
	public static NordWest instance;

	@SidedProxy(clientSide = "mods.nordwest.client.ClientProxy", serverSide = "mods.nordwest.common.CommonProxy")
	public static CommonProxy proxy;
	public static CreativeTabs tabNord = new CreativeTabs("tabNord") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Item.eyeOfEnder, 1, 0);
		}
	};
	public static Config cfg = null;
	public static Random rand = new Random();

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		cfg = new Config(event.getSuggestedConfigurationFile());
		proxy.registerRenderers();
		/** Renders **/
		CustomItems.render();
		/** Item **/
		CustomItems.init();
		/** ClassTool **/
		CustomItems.setToolClass();
		/** Block **/
		CustomBlocks.init();
		/** Post block item init **/
		CustomItems.posBlockInit();
		CustomBlocks.posItemBlockInit();
		/** Harvest Level for block **/
		CustomBlocks.setHarvestLevel();
		/** Dictionary **/
		Dictionary.init();
		/** Recipes **/
		Recipes.init();

	}

	@Init
	public void load(FMLInitializationEvent event) {

		/** Our Proxies */
		proxy.registerEvent();

		/** Registering GUI handler */
		NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
		/** Registering Smelting Recipes **/
		GameRegistry.addSmelting(CustomBlocks.copperOre.blockID, new ItemStack(CustomItems.copperIngotItem), 0.2f);
		GameRegistry.addSmelting(CustomBlocks.mythrilOre.blockID, new ItemStack(CustomItems.mythrilIngotItem), 0.2f);
		GameRegistry.addSmelting(CustomBlocks.customTreeWood.blockID, new ItemStack(Item.coal, 1, 1), 0.2f);
		/** Registering Generators **/
		GameRegistry.registerWorldGenerator(new OreWorldGenerator());
		GameRegistry.registerWorldGenerator(new CustomTreeWorldGenerator());
		String currentVersion = "0.1.a";

		/** Console Notification */
		System.out.println("[NordWest] Loading of the mod version " + currentVersion + " is successfully completed!");

		/** Log Files Notification */
		logger.info("[NordWest] Mod version " + currentVersion + " is loaded.");
	}

	public static final String LanguageDirectory = "/mods/nordwest/lang/";

	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		/** overwrite item **/
		CustomBlocks.registerSlabItem();
	}

}
