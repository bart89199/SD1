package sd.sd.handlers;


import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import sd.sd.SD;

import java.util.List;

public class ChestsCheck implements Listener {

    private SD plugin;

    public ChestsCheck(SD plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onOpenChest(PlayerInteractEvent e) {
        if (e.getClickedBlock() != null && (e.getClickedBlock().getType() == Material.CHEST || e.getClickedBlock().getType() == Material.TRAPPED_CHEST || e.getClickedBlock().getType() == Material.SHULKER_BOX)) {
//            try {
            List<String> list =  SD.getShops().getConfig().getStringList("Chests");
            if(list.isEmpty()) return;
            for (String cor : list){
//                if(Balt.getInstance().getConfig().getBoolean("TestTest")) e.getPlayer().sendMessage(cor.substring(0, cor.indexOf(' ')) + " " + cor.substring(cor.indexOf(" ") + 1, cor.indexOf(' ', cor.indexOf(" ") + 2)) + " "  + cor.substring(cor.lastIndexOf(" ") + 1));
                    if(Integer.parseInt(cor.substring(0, cor.indexOf(' '))) == e.getClickedBlock().getX() && Integer.parseInt(cor.substring(cor.indexOf(" ") + 1, cor.indexOf(' ', cor.indexOf(" ") + 2))) == e.getClickedBlock().getY() && Integer.parseInt(cor.substring(cor.lastIndexOf(" ") + 1)) == e.getClickedBlock().getZ()){
                        if(SD.getInstance().getConfig().getBoolean("TestTest")) e.getPlayer().sendMessage("1");
//                        e.getPlayer().openInventory(((Chest)e.getClickedBlock().getBlockData().clone()).);
//                        e.getPlayer().openInventory(((CraftChest)(((org.bukkit.craftbukkit.v1_19_R1.block.impl.CraftChest) e.getClickedBlock().getBlockData().clone()).getState())).getInventory());

                        e.setCancelled(true);

                   //     Balt.getTags().getConfig().set("Chest", ((CraftChest) e.getClickedBlock().getState()).getBlockInventory());
                  //      e.getPlayer().openInventory((Inventory) Balt.getTags().getConfig().get("Chest"));
                  //      Balt.getTags().getConfig().set("Chest", null);
                        return;
                    }
//e.getClickedBlock().getBlockData()
                }
//            }catch (Exception ex){
//                Bukkit.getConsoleSender().sendMessage(Balt.sd + " §4Внимание произошла ошибка во время обработки открытия хранилища!!!");
//            }
        }
    }

}
