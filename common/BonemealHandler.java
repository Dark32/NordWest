package mods.nordwest.common;

import mods.nordwest.blocks.CustomTreeSapling;
import net.minecraft.block.Block;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class BonemealHandler {

	@ForgeSubscribe
	public void onUseBonemeal(BonemealEvent e) {
		if (!e.world.isRemote) {

			//System.out.print(CustomBlock.customTreeSapling);
			if (e.getResult() == Result.DEFAULT && e.ID == CustomBlocks.customTreeSapling.blockID) {
				((CustomTreeSapling) CustomBlocks.customTreeSapling).func_96477_c(e.world, e.X, e.Y, e.Z, e.world.rand);
			}
			if (e.getResult() == Result.DEFAULT && e.ID == CustomBlocks.magicTreeSapling.blockID) {
				((CustomTreeSapling) CustomBlocks.magicTreeSapling).func_96477_c(e.world, e.X, e.Y, e.Z, e.world.rand);
			}
		}

	}
}
