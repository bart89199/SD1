package sd.sd.stonecutter;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import sd.sd.SD;

import java.util.ArrayList;
import java.util.List;

import static sd.sd.SD.ListOfRecipesSlots;

public class Open implements Listener, InventoryHolder{


    private SD plugin;

    public Open(SD plugin) {
        this.plugin = plugin;
    }

    private Inventory menu;
    private Inventory guyed;

    @EventHandler
    public void onTimer(PlayerInteractEvent e) {
        if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) if(!(e.getClickedBlock() == null)) if(e.getClickedBlock().getType().equals(Material.STONECUTTER)) {
            Player p = e.getPlayer();
            e.setCancelled(true);
            p.openInventory(Menu(e.getClickedBlock()));
        }
    }

    public Inventory Menu(Block block){
        menu = Bukkit.createInventory( this, 9*5, "Камнерез");
        for (int i = 0; i < 45; i++) {
            ItemStack v = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemMeta m = v.getItemMeta();
            m.setDisplayName(" ");
            v.setItemMeta(m);
            menu.setItem(i, v);
        }
        ItemStack v = new ItemStack(Material.AIR);
        menu.setItem(10, v);
        menu.setItem(11, v);
        menu.setItem(12, v);
        menu.setItem(25, v);
        menu.setItem(34, v);
        menu.setItem(14, v);
        v = new ItemStack(Material.BARRIER);
        ItemMeta m = v.getItemMeta();
        m.setDisplayName("§4Требуется диск!");
        v.setItemMeta(m);
        menu.setItem(16, v);
        menu.setItem(25, v);
        menu.setItem(34, v);
        ItemStack guyed = new ItemStack(Material.WRITABLE_BOOK);
        m = guyed.getItemMeta();
        m.setDisplayName("§6Гайд");
        List<String> lore = new ArrayList<>();
        lore.add("§7Как работает этот камнерез?");
        lore.add("§7Какие рецепты есть теперь?");
        m.setLore(lore);
        m.setLocalizedName("StoneCutter");
        guyed.setItemMeta(m);
        menu.setItem(5, guyed);
        v = new ItemStack(Material.BARRIER);
        m = v.getItemMeta();
        m.setDisplayName("§4Нет вариантов обработки");
        v.setItemMeta(m);
        for(Integer n : ListOfRecipesSlots){
            menu.setItem(n, v);
        }

        v = new ItemStack(Material.SEAGRASS);
        m = v.getItemMeta();
        m.setDisplayName("§6Обновить");
        v.setItemMeta(m);
        menu.setItem(8, v);
        v = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);m = v.getItemMeta();
        m.setDisplayName(" ");
        m.setLocalizedName(String.valueOf(block));
        v.setItemMeta(m);
        menu.setItem(1, v);
        return menu;
    }

    @Override
    public @NotNull Inventory getInventory() {
        return null;
    }
}
