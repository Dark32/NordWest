package mods.nordwest.items;

import mods.nordwest.common.NordWest;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.common.IPlantable;

public class BaseSeed extends ItemSeeds implements IPlantable {
	public BaseSeed(int par1, int par2, int par3) {
		super(par1, par2, par3);
		this.setCreativeTab(NordWest.tabNord);
	}
	public BaseSeed(int par1, int par2) {
		super(par1, par2, Block.tilledField.blockID);
		this.setCreativeTab(NordWest.tabNord);
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("nordwest:" + this.getUnlocalizedName());
	}
}
