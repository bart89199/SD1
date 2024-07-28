package sd.sd.shops;

import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryHolder;

public interface ShopGUIInventory extends InventoryHolder {

    public ShopGUI.ShopGUIFormat getFormat();


    public void generateInventory(Player p, Shop shop);

}
