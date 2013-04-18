package mods.nordwest.blocks;

import java.util.HashMap;
import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.nordwest.common.CustomBlocks;
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
	private String[] stringTops;
	private Icon[] iconTopArray;
	private HashMap otherDrop;

	public BaseMetadataBlock(int par1, Material par2Material, int subName) {
		super(par1, par2Material);
		this.subName = subName;
		this.stringTops = new String[subName];
	}

	public BaseMetadataBlock(int par1, Material par2Material, int subName, String[] tops) {
		super(par1, par2Material);
		this.subName = subName;
		this.stringTops = new String[subName];
		this.iconTopArray = new Icon[subName];
		this.stringTops = tops;
	}

	public BaseMetadataBlock(int par1, Material par2Material, int subName, String[] tops, HashMap otherDrop) {
		super(par1, par2Material);
		this.subName = subName;
		this.stringTops = new String[subName];
		this.iconTopArray = new Icon[subName];
		this.stringTops = tops;
		this.otherDrop = otherDrop;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		this.iconArray = new Icon[subName];

		for (int i = 0; i < this.iconArray.length; ++i) {
			this.iconArray[i] = par1IconRegister.registerIcon("nordwest:" + this.getUnlocalizedName2() + "." + i);
			if (stringTops[i] != null && !stringTops[i].equals("")) {
				iconTopArray[i] = par1IconRegister.registerIcon("nordwest:" + this.getUnlocalizedName2() + "." + i + stringTops[i]);
			}
		}
	}

	@Override
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int i = 0; i < this.subName; ++i) {
			par3List.add(new ItemStack(par1, 1, i));
		}

	}

	@Override
	public int damageDropped(int par1) {
		boolean stone = true;
		stone |= this.blockID == CustomBlocks.customStone1.blockID;
		stone |= this.blockID == CustomBlocks.customStone2.blockID;
		stone |= this.blockID == CustomBlocks.customStone3.blockID;
		stone |= this.blockID == CustomBlocks.customStone4.blockID;
		stone |= this.blockID == CustomBlocks.customStone5.blockID;
		stone |= this.blockID == CustomBlocks.customStone6.blockID;
		stone |= this.blockID == CustomBlocks.customStone7.blockID;
		if (par1 == 0 || stone) {
			return 1;
		} else {
			return par1;
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int par1, int par2) {
		if (par1 == 1 || par1 == 0) {
			if (stringTops[par2] != null && !stringTops[par2].equals("")) {
				return iconTopArray[par2];
			} else {
				return this.iconArray[par2];
			}
		} else {
			return this.iconArray[par2];
		}
	}
}
