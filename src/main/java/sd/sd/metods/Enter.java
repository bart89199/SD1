package sd.sd.metods;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import sd.sd.SD;
import sd.sd.commands.Play;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public abstract class Enter implements Listener, InventoryHolder {

    Player p;
    Title title;
    Long time;
    int endTime;
    Inventory inv;
    boolean run;
    String data;
    protected String prefix;

    public boolean isRun() {
        return run;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }

    Map<Play, Integer> count = new HashMap<>();

    public Player getP() {
        return p;
    }

    public void setP(Player p) {
        this.p = p;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void enter(Player p, Title title, int duration, Inventory inv, String data, String prefix) {
        this.p = p;
        this.title = title;
        this.endTime = duration;
        this.inv = inv;
        this.data = data;
        this.prefix = prefix;
    }

    public Enter(){

    }


    @EventHandler(priority = EventPriority.HIGHEST)
    public void onChat(AsyncChatEvent e){
        if(run)
            if(e.getPlayer().getName().equals(p.getName()))
                if(time + endTime * 1000L >= System.currentTimeMillis()){

                    e.setCancelled(true);
                    String message = ((TextComponent)e.originalMessage()).content();
                    if(onEnter(message, data)) stop();


                }
    }

    public void run() {
        time = System.currentTimeMillis();
        SD.enterToChatMap.add(this);
        run = true;
        p.showTitle(Title.title(title.title(), title.subtitle(), Title.Times.times(Duration.ZERO, Duration.ofSeconds(endTime), Duration.ZERO)));
//        idTask = Bukkit.getScheduler().scheduleSyncRepeatingTask(SD.getInstance(), () -> {
//            try {
////                p.sendMessage("3");
////                if(time + endTime < System.currentTimeMillis()) {
////                    p.sendMessage("4");
////                    SD.enterToChatMap.remove(this);
////                    Bukkit.getScheduler().cancelTask(idTask);
////                    run = false;
////                    return;
////                }
//                p.showTitle(Title.title(Component.text(title), Component.text(subtitle), Title.Times.times(Duration.ZERO, Duration.ofSeconds(endTime), Duration.ZERO)));
//            }catch (Exception e){
//                SD.enterToChatMap.remove(this);
//                Bukkit.getScheduler().cancelTask(idTask);
//                run = false;
//            }
//        }, 0, 20 * 10);

        Bukkit.getScheduler().scheduleSyncDelayedTask(SD.getInstance(), this::stop, endTime * 20L);


        }

    public void stop(){
        SD.enterToChatMap.remove(this);
        run = false;
        p.clearTitle();
    }


    public abstract boolean onEnter(String enterString, String data);


}
