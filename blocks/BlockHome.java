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
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
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
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		this.iconArray = new Icon[3];

		this.iconArray[0] = par1IconRegister.registerIcon("nordwest:" + this.getUnlocalizedName2() + ".side");
		this.iconArray[1] = par1IconRegister.registerIcon("nordwest:" + this.getUnlocalizedName2() + ".top");
		this.iconArray[2] = par1IconRegister.registerIcon("nordwest:" + this.getUnlocalizedName2() + ".buttom");
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		Random random = new Random();
		if (world.provider.dimensionId == 1) {
			int dropChance = random.nextInt(10);
			world.createExplosion((Entity)null, x, y, z, 2.0F, false);
			if (dropChance <= 7) {
			world.destroyBlock(x, y, z, true);
			} else {
			world.destroyBlock(x, y, z, false);
			}
		}/** else {
			if (homeGui(world, x, y, z, player) == true) {
				
			} else {
				world.destroyBlock(x, y, z, true);
			}
		}*/
	}
	
	/**public boolean homeGui(World world, int x, int y, int z, EntityPlayer player){
		player.openGui(Tutorial.instance, 3, world, x, y, z);
	}*/
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int par1, int par2) {
		if (par1 == 0)
			return this.iconArray[2];
		if (par1 == 1)
			return this.iconArray[1];
		return this.iconArray[0];
	}
	
	@Override
	public void randomDisplayTick(World par1World, int x, int y, int z, Random random) {
		super.randomDisplayTick(par1World, x, y, z, random);
		if (testBlock(par1World, x, y, z)) {
			for (int i = x - 2; i < x + 3; i++) {
				for (int j = y; j < y + 4; j++) {
					for (int k = z - 2; k < z + 3; k++) {
						if (random.nextInt(16) == 0) {
							par1World.spawnParticle("portal", i + random.nextDouble(), j + random.nextDouble(), k
									+ random.nextDouble(), 0, 0, 0);
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
