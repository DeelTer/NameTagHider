package ru.deelter.namehider;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;

public class NameHideListener implements Listener {

    @EventHandler
    public void onJoin(@NotNull PlayerJoinEvent event) {
        NameHider.getTeam().addEntry(event.getPlayer().getName());
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        Entity interactedPlayer = event.getRightClicked();

        if (interactedPlayer instanceof Player) {
            event.getPlayer().sendActionBar(Component.text("§6-=[§f" + interactedPlayer.getName() + "§6]=-"));
        }
    }
}
