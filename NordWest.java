package mods.mod_nw;

import java.util.logging.Level;

import mods.mod_nw.Block.*;
import mods.mod_nw.Item.BaseItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "NordWest", name = "mod for mcnw.ru", version = "1.0.0")
// @NetworkMod(channels = { "NordWest" }, clientSideRequired = true,
// serverSideRequired = false, packetHandler = PacketHandler.class)
public class NordWest {
	@Instance("mod_nw")
	public static NordWest instance;
	@SidedProxy(clientSide = "mods.mod_nw.client.ClientProxy", serverSide = "mods.mod_nw.CommonProxy")
	public static CommonProxy proxy;
	public static CreativeTabs tabNord = new CreativeTabs("tabNord") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Item.eyeOfEnder, 1, 0);
		}
	};
	public static Config cfg = null;
	public static Block lexpo;
	public static Block ore0;
	public static Block ore1;
	public static Block ore2;
	public static Block ore3;
	public static Block ore4;
	public static Block coperore;
	public static Block coperblock;
	public static Block mithrilore;

	public static Item lexpiItem;
	public static Item mingotItem;
	public static Item cingotItem;
	public static Block blockmithri;

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		cfg = new Config(event.getSuggestedConfigurationFile());

	}

	LanguageRegistry language = LanguageRegistry.instance();

	// .addStringLocalization("itemGroup.tabCustom", "en_US", "My Custom Tab");
	@Init
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
		/** Item **/
		lexpiItem = new BaseItem(cfg.lexpi_id).setUnlocalizedName("lexpi");
		LanguageRegistry.addName(lexpiItem, cfg.lexpi_name);
		mingotItem = new BaseItem(cfg.mingot_id).setUnlocalizedName("mingot");
		LanguageRegistry.addName(mingotItem, cfg.mingot_name);

		cingotItem = new BaseItem(cfg.cingot_id).setMaxStackSize(64).setUnlocalizedName("cingot");
		LanguageRegistry.addName(cingotItem, cfg.cingot_name);
		/** Block **/
		lexpo = new BaseOre(cfg.lexpo_id, Material.rock, lexpiItem.itemID, 5).setHardness(3F).setResistance(5F)
				.setUnlocalizedName("lexpo");
		GameRegistry.registerBlock(lexpo, "lexpo");
		LanguageRegistry.addName(lexpo, cfg.lexpo_name);

		ore0 = new BlockStone(cfg.ore0_id).setHardness(1.5F).setResistance(10.0F)
				.setStepSound(Block.soundStoneFootstep).setUnlocalizedName("stone");
		ore1 = new BlockStone(cfg.ore1_id).setHardness(1.5F).setResistance(10.0F)
				.setStepSound(Block.soundStoneFootstep).setUnlocalizedName("stone");
		ore2 = new BlockStone(cfg.ore2_id).setHardness(1.5F).setResistance(10.0F)
				.setStepSound(Block.soundStoneFootstep).setUnlocalizedName("stone");
		ore3 = new BlockStone(cfg.ore3_id).setHardness(1.5F).setResistance(10.0F)
				.setStepSound(Block.soundStoneFootstep).setUnlocalizedName("stone");
		ore4 = new BlockStone(cfg.ore4_id).setHardness(1.5F).setResistance(10.0F)
				.setStepSound(Block.soundStoneFootstep).setUnlocalizedName("stone");
		GameRegistry.registerBlock(ore0, "ore0");
		LanguageRegistry.addName(ore0, cfg.ore0_name);
		GameRegistry.registerBlock(ore1, "ore1");
		LanguageRegistry.addName(ore1, cfg.ore1_name);
		GameRegistry.registerBlock(ore2, "ore2");
		LanguageRegistry.addName(ore2, cfg.ore2_name);
		GameRegistry.registerBlock(ore3, "ore3");
		LanguageRegistry.addName(ore3, cfg.ore3_name);
		GameRegistry.registerBlock(ore4, "ore4");
		LanguageRegistry.addName(ore4, cfg.ore4_name);

		coperore = new BaseBlock(cfg.coper_ore_id, Material.rock).setHardness(3F).setResistance(5F)
				.setUnlocalizedName("coperore");
		GameRegistry.registerBlock(coperore, "coperore");
		LanguageRegistry.addName(coperore, cfg.coper_ore_name);
		coperblock = new BaseBlock(cfg.coperblock_id, Material.rock).setHardness(3F).setResistance(5F)
				.setUnlocalizedName("coperblock");
		GameRegistry.registerBlock(coperblock, "coperblock");
		LanguageRegistry.addName(coperblock, cfg.coperblock_name);

		mithrilore = new BaseBlock(cfg.mithrilore_id, Material.rock).setHardness(3F).setResistance(5F)
				.setUnlocalizedName("mithrilore");
		GameRegistry.registerBlock(mithrilore, "mithrilore");
		LanguageRegistry.addName(mithrilore, cfg.mithrilore_name);

		blockmithri = new BaseBlock(cfg.blockmithri_id, Material.rock).setHardness(3F).setResistance(5F)
				.setUnlocalizedName("blockmithri");
		GameRegistry.registerBlock(blockmithri, "blockmithri");
		LanguageRegistry.addName(blockmithri, cfg.blockmithri_name);
		/** безформенные рецепты **/

		GameRegistry.addShapelessRecipe(new ItemStack(Item.expBottle, 1), NordWest.lexpiItem, Item.glassBottle);
		GameRegistry.addShapelessRecipe(new ItemStack(cingotItem, 9), new ItemStack(coperblock));
		GameRegistry.addShapelessRecipe(new ItemStack(mingotItem, 9), new ItemStack(blockmithri));
		/** Форменные рецепты **/
		GameRegistry.addRecipe(new ItemStack(blockmithri, 1), new Object[] { "111", "111", "111", '1',
				NordWest.mingotItem });
		GameRegistry.addRecipe(new ItemStack(coperblock, 1), new Object[] { "111", "111", "111", '1',
				NordWest.cingotItem });
		/** Рецепты печки **/
		GameRegistry.addSmelting(coperore.blockID, new ItemStack(cingotItem), 0.2f);
		GameRegistry.addSmelting(mithrilore.blockID, new ItemStack(mingotItem), 0.2f);
	}

	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		language.addStringLocalization("itemGroup.tabNord", "en_US", cfg.tabNord);
	}

}
