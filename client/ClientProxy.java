package mods.nordwest.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import mods.nordwest.client.gui.GuiAltar;
import mods.nordwest.client.gui.GuiExtractor;
import mods.nordwest.client.renders.BlockCandleRenderer;
import mods.nordwest.client.renders.BlockExtractorRenderer;
import mods.nordwest.common.CommonProxy;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {
		 RenderingRegistry.registerBlockHandler(new BlockCandleRenderer());
		 RenderingRegistry.registerBlockHandler(new BlockExtractorRenderer());
	}
	
	@Override
	public GuiScreen getClientGui(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		
		switch(ID)
		{
			case 0:
				return new GuiAltar(tileEntity,player, world);
			case 1:
				return new GuiExtractor(player.inventory,tileEntity,player);
		}
		return null;
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