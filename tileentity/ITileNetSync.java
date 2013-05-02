package mods.nordwest.tileentity;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;

import com.google.common.io.ByteArrayDataInput;

public interface ITileNetSync {

	public void handlePacketData(DataInputStream dataStream) throws Exception;

	public DataOutputStream getNetworkedData(DataOutputStream data);

}