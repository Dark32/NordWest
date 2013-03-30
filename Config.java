package mods.mod_nw;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config {
	/** Block **/
	public static int lexpo_id;
	public static String lexpo_name;
	public static int ore0_id;
	public static String ore0_name;
	public static int ore1_id;
	public static String ore1_name;
	public static int ore2_id;
	public static String ore2_name;
	public static int ore3_id;
	public static String ore3_name;
	public static int ore4_id;
	public static String ore4_name;
	public static int coper_ore_id;
	public static String coper_ore_name;
	public static int coperblock_id;
	public static String coperblock_name;
	/** Item **/
	public static int lexpi_id;
	public static String lexpi_name;
	public static int mingot_id;
	public static String mingot_name;
	public static int cingot_id;
	public static String cingot_name;
	public static int  mithrilore_id;
	public static String  mithrilore_name;
	public static int blockmithri_id;
	public static String blockmithri_name;
	/** Other  **/
	public static String tabNord;
	public Config(File file){
		
	
	//public static void init(FMLPreInitializationEvent event){

		Configuration cfg = new Configuration(file);
		try {
			cfg.load();
			/**Block**/
			lexpo_id = cfg.getBlock("lexpo", 194).getInt(194);
			lexpo_name = cfg.get("Name", "lexpo", "Эксперинит").getString();
			
			ore0_id = cfg.getBlock("ore0_id", 195).getInt(195);
			ore0_name = cfg.get("Name", "ore0_name", "Камень").getString();
			ore1_id = cfg.getBlock("ore1_id", 196).getInt(196);
			ore1_name = cfg.get("Name", "ore1_name", "Камень").getString();
			ore2_id = cfg.getBlock("ore2_id", 197).getInt(197);
			ore2_name = cfg.get("Name", "ore2_name", "Камень").getString();
			ore3_id = cfg.getBlock("ore3_id", 198).getInt(198);
			ore3_name = cfg.get("Name", "ore3_name", "Камень").getString();
			ore4_id = cfg.getBlock("ore4_id", 199).getInt(199);
			ore4_name = cfg.get("Name", "ore4_name", "Камень").getString();
			
			coper_ore_id = cfg.getBlock("coper_ore_id", 200).getInt(200);
			coper_ore_name = cfg.get("Name", "coper_ore_name", "Медная руда").getString();
			
			coperblock_id = cfg.getBlock("coperblock_id", 201).getInt(201);
			coperblock_name = cfg.get("Name", "coperblock_name", "Медный блок").getString();
			
			mithrilore_id = cfg.getBlock("mithrilore_id", 202).getInt(202);
			mithrilore_name = cfg.get("Name", "mithrilore_name", "Митриловая руда").getString();
			
			blockmithri_id = cfg.getBlock("blockmithri_id", 203).getInt(203);
			blockmithri_name = cfg.get("Name", "blockmithri_name", "Митриловый блок").getString();
			/**Item**/
			lexpi_id = cfg.getItem("lexpi", 411).getInt(411);
			lexpi_name = cfg.get("Name", "lexpi", "Эксперинит").getString();
			mingot_id = cfg.getItem("mingot_id", 409).getInt(409);
			mingot_name = cfg.get("Name", "mingot_name", "Слиток митрила").getString();
			cingot_id = cfg.getItem("cingot_id", 410).getInt(410);
			cingot_name = cfg.get("Name", "cingot_name", "Слиток меди").getString();
			
			/**Other**/
			tabNord = cfg.get("Other_Name", "tabNord", "НордВест").getString();
			
			
		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, "NordWest has a problem loading it's configuration");
		} finally {
			cfg.save();
		}
	}
	
}