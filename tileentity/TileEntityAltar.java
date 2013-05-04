package mods.nordwest.tileentity;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import com.google.common.io.ByteArrayDataInput;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.network.PacketDispatcher;

public class TileEntityAltar extends TileEntity implements ITileNetSync {
	public String name = "Unknown";
	public String owner = "Unknown";
	public int stage;

	@Override
	public void readFromNBT(NBTTagCompound nbtTags) {
		super.readFromNBT(nbtTags);
		name = nbtTags.getString("name");
		owner = nbtTags.getString("owner");
		stage = nbtTags.getInteger("stage");

	}

	@Override
	public void writeToNBT(NBTTagCompound nbtTags) {
		super.writeToNBT(nbtTags);
		nbtTags.setString("name", name);
		nbtTags.setString("owner", owner);
		nbtTags.setInteger("stage", stage);
	}

	@Override
	public Packet getDescriptionPacket() {
		Packet132TileEntityData packet = (Packet132TileEntityData) super.getDescriptionPacket();
		NBTTagCompound tag = packet != null ? packet.customParam1 : new NBTTagCompound();
		writeToNBT(tag);
		return new Packet132TileEntityData(xCoord, yCoord, zCoord, 1, tag);
	}

	@Override
	public void handlePacketData(DataInputStream inputStream) {
		try {
			stage = inputStream.readInt();
			name = inputStream.readUTF();
			owner = inputStream.readUTF();
			//	System.out.println("Okay, now stage is " + stage + ". And the name - " + name + " by " + owner + ".");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public DataOutputStream getNetworkedData(DataOutputStream outputStream) {
		try {
			outputStream.writeInt(0x001);
			outputStream.writeInt(xCoord);
			outputStream.writeInt(yCoord);
			outputStream.writeInt(zCoord);
			outputStream.writeInt(stage);
			outputStream.writeUTF(name);
			outputStream.writeUTF(owner);
			//return outputStream;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println("[Mekanism] Error while writing tile entity packet.");
		}
		return outputStream;

	}

	@Override
	public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt) {
		super.onDataPacket(net, pkt);
		NBTTagCompound tag = pkt.customParam1;
		readFromNBT(tag);
	}

}