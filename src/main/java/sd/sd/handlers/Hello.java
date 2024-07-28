package sd.sd.handlers;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import sd.sd.SD;
import sd.sd.session.Session;

import static sd.sd.SD.reg_perm;
import static sd.sd.SD.spawn_perm;

public class Hello implements Listener {

//    @EventHandler
//    public void onCmd(PlayerCommandSendEvent e){
//    if(e.getCommands().toArray()[0].equals("play") || e.getCommands().toArray()[0].equals("играть") || e.getCommands().toArray()[0].equals("зайти")){
//        Player p = e.getPlayer();
//            if(p.hasPermission(reg_perm) || p.hasPermission(admin_perm)){
//                p.performCommand("/server The-Reality-of-Spasenia");
//            }else{
//                p.sendMessage(Balt.sd + "Для начала игры вам надо быть игроком, если вы ещё не подали заявку, то переходите в наш дискорд https://discord.gg/sd-mc и там подаёте заявку, если ваше заявку уже приняли, то введите код, который вам выдали /sd login <код> если вам его не дали, напишите batr#7749");
//            }
//
//    }
//    }


    @EventHandler
    public void join(PlayerJoinEvent e) {
        Player p = e.getPlayer();
//        if (!p.hasPermission(reg_perm)) {
//            p.setGameMode(GameMode.SPECTATOR);
//        }
        if(SD.offlineSessions.containsKey(p)){
            SD.sessions.put(p, SD.offlineSessions.get(p));
        }else {
            SD.sessions.put(p, new Session(System.currentTimeMillis()));
        }
        if(SD.isHub && !p.isOp()){
            p.setGameMode(GameMode.ADVENTURE);
        }
        if(!SD.isHub && !p.hasPermission(reg_perm)){
            p.kick(Component.text("§6Для перехода на этот сервер вам надо быть игроком, если вы ещё не подали заявку, то переходите в наш дискорд https://discord.gg/sd-mc и там подаёте заявку, если ваше заявку уже приняли, то введите код, который вам выдали /sd login <код> если вам его не дали, напишите batr#7749"));
        }
        if (!p.hasPermission(reg_perm) || e.getPlayer().hasPermission(spawn_perm)) if(SD.getInstance().getConfig().getBoolean("Spawn.On.Join", true)) if(SD.getInstance().getConfig().getLocation("Spawn.Location") != null) p.teleport(SD.getInstance().getConfig().getLocation("Spawn.Location"));
        int time = SD.getMessages().getConfig().getInt("join.time", 11) * 20;
        //Bukkit.getScheduler().scheduleSyncDelayedTask(Balt.getInstance(), () -> p.sendMessage(Balt.sd + " §9Приветствую тебя!"), 220);
        Bukkit.getScheduler().scheduleSyncDelayedTask(SD.getInstance(), () -> {
            if(!SD.getMessages().getStringList("join.hello").isEmpty()) {
                int i = 0;
                for (String st : SD.getMessages().getStringList("join.hello")) {
                    if(i == 0) p.sendMessage(SD.prefix + " " + st);else p.sendMessage(st);
                    i++;
                }
            }else {
                p.sendMessage(SD.prefix + " §7Приветствую на сервере");
            }

//            if (p.hasPermission(reg_perm)) {
////                if(Balt.getMessages().getConfig().getInt("RolePlay.Stadion") >= 1) if (Balt.getProfils().getConfig().getString(p.getName() + ".LorePlayer") == null) {
////                    p.sendMessage(Balt.sd + Balt.getMessages().getString("RolePlay.NoLore", "§4Внимание! У вашего персонажа не указан лор! Просьба его придумать и скинуть §5MrKreiz1#5502"));
////                }
////                if (Balt.getProfils().getConfig().getString(p.getName() + ".RealName") == null && Balt.getProfils().getConfig().getString(p.getName() + ".Nick") == null && Balt.getProfils().getConfig().getString(p.getName() + ".DiscordName") == null && Balt.getProfils().getConfig().getString(p.getName() + ".Age") == null && Balt.getProfils().getConfig().getString(p.getName() + ".PlayerCels") == null && Balt.getProfils().getConfig().getString(p.getName() + ".About") == null) {
////                    p.sendMessage(Balt.sd + " " + Balt.getMessages().getString("join.NoProfile", "§6Просьба создать профиль командой §5/профиль создать Р.Имя: Ник: Дс.Имя: Лет: Цели: О:"));
////                    return;
////                }
////                if (Balt.getProfils().getConfig().getString(p.getName() + ".RealName") == null || Balt.getProfils().getConfig().getString(p.getName() + ".Nick") == null || Balt.getProfils().getConfig().getString(p.getName() + ".DiscordName") == null || Balt.getProfils().getConfig().getString(p.getName() + ".Age") == null || Balt.getProfils().getConfig().getString(p.getName() + ".PlayerCels") == null || Balt.getProfils().getConfig().getString(p.getName() + ".About") == null) {
////                    p.sendMessage(Balt.sd + Balt.getMessages().getString("join.NoFullProfile", "§4Внимание! У вас не полностью заполнен профиль, просьба воспользоваться командой §5/профиль изменить Р.Имя: Ник: Дс.Имя: Лет: Цели: О: §6И заполните пустые поля."));
////                }
//            }else{
//                for(String s : Balt.getMessages().getConfig().getStringList("join.NoRegister")){
//                    Bukkit.getScheduler().scheduleSyncDelayedTask(Balt.getInstance(), () -> {
//                        p.sendMessage(Balt.sd + " " + s.replace("&", "§").replace("<discord>", Balt.getInstance().getConfig().getString("info.discord", "")));
//                    }, time);
//                }
//            }
        }, time);

    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        SD.offlineSessions.put(Bukkit.getOfflinePlayer(e.getPlayer().getName()), SD.sessions.get(e.getPlayer()));
        SD.sessions.remove(e.getPlayer());
    }
}
