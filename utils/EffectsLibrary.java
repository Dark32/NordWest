package mods.nordwest.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EffectsLibrary {
	
	public static void doFakeEntityExplosion(EntityPlayer player)
	{
		World world = player.worldObj;
		world.spawnParticle("hugeexplosion", player.posX, player.posY, player.posZ, 0.0D, 0.0D, 0.0D);
		player.playSound("random.explode", 1.0F, 1.2F);
	}

	
	public static void smokeCloud(EntityPlayer player, int x, int y, int z, int intensivity)
	{
		World world = player.worldObj;
		double r = 0.5d;
		for (int i = 1; i < intensivity; i++) {
		world.spawnParticle("smoke", x + 0.5D + (r * Math.cos(i)), y + 0.75D + (i * 0.025), z + 0.5D + (r * Math.sin(i)), 0.0D, 0.0D, 0.0D);
	}
	}
	
	public static void playSoundOnEntity(EntityPlayer player, String soundPath)
	{
		player.playSound(soundPath, 1.0f, 1.2f);
	}
}