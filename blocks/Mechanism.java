package mods.nordwest.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.nordwest.common.Config;
import mods.nordwest.common.CustomBlocks;
import mods.nordwest.common.NordWest;
import mods.nordwest.tileentity.TileEntityExtractor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Mechanism extends BlockContainer {

	private Icon iconTop;
	private Icon iconSide;
	private Icon iconDown;
	private Icon distiller;
	private Icon cooler;

	public Mechanism(int par1) {
		super(par1, Material.rock);
		setCreativeTab(NordWest.tabNord);
		this.setBlockBounds(0.0f, 0.0F, 0.0f, 1.0F, 1.0F, 1.0f);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		this.iconTop = par1IconRegister.registerIcon("nordwest:extractor_top");
		this.iconSide = par1IconRegister.registerIcon("nordwest:extractor_side");
		this.iconDown = par1IconRegister.registerIcon("nordwest:extractor_down");
		this.distiller = par1IconRegister.registerIcon("nordwest:distiller");
		this.cooler = par1IconRegister.registerIcon("nordwest:cooler");
	}

	@Override
	public MovingObjectPosition collisionRayTrace(World par1World, int par2, int par3, int par4, Vec3 par5Vec3, Vec3 par6Vec3) {
		this.setBlockBounds(0.0f, 0.0F, 0.0f, 1.0F, 1.0F, 1.0f);
		return super.collisionRayTrace(par1World, par2, par3, par4, par5Vec3, par6Vec3);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int par1, int par2) {
		if (par2 == 0) {
			if (par1 == 1) {
				return this.iconTop;
			} else if (par1 == 0) {
				return this.iconDown;
			} else {
				return this.iconSide;
			}
		} else if (par2 == 1) {
			if (par1 > 1) {
				return this.distiller;
			} else {
				return Block.furnaceIdle.getBlockTextureFromSide(0);
			}
		} else if (par2 == 2) {
			if (par1 > 1) {
				return this.cooler;
			} else {
				return Block.furnaceIdle.getBlockTextureFromSide(0);
			}
		} else if (par2 == 3) {
			if (par1 != 6) {
				return Block.planks.getIcon(0, 0);
			} else {
				return Block.waterMoving.getBlockTextureFromSide(0);
			}
		}
		return this.iconSide;
	}

	public int getRenderType() {
		return Config.ExtractorRendererID;
	}

	public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {
		int meta = par1World.getBlockMetadata(par2, par3, par4);
		if (meta == 3) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
			float f = 0.125F;
			this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
			this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
			this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
			this.setBlockBoundsForItemRender();
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else {

			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);

		}
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityExtractor();
	}

	@Override
	public TileEntity createTileEntity(World world, int metadata) {
		switch (metadata) {
		case 0:
			return new TileEntityExtractor();
		default:
			return null;
		}

	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		if (!world.isRemote) {
			int meta = world.getBlockMetadata(x, y, z);
			TileEntity tileentity = world.getBlockTileEntity(x, y, z);
			//System.out.println(tileentity);
			if (tileentity != null) {
				if (meta == 0) {
					par5EntityPlayer.openGui(NordWest.instance, 1, world, x, y, z);
					return true;
				}
				if (meta == 1) {
					par5EntityPlayer.openGui(NordWest.instance, 0, world, x, y, z);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, 1));
		par3List.add(new ItemStack(par1, 1, 2));
		par3List.add(new ItemStack(par1, 1, 3));
	}

	@Override
	public int damageDropped(int par1) {
		return par1;
	}

	public int getRenderBlockPass() {
		return 1;
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {

		return true;
	}
}
