package me.Galaxy1007.boostpad;

import me.Galaxy1007.listeners.FallDamageListener;
import me.Galaxy1007.listeners.PlayerMoveListener;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class BoostPad extends JavaPlugin {

    public ArrayList <Player> jumping_players = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("[BoostPad] BoostPad Loaded");
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        //register events
        getServer().getPluginManager().registerEvents(new PlayerMoveListener(this), this);
        getServer().getPluginManager().registerEvents(new FallDamageListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("[BoostPad] BoostPad Unloaded");
    }
}
