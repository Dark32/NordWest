package mods.nordwest.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.nordwest.common.Config;
import mods.nordwest.common.NordWest;
import mods.nordwest.tileentity.TileEntityExtractor;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class Extractor extends BlockContainer {

	private Icon iconTop;
	private Icon iconSide;
	private Icon iconDown;

	public Extractor(int par1) {
		super(par1, Material.rock);
		setCreativeTab(NordWest.tabNord);
		this.setBlockBounds(0.0f, 0.0F, 0.0f, 1.0F, 1.0F, 1.0f);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		this.iconTop = par1IconRegister.registerIcon("nordwest:" + this.getUnlocalizedName2() + "_top");
		this.iconSide = par1IconRegister.registerIcon("nordwest:" + this.getUnlocalizedName2() + "_side");
		this.iconDown = par1IconRegister.registerIcon("nordwest:" + this.getUnlocalizedName2() + "_down");
	}
	@Override
	public MovingObjectPosition collisionRayTrace(World par1World, int par2, int par3, int par4, Vec3 par5Vec3, Vec3 par6Vec3) {
		this.setBlockBounds(0.0f, 0.0F, 0.0f, 1.0F, 1.0F, 1.0f);
		return super.collisionRayTrace(par1World, par2, par3, par4, par5Vec3, par6Vec3);
	}
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int par1, int par2) {
		if (par1 == 1) {
			return this.iconTop;
		} else if (par1 == 0) {
			return this.iconDown;
		} else {
			return this.iconSide;
		}
	}
	public int getRenderType() {
		return Config.ExtractorRendererID;
	}
	public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
	}
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntityExtractor();
	}
	 public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	    {
	        if (world.isRemote)
	        {
	            return true;
	        }
	        else
	        {
	        	TileEntityExtractor tileentity = (TileEntityExtractor)world.getBlockTileEntity(x, y, z);

	            if (tileentity != null)
	            {
	                //par5EntityPlayer.displayGUIFurnace(tileentity);
	            	par5EntityPlayer.openGui(NordWest.instance, 1, world, x, y, z);
	            }

	            return true;
	        }
	    }
}
