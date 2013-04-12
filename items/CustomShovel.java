package mods.nordwest.items;

import mods.nordwest.common.CustomItems;
import mods.nordwest.common.NordWest;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemTool;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomShovel extends ItemTool
{
    private static Block blocksEffectiveAgainst[];

    public CustomShovel(int id, EnumToolMaterial enumtoolmaterial)
    {
        super(id, 1, enumtoolmaterial, blocksEffectiveAgainst);
		setCreativeTab(NordWest.tabNord);
    }
    
	public void updateIcons(IconRegister iconRegister) {
		iconIndex = iconRegister.registerIcon("nordwest:" + this.getUnlocalizedName());
	}

    @Override
    public boolean canHarvestBlock(Block block)
    {
        if (block == Block.snow)
        {
            return true;
        }

        return block == Block.blockSnow;
    }

    static
    {
        blocksEffectiveAgainst = (new Block[]
                {
                    Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium
                });
    }
}