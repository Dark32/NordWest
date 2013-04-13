package mods.nordwest.common;

import cpw.mods.fml.common.registry.GameRegistry;
import mods.nordwest.blocks.BaseBlockStep;
import mods.nordwest.blocks.BaseBlock;
import mods.nordwest.blocks.BaseMetadataBlock;
import mods.nordwest.blocks.BaseOre;
import mods.nordwest.blocks.BlockFlora;
import mods.nordwest.blocks.BlockHome;
import mods.nordwest.blocks.CustomTreeLeaves;
import mods.nordwest.blocks.CustomTreeSapling;
import mods.nordwest.blocks.CustomTreeWood;
import mods.nordwest.blocks.SlimeBlock;
import mods.nordwest.items.MetadataBlockItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;
import net.minecraftforge.common.MinecraftForge;

public class CustomBlocks {
	public static Block expaniteOre;
	public static Block ore0;
	public static Block ore1;
	public static Block ore2;
	public static Block ore3;
	public static Block ore4;
	public static Block copperOre;
	public static Block copperBlock;
	public static Block mythrilOre;
	public static Block mythrilBlock;
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

	public static BlockHalfSlab blockWoolHalf1;
	public static BlockHalfSlab blockWoolFull1;
	public static BlockHalfSlab blockWoolHalf2;
	public static BlockHalfSlab blockWoolFull2;
	
	public static Block redBlock;
	public static Block slimeBlock;


	public static void init() {
		expaniteOre = new BaseOre(Config.BLOCK_ID.expaniteOre_id, Material.rock, CustomItems.expaniteItem.itemID, 2, 4, 0).setHardness(3F).setResistance(5F).setUnlocalizedName("expaniteOre");
		GameRegistry.registerBlock(expaniteOre, "expaniteOre");

		ore0 = new BlockStone(Config.BLOCK_ID.ore0_id).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("stone");
		ore1 = new BlockStone(Config.BLOCK_ID.ore1_id).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("stone");
		ore2 = new BlockStone(Config.BLOCK_ID.ore2_id).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("stone");
		ore3 = new BlockStone(Config.BLOCK_ID.ore3_id).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("stone");
		ore4 = new BlockStone(Config.BLOCK_ID.ore4_id).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("stone");
		GameRegistry.registerBlock(ore0, "ore0");
		GameRegistry.registerBlock(ore1, "ore1");
		GameRegistry.registerBlock(ore2, "ore2");
		GameRegistry.registerBlock(ore3, "ore3");
		GameRegistry.registerBlock(ore4, "ore4");

		copperOre = new BaseBlock(Config.BLOCK_ID.coper_ore_id, Material.rock).setHardness(3F).setResistance(5F).setUnlocalizedName("copperOre");
		GameRegistry.registerBlock(copperOre, "copperOre");
		copperBlock = new BaseBlock(Config.BLOCK_ID.copperBlock_id, Material.rock).setHardness(3F).setResistance(5F).setUnlocalizedName("copperBlock");
		GameRegistry.registerBlock(copperBlock, "copperBlock");
		mythrilOre = new BaseBlock(Config.BLOCK_ID.mythrilOre_id, Material.rock).setHardness(3F).setResistance(5F).setUnlocalizedName("mythrilOre");
		GameRegistry.registerBlock(mythrilOre, "mythrilOre");
		mythrilBlock = new BaseBlock(Config.BLOCK_ID.mythrilBlock_id, Material.rock).setHardness(3F).setResistance(5F).setUnlocalizedName("mythrilBlock");
		GameRegistry.registerBlock(mythrilBlock, "mythrilBlock");

		String[] wood = new String[] { "dark", "pink", "yellow", "gray" };
		customTreePlank = new BaseMetadataBlock(Config.BLOCK_ID.customTreeplank_id, Material.wood, 4).setHardness(2F).setResistance(5F).setUnlocalizedName("customTreePlank");
		GameRegistry.registerBlock(customTreePlank, MetadataBlockItem.class, "customTreePlank");

		magicTreePlank = new BaseMetadataBlock(Config.BLOCK_ID.magicTreeplank_id, Material.iron, 4).setHardness(20F).setResistance(5F).setUnlocalizedName("magicTreePlank").setStepSound(Block.soundWoodFootstep);
		GameRegistry.registerBlock(magicTreePlank, MetadataBlockItem.class, "magicTreePlank");

		lamp = new Block(Config.BLOCK_ID.lamp_id, Material.glass).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("redstoneLight").setLightValue(1.0F);
		GameRegistry.registerBlock(lamp, "redstoneLight");

		customTreeLeaves = new CustomTreeLeaves(Config.BLOCK_ID.leave_id).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("customTreeLeaves");
		GameRegistry.registerBlock(customTreeLeaves, MetadataBlockItem.class, "customTreeLeaves");

		customTreeWood = new CustomTreeWood(Config.BLOCK_ID.customTreewood_id).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("customTreeWood");
		GameRegistry.registerBlock(customTreeWood, MetadataBlockItem.class, "customTreeWood");

		magicTreeLeaves = new CustomTreeLeaves(Config.BLOCK_ID.magicTreeLeaves).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("magicTreeLeaves");
		GameRegistry.registerBlock(magicTreeLeaves, MetadataBlockItem.class, "magicTreeLeaves");

		customTreeSapling = new CustomTreeSapling(Config.BLOCK_ID.customTreeSapling).setHardness(0.1F).setResistance(5F).setUnlocalizedName("customTreeSapling").setStepSound(Block.soundGrassFootstep);
		GameRegistry.registerBlock(customTreeSapling, MetadataBlockItem.class, "customTreeSapling");

		magicTreeWood = new CustomTreeWood(Config.BLOCK_ID.magicTreeWood, Material.iron).setHardness(25.0F).setResistance(50F).setUnlocalizedName("magicTreeWood").setStepSound(Block.soundWoodFootstep)
				.setLightValue(0.2F);
		;
		GameRegistry.registerBlock(magicTreeWood, MetadataBlockItem.class, "magicTreeWood");

		magicTreeSapling = new CustomTreeSapling(Config.BLOCK_ID.magicTreeSapling, "magic").setHardness(0.1F).setResistance(5F).setUnlocalizedName("magicTreeSapling").setStepSound(Block.soundGrassFootstep);
		GameRegistry.registerBlock(magicTreeSapling, MetadataBlockItem.class, "magicTreeSapling");

		flora = new BlockFlora(Config.BLOCK_ID.flora).setHardness(0.0F).setResistance(1F).setUnlocalizedName("flora").setStepSound(Block.soundGrassFootstep);
		GameRegistry.registerBlock(flora, MetadataBlockItem.class, "flora");

		blockhome = new BlockHome(Config.BLOCK_ID.homeblock).setHardness(10.0F).setResistance(10F).setUnlocalizedName("blockhome").setStepSound(Block.soundStoneFootstep);
		GameRegistry.registerBlock(blockhome, "blockhome");
		blockWoolHalf1 = (BlockHalfSlab) (new BaseBlockStep(Config.BLOCK_ID.blockWoolHalf1, false)).setHardness(1.0F).setResistance(1.0F).setLightOpacity(255).setStepSound(Block.soundClothFootstep).setUnlocalizedName("blockWool1");
		blockWoolFull1 = (BlockHalfSlab) (new BaseBlockStep(Config.BLOCK_ID.blockWoolFull1, true)).setHardness(1.0F).setResistance(1.0F).setLightOpacity(0).setStepSound(Block.soundClothFootstep).setUnlocalizedName("blockWool1");
		GameRegistry.registerBlock(blockWoolHalf1, "blockWoolHalf1");
		GameRegistry.registerBlock(blockWoolFull1, "blockWoolFull1");
		blockWoolHalf2 = (BlockHalfSlab) (new BaseBlockStep(Config.BLOCK_ID.blockWoolHalf2, false)).setHardness(1.0F).setResistance(1.0F).setLightOpacity(255).setStepSound(Block.soundClothFootstep).setUnlocalizedName("blockWool2");
		blockWoolFull2 = (BlockHalfSlab) (new BaseBlockStep(Config.BLOCK_ID.blockWoolFull2, true)).setHardness(1.0F).setResistance(1.0F).setLightOpacity(0).setStepSound(Block.soundClothFootstep).setUnlocalizedName("blockWool2");
		GameRegistry.registerBlock(blockWoolHalf2, "blockWoolHalf2");
		GameRegistry.registerBlock(blockWoolFull2, "blockWoolFull2");
		
		slimeBlock = new SlimeBlock(Config.BLOCK_ID.slameBlock).setHardness(1F).setResistance(2F).setUnlocalizedName("slimeBlock").setStepSound(Block.soundSnowFootstep);
		GameRegistry.registerBlock(slimeBlock, "slimeBlock");

		redBlock = new BaseMetadataBlock(Config.BLOCK_ID.redBlock, Material.iron, 4).setHardness(2F).setResistance(2F).setUnlocalizedName("redBlock").setStepSound(Block.soundStoneFootstep);
		GameRegistry.registerBlock(redBlock, MetadataBlockItem.class, "redBlock");

		
		burn();
		flowers();
	}

	private static void burn() {
		Block.setBurnProperties(CustomBlocks.customTreePlank.blockID, 5, 20);
		Block.setBurnProperties(CustomBlocks.customTreeLeaves.blockID, 30, 60);
		Block.setBurnProperties(CustomBlocks.customTreeWood.blockID, 5, 5);
	}

	private static void flowers() {
		for (int l1 = 0; l1 < 11; l1++) {
			MinecraftForge.addGrassPlant(flora, l1, 10);
		}
	}

	public static void registerSlabItem() {
		registerSlabItem(blockWoolHalf1, blockWoolFull1);
		registerSlabItem(blockWoolHalf2, blockWoolFull2);
	}

	private static void registerSlabItem(BlockHalfSlab half, BlockHalfSlab full) {
		Item.itemsList[half.blockID] = null;
		Item.itemsList[full.blockID] = null;
		Item.itemsList[half.blockID] = (new ItemSlab(half.blockID - 256, half, full, false)).setUnlocalizedName(half.getUnlocalizedName());
		Item.itemsList[full.blockID] = (new ItemSlab(full.blockID - 256, half, full, true)).setUnlocalizedName(half.getUnlocalizedName());
	}

	public static void setHarvestLevel() {
		MinecraftForge.setBlockHarvestLevel(mythrilBlock, 0, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(mythrilOre, 0, "pickaxe", 2);
	}
}
