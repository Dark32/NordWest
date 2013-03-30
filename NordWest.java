package mods.mod_nw;

import java.util.logging.Level;

import mods.mod_nw.Block.*;
import net.minecraft.block.Block;
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
	public static Config cfg=null;
	public static Block lexpo;
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		cfg = new Config(event);
		
	}
	LanguageRegistry language =LanguageRegistry.instance();
	//.addStringLocalization("itemGroup.tabCustom", "en_US", "My Custom Tab");
	@Init
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
		lexpo = new BaseOre(cfg.lexpo_id, Material.rock).setHardness(3F).setResistance(5F).setUnlocalizedName("lexpo");
		GameRegistry.registerBlock(lexpo, "lexpo");
		LanguageRegistry.addName(lexpo, cfg.lexpo_name);
		
		
		

	}

	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		language.addStringLocalization("itemGroup.tabNord", "en_US", cfg.tabNord);
	}

}
