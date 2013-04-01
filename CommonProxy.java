package mods.mod_nw;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class CommonProxy {
	public static int cmfblockRenderID;
	public static int slopesRenderID;

	// Client stuff
	public void registerRenderers() {
		// Nothing here as this is the server side proxy
	}

	public int addArmor(String armor) {
		return 0; // server doesn't care what the number is
	}

	public void registerServerTickHandler() {
		// TickRegistry.registerTickHandler(new CommonTickHandler(),
		// Side.SERVER);
		// TickRegistry.registerTickHandler(new ClientTickHandler(),
		// Side.CLIENT);
	}

	public void registerEvent() {
		MinecraftForge.EVENT_BUS.register(new BonemealHandler());
	}
}
