package abhigya.menu.menu.item.voidaction;

import abhigya.menu.menu.Item;
import abhigya.menu.menu.action.ItemClickAction;
import org.bukkit.inventory.ItemStack;

public class VoidActionItem extends Item {

    public VoidActionItem(String name, ItemStack icon, String... lore) {
        super(name, icon, lore);
    }

    @Override
    public final void onClick(ItemClickAction action) {
        /* do nothing */
    }

}
