package mods.nordwest.common;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class CommonProxy {
	public static int cmfblockRenderID;
	public static int slopesRenderID;

	/** Client stuff: */
	public void registerRenderers() {
		/** Nothing here as renders are the server side proxy! */
	}

	public int addArmor(String armor) {
		return 0; /** Server doesn't care what number is. */
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