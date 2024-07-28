package sd.sd.commands;

import com.google.common.collect.Lists;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import sd.sd.SD;

import java.util.ArrayList;
import java.util.List;

public class MeDo extends AbstractCommand {

    public MeDo() {
        super("me");
    }

    @Override
    public void execute(CommandSender sender, @NotNull Command cmd, String label, String[] args) {
        if(sender instanceof ConsoleCommandSender) {
            StringBuilder a = new StringBuilder();
            for (int i = 0; i < args.length; i++) a.append(args[i]).append(' ');
            String act = a.toString();
            act = act.replace("&", "§");
            for(Player player : Bukkit.getOnlinePlayers()){
                player.sendMessage("§5* §6сервер §5 " + act);
            }
            Bukkit.getConsoleSender().sendMessage("§5* §6сервер §5 " + act);
            return;
        }
        if(sender instanceof Player) {
            Player p = Bukkit.getPlayer(sender.getName());
            if (args.length == 0) {
                sender.sendMessage(SD.prefix + " " + SD.getMessages().getString("CommandMe.Usage", "&9Для использования §5/" + label + " &9пропишете после §6/" + label + " &9действие, которое вы хотите совершить").replace("label", label));
                return;
            }
            StringBuilder a = new StringBuilder();
            for (int i = 0; i < args.length; i++) a.append(args[i]).append(' ');
            String act = a.toString();
            act = act.replace("&", "§");
            List<String> playersList = new ArrayList<>(); // Это лист, в котором будут храниться твои игроки.
            Location location = p.getLocation(); // Локация. Сейчас это допустим локация игрока.
            int radius = SD.getInstance().getConfig().getInt("CommandMe.Radius", 50); // Это твой радиус.


            if (String.valueOf(args[0].charAt(0)).equalsIgnoreCase("!")) {
                act = act.substring(1);
                for (Player player : Bukkit.getOnlinePlayers()) {
                    String NamePlayer = player.getName();
                    if(!NamePlayer.equalsIgnoreCase(sender.getName())) playersList.add(NamePlayer);
                }
            } else {

                for (Entity entity : location.getWorld().getNearbyEntities(location, radius, radius, radius)) { // С помощью цикла мы в определенной локации ищем всех существ на расстоянии 200 блоков.
                    if (entity.getType() == EntityType.PLAYER) {
                        if (!entity.getName().equalsIgnoreCase(p.getName())) {
                            playersList.add(entity.getName());
                        }
                    }
                }
            }
            if(playersList.isEmpty()) if (!String.valueOf(args[0].charAt(0)).equalsIgnoreCase("!")){
                p.sendMessage(SD.prefix + " " + SD.getMessages().getString("CommandMe.NooneHeard", "§7Вас никто не услышал, используйте §6! §7для глобализации"));
                Bukkit.getConsoleSender().sendMessage(SD.getString("CommandMe.Format", ChatColor.LIGHT_PURPLE + "* " + act + ChatColor.LIGHT_PURPLE + " " + sender.getName() + " *").replace("player", sender.getName()).replace("message", act) + ChatColor.GRAY + " Тихо промолвил");
                sender.sendMessage(SD.getString("CommandMe.Format", ChatColor.LIGHT_PURPLE + "* " + act + ChatColor.LIGHT_PURPLE + " " + sender.getName() + " *").replace("player", sender.getName()).replace("message", act));
                return;
            }
            playersList.add(sender.getName());
            for (String pl : playersList) {
                Player player = Bukkit.getPlayer(pl);
                player.sendMessage(SD.getString("CommandMe.Format", ChatColor.LIGHT_PURPLE + "* " + act + ChatColor.LIGHT_PURPLE + " " + sender.getName() + " *").replace("player", sender.getName()).replace("message", act));
            }

                Bukkit.getConsoleSender().sendMessage(SD.getString("CommandMe.Format", ChatColor.LIGHT_PURPLE + "* " + act + ChatColor.LIGHT_PURPLE + " " + sender.getName() + " *").replace("player", sender.getName()).replace("message", act));
        }
    }

    @Override
    public List<String> complete(CommandSender sender, String[] args) {
        if(args.length == 1) return Lists.newArrayList(SD.getString("CommandMe.OnTabComplete", "действие"), "!" + SD.getString("CommandMe.OnTabComplete", "действие"));
        return Lists.newArrayList(SD.getString("CommandMe.OnTabComplete", "действие"));
}
    }
