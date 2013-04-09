package mods.mod_nw.client;

import cpw.mods.fml.client.registry.RenderingRegistry;

import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import mods.mod_nw.CommonProxy;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {

	}
	
	@Override
	public int addArmor(String armor)
	{
		return RenderingRegistry.addNewArmourRendererPrefix("../mods/mod_nw/textures/armor/"+armor);
	}
	public void registerServerTickHandler()
	{
		//TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
	}

}