package com.acquized.nametags.placeholders;

import org.bukkit.OfflinePlayer;
import me.clip.placeholderapi.PlaceholderAPI;

public class PlaceholderAPIHook implements Placeholder {

	@Override
	public String replace(OfflinePlayer player, String input) {
		return PlaceholderAPI.setPlaceholders(player, input);
	}

}
