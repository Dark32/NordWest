package mods.mod_nw.Block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class BaseMetadataBlock extends BaseBlock {
	private int subName;
	@SideOnly(Side.CLIENT)
	private Icon[] iconArray;

	public BaseMetadataBlock(int par1, Material par2Material, int subName) {
		super(par1, par2Material);
		this.subName = subName;
		// TODO Auto-generated constructor stub
	}

	@SideOnly(Side.CLIENT)
	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	public void registerIcons(IconRegister par1IconRegister) {
		this.iconArray = new Icon[subName];

		for (int i = 0; i < this.iconArray.length; ++i) {
			this.iconArray[i] = par1IconRegister.registerIcon("mod_nw:" +this.getUnlocalizedName2()+"."+i);
		}
	}

	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int i = 0; i < this.subName; ++i) {
			par3List.add(new ItemStack(par1, 1, i));
		}

	}
    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int par1)
    {
        return par1;
    }
    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        return this.iconArray[par2];
    }
}
