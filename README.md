To-Do List:
========
 - Add TileEntity that can contain NBTTags;
 - Add 3D model to our Altar.

Bugs:
========
 - You can see the whole block collision box, while using Flint & Steel on candle (http://i.imgur.com/SWqBBNX.png);
 - You can use F&S on candle to set fire on separate blocks;
 - You can set fire on the Altar using F&S while sneaking;
 - Candles don't fall when there are no blocks under them, you can set candle on the air.
 - Client Side method use on Server Side
 java.lang.NoClassDefFoundError: net/minecraft/client/Minecraft
 at mods.nordwest.items.ScrollItem.checkConditions(ScrollItem.java:145)
	at mods.nordwest.items.ScrollItem.start(ScrollItem.java:122)
	at mods.nordwest.items.ScrollItem.onItemRightClick(ScrollItem.java:79)
	at net.minecraft.item.ItemStack.useItemRightClick(ItemStack.java:173)
	at net.minecraft.item.ItemInWorldManager.tryUseItem(ItemInWorldManager.java:349)
	at net.minecraft.network.NetServerHandler.handlePlace(NetServerHandler.java:539)
	at net.minecraft.network.packet.Packet15Place.processPacket(Packet15Place.java:79)
	at net.minecraft.network.TcpConnection.processReadPackets(TcpConnection.java:461)
	at net.minecraft.network.NetServerHandler.networkTick(NetServerHandler.java:134)
	at net.minecraft.network.NetworkListenThread.networkTick(NetworkListenThread.java:53)
	at net.minecraft.server.dedicated.DedicatedServerListenThread.networkTick(DedicatedServerListenThread.java:34)
	at net.minecraft.server.MinecraftServer.updateTimeLightAndEntities(MinecraftServer.java:674)
	at net.minecraft.server.dedicated.DedicatedServer.updateTimeLightAndEntities(DedicatedServer.java:274)
	at net.minecraft.server.MinecraftServer.tick(MinecraftServer.java:570)
	at net.minecraft.server.MinecraftServer.run(MinecraftServer.java:468)
	at net.minecraft.server.ThreadMinecraftServer.run(ThreadMinecraftServer.java:16)
Caused by: java.lang.ClassNotFoundException: net.minecraft.client.Minecraft
	at cpw.mods.fml.relauncher.RelaunchClassLoader.findClass(RelaunchClassLoader.java:238)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:306)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:247)
	... 16 more
Caused by: java.lang.RuntimeException: Attempted to load class net/minecraft/client/Minecraft for invalid side SERVER
	at cpw.mods.fml.common.asm.transformers.SideTransformer.transform(SideTransformer.java:50)
	at cpw.mods.fml.relauncher.RelaunchClassLoader.runTransformers(RelaunchClassLoader.java:352)
	at cpw.mods.fml.relauncher.RelaunchClassLoader.findClass(RelaunchClassLoader.java:225)
	... 18 more
