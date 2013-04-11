package mods.nordwest.common;

import java.util.logging.Level;
import net.minecraftforge.common.EnumHelper;
import mods.nordwest.blocks.*;
import mods.nordwest.common.Config.BLOCK_ID;
import mods.nordwest.common.Config.ITEM_ID;
import mods.nordwest.generators.OreWorldGenerator;
import mods.nordwest.items.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
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

@Mod(modid = "NordWest", name = "Mod for mcnw.ru", version = "1.0.0")
// @NetworkMod(channels = { "NordWest" }, clientSideRequired = true,
// serverSideRequired = false, packetHandler = PacketHandler.class)
public class NordWest {
	@Instance("nordwest")
	public static NordWest instance;
	@SidedProxy(clientSide = "mods.nordwest.client.ClientProxy", serverSide = "mods.nordwest.common.CommonProxy")
	public static CommonProxy proxy;
	public static CreativeTabs tabNord = new CreativeTabs("tabNord") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Item.eyeOfEnder, 1, 0);
		}
	};
	public static Config cfg = null;

	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		cfg = new Config(event.getSuggestedConfigurationFile());
		proxy.registerRenderers();
		/** Renders **/
		CustomItems.render();
		/** Item **/
		CustomItems.init();
		/** Block **/
		CustomBlocks.init();
		Recipes.init();

	}

	// LanguageRegistry language = LanguageRegistry.instance();

	@Init
	public void load(FMLInitializationEvent event) {
		proxy.registerEvent();

		/** Рецепты печки **/
		GameRegistry.addSmelting(CustomBlocks.copperOre.blockID, new ItemStack(CustomItems.copperIngotItem), 0.2f);
		GameRegistry.addSmelting(CustomBlocks.mythrilOre.blockID, new ItemStack(CustomItems.mythrilIngotItem), 0.2f);
		GameRegistry.addSmelting(CustomBlocks.customTreeWood.blockID, new ItemStack(Item.coal, 1, 1), 0.2f);
		/** Генераторы **/
		GameRegistry.registerWorldGenerator(new OreWorldGenerator());
	}

	public static final String LanguageDirectory = "/mods/nordwest/lang/";

	@PostInit
	public void postInit(FMLPostInitializationEvent event) {

	}

}
