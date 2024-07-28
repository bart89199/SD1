package sd.sd.commands;

import com.google.common.collect.Lists;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import sd.sd.SD;
import sd.sd.profiles.Profils;
import sd.sd.profiles.Settings;
import sd.sd.profiles.TypeProfile;

import java.util.ArrayList;
import java.util.List;

public class profil extends AbstractCommand {


    public profil() {
        super("профиль");
    }


    @Override
    public void execute(CommandSender sender, @NotNull Command cmd, String label, String[] args) {
        if(sender instanceof ConsoleCommandSender){
            if (args[1].equalsIgnoreCase("изменить")) {
                if (args.length == 2) {
                    sender.sendMessage(SD.prefix + " §6Для изменения профиля воспользуйтесь командой: §5/профиль <ник> изменить Р.Имя: Ник: Дс.Имя: Лет: Цели: О: Лор:");
                    return;
                }
                if (args.length > 2) {
                    StringBuilder z = new StringBuilder();
                    for (int i = 2; i < args.length; i++) z.append(args[i]).append(' ');
                    if (z.length() > 1) z.deleteCharAt(z.length() - 1);
                    String f = z.toString();

                    if (f.contains("Р.Имя:") || f.contains("Лор:") || f.contains("Ник:") || f.contains("Дс.Имя:") || f.contains("Лет:") || f.contains("Цели:") || f.contains("О:") || f.contains("Статус:")) {
                        List<Integer> zg = new ArrayList<>();
                        List<Integer> zg1 = new ArrayList<>();

                        int q = 0;
                        int[] rn = new int[2];
                        int[] nick = new int[2];
                        int[] ds_nick = new int[2];
                        int[] age = new int[2];
                        int[] cels = new int[2];
                        int[] about = new int[2];
                        int[] lore = new int[2];
                        int[] Status = new int[2];

                        if (f.contains("Р.Имя:")) {
                            q++;
                            rn[1] = (f.indexOf("Р.Имя:") + 7);
                            rn[0] = (f.indexOf("Р.Имя:"));
                            zg1.add(rn[0]);
                            zg.add(rn[1]);
                        }
                        if (f.contains("Лор:")) {
                            q++;
                            lore[1] = (f.indexOf("Лор:") + 5);
                            lore[0] = (f.indexOf("Лор:"));
                            zg1.add(lore[0]);
                            zg.add(lore[1]);
                        }
                        if (f.contains("Ник:")) {
                            q++;
                            nick[1] = (f.indexOf("Ник:") + 5);
                            nick[0] = (f.indexOf("Ник:"));
                            zg.add(nick[1]);
                            zg1.add(nick[0]);
                        }
                        if (f.contains("Дс.Имя:")) {
                            q++;
                            ds_nick[1] = (f.indexOf("Дс.Имя:") + 8);
                            ds_nick[0] = (f.indexOf("Дс.Имя:"));
                            zg.add(ds_nick[1]);
                            zg1.add(ds_nick[0]);
                        }
                        if (f.contains("Лет:")) {
                            q++;
                            age[1] = (f.indexOf("Лет:") + 5);
                            age[0] = (f.indexOf("Лет:"));
                            zg.add(age[1]);
                            zg1.add(age[0]);
                        }
                        if (f.contains("Цели:")) {
                            q++;
                            cels[1] = (f.indexOf("Цели:") + 6);
                            cels[0] = (f.indexOf("Цели:"));
                            zg.add(cels[1]);
                            zg1.add(cels[0]);
                        }
                        if (f.contains("О:")) {
                            q++;
                            about[1] = (f.indexOf("О:") + 3);
                            about[0] = (f.indexOf("О:"));
                            zg1.add(about[0]);
                            zg.add(about[1]);
                        }
                        if (f.contains("Статус:")) {
                            q++;
                            Status[1] = (f.indexOf("Статус:") + 8);
                            Status[0] = (f.indexOf("Статус:"));
                            zg1.add(Status[0]);
                            zg.add(Status[1]);
                        }

                        int[] Min = new int[q];
                        Integer[] a = new Integer[q];
                        int Cou = 0;
                        int[] Min1 = new int[q];

                        zg1.add(f.length());

                        String[] strings = new String[q];

                        String[] res = new String[q];

                        int aq1 = 1000;
                        for (int in : zg1) {
                            aq1 = Math.min(aq1, in);
                        }
                        zg1.remove(Integer.valueOf(aq1));
                        int aq;
                        for (int i = 1; i < q + 1; i++) {
                            aq = 1000;
                            for (int in : zg) {
                                aq = Math.min(aq, in);
                            }

                            if (aq == rn[1]) {
                                strings[Cou] = ".RealName";
                            }
                            if (aq == nick[1]) {
                                strings[Cou] = ".Nick";
                            }
                            if (aq == ds_nick[1]) {
                                strings[Cou] = ".DiscordName";
                            }
                            if (aq == age[1]) {
                                strings[Cou] = ".Age";
                            }
                            if (aq == cels[1]) {
                                strings[Cou] = ".PlayerCels";
                            }
                            if (aq == about[1]) {
                                strings[Cou] = ".About";
                            }
                            if (aq == lore[1]) {
                                strings[Cou] = ".LorePlayer";
                            }
                            if (aq == Status[1]) {
                                strings[Cou] = ".Status";
                            }
                            Min[Cou] = aq;
                            a[Cou] = aq;
                            zg.remove(a[Cou]);
                            aq = 1000;
                            for (int in : zg1) {
                                aq = Math.min(aq, in);
                            }
                            Min1[Cou] = aq;
                            a[Cou] = aq;
                            zg1.remove(a[Cou]);
                            res[Cou] = f.substring(Min[Cou] - 1, Min1[Cou]);
                            res[Cou] = res[Cou].replace("&", "§");
                            Cou++;
                        }

                        Cou = 0;

                        for (String r : strings) {
                            SD.getProfils().getConfig().set(args[0] + r, res[Cou]);
                            SD.getProfils().save();
                            Cou++;
                        }
                        String player = args[0];
                        return;
                    }
                }
                sender.sendMessage(SD.prefix + " §4Ошибка!");
                sender.sendMessage(SD.prefix + " §6Для изменения профиля воспользуйтесь командой: §5профиль <ник> изменить Р.Имя: Ник: Дс.Имя: Лет: Цели: О: Лор:");
                return;
            }
        }

        if (sender instanceof Player){
            Player p = Bukkit.getPlayer(sender.getName());

        if (sender.hasPermission("balt.reg")) {
            if ((!(args.length == 0) && !sender.hasPermission("balt.admin"))) {
                if (args[0].equalsIgnoreCase("создать")) {
                    if (SD.getProfils().getConfig().getString(sender.getName() + ".RealName") == null) {
                        if (args.length > 4) {
                            StringBuilder z = new StringBuilder();
                            for (int i = 1; i < args.length; i++) z.append(args[i]).append(' ');
                            if (z.length() > 1) z.deleteCharAt(z.length() - 1);
                            String f = z.toString();


                            if (f.contains("Р.Имя:") && f.contains("Ник:") && f.contains("Дс.Имя:") && f.contains("Лет:") && f.contains("Цели:") && f.contains("О:")) {
                                List<Integer> zg = new ArrayList<>();
                                List<Integer> zg1 = new ArrayList<>();

                                int q = 0;
                                int[] rn = new int[2];
                                int[] nick = new int[2];
                                int[] ds_nick = new int[2];
                                int[] age = new int[2];
                                int[] cels = new int[2];
                                int[] about = new int[2];

                                if (f.contains("Р.Имя:")) {
                                    q++;
                                    rn[1] = (f.indexOf("Р.Имя:") + 7);
                                    rn[0] = (f.indexOf("Р.Имя:"));
                                    zg1.add(rn[0]);
                                    zg.add(rn[1]);
                                }
                                if (f.contains("Ник:")) {
                                    q++;
                                    nick[1] = (f.indexOf("Ник:") + 5);
                                    nick[0] = (f.indexOf("Ник:"));
                                    zg.add(nick[1]);
                                    zg1.add(nick[0]);
                                }
                                if (f.contains("Дс.Имя:")) {
                                    q++;
                                    ds_nick[1] = (f.indexOf("Дс.Имя:") + 8);
                                    ds_nick[0] = (f.indexOf("Дс.Имя:"));
                                    zg.add(ds_nick[1]);
                                    zg1.add(ds_nick[0]);
                                }
                                if (f.contains("Лет:")) {
                                    q++;
                                    age[1] = (f.indexOf("Лет:") + 5);
                                    age[0] = (f.indexOf("Лет:"));
                                    zg.add(age[1]);
                                    zg1.add(age[0]);
                                }
                                if (f.contains("Цели:")) {
                                    q++;
                                    cels[1] = (f.indexOf("Цели:") + 6);
                                    cels[0] = (f.indexOf("Цели:"));
                                    zg.add(cels[1]);
                                    zg1.add(cels[0]);
                                }
                                if (f.contains("О:")) {
                                    q++;
                                    about[1] = (f.indexOf("О:") + 3);
                                    about[0] = (f.indexOf("О:"));
                                    zg1.add(about[0]);
                                    zg.add(about[1]);
                                }

                                int[] Min = new int[q];
                                Integer[] a = new Integer[q];
                                int Cou = 0;
                                int[] Min1 = new int[q];

                                zg1.add(f.length());

                                String[] strings = new String[q];

                                String[] res = new String[q];

                                int aq1 = 1000;
                                for (int in : zg1) {
                                    aq1 = Math.min(aq1, in);
                                }
                                zg1.remove(Integer.valueOf(aq1));
                                int aq;
                                for (int i = 1; i < q + 1; i++) {
                                    aq = 1000;
                                    for (int in : zg) {
                                        aq = Math.min(aq, in);
                                    }

                                    if (aq == rn[1]) {
                                        strings[Cou] = ".RealName";
                                    }
                                    if (aq == nick[1]) {
                                        strings[Cou] = ".Nick";
                                    }
                                    if (aq == ds_nick[1]) {
                                        strings[Cou] = ".DiscordName";
                                    }
                                    if (aq == age[1]) {
                                        strings[Cou] = ".Age";
                                    }
                                    if (aq == cels[1]) {
                                        strings[Cou] = ".PlayerCels";
                                    }
                                    if (aq == about[1]) {
                                        strings[Cou] = ".About";
                                    }
                                    Min[Cou] = aq;
                                    a[Cou] = aq;
                                    zg.remove(a[Cou]);
                                    aq = 1000;
                                    for (int in : zg1) {
                                        aq = Math.min(aq, in);
                                    }
                                    Min1[Cou] = aq;
                                    a[Cou] = aq;
                                    zg1.remove(a[Cou]);
                                    res[Cou] = f.substring(Min[Cou] - 1, Min1[Cou]);
                                    res[Cou] = res[Cou].replace("&", "§");
                                    Cou++;
                                }

                                Cou = 0;

                                for (String r : strings) {
                                    SD.getProfils().getConfig().set(sender.getName() + r, res[Cou]);
                                    Cou++;
                                    SD.getProfils().save();
                                }
                                Profils profile = new Profils(sender.getName(), TypeProfile.My, Material.GRAY_STAINED_GLASS_PANE);
                                p.openInventory(profile.getInventory());
                                return;
                            }
                        }
                        sender.sendMessage(SD.prefix + " §4Ошибка!");
                        sender.sendMessage(SD.prefix + " §6Для создания профиля воспользуйтесь командой: §5/профиль создать Р.Имя: Ник: Дс.Имя: Лет: Цели: О:");
                        return;
                    } else {
                        sender.sendMessage(SD.prefix + " §6Ваш профиль уже создан, если вы хотите изменить профиль, то воспользуйтесь командой: §5/профиль изменить");
                        return;
                    }
                }
            }
            if (!sender.hasPermission("balt.admin") && SD.getProfils().getConfig().getString(sender.getName() + ".RealName") == null) {
                sender.sendMessage(SD.prefix + " §6Для начала создайте профиль командой §5/профиль создать Р.Имя: Ник: Дс.Имя: Лет: Цели: О:");
                return;
            }
            if (args.length == 0) {
                Profils profile = new Profils(p.getName(), TypeProfile.My, Material.GRAY_STAINED_GLASS_PANE);
                p.openInventory(profile.getInventory());
                return;
            }
            if (args[0].equalsIgnoreCase("настройки")) {
                Settings settings = new Settings(p, Material.GRAY_STAINED_GLASS_PANE);
                p.openInventory(settings.getInventory());
                return;
            }
            if (args[0].equalsIgnoreCase("изменить")) {
                if (SD.getProfils().getConfig().getString(sender.getName() + ".RealName") == null) {
                    sender.sendMessage(SD.prefix + " §4Для начала создай профиль командой §5§l/профиль создать");
                    return;
                }
                if (args.length == 1) {
                    sender.sendMessage(SD.prefix + " §6Для изменения профиля воспользуйтесь командой: §5/профиль изменить Р.Имя: Ник: Дс.Имя: Лет: Цели: О:");
                    return;

                }
                if (args.length > 1) {
                    StringBuilder z = new StringBuilder();
                    for (int i = 1; i < args.length; i++) z.append(args[i]).append(' ');
                    if (z.length() > 1) z.deleteCharAt(z.length() - 1);
                    String f = z.toString();


                    if (f.contains("Р.Имя:") || f.contains("Ник:") || f.contains("Дс.Имя:") || f.contains("Лет:") || f.contains("Цели:") || f.contains("О:")) {
                        List<Integer> zg = new ArrayList<>();
                        List<Integer> zg1 = new ArrayList<>();

                        int q = 0;
                        int[] rn = new int[2];
                        int[] nick = new int[2];
                        int[] ds_nick = new int[2];
                        int[] age = new int[2];
                        int[] cels = new int[2];
                        int[] about = new int[2];

                        if (f.contains("Р.Имя:")) {
                            q++;
                            rn[1] = (f.indexOf("Р.Имя:") + 7);
                            rn[0] = (f.indexOf("Р.Имя:"));
                            zg1.add(rn[0]);
                            zg.add(rn[1]);
                        }
                        if (f.contains("Ник:")) {
                            q++;
                            nick[1] = (f.indexOf("Ник:") + 5);
                            nick[0] = (f.indexOf("Ник:"));
                            zg.add(nick[1]);
                            zg1.add(nick[0]);
                        }
                        if (f.contains("Дс.Имя:")) {
                            q++;
                            ds_nick[1] = (f.indexOf("Дс.Имя:") + 8);
                            ds_nick[0] = (f.indexOf("Дс.Имя:"));
                            zg.add(ds_nick[1]);
                            zg1.add(ds_nick[0]);
                        }
                        if (f.contains("Лет:")) {
                            q++;
                            age[1] = (f.indexOf("Лет:") + 5);
                            age[0] = (f.indexOf("Лет:"));
                            zg.add(age[1]);
                            zg1.add(age[0]);
                        }
                        if (f.contains("Цели:")) {
                            q++;
                            cels[1] = (f.indexOf("Цели:") + 6);
                            cels[0] = (f.indexOf("Цели:"));
                            zg.add(cels[1]);
                            zg1.add(cels[0]);
                        }
                        if (f.contains("О:")) {
                            q++;
                            about[1] = (f.indexOf("О:") + 3);
                            about[0] = (f.indexOf("О:"));
                            zg1.add(about[0]);
                            zg.add(about[1]);
                        }

                        int[] Min = new int[q];
                        Integer[] a = new Integer[q];
                        int Cou = 0;
                        int[] Min1 = new int[q];

                        zg1.add(f.length());

                        String[] strings = new String[q];

                        String[] res = new String[q];

                        int aq1 = 1000;
                        for (int in : zg1) {
                            aq1 = Math.min(aq1, in);
                        }
                        zg1.remove(Integer.valueOf(aq1));
                        int aq;
                        for (int i = 1; i < q + 1; i++) {
                            aq = 1000;
                            for (int in : zg) {
                                aq = Math.min(aq, in);
                            }

                            if (aq == rn[1]) {
                                strings[Cou] = ".RealName";
                            }
                            if (aq == nick[1]) {
                                strings[Cou] = ".Nick";
                            }
                            if (aq == ds_nick[1]) {
                                strings[Cou] = ".DiscordName";
                            }
                            if (aq == age[1]) {
                                strings[Cou] = ".Age";
                            }
                            if (aq == cels[1]) {
                                strings[Cou] = ".PlayerCels";
                            }
                            if (aq == about[1]) {
                                strings[Cou] = ".About";
                            }
                            Min[Cou] = aq;
                            a[Cou] = aq;
                            zg.remove(a[Cou]);
                            aq = 1000;
                            for (int in : zg1) {
                                aq = Math.min(aq, in);
                            }
                            Min1[Cou] = aq;
                            a[Cou] = aq;
                            zg1.remove(a[Cou]);
                            res[Cou] = f.substring(Min[Cou] - 1, Min1[Cou]);
                            res[Cou] = res[Cou].replace("&", "§");
                            Cou++;
                        }

                        Cou = 0;

                        for (String r : strings) {
                            SD.getProfils().getConfig().set(sender.getName() + r, res[Cou]);
                            SD.getProfils().save();
                            Cou++;
                        }
                        Profils profile = new Profils(p.getName(), TypeProfile.My, Material.GRAY_STAINED_GLASS_PANE);
                        p.openInventory(profile.getInventory());
                        return;
                    }
                }
                sender.sendMessage(SD.prefix + " §4Ошибка!");
                sender.sendMessage(SD.prefix + " §6Для изменения профиля воспользуйтесь командой: §5/профиль изменить Р.Имя: Ник: Дс.Имя: Лет: Цели: О:");
                return;
            }
            if (args.length == 1 && !sender.hasPermission("balt.admin")) {
                String player = args[0];
                if (SD.getProfils().getConfig().getString(player + ".RealName") == null) {
                    sender.sendMessage(SD.prefix + " §4Указанный игрок не зарегистрирован!");
                    return;
                } else {
                    boolean online = false;
                    for (Player pl : Bukkit.getOnlinePlayers()) {
                        if (pl.getName().equalsIgnoreCase(player)) online = true;
                    }
                    if (!online) {
                        sender.sendMessage(SD.prefix + " §4Когда игрок не онлайн его профиль просматривать нельзя!");
                        return;
                    }
//                    if (Balt.getProfils().getConfig().getString(player + ".ProfilStatus", "close").equalsIgnoreCase("open")) {
//
//                        Profils profile = new Profils(player, TypeProfile.Players, Material.GRAY_STAINED_GLASS_PANE);
//                        p.openInventory(profile.getInventory());
//                        return;
//                    } else {
//                        sender.sendMessage(Balt.sd + " §4Профиль игрока закрыт");
//                    }
                    Profils profile = new Profils(player, TypeProfile.Players, Material.GRAY_STAINED_GLASS_PANE);
                    p.openInventory(profile.getInventory());
                }
            }
//            if (args[0].equalsIgnoreCase("статус")) {
//                if (args.length == 1) {
//                    String st = Balt.getProfils().getConfig().getString(sender.getName() + ".ProfilStatus", "close").replace("close", "§4закрыт").replace("open", "§2открыт").replace("OnRequest", "§6по запросу");
//                    sender.sendMessage(Balt.sd + " §6Ваш профиль " + st + ". §6Для изменения статуса воспользуйтесь командой §5/профиль статус изменить");
//                    return;
//                }
//                if (args[1].equalsIgnoreCase("изменить") || args[1].equalsIgnoreCase("установить")) {
//                    if (args[2].equalsIgnoreCase("открыть") || args[2].equalsIgnoreCase("открыт") || args[2].equalsIgnoreCase("открытый")) {
//                        Balt.getProfils().getConfig().set(sender.getName() + ".ProfilStatus", "open");
//                        Balt.getProfils().save();
//                        String st = Balt.getProfils().getConfig().getString(sender.getName() + ".ProfilStatus", "close").replace("close", "§4закрыт").replace("open", "§2открыт").replace("OnRequest", "§6по запросу");
//                        sender.sendMessage(Balt.sd + " §6Ваш профиль " + st);
//                        return;
//                    }
//                    if (args[2].equalsIgnoreCase("закрыть") || args[2].equalsIgnoreCase("закрыт") || args[2].equalsIgnoreCase("закрытый")) {
//                        String st = Balt.getProfils().getConfig().getString(sender.getName() + ".ProfilStatus", "close").replace("close", "§4закрыт").replace("open", "§2открыт").replace("OnRequest", "§6по запросу");
//                        sender.sendMessage(Balt.sd + " §6Ваш профиль " + st);
//                        return;
//                    }
//                    /**   if (args[2].equalsIgnoreCase("по") && args[3].equalsIgnoreCase("запросу")) {
//                     Balt.getProfils().getConfig().set(sender.getName() + ".ProfilStatus", "OnRequest");
//                     Balt.getProfils().save();
//                     String st = Balt.getProfils().getConfig().getString(sender.getName() + ".ProfilStatus", "close").replace("close", "§4закрыт").replace("open", "§2открыт").replace("OnRequest", "§6по запросу ");
//                     sender.sendMessage(Balt.sd + " §6Ваш профиль " + st + ". §6Теперь когда игрок захочет посмотреть ваш профиль, вам придёт запрос");
//                     return;
//                     }*/
//                    sender.sendMessage(" §4Ошибка! §6Возможные статусы профиля: §5открыт, закрыт");
////                    sender.sendMessage(" §4Ошибка! §6Возможные статусы профиля: §5открыт, закрыт, по запросу");
//                }
//            }
            if (sender.hasPermission("balt.admin") || sender.hasPermission("balt.glava")) {

                if (args.length == 1 && sender.hasPermission("balt.admin*")) {
                    String player = args[0];
                    if (SD.getProfils().getConfig().getString(player + ".RealName") == null) {
                        sender.sendMessage(SD.prefix + " §4Указанный игрок не зарегистрирован!");
                        return;
                    } else {
                        Profils profil = new Profils(player, TypeProfile.Players, Material.GRAY_STAINED_GLASS_PANE);
                        p.openInventory(profil.getInventory());
                        return;

                    }
                }

                if (args[1].equalsIgnoreCase("изменить")) {
                    if (args.length == 2) {
                        sender.sendMessage(SD.prefix + " §6Для изменения профиля воспользуйтесь командой: §5/профиль <ник> изменить Р.Имя: Ник: Дс.Имя: Лет: Цели: О: Лор:");
                        return;
                    }
                    if (args.length > 2) {
                        StringBuilder z = new StringBuilder();
                        for (int i = 2; i < args.length; i++) z.append(args[i]).append(' ');
                        if (z.length() > 1) z.deleteCharAt(z.length() - 1);
                        String f = z.toString();

                        if (f.contains("Р.Имя:") || f.contains("Лор:") || f.contains("Ник:") || f.contains("Дс.Имя:") || f.contains("Лет:") || f.contains("Цели:") || f.contains("О:") || f.contains("Статус:")) {
                            List<Integer> zg = new ArrayList<>();
                            List<Integer> zg1 = new ArrayList<>();

                            int q = 0;
                            int[] rn = new int[2];
                            int[] nick = new int[2];
                            int[] ds_nick = new int[2];
                            int[] age = new int[2];
                            int[] cels = new int[2];
                            int[] about = new int[2];
                            int[] lore = new int[2];
                            int[] Status = new int[2];

                            if (f.contains("Р.Имя:")) {
                                q++;
                                rn[1] = (f.indexOf("Р.Имя:") + 7);
                                rn[0] = (f.indexOf("Р.Имя:"));
                                zg1.add(rn[0]);
                                zg.add(rn[1]);
                            }
                            if (f.contains("Лор:")) {
                                q++;
                                lore[1] = (f.indexOf("Лор:") + 5);
                                lore[0] = (f.indexOf("Лор:"));
                                zg1.add(lore[0]);
                                zg.add(lore[1]);
                            }
                            if (f.contains("Ник:")) {
                                q++;
                                nick[1] = (f.indexOf("Ник:") + 5);
                                nick[0] = (f.indexOf("Ник:"));
                                zg.add(nick[1]);
                                zg1.add(nick[0]);
                            }
                            if (f.contains("Дс.Имя:")) {
                                q++;
                                ds_nick[1] = (f.indexOf("Дс.Имя:") + 8);
                                ds_nick[0] = (f.indexOf("Дс.Имя:"));
                                zg.add(ds_nick[1]);
                                zg1.add(ds_nick[0]);
                            }
                            if (f.contains("Лет:")) {
                                q++;
                                age[1] = (f.indexOf("Лет:") + 5);
                                age[0] = (f.indexOf("Лет:"));
                                zg.add(age[1]);
                                zg1.add(age[0]);
                            }
                            if (f.contains("Цели:")) {
                                q++;
                                cels[1] = (f.indexOf("Цели:") + 6);
                                cels[0] = (f.indexOf("Цели:"));
                                zg.add(cels[1]);
                                zg1.add(cels[0]);
                            }
                            if (f.contains("О:")) {
                                q++;
                                about[1] = (f.indexOf("О:") + 3);
                                about[0] = (f.indexOf("О:"));
                                zg1.add(about[0]);
                                zg.add(about[1]);
                            }
                            if (f.contains("Статус:")) {
                                q++;
                                Status[1] = (f.indexOf("Статус:") + 8);
                                Status[0] = (f.indexOf("Статус:"));
                                zg1.add(Status[0]);
                                zg.add(Status[1]);
                            }

                            int[] Min = new int[q];
                            Integer[] a = new Integer[q];
                            int Cou = 0;
                            int[] Min1 = new int[q];

                            zg1.add(f.length());

                            String[] strings = new String[q];

                            String[] res = new String[q];

                            int aq1 = 1000;
                            for (int in : zg1) {
                                aq1 = Math.min(aq1, in);
                            }
                            zg1.remove(Integer.valueOf(aq1));
                            int aq;
                            for (int i = 1; i < q + 1; i++) {
                                aq = 1000;
                                for (int in : zg) {
                                    aq = Math.min(aq, in);
                                }

                                if (aq == rn[1]) {
                                    strings[Cou] = ".RealName";
                                }
                                if (aq == nick[1]) {
                                    strings[Cou] = ".Nick";
                                }
                                if (aq == ds_nick[1]) {
                                    strings[Cou] = ".DiscordName";
                                }
                                if (aq == age[1]) {
                                    strings[Cou] = ".Age";
                                }
                                if (aq == cels[1]) {
                                    strings[Cou] = ".PlayerCels";
                                }
                                if (aq == about[1]) {
                                    strings[Cou] = ".About";
                                }
                                if (aq == lore[1]) {
                                    strings[Cou] = ".LorePlayer";
                                }
                                if (aq == Status[1]) {
                                    strings[Cou] = ".Status";
                                }
                                Min[Cou] = aq;
                                a[Cou] = aq;
                                zg.remove(a[Cou]);
                                aq = 1000;
                                for (int in : zg1) {
                                    aq = Math.min(aq, in);
                                }
                                Min1[Cou] = aq;
                                a[Cou] = aq;
                                zg1.remove(a[Cou]);
                                res[Cou] = f.substring(Min[Cou] - 1, Min1[Cou]);
                                res[Cou] = res[Cou].replace("&", "§");
                                Cou++;
                            }

                            Cou = 0;

                            for (String r : strings) {
                                SD.getProfils().getConfig().set(args[0] + r, res[Cou]);
                                SD.getProfils().save();
                                Cou++;
                            }
                            String player = args[0];
                            Profils profile = new Profils(player, TypeProfile.Players, Material.GRAY_STAINED_GLASS_PANE);
                            p.openInventory(profile.getInventory());
                            return;
                        }
                    }
                    sender.sendMessage(SD.prefix + " §4Ошибка!");
                    sender.sendMessage(SD.prefix + " §6Для изменения профиля воспользуйтесь командой: §5/профиль <ник> изменить Р.Имя: Ник: Дс.Имя: Лет: Цели: О: Лор:");
                    return;
                }


                if (args[0].equalsIgnoreCase("добавить") || args[0].equalsIgnoreCase("создать")) {
                    if (args.length == 1) {
                        sender.sendMessage(SD.prefix + " §6Для добавления профиля воспользуйтесь командой: §5/профиль добавить <Ник> Р.Имя: Дс.Имя: Лет: Цели: О: Лор:");
                        return;

                    }
                    StringBuilder z = new StringBuilder();
                    for (int i = 2; i < args.length; i++) z.append(args[i]).append(' ');
                    if (z.length() > 2) z.deleteCharAt(z.length() - 1);
                    String f = z.toString();

                    if (f.contains("Р.Имя:") && f.contains("Ник:") && f.contains("Дс.Имя:") && f.contains("Лет:") && f.contains("От.Игрок:") && f.contains("Цели:") && f.contains("О:")) {
                        int q = 9;
                        int[] Min = new int[q];
                        Integer[] a = new Integer[q];
                        int Cou = 0;
                        int[] Min1 = new int[q];


                        int[] rn = new int[2];
                        rn[1] = (f.indexOf("Р.Имя:") + 7);
                        rn[0] = (f.indexOf("Р.Имя:"));
                        int[] ds_nick = new int[2];
                        ds_nick[1] = (f.indexOf("Дс.Имя:") + 8);
                        ds_nick[0] = (f.indexOf("Дс.Имя:"));
                        int[] age = new int[2];
                        age[1] = (f.indexOf("Лет:") + 5);
                        age[0] = (f.indexOf("Лет:"));
                        int[] from = new int[2];
                        from[1] = (f.indexOf("От.Игрок:") + 10);
                        from[0] = (f.indexOf("От.Игрок:"));
                        int[] cels = new int[2];
                        cels[1] = (f.indexOf("Цели:") + 6);
                        cels[0] = (f.indexOf("Цели:"));
                        int[] about = new int[2];
                        about[1] = (f.indexOf("О:") + 3);
                        about[0] = (f.indexOf("О:"));
                        int[] lore = new int[2];
                        lore[1] = (f.indexOf("Лор:") + 5);
                        lore[0] = (f.indexOf("Лор:"));

                        List<Integer> zg = new ArrayList<>();
                        zg.add(rn[1]);
                        zg.add(ds_nick[1]);
                        zg.add(age[1]);
                        zg.add(from[1]);
                        zg.add(cels[1]);
                        zg.add(about[1]);
                        zg.add(lore[1]);

                        List<Integer> zg1 = new ArrayList<>();
                        zg1.add(rn[1]);
                        zg1.add(ds_nick[0]);
                        zg1.add(age[0]);
                        zg1.add(from[0]);
                        zg1.add(cels[0]);
                        zg1.add(about[0]);
                        zg1.add(lore[0]);
                        zg1.add(f.length());

                        String[] strings = new String[q];

                        String[] res = new String[q];


                        int aq1 = 1000;
                        for (int in : zg1) {
                            aq1 = Math.min(aq1, in);
                        }
                        zg1.remove(Integer.valueOf(aq1));

                        for (int aq : Min) {
                            aq = 1000;
                            for (int in : zg) {
                                aq = Math.min(aq, in);
                            }
                            if (aq == rn[1]) strings[Cou] = ".RealName";
                            if (aq == ds_nick[1]) strings[Cou] = ".DiscordName";
                            if (aq == age[1]) strings[Cou] = ".Age";
                            if (aq == from[1]) strings[Cou] = ".when_from";
                            if (aq == cels[1]) strings[Cou] = ".PlayerCels";
                            if (aq == about[1]) strings[Cou] = ".About";
                            if (aq == lore[1]) strings[Cou] = ".LorePlayer";
                            int q1 = aq;
                            Min[Cou] = aq;
                            a[Cou] = aq;
                            zg.remove(a[Cou]);
                            aq = 1000;
                            for (int in : zg1) {
                                aq = Math.min(aq, in);
                            }
                            Min1[Cou] = aq;
                            a[Cou] = aq;
                            zg1.remove(a[Cou]);
                            res[Cou] = f.substring(Min[Cou] - 1, Min1[Cou]);
                            Cou = Cou + 1;
                        }


                        Cou = 0;

                        for (String r : strings) {
                            SD.getProfils().getConfig().set(args[1] + r, res[Cou]);
                            SD.getProfils().save();
                            Cou++;
                        }
                        SD.getProfils().save();

                        List<String> myList = SD.getProfils().getConfig().getStringList("players");
                        myList.add(args[2]);
                        SD.getProfils().getConfig().set("players", myList);
                        SD.getProfils().save();
                        String player = args[1];
                        Profils profile = new Profils(player, TypeProfile.Players, Material.GRAY_STAINED_GLASS_PANE);
                        p.openInventory(profile.getInventory());
                        return;
                    }

                    sender.sendMessage(SD.prefix + " §4Ошибка!");
                    sender.sendMessage(SD.prefix + " §6Для добавления профиля воспользуйтесь командой: §5/профиль добавить <ник> Р.Имя: Дс.Имя: Лет: Цели: О: Лор:");
                    return;
                }
            }
        }
    }
    }



    @Override
    public List<String> complete(CommandSender sender, String[] args) {
        List<String> players = new ArrayList<>();
        for (Player player : Bukkit.getOnlinePlayers()){
            if(player.hasPermission("balt.reg")){
                players.add(player.getName());
            }
        }
        List<String> h = new ArrayList<>(players);
        h.add("изменить");h.add("статус");h.add("добавить");h.add("настройки");
        if (args.length == 1 && sender.hasPermission("balt.admin")) return Lists.newArrayList(h);

        if (SD.getProfils().getConfig().getString(sender.getName() + ".RealName") == null) {
            if (!sender.hasPermission("balt.admin")) {
                if (args.length == 1) Lists.newArrayList("создать");
                if (args[0].equalsIgnoreCase("создать")) {
                    StringBuilder z = new StringBuilder();
                    for (int i = 1; i < args.length; i++) z.append(args[i]).append(' ');
                    if (z.length() > 1) z.deleteCharAt(z.length() - 1);
                    String f = z.toString();
                    List<String> l = new ArrayList<>();

                    l.add("Р.Имя:");
                    l.add("Ник:");
                    l.add("Дс.Имя:");
                    l.add("Лет:");
                    l.add("Цели:");
                    l.add("О:");
                    l.add("Лор:");
                    //     if(sender.hasPermission("balt.admin") || sender.hasPermission("balt.glava")) l.add("Работа:");

                    if (f.contains("Р.Имя:")) l.remove("Р.Имя:");
                    if (f.contains("Ник:")) l.remove("Ник:");
                    if (f.contains("Дс.Имя:")) l.remove("Дс.Имя:");
                    if (f.contains("Лет:")) l.remove("Лет:");
                    if (f.contains("Цели:")) l.remove("Цели:");
                    if (f.contains("О:")) l.remove("О:");
                    if (f.contains("Лор:")) l.remove("Лор:");
                    return Lists.newArrayList(l);
                }
            }
        }else{
            h.clear();
            players.clear();
            for (Player player : Bukkit.getOnlinePlayers()){
                if(player.hasPermission("balt.reg")){
                    if(SD.getProfils().getConfig().getString(sender.getName() + ".ProfilStatus", "close").equalsIgnoreCase("close"))
                    players.add(player.getName());
                }
            }
            h.addAll(players);
            h.add("изменить"); h.add("статус");h.add("настройки");
        if (args.length == 1 && !sender.hasPermission("balt.admin")) return Lists.newArrayList(h);

        if (args[0].equalsIgnoreCase("изменить")) {
            StringBuilder z = new StringBuilder();
            for (int i = 1; i < args.length; i++) z.append(args[i]).append(' ');
            if (z.length() > 1) z.deleteCharAt(z.length() - 1);
            String f = z.toString();
            List<String> l = new ArrayList<>();

            l.add("Р.Имя:");
            l.add("Ник:");
            l.add("Дс.Имя:");
            l.add("Лет:");
            l.add("Цели:");
            l.add("О:");
      //      l.add("Лор:");

            if (f.contains("Р.Имя:")) l.remove("Р.Имя:");
            if (f.contains("Ник:")) l.remove("Ник:");
            if (f.contains("Дс.Имя:")) l.remove("Дс.Имя:");
            if (f.contains("Лет:")) l.remove("Лет:");
            if (f.contains("Цели:")) l.remove("Цели:");
            if (f.contains("О:")) l.remove("О:");
         //   if (f.contains("Лор:")) l.remove("Лор:");
            return Lists.newArrayList(l);
        }
        if(sender.hasPermission("balt.admin")) if(args[0].equalsIgnoreCase("дабавить") || args[0].equalsIgnoreCase("создать")){
            if(args.length == 2) return Lists.newArrayList("ник");
            StringBuilder z = new StringBuilder();
            for (int i = 1; i < args.length; i++) z.append(args[i]).append(' ');
            if (z.length() > 1) z.deleteCharAt(z.length() - 1);
            String f = z.toString();
            List<String> l = new ArrayList<>();

            l.add("Р.Имя:");
            l.add("Ник:");
            l.add("Дс.Имя:");
            l.add("Лет:");
            l.add("З.Правил:");
            l.add("От.Игрок:");
            l.add("Цели:");
            l.add("О:");
            l.add("Статус:");
            //     if(sender.hasPermission("balt.admin") || sender.hasPermission("balt.glava")) l.add("Работа:");

            if (f.contains("Р.Имя:")) l.remove("Р.Имя:");
            if (f.contains("Ник:")) l.remove("Ник:");
            if (f.contains("Дс.Имя:")) l.remove("Дс.Имя:");
            if (f.contains("Лет:")) l.remove("Лет:");
            if (f.contains("З.Правил:")) l.remove("З.Правил:");
            if (f.contains("От.Игрок:")) l.remove("От.Игрок:");
            if (f.contains("Цели:")) l.remove("Цели:");
            if (f.contains("О:")) l.remove("О:");
            if (f.contains("Статус:")) l.remove("Статус:");
            return Lists.newArrayList(l);
        }

        if(args[0].equalsIgnoreCase("статус")){
            if(args.length == 2)  return Lists.newArrayList("изменить");
            if(args.length == 3 && args[1].equalsIgnoreCase("изменить"))  return Lists.newArrayList("открытый", "закрытый");
        }

        /**
         StringBuilder z = new StringBuilder();
         for (int i = 1; i < args.length; i++) z.append(args[i]).append(' ');
         if (z.length() > 1) z.deleteCharAt(z.length() - 1);
         String f = z.toString();
         List<String> l = new ArrayList<>();

         l.add("Р.Имя:");
         l.add("Ник:");
         l.add("Дс.Имя:");
         l.add("Лет:");
         l.add("З.Правил:");
         l.add("От.Игрок:");
         l.add("Цели:");
         l.add("О:");
         l.add("Статус:");

         if (f.contains("Р.Имя:")) l.remove("Р.Имя:");
         if (f.contains("Ник:")) l.remove("Ник:");
         if (f.contains("Дс.Имя:")) l.remove("Дс.Имя:");
         if (f.contains("Лет:")) l.remove("Лет:");
         if (f.contains("З.Правил:")) l.remove("З.Правил:");
         if (f.contains("От.Игрок:")) l.remove("От.Игрок:");
         if (f.contains("Цели:")) l.remove("Цели:");
         if (f.contains("О:")) l.remove("О:");
         if (f.contains("Статус:")) l.remove("Статус:");
         return Lists.newArrayList(l);
         */
        }

        if (sender.hasPermission("balt.admin") && sender.hasPermission("balt.glava") && args.length == 2) return Lists.newArrayList("изменить");

        if(sender.hasPermission("balt.admin") && sender.hasPermission("balt.glava") && args[1].equalsIgnoreCase("изменить")){
            StringBuilder z = new StringBuilder();
            for (int i = 2; i < args.length; i++) z.append(args[i]).append(' ');
            if (z.length() > 1) z.deleteCharAt(z.length() - 1);
            String f = z.toString();
            List<String> l = new ArrayList<>();

            l.add("Р.Имя:");
            l.add("Ник:");
            l.add("Дс.Имя:");
            l.add("Лет:");
            l.add("Цели:");
            l.add("О:");
            l.add("Лор:");
            l.add("Статус:");

            if (f.contains("Р.Имя:")) l.remove("Р.Имя:");
            if (f.contains("Ник:")) l.remove("Ник:");
            if (f.contains("Дс.Имя:")) l.remove("Дс.Имя:");
            if (f.contains("Лет:")) l.remove("Лет:");
            if (f.contains("Цели:")) l.remove("Цели:");
            if (f.contains("О:")) l.remove("О:");
            if (f.contains("Лор:")) l.remove("Лор:");
            if (f.contains("Статус:")) l.remove("Статус:");
            return Lists.newArrayList(l);
        }

        return Lists.newArrayList();

        }
    }

