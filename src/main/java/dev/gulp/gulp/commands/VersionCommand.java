package dev.gulp.gulp.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VersionCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //Instance of pattern match to see if a Player ran the command
        if (sender instanceof Player){
             Player p = (Player) sender;
            // Send The Player The Current Plugin Version
            p.sendMessage(ChatColor.GRAY + "Gulp version " + ChatColor.GOLD + "1.0-SNAPSHOT");
        }

        return true;
    }
}