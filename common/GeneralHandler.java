package mods.nordwest.common;

import java.util.Random;

import mods.nordwest.blocks.CustomTreeSapling;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class GeneralHandler {

	@ForgeSubscribe
	public void onUseBonemeal(BonemealEvent e) {
		if (!e.world.isRemote) {

			//System.out.print(CustomBlock.customTreeSapling);
			if (e.getResult() == Result.DEFAULT && e.ID == CustomBlocks.customTreeSapling.blockID) {
				((CustomTreeSapling) CustomBlocks.customTreeSapling).func_96477_c(e.world, e.X, e.Y, e.Z, e.world.rand);
			}
			if (e.getResult() == Result.DEFAULT && e.ID == CustomBlocks.magicTreeSapling.blockID) {
				((CustomTreeSapling) CustomBlocks.magicTreeSapling).func_96477_c(e.world, e.X, e.Y, e.Z, e.world.rand);
			}
		}

	}

	@ForgeSubscribe
	public void onLivingSpecialSpawn(LivingSpawnEvent  event) {
		System.out.print(1);
		Random random = new Random();
		int chance = random.nextInt(10);
		int secondChance = random.nextInt(2);
		if (chance < 5) {
			int weapon = random.nextInt(10);
			int armor = random.nextInt(10);
			if (secondChance == 0) {
				if (event.entityLiving instanceof EntityZombie && weapon < 5) {
					event.entityLiving.setCurrentItemOrArmor(0, new ItemStack(CustomItems.copperSword));
				}
				if (armor < 3) {
					event.entityLiving.setCurrentItemOrArmor(1, new ItemStack(CustomItems.copperHelmet));
					event.entityLiving.setCurrentItemOrArmor(2, new ItemStack(CustomItems.copperChestplate));
					event.entityLiving.setCurrentItemOrArmor(3, new ItemStack(CustomItems.copperLegs));
					event.entityLiving.setCurrentItemOrArmor(4, new ItemStack(CustomItems.copperBoots));
				}
			} else if (secondChance == 1) {
				if (event.entityLiving instanceof EntityZombie && weapon < 3) {
					event.entityLiving.setCurrentItemOrArmor(0, new ItemStack(CustomItems.copperAxe));
				}
				if (armor < 1) {
					event.entityLiving.setCurrentItemOrArmor(1, new ItemStack(CustomItems.mythrilHelmet));
					event.entityLiving.setCurrentItemOrArmor(2, new ItemStack(CustomItems.mythrilChestplate));
					event.entityLiving.setCurrentItemOrArmor(3, new ItemStack(CustomItems.mythrilLegs));
					event.entityLiving.setCurrentItemOrArmor(4, new ItemStack(CustomItems.mythrilBoots));
				}
			} else if (secondChance == 2) {
				if (event.entityLiving instanceof EntityZombie && weapon < 5) {
					event.entityLiving.setCurrentItemOrArmor(0, new ItemStack(CustomItems.copperSword));
				}
				if (armor < 5) {
					event.entityLiving.setCurrentItemOrArmor(2, new ItemStack(CustomItems.copperChestplate));
				}
			}
		}
	}
}
