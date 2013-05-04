package mods.nordwest.items;

import java.security.Timestamp;
import java.util.Date;
import java.util.List;

import org.lwjgl.Sys;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import mods.nordwest.common.CustomBlocks;
import mods.nordwest.common.NordWest;
import mods.nordwest.tileentity.TileEntityAltar;
import mods.nordwest.utils.EnumColors;
import mods.nordwest.utils.EnumFormatting;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ScrollItem extends BaseItem {

	public ScrollItem(int par1) {
		super(par1);
		setCreativeTab(NordWest.tabNord);
		this.setMaxStackSize(16);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		if (par1ItemStack.hasTagCompound()) {
			if (par1ItemStack.getItemDamage() == 1) {
				return;
			}
			int x, y, z;
			int worldID = par1ItemStack.getTagCompound().getInteger("worldID");
			String by = LanguageRegistry.instance().getStringLocalization("author.by");
			String doublePoint = ": ";
			String worldDescription = LanguageRegistry.instance().getStringLocalization("world.desc");
			String worldName = LanguageRegistry.instance().getStringLocalization("world.undefined");
			String color = "\u00a77"; //Default Color
			if (worldID == 0) {
				worldName = LanguageRegistry.instance().getStringLocalization("world.overworld");
			} else if (worldID == -1) {
				worldName = LanguageRegistry.instance().getStringLocalization("world.nether");
			} else if (worldID == 1) {
				worldName = LanguageRegistry.instance().getStringLocalization("world.end");
			} else if (worldID != 0 || worldID != 1 || worldID != -1 && par1ItemStack.getTagCompound().getString("worldName") != null) {
				worldName = par1ItemStack.getTagCompound().getString("worldName");
				color = "\u00a7e"; //Yellow Color
			} else {
				worldName = LanguageRegistry.instance().getStringLocalization("world.undefined");
				color = "\u00a78"; //Gray Color
			}
			x = par1ItemStack.getTagCompound().getInteger("X");
			y = par1ItemStack.getTagCompound().getInteger("Y");
			z = par1ItemStack.getTagCompound().getInteger("Z");
			par3List.add(EnumColors.WHITE + "\u00a7o" + par1ItemStack.getTagCompound().getString("blockName"));
			par3List.add(color + worldDescription + doublePoint + worldName);
			par3List.add(by + doublePoint + par1ItemStack.getTagCompound().getString("Lore"));
			par3List.add("X" + doublePoint + x);
			par3List.add("Y" + doublePoint + y);
			par3List.add("Z" + doublePoint + z);
		}
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, player, true);
		if (movingobjectposition == null) {
			if (start(itemstack, world, player))
				itemstack.stackSize--;
			return itemstack;
		} else {
			int x = movingobjectposition.blockX;
			int y = movingobjectposition.blockY;
			int z = movingobjectposition.blockZ;
			TileEntityAltar tileEntity = null;
			if (world.getBlockTileEntity(x, y, z) instanceof TileEntityAltar) {
				tileEntity = (TileEntityAltar) world.getBlockTileEntity(x, y, z);
			} else {
				if (start(itemstack, world, player))
					itemstack.stackSize--;
				return itemstack;
			}
			if (!itemstack.hasTagCompound()) {
				if (itemstack.itemID == this.itemID && (checkOnLinking(world, x, y, z))) {

					ItemStack item = new ItemStack(this, 1, itemstack.getItemDamage());
					NBTTagCompound tag = item.getTagCompound();
					if (tag == null) {
						tag = new NBTTagCompound();
						item.setTagCompound(tag);
					}
					tag.setString("Lore", player.getEntityName());
					tag.setString("worldName", world.provider.getDimensionName());
					tag.setString("blockName", tileEntity.name);
					tag.setInteger("X", x);
					tag.setInteger("Y", y);
					tag.setInteger("Z", z);
					tag.setInteger("worldID", world.provider.dimensionId);
					itemstack.stackSize--;
					player.inventory.addItemStackToInventory(item);
					world.playSound(x, y, z, "random.breath", 0.5f, 1.2f, false);
					world.spawnParticle("reddust", x + 0.5D, y + 1.0D, z + 0.5D, 0.0D, 0.5D, 0.0D);
					return itemstack;
				}
			} else {
				if (start(itemstack, world, player))
					itemstack.stackSize--;
				return itemstack;
			}
		}
		return itemstack;
	}

	private boolean start(ItemStack itemstack, World world, EntityPlayer player) {
		if (itemstack.hasTagCompound()) {
			int x, y, z;
			x = itemstack.getTagCompound().getInteger("X"); // + 0.5d;
			y = itemstack.getTagCompound().getInteger("Y"); // + 1.2d;
			z = itemstack.getTagCompound().getInteger("Z"); // + 0.5d;
			int worldId = itemstack.getTagCompound().getInteger("worldID");
			if (checkConditions(world, x, y, z, player, itemstack) || itemstack.getItemDamage() == 1) {
				goodEffectDraw(world, player.posX, player.posY - 1, player.posZ);
				world.playSound(player.posX + 0.5D, player.posY + 1.0D, player.posZ + 0.5D, "mob.endermen.portal", 0.5f, 2.2f, false);
				goodEffectDraw(world, x + 0.5D, y + 1.0D, z + 0.5D);
				world.playSound(x + 0.5D, y + 1.0D, z + 0.5D, "mob.endermen.portal2", 0.5f, 2.2f, false);
				player.setPositionAndUpdate(x + 0.5D, y + 1.0D, z + 0.5D);
				player.fallDistance = 0.0F;
				return true;
			}

		}
		return false;
	}

	private boolean checkConditions(World world, int x, int y, int z, EntityPlayer player, ItemStack itemstack) {
		NBTTagCompound tag = itemstack.getTagCompound();
		if (tag == null) {
			tag = new NBTTagCompound();
			itemstack.setTagCompound(tag);
		}
		boolean delay = true;
		int worldId = itemstack.getTagCompound().getInteger("worldID");
		int id = world.getBlockId(x, y, z);
		TileEntityAltar tileEntity = null;
		if (world.getBlockTileEntity(x, y, z) instanceof TileEntityAltar) {
			tileEntity = (TileEntityAltar) world.getBlockTileEntity(x, y, z);
		}
		String homeName = itemstack.getTagCompound().getString("blockName");
		if (tileEntity != null) {
			if (!tileEntity.name.equals("Unknown")) {
				homeName = tileEntity.name;
			}
		}
		homeName = homeName.replaceAll(".$", "");
		String welcomeMessage = LanguageRegistry.instance().getStringLocalization("scroll.welcome");
		welcomeMessage = welcomeMessage.replaceAll("%p", homeName);
		String forcedTeleportationMessage = LanguageRegistry.instance().getStringLocalization("scroll.forced");
		forcedTeleportationMessage = forcedTeleportationMessage.replaceAll("%p", homeName);
		if (getSystemTime() >= itemstack.getTagCompound().getLong("time") + 1250 || (!tag.hasKey("time"))) {
			delay = true;
		} else {
			delay = false;
		}
		if (delay == true) {
			if (worldId != (world.provider.dimensionId)) {// если миры не совпадают
				if (!world.isRemote)
					player.sendChatToPlayer(EnumColors.DARK_RED + LanguageRegistry.instance().getStringLocalization("scroll.error.wrongDimension"));
				badEffectDraw(world, player.posX, player.posY - 1, player.posZ);
				world.playSound(player.posX + 0.5D, player.posY + 1.0D, player.posZ + 0.5D, "random.breath", 0.5f, 2.2f, false);
				tag.setLong("time", getSystemTime());
				return false;
			} else if (tileEntity == null) {// Если блок явно сломан

				if (!player.capabilities.isCreativeMode) {
					if (!world.isRemote)
						player.sendChatToPlayer(EnumColors.DARK_RED + LanguageRegistry.instance().getStringLocalization("scroll.error.notCreative"));
					badEffectDraw(world, player.posX, player.posY - 1, player.posZ);
					world.playSound(player.posX + 0.5D, player.posY + 1.0D, player.posZ + 0.5D, "random.breath", 0.5f, 2.2f, false);
					tag.setLong("time", getSystemTime());
					return false;
				} else {
					if (!world.isRemote) {
						player.sendChatToPlayer(EnumColors.YELLOW + LanguageRegistry.instance().getStringLocalization("scroll.error.creative"));
						player.sendChatToPlayer(EnumColors.YELLOW + forcedTeleportationMessage);
					}
					tag.setLong("time", getSystemTime());
					return true;

				}
			} else if (worldId == 1) {// Если в энде
				if (!world.isRemote)
					player.sendChatToPlayer(EnumColors.DARK_RED + LanguageRegistry.instance().getStringLocalization("scroll.error.end"));
				badEffectDraw(world, player.posX, player.posY - 1, player.posZ);
				world.playSound(player.posX + 0.5D, player.posY + 1.0D, player.posZ + 0.5D, "random.breath", 0.5f, 2.2f, false);
				tag.setLong("time", getSystemTime());
				return false;
			} else {// если блок есть
				if (!tileEntity.owner.equals("Unknown")) {
					if (!world.isRemote) {
						player.sendChatToPlayer(EnumColors.PURPLE + LanguageRegistry.instance().getStringLocalization("scroll.tp"));
						player.sendChatToPlayer(EnumColors.PURPLE + welcomeMessage);
					}
					tag.setLong("time", getSystemTime());
					return true;
				} else {
					if (player.capabilities.isCreativeMode) {
						if (!world.isRemote) {
							player.sendChatToPlayer(EnumColors.YELLOW + LanguageRegistry.instance().getStringLocalization("scroll.error.creative"));
							player.sendChatToPlayer(EnumColors.YELLOW + forcedTeleportationMessage);
						}
						tag.setLong("time", getSystemTime());
						return true;
					} else {
						if (!world.isRemote)
							player.sendChatToPlayer(EnumColors.DARK_RED + LanguageRegistry.instance().getStringLocalization("scroll.error.notCreative"));
						badEffectDraw(world, player.posX, player.posY - 1, player.posZ);
						world.playSound(player.posX + 0.5D, player.posY + 1.0D, player.posZ + 0.5D, "random.breath", 0.5f, 2.2f, false);
						tag.setLong("time", getSystemTime());
						return false;
					}
				}
			}
		} else {
			return false;
		}
	}

	private boolean checkOnLinking(World world, int x, int y, int z) {
		int id = world.getBlockId(x, y, z);
		TileEntityAltar tileEntity = (TileEntityAltar) world.getBlockTileEntity(x, y, z);
		if (id != CustomBlocks.blockhome.blockID || tileEntity.owner.equals("Unknown")) {
			return false;
		} else {
			/**
			 * boolean test = true; for (int i = 0; i < 4; i++) { test &= world.getBlockId(x + 2, y + i, z + 2) == Block.obsidian.blockID; test &= world.getBlockId(x - 2, y + i, z + 2) == Block.obsidian.blockID; test &= world.getBlockId(x + 2, y + i, z - 2) == Block.obsidian.blockID; test &= world.getBlockId(x - 2, y + i, z - 2) == Block.obsidian.blockID; return test;
			 */
			return true;
		}
	}

	private void goodEffectDraw(World world, double x, double y, double z) {
		double r = 0.5d;
		int c = 36;
		for (int i = 1; i < c; i++) {
			world.spawnParticle("portal", x + r * Math.cos(i), y + (i * 0.025), z + r * Math.sin(i), 0.0D, -0.5D, 0.0D);

		}
	}

	private void badEffectDraw(World world, double x, double y, double z) {
		double r = 0.5d;
		int c = 36;
		for (int i = 1; i < c; i++) {
			world.spawnParticle("smoke", x + r * Math.cos(i), y + (i * 0.025), z + r * Math.sin(i), 0.0D, 0.0D, 0.0D);
		}

	}

	@Override
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int j = 0; j < 2; ++j) {
			par3List.add(new ItemStack(par1, 1, j));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
		return super.getUnlocalizedName() + "." + i;
	}

	public static long getSystemTime() {
		return (new Date()).getTime();
	}
}
