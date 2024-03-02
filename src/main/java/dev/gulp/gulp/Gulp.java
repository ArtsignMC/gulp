package dev.gulp.gulp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import dev.gulp.gulp.commands.VersionCommand;
import dev.gulp.gulp.commands.GodModeCommand;

import java.util.ArrayList;
import java.util.List;

public final class Gulp extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("gulp").setTabCompleter(this);
        getCommand("version").setExecutor(new VersionCommand());
        getCommand("ver").setExecutor(new VersionCommand());
        getCommand("godmode").setExecutor(new GodModeCommand());
        getCommand("god").setExecutor(new GodModeCommand());
        getLogger().info("\u001B[32m" + "[G.U.L.P] > Enabled" + "\u001B[0m");
    }

    @Override
    public void onDisable() {
        getLogger().info("\u001B[31m" + "[G.U.L.P] > Disabled" + "\u001B[0m");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("gulp")) {
            if (args.length >= 1) {
                String subCommand = args[0].toLowerCase();
                switch (subCommand) {
                    case "version":
                    case "ver":
                        if (args.length > 1) {
                            sender.sendMessage("§8[§6§lG.U.L.P§r§8]§7 Unknown arguments, use §e/gulp version");
                            return true; // Return true here to prevent sending "/gulp gulp"
                        }
                        return new VersionCommand().onCommand(sender, command, label, args);
                    case "godmode":
                    case "god":
                        if (args.length > 1) {
                            sender.sendMessage("§8[§6§lG.U.L.P§r§8]§7 Unknown arguments, use §e/gulp godmode");
                            return true; // Return true here to prevent sending "/gulp gulp"
                        }
                        return new GodModeCommand().onCommand(sender, command, label, args);
                    default:
                        sender.sendMessage("§8[§6§lG.U.L.P§r§8]§7 Unknown arguments, use §e/gulp <command>");
                        break;
                }
            } else {
                sender.sendMessage("§8[§6§lG.U.L.P§r§8]§7 Usage: §e/gulp <command>");
            }
            return true; // Return true here to prevent sending "/gulp gulp"
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (command.getName().equalsIgnoreCase("gulp")) {
            if (args.length == 1) {
                List<String> subCommands = new ArrayList<>();
                subCommands.add("version");
                subCommands.add("ver");
                subCommands.add("godmode");
                subCommands.add("god");
                return subCommands;
            }
        }
        return null;
    }
}