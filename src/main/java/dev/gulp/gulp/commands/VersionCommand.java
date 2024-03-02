package dev.gulp.gulp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VersionCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be executed by players.");
            return false;
        }

        if (args.length == 0 || (args.length == 1 && args[0].equalsIgnoreCase("version") || args[0].equalsIgnoreCase("ver"))) {
            sender.sendMessage(" ",
                    "   §8[§6§lG.U.L.P§r§8]",
                    "   §7Plugin version: §e§lv1.0",
                    "   §7Discord:§e https://discord.gg/vUKeqs4NYf",
                    " ");
            return true;
        } else {
            StringBuilder remainingArgs = new StringBuilder();
            for (int i = 1; i < args.length; i++) {
                remainingArgs.append(args[i]).append(" ");
            }

            sender.sendMessage("§8[§6§lG.U.L.P§r§8]§7 Unknown arguments: §e" + remainingArgs);
            return false;
        }
    }
}
