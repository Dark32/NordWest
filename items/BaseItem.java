package mods.nordwest.items;

import mods.nordwest.common.NordWest;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class BaseItem extends Item {

	public BaseItem(int par1) {
		super(par1);
		setCreativeTab(NordWest.tabNord);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("nordwest:" + this.getUnlocalizedName());
	}
}
