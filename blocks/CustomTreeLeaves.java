package mods.nordwest.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import mods.nordwest.common.CustomBlocks;
import mods.nordwest.common.NordWest;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class CustomTreeLeaves extends BlockLeaves implements IShearable {
	public static final String[] LEAF_TYPES = new String[] { "0", "1", "2", "3" };
	// public static final String[][] field_94396_b = new String[][] {{"0", "1",
	// "2", "3"}, {"0", "1", "2", "3"}};
	@SideOnly(Side.CLIENT)
	private int field_94394_cP;
	private Icon[] iconArray = new Icon[4];
	int[] adjacentTreeBlocks;

	public CustomTreeLeaves(int par1) {
		super(par1);
		this.setTickRandomly(true);
		setCreativeTab(NordWest.tabNord);

	}

	@Override
	public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
		return 0xffffff;

	}

	@Override
	public int getRenderColor(int par1) {
		return 0xffffff;
	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return CustomBlocks.customTreeSapling.blockID;
	}

	@Override
	public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7) {
		if (!par1World.isRemote) {
			int j1 = 20;

			if ((par5 & 3) == 3) {
				j1 = 40;
			}

			if (par7 > 0) {
				j1 -= 2 << par7;

				if (j1 < 10) {
					j1 = 10;
				}
			}

			if (par1World.rand.nextInt(j1) == 0) {
				int k1 = this.idDropped(par5, par1World.rand, par7);
				this.dropBlockAsItem_do(par1World, par2, par3, par4, new ItemStack(k1, 1, this.damageDropped(par5)));
			}

			j1 = 200;

			if (par7 > 0) {
				j1 -= 10 << par7;

				if (j1 < 40) {
					j1 = 40;
				}
			}

			if ((par5 & 3) == 0 && par1World.rand.nextInt(j1) == 0) {// Заменить
																		// вещь
				this.dropBlockAsItem_do(par1World, par2, par3, par4, new ItemStack(Item.appleRed, 1, 0));
			}
		}
	}

	@Override
	public Icon getIcon(int par1, int par2) {
		return this.iconArray[par2 & 3];
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		for (int i = 0; i < this.iconArray.length; ++i) {
			this.iconArray[i] = par1IconRegister.registerIcon("nordwest:" + this.getUnlocalizedName2() + "." + i);
		}
	}

	@Override
	public boolean isShearable(ItemStack item, World world, int x, int y, int z) {
		return true;
	}

	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, World world, int x, int y, int z, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z) & 3));
		return ret;
	}

	@Override
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, 1));
		par3List.add(new ItemStack(par1, 1, 2));
		par3List.add(new ItemStack(par1, 1, 3));
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	@Override
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {

		return par5 == 0 && this.minY > 0.0D ? true : (par5 == 1 && this.maxY < 1.0D ? true : (par5 == 2
				&& this.minZ > 0.0D ? true : (par5 == 3 && this.maxZ < 1.0D ? true
				: (par5 == 4 && this.minX > 0.0D ? true : (par5 == 5 && this.maxX < 1.0D ? true : !par1IBlockAccess
						.isBlockOpaqueCube(par2, par3, par4))))));
	}
}
