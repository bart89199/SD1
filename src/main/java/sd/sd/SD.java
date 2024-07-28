package sd.sd;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;
import sd.sd.Files.*;
import sd.sd.admin.HandlerAdm;
import sd.sd.commands.ItemLore;
import sd.sd.commands.MainCommand;
import sd.sd.commands.MoneyCommand;
import sd.sd.commands.RPDice;
import sd.sd.crafts.Crafts;
import sd.sd.crafts.CraftsListener;
import sd.sd.handlers.Hello;
import sd.sd.handlers.Register;
import sd.sd.metods.Enter;
import sd.sd.session.Session;
import sd.sd.shops.Shop;
import sd.sd.shops.ShopGUI;
import sd.sd.species.playerSpecies.CryfixElectro;
import sd.sd.species.Specie;
import sd.sd.species.SpecieListener;
import sd.sd.species.playerSpecies.Kezet_;
import sd.sd.species.playerSpecies.MagisterSam;
import sd.sd.stonecutter.CraftsCommand.MenuControl;
import sd.sd.stonecutter.StoneCutterCrafts;
import sd.sd.stonecutter.Update;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class SD extends JavaPlugin {

    public static String ban = "\u00a74Вы были забанены великим и несравненным Batr`ом!";
    private static SD instance;
    private Codes codes;
    private sd.sd.Files.profils profils;
    private FileServer ServerAbout;
    private Messages Messages;
    private Shops Shops;
    private sd.sd.Files.Crafts Crafts;
    private Logs Logs;
    ConsoleCommandSender log = Bukkit.getConsoleSender();
    public static String prefix = "§8[§9§lS§8§lD§8]";
    public static boolean batr;

    public static boolean isHub = false;

    public static StoneCutterCrafts stoneCutterCrafts = new StoneCutterCrafts();

    public static List<Integer> ListOfRecipesSlots = new ArrayList<>();

    public static Permission reg_perm = new Permission("sd.reg", "This permission gives to registered");
    public static Permission admin_perm = new Permission("sd.admin", "This permission gives to admins");
    public static Permission spawn_perm = new Permission("sd.tp.spawn", "With this permission player teleport to spawn on death and join");

    public static List<Shop> shops;
    public static List<Shop[]> listOfShops = new ArrayList<>();
    public static List<Enter> enterToChatMap = new ArrayList<>();
    public static Map<Player, Session> sessions = new HashMap<>();
    public static Map<OfflinePlayer, Session> offlineSessions = new HashMap<>();
    public static Map<String, Specie> playersSpecies = new HashMap<>();

    @Override
    public void onEnable() {

        log.sendMessage("§9====  ||==\\\\");
        log.sendMessage("§9|     ||  ||    §6- §9 Role Play §5плагин");
        log.sendMessage("§9|     ||  ||  ");
        log.sendMessage("§9|     ||  ||    §6Автор: §5§lBatr");
        log.sendMessage("§9====  ||==//");


        ConfigurationSerialization.registerClass(Shop.class);
        log.sendMessage("§6Магазины зарегистрированы для сериализации");
        ListOfRecipesSlots.add(27); ListOfRecipesSlots.add(28); ListOfRecipesSlots.add(29); ListOfRecipesSlots.add(30); ListOfRecipesSlots.add(31); ListOfRecipesSlots.add(32); ListOfRecipesSlots.add(33);
        ListOfRecipesSlots.add(36); ListOfRecipesSlots.add(37); ListOfRecipesSlots.add(38); ListOfRecipesSlots.add(39); ListOfRecipesSlots.add(40); ListOfRecipesSlots.add(41); ListOfRecipesSlots.add(42);
        new Crafts();
        instance = this;

        new MainCommand();
        new sd.sd.commands.Hub();
        new ItemLore();
        new sd.sd.commands.NonRPCmd();
        new sd.sd.commands.MeDo();
        new sd.sd.commands.CraftsCmd();
        new sd.sd.commands.Play();
        new sd.sd.commands.ShopCommand();
        new RPDice();
        new MoneyCommand();
        log.sendMessage("§6Команды зарегистрированы");
        Bukkit.getPluginManager().registerEvents(new CraftsListener(), this);
        Bukkit.getPluginManager().registerEvents(new Register(), this);
        Bukkit.getPluginManager().registerEvents(new sd.sd.books.Handler(this), this);
        Bukkit.getPluginManager().registerEvents(new Hello(), this);
        Bukkit.getPluginManager().registerEvents(new HandlerAdm(), this);
        Bukkit.getPluginManager().registerEvents(new Elytra(), this);
        Bukkit.getPluginManager().registerEvents(new Update(), this);
        Bukkit.getPluginManager().registerEvents(new MenuControl(), this);
        Bukkit.getPluginManager().registerEvents(new SpecieListener(), this);
        Bukkit.getPluginManager().registerEvents(new Shop.ShopListener(), this);
        log.sendMessage("§6События зарегистрированы");
        saveDefaultConfig();
        profils = new profils("profiles.yml");
        ServerAbout = new FileServer("FileServer.yml");
        codes = new Codes("Codes.yml");
        Messages = new Messages("Messages.yml");
        Crafts = new sd.sd.Files.Crafts("Crafts.yml");
        Logs = new sd.sd.Files.Logs("Logs.yml");
        Shops = new Shops("Shops.yml");

        SD.getInstance().reloadConfig();
        batr = true;
        isHub = getConfig().getBoolean("isHub");

        log.sendMessage("§6Конфиги готовы");

        prefix = SD.getInstance().getConfig().getString("info.prefix", "§8[§9§lS§8§lD§8]").replace("&", "§");

        if(SD.isHub) {
            log.sendMessage("§6Сервер отмечен как хаб");
            Bukkit.getPluginManager().registerEvents(new Shop.ShopListener(), this);
            Bukkit.getPluginManager().registerEvents(new ShopGUI(), this);
            log.sendMessage("§6События магазинов зарегистрированы");
            SD.shops = getShops().getShops();
            log.sendMessage("§6Магазины реализованы");
           if(!SD.shops.isEmpty()) {
               log.sendMessage("§6Магазины есть");
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
               log.sendMessage("§6Магазины готовы");
           }else log.sendMessage("§6Магазинов нет");
        }else{
            log.sendMessage("§6Сервер отмечен как основной");
            shops = new ArrayList<>();
            new CryfixElectro("CryfixElectro");
            new Kezet_("Kezet_");
            new MagisterSam("BATR_PRO");
            log.sendMessage("§6Способности игроков готовы");
        }


        ItemMeta m = sd.sd.crafts.Crafts.money.getItemMeta();
        m.setDisplayName("§6Монетка");
        m.setCustomModelData(40060001);
        sd.sd.crafts.Crafts.money.setItemMeta(m);
//
//        listOfShops = new ArrayList<>();
//        listOfShops.add(new Shop[7]);


        //Bukkit.getScheduler().scheduleSyncRepeatingTask(Balt.getInstance(), () -> {
        //for (Player p : Bukkit.getOnlinePlayers()){

        //      if(p.hasPermission("balt.reg")){
        //     List<String> listreg = getConfig().getStringList("messages.join.noregister");
        //       for (String noreg : listreg) {
        //    Bukkit.getScheduler().scheduleSyncDelayedTask(this, () -> {
        //             noreg = noreg.replace("&", "\u00a7");
        //               p.sendMessage(Balt.sd + noreg);
        //                  p.sendMessage(sd);
        //         }
        //    }, 70);
        //           }


        //     }
        //   }, 0, 100);

//        if (!setupEconomy() ) {
//            getServer().getPluginManager().disablePlugin(this);
//            return;
//        }
    }




    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }



    public static SD getInstance() {
        return instance;
    }

    public static profils getProfils(){
        return instance.profils;
    }

    public static Codes getCodesSistem(){
        return instance.codes;
    }

    public static FileServer getFileServerAbout(){
        return instance.ServerAbout;
    }

    public static Messages getMessages(){
        return instance.Messages;
    }
    public static Shops getShops(){
        return instance.Shops;
    }

    public static sd.sd.Files.Crafts getCrafts(){
        return instance.Crafts;
    }
    public static Logs getLogs(){
        return instance.Logs;
    }

    public static String getString(String way){
        return SD.getInstance().getConfig().getString(way).replace("<prefix>", SD.prefix).replace("&", "§").replace("<discord>", SD.getInstance().getConfig().getString("info.discord", ""));
    }

    public static String getString(String way, String def){
        return SD.getInstance().getConfig().getString(way, def).replace("<prefix>", SD.prefix).replace("&", "§").replace("<discord>", SD.getInstance().getConfig().getString("info.discord", ""));
    }

    public static List<String> getStringList(String way){
        List<String> getList = getInstance().getConfig().getStringList(way);
        List<String> endList = new ArrayList<>();
        for (String abouts : getList) {
            endList.add(abouts.replace("<prefix>", SD.prefix).replace("&", "§").replace("<discord>", SD.getInstance().getConfig().getString("info.discord", "")));
        }
        return endList;
    }
}
