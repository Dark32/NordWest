package mods.mod_nw.Block;

import mods.mod_nw.NordWest;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BaseBlock extends Block {

	public BaseBlock(int par1, Material par2Material) {
		super(par1, par2Material);
		setCreativeTab(NordWest.tabNord);
		// TODO Auto-generated constructor stub
	}
	public void registerIcons(IconRegister iconRegister)
	{
	         blockIcon = iconRegister.registerIcon("mod_nw:"+this.getUnlocalizedName2());
	}
}