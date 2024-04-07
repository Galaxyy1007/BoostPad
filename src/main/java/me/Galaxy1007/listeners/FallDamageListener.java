package me.Galaxy1007.listeners;

import me.Galaxy1007.boostpad.BoostPad;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class FallDamageListener implements Listener {

    BoostPad plugin;

    public FallDamageListener(BoostPad plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onFallDamage(EntityDamageEvent e) {
        if  (e.getCause() == EntityDamageEvent.DamageCause.FALL && plugin.getConfig().getBoolean("disable-fall-damage")) {
            if (plugin.jumping_players.contains(e.getEntity())) {
                e.setCancelled(true);
                plugin.jumping_players.remove(e.getEntity());
            }
        }
    }
}
