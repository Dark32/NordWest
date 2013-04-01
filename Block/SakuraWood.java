package mods.mod_nw.Block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class SakuraWood extends BaseMetadataBlock {
	@SideOnly(Side.CLIENT)
	private Icon[] iconArray;
	@SideOnly(Side.CLIENT)
	private Icon[] tree_topArray;

	public SakuraWood(int par1) {
		super(par1, Material.wood, 4);
	}

	public int getRenderType() {
		return 31;
	}

	/**
	 * ejects contained items into the world, and notifies neighbours of an
	 * update, as appropriate
	 */
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6) {
		byte b0 = 4;
		int j1 = b0 + 1;

		if (par1World.checkChunksExist(par2 - j1, par3 - j1, par4 - j1, par2 + j1, par3 + j1, par4 + j1)) {
			for (int k1 = -b0; k1 <= b0; ++k1) {
				for (int l1 = -b0; l1 <= b0; ++l1) {
					for (int i2 = -b0; i2 <= b0; ++i2) {
						int j2 = par1World.getBlockId(par2 + k1, par3 + l1, par4 + i2);

						if (Block.blocksList[j2] != null) {
							Block.blocksList[j2].beginLeavesDecay(par1World, par2 + k1, par3 + l1, par4 + i2);
						}
					}
				}
			}
		}
	}

	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7,
			float par8, int par9) {
		int j1 = par9 & 3;
		byte b0 = 0;

		switch (par5) {
		case 0:
		case 1:
			b0 = 0;
			break;
		case 2:
		case 3:
			b0 = 8;
			break;
		case 4:
		case 5:
			b0 = 4;
		}

		return j1 | b0;
	}

	public int damageDropped(int par1) {
		return par1 & 3;
	}

	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2) {
		int k = par2 & 12;
		int l = par2 & 3;
		return k == 0 && (par1 == 1 || par1 == 0) ? this.tree_topArray[l]
				: (k == 4 && (par1 == 5 || par1 == 4) ? this.tree_topArray[l]
						: (k == 8 && (par1 == 2 || par1 == 3) ? this.tree_topArray[l] : this.iconArray[l]));
	}

	public static int limitToValidMetadata(int par0) {
		return par0 & 3;
	}

	protected ItemStack createStackedBlock(int par1) {
		return new ItemStack(this.blockID, 1, limitToValidMetadata(par1));
	}

	public void registerIcons(IconRegister par1IconRegister) {
		String path = "mod_nw:" + this.getUnlocalizedName2() + ".";
		this.iconArray = new Icon[4];
		this.tree_topArray = new Icon[4];
		for (int i = 0; i < this.iconArray.length; ++i) {
			this.iconArray[i] = par1IconRegister.registerIcon(path + i);
			this.tree_topArray[i] = par1IconRegister.registerIcon(path + "top." + i);

		}
	}

	@Override
	public boolean canSustainLeaves(World world, int x, int y, int z) {
		return true;
	}

	@Override
	public boolean isWood(World world, int x, int y, int z) {
		return true;
	}
}
