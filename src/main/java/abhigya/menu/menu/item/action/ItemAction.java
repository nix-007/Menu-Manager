package abhigya.menu.menu.item.action;

import abhigya.menu.menu.action.ItemClickAction;

public interface ItemAction {

    public ItemActionPriority getPriority();

    public void onClick(ItemClickAction action);

}
