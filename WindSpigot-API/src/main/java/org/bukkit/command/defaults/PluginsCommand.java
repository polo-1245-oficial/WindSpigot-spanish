package org.bukkit.command.defaults;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class PluginsCommand extends BukkitCommand {
	public PluginsCommand(String name) {
		super(name);
		this.description = "Gets a list of plugins running on the server";
		this.usageMessage = "/plugins";
		this.setPermission("bukkit.command.plugins");
		this.setAliases(Arrays.asList("pl"));
	}

	@Override
	public boolean execute(CommandSender sender, String currentAlias, String[] args) {
		if (!testPermission(sender))
			return true;

		sender.sendMessage("§cque miras");
		return true;
	}

	private String getPluginList() {
		StringBuilder pluginList = new StringBuilder();
		Plugin[] plugins = Bukkit.getPluginManager().getPlugins();

		for (Plugin plugin : plugins) {
			if (pluginList.length() > 0) {
				pluginList.append(ChatColor.WHITE);
				pluginList.append(", ");
			}

			pluginList.append(plugin.isEnabled() ? ChatColor.GREEN : ChatColor.RED);
			pluginList.append(plugin.getDescription().getName());
		}

		return "(" + plugins.length + "): " + pluginList.toString();
	}

	// Spigot Start
	@Override
	public java.util.List<String> tabComplete(CommandSender sender, String alias, String[] args)
			throws IllegalArgumentException {
		return java.util.Collections.emptyList();
	}
	// Spigot End
}
