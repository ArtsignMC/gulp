package dev.gulp.gulp;

import dev.gulp.gulp.commands.VersionCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Gulp extends JavaPlugin {

    @Override
    public void onEnable() {

        getCommand("version").setExecutor(new VersionCommand());
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
