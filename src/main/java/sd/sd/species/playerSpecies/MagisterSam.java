package sd.sd.species.playerSpecies;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.event.player.PlayerHarvestBlockEvent;
import org.bukkit.event.world.StructureGrowEvent;
import org.bukkit.inventory.ItemStack;
import sd.sd.SD;
import sd.sd.species.Specie;

import java.util.Random;

public class MagisterSam extends Specie implements Listener {

    public MagisterSam(String playerName){
        super(playerName);
    }


    @Override
    public Specie getPlayerSpecie() {
        return this;
    }

    @EventHandler
    public void onBlockDropItem(BlockDropItemEvent e) {
        if (SD.isHub) return;

        if(SD.playersSpecies.get(e.getPlayer().getName()).equals(this)){
            Block blok = e.getBlock();
            Player p = e.getPlayer();
            Random r = new Random();
            switch (blok.getType()) {
                case WHEAT -> {
                    p.sendMessage("1");
                    if(r.nextInt(2) == 1) blok.getWorld().dropItem(blok.getLocation(), new ItemStack(Material.WHEAT));
                }
                case BEETROOTS -> {
                    p.sendMessage("1");
                    if(r.nextInt(2) == 1) blok.getWorld().dropItem(blok.getLocation(), new ItemStack(Material.BEETROOT));
                }
                case CARROTS -> {
                    p.sendMessage("1");
                    blok.getWorld().dropItem(blok.getLocation(), new ItemStack(Material.CARROT, r.nextInt(3)));
                }
                case POTATOES -> {
                    p.sendMessage("1");
                    blok.getWorld().dropItem(blok.getLocation(), new ItemStack(Material.POTATO, r.nextInt(3)));
                }
                case COCOA_BEANS -> {
                    p.sendMessage("1");
                    blok.getWorld().dropItem(blok.getLocation(), new ItemStack(Material.COCOA_BEANS, r.nextInt(3)));
                }
                case NETHER_WART_BLOCK -> {
                    p.sendMessage("1");
                    blok.getWorld().dropItem(blok.getLocation(), new ItemStack(Material.NETHER_WART, r.nextInt(3)));
                }
                case SUGAR_CANE -> {
                    p.sendMessage("1");
                    if(r.nextInt(3) == 1) blok.getWorld().dropItem(blok.getLocation(), new ItemStack(Material.SUGAR_CANE));
                }
                case MELON -> {
                    p.sendMessage("1");
                    blok.getWorld().dropItem(blok.getLocation(), new ItemStack(Material.MELON_SLICE, r.nextInt(3)));
                }
            }
        }

    }

    @EventHandler
    public void onPlayerHarvestBlockEvent(PlayerHarvestBlockEvent e) {
        if (SD.isHub) return;

        if(SD.playersSpecies.get(e.getPlayer().getName()).equals(this)){
            Block blok = e.getHarvestedBlock();
            Random r = new Random();
            Player p = e.getPlayer();
            switch (blok.getType()) {
                case SWEET_BERRY_BUSH -> {
                    p.sendMessage("2");
                    if(r.nextInt(2) == 1) blok.getWorld().dropItem(blok.getLocation(), new ItemStack(Material.SWEET_BERRIES, r.nextInt(2)+1));
                }
                case GLOW_BERRIES -> {
                    p.sendMessage("2");
                    if(r.nextInt(2) == 1) blok.getWorld().dropItem(blok.getLocation(), new ItemStack(Material.GLOW_BERRIES, r.nextInt(2)+1));
                }
            }
        }

    }

    @EventHandler
    public void onStructureGrowEvent(StructureGrowEvent e) {
        if (SD.isHub) return;

        if(SD.playersSpecies.get(e.getPlayer().getName()).equals(this)){
            e.getPlayer().sendMessage("3");
            if(new Random().nextInt(3) != 2) e.setCancelled(true);
        }

    }
}


