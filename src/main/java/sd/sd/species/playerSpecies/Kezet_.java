package sd.sd.species.playerSpecies;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import sd.sd.SD;
import sd.sd.species.Specie;

import java.util.Map;
import java.util.Random;

public class Kezet_ extends Specie implements Listener {

    public Kezet_(String playerName){
        super(playerName);
    }


    @Override
    public Specie getPlayerSpecie() {
        return this;
    }


    @EventHandler
    public void onEnchant(EnchantItemEvent e) {
        if (SD.isHub) return;

        Player p = e.getEnchanter();

        if(SD.playersSpecies.get(p.getName()).equals(this)){

            e.setExpLevelCost((int) (e.getExpLevelCost() * 1.35));

            Map<Enchantment, Integer> enc = e.getEnchantsToAdd();
            ItemStack item = e.getItem();
            ItemMeta m = item.getItemMeta();
            Random r = new Random();
            for (Map.Entry<Enchantment, Integer> entry : enc.entrySet()) {
                if(r.nextInt(10) == 0){
                    item.removeEnchantment(entry.getKey());
                    enc.remove(entry.getKey());
                    item.addUnsafeEnchantment(entry.getKey(), entry.getValue() + 1);
                }
            }
        }



    }

}
