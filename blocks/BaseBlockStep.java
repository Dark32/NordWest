package mods.nordwest.blocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import mods.nordwest.common.CustomBlocks;
import mods.nordwest.common.NordWest;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BaseBlockStep extends BlockHalfSlab {
	private Icon[] iconSide = new Icon[8];
	private Icon[] iconTop = new Icon[8];
	private String[] siconTop = new String[8];

	public BaseBlockStep(int id, boolean doubleslab,Material m) {
		super(id, doubleslab, m);
		setCreativeTab(NordWest.tabNord);
		useNeighborBrightness[id] = true;
	}

	public BaseBlockStep(int id, boolean doubleslab, String[] iconTop) {
		super(id, doubleslab, Material.rock);
		setCreativeTab(NordWest.tabNord);
		useNeighborBrightness[id] = true;
		this.siconTop = iconTop;
	}
	public BaseBlockStep(int id, boolean doubleslab,Material m, String[] iconTop) {
		super(id, doubleslab, m);
		setCreativeTab(NordWest.tabNord);
		useNeighborBrightness[id] = true;
		this.siconTop = iconTop;
	}
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		int ret = this.blockID;
		if (!isBlockSingleSlab(this.blockID)) {
			if (this.blockID == CustomBlocks.blockWoolFull1.blockID) {
				ret = CustomBlocks.blockWoolHalf1.blockID;
			}
			if (this.blockID == CustomBlocks.blockWoolFull2.blockID) {
				ret = CustomBlocks.blockWoolHalf2.blockID;
			}
			if (this.blockID == CustomBlocks.customSlabFull.blockID) {
				ret = CustomBlocks.customSlabHalf.blockID;
			}
			if (this.blockID == CustomBlocks.customSlabFull2.blockID) {
				ret = CustomBlocks.customSlabHalf2.blockID;
			}
			if (this.blockID == CustomBlocks.customSlabFull3.blockID) {
				ret = CustomBlocks.customSlabHalf3.blockID;
			}
		}
		return ret;
	}

	@Override
	public String getFullSlabName(int i) {
		return super.getUnlocalizedName() + "." + i;
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		for (int i = 0; i < 8; ++i) {
			iconSide[i] = par1IconRegister.registerIcon("nordwest:" + this.getUnlocalizedName2() + "." + i);
			if (siconTop[i] != null && !siconTop[i].equals("")) {
				iconTop[i] = par1IconRegister.registerIcon("nordwest:" + siconTop[i]);
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2) {
		if (par1 == 1 || par1 == 0) {
			if (siconTop[par2 & 7] != null && !siconTop[par2 & 7].equals("")) {
				return iconTop[par2 & 7];
			} else {
				return this.iconSide[par2 & 7];
			}
		} else {
			return this.iconSide[par2 & 7];
		}
	}

	@Override
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		if (isBlockSingleSlab(par1))
			for (int i = 0; i < 8; ++i) {
				par3List.add(new ItemStack(par1, 1, i));
			}

	}

	@SideOnly(Side.CLIENT)
	//@Override
	private static boolean isBlockSingleSlab(int par0) {
		if (par0 == CustomBlocks.blockWoolHalf1.blockID) {
			return true;
		}
		if (par0 == CustomBlocks.blockWoolHalf2.blockID) {
			return true;
		}
		if (par0 == CustomBlocks.customSlabHalf.blockID) {
			return true;
		}
		if (par0 == CustomBlocks.customSlabHalf2.blockID) {
			return true;
		}
		if (par0 == CustomBlocks.customSlabHalf3.blockID) {
			return true;
		}
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int idPicked(World par1World, int par2, int par3, int par4) {
		int ret = this.blockID;
		if (!isBlockSingleSlab(this.blockID)) {
			if (this.blockID == CustomBlocks.blockWoolFull1.blockID) {
				ret = CustomBlocks.blockWoolHalf1.blockID;
			}
			if (this.blockID == CustomBlocks.blockWoolFull2.blockID) {
				ret = CustomBlocks.blockWoolHalf2.blockID;
			}
			if (this.blockID == CustomBlocks.customSlabFull.blockID) {
				ret = CustomBlocks.customSlabHalf.blockID;
			}
			if (this.blockID == CustomBlocks.customSlabFull2.blockID) {
				ret = CustomBlocks.customSlabHalf2.blockID;
			}
			if (this.blockID == CustomBlocks.customSlabFull3.blockID) {
				ret = CustomBlocks.customSlabHalf3.blockID;
			}

		}
		return ret;
	}
}