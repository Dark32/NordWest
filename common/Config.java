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
			BLOCK_ID.expaniteOre_id = cfg.getBlock("expaniteOre", 194).getInt(194);

			BLOCK_ID.ore0_id = cfg.getBlock("ore0_id", 195).getInt(195);
			BLOCK_ID.ore1_id = cfg.getBlock("ore1_id", 196).getInt(196);
			BLOCK_ID.ore2_id = cfg.getBlock("ore2_id", 197).getInt(197);
			BLOCK_ID.ore3_id = cfg.getBlock("ore3_id", 198).getInt(198);
			BLOCK_ID.ore4_id = cfg.getBlock("ore4_id", 199).getInt(199);
			BLOCK_ID.coper_ore_id = cfg.getBlock("coper_ore_id", 200).getInt(200);
			BLOCK_ID.copperBlock_id = cfg.getBlock("copperBlock_id", 201).getInt(201);
			BLOCK_ID.mythrilOre_id = cfg.getBlock("mythrilOre_id", 202).getInt(202);
			BLOCK_ID.mythrilBlock_id = cfg.getBlock("mythrilBlock_id", 203).getInt(203);
			BLOCK_ID.customTreeplank_id = cfg.getBlock("customTreelog_id", 204).getInt(204);
			BLOCK_ID.magicTreeplank_id = cfg.getBlock("magicTreeplank_id", 205).getInt(205);
			BLOCK_ID.lamp_id = cfg.getBlock("lamp_id", 206).getInt(206);
			BLOCK_ID.leave_id = cfg.getBlock("leave_id", 207).getInt(207);
			BLOCK_ID.customTreewood_id = cfg.getBlock("customTreewood_id", 208).getInt(208);
			BLOCK_ID.customTreeSapling = cfg.getBlock("customTreeSapling", 209).getInt(209);
			BLOCK_ID.magicTreeLeaves = cfg.getBlock("magicTreeLeaves", 210).getInt(210);
			BLOCK_ID.magicTreeWood = cfg.getBlock("magicTreeWood", 211).getInt(211);
			BLOCK_ID.magicTreeSapling = cfg.getBlock("magicTreeSapling", 212).getInt(212);
			BLOCK_ID.flora = cfg.getBlock("flora", 213).getInt(213);
			BLOCK_ID.homeblock = cfg.getBlock("homeblock", 214).getInt(214);
			BLOCK_ID.blockWoolHalf1 = cfg.getBlock("blockWoolHalf1", 215).getInt(215);
			BLOCK_ID.blockWoolHalf2 = cfg.getBlock("blockWoolHalf2", 216).getInt(216);
			BLOCK_ID.blockWoolFull1 = cfg.getBlock("blockWoolFull1", 217).getInt(217);
			BLOCK_ID.blockWoolFull2 = cfg.getBlock("blockWoolFull2", 218).getInt(218);

			BLOCK_ID.slameBlock = cfg.getBlock("slameBlock", 219).getInt(219);
			BLOCK_ID.redBlock = cfg.getBlock("redBlock", 220).getInt(220);
			BLOCK_ID.customBlock1 = cfg.getBlock("customBlock1", 221).getInt(221);
			BLOCK_ID.customBlock2 = cfg.getBlock("customBlock2", 222).getInt(222);
			BLOCK_ID.customBlock3 = cfg.getBlock("customBlock3", 223).getInt(223);
			BLOCK_ID.customBlock4 = cfg.getBlock("customBlock4", 224).getInt(224);
			BLOCK_ID.customBlock5 = cfg.getBlock("customBlock5", 225).getInt(225);
			BLOCK_ID.customBlock6 = cfg.getBlock("customBlock6", 226).getInt(226);
			BLOCK_ID.customBlock7 = cfg.getBlock("customBlock7", 227).getInt(227);
			BLOCK_ID.customBlock8 = cfg.getBlock("customBlock8", 237).getInt(237);
			BLOCK_ID.customSlabHalf = cfg.getBlock("customSlabHalf", 238).getInt(238);
			BLOCK_ID.customSlabFull = cfg.getBlock("customSlabFull", 239).getInt(239);
			BLOCK_ID.customSlabHalf2 = cfg.getBlock("customSlabHalf2", 240).getInt(240);
			BLOCK_ID.customSlabFull2 = cfg.getBlock("customSlabFull2", 241).getInt(241);
			BLOCK_ID.customSlabHalf3 = cfg.getBlock("customSlabHalf3", 242).getInt(242);
			BLOCK_ID.customSlabFull3 = cfg.getBlock("customSlabFull3", 243).getInt(243);
			BLOCK_ID.decoratedTreeWood = cfg.getBlock("decoratedTreeWood", 244).getInt(244);
			BLOCK_ID.decoratedTreeWood2 = cfg.getBlock("decoratedTreeWood2", 245).getInt(245);
			BLOCK_ID.candle = cfg.getBlock("candle", 246).getInt(246);
			
			BLOCK_ID.ryeCrop = cfg.getBlock("ryeCrop", 247).getInt(247);
			/** Items... AGAIN! **/
			ITEM_ID.expanite_id = cfg.getItem("expanite", 411).getInt(411);
			ITEM_ID.mythrilIngot_id = cfg.getItem("mythrilIngot_id", 409).getInt(409);
			ITEM_ID.copperIngot_id = cfg.getItem("copperIngot_id", 410).getInt(410);
			ITEM_ID.homescroll = cfg.getItem("homescroll", 437).getInt(437);

			ITEM_ID.copperHelmet = cfg.getItem("copperHelmet", 480).getInt(480);
			ITEM_ID.copperChestplate = cfg.getItem("copperChestplate", 481).getInt(481);
			ITEM_ID.copperLegs = cfg.getItem("copperLegs", 482).getInt(482);
			ITEM_ID.copperBoots = cfg.getItem("copperBoots", 483).getInt(483);

			ITEM_ID.mythrilHelmet = cfg.getItem("mythrilHelmet", 470).getInt(470);
			ITEM_ID.mythrilChestplate = cfg.getItem("mythrilChestplate", 471).getInt(471);
			ITEM_ID.mythrilLegs = cfg.getItem("mythrilLegs", 472).getInt(472);
			ITEM_ID.mythrilBoots = cfg.getItem("mythrilBoots", 473).getInt(473);

			ITEM_ID.copperPickaxe = cfg.getItem("copperPickaxe", 490).getInt(490);
			ITEM_ID.copperAxe = cfg.getItem("copperAxe", 491).getInt(491);
			ITEM_ID.copperShovel = cfg.getItem("copperShovel", 492).getInt(492);
			ITEM_ID.copperSword = cfg.getItem("copperSword", 493).getInt(493);
			ITEM_ID.copperHoe = cfg.getItem("copperHoe", 494).getInt(494);

			ITEM_ID.mythrilPickaxe = cfg.getItem("mythrilPickaxe", 495).getInt(495);
			ITEM_ID.mythrilAxe = cfg.getItem("mythrilAxe", 496).getInt(496);
			ITEM_ID.mythrilShovel = cfg.getItem("mythrilShovel", 497).getInt(497);
			ITEM_ID.mythrilSword = cfg.getItem("mythrilSword", 498).getInt(498);
			ITEM_ID.mythrilHoe = cfg.getItem("mythrilHoe", 499).getInt(499);

			ITEM_ID.samuraiHelmet = cfg.getItem("samuraiHelmet", 488).getInt(488);
			ITEM_ID.samuraiChestplate = cfg.getItem("samuraiChestplate", 489).getInt(489);
			ITEM_ID.samuraiLegs = cfg.getItem("samuraiLegs", 490).getInt(490);
			ITEM_ID.samuraiBoots = cfg.getItem("samuraiBoots", 491).getInt(491);
			
			ITEM_ID.seedRye = cfg.getItem("seedRye", 492).getInt(492);;
			ITEM_ID.cropRye = cfg.getItem("cropRye", 493).getInt(493);;
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
