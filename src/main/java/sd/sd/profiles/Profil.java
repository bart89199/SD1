package sd.sd.profiles;

import org.bukkit.event.Listener;
import sd.sd.SD;

public class Profil implements Listener {


    private SD plugin;



    public Profil(SD plugin) {
        this.plugin = plugin;
    }
//
//    @EventHandler
//    public void onTimer(InventoryClickEvent e) {
//        String title = e.getView().getTitle();
//        if(e.getCurrentItem() == null) return;
//        if(title.contains("Профиль") || title.contains("профиль")) if(!(e.getInventory().getItem(0) == null)) if(e.getInventory().getItem(0).hasItemMeta()) if(e.getInventory().getItem(0).getItemMeta().getDisplayName().equalsIgnoreCase(" ")){
//            Player p = (Player) e.getView().getPlayer();
//            String player = p.getName();
//            if(title.contains("`а")){
//                player = title.replace("Профиль", "").replace("`а", "").replace(" ", "");
//            }
//            //if(Title.equalsIgnoreCase("Ваш профиль")){
//              //
//            //}
//            e.setCancelled(true);
//            ItemStack i = e.getCurrentItem();
//            assert i != null;
//            String n = e.getCurrentItem().getItemMeta().getDisplayName();
//            if (i.getType().equals(Material.PLAYER_HEAD)) if(n.contains("еальное имя")){
//                p.sendMessage(SD.prefix + " " + n + ": §5" + SD.getProfils().getConfig().getString(player + ".RealName", "§4Не указано"));
//                p.closeInventory();
//            }
//            if (i.getType().equals(Material.AXOLOTL_BUCKET)) if(n.contains("ик")){
//                p.sendMessage(SD.prefix + " " + n + ": §5" + SD.getProfils().getConfig().getString(player + ".Nick", "§4Не указано"));
//                p.closeInventory();
//            }
//            if (i.getType().equals(Material.ENDER_PEARL)) if(n.contains("искорд")){
//                p.sendMessage(SD.prefix + " " + n + ": §5" + SD.getProfils().getConfig().getString(player + ".DiscordName", "§4Не указано"));
//                p.closeInventory();
//            }
//            if (i.getType().equals(Material.ARMOR_STAND)) if(n.contains("озраст")){
//                p.sendMessage(SD.prefix + " " + n + ": §5" + SD.getProfils().getConfig().getString(player + ".Age", "§4Не указано"));
//                p.closeInventory();
//            }
//            if (i.getType().equals(Material.SMALL_DRIPLEAF)) if(n.contains("ели")){
//                p.sendMessage(SD.prefix + " " + n + ": §5" + SD.getProfils().getConfig().getString(player + ".PlayerCels", "§4Не указано"));
//                p.closeInventory();
//            }
//            if (i.getType().equals(Material.BOOK)) if(n.contains("о") || n.contains("О")){
//                p.sendMessage(SD.prefix + " " + n + ": §5" + SD.getProfils().getConfig().getString(player + ".About", "§4Не указано"));
//                p.closeInventory();
//            }
//            if (i.getType().equals(Material.PAPER)) if(n.contains("ор")){
//                p.sendMessage(SD.prefix + " " + n + ": §5" + SD.getProfils().getConfig().getString(player + ".LorePlayer", "§4Не указано"));
//                p.closeInventory();
//            }
//            if (i.getType().equals(Material.NETHER_STAR)) if(n.contains("оложение на сервере")){
//                p.sendMessage(SD.prefix + " " + n + ": §5" + SD.getProfils().getConfig().getString(player + ".Status", "§4Не указано"));
//                p.closeInventory();
//            }
//
//
//
//        }
//
//
//
//        if(title.equalsIgnoreCase("§6Настройки Вашего профиля")){
//            Player p = (Player) e.getView().getPlayer();
//            e.setCancelled(true);
//            ItemStack i = e.getCurrentItem();
//            assert i != null;
//            String n = e.getCurrentItem().getItemMeta().getDisplayName();
//            if(n.contains("Статус вашего профиля:")){
//                p.closeInventory();
//              //  p.showTitle(t);
//                SD.getTags().getConfig().set(p.getName() + ".SetStatusProfile", true);
//
//                Task task = Task.ChangeProfileStatus;
//                task.setTitle(Title.title(Component.text("§cСтатус профиля"), Component.text("§5Введите статус в чат §7Открытый(1), закрытый(2)")));
//                task.setPlayer(p);
//                task.setTarget("SetStatusProfile");
//                task.run();
//
//                p.sendMessage("§9Для отмены напишите §4отмена");
//
//                Bukkit.getScheduler().scheduleSyncDelayedTask(SD.getInstance(), () -> {
//                    if (SD.getTags().getConfig().getBoolean(p.getName() + ".SetStatusProfile"))
//                SD.getTags().getConfig().set(p.getName() + ".SetStatusProfile", false);
//
//                    Bukkit.getScheduler().cancelTask(task.getID());
//                //    p.sendMessage(Balt.sd);
//                }, 1000);
//                return;
//            }
//
//
//            if(i.getItemMeta().getLocalizedName().contains("ProfileData")){
//                String get = p.getName() + "." + i.getItemMeta().getLocalizedName().replace("ProfileData_", "");
//                String get1 = i.getItemMeta().getLocalizedName().replace("ProfileData_", "");
//                String get2 = i.getItemMeta().getLocalizedName().replace("ProfileData_", "").replace("RealName", "Реальное имя").replace("Nick", "Ник").replace("DiscordName", "Дискорд ник").replace("Age", "Возраст").replace("Cels", "Цели").replace("About", "О вас");
//                String get3 = i.getItemMeta().getLocalizedName().replace("ProfileData_", "").replace("RealName", "новое реальное имя").replace("Nick", "новый ник").replace("DiscordName", "новый дискорд ник").replace("Age", "новый возраст").replace("Cels", "новые цели").replace("About", "новую информацию о вас");
//                String whose = i.getItemMeta().getLocalizedName().replace("ProfileData_", "").replace("RealName", "реального имени").replace("Nick", "ника").replace("DiscordName", "дискорд имени").replace("Age", "возраста").replace("Cels", "целей").replace("About", "информации о вас");
//                ChangeName get4 = new ChangeName(get2, whose, get3, i.getItemMeta().getLocalizedName().replace("ProfileData_", ""));
//                get4.setIconWhitProfiles();
//                Settings s = new Settings(p, Material.GRAY_STAINED_GLASS_PANE, get, get4);
//                p.openInventory(s.getInventory());
//            }
//        }
//        if(title.contains("§6Настройки §5")){
//            Player p = (Player) e.getView().getPlayer();
//            e.setCancelled(true);
//            ItemStack i = e.getCurrentItem();
//            assert i != null;
//            String n = e.getCurrentItem().getItemMeta().getDisplayName();
//            if(n.contains("Изменить")){
//                if(i.getItemMeta().getLocalizedName().contains("ProfileData")){
//                    String get = p.getName() + "." + i.getItemMeta().getLocalizedName().replace("ProfileData_", "");
//                    String get1 = i.getItemMeta().getLocalizedName().replace("ProfileData_", "");
//                    String get2 = i.getItemMeta().getLocalizedName().replace("ProfileData_", "").replace("RealName", "Реальное имя").replace("Nick", "Ник").replace("DiscordName", "Дискорд ник").replace("Age", "Возраст").replace("Cels", "Цели").replace("About", "О вас");
//                    String get3 = i.getItemMeta().getLocalizedName().replace("ProfileData_", "").replace("RealName", "новое реальное имя").replace("Nick", "новый ник").replace("DiscordName", "новый дискорд ник").replace("Age", "новый возраст").replace("Cels", "новые цели").replace("About", "новую информацию о вас");
//                    String whose = i.getItemMeta().getLocalizedName().replace("ProfileData_", "").replace("RealName", "реального имени").replace("Nick", "ника").replace("DiscordName", "дискорд имени").replace("Age", "возраста").replace("Cels", "целей").replace("About", "информации о вас");
//                    ChangeName get4 = new ChangeName(get2, whose, get3, get);
//                    p.closeInventory();
//                    SD.getTags().getConfig().set(p.getName() + ".SetInProfile", true);
//                    SD.getTags().getConfig().set(p.getName() + ".set", get);
//
//                    p.sendMessage("§9Для отмены напишите §4отмена");
//
//                    Task task = Task.ChangeProfileStatus;
//                    task.setTitle(Title.title(Component.text("§c" + get2 + " в профиле"), Component.text("§5Введите " + get3)));
//                    task.setPlayer(p);
//                    task.setTarget("SetInProfile");
//                    task.run();
//
//                    Bukkit.getScheduler().scheduleSyncDelayedTask(SD.getInstance(), () -> {
//                        if (SD.getTags().getConfig().getBoolean(p.getName() + ".SetInProfile"))
//                            SD.getTags().getConfig().set(p.getName() + ".SetInProfile", false);
//                        SD.getTags().getConfig().set(p.getName() + ".set", null);
//                        Bukkit.getScheduler().cancelTask(task.getID());
//                    }, 1000);
//                    return;
//                }
//            }
//        }
//    }
//
//    @EventHandler
//    public void onTimer(PlayerCommandPreprocessEvent e) {
//        Player p = e.getPlayer();
//        if (SD.getTags().getConfig().getBoolean(p.getName() + ".SetStatusProfile")) {
//
//            SD.getTags().getConfig().set(p.getName() + ".SetStatusProfile", false);
//            p.clearTitle();
//        }
//
//        if (SD.getTags().getConfig().getBoolean(p.getName() + ".SetInProfile")) {
//
//            SD.getTags().getConfig().set(p.getName() + ".SetInProfile", false);
//            SD.getTags().getConfig().set(p.getName() + ".set", null);
//            p.clearTitle();
//        }
//    }
//
//    @EventHandler
//    public void onPlayerChat(AsyncPlayerChatEvent e) {
//        Player p = e.getPlayer();
//        if (SD.getTags().getConfig().getBoolean(p.getName() + ".SetStatusProfile")) {
//            String Message = e.getMessage();
//
//            if (Message.contains("ткрыт") || Message.equalsIgnoreCase("1")) {
//                SD.getProfils().getConfig().set(p.getName() + ".ProfilStatus", "open");
//                SD.getProfils().save();
//                SD.getTags().getConfig().set(p.getName() + ".SetStatusProfile", false);
//                p.clearTitle();
//                e.setCancelled(true);
//                Bukkit.getScheduler().scheduleSyncDelayedTask(SD.getInstance(), () -> {
//                    Settings m = new Settings(p, Material.GRAY_STAINED_GLASS_PANE);
//                    p.openInventory(m.getInventory());
//                }, 5);
//                return;
//            }
//            if(Message.contains("тмена")){
//                SD.getTags().getConfig().set(p.getName() + ".SetStatusProfile", false);
//                p.clearTitle();
//                e.setCancelled(true);
//                return;
//            }
//
//            if (Message.contains("акрыт")  || Message.equalsIgnoreCase("2")) {
//                SD.getTags().getConfig().set(p.getName() + ".SetStatusProfile", false);
//                SD.getProfils().getConfig().set(p.getName() + ".ProfilStatus", "close");
//                SD.getProfils().save();
//                p.clearTitle();
//                e.setCancelled(true);
//                Bukkit.getScheduler().scheduleSyncDelayedTask(SD.getInstance(), () -> {
//                    Settings m = new Settings(p, Material.GRAY_STAINED_GLASS_PANE);
//                    p.openInventory(m.getInventory());
//                }, 5);
//                return;
//            }
//            p.sendMessage(SD.prefix + " §cВведите новый статус профиля! §2открытый§7/§4закрытый §3или §4отмените §3изменение профиля прописав §6отмена");
//            e.setCancelled(true);
//        }
//
//
//        if (SD.getTags().getConfig().getBoolean(p.getName() + ".SetInProfile")) {
//            String Message = e.getMessage();
//            if(Message.contains("тмена")){
//                SD.getTags().getConfig().set(p.getName() + ".SetInProfile", false);
//                p.clearTitle();
//                e.setCancelled(true);
//                return;
//            }
//
//                SD.getProfils().getConfig().set(SD.getTags().getConfig().getString(p.getName() + ".set"), Message.replace("&", "§"));
//                SD.getProfils().save();
//                SD.getTags().getConfig().set(p.getName() + ".SetInProfile", false);
//            SD.getTags().getConfig().set(p.getName() + ".set", null);
//                p.clearTitle();
//                e.setCancelled(true);
//                Bukkit.getScheduler().scheduleSyncDelayedTask(SD.getInstance(), () -> {
//                    Settings m = new Settings(p, Material.GRAY_STAINED_GLASS_PANE);
//                    p.openInventory(m.getInventory());
//                }, 20);
//                return;
//
//
//        }


//    }


/**
    @EventHandler
    public void onTimer(PlayerEvent e) {
        Player p = e.getPlayer();
        if(Balt.getTags().getConfig().getBoolean(p.getName() + ".SetStatusProfile")){
            Title t = Title.title (Component.text("§cВведите желаемый статус профиля в чат"), Component.text("§7Открытый, закрытый"));
            p.showTitle(t);
        }
    }

@EventHandler
public void onTimer(PlayerMoveEvent e) {
    Player p = e.getPlayer();
    if(Balt.getTags().getConfig().getBoolean(p.getName() + ".SetStatusProfile")){
        Title t = Title.title (Component.text("§cВведите желаемый статус профиля в чат"), Component.text("§7Открытый, закрытый"));
        p.showTitle(t);
    }
}
 */
}

