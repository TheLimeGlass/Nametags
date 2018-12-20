/* Copyright 2016 Acquized
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	 http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.acquized.nametags;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.acquized.nametags.placeholders.Placeholder;
import com.acquized.nametags.placeholders.PlaceholderAPIHook;
import com.acquized.nametags.placeholders.StockPlaceholder;

import java.io.File;
import java.util.logging.Level;

public class Nametags extends JavaPlugin {

	private static Placeholder placeholder;
	private static Nametags instance;

	@Override
	public void onEnable() {
		instance = this;
		Plugin plugin = Bukkit.getPluginManager().getPlugin("ProtocolLib");
		if (plugin == null || !plugin.isEnabled()) {
			getLogger().log(Level.SEVERE, "Could not find ProtocolLib. Please install ProtocolLib and restart the server.");
			Bukkit.getPluginManager().disablePlugin(this);
			return;
		}
		if (!getDescription().getVersion().equals(getConfig().getString("version"))) {
			getLogger().info("New version found! Updating configuration now...");
			File config = new File(getDataFolder(), "config.yml");
			if (config.exists())
				new SpigotConfigSaver(this).execute();
		}
		saveDefaultConfig();
		plugin = Bukkit.getPluginManager().getPlugin("PlaceholderAPI");
		if (plugin != null && plugin.isEnabled()) {
			placeholder = new PlaceholderAPIHook();
		} else {
			placeholder = new StockPlaceholder();
		}
		getLogger().info("Nametags has been enabled.");
	}
	
	public static Placeholder getPlaceholder() {
		return placeholder;
	}
	
	public static Nametags getInstance() {
		return instance;
	}
	
}
