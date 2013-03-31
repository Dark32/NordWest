package mods.mod_nw.WorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

import cpw.mods.fml.common.IWorldGenerator;

public class OreWorldGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {
		/*if(world.getBiomeGenForCoords(chunkX, chunkZ) != BiomeGenBase.hell)
		{
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		}*/
		
	}

	private void generateSurface(World world, Random random, int i, int j) {
		for(int k=100;k<256;k++){
			if (world.getBlockId(i, j, k)==0){
				world.setBlock(i, j, k, 1);
			}
		}
		
	}

}