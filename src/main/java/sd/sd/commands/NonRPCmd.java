package sd.sd.commands;

import com.google.common.collect.Lists;
import org.bukkit.Bukkit;
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

public class NonRPCmd extends AbstractCommand {
    public NonRPCmd() {
        super("n");
    }

    @Override
    public void execute(CommandSender sender, @NotNull Command cmd, String label, String[] args) {
        if(sender instanceof ConsoleCommandSender){
            sender.sendMessage(SD.prefix + " §4Для этой команды надо быть игроком");
            return;
        }
        Player p = Bukkit.getPlayer(sender.getName());
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < args.length; i++) a.append(args[i]).append(' ');
        if (a.length() > 0) a.deleteCharAt(a.length() - 1);
        String act = a.toString();
        act = act.replace("&", "§");

        if(String.valueOf(args[0].charAt(0)).equalsIgnoreCase("!")) {
            act = act.substring(1, act.length());
            Bukkit.getConsoleSender().sendMessage(SD.getString("Chat.Global", "§e[§aГлобал§e]") + " §f" + sender.getName() + "§8: §f((" + act + "§f))");
            for(Player pla : Bukkit.getOnlinePlayers()) {
                pla.sendMessage(SD.getString("Chat.Global", "§e[§aГлобал§e]") + " §f" + sender.getName() + "§8: §f((" + act + "§f))");
            }
            return;
        }

        List<String> playersList = new ArrayList<>(); // Это лист, в котором будут храниться твои игроки.
        Location location = p.getLocation(); // Локация. Сейчас это допустим локация игрока.
        int radius = SD.getInstance().getConfig().getInt("NonRPCommand.Radius", 50);; // Это твой радиус.
        for (Entity entity : location.getWorld().getNearbyEntities(location, radius, radius, radius)) { // С помощью цикла мы в определенной локации ищем всех существ на расстоянии 200 блоков.
            if (entity.getType() == EntityType.PLAYER)
                playersList.add(entity.getName()); // Проверяем, что существо является игроком и добавляем его в лист.
        }
        if(playersList.isEmpty()){
            p.sendMessage(SD.prefix + " " + SD.getMessages().getString("NonRPCommand.NooneHeard", "§7Вас никто не услышал, используйте §6! §7для глобализации"));
            Bukkit.getConsoleSender().sendMessage(SD.getString("Chat.Local", "§e[§6Локально§e]") + " §f" + sender.getName() + "§8: §f((" + act + "§f)) §7прошептал");
            sender.sendMessage(SD.getString("Chat.Local", "§e[§6Локально§e]") + " §f" + sender.getName() + "§8: §f((" + act + "§f))");
            return;
        }
        for (String pl : playersList) {
            p = Bukkit.getPlayer(pl);
            p.sendMessage(SD.getString("Chat.Local", "§e[§6Локально§e]") + " §f" + sender.getName() + "§8: §f((" + act + "§f))");
        }
        Bukkit.getConsoleSender().sendMessage(SD.getString("Chat.Local", "§e[§6Локально§e]") + " §f" + sender.getName() + "§8: §f((" + act + "§f))");
    }
    @Override
    public List<String> complete(CommandSender sender, String[] args) {
        if(args.length == 1) return Lists.newArrayList(SD.getString("NonRPCommand.OnTabComplete", "&6Сообщение"), "!" + SD.getString("NonRPCommand.OnTabComplete", "&6Сообщение"));
        return Lists.newArrayList(SD.getString("NonRPCommand.OnTabComplete", "&6Сообщение"));
    }
}
