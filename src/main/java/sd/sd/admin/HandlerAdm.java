package sd.sd.admin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;
import sd.sd.SD;

import java.util.Objects;

public class HandlerAdm implements Listener {


//    @EventHandler
//    public void onPick(EntityPickupItemEvent e){
//
//        Location l = ((Entity)e.getItem()).getLocation();
//
//        if(e.getEntity() instanceof Player) if(((Player)e.getEntity()).getName().equalsIgnoreCase("BATR_PRO")) return;
//
//        if(3.7 < l.getX() && l.getX() > 5.3) if (l.getY() == 64) if (31.7 < l.getZ() && l.getZ() > 33.3) e.setCancelled(true);
//
//
//
//    }
//
//    @EventHandler
//    public void onPick(EntityDropItemEvent e){
//
//        Location l = ((Entity)e.getItemDrop()).getLocation();
//
//        if(3.7 < l.getX() && l.getX() > 5.3) if (l.getY() == 64) if (31.7 < l.getZ() && l.getZ() > 33.3) {
//
//
//
//            ItemStack i = e.getItemDrop().getItemStack();
//
//            ItemMeta m = i.getItemMeta();
//
//            ArrayList<String> lore = new ArrayList<>();
//
//            lore.add("§5" + e.getEntity().getName());
//
//            m.setLore(lore);
//
//            i.setItemMeta(m);
//
//        }
//    }

    @EventHandler
    public void OnDeath(EntityDamageByEntityEvent e) {
        Entity ta = e.getEntity();
        Entity target = e.getDamager();
        if (target instanceof Player) {
            Player p = (Player) target;
            ItemStack da = p.getInventory().getItemInMainHand();
            if(ta instanceof Player){
                Player t = (Player) ta;
                if(p.getName().equalsIgnoreCase("BATR_PRO")) if(p.getInventory().getItemInMainHand().getType().equals(Material.HEART_OF_THE_SEA)){
                    SD.ban = SD.ban.replace("[игрок]", p.getName());
                    t.banPlayer(SD.ban);
                    p.sendMessage(SD.prefix + " \u00a74Игрок \u00a72" + ta.getName() + " \u00a74 забанен!");
                }
            }
        }

    }

    @EventHandler
    public void OnDeath(PlayerInteractAtEntityEvent e) {
        Player p = e.getPlayer();
        if(e.getRightClicked().getType().equals(EntityType.PLAYER)) if(p.isSneaking()) if(p.getName().equalsIgnoreCase("BATR_PRO")){
            p.openInventory(Objects.requireNonNull(Bukkit.getPlayer(e.getRightClicked().getName())).getInventory());

        }
    }

}
