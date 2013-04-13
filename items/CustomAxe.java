package mods.nordwest.items;

import mods.nordwest.common.CustomItems;
import mods.nordwest.common.NordWest;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomAxe extends ItemAxe
{
    private static Block blocksEffectiveAgainst[];

    public CustomAxe(int id, EnumToolMaterial enumtoolmaterial)
    {
        super(id, enumtoolmaterial);
		setCreativeTab(NordWest.tabNord);
    }
    @Override
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("nordwest:" + this.getUnlocalizedName());
	}

    @Override
    public float getStrVsBlock(ItemStack itemstack, Block block)
    {
        if (block != null && block.blockMaterial == Material.wood)
        {
            return efficiencyOnProperMaterial;
        }
        else
        {
            return super.getStrVsBlock(itemstack, block);
        }
    }

    static
    {
        blocksEffectiveAgainst = (new Block[]
                {
                    Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.woodSingleSlab, Block.woodDoubleSlab, Block.pumpkin, Block.pumpkinLantern
                });
    }
}
