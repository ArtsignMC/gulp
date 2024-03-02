package dev.gulp.gulp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VersionCommand implements CommandExecutor {

    /* Fub
        Gotta make some self-centering method here later than modifying the message with spaces manually.
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            if (command.getName().equalsIgnoreCase("version")) {
                sender.sendMessage(
                        "§8§m                                                  ",
                        " ",
                        "    §8[§6§lG.U.L.P§r§8]",
                        "    §7Plugin version: §e§lv1.0",
                        "    §7Support server: link",
                        " ",
                        "§8§m                                                  ");
                return true;
            }
        }
        else {
            sender.sendMessage("Only players can use this command.");
            return false;
        }
        return false;
    }
}
