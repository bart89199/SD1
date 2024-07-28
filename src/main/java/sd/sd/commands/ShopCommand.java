package sd.sd.commands;

import com.google.common.collect.Lists;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import sd.sd.SD;
import sd.sd.shops.Shop;
import sd.sd.shops.ShopGUI;

import java.util.ArrayList;
import java.util.List;

import static sd.sd.SD.*;

public class ShopCommand extends AbstractCommand {
    //    public String log = "§8[§9§lS§8§lD§8]";



    public ShopCommand() {
        super("shops");
    }
    @Override
    public void execute(CommandSender sender, @NotNull Command cmd, String label, String[] args) {

        if(!SD.isHub){

            sender.sendMessage(SD.prefix + " §4Это не хаб!");
            return;

        }

        if (sender.hasPermission(admin_perm)) {


            if(args.length == 0){

                if(sender instanceof Player p){
                    p.openInventory(new ShopGUI(ShopGUI.ShopGUIFormat.MAIN_MENU, p, null).getInventory());
                }else {
                    sender.sendMessage(SD.prefix + " §4GUI доступно только для игроков");
                }
                return;
            }
            if (args[0].equalsIgnoreCase("создать")) {
                if (args.length == 14) {
                    World w;
                    if (sender instanceof Player p) {
                        w =  p.getWorld();
                    } else
                        w = Bukkit.getWorld("world");

                    try {
                        String name = args[1];
                        int startX = Integer.parseInt(args[2]);
                        int startY = Integer.parseInt(args[3]);
                        int startZ = Integer.parseInt(args[4]);
                        int endX = Integer.parseInt(args[5]);
                        int endY = Integer.parseInt(args[6]);
                        int endZ = Integer.parseInt(args[7]);
                        int putX = Integer.parseInt(args[8]);
                        int putY = Integer.parseInt(args[9]);
                        int putZ = Integer.parseInt(args[10]);
                        int getX = Integer.parseInt(args[11]);
                        int getY = Integer.parseInt(args[12]);
                        int getZ = Integer.parseInt(args[13]);
                        getShops().addShop(name, new Location(w, startX, startY, startZ), new Location(w, endX, endY, endZ), new Location(w, putX, putY, putZ), new Location(w, getX, getY, getZ));
                        SD.shops = SD.getShops().getShops();

                        listOfShops = new ArrayList<>();
                        listOfShops.add(new Shop[7]);

                        int line = 0;
                        int slot = 0;

                        for(Shop shop : shops){

                            if(slot >= 6){

                                slot = 0;
                                listOfShops.add(++line, new Shop[7]);

                            }

                            listOfShops.get(line)[slot++] = shop;

                        }
                        sender.sendMessage(SD.prefix + " §3Магазин " + args[1] + " создан");
                        return;
                    } catch (Exception ex) {

                        sender.sendMessage(SD.prefix + " §4Произошла ошибка");
                        return;
                    }
                } else {

                    sender.sendMessage(SD.prefix + "§3Формат создания магазина: §6/" + label +
                            " создать [имя] [координаты начала]{[x], [y], [z]} [координаты конца]{[x], [y], [z]} [координаты бочки получения]{[x], [y], [z]} [координаты бочки внесения]{[x], [y], [z]}");
                    return;
                }
            }
                if (args[0].equalsIgnoreCase("удалить")) if (args.length == 2) {

                    if (getShops().removeShop(args[1])) {

                        sender.sendMessage(SD.prefix + " §2Магазин §6" + args[1] + " §2успешно удалён");
                        SD.shops = SD.getShops().getShops();

                        listOfShops = new ArrayList<>();
                        listOfShops.add(new Shop[7]);

                        int line = 0;
                        int slot = 0;

                        for(Shop shop : shops){

                            if(slot >= 6){

                                slot = 0;
                                listOfShops.add(++line, new Shop[7]);

                            }

                            listOfShops.get(line)[slot++] = shop;

                        }
                        return;

                    } else {

                        sender.sendMessage(SD.prefix + " §3Магазин §6" + args[1] + " §3не найден");
                        return;

                    }

                } else {

                    sender.sendMessage(SD.prefix + "§3Формат удаления магазина: §6/" + label + " создать [имя магазина]");
                    return;

                }

            sender.sendMessage(SD.prefix + "\u00a74 Команда введена не верно!");

        }
    }

    @Override
    public List<String> complete (CommandSender sender, String[]args){
        if(sender.hasPermission(admin_perm)) {

            if (args.length == 1) return Lists.newArrayList("создать", "удалить");

            if (sender instanceof Player p) {

                if (args[0].equalsIgnoreCase("создать")) {

                    String x = "x";
                    String y = "y";
                    String z = "z";
                    Block b = p.getTargetBlockExact(8);
                    if (b != null) {

                        x = String.valueOf(b.getX());
                        y = String.valueOf(b.getY());
                        z = String.valueOf(b.getZ());

                    }

                    if (args.length == 2) return Lists.newArrayList("имя");
                    if (args.length == 3) return Lists.newArrayList(x);
                    if (args.length == 4) return Lists.newArrayList(y);
                    if (args.length == 5) return Lists.newArrayList(z);
                    if (args.length == 6) return Lists.newArrayList(x);
                    if (args.length == 7) return Lists.newArrayList(y);
                    if (args.length == 8) return Lists.newArrayList(z);
                    if (args.length == 9) return Lists.newArrayList(x);
                    if (args.length == 10) return Lists.newArrayList(y);
                    if (args.length == 11) return Lists.newArrayList(z);
                    if (args.length == 12) return Lists.newArrayList(x);
                    if (args.length == 13) return Lists.newArrayList(y);
                    if (args.length == 14) return Lists.newArrayList(z);
                }
            }else{
                if (args[0].equalsIgnoreCase("создать")) {

                    String x = "x";
                    String y = "y";
                    String z = "z";

                    if (args.length == 2) return Lists.newArrayList("имя");
                    if (args.length == 3) return Lists.newArrayList(x);
                    if (args.length == 4) return Lists.newArrayList(y);
                    if (args.length == 5) return Lists.newArrayList(z);
                    if (args.length == 6) return Lists.newArrayList(x);
                    if (args.length == 7) return Lists.newArrayList(y);
                    if (args.length == 8) return Lists.newArrayList(z);
                    if (args.length == 9) return Lists.newArrayList(x);
                    if (args.length == 10) return Lists.newArrayList(y);
                    if (args.length == 11) return Lists.newArrayList(z);
                    if (args.length == 12) return Lists.newArrayList(x);
                    if (args.length == 13) return Lists.newArrayList(y);
                    if (args.length == 14) return Lists.newArrayList(z);
                }
            }
            if (args[0].equalsIgnoreCase("удалить")) {

                if(SD.shops == null || SD.shops.isEmpty()){

                    if (args.length == 2) return Lists.newArrayList("имя магазина");

                }else {

                    ArrayList<String> shopNames = new ArrayList<>();

                    for(Shop shop : SD.shops){

                        shopNames.add(shop.getName());

                    }

                    if (args.length == 2) return shopNames;

                }


            }
        }
            return Lists.newArrayList();
    }


}