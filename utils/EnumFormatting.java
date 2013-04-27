package mods.nordwest.utils;

public enum EnumFormatting
{
	/* Formatting */
	UDERLINE ("\u00a7n", "Underline"),
	STRIKETHROUGH ("\u00a7m", "Strikethrough"),
	ITALIC ("\u00a7o", "Italic"),
	BOLD ("\u00a7l", "Bold"),
	RESET ("\u00a7r", "Reset");
	
	/** The color code that will be displayed */
	public final String code;
	
	/** A friendly name of the color. */
	public String friendlyName;
	
	private EnumFormatting(String s, String n)
	{
		code = s;
		friendlyName = n;
	}
	
	public String getName()
	{
		return code + friendlyName;
	}
	
	@Override
	public String toString()
	{
		return code;
	}
}
