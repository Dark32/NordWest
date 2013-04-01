package mods.mod_nw.WorldGen;

import java.util.Random;

import mods.mod_nw.NordWest;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import cpw.mods.fml.common.IWorldGenerator;

public class OreWorldGenerator implements IWorldGenerator {
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
        case 0:
            generateSurface(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	private void generateSurface(World world, Random random, int chunkX, int chunkZ) {
		//--These high values are necessary to facilitate search for our changes!--
		//--"75" is the max height!--
		//--"30 after 'coperblock'" is the max-average size of the vines!--
		//--Decrease this values to make this ores to generate normally!--
		for (int i = 0; i < 75; i++) {
			int xCoord = chunkX + random.nextInt(16);
			int yCoord = random.nextInt(64);
			int zCoord = chunkZ + random.nextInt(16);
		//--Here we're registering our custom blocks to generate in the world. There's also the size of the vines!--
			(new WorldGenMinable(NordWest.coperore.blockID, 30)).generate(world, random, xCoord, yCoord, zCoord);
		}
	}
}
