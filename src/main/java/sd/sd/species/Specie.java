package sd.sd.species;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import sd.sd.SD;

import java.util.HashMap;
import java.util.Map;

public abstract class Specie implements Listener {

    public Specie(String playerName){
        SD.playersSpecies.put(playerName, getPlayerSpecie());
        Bukkit.getPluginManager().registerEvents(getPlayerSpecie(), SD.getInstance());
    }

    public Map<String, Object> edited = new HashMap<>();


    public abstract Specie getPlayerSpecie();
}
