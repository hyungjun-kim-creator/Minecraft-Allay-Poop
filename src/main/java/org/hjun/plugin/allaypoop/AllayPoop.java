package org.hjun.plugin.allaypoop;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class AllayPoop extends JavaPlugin {

    public static int allaypoopstate = 0;
    public static int Allay = 0;
    Logger logger = getServer().getLogger();

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new apevent(), this);
        getCommand("allaypoop").setExecutor(new apcommand());
        logger.info("[AllayPoop] AllayPoop plugin has successfully started!");
    }

    @Override
    public void onDisable() {
        logger.info("[AllayPoop] AllayPoop plugin has stoped!");
    }
}
