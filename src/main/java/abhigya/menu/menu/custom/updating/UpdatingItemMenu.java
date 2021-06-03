package abhigya.menu.menu.custom.updating;

import abhigya.menu.menu.Item;
import abhigya.menu.menu.ItemMenu;
import abhigya.menu.menu.custom.updating.handler.UpdatingItemMenuHandler;
import abhigya.menu.menu.size.ItemMenuSize;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class UpdatingItemMenu extends ItemMenu {

    public UpdatingItemMenu(String title, ItemMenuSize size, ItemMenu parent, Item... contents) {
        super(title, size, parent, contents);
    }

    @Override
    public UpdatingItemMenuHandler getHandler() {
        return (UpdatingItemMenuHandler) this.handler;
    }

    @Override
    public boolean registerListener(Plugin plugin) {
        if (this.handler == null) {
            Bukkit.getPluginManager().registerEvents((this.handler = new UpdatingItemMenuHandler(this, plugin)), plugin);
            return true;
        }
        return false;
    }

}
