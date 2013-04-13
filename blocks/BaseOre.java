package mods.nordwest.blocks;

import java.util.Random;

import mods.nordwest.common.NordWest;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BaseOre extends Block {
	private int drop_id;
	private int quantaty = 1;
	private int minQuantaty = 0;
	private int xp = 0;

	public BaseOre(int id, Material par2Material, int drop_id, int quantaty, int minQuantaty) {
		super(id, par2Material);
		this.drop_id = drop_id;
		this.quantaty = quantaty;
		setCreativeTab(NordWest.tabNord);
		this.minQuantaty = minQuantaty;
	}
	public BaseOre(int id, Material par2Material, int drop_id, int quantaty, int minQuantaty,int xp) {
		super(id, par2Material);
		this.drop_id = drop_id;
		this.quantaty = quantaty;
		setCreativeTab(NordWest.tabNord);
		this.minQuantaty = minQuantaty;
		this.xp = xp;
	}
	public BaseOre(int id, Material par2Material, int drop_id, int quantaty) {
		super(id, par2Material);
		this.drop_id = drop_id;
		this.quantaty = quantaty;
		setCreativeTab(NordWest.tabNord);
		this.minQuantaty = 0;

	}

	public BaseOre(int id, Material par2Material) {
		super(id, par2Material);
		this.drop_id = id;
		setCreativeTab(NordWest.tabNord);
	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return drop_id;
	}

	@Override
	public int quantityDropped(Random par1Random) {
		return par1Random.nextInt(quantaty) + minQuantaty;
	}

	/**
	 * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i'
	 * (inclusive).
	 */
	@Override
	public int quantityDroppedWithBonus(int par1, Random par2Random) {
		if (par1 > 0 && this.blockID != this.idDropped(0, par2Random, par1)) {
			int j = par2Random.nextInt(par1 + 2) - 1;

			if (j < 0) {
				j = 0;
			}

			return this.quantityDropped(par2Random) * (j + 1);
		} else {
			return this.quantityDropped(par2Random);
		}
	}
	@Override
	public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7) {
		super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
		int j1 = MathHelper.getRandomIntegerInRange(par1World.rand, xp, xp+5);
		this.dropXpOnBlockBreak(par1World, par2, par3, par4, (quantaty > 1 && xp>0) ? j1 : 0);

	}
	@Override
	public void registerIcons(IconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon("nordwest:" + this.getUnlocalizedName2());
	}
}
