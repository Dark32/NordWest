package mods.nordwest.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import mods.nordwest.common.NordWest;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BaseFood extends BaseItem {

	private static HashMap<Integer, List> statsFood = new HashMap<Integer, List>();
	private boolean alwaysEdible;


	private Icon[] arrayItemIcon;

	public BaseFood(int par1) {
		super(par1);
		this.setCreativeTab(NordWest.tabNord);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	public static void addFoodStats(String name, int healAmount, int saturationModifier, EnumRarity rare, PotionEffect potion) {
		List value = new ArrayList();
		value.add(name);
		value.add(healAmount);
		value.add(saturationModifier);
		value.add(false);
		value.add(rare);
		value.add(potion);
		int sub = statsFood.size();
		statsFood.put(sub, value);
	}

	public static void addFoodStats(String name, int healAmount, int saturationModifier, PotionEffect potion) {
		addFoodStats(name, saturationModifier, saturationModifier, EnumRarity.common, potion);
	}

	public static void addFoodStats(String name, int healAmount, int saturationModifier, EnumRarity rare) {
		addFoodStats(name, saturationModifier, saturationModifier, rare, null);
	}

	public static void addFoodStats(String name, int healAmount, int saturationModifier) {
		addFoodStats(name, saturationModifier, saturationModifier, EnumRarity.common, null);
	}

	public static String getName(int key) {
		return (String) statsFood.get(key).get(0);
	}

	public static int getSize() {
		return (int) statsFood.size();
	}

	public static EnumRarity getEnumRare(int key) {
		return (EnumRarity) statsFood.get(key).get(4);
	}

	public static PotionEffect getPotionEffect(int key) {
		return (PotionEffect) statsFood.get(key).get(5);

	}

	@Override
	public ItemStack onEaten(ItemStack item, World world, EntityPlayer player) {
		int meta = item.getItemDamage();
		--item.stackSize;
		player.getFoodStats().addStats(this.getHealAmount(meta), this.getSaturationModifier(meta));
		world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
		this.onFoodEaten(item, world, player);
		return item;
	}

	//@Override
	protected void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		if (getPotionEffect(par1ItemStack.getItemDamage()) != null) {
			par3EntityPlayer.addPotionEffect(getPotionEffect(par1ItemStack.getItemDamage()));
		}
	}

	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return 32;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.eat;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		if (par3EntityPlayer.canEat(this.alwaysEdible)) {
			par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		}
		return par1ItemStack;
	}

	public int getHealAmount(int key) {
		return (Integer) statsFood.get(key).get(1);
	}

	public float getSaturationModifier(int key) {
		return (Integer) statsFood.get(key).get(2);
	}

	@Override
	public void registerIcons(IconRegister iconRegister) {
		arrayItemIcon = new Icon[getSize()];
		for (int i = 0; i < getSize(); ++i) {
			arrayItemIcon[i] = iconRegister.registerIcon("nordwest:" + this.getUnlocalizedName() + "." + this.getName(i));
		}

	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		return super.getUnlocalizedName(itemstack) + "." + this.getName(itemstack.getItemDamage());
	}

	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return getEnumRare(par1ItemStack.getItemDamage());
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack) {
		return getEnumRare(par1ItemStack.getItemDamage()) == EnumRarity.epic;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1) {
		int j = MathHelper.clamp_int(par1, 0, getSize());
		return this.arrayItemIcon[j];
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int j = 0; j < getSize(); ++j) {
			par3List.add(new ItemStack(par1, 1, j));
		}
	}
}
