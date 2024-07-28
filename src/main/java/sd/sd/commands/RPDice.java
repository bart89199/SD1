package sd.sd.commands;

import com.google.common.collect.Lists;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import sd.sd.SD;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RPDice extends AbstractCommand {

    public RPDice() {
        super("dice");
    }

    @Override
    public void execute(CommandSender sender, @NotNull Command cmd, String label, String[] args) {

        if (args.length != 2) {
            sender.sendMessage(SD.prefix + " §9Принцип работы РП кубика: §6/" + label + " §7(§6!§7)§7[§6Макс. число§7] §7[§6Удачное число(Число, с которого всё получается)§7] ");
            return;
        }
        int max;
        int win;
        boolean pub = args[0].charAt(0) == '!';
        try {
            if (pub) {
                max = Integer.parseInt(args[0].substring(1));
            } else max = Integer.parseInt(args[0]);
            win = Integer.parseInt(args[1]);
        } catch (Exception e) {
            sender.sendMessage(SD.prefix + " §4Ошибка при обработке");
            return;
        }
        if (max <= 1) {
            sender.sendMessage(SD.prefix + " §4Макс. число должно быть > 1");
            return;
        }
        if (win >= max) {
            sender.sendMessage(SD.prefix + " §4Удачное число должно быть < макс. числа");
            return;
        }
        if (win <= 0) {
            sender.sendMessage(SD.prefix + " §4Удачное число должно быть > 0");
            return;
        }
        int dice = dice(max);
        String result;
        if (dice <= win) {
            result = SD.prefix + " §6" + sender.getName() + " §9кинул кубик на §6" + max + " §9с удачным числом §6" + win + ", §9ему выпало §2" + dice;
        } else {
            result = SD.prefix + " §6" + sender.getName() + " §9кинул кубик на §6" + max + " §9с удачным числом §6" + win + ", §9ему выпало §4" + dice;
        }
        Bukkit.getConsoleSender().sendMessage(result);

        if (sender instanceof Player p) {
            p.sendMessage(result.replace(sender.getName() + " §9кинул", "§9Вы кинули"));
            List<String> playersList = new ArrayList<>(); // Это лист, в котором будут храниться твои игроки.
            Location location = p.getLocation(); // Локация. Сейчас это допустим локация игрока.
            int radius = SD.getInstance().getConfig().getInt("CommandMe.Radius", 50); // Это твой радиус.
            if (pub) {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    String NamePlayer = player.getName();
                    if (!NamePlayer.equalsIgnoreCase(sender.getName())) playersList.add(NamePlayer);
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
            if (playersList.isEmpty()) if (!pub) {
                p.sendMessage(SD.prefix + " " + SD.getMessages().getString("CommandMe.NooneHeard", "§7Вас никто не услышал, используйте §6! §7для глобализации"));
                return;
            }
            for (String pl : playersList) {
                Player player = Bukkit.getPlayer(pl);
                player.sendMessage(result);
            }

        } else {

            for(Player p : Bukkit.getOnlinePlayers()){
                p.sendMessage(result);
            }

        }

    }


    public static boolean dice(int max, int win){
        int result = new Random().nextInt(max)+1;
        return result <= win;
    }

    public static int dice(int max){
        return new Random().nextInt(max)+1;
    }

    @Override
    public List<String> complete(CommandSender sender, String[] args) {
        if(args.length == 1) return Lists.newArrayList("!§7[§6Макс. число§7]", "§7[§6Макс. число§7]");
        if(args.length == 2) return Lists.newArrayList("§7[§6Удачное число§7]");
        return Lists.newArrayList();
    }
}
