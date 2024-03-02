package dev.gulp.gulp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodModeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be executed by players.");
            return false;
        }

        Player player = (Player) sender;

        if (args.length == 0 || (args.length == 1 && args[0].equalsIgnoreCase("godmode") || args[0].equalsIgnoreCase("god"))) {
            toggleGodMode(player);
            return true;
        } else {
            sender.sendMessage("§8[§6§lG.U.L.P§r§8]§7 Usage: §e/gulp godmode");
            return false;
        }
    }

    private void toggleGodMode(Player player) {
        if (player.isInvulnerable()) {
            player.setInvulnerable(false);
            player.sendMessage(" ",
                    "   §8[§6§lG.U.L.P§r§8]",
                    "   §7Godmode: §a§lENABLED",
                    " ");
        } else {
            player.setInvulnerable(true);
            player.sendMessage(" ",
                    "   §8[§6§lG.U.L.P§r§8]",
                    "   §7Godmode: §c§lDISABLED",
                    " ");
        }
    }
}
