package mods.mod_nw;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config {
	public static int lexpo_id;
	public static String lexpo_name;
	public static String tabNord;
	public Config(FMLPreInitializationEvent event){
		
	
	//public static void init(FMLPreInitializationEvent event){

		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		try {
			cfg.load();
			lexpo_id = cfg.getBlock("lexpo", 194).getInt(194);
			lexpo_name = cfg.get("Name", "lexpo", "Эксперинит").getString();
			
			
			tabNord = cfg.get("Name", "tabNord", "НордВест").getString();
		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, "NordWest has a problem loading it's configuration");
		} finally {
			cfg.save();
		}
	}
	
}