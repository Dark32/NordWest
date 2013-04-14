package mods.nordwest.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.nordwest.common.CustomItems;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;

public class CustomColoredArmor extends CustomArmor {
	private final EnumArmorMaterial material;
	private Icon iconOverlay;
	private Icon icon;

	//	public final int damageReduceAmount;

	public CustomColoredArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.material = par2EnumArmorMaterial;
		//this.material.customCraftingMaterial=Item.silk;
		//this.damageReduceAmount = par2EnumArmorMaterial.getDamageReductionAmount(par4);
		// this.setMaxDamage(par2EnumArmorMaterial.getDurability(par4));
		//this.material.setDurability(par2EnumArmorMaterial.getDurability(par4));
	}

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return true;
	}

	@Override
	public boolean hasColor(ItemStack par1ItemStack) {
		return this.material != CustomItems.samuraiArmorMaterial ? false : (!par1ItemStack.hasTagCompound() ? false
				: (!par1ItemStack.getTagCompound().hasKey("display") ? false : par1ItemStack.getTagCompound()
						.getCompoundTag("display").hasKey("color")));
	}

	@Override
	public int getColor(ItemStack par1ItemStack) {
		if (!true) {
			return -1;
		} else {
			NBTTagCompound nbttagcompound = par1ItemStack.getTagCompound();

			if (nbttagcompound == null) {
				return 0xa01401;
			} else {
				NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");
				return nbttagcompound1 == null ? 0xa06540 : (nbttagcompound1.hasKey("color") ? nbttagcompound1
						.getInteger("color") : 0xa06540);
			}
		}
	}

	@Override
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

	@Override
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

	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIconFromDamageForRenderPass(int par1, int par2) {
		return par2 == 1 ? this.iconOverlay : super.getIconFromDamageForRenderPass(par1, par2);
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		super.registerIcons(iconRegister);

		if (true) {
			this.iconOverlay = iconRegister.registerIcon("nordwest:" + this.getUnlocalizedName() + ".overlay");
		}

		this.icon = iconRegister.registerIcon("nordwest:" + this.getUnlocalizedName());
	}
}
