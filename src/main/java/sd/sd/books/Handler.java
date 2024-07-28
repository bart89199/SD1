package sd.sd.books;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import sd.sd.SD;

import java.util.Objects;

public class Handler implements Listener {


    private SD plugin;

    public Handler(SD plugin) {
        this.plugin = plugin;
    }
    // Открытие инвенторя
    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent e) {
        Inventory inventory = e.getInventory();
        for (ItemStack item : inventory.getContents()) { // проходимся циклом по вещам и обновляем книги
            if (item == null) continue;
            updateBook(item);
        }
    }

    // shift + ПКМ
    // /**
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        //if (!p.isSneaking()) return; // проверяем, если игрок сидит на шифте
        if (e.getAction() != Action.RIGHT_CLICK_AIR &&
                e.getAction() != Action.RIGHT_CLICK_BLOCK) return; // проверяем, если "действие" не правый клик

        // тут все и так очевидно
        ItemStack item = e.getItem();

        if (item == null) return;
        updateBook(item);
    }
//*/
    private String extractAuthor(BookMeta meta) {
        // реплейсим регекс и тримим
        return Objects.requireNonNull(meta.getAuthor()).replaceAll("(§a\\(онлайн\\)|§c\\(оффлайн\\))", "").trim();
    }

    private void updateBook(ItemStack item) {
        if (item.getType() != Material.WRITTEN_BOOK) return; // Проверяем подписанная ли это книга
        BookMeta bookMeta = (BookMeta) item.getItemMeta(); // Получаем мету
        if(!bookMeta.hasAuthor()) return;

        String authorName = extractAuthor(bookMeta); // достаем имя автора

        bookMeta.setAuthor(authorName + (Bukkit.getPlayer(authorName) == null ? " §c(оффлайн)" : " §a(онлайн)")); // устанавливаем автора

        item.setItemMeta(bookMeta); // Устанавливаем мету
    }


}
