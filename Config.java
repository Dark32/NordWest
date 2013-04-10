package mods.mod_nw;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
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
		public static int homeblock;;

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
	}

	/** Other **/
	public String[] lang;
	public static final String LanguageDirectory = "/mods/mod_nw/lang/";

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

			/** Localizations **/
			List<String> _lang = new ArrayList<String>();
			_lang.add("ru_RU");
			_lang.add("en_US");
			for (String localizationName : _lang) {
				LanguageRegistry.instance().loadLocalization(LanguageDirectory + localizationName + ".xml",
						localizationName, true);
			}
			/*
			 * for (int i = 0; i < _lang.length; ++i) { String localizationName
			 * = _lang[i];
			 * LanguageRegistry.instance().loadLocalization(LanguageDirectory +
			 * localizationName + ".xml", localizationName, true); }
			 */

		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, "NordWest has a problem loading because of it's configuration!");
		} finally {
			cfg.save();
		}
	}

}
