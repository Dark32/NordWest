package mods.mod_nw.Item;

import mods.mod_nw.NordWest;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class BaseItem extends Item {

	public BaseItem(int par1) {
		super(par1);
		setCreativeTab(NordWest.tabNord);
		// TODO Auto-generated constructor stub
	}
	public void updateIcons(IconRegister iconRegister)
	{
	         iconIndex = iconRegister.registerIcon("mod_nw:"+this.getUnlocalizedName());
	}
}
