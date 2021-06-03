package abhigya.menu.menu.item.action.back;

import abhigya.menu.menu.action.ItemClickAction;
import abhigya.menu.menu.item.action.ActionItem;
import abhigya.menu.menu.item.action.ItemAction;
import abhigya.menu.menu.item.action.ItemActionPriority;
import org.bukkit.inventory.ItemStack;

public class BackActionItem extends ActionItem {

    public BackActionItem(String name, ItemStack icon, String[] lore) {
        super(name, icon, lore);
        addAction(new ItemAction() {

            @Override
            public ItemActionPriority getPriority() {
                return ItemActionPriority.LOW;
            }

            @Override
            public void onClick(ItemClickAction action) {
                action.setGoBack(true);
            }
        });
    }

}
