package dev.gulp.gulp;

import org.bukkit.plugin.java.JavaPlugin;

public final class Gulp extends JavaPlugin {

    @Override
    public void onEnable() {
        // test
        getLogger().info("Alive once more.");
    }

    @Override
    public void onDisable() {
        // test
        getLogger().info("Farewell.");
    }
}
