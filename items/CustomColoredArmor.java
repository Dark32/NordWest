package mods.nordwest.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.nordwest.common.CustomItems;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class CustomColoredArmor extends CustomArmor {
	private final EnumArmorMaterial material;

	public CustomColoredArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.material = par2EnumArmorMaterial;
	}

	//@SideOnly(Side.CLIENT)
	//public boolean requiresMultipleRenderPasses() {
	//	return true;
	//}

	/**
	 * Return whether the specified armor ItemStack has a color.
	 */
	public boolean hasColor(ItemStack par1ItemStack) {
		return this.material != CustomItems.samuraiArmorMaterial ? false : (!par1ItemStack.hasTagCompound() ? false : (!par1ItemStack.getTagCompound().hasKey("display") ? false : par1ItemStack.getTagCompound()
				.getCompoundTag("display").hasKey("color")));
	}

	public int getColor(ItemStack par1ItemStack) {
		if (!true) {
			return -1;
		} else {
			NBTTagCompound nbttagcompound = par1ItemStack.getTagCompound();

			if (nbttagcompound == null) {
				return 0xa06540;
			} else {
				NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");
				return nbttagcompound1 == null ? 0xa06540 : (nbttagcompound1.hasKey("color") ? nbttagcompound1.getInteger("color") : 0xa06540);
			}
		}
	}

	/**
	 * Remove the color from the specified armor ItemStack.
	 */
	public void removeColor(ItemStack par1ItemStack) {
		if (true) {
			NBTTagCompound nbttagcompound = par1ItemStack.getTagCompound();

			if (nbttagcompound != null) {
				NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");

				if (nbttagcompound1.hasKey("color")) {
					nbttagcompound1.removeTag("color");
				}
			}
		}
	}

	public void func_82813_b(ItemStack par1ItemStack, int par2) {
		if (!true) {
			throw new UnsupportedOperationException("Can\'t dye non-leather!");
		} else {
			NBTTagCompound nbttagcompound = par1ItemStack.getTagCompound();

			if (nbttagcompound == null) {
				nbttagcompound = new NBTTagCompound();
				par1ItemStack.setTagCompound(nbttagcompound);
			}

			NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");

			if (!nbttagcompound.hasKey("display")) {
				nbttagcompound.setCompoundTag("display", nbttagcompound1);
			}

			nbttagcompound1.setInteger("color", par2);
		}
	}
}
