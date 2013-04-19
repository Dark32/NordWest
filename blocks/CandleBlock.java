package mods.nordwest.blocks;

import static net.minecraftforge.common.ForgeDirection.EAST;
import static net.minecraftforge.common.ForgeDirection.NORTH;
import static net.minecraftforge.common.ForgeDirection.SOUTH;
import static net.minecraftforge.common.ForgeDirection.WEST;

import java.util.List;
import java.util.Random;

import mods.nordwest.client.renders.BlockCandleRenderer;
import mods.nordwest.common.Config;
import mods.nordwest.common.NordWest;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class CandleBlock extends BaseBlock {

	public CandleBlock(int par1, Material par2Material) {
		super(par1, Material.circuits);
		setCreativeTab(NordWest.tabNord);
	}
	
    public int getRenderType()
    {
        return Config.CandleRendererID;
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
   public void randomDisplayTick(World par1World, int x, int y, int z, Random random) {
         double a = x + 0.5F;
         double b = y + 0.7F;
         double c = z + 0.5F;
     
         par1World.spawnParticle("smoke", a, b, c, 0.0D, 0.0D, 0.0D);
         par1World.spawnParticle("flame", a, b, c, 0.0D, 0.0D, 0.0D);
   }
   
   public MovingObjectPosition collisionRayTrace(World par1World, int par2, int par3, int par4, Vec3 par5Vec3, Vec3 par6Vec3)
   {
	   this.setBlockBounds(0.375F, 0.0F, 0.375F, 0.625F, 0.5F, 0.625F);
       return super.collisionRayTrace(par1World, par2, par3, par4, par5Vec3, par6Vec3);
   }
   
	@Override
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
			for (int i = 0; i < 16; ++i) {
				par3List.add(new ItemStack(par1, 1, i));
			}

	}
	
	public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity)
    {
		this.setBlockBounds(0.375F, 0.0F, 0.375F, 0.625F, 0.5F, 0.625F);
        super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
    }
	
    private boolean canPlaceCandleOn(World par1World, int par2, int par3, int par4)
    {
        if (par1World.doesBlockHaveSolidTopSurface(par2, par3, par4))
        {
            return true;
        }
        else
        {
            int l = par1World.getBlockId(par2, par3, par4);
            return (Block.blocksList[l] != null && Block.blocksList[l].canPlaceTorchOnTop(par1World, par2, par3, par4));
        }
    }
	
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return canPlaceCandleOn(par1World, par2, par3 - 1, par4);
    }
	
	 public int colorMultiplier(IBlockAccess par1IBlockAccess, int x, int y, int z)
	    {
	            return BlockCandleRenderer.colors[par1IBlockAccess.getBlockMetadata(x, y, z)];
	        }
	}
