package mods.nordwest.blocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import mods.nordwest.common.NordWest;
import mods.nordwest.generators.WorldGenBigCustomTrees;
import mods.nordwest.generators.WorldGenCustomTree;
import mods.nordwest.generators.WorldGenCustomTree2;
import mods.nordwest.generators.WorldGenHugeTree;
import mods.nordwest.generators.WorldGenMagicTree;
import mods.nordwest.generators.WorldGenSakuraForest;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenHugeTrees;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

public class CustomTreeSapling extends BlockFlower {
	@SideOnly(Side.CLIENT)
	private Icon[] Icons;
	private String type = "";

	public CustomTreeSapling(int par1)

	{
		super(par1);
		float f = 0.4F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
		this.setCreativeTab(NordWest.tabNord);
	}

	public CustomTreeSapling(int par1, String type)

	{
		super(par1);
		float f = 0.4F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
		this.setCreativeTab(NordWest.tabNord);
		this.type = type;
	}
	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		if (!par1World.isRemote) {
			super.updateTick(par1World, par2, par3, par4, par5Random);

			if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9 && par5Random.nextInt(7) == 0) {
				this.func_96477_c(par1World, par2, par3, par4, par5Random);
			}
		}
	}
	//@Override
	public void func_96477_c(World par1World, int par2, int par3, int par4, Random par5Random) {
		int l = par1World.getBlockMetadata(par2, par3, par4);

		if ((l & 8) == 0) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, l | 8, 4);
		} else {
			this.growTree(par1World, par2, par3, par4, par5Random);
		}
	}
	//@Override
	public void growTree(World par1World, int par2, int par3, int par4, Random par5Random) {
		// if (!TerrainGen.saplingGrowTree(par1World, par5Random, par2, par3,
		// par4)) return;

		int l = par1World.getBlockMetadata(par2, par3, par4) & 3;
		Object object = null;
		int i1 = 0;
		int j1 = 0;
		boolean flag = false;

		if (l == 2) {
			object = new WorldGenCustomTree2(true);
		} else if (l == 1) {
			object = new WorldGenSakuraForest(true);
		} else if (l == 3) {
			for (i1 = 0; i1 >= -1; --i1) {
				for (j1 = 0; j1 >= -1; --j1) {
					if (this.isSameSapling(par1World, par2 + i1, par3, par4 + j1, 3)
							&& this.isSameSapling(par1World, par2 + i1 + 1, par3, par4 + j1, 3)
							&& this.isSameSapling(par1World, par2 + i1, par3, par4 + j1 + 1, 3)
							&& this.isSameSapling(par1World, par2 + i1 + 1, par3, par4 + j1 + 1, 3)) {
						object = new WorldGenHugeTree(true, 7 + par5Random.nextInt(10), 3, 3);
						flag = true;
						break;
					}
				}

				if (object != null) {
					break;
				}
			}

			if (object == null) {
				j1 = 0;
				i1 = 0;
				object = new WorldGenCustomTree(true, 4 + par5Random.nextInt(7), 3, 3, false);
			}
		} else {
			object = new WorldGenCustomTree(true);

			if (par5Random.nextInt(1) == 0) {
				object = new WorldGenBigCustomTrees(true);
			}
		}
		if (this.type.equals("magic")){
			object = new WorldGenMagicTree(true,3,l,l,false);
			
		}
		if (flag) {
			par1World.setBlock(par2 + i1, par3, par4 + j1, 0, 0, 4);
			par1World.setBlock(par2 + i1 + 1, par3, par4 + j1, 0, 0, 4);
			par1World.setBlock(par2 + i1, par3, par4 + j1 + 1, 0, 0, 4);
			par1World.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, 0, 0, 4);
		} else {
			par1World.setBlock(par2, par3, par4, 0, 0, 4);
		}

		if (!((WorldGenerator) object).generate(par1World, par5Random, par2 + i1, par3, par4 + j1)) {
			if (flag) {
				par1World.setBlock(par2 + i1, par3, par4 + j1, this.blockID, l, 4);
				par1World.setBlock(par2 + i1 + 1, par3, par4 + j1, this.blockID, l, 4);
				par1World.setBlock(par2 + i1, par3, par4 + j1 + 1, this.blockID, l, 4);
				par1World.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, this.blockID, l, 4);
			} else {
				par1World.setBlock(par2, par3, par4, this.blockID, l, 4);
			}
		}
	}

	/**
	 * Determines if the same sapling is present at the given location.
	 */
	public boolean isSameSapling(World par1World, int par2, int par3, int par4, int par5) {
		return par1World.getBlockId(par2, par3, par4) == this.blockID
				&& (par1World.getBlockMetadata(par2, par3, par4) & 3) == par5;
	}

	@Override
	public int damageDropped(int par1) {
		return par1 & 3;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, 1));
		par3List.add(new ItemStack(par1, 1, 2));
		par3List.add(new ItemStack(par1, 1, 3));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		this.Icons = new Icon[4];

		for (int i = 0; i < this.Icons.length; ++i) {
			this.Icons[i] = par1IconRegister.registerIcon("nordwest:" + this.getUnlocalizedName2() + "." + i);
		}
	}
	@Override
	public Icon getIcon(int par1, int par2) {
		par2 &= 3;
		return this.Icons[par2];
	}
}
