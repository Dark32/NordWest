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
		public static int lexpo_id;
		public static int ore0_id;
		public static int ore1_id;
		public static int ore2_id;
		public static int ore3_id;
		public static int ore4_id;
		public static int coper_ore_id;
		public static int coperblock_id;
		public static int mithrilore_id;
		public static int blockmithri_id;
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

	/** Item **/
	public static class ITEM_ID {

		public static int lexpi_id;

		public static int mingot_id;
		public static int cingot_id;

		public static int homescroll;
	}

	/** Other **/
	public String[] lang;
	public static final String LanguageDirectory = "/mods/mod_nw/lang/";

	public Config(File file) {

		// public static void init(FMLPreInitializationEvent event){

		Configuration cfg = new Configuration(file);
		try {
			cfg.load();
			/** Block **/
			BLOCK_ID.lexpo_id = cfg.getBlock("lexpo", 194).getInt(194);

			BLOCK_ID.ore0_id = cfg.getBlock("ore0_id", 195).getInt(195);
			BLOCK_ID.ore1_id = cfg.getBlock("ore1_id", 196).getInt(196);
			BLOCK_ID.ore2_id = cfg.getBlock("ore2_id", 197).getInt(197);
			BLOCK_ID.ore3_id = cfg.getBlock("ore3_id", 198).getInt(198);
			BLOCK_ID.ore4_id = cfg.getBlock("ore4_id", 199).getInt(199);
			BLOCK_ID.coper_ore_id = cfg.getBlock("coper_ore_id", 200).getInt(200);
			BLOCK_ID.coperblock_id = cfg.getBlock("coperblock_id", 201).getInt(201);
			BLOCK_ID.mithrilore_id = cfg.getBlock("mithrilore_id", 202).getInt(202);
			BLOCK_ID.blockmithri_id = cfg.getBlock("blockmithri_id", 203).getInt(203);
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
			/** Item **/
			ITEM_ID.lexpi_id = cfg.getItem("lexpi", 411).getInt(411);
			ITEM_ID.mingot_id = cfg.getItem("mingot_id", 409).getInt(409);
			ITEM_ID.cingot_id = cfg.getItem("cingot_id", 410).getInt(410);
			ITEM_ID.homescroll = cfg.getItem("homescroll", 437).getInt(437);

			/** локализация **/
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
