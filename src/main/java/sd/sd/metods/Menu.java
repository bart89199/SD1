package sd.sd.metods;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class Menu implements InventoryHolder {
    private Inventory inventory;
    /**
     * @param line  - Размер линий инвентаря от 1 до 6.
     * @param title - Заголовок инвентаря.
     */
    public Menu(int line, String title) {
        this.inventory = Bukkit.createInventory(this, 9 * line, title);
    }

    /**
     * @param stack - Итемстак.
     * @param slot  - Номер слота, от 0 до 9 * line.
     */
    public void setItemClot(ItemStack stack, int slot) {
        this.inventory.setItem(slot, stack);
    }


    /**
     * @return - Возвращает инвентарь.
     */
    @Override
    public Inventory getInventory() {
        return this.inventory;
    }

}