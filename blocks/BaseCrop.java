package mods.nordwest.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;

public class BaseCrop extends BlockCrops {

	private Icon[] iconArray;
	private int seedItem;
	private int cropItem;
	public BaseCrop(int par1,int crop, int seed) {
		super(par1);
		this.cropItem = crop;
		this.seedItem = seed;
	}
	@Override
    protected int getSeedItem()
    {
        return seedItem;
    }
    @Override
    protected int getCropItem()
    {
        return cropItem;
    }

	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int par1, int par2) {
		return this.iconArray[par2];
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		this.iconArray = new Icon[8];
		for (int i = 0; i < this.iconArray.length; ++i) {
			this.iconArray[i] = par1IconRegister.registerIcon("nordwest:" + this.getUnlocalizedName2() + "." + i);
		}
	}
}
