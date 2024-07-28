package sd.sd.handlers;

import io.papermc.paper.event.player.PlayerItemFrameChangeEvent;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.player.*;
import sd.sd.SD;

import static sd.sd.SD.*;

public class Register implements Listener {


//    @EventHandler
//    public void onCmd(PlayerCommandPreprocessEvent e){
//
//        switch (e.getMessage()){
//
//            case "Lol" -> e.setMessage("Lol 1");
//            case "Lol 123" -> e.setMessage("Lol 123 2");
//            case "abor" -> e.setMessage("abor 3");
//            case "abor 53" -> e.setMessage("abor 53 4");
//
//        }
//
//    }

//    @EventHandler
//    public void onTimer(PlayerMoveEvent e) {
//        if (!e.getPlayer().hasPermission("balt.reg")) {
//                e.setCancelled(true);
//        }
//    }
//
//    @EventHandler
//    public void stop(PlayerDropItemEvent e){
//        if(!e.getPlayer().hasPermission("balt.reg")){
//            e.setCancelled(true);
//        }
//    }
//    @EventHandler
//    public void stop(PlayerPickupItemEvent e){
//        Player p = e.getPlayer();
//        if(!p.hasPermission("balt.reg")){
//            e.setCancelled(true);
//        }
//    }
//
//
//     @EventHandler
//    public void onTimer(PlayerInteractEvent e) {
//        Player p = e.getPlayer();
//        if (!p.hasPermission("balt.reg")) {
//            e.setCancelled(true);
//        }
//    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        if (!e.getPlayer().hasPermission(reg_perm) || e.getPlayer().hasPermission(spawn_perm)) {
            if(SD.getInstance().getConfig().getBoolean("Spawn.On.Respawn", true)){
                if(SD.getInstance().getConfig().getLocation("Spawn.Location") != null){
                    e.setRespawnLocation(SD.getInstance().getConfig().getLocation("Spawn.Location"));
                }
            }
        }
    }

    @EventHandler (priority = EventPriority.HIGHEST)
    public void onFrameMove(PlayerInteractEntityEvent e) {
        if(!isHub) return;
        if(!e.getPlayer().hasPermission(admin_perm)) if (e.getPlayer().getWorld().getName().equals(SD.getInstance().getConfig().getString("Hub.World", "world"))) {
            if(e.getRightClicked().getType().equals(EntityType.ITEM_FRAME)){
                e.setCancelled(true);
            }
        }
    }


    @EventHandler (priority = EventPriority.HIGHEST)
    public void onPVP(EntityDamageByEntityEvent e) {
        if(!isHub) return;
        if(e.getDamager() instanceof Player && e.getEntity() instanceof Player)
        if(!e.getDamager().hasPermission(admin_perm)) if (e.getDamager().getWorld().getName().equals(SD.getInstance().getConfig().getString("Hub.World", "world"))) {
                e.setCancelled(true);
            }
        }

        @EventHandler (priority = EventPriority.HIGHEST)
    public void onItemFrameBreak(HangingBreakByEntityEvent e) {
            if(!isHub) return;
        if(e.getRemover() instanceof Player && e.getEntity() instanceof ItemFrame)
        if(!e.getRemover().hasPermission(admin_perm)) if (e.getRemover().getWorld().getName().equals(SD.getInstance().getConfig().getString("Hub.World", "world"))) {
                e.setCancelled(true);
            }
        }


    @EventHandler (priority = EventPriority.HIGHEST)
    public void onFrameInter(PlayerInteractEvent e) {
        if(e.getClickedBlock() == null) return;
        if(!isHub) return;
        if(!e.getPlayer().hasPermission(admin_perm)) if (e.getPlayer().getWorld().getName().equals(SD.getInstance().getConfig().getString("Hub.World", "world"))) {
            if(e.getClickedBlock().getType().equals(Material.ITEM_FRAME)){
                e.setCancelled(true);
            }
        }
    }

    @EventHandler (priority = EventPriority.HIGHEST)
    public void onFrameInter(PlayerItemFrameChangeEvent e) {
        if(!isHub) return;
        if(!e.getPlayer().hasPermission(admin_perm)) if (e.getPlayer().getWorld().getName().equals(SD.getInstance().getConfig().getString("Hub.World", "world"))) {
                e.setCancelled(true);
        }

    }

}
