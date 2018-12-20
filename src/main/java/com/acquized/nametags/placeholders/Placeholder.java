package com.acquized.nametags.placeholders;

import org.bukkit.OfflinePlayer;

public interface Placeholder {

	/**
	 * @param player The OfflinePlayer to base the placeholder results off of.
	 * @param input The input string with placeholders to parse.
	 * @return The final formatted placeholder string.
	 */
	String replace(OfflinePlayer player, String input);
	
}
