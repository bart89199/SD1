package sd.sd.shops;

import com.google.common.collect.Lists;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;
import sd.sd.SD;
import sd.sd.metods.Enter;
import sd.sd.shops.ShopGUIInventories.CertainShop;
import sd.sd.shops.ShopGUIInventories.MainMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static sd.sd.SD.getShops;
import static sd.sd.SD.listOfShops;

public class ShopGUI extends Enter implements Listener {

    public static Map<String, EditedInShop> drafts = new HashMap<>();
    public Inventory inv;
    public ShopGUI(){ }

    public ShopGUI(ShopGUIFormat format, Player p, Shop shop){

        ShopGUIInventory shopGUIInventory = format.getShopGUIInventory();
        shopGUIInventory.generateInventory(p, shop);
        inv = shopGUIInventory.getInventory();

    }
//    @Override
//    public Enter getExClass() {
//        return this;
//    }

    @Override
    public boolean onEnter(String enterString, String data) {
        switch (data){
            case "name" -> {
                drafts.get(getP().getName()).addEdited(data, enterString);
                drafts.get(getP().getName()).editInShop(drafts.get(getP().getName()), prefix, data);
                openInventory();
                return true;
            }

            case "start", "end", "put", "get" -> {

                onEnterLocation(enterString, data, prefix);
                return true;

            }

            case "delete" -> {

                if(enterString.equals("0")){
                    openInventory();
                    return true;
                } else if (enterString.equals("1")) {
                    drafts.get(getP().getName()).delete();
                    getP().sendMessage(SD.prefix + " §2Магазин удалён!");
                    return true;
                } else {
                    getP().sendMessage(SD.prefix + " §4Ошибка! Введите 0 или 1");
                    return false;
                }

            }

            default -> {
                getP().sendMessage(SD.prefix + " §4Ошибка!");
                return false;
            }
        }
    }

    public void onEnterLocation(String enterString, String data, String prefix) {

        int[] newCoordinates = new int[3];

        try{
            String[] args = enterString.split(" ");

            if (args.length < 3){
                getP().sendMessage(SD.prefix + " §4У вас только " + args.length + " значения, а должно быть 3");
                return;
            } else if (args.length > 3) {
                getP().sendMessage(SD.prefix + " §cУ вас более 3 значений, мы попробуем добавить первые три из них.");
            }

            newCoordinates[0] = Integer.parseInt(args[0]);
            newCoordinates[1] = Integer.parseInt(args[1]);
            newCoordinates[2] = Integer.parseInt(args[2]);
            drafts.get(getP().getName()).addEdited(data, newCoordinates);
            drafts.get(getP().getName()).editInShopLocation(drafts.get(getP().getName()), prefix, data);
            openInventory();

            return;

        } catch (Exception e) {
            getP().sendMessage(SD.prefix + " §4Произошла ошибка в процессе обработки информации, ошибка: " + e.getLocalizedMessage());
        }

        try {
            openInventory();
        } catch (Exception e) {
            getP().sendMessage(SD.prefix + " §4Произошла ошибка в процессе обработки информации, ошибка: " + e.getLocalizedMessage());
        }


    }

    public void openInventory() {
        new BukkitRunnable() {
            @Override
            public void run() {
                getP().openInventory(getInv());
            }
        }.runTask(SD.getInstance());
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {

        Player p = (Player) e.getView().getPlayer();
        if (e.getView().getTitle().equalsIgnoreCase("§9Главное меню магазинов")) {

            Inventory inv = e.getClickedInventory();

            e.setCancelled(true);

            ItemStack item = e.getCurrentItem();


            if (item != null && !item.getType().isEmpty()) {

                if (item.hasItemMeta() && item.getItemMeta().hasLocalizedName()) {

                    String l = item.getItemMeta().getLocalizedName();

                    switch (l) {

                        case "continue" -> {

                            p.closeInventory();

                            if(drafts.containsKey(p.getName())){

                                p.openInventory(drafts.get(p.getName()).getShopInventory());

                            }else {
                                p.sendMessage(SD.prefix + " §4Ошибка!");
                            }


                        }

                        case "up", "down" -> {

                            ItemStack i;
                            ItemMeta m;

                            int sl = Integer.valueOf(inv.getItem(10).getItemMeta().getLocalizedName());




                            int c = sl + 1;
                            if (l.equals("down")) {
                                c = sl - 1;
                            }
                            if (listOfShops != null && !listOfShops.isEmpty()) {

                                int line = 0;
                                int slot = 0;
                                int number = 0;

//                        try {
                                ArrayList<ItemStack[]> listOfShopsInItems = new ArrayList<>();



                                slot = 0;


                                if (c > 0) {
                                    i = new ItemStack(Material.POINTED_DRIPSTONE);
                                    m = i.getItemMeta();
                                    m.setDisplayName("§6Вниз");
                                    m.setLocalizedName("down");
                                    i.setItemMeta(m);
                                    inv.setItem(4, i);
                                } else {
                                    inv.setItem(4, new ItemStack(Material.AIR));
                                }

                                inv.setItem(6, new ItemStack(Material.AIR));
                                for (int a = 0; c < listOfShopsInItems.size(); a++) {


                                    ItemStack[] items = listOfShopsInItems.get(c++);


                                    if (a < 4) {

                                        for (int s = 0; s < items.length; s++) {

                                            inv.setItem((10 + slot++ + a * 2), items[s]);

                                        }

                                    } else {

                                        i = new ItemStack(Material.CANDLE);
                                        m = i.getItemMeta();
                                        m.setDisplayName("§6Вверх");
                                        m.setLocalizedName("up");
                                        i.setItemMeta(m);

                                        inv.setItem(6, i);
                                        break;

                                    }

                                }

                            }
                        }

                    }


                    if (item.getItemMeta().hasLore() && item.getItemMeta().getLore().equals(Lists.newArrayList("§3Для выбора клик"))) {

                        ItemMeta m;
                        ItemStack i;
                        Shop shop = SD.getShops().getShop(UUID.fromString(item.getItemMeta().getLocalizedName().replace("§9", "")));

                        if (shop != null) {

                            p.openInventory(new ShopGUI(ShopGUIFormat.CERTAIN_SHOP, p, shop).getInventory());

                        }

                    }
                }

            }


        }

        if (e.getView().getTitle().contains("§9Магазин §6")) {

            Inventory inv = e.getClickedInventory();

            e.setCancelled(true);

            ItemStack item = e.getCurrentItem();

            if (item != null && !item.getType().isEmpty()) {

                if (item.hasItemMeta() && item.getItemMeta().hasLocalizedName()) {

                    String l = item.getItemMeta().getLocalizedName();

                    switch (l) {

                        case "back" -> {
                            p.closeInventory();
                            p.openInventory(new ShopGUI(ShopGUI.ShopGUIFormat.MAIN_MENU, p, null).getInventory());
                        }

                        case "save" -> {
                            EditedInShop editedInShop = drafts.get(p.getName());
                            editedInShop.save();
                            p.openInventory(new ShopGUI(ShopGUIFormat.CERTAIN_SHOP, p, editedInShop.shop).getInventory());
                        }

                        case "delete" -> {
                            p.closeInventory();
                            enter(p, Title.title(Component.text("Удаление"), Component.text("Удаление - 1, отмена - 0")),
                                    100, inv, l, "");
                            run();
                        }

                        case "name" -> {
                            p.closeInventory();
                            enter(p, Title.title(Component.text("Введите"), Component.text("Новое имя магазина")),
                                    100, inv, l, "§3Имя §7:");
                            run();
                        }

                        case "start" -> {
                            p.closeInventory();
                            enter(p, Title.title(Component.text("Введите новые координаты"), Component.text("Начала магазина, в формате x y z")),
                                    100, inv, l, "§3Начало магазина §7:");
                            run();
                        }

                        case "end" -> {
                            p.closeInventory();
                            enter(p, Title.title(Component.text("Введите новые координаты"), Component.text("Конца магазина, в формате x y z")),
                                    100, inv, l, "§3Конец магазина §7:");
                            run();
                        }

                        case "put" -> {
                            p.closeInventory();
                            enter(p, Title.title(Component.text("Введите новые координаты"), Component.text("Бочки для складывания, в формате x y z")),
                                    100, inv, l, "§3Бочка для складывания магазина §7:");
                            run();
                        }

                        case "get" -> {
                            p.closeInventory();
                            enter(p, Title.title(Component.text("Введите новые координаты"), Component.text("Бочки получения, в формате x y z")),
                                    100, inv, l, "§3Бочка получения магазина §7:");
                            run();
                        }

                    }
                }
            }
        }
    }

    @Override
    public @NotNull Inventory getInventory() {
        return inv;
    }


    public static class EditedInShop{

        Map<String, Object> edited = new HashMap<>();
        private Shop shop;

        private Inventory shopInventory;

        public Inventory getShopInventory() {
            return shopInventory;
        }

        public void setShopInventory(Inventory shopInventory) {
            this.shopInventory = shopInventory;
        }

        public Shop getShop() {
            return shop;
        }

        public void setShop(Shop shop) {
            this.shop = shop;
        }

        public EditedInShop(Inventory shop, Shop s) {
            this.shop = s;
            this.shopInventory = shop;
        }

        public EditedInShop(Inventory shop, Map<String, Object> edited, Shop s) {
            this.shopInventory = shop;
            this.edited = edited;
            this.shop = s;
        }

        public void addEdited(String key, Object value){
            edited.put(key, value);
        }

        public void delete() {
            if(!getShops().removeShop(shop.getName())) {
                Bukkit.getConsoleSender().sendMessage(SD.prefix + " §4Магазин " + shop.getName() + " не был удалён в процессе удаления");

            }
        }

        public void save() {


            if(edited.get("name") instanceof String s){
                shop.setName(s);
            }
            if(edited.get("start") instanceof int[] c){
                shop.setStart(new Location(shop.getStart().getWorld(), c[0], c[1], c[2]));
            }
            if(edited.get("end") instanceof int[] c){
                shop.setEnd(new Location(shop.getEnd().getWorld(), c[0], c[1], c[2]));
            }
            if(edited.get("get") instanceof int[] c){
                shop.setGet(new Location(shop.getGet().getWorld(), c[0], c[1], c[2]));
            }
            if(edited.get("put") instanceof int[] c){
                shop.setPut(new Location(shop.getPut().getWorld(), c[0], c[1], c[2]));
            }
            if(edited.get("items") instanceof ItemStack[] i){
                shop.setItems(i);
            }

            if(edited.get("armorStands") instanceof UUID[] u){
                shop.setArmorStands(u);
            }

            if(!getShops().removeShop(shop.getName())) {
                Bukkit.getConsoleSender().sendMessage(SD.prefix + " §4Магазин " + shop.getName() + " не был удалён в процессе обновления");
            }

            getShops().addShop(shop);

        }

        public void editInShop(Inventory shop, EditedInShop edited){
//        if(edited != null)
            for(ItemStack i : shop.getContents()){
                if(i != null && i.hasItemMeta() && i.getItemMeta().hasLocalizedName() &&
                        edited.edited.containsKey(i.getItemMeta().getLocalizedName())){
                    switch (i.getItemMeta().getLocalizedName()){
                        case "name" -> {
                            if(!i.getItemMeta().getDisplayName().equals("§3Имя §7: §6" + edited.edited.get(i.getItemMeta().getLocalizedName()))) {
                                ItemMeta m = i.getItemMeta();
                                m.setDisplayName("§3Имя §7: §6" + edited.edited.get(i.getItemMeta().getLocalizedName()) + " §7(изменено)");
                                i.setItemMeta(m);
                            }
                        }
                    }
                }
            }
        }
        public void editInShop(EditedInShop edited, String prefix, String data){
            for(ItemStack i : shopInventory.getContents()){
                if(i != null && i.hasItemMeta() && i.getItemMeta().hasLocalizedName() &&
                        i.getItemMeta().getLocalizedName().equals(data) && edited.edited.get(data) instanceof String edited1){
                    ItemMeta m = i.getItemMeta();
                    m.setDisplayName(prefix + " §6" + edited1 + " §7(изменено)");
                    i.setItemMeta(m);

                }
            }
        }

        public void editInShopLocation(EditedInShop edited, String prefix, String data){
            for(ItemStack i : shopInventory.getContents()){
                if(i != null && i.hasItemMeta() && i.getItemMeta().hasLocalizedName() &&
                        i.getItemMeta().getLocalizedName().equals(data) &&
                    edited.edited.get(data) instanceof int[] cords) {
                    ItemMeta m = i.getItemMeta();
                    m.setDisplayName(prefix + " §6" + cords[0] + " " + cords[1] + " " + cords[2] + " §7(изменено)");
                    i.setItemMeta(m);

                }
            }
        }
    }

    public enum ShopGUIFormat {
        MAIN_MENU(1, new MainMenu()), CERTAIN_SHOP(2, new  CertainShop()), ERROR(0, null);

        private final int number;

        public ShopGUIInventory getShopGUIInventory() {
            return shopGUIInventory;
        }

        final ShopGUIInventory shopGUIInventory;

        public int getNumber() {
            return number;
        }

        ShopGUIFormat(int number, ShopGUIInventory shopGUIInventory) {
            this.number = number;
            this.shopGUIInventory = shopGUIInventory;
        }

        public static ShopGUIFormat getFormat(int number) {
            for(ShopGUIFormat i : ShopGUIFormat.values()) {

                if (i.getNumber() == number) return i;

            }
            return ERROR;
        }



    }

}
