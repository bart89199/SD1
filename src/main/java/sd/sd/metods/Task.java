package sd.sd.metods;

import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import sd.sd.SD;

public enum Task implements Runnable{

    ChangeProfileStatus(1), Change(2);

    private int ID;
    private Player p;
    private int i;
    private Title title;
    private String target = "SetStatusProfile";

    Task(int ID) {
    this.i= ID;
    }


    public void setPlayer(Player player) {
        this.p = player;
    }

    public void setTitle(Title title){
        this.title = title;
    }

    public void setTarget(String target){
        this.target = target;
    }
/**
    public void setTitle(String MainText){
        this.title = Title.title(Component.text(MainText), this.title.subtitle());
    }

    public void setSubtitle(String subtitle){
        this.title = Title.title(this.title.title(), Component.text(subtitle));
    }
*/
    @Override
    public void run() {
        if(i == 1) {
            this.ID = Bukkit.getScheduler().scheduleSyncRepeatingTask(SD.getInstance(), () -> {
          //      if (Balt.getTags().getConfig().getBoolean(p.getName() + ".SetStatusProfile")) {
                    //       String ta = "§cВведите желаемый статус профиля в чат";
                    //Title t = Title.title(Component.text("§cВведите желаемый статус профиля в чат"), Component.text("§7Открытый, закрытый"));
                    this.p.showTitle(this.title);
//                if (!SD.getTags().getConfig().getBoolean(p.getName() + "." + target)){
//                    p.clearTitle();
//                    Bukkit.getScheduler().cancelTask(ID);
//                }
          //      }
            }, 0, 60);
        }
    }

    public int getID(){
        return this.ID;
    }
}
