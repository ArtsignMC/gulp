package dev.gulp.gulp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VersionCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 0 || (args.length == 1 && args[0].equalsIgnoreCase("version"))) {
                sender.sendMessage(" ",
                        "§8[§6§lG.U.L.P§r§8]",
                        "§7Plugin version: §e§lv1.0",
                        "§7Support server: link",
                        " ");
                return true;
            } else {
                sender.sendMessage("Usage: /gulp version");
                return false;
            }
        } else {
            sender.sendMessage("Only players can use this command.");
            return false;
        }
    }
}
