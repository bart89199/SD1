package sd.sd.species.playerSpecies;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import sd.sd.SD;
import sd.sd.species.Specie;

public class CryfixElectro extends Specie implements Listener {

    public CryfixElectro(String playerName){
        super(playerName);
        edited.put("noWaterDamage", true);

        edited.put("noEffect", PotionEffectType.FIRE_RESISTANCE);
    }


    @Override
    public Specie getPlayerSpecie() {
        return this;
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (SD.isHub) return;

        if (e.getEntity() instanceof Player p) {

            if(SD.playersSpecies.get(p.getName()).equals(this)){
                if(e.getCause().equals(EntityDamageEvent.DamageCause.LAVA)){
                    if(!p.hasPotionEffect(PotionEffectType.HARM)) p.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 1 * 20, 0));
                }
            }

        }

    }
}
