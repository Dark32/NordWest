package mods.nordwest.common;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Config {
	public static class BLOCK_ID {
		public static int expaniteOre_id;
		public static int ore0_id;
		public static int ore1_id;
		public static int ore2_id;
		public static int ore3_id;
		public static int ore4_id;
		public static int coper_ore_id;
		public static int copperBlock_id;
		public static int mythrilOre_id;
		public static int mythrilBlock_id;
		public static int customTreeplank_id;
		public static int magicTreeplank_id;
		public static int lamp_id;
		public static int leave_id;
		public static int customTreewood_id;
		public static int customTreeSapling;
		public static int magicTreeLeaves;
		public static int magicTreeWood;
		public static int magicTreeSapling;
		public static int flora;
		public static int homeblock;
		public static int blockWoolHalf1;
		public static int blockWoolHalf2;
		public static int blockWoolFull1;
		public static int blockWoolFull2;
		public static int redBlock;
		public static int slameBlock;
		public static int customBlock1;
		public static int customBlock2;
		public static int customBlock3;
		public static int customBlock4;
		public static int customBlock5;
		public static int customBlock6;
		public static int customBlock7;
		public static int customBlock8;
		public static int customSlabHalf;
		public static int customSlabFull;
		public static int customSlabHalf2;
		public static int customSlabFull2;
		public static int customSlabHalf3;
		public static int customSlabFull3;
		public static int decoratedTreeWood;
		public static int decoratedTreeWood2;
		public static int candle;
		public static int ryeCrop;

	}

	/** Items **/
	public static class ITEM_ID {
		public static int wax;
		public static int expanite_id;
		public static int mythrilIngot_id;
		public static int copperIngot_id;
		public static int homescroll;
		public static int copperHelmet;
		public static int copperChestplate;
		public static int copperLegs;
		public static int copperBoots;
		public static int homescopperBootscroll;
		public static int mythrilHelmet;
		public static int mythrilChestplate;
		public static int mythrilLegs;
		public static int mythrilBoots;
		public static int copperPickaxe;
		public static int copperAxe;
		public static int copperShovel;
		public static int copperSword;
		public static int copperHoe;
		public static int mythrilPickaxe;
		public static int mythrilAxe;
		public static int mythrilShovel;
		public static int mythrilSword;
		public static int mythrilHoe;
		public static int samuraiHelmet;
		public static int samuraiChestplate;
		public static int samuraiLegs;
		public static int samuraiBoots;
		public static int seedRye;
		public static int cropRye;
	}

	/** Other **/
	public String[] lang;
	public static final String LanguageDirectory = "/mods/nordwest/lang/";
	public static int CandleRendererID = RenderingRegistry.getNextAvailableRenderId();

	public Config(File file) {

		// public static void init(FMLPreInitializationEvent event){

		Configuration cfg = new Configuration(file);
		try {
			cfg.load();
			/** Blocks **/
			BLOCK_ID.expaniteOre_id = cfg.getBlock("expaniteOre", 1000).getInt(1000);
			BLOCK_ID.ore0_id = cfg.getBlock("ore0_id", 1001).getInt(1001);
			BLOCK_ID.ore1_id = cfg.getBlock("ore1_id", 1002).getInt(1002);
			BLOCK_ID.ore2_id = cfg.getBlock("ore2_id", 1003).getInt(1003);
			BLOCK_ID.ore3_id = cfg.getBlock("ore3_id", 1004).getInt(1004);
			BLOCK_ID.ore4_id = cfg.getBlock("ore4_id", 1005).getInt(1005);
			BLOCK_ID.coper_ore_id = cfg.getBlock("coper_ore_id", 1006).getInt(1006);
			BLOCK_ID.copperBlock_id = cfg.getBlock("copperBlock_id", 1007).getInt(1007);
			BLOCK_ID.mythrilOre_id = cfg.getBlock("mythrilOre_id", 1008).getInt(1008);
			BLOCK_ID.mythrilBlock_id = cfg.getBlock("mythrilBlock_id", 1009).getInt(1009);
			BLOCK_ID.customTreeplank_id = cfg.getBlock("customTreelog_id", 1010).getInt(1010);
			BLOCK_ID.magicTreeplank_id = cfg.getBlock("magicTreeplank_id", 1011).getInt(1011);
			BLOCK_ID.lamp_id = cfg.getBlock("lamp_id", 1012).getInt(1012);
			BLOCK_ID.leave_id = cfg.getBlock("leave_id", 1013).getInt(1013);
			BLOCK_ID.customTreewood_id = cfg.getBlock("customTreewood_id", 1014).getInt(1014);
			BLOCK_ID.customTreeSapling = cfg.getBlock("customTreeSapling", 1015).getInt(1015);
			BLOCK_ID.magicTreeLeaves = cfg.getBlock("magicTreeLeaves", 1016).getInt(1016);
			BLOCK_ID.magicTreeWood = cfg.getBlock("magicTreeWood", 1017).getInt(1017);
			BLOCK_ID.magicTreeSapling = cfg.getBlock("magicTreeSapling", 1018).getInt(1018);
			BLOCK_ID.flora = cfg.getBlock("flora", 1019).getInt(1019);
			BLOCK_ID.homeblock = cfg.getBlock("homeblock", 1020).getInt(1020);
			BLOCK_ID.blockWoolHalf1 = cfg.getBlock("blockWoolHalf1", 1021).getInt(1021);
			BLOCK_ID.blockWoolHalf2 = cfg.getBlock("blockWoolHalf2", 1022).getInt(1022);
			BLOCK_ID.blockWoolFull1 = cfg.getBlock("blockWoolFull1", 1023).getInt(1023);
			BLOCK_ID.blockWoolFull2 = cfg.getBlock("blockWoolFull2", 1024).getInt(1024);
			BLOCK_ID.slameBlock = cfg.getBlock("slameBlock", 1025).getInt(1025);
			BLOCK_ID.redBlock = cfg.getBlock("redBlock", 1026).getInt(1026);
			BLOCK_ID.customBlock1 = cfg.getBlock("customBlock1", 1027).getInt(1027);
			BLOCK_ID.customBlock2 = cfg.getBlock("customBlock2", 1028).getInt(1028);
			BLOCK_ID.customBlock3 = cfg.getBlock("customBlock3", 1029).getInt(1029);
			BLOCK_ID.customBlock4 = cfg.getBlock("customBlock4", 1030).getInt(1030);
			BLOCK_ID.customBlock5 = cfg.getBlock("customBlock5", 1031).getInt(1031);
			BLOCK_ID.customBlock6 = cfg.getBlock("customBlock6", 1032).getInt(1032);
			BLOCK_ID.customBlock7 = cfg.getBlock("customBlock7", 1033).getInt(1033);
			BLOCK_ID.customBlock8 = cfg.getBlock("customBlock8", 1034).getInt(1034);
			BLOCK_ID.customSlabHalf = cfg.getBlock("customSlabHalf", 1035).getInt(1035);
			BLOCK_ID.customSlabFull = cfg.getBlock("customSlabFull", 1036).getInt(1036);
			BLOCK_ID.customSlabHalf2 = cfg.getBlock("customSlabHalf2", 1037).getInt(1037);
			BLOCK_ID.customSlabFull2 = cfg.getBlock("customSlabFull2", 1038).getInt(1038);
			BLOCK_ID.customSlabHalf3 = cfg.getBlock("customSlabHalf3", 1039).getInt(1039);
			BLOCK_ID.customSlabFull3 = cfg.getBlock("customSlabFull3", 1040).getInt(1040);
			BLOCK_ID.decoratedTreeWood = cfg.getBlock("decoratedTreeWood", 1041).getInt(1041);
			BLOCK_ID.decoratedTreeWood2 = cfg.getBlock("decoratedTreeWood2", 1042).getInt(1042);
			BLOCK_ID.candle = cfg.getBlock("candle", 1043).getInt(1043);
			BLOCK_ID.ryeCrop = cfg.getBlock("ryeCrop", 1044).getInt(1044);

			/** Items... AGAIN! **/
			ITEM_ID.wax = cfg.getItem("wax", 5000).getInt(5000);
			ITEM_ID.expanite_id = cfg.getItem("expanite", 5001).getInt(5001);
			ITEM_ID.mythrilIngot_id = cfg.getItem("mythrilIngot_id", 5002).getInt(5002);
			ITEM_ID.copperIngot_id = cfg.getItem("copperIngot_id", 5003).getInt(5003);
			ITEM_ID.homescroll = cfg.getItem("homescroll", 5004).getInt(5004);
			ITEM_ID.copperHelmet = cfg.getItem("copperHelmet", 5005).getInt(5005);
			ITEM_ID.copperChestplate = cfg.getItem("copperChestplate", 5006).getInt(5006);
			ITEM_ID.copperLegs = cfg.getItem("copperLegs", 5007).getInt(5007);
			ITEM_ID.copperBoots = cfg.getItem("copperBoots", 5008).getInt(5008);
			ITEM_ID.mythrilHelmet = cfg.getItem("mythrilHelmet", 5009).getInt(5009);
			ITEM_ID.mythrilChestplate = cfg.getItem("mythrilChestplate", 5010).getInt(5010);
			ITEM_ID.mythrilLegs = cfg.getItem("mythrilLegs", 5011).getInt(5011);
			ITEM_ID.mythrilBoots = cfg.getItem("mythrilBoots", 5012).getInt(5012);
			ITEM_ID.copperPickaxe = cfg.getItem("copperPickaxe", 5013).getInt(5013);
			ITEM_ID.copperAxe = cfg.getItem("copperAxe", 5014).getInt(5014);
			ITEM_ID.copperShovel = cfg.getItem("copperShovel", 5015).getInt(5015);
			ITEM_ID.copperSword = cfg.getItem("copperSword", 5016).getInt(5016);
			ITEM_ID.copperHoe = cfg.getItem("copperHoe", 5017).getInt(5017);
			ITEM_ID.mythrilPickaxe = cfg.getItem("mythrilPickaxe", 5018).getInt(5018);
			ITEM_ID.mythrilAxe = cfg.getItem("mythrilAxe", 5019).getInt(5019);
			ITEM_ID.mythrilShovel = cfg.getItem("mythrilShovel", 5020).getInt(5020);
			ITEM_ID.mythrilSword = cfg.getItem("mythrilSword", 5021).getInt(5021);
			ITEM_ID.mythrilHoe = cfg.getItem("mythrilHoe", 5022).getInt(5022);
			ITEM_ID.samuraiHelmet = cfg.getItem("samuraiHelmet", 5023).getInt(5023);
			ITEM_ID.samuraiChestplate = cfg.getItem("samuraiChestplate", 5024).getInt(5024);
			ITEM_ID.samuraiLegs = cfg.getItem("samuraiLegs", 5025).getInt(5025);
			ITEM_ID.samuraiBoots = cfg.getItem("samuraiBoots", 5026).getInt(5026);
			ITEM_ID.seedRye = cfg.getItem("seedRye", 5027).getInt(5027);
			ITEM_ID.cropRye = cfg.getItem("cropRye", 5028).getInt(5028);
			/** Localizations **/
			List<String> _lang = new ArrayList<String>();
			_lang.add("ru_RU");
			_lang.add("en_US");
			for (String localizationName : _lang) {
				LanguageRegistry.instance().loadLocalization(LanguageDirectory + localizationName + ".xml", localizationName, true);
			}
			/*
			 * for (int i = 0; i < _lang.length; ++i) { String localizationName = _lang[i]; LanguageRegistry.instance().loadLocalization(LanguageDirectory + localizationName + ".xml", localizationName, true); }
			 */

		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, "NordWest has a problem loading because of it's configuration!");
		} finally {
			cfg.save();
		}
	}
}
/**
 * str=''
 * i=5000 str.each_line{|l| 
 * print l.gsub(/,\s(\d+)\)\.getInt\((\d+)\)/,", #{i}).getInt(#{i})") 
 * i+=1 }
 * **/
