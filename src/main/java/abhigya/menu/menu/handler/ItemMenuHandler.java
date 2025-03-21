package abhigya.menu.menu.handler;

import abhigya.menu.menu.ItemMenu;
import abhigya.menu.menu.action.ItemMenuClickAction;
import abhigya.menu.menu.holder.ItemMenuHolder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.plugin.Plugin;

public class ItemMenuHandler implements Listener {

    protected final ItemMenu menu;
    protected final Plugin plugin;

    public ItemMenuHandler(ItemMenu menu, Plugin plugin) {
        this.menu = menu;
        this.plugin = plugin;
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public void delayedOpen(Player player, int delay) {
        delayed(() -> {
            menu.open(player);
        }, delay);
    }

    public void delayedUpdate(Player player, int delay) {
        delayed(() -> {
            menu.update(player);
        }, delay);
    }

    public void delayedClose(Player player, int delay) {
        delayed(() -> {
            menu.close(player);
        }, delay);
    }

    public void unregisterListener() {
        HandlerList.unregisterAll(this);
    }

    protected void delayed(Runnable runnable, int delay) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, runnable, delay);
    }

    @SuppressWarnings("deprecation")
    @EventHandler(priority = EventPriority.LOWEST)
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory() == null
                || event.getInventory().getType() != InventoryType.CHEST
                || !(event.getWhoClicked() instanceof Player)
                || !(event.getInventory().getHolder() instanceof ItemMenuHolder)) {
            return;
        }

        ItemMenuHolder holder = (ItemMenuHolder) event.getInventory().getHolder();
        if (!menu.equals(holder.getItemMenu())) {
            return;
        }

        final ItemMenuClickAction action = new ItemMenuClickAction(menu, event);
        ((ItemMenuHolder) event.getInventory().getHolder()).getItemMenu().onClick(action);
        event.setCurrentItem(action.getCurrentItem());
        event.setCursor(action.getCursor());
        event.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPluginDisable(PluginDisableEvent event) {
        if (event.getPlugin().equals(plugin)) {
            this.menu.closeOnlinePlayers();
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((menu == null) ? 0 : menu.hashCode());
        result = prime * result + ((plugin == null) ? 0 : plugin.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ItemMenuHandler other = (ItemMenuHandler) obj;
        if (menu == null) {
            if (other.menu != null)
                return false;
        } else if (!menu.equals(other.menu))
            return false;
        if (plugin == null) {
            if (other.plugin != null)
                return false;
        } else if (!plugin.getDescription().getFullName().equals(other.plugin.getDescription().getFullName()))
            return false;
        return true;
    }

}
