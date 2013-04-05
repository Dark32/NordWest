package mods.mod_nw;

import mods.mod_nw.Block.CustomTreeSapling;
import net.minecraft.block.Block;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class BonemealHandler {

	@ForgeSubscribe
	public void onUseBonemeal(BonemealEvent e) {
		if (!e.world.isRemote) {

			//System.out.print(NWBlock.customTreeSapling);
			if (e.getResult() == Result.DEFAULT && e.ID == NWBlock.customTreeSapling.blockID) {
				((CustomTreeSapling) NWBlock.customTreeSapling).growTree(e.world, e.X, e.Y, e.Z, e.world.rand);
			}
		}

	}
}
