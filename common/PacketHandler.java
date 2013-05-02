package mods.nordwest.common;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import mods.nordwest.tileentity.ITileNetSync;
import mods.nordwest.tileentity.TileEntityAltar;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {
/**
 * packet type
 * 0x001 - GuiAltar
 */
	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
		EntityPlayer entityplayer = (EntityPlayer) player;
		if (packet.channel.equals("NordWest")) {
			try {
				int packetType = inputStream.readInt();//получаем тип пакета
				if (packetType == 0x001) {// если Алтарь
						int x = inputStream.readInt();// читаем координаты
						int y = inputStream.readInt();
						int z = inputStream.readInt();
						World world = entityplayer.worldObj;
						TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
						if (tileEntity instanceof ITileNetSync) {// если содержит интерфейс синхронизации
							((ITileNetSync)tileEntity).handlePacketData(inputStream); // синхронизируем
						}
				}
			} catch (IOException e) {
				e.printStackTrace();
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
