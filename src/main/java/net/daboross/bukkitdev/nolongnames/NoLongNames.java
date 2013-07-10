/*
 * Author: Dabo Ross
 * Website: www.daboross.net
 * Email: daboross@daboross.net
 */
package net.daboross.bukkitdev.nolongnames;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author daboross
 */
public class NoLongNames extends JavaPlugin implements Listener {

    private int maxNameLength;
    private String kickMessage;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(this, this);
    }

    @Override
    public void onDisable() {
    }

    private void reload() {
        reloadConfig();
        maxNameLength = getConfig().getInt("maxnamelength");
        kickMessage = getConfig().getString("kickmessage");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("reloadnln")) {
            reload();
            sender.sendMessage("NoLongName's config has been reloaded.");
            sender.sendMessage("Will kick players with names longer than " + maxNameLength + " characters with kick message:");
            sender.sendMessage("'" + kickMessage + "'");
        } else {
            sender.sendMessage("NoLongNames doesn't know about the command /" + cmd);
        }
        return true;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent pje) {
        if (pje.getPlayer().getName().length() > maxNameLength) {
            pje.getPlayer().kickPlayer(kickMessage);
        }
    }
}
