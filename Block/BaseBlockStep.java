package mods.mod_nw.Block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import mods.mod_nw.NWBlock;
import mods.mod_nw.NordWest;
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
	//protected static Icon iconSide, iconTop;
	private Icon[] iconSide = new Icon[16];

	public BaseBlockStep(int id, boolean doubleslab) {
		super(id, doubleslab, Material.wood);
		setCreativeTab(NordWest.tabNord);
		useNeighborBrightness[id] = true;
	}

	public int idDropped(int par1, Random par2Random, int par3) {
		int ret = this.blockID;
		if (!isBlockSingleSlab(this.blockID)) {
			if (this.blockID == NWBlock.blockWoolFull1.blockID) {
				ret = NWBlock.blockWoolHalf1.blockID;
			}
			if (this.blockID == NWBlock.blockWoolFull2.blockID) {
				ret = NWBlock.blockWoolHalf2.blockID;
			}

		}
		return ret;
	}

	public String getFullSlabName(int i) {
		return super.getUnlocalizedName() + "." + i;
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		for (int i = 0; i < 8; ++i) {
			iconSide[i] = par1IconRegister.registerIcon("mod_nw:" + this.getUnlocalizedName2() + "." + i);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2) {
		return iconSide[par2 & 7];
	}

	@Override
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		if (isBlockSingleSlab(par1))
			for (int i = 0; i < 8; ++i) {
				par3List.add(new ItemStack(par1, 1, i));
			}

	}

	@SideOnly(Side.CLIENT)
	private static boolean isBlockSingleSlab(int par0) {
		if (par0 == NWBlock.blockWoolHalf1.blockID) {
			return true;
		}
		if (par0 == NWBlock.blockWoolHalf2.blockID) {
			return true;
		}
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int idPicked(World par1World, int par2, int par3, int par4) {
		int ret = this.blockID;
		if (!isBlockSingleSlab(this.blockID)) {
			if (this.blockID == NWBlock.blockWoolFull1.blockID) {
				ret = NWBlock.blockWoolHalf1.blockID;
			}
			if (this.blockID == NWBlock.blockWoolFull2.blockID) {
				ret = NWBlock.blockWoolHalf2.blockID;
			}

		}
		return ret;
	}
}