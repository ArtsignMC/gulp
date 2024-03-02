package dev.gulp.gulp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import dev.gulp.gulp.commands.VersionCommand;

import java.util.ArrayList;
import java.util.List;

public final class Gulp extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("gulp").setTabCompleter(this);
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
                        return new VersionCommand().onCommand(sender, command, label, args);
                    default:
                        sender.sendMessage("Unknown command. Use /gulp <command>");
                        break;
                }
            } else {
                sender.sendMessage("Usage: /gulp <command>");
            }
            return true;
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (command.getName().equalsIgnoreCase("gulp")) {
            if (args.length == 1) {
                List<String> subCommands = new ArrayList<>();
                subCommands.add("version");
                return subCommands;
            }
        }
        return null;
    }
}
