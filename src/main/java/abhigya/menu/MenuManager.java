package abhigya.menu;

import org.bukkit.plugin.java.JavaPlugin;

public final class MenuManager extends JavaPlugin {

    private static MenuManager instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static MenuManager getInstance() {
        return instance;
    }
}
