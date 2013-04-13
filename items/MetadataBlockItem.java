package mods.nordwest.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.nordwest.common.NordWest;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class MetadataBlockItem extends ItemBlock {
	public MetadataBlockItem(int par1) {
		super(par1);
		setMaxDamage(0);
		setHasSubtypes(true);
	}
	@SideOnly(Side.CLIENT)
	private Block getBlock() {
		return Block.blocksList[getBlockID()];
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getColorFromItemStack(ItemStack itemstack, int par2) {
		return getBlock().getRenderColor(itemstack.getItemDamage());
	}
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIconFromDamage(int md) {
		return getBlock().getIcon(0, md);
	}
	
	@Override
	public int getMetadata(int damage) {
		return damage;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		return super.getUnlocalizedName(itemstack) + "." + itemstack.getItemDamage();
	}
}
