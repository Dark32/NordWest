package mods.nordwest.items;

import mods.nordwest.common.CustomItems;
import mods.nordwest.common.NordWest;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomPickaxe extends ItemPickaxe
{
    private static Block blocksEffectiveAgainst[];

    public CustomPickaxe(int id, EnumToolMaterial enumtoolmaterial)
    {
        super(id, enumtoolmaterial);
		setCreativeTab(NordWest.tabNord);
    }
    @Override
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("nordwest:" + this.getUnlocalizedName());
	}

    @Override
    public boolean canHarvestBlock(Block block)
    {
        if (block == Block.obsidian)
        {
            return toolMaterial.getHarvestLevel() == 3;
        }

        if (block == Block.blockDiamond || block == Block.oreDiamond)
        {
            return toolMaterial.getHarvestLevel() >= 2;
        }

        if (block == Block.blockGold || block == Block.oreGold)
        {
            return toolMaterial.getHarvestLevel() >= 2;
        }

        if (block == Block.blockIron || block == Block.oreIron)
        {
            return toolMaterial.getHarvestLevel() >= 1;
        }

        if (block == Block.blockLapis || block == Block.oreLapis)
        {
            return toolMaterial.getHarvestLevel() >= 1;
        }

        if (block == Block.oreRedstone || block == Block.oreRedstoneGlowing)
        {
            return toolMaterial.getHarvestLevel() >= 2;
        }

        if (block.blockMaterial == Material.rock)
        {
            return true;
        }

        return block.blockMaterial == Material.iron;
    }

    @Override
    public float getStrVsBlock(ItemStack itemstack, Block block)
    {
        if (block != null && (block.blockMaterial == Material.iron || block.blockMaterial == Material.rock))
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
                    Block.cobblestone, Block.stoneSingleSlab, Block.stoneDoubleSlab, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.blockIron, Block.oreCoal, Block.blockGold,
                    Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis, Block.oreRedstone, Block.oreRedstoneGlowing, Block.rail,
                    Block.railDetector, Block.railPowered
                });
    }
}