package sd.sd;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonExtendEvent;

public class PistonListener implements Listener {


    @EventHandler(priority = EventPriority.NORMAL)
    public void onPiston(BlockPistonExtendEvent e){




        int X = e.getDirection().getModX();
        int Y = e.getDirection().getModY();
        int Z = e.getDirection().getModZ();

    }

}