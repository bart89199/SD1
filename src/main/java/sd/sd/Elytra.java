package sd.sd;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import sd.sd.species.Species;

public class Elytra implements Listener {

    @EventHandler
    public void OnRepair(EnchantItemEvent e) {
        if(e.getItem().getType().equals(Material.ELYTRA)){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void OnRepair(PrepareItemEnchantEvent e) {
        if(e.getItem().getType().equals(Material.ELYTRA)){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void OnRepair(PrepareAnvilEvent e) {
        if(e.getResult() == null) return;
        if(e.getResult().getType().equals(Material.ELYTRA)) if(Species.getSpecie((Player) e.getView().getPlayer()) == null || !Species.getSpecie((Player) e.getView().getPlayer()).equals(Species.ДРАКОНИДЫ)) {
                e.setResult(new ItemStack(Material.AIR));
        }else{
            if(e.getResult().getItemMeta().hasEnchants()){
                e.setResult(new ItemStack(Material.AIR));
            }
        }
    }

    @EventHandler
    public void OnRepair(PlayerArmorChangeEvent e) {
        if(e.getNewItem() != null && (e.getNewItem().getType().equals(Material.ELYTRA) && ((Damageable)e.getNewItem().getItemMeta()).getDamage() >= 432)){
            e.getPlayer().getInventory().setChestplate(null);
        }
        if(e.getNewItem() != null && (e.getNewItem().getType().equals(Material.ELYTRA) && e.getNewItem().getItemMeta().hasEnchants())){
            ItemStack item = e.getNewItem();
            ItemMeta m = item.getItemMeta();
            m.removeEnchant(Enchantment.MENDING);
            m.removeEnchant(Enchantment.DURABILITY);
            item.setItemMeta(m);
            e.getPlayer().getInventory().setChestplate(item);
        }
    }
}
