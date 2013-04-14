package mods.nordwest.common;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.minecraftforge.common.EnumHelper;
import mekanism.common.PacketHandler;
import mekanism.common.Version;
import mods.nordwest.blocks.*;
import mods.nordwest.common.Config.BLOCK_ID;
import mods.nordwest.common.Config.ITEM_ID;
import mods.nordwest.generators.OreWorldGenerator;
import mods.nordwest.items.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
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

@Mod(modid = "NordWest", name = "Mod for mcnw.ru", version = "0.0.1")
@NetworkMod(channels = {"NordWest"}, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class NordWest {
	
	public static Logger logger = Logger.getLogger("Minecraft");
	
	@Instance("nordwest")
	public static NordWest instance;
	
	public static Version currentVersion = new Version(0, 0, 1);
	
	@SidedProxy(clientSide = "mods.nordwest.client.ClientProxy", serverSide = "mods.nordwest.common.CommonProxy")
	public static CommonProxy proxy;
	public static CreativeTabs tabNord = new CreativeTabs("tabNord") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Item.eyeOfEnder, 1, 0);
		}
	};
	public static Config cfg = null;
	public static Random rand = new Random();
	
	@ForgeSubscribe
	public void onLivingSpecialSpawn(LivingSpawnEvent event)
	{
		Random random = new Random();

		int chance = random.nextInt(10);
		int secondChance = random.nextInt(2);

			if(chance < 5)
				{
					int weapon = random.nextInt(10);
					int armor = random.nextInt(10);

						if(secondChance == 0)
						{
							if(event.entityLiving instanceof EntityZombie && weapon < 5) {
							event.entityLiving.setCurrentItemOrArmor(0, new ItemStack(CustomItems.copperSword));
							}
							if(armor < 3) {
							event.entityLiving.setCurrentItemOrArmor(1, new ItemStack(CustomItems.copperHelmet));
							event.entityLiving.setCurrentItemOrArmor(2, new ItemStack(CustomItems.copperChestplate));
							event.entityLiving.setCurrentItemOrArmor(3, new ItemStack(CustomItems.copperLegs));
							event.entityLiving.setCurrentItemOrArmor(4, new ItemStack(CustomItems.copperBoots));
							}
						}
						else if(secondChance == 1)
						{
							if(event.entityLiving instanceof EntityZombie && weapon < 3) {
							event.entityLiving.setCurrentItemOrArmor(0, new ItemStack(CustomItems.copperAxe));
							}
							if(armor < 1) {
							event.entityLiving.setCurrentItemOrArmor(1, new ItemStack(CustomItems.mythrilHelmet));
							event.entityLiving.setCurrentItemOrArmor(2, new ItemStack(CustomItems.mythrilChestplate));
							event.entityLiving.setCurrentItemOrArmor(3, new ItemStack(CustomItems.mythrilLegs));
							event.entityLiving.setCurrentItemOrArmor(4, new ItemStack(CustomItems.mythrilBoots));
							}
						}
						else if(secondChance == 2)
						{
							if(event.entityLiving instanceof EntityZombie && weapon < 5) {
							event.entityLiving.setCurrentItemOrArmor(0, new ItemStack(CustomItems.copperSword));
							}
							if(armor < 5) {
							event.entityLiving.setCurrentItemOrArmor(2, new ItemStack(CustomItems.copperChestplate));
							}
						}
					}
				}

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
		/** Harvest Level for block **/
		CustomBlocks.setHarvestLevel();
		/** Recipes **/
		Recipes.init();

	}

	@Init
	public void load(FMLInitializationEvent event, EntityPlayer player) {
		
		/** Our Proxies */
		proxy.registerEvent();

		/** Registering Smelting Recipes **/
		GameRegistry.addSmelting(CustomBlocks.copperOre.blockID, new ItemStack(CustomItems.copperIngotItem), 0.2f);
		GameRegistry.addSmelting(CustomBlocks.mythrilOre.blockID, new ItemStack(CustomItems.mythrilIngotItem), 0.2f);
		GameRegistry.addSmelting(CustomBlocks.customTreeWood.blockID, new ItemStack(Item.coal, 1, 1), 0.2f);
		/** Registering Generators **/
		GameRegistry.registerWorldGenerator(new OreWorldGenerator());
		
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
