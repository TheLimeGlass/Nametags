package com.acquized.nametags.placeholders;

import org.bukkit.OfflinePlayer;

public class StockPlaceholder implements Placeholder {

	@Override
	public String replace(OfflinePlayer player, String input) {
		return input;
	}

}
