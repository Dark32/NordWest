package mods.nordwest.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.nordwest.common.Config;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class Extractor extends BaseBlock {

	private Icon iconTop;
	private Icon iconSide;
	private Icon iconDown;

	public Extractor(int par1) {
		super(par1, Material.rock);
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
}
