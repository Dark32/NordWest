package mods.mod_nw;

import cpw.mods.fml.common.registry.GameRegistry;
import mods.mod_nw.Block.BaseBlock;
import mods.mod_nw.Block.BaseMetadataBlock;
import mods.mod_nw.Block.BaseOre;
import mods.mod_nw.Block.BlockFlora;
import mods.mod_nw.Block.BlockHome;
import mods.mod_nw.Block.CustomTreeSapling;
import mods.mod_nw.Block.CustomTreeLeaves;
import mods.mod_nw.Block.CustomTreeWood;
import mods.mod_nw.Item.MetadataBlockItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;

public class NWBlock {
	public static Block lexpo;
	public static Block ore0;
	public static Block ore1;
	public static Block ore2;
	public static Block ore3;
	public static Block ore4;
	public static Block coperore;
	public static Block coperblock;
	public static Block mithrilore;
	public static Block blockmithri;
	public static Block customTreePlank;
	public static Block magicTreePlank;
	public static Block lamp;
	public static Block customTreeLeaves;
	public static Block customTreeSapling;
	public static Block customTreeWood;
	public static Block magicTreeLeaves;
	public static Block magicTreeWood;
	public static Block magicTreeSapling;
	public static Block flora;
	public static Block blockhome;

	public static void init() {
		lexpo = new BaseOre(Config.BLOCK_ID.lexpo_id, Material.rock, NordWest.lexpiItem.itemID, 2, 4, 0)
				.setHardness(3F).setResistance(5F).setUnlocalizedName("lexpo");
		GameRegistry.registerBlock(lexpo, "lexpo");

		ore0 = new BlockStone(Config.BLOCK_ID.ore0_id).setHardness(1.5F).setResistance(10.0F)
				.setStepSound(Block.soundStoneFootstep).setUnlocalizedName("stone");
		ore1 = new BlockStone(Config.BLOCK_ID.ore1_id).setHardness(1.5F).setResistance(10.0F)
				.setStepSound(Block.soundStoneFootstep).setUnlocalizedName("stone");
		ore2 = new BlockStone(Config.BLOCK_ID.ore2_id).setHardness(1.5F).setResistance(10.0F)
				.setStepSound(Block.soundStoneFootstep).setUnlocalizedName("stone");
		ore3 = new BlockStone(Config.BLOCK_ID.ore3_id).setHardness(1.5F).setResistance(10.0F)
				.setStepSound(Block.soundStoneFootstep).setUnlocalizedName("stone");
		ore4 = new BlockStone(Config.BLOCK_ID.ore4_id).setHardness(1.5F).setResistance(10.0F)
				.setStepSound(Block.soundStoneFootstep).setUnlocalizedName("stone");
		GameRegistry.registerBlock(ore0, "ore0");
		GameRegistry.registerBlock(ore1, "ore1");
		GameRegistry.registerBlock(ore2, "ore2");
		GameRegistry.registerBlock(ore3, "ore3");
		GameRegistry.registerBlock(ore4, "ore4");

		coperore = new BaseBlock(Config.BLOCK_ID.coper_ore_id, Material.rock).setHardness(3F).setResistance(5F)
				.setUnlocalizedName("coperore");
		GameRegistry.registerBlock(coperore, "coperore");
		coperblock = new BaseBlock(Config.BLOCK_ID.coperblock_id, Material.rock).setHardness(3F).setResistance(5F)
				.setUnlocalizedName("coperblock");
		GameRegistry.registerBlock(coperblock, "coperblock");

		mithrilore = new BaseBlock(Config.BLOCK_ID.mithrilore_id, Material.rock).setHardness(3F).setResistance(5F)
				.setUnlocalizedName("mithrilore");
		GameRegistry.registerBlock(mithrilore, "mithrilore");

		blockmithri = new BaseBlock(Config.BLOCK_ID.blockmithri_id, Material.rock).setHardness(3F).setResistance(5F)
				.setUnlocalizedName("blockmithri");
		GameRegistry.registerBlock(blockmithri, "blockmithri");
		String[] wood = new String[] { "dark", "pink", "yellow", "gray" };
		customTreePlank = new BaseMetadataBlock(Config.BLOCK_ID.customTreeplank_id, Material.wood, 4).setHardness(2F)
				.setResistance(5F).setUnlocalizedName("customTreePlank");

		GameRegistry.registerBlock(customTreePlank, MetadataBlockItem.class, "customTreePlank");

		magicTreePlank = new BaseMetadataBlock(Config.BLOCK_ID.magicTreeplank_id, Material.iron, 4).setHardness(20F)
				.setResistance(5F).setUnlocalizedName("magicTreePlank").setStepSound(Block.soundWoodFootstep);
		GameRegistry.registerBlock(magicTreePlank, MetadataBlockItem.class, "magicTreePlank");

		lamp = new Block(Config.BLOCK_ID.lamp_id, Material.glass).setHardness(0.3F)
				.setStepSound(Block.soundGlassFootstep).setUnlocalizedName("redstoneLight").setLightValue(1.0F);
		GameRegistry.registerBlock(lamp, "redstoneLight");

		customTreeLeaves = new CustomTreeLeaves(Config.BLOCK_ID.leave_id).setHardness(0.2F).setLightOpacity(1)
				.setStepSound(Block.soundGrassFootstep).setUnlocalizedName("customTreeLeaves");
		GameRegistry.registerBlock(customTreeLeaves, MetadataBlockItem.class, "customTreeLeaves");

		customTreeWood = new CustomTreeWood(Config.BLOCK_ID.customTreewood_id).setHardness(2.0F).setResistance(5.0F)
				.setStepSound(Block.soundWoodFootstep).setUnlocalizedName("customTreeWood");
		GameRegistry.registerBlock(customTreeWood, MetadataBlockItem.class, "customTreeWood");

		magicTreeLeaves = new CustomTreeLeaves(Config.BLOCK_ID.magicTreeLeaves).setHardness(0.2F).setLightOpacity(1)
				.setStepSound(Block.soundGrassFootstep).setUnlocalizedName("magicTreeLeaves");
		GameRegistry.registerBlock(magicTreeLeaves, MetadataBlockItem.class, "magicTreeLeaves");

		customTreeSapling = new CustomTreeSapling(Config.BLOCK_ID.customTreeSapling).setHardness(0.1F)
				.setResistance(5F).setUnlocalizedName("customTreeSapling").setStepSound(Block.soundGrassFootstep);
		GameRegistry.registerBlock(customTreeSapling, MetadataBlockItem.class, "customTreeSapling");

		magicTreeWood = new CustomTreeWood(Config.BLOCK_ID.magicTreeWood, Material.iron).setHardness(25.0F)
				.setResistance(50F).setUnlocalizedName("magicTreeWood").setStepSound(Block.soundWoodFootstep)
				.setLightValue(0.2F);
		;
		GameRegistry.registerBlock(magicTreeWood, MetadataBlockItem.class, "magicTreeWood");

		magicTreeSapling = new CustomTreeSapling(Config.BLOCK_ID.magicTreeSapling, "magic").setHardness(0.1F)
				.setResistance(5F).setUnlocalizedName("magicTreeSapling").setStepSound(Block.soundGrassFootstep);
		GameRegistry.registerBlock(magicTreeSapling, MetadataBlockItem.class, "magicTreeSapling");
		flora = new BlockFlora(Config.BLOCK_ID.flora).setHardness(0.0F).setResistance(1F).setUnlocalizedName("flora")
				.setStepSound(Block.soundGrassFootstep);
		GameRegistry.registerBlock(flora, MetadataBlockItem.class, "flora");
		
		blockhome = new BlockHome(Config.BLOCK_ID.homeblock).setHardness(10.0F).setResistance(10F).setUnlocalizedName("blockhome")
				.setStepSound(Block.soundStoneFootstep);
		GameRegistry.registerBlock(blockhome, "blockhome");
		
		burn();
		flowers();
	}

	private static void burn() {
		Block.setBurnProperties(NWBlock.customTreePlank.blockID, 5, 20);
		Block.setBurnProperties(NWBlock.customTreeLeaves.blockID, 30, 60);
		Block.setBurnProperties(NWBlock.customTreeWood.blockID, 5, 5);
	}

	private static void flowers() {
		for (int l1 = 0; l1 < 11; l1++) {
			MinecraftForge.addGrassPlant(flora, l1, 10);
		}
	}
}
