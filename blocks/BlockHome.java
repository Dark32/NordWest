package mods.nordwest.blocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.nordwest.common.CustomBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockHome extends BaseBlock {
	@SideOnly(Side.CLIENT)
	private Icon[] iconArray;

	public BlockHome(int par1) {
		super(par1, Material.rock);
	}

	@SideOnly(Side.CLIENT)
	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	public void registerIcons(IconRegister par1IconRegister) {
		this.iconArray = new Icon[3];

		this.iconArray[0] = par1IconRegister.registerIcon("nordwest:" + this.getUnlocalizedName2() + ".side");
		this.iconArray[1] = par1IconRegister.registerIcon("nordwest:" + this.getUnlocalizedName2() + ".top");
		this.iconArray[2] = par1IconRegister.registerIcon("nordwest:" + this.getUnlocalizedName2() + ".buttom");

	}

	@SideOnly(Side.CLIENT)
	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata!
	 */
	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2) {
		if (par1 == 0)
			return this.iconArray[2];
		if (par1 == 1)
			return this.iconArray[1];
		return this.iconArray[0];
	}

	public void randomDisplayTick(World par1World, int x, int y, int z, Random random) {
		super.randomDisplayTick(par1World, x, y, z, random);
		if (testBlock(par1World, x, y, z)) {
			for (int i = x - 2; i < x + 3; i++) {
				for (int j = y; j < y + 4; j++) {
					for (int k = z - 2; k < z + 3; k++) {
						if (random.nextInt(16) == 0) {
							par1World.spawnParticle("portal", 
									i + random.nextDouble(), 
									j + random.nextDouble(), 
									k + random.nextDouble(),
									0, 0, 0);
						}
					}
				}
			}
		}

	}

	private boolean testBlock(World world, int x, int y, int z) {
		int id = world.getBlockId(x, y, z);
		if (id != CustomBlocks.blockhome.blockID) {
			return false;
		} else {
			boolean test = true;
			for (int i = 0; i < 4; i++) {
				test &= world.getBlockId(x + 2, y + i, z + 2) == Block.obsidian.blockID;
				test &= world.getBlockId(x - 2, y + i, z + 2) == Block.obsidian.blockID;
				test &= world.getBlockId(x + 2, y + i, z - 2) == Block.obsidian.blockID;
				test &= world.getBlockId(x - 2, y + i, z - 2) == Block.obsidian.blockID;
			}
			return test;
		}
	}
}
