package sd.sd.stonecutter;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import sd.sd.metods.Menu;

import static sd.sd.SD.stoneCutterCrafts;

public enum GUI_test {

    EditCrafts(1), EditCraft(2), Accept(3);

    GUI_test(int number) {this.number = number;}

    private int number;

    public Inventory get(ItemStack item){
        Inventory menu = new Menu(5, "§3Меню редактирования крафта").getInventory();

        for (int i = 0; i < 45; i++) {
            ItemStack v = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemMeta m = v.getItemMeta();
            m.setDisplayName(" ");
            v.setItemMeta(m);
            menu.setItem(i, v);
        }

        ItemStack i = new ItemStack(Material.BARRIER);
        ItemMeta m = i.getItemMeta();
        m.setDisplayName("§4Удалить предмет");
        menu.setItem(36, stoneCutterCrafts.setResultOnItem(stoneCutterCrafts.getResultOnItem(item)));

        i = new ItemStack(Material.GREEN_BANNER);
        m = i.getItemMeta();
        m.setDisplayName("§aСохранить§7(§8без тегов§7)");
        m.setLocalizedName("save");
        i.setItemMeta(m);
        menu.setItem(45, i);

        i = new ItemStack(Material.CANDLE);
        m = i.getItemMeta();
        m.setDisplayName("§7Назад");
        m.setLocalizedName("back");
        i.setItemMeta(m);
        menu.setItem(0, i);

        ItemStack[] ingredients = stoneCutterCrafts.getResultOnItem(item);

        for(ItemStack it : ingredients){
            if(it.getType().isEmpty()) it.setType(Material.AIR);
        }

        menu.setItem(28, ingredients[0]);
        menu.setItem(29, ingredients[1]);
        menu.setItem(30, ingredients[2]);
        menu.setItem(31, ingredients[6]);
        menu.setItem(32, ingredients[3]);
        menu.setItem(33, ingredients[4]);
        menu.setItem(34, ingredients[5]);

        for(ItemStack it : ingredients){
            if(it.getType().isEmpty()){
                it.setType(Material.STRUCTURE_VOID);
            }
            m = it.getItemMeta();
            m.setLocalizedName("test");
            it.setItemMeta(m);
        }

        menu.setItem(10, ingredients[0]);
        menu.setItem(11, ingredients[1]);
        menu.setItem(12, ingredients[2]);
        menu.setItem(13, ingredients[6]);
        menu.setItem(14, ingredients[3]);
        menu.setItem(15, ingredients[4]);
        menu.setItem(16, ingredients[5]);

        return menu;
    }
}
