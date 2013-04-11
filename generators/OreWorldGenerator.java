package mods.nordwest.generators;

import java.util.Random;

import mods.nordwest.common.CustomBlocks;
import mods.nordwest.common.NordWest;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import cpw.mods.fml.common.IWorldGenerator;

public class OreWorldGenerator implements IWorldGenerator {
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	private void generateSurface(World world, Random random, int chunkX, int chunkZ) {
		WorldGenMinable coper = (new WorldGenMinable(CustomBlocks.copperOre.blockID, 0, 16, 1));
		WorldGenMinable expaniteOre = (new WorldGenMinable(CustomBlocks.expaniteOre.blockID, 0, 20, 1));
		//WorldGenMinable air = (new WorldGenMinable(20, 0, 40, 1));
		baseOreGeneration(world, coper, random, chunkX, chunkZ, 20, 200, 45);
		baseOreGeneration(world, expaniteOre, random, chunkX, chunkZ, 0, 200, 50);
		//baseOreGeneration(world, air, random, chunkX, chunkZ, 0, 205, 300);

	}

	private void baseOreGeneration(World world, WorldGenMinable ore, Random random, int chunkX, int chunkZ, int minY,
			int maxZ, int unrare) {
		for (int i = 0; i < unrare; i++) {
			int xCoord = chunkX + random.nextInt(16);
			int yCoord = random.nextInt(maxZ);
			int zCoord = chunkZ + random.nextInt(16);
			ore.generate(world, random, xCoord, yCoord, zCoord);
		}
	}
}
