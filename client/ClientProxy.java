package mods.nordwest.client;

import cpw.mods.fml.client.registry.RenderingRegistry;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import mods.nordwest.client.renders.BlockCandleRenderer;
import mods.nordwest.common.CommonProxy;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {
		 RenderingRegistry.registerBlockHandler(new BlockCandleRenderer());
	}
	
	@Override
	public int addArmor(String armor)
	{
		return RenderingRegistry.addNewArmourRendererPrefix("../mods/nordwest/textures/armor/"+armor);
	}
	public void registerServerTickHandler()
	{
		//TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
	}
	public String getStringLocalization(String key){
		return  LanguageRegistry.instance().getStringLocalization(key);
	}
}