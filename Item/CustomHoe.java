package mods.mod_nw.Item;

import mods.mod_nw.NWItem;
import mods.mod_nw.NordWest;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemHoe;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomHoe extends ItemHoe
{
    protected EnumToolMaterial toolMaterial;

    public CustomHoe(int id, EnumToolMaterial enumtoolmaterial)
    {
        super(id, enumtoolmaterial);
        toolMaterial = enumtoolmaterial;
        maxStackSize = 1;
        setMaxDamage(enumtoolmaterial.getMaxUses());
        setCreativeTab(CreativeTabs.tabTools);
		setCreativeTab(NordWest.tabNord);
    }
    
	public void updateIcons(IconRegister iconRegister) {
		iconIndex = iconRegister.registerIcon("mod_nw:" + this.getUnlocalizedName());
	}

    @Override
    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int x, int y, int z, int side, float entityX, float entityY, float entityZ)
    {
        if (!entityplayer.canPlayerEdit(x, y, z, side, itemstack))
        {
            return false;
        }
        else
        {
            UseHoeEvent event = new UseHoeEvent(entityplayer, itemstack, world, x, y, z);
            if(MinecraftForge.EVENT_BUS.post(event))
            {
                return false;
            }

            if(event.getResult() == Result.ALLOW)
            {
                itemstack.damageItem(1, entityplayer);
                return true;
            }

            int blockID = world.getBlockId(x, y, z);
            int aboveBlockID = world.getBlockId(x, y + 1, z);

            if((side == 0 || aboveBlockID != 0 || blockID != Block.grass.blockID) && blockID != Block.dirt.blockID)
            {
                return false;
            }
            else {
                Block block = Block.tilledField;
                world.playSoundEffect(x + 0.5F, y + 0.5F, z + 0.5F, block.stepSound.getStepSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);

                if (world.isRemote)
                {
                    return true;
                }
                else {
                    world.setBlock(x, y, z, block.blockID);
                    itemstack.damageItem(1, entityplayer);
                    return true;
                }
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }
}