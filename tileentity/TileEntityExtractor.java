package mods.nordwest.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.nordwest.common.ExtractorRecipes;
import mods.nordwest.common.NordWest;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ForgeDummyContainer;

public class TileEntityExtractor extends TileEntity implements ISidedInventory, net.minecraftforge.common.ISidedInventory {
	private static final int[] field_102010_d = new int[] { 0 };
	private static final int[] field_102011_e = new int[] { 2, 1 };
	private static final int[] field_102009_f = new int[] { 1 };

	/**
	 * The ItemStacks that hold the items currently being used in the furnace
	 */
	private ItemStack[] extractorItemStacks = new ItemStack[5];

	/** The number of ticks that the furnace will keep burning */
	public int extractorBurnTime = 0;

	/**
	 * The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for
	 */

	public int currentItemBurnTime = 0;

	/** The number of ticks that the current item has been cooking for */
	public int extractorCookTime = 0;
	private String customName;

	/**
	 * Returns the number of slots in the inventory.
	 */
	public int getSizeInventory() {
		return this.extractorItemStacks.length;
	}

	/**
	 * Returns the stack in slot i
	 */
	@Override
	public ItemStack getStackInSlot(int par1) {
		return this.extractorItemStacks[par1];
	}

	/**
	 * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a new stack.
	 */
	@Override
	public ItemStack decrStackSize(int par1, int par2) {
		if (this.extractorItemStacks[par1] != null) {
			ItemStack itemstack;

			if (this.extractorItemStacks[par1].stackSize <= par2) {
				itemstack = this.extractorItemStacks[par1];
				this.extractorItemStacks[par1] = null;
				return itemstack;
			} else {
				itemstack = this.extractorItemStacks[par1].splitStack(par2);

				if (this.extractorItemStacks[par1].stackSize == 0) {
					this.extractorItemStacks[par1] = null;
				}

				return itemstack;
			}
		} else {
			return null;
		}
	}

	/**
	 * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem - like when you close a workbench GUI.
	 */
	@Override
	public ItemStack getStackInSlotOnClosing(int par1) {
		if (this.extractorItemStacks[par1] != null) {
			ItemStack itemstack = this.extractorItemStacks[par1];
			this.extractorItemStacks[par1] = null;
			return itemstack;
		} else {
			return null;
		}
	}

	/**
	 * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
	 */
	@Override
	public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
		this.extractorItemStacks[par1] = par2ItemStack;

		if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit()) {
			par2ItemStack.stackSize = this.getInventoryStackLimit();
		}
	}

	/**
	 * Returns the name of the inventory.
	 */
	@Override
	public String getInvName() {
		return this.isInvNameLocalized() ? this.customName : "container.extractor";
	}

	/**
	 * If this returns false, the inventory name will be used as an unlocalized name, and translated into the player's language. Otherwise it will be used directly.
	 */
	@Override
	public boolean isInvNameLocalized() {
		return this.customName != null && this.customName.length() > 0;
	}

	public void getCustomName(String par1Str) {
		this.customName = par1Str;
	}

	/**
	 * Reads a tile entity from NBT.
	 */
	@Override
	public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);
		NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items");
		this.extractorItemStacks = new ItemStack[this.getSizeInventory()];

		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");

			if (b0 >= 0 && b0 < this.extractorItemStacks.length) {
				this.extractorItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}

		this.extractorBurnTime = par1NBTTagCompound.getShort("BurnTime");
		this.extractorCookTime = par1NBTTagCompound.getShort("CookTime");
		this.currentItemBurnTime = getItemBurnTime(this.extractorItemStacks[1]);

		if (par1NBTTagCompound.hasKey("CustomName")) {
			this.customName = par1NBTTagCompound.getString("CustomName");
		}
	}

	/**
	 * Writes a tile entity to NBT.
	 */
	@Override
	public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setShort("BurnTime", (short) this.extractorBurnTime);
		par1NBTTagCompound.setShort("CookTime", (short) this.extractorCookTime);
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < this.extractorItemStacks.length; ++i) {
			if (this.extractorItemStacks[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				this.extractorItemStacks[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}

		par1NBTTagCompound.setTag("Items", nbttaglist);

		if (this.isInvNameLocalized()) {
			par1NBTTagCompound.setString("CustomName", this.customName);
		}
	}

	/**
	 * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. *Isn't this more of a set than a get?*
	 */
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Returns an integer between 0 and the passed value representing how close the current item is to being completely
	 * cooked
	 */
	public int getCookProgressScaled(int par1) {
		return this.extractorCookTime * par1 / 200;
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Returns an integer between 0 and the passed value representing how much burn time is left on the current fuel
	 * item, where 0 means that the item is exhausted and the passed value means that the item is fresh
	 */
	public int getBurnTimeRemainingScaled(int par1) {
		if (this.currentItemBurnTime == 0) {
			this.currentItemBurnTime = 200;
		}

		return this.extractorBurnTime * par1 / this.currentItemBurnTime;
	}

	/**
	 * Returns true if the furnace is currently burning
	 */
	public boolean isBurning() {
		return this.extractorBurnTime > 0;
	}

	/**
	 * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count ticks and creates a new spawn inside its implementation.
	 */
	@Override
	public void updateEntity() {
		boolean flag = this.extractorBurnTime > 0;
		boolean flag1 = false;
		if (this.extractorBurnTime > 0) {
			--this.extractorBurnTime;
		}
		if (!this.worldObj.isRemote) {
			if (this.extractorBurnTime == 0 && this.canExtractor()) {
				this.currentItemBurnTime = this.extractorBurnTime = getItemBurnTime(this.extractorItemStacks[1]);

				if (this.extractorBurnTime > 0) {
					flag1 = true;

					if (this.extractorItemStacks[1] != null) {
						--this.extractorItemStacks[1].stackSize;

						if (this.extractorItemStacks[1].stackSize == 0) {
							this.extractorItemStacks[1] = this.extractorItemStacks[1].getItem().getContainerItemStack(extractorItemStacks[1]);
						}
					}
				}
			}

			if (this.isBurning() && this.canExtractor()) {
				++this.extractorCookTime;

				if (this.extractorCookTime == 200) {
					this.extractorCookTime = 0;
					this.extractItem();
					flag1 = true;
				}
			} else {
				this.extractorCookTime = 0;
			}

			if (flag != this.extractorBurnTime > 0) {
				flag1 = true;
				// воткнуть сюда дымок
				// BlockFurnace.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
		}

		if (flag1) {
			this.onInventoryChanged();
		}
	}

	/**
	 * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
	 */
	private boolean canExtractor() {
		if (this.extractorItemStacks[0] == null) {
			return false;
		} else {
			ItemStack itemstack = ExtractorRecipes.extracting().getExtractingResult(this.extractorItemStacks[0]);//FurnaceRecipes.smelting().getSmeltingResult(this.extractorItemStacks[0]);
			if (itemstack == null)
				return false;
			if (this.extractorItemStacks[2] == null)
				return true;
			if (!this.extractorItemStacks[2].isItemEqual(itemstack))
				return false;
			int result = extractorItemStacks[2].stackSize + itemstack.stackSize;
			return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
		}
	}

	/**
	 * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
	 */
	public void extractItem() {
		if (this.canExtractor()) {
			ItemStack itemstack = ExtractorRecipes.extracting().getExtractingResult((this.extractorItemStacks[0]));//FurnaceRecipes.smelting().getSmeltingResult(this.extractorItemStacks[0]);
			ItemStack bonus = ExtractorRecipes.extracting().getExtractingBonusResult(this.extractorItemStacks[0]);
			int chance = ExtractorRecipes.extracting().getExtractingBonusChance(this.extractorItemStacks[0]);
			boolean botle = false;
			if (this.extractorItemStacks[3] != null && this.extractorItemStacks[3].getItem().itemID == Item.glassBottle.itemID && this.extractorItemStacks[3].stackSize > 0) {
				botle = true;
			}
			if (botle) {
				if (this.extractorItemStacks[2] == null) {
					this.extractorItemStacks[2] = itemstack.copy();
				} else if (this.extractorItemStacks[2].isItemEqual(itemstack)) {
					extractorItemStacks[2].stackSize += itemstack.stackSize;
				}
				this.extractorItemStacks[3].stackSize-=itemstack.stackSize;
				--this.extractorItemStacks[0].stackSize;

				if (chance > NordWest.rand.nextInt(100)) {
					if (this.extractorItemStacks[4] == null) {
						this.extractorItemStacks[4] = bonus.copy();
					} else if (this.extractorItemStacks[2].isItemEqual(bonus)) {
						extractorItemStacks[4].stackSize += bonus.stackSize;
					}
				}
			}
			if (this.extractorItemStacks[0].stackSize <= 0) {
				this.extractorItemStacks[0] = null;
			}
			if (botle && this.extractorItemStacks[3].stackSize <= 0) {
				this.extractorItemStacks[3] = null;
			}
		}
	}

	/**
	 * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't fuel
	 */
	public static int getItemBurnTime(ItemStack par0ItemStack) {
		if (par0ItemStack == null) {
			return 0;
		} else {
			int i = par0ItemStack.getItem().itemID;
			Item item = par0ItemStack.getItem();

			if (par0ItemStack.getItem() instanceof ItemBlock && Block.blocksList[i] != null) {
				Block block = Block.blocksList[i];

				if (block == Block.woodSingleSlab) {
					return 150;
				}

				if (block.blockMaterial == Material.wood) {
					return 300;
				}
			}

			if (item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("WOOD"))
				return 200;
			if (item instanceof ItemSword && ((ItemSword) item).getToolMaterialName().equals("WOOD"))
				return 200;
			if (item instanceof ItemHoe && ((ItemHoe) item).func_77842_f().equals("WOOD"))
				return 200;
			if (i == Item.stick.itemID)
				return 100;
			if (i == Item.coal.itemID)
				return 1600;
			if (i == Item.bucketLava.itemID)
				return 20000;
			if (i == Block.sapling.blockID)
				return 100;
			if (i == Item.blazeRod.itemID)
				return 2400;
			return GameRegistry.getFuelValue(par0ItemStack);
		}
	}

	/**
	 * Return true if item is a fuel source (getItemBurnTime() > 0).
	 */
	public static boolean isItemFuel(ItemStack par0ItemStack) {
		return getItemBurnTime(par0ItemStack) > 0;
	}

	/**
	 * Do not make give this method the name canInteractWith because it clashes with Container
	 */
	@Override
	public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
		return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openChest() {
	}

	@Override
	public void closeChest() {
	}

	/**
	 * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
	 */
	@Override
	public boolean isStackValidForSlot(int par1, ItemStack par2ItemStack) {
		if (par1 == 2) {
			return false;
		} else if (par1 == 1) {
			return isItemFuel(par2ItemStack);
		} else if (par1 == 3) {
			return par2ItemStack.getItem().itemID == Item.glassBottle.itemID;
		} else {
			return true;
		}
		//return par1 == 2 ? false : (par1 == 1 ? isItemFuel(par2ItemStack) : true);
		//	return tileEntityInvalid;
	}

	/**
	 * Get the size of the side inventory.
	 */
	public int[] getSizeInventorySide(int par1) {
		return par1 == 0 ? field_102011_e : (par1 == 1 ? field_102010_d : field_102009_f);
	}

	public boolean func_102007_a(int par1, ItemStack par2ItemStack, int par3) {
		return this.isStackValidForSlot(par1, par2ItemStack);
	}

	public boolean func_102008_b(int par1, ItemStack par2ItemStack, int par3) {
		return par3 != 0 || par1 != 1 || par2ItemStack.itemID == Item.bucketEmpty.itemID;
	}

	/***********************************************************************************
	 * This function is here for compatibilities sake, Modders should Check for Sided before ContainerWorldly, Vanilla Minecraft does not follow the sided standard that Modding has for a while.
	 * 
	 * In vanilla:
	 * 
	 * Top: Ores Sides: Fuel Bottom: Output
	 * 
	 * Standard Modding: Top: Ores Sides: Output Bottom: Fuel
	 * 
	 * The Modding one is designed after the GUI, the vanilla one is designed because its intended use is for the hopper, which logically would take things in from the top.
	 * 
	 * This will possibly be removed in future updates, and make vanilla the definitive standard.
	 */

	@Override
	public int getStartInventorySide(ForgeDirection side) {
		if (ForgeDummyContainer.legacyFurnaceSides) {
			if (side == ForgeDirection.DOWN)
				return 1;
			if (side == ForgeDirection.UP)
				return 0;
			return 2;
		} else {
			if (side == ForgeDirection.DOWN)
				return 2;
			if (side == ForgeDirection.UP)
				return 0;
			return 1;
		}
	}

	@Override
	public int getSizeInventorySide(ForgeDirection side) {
		return 1;
	}
}
