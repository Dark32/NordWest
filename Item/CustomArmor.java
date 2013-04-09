package mods.mod_nw.Item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.mod_nw.NordWest;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class CustomArmor extends ItemArmor {
	private String armorRender;
	public CustomArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		setCreativeTab(NordWest.tabNord);
	}

	public void updateIcons(IconRegister iconRegister) {
		iconIndex = iconRegister.registerIcon("mod_nw:" + this.getUnlocalizedName());
	}



}