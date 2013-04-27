package mods.nordwest.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
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
	
	public Object getClientGui(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		return null;
	}
	
	public Container getServerGui(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		
		switch(ID)
		{
			/*case 1:
				return new ContainerChest(player.inventory, (TileEntityChest)tileEntity);*/
		}
		return null;
	}

	public void registerServerTickHandler() {
		// TickRegistry.registerTickHandler(new CommonTickHandler(),
		// Side.SERVER);
		// TickRegistry.registerTickHandler(new ClientTickHandler(),
		// Side.CLIENT);
	}

	public void registerEvent() {
		MinecraftForge.EVENT_BUS.register(new GeneralHandler());
	}
	public String getStringLocalization(String key){
		return key;	
	}

}