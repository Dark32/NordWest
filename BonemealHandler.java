package mods.mod_nw;

import mods.mod_nw.Block.DarkSakuraSapling;
import net.minecraft.block.Block;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class BonemealHandler {

	@ForgeSubscribe
	public void onUseBonemeal(BonemealEvent e) {
		if (!e.world.isRemote) {

			//System.out.print(NWBlock.dsakuraSapling);
			if (e.getResult() == Result.DEFAULT && e.ID == NWBlock.dsakuraSapling.blockID) {
				((DarkSakuraSapling) NWBlock.dsakuraSapling).growTree(e.world, e.X, e.Y, e.Z, e.world.rand);
			}
		}

	}
}
