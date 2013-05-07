package mods.nordwest.items;

import mods.nordwest.common.CustomItems;
import mods.nordwest.common.NordWest;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomSword extends ItemSword
{
    private int weaponDamage;
    private final EnumToolMaterial toolMaterial;

    public CustomSword(int id, EnumToolMaterial enumtoolmaterial)
    {
        super(id, enumtoolmaterial);
        toolMaterial = enumtoolmaterial;
        maxStackSize = 1;
        setMaxDamage(enumtoolmaterial.getMaxUses());
        weaponDamage = 4 + enumtoolmaterial.getDamageVsEntity();
		setCreativeTab(NordWest.tabNord);
    }
    
    public CustomSword(int id, EnumToolMaterial enumtoolmaterial, float multiple)
    {
        super(id, enumtoolmaterial);
        toolMaterial = enumtoolmaterial;
        maxStackSize = 1;
        setMaxDamage((int)(enumtoolmaterial.getMaxUses()*multiple));
        weaponDamage = (int) ((4 + enumtoolmaterial.getDamageVsEntity())*multiple);
		setCreativeTab(NordWest.tabNord);
    }
    
    @Override
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("nordwest:" + this.getUnlocalizedName());
	}

    @Override
    public float getStrVsBlock(ItemStack itemstack, Block block)
    {
        return block.blockID != Block.web.blockID ? 1.5F : 15F;
    }

    @Override
    public boolean hitEntity(ItemStack itemstack, EntityLiving entityplayer, EntityLiving entityliving)
    {
        itemstack.damageItem(1, entityliving);
        return true;
    }
    
    @Override
    public boolean onBlockDestroyed(ItemStack itemstack, World world, int x, int y, int z, int facing, EntityLiving entityplayer)
    {
        itemstack.damageItem(2, entityplayer);
        return true;
    }

    @Override
    public int getDamageVsEntity(Entity entity)
    {
        return weaponDamage;
    }

    @Override
    public boolean isFull3D()
    {
        return true;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack itemstack)
    {
        return EnumAction.block;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack itemstack)
    {
        return 0x11940;
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        entityplayer.setItemInUse(itemstack, getMaxItemUseDuration(itemstack));
        return itemstack;
    }

    @Override
    public boolean canHarvestBlock(Block block)
    {
        return block.blockID == Block.web.blockID;
    }

    @Override
    public int getItemEnchantability()
    {
        return toolMaterial.getEnchantability();
    }
}
