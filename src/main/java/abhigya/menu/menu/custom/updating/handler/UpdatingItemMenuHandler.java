package abhigya.menu.menu.custom.updating.handler;

import abhigya.menu.menu.ItemMenu;
import abhigya.menu.menu.handler.ItemMenuHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

public class UpdatingItemMenuHandler extends ItemMenuHandler {

    protected BukkitTask updater_task;

    public UpdatingItemMenuHandler(ItemMenu menu, Plugin plugin) {
        super(menu, plugin);
    }

    public boolean isUpdating() {
        return updater_task != null && Bukkit.getScheduler().isCurrentlyRunning(updater_task.getTaskId());
    }

    @Override
    public void unregisterListener() {
        super.unregisterListener();
        stopUpdating();
    }

    public void startUpdating(int start_delay, int ticks) {
        stopUpdating();
        this.updater_task = Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            this.menu.updateOnlinePlayers();
        }, start_delay, ticks);
    }

    public void stopUpdating() {
        if (updater_task != null) {
            updater_task.cancel();
            updater_task = null;
        }
    }

}
