package sd.sd.profiles;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import sd.sd.SD;
import sd.sd.metods.Lore;

import java.util.ArrayList;
import java.util.List;

public class Profils implements InventoryHolder {

    private Inventory inventory;
    private ItemStack EmptySlot;

    public Profils(String player, TypeProfile typeProfile, Material EmptySlot) {
        if(typeProfile.equals(TypeProfile.My)){
            this.inventory = Bukkit.createInventory(this, 9 * 3, "§6Ваш профиль");
            for (int i = 0; i < 27; i++) {
                ItemStack itemStack = new ItemStack(EmptySlot);
                ItemMeta m = itemStack.getItemMeta();
                m.setDisplayName(" ");
                itemStack.setItemMeta(m);
                this.inventory.setItem(i, itemStack);
                this.EmptySlot = itemStack;
            }
            ItemStack RealName = new ItemStack(Material.PLAYER_HEAD);
            ItemMeta m = RealName.getItemMeta();
            m.setDisplayName("§6Ваше реальное имя");
            m.setLore(new Lore(SD.getProfils().getConfig().getString(player + ".RealName", "§4Не указано"), 20).getResult());
            RealName.setItemMeta(m);
            if(SD.getInstance().getConfig().getBoolean("Profil." + "RealName", false))
            this.inventory.setItem(1, RealName);
            ItemStack Nick = new ItemStack(Material.AXOLOTL_BUCKET);
            m = Nick.getItemMeta();
            m.setDisplayName("§6Ваш ник");
            m.setLore(new Lore(SD.getProfils().getConfig().getString(player + ".Nick", "§4Не указано"), 20).getResult());
            Nick.setItemMeta(m);
            if(SD.getInstance().getConfig().getBoolean("Profil." + "Nick", false))
            this.inventory.setItem(3, Nick);
            ItemStack DiscordName = new ItemStack(Material.ENDER_PEARL);
            m = DiscordName.getItemMeta();
            m.setDisplayName("§6Ваш ник дискорд");
            m.setLore(new Lore(SD.getProfils().getConfig().getString(player + ".DiscordName", "§4Не указано"), 40).getResult());
            DiscordName.setItemMeta(m);
            if(SD.getInstance().getConfig().getBoolean("Profil." + "DiscordName", false))
            this.inventory.setItem(5, DiscordName);
            ItemStack Age = new ItemStack(Material.ARMOR_STAND);
            m = Age.getItemMeta();
            m.setDisplayName("§6Ваш возраст");
            m.setLore(new Lore(SD.getProfils().getConfig().getString(player + ".Age", "§4Не указано"), 20).getResult());
            Age.setItemMeta(m);
            if(SD.getInstance().getConfig().getBoolean("Profil." + "Age", false))
            this.inventory.setItem(7, Age);
            ItemStack Cels = new ItemStack(Material.SMALL_DRIPLEAF);
            m = Cels.getItemMeta();
            m.setDisplayName("§6Ваши цели");
            m.setLore(new Lore(SD.getProfils().getConfig().getString(player + ".PlayerCels", "§4Не указано"), 60).getResult());
            Cels.setItemMeta(m);
            if(SD.getInstance().getConfig().getBoolean("Profil." + "Cels", false))
            this.inventory.setItem(19, Cels);
            ItemStack About = new ItemStack(Material.BOOK);
            m = About.getItemMeta();
            m.setDisplayName("§6О вас");
            m.setLore(new Lore(SD.getProfils().getConfig().getString(player + ".About", "§4Не указано"), 40).getResult());
            About.setItemMeta(m);
            if(SD.getInstance().getConfig().getBoolean("Profil." + "About", false))
            this.inventory.setItem(21, About);
            ItemStack LorePlayer = new ItemStack(Material.PAPER);
            m = LorePlayer.getItemMeta();
            m.setDisplayName("§6Лор вашего персонажа");
            m.setLore(new Lore(SD.getProfils().getConfig().getString(player + ".LorePlayer", "§4Не указано"), 60).getResult());
            LorePlayer.setItemMeta(m);
            if(SD.getInstance().getConfig().getBoolean("Profil." + "LorePlayer", false))
            this.inventory.setItem(23, LorePlayer);
            ItemStack Status = new ItemStack(Material.NETHER_STAR);
            m = Status.getItemMeta();
            m.setDisplayName("§6Ваше положение на сервере");
            m.setLore(new Lore(SD.getProfils().getConfig().getString(player + ".Status", "§4Не указано"), 40).getResult());
            Status.setItemMeta(m);

        }

        if(typeProfile.equals(TypeProfile.Players)){
            this.inventory = Bukkit.createInventory(this, 9 * 3, "§6Профиль §5" + player);
            for (int i = 0; i < 27; i++) {
                ItemStack itemStack = new ItemStack(EmptySlot);
                ItemMeta m = itemStack.getItemMeta();
                m.setDisplayName(" ");
                itemStack.setItemMeta(m);
                this.inventory.setItem(i, itemStack);
                this.EmptySlot = itemStack;
            }

            ItemStack RealName = new ItemStack(Material.PLAYER_HEAD);
            ItemMeta meta = RealName.getItemMeta();
            meta.setDisplayName("§6Реальное Имя " + player);
            meta.setLore(new Lore(SD.getProfils().getConfig().getString(player + ".RealName", "§4Не указано"), 20).getResult());
            RealName.setItemMeta(meta);
            if(SD.getInstance().getConfig().getBoolean("Profil." + "RealName", false))
                this.inventory.setItem(1, RealName);
            ItemStack Nick = new ItemStack(Material.AXOLOTL_BUCKET);
            meta = Nick.getItemMeta();
            meta.setDisplayName("§6Ник " + player + "`а");
            meta.setLore(new Lore(SD.getProfils().getConfig().getString(player + ".Nick", "§4Не указано"), 20).getResult());
            Nick.setItemMeta(meta);
            if(SD.getInstance().getConfig().getBoolean("Profil." + "Nick", false))
            this.inventory.setItem(3, Nick);
            ItemStack DiscordName = new ItemStack(Material.ENDER_PEARL);
            meta = DiscordName.getItemMeta();
            meta.setDisplayName("§6Ник дискорд " + player);
            meta.setLore(new Lore(SD.getProfils().getConfig().getString(player + ".DiscordName", "§4Не указано"), 40).getResult());
            DiscordName.setItemMeta(meta);
            if(SD.getInstance().getConfig().getBoolean("Profil." + "DiscordName", false))
            this.inventory.setItem(5, DiscordName);
            ItemStack Age = new ItemStack(Material.ARMOR_STAND);
            meta = Age.getItemMeta();
            meta.setDisplayName("§6Возраст " + player);
            meta.setLore(new Lore(SD.getProfils().getConfig().getString(player + ".Age", "§4Не указано"), 20).getResult());
            Age.setItemMeta(meta);
            if(SD.getInstance().getConfig().getBoolean("Profil." + "Age", false))
            this.inventory.setItem(7, Age);
            ItemStack Cels = new ItemStack(Material.SMALL_DRIPLEAF);
            meta = Cels.getItemMeta();
            meta.setDisplayName("§6Цели " + player);
            meta.setLore(new Lore(SD.getProfils().getConfig().getString(player + ".PlayerCels", "§4Не указано"), 40).getResult());
            Cels.setItemMeta(meta);
            if(SD.getInstance().getConfig().getBoolean("Profil." + "Cels", false))
            this.inventory.setItem(19, Cels);
            ItemStack About = new ItemStack(Material.BOOK);
            meta = About.getItemMeta();
            meta.setDisplayName("§6О " + player);
            meta.setLore(new Lore(SD.getProfils().getConfig().getString(player + ".About", "§4Не указано"), 40).getResult());
            About.setItemMeta(meta);
            if(SD.getInstance().getConfig().getBoolean("Profil." + "About", false))
            this.inventory.setItem(21, About);
            ItemStack Lore = new ItemStack(Material.PAPER);
            meta = Lore.getItemMeta();
            meta.setDisplayName("§6Лор " + player);
            meta.setLore(new Lore(SD.getProfils().getConfig().getString(player + ".LorePlayer", "§4Не указано"), 80).getResult());
            Lore.setItemMeta(meta);
            if(SD.getInstance().getConfig().getBoolean("Profil." + "LorePlayer", false))
                this.inventory.setItem(23, Lore);
            ItemStack Status = new ItemStack(Material.NETHER_STAR);
            meta = Status.getItemMeta();
            meta.setDisplayName("§6Положение на сервере " + player);
            meta.setLore(new Lore(SD.getProfils().getConfig().getString(player + ".Status", "§4Не указано"), 40).getResult());
            Status.setItemMeta(meta);
            if(SD.getInstance().getConfig().getBoolean("Profil." + "Status", false))
                this.inventory.setItem(25, Status);
            String c = "f";
            int r = SD.getProfils().getConfig().getInt(player + ".Reiting");
            ItemStack Reiting = new ItemStack(Material.AIR);
            if(r > 9){
                c = "c";
                Reiting = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
            }
            if(r > 24){
                c = "6";
                Reiting = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
            }
            if(r > 38){
                c = "3";
                Reiting = new ItemStack(Material.CYAN_STAINED_GLASS_PANE);
            }
            if(r > 49){
                c = "d";
                Reiting = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
            }
            if(r > 74){
                c = "5";
                Reiting = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
            }
            if(r > 99){
                c = "2";
                Reiting = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            }
            if(r < 10){
                c = "4";
                Reiting = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            }
            meta = Reiting.getItemMeta();
            meta.setDisplayName("§" + c + "Социальный рейтинг " + player + "`а: " + r);
            //         m.setLore(new Lore(Balt.getProfils().getConfig().getString(sender.getName() + ".Reiting"), 20).getResult());
            Reiting.setItemMeta(meta);
            if(SD.getInstance().getConfig().getBoolean("Profil." + "SocialRaiting", false))
                this.inventory.setItem(13, Reiting);


        }
    }
/**
    public Profils setPlayersProfil(Player player, Material EmptySlot){
        this.inventory = Bukkit.createInventory(this, 9 * 3, "§6Профиль §5" + player.getName());
        for(ItemStack itemStack : this.inventory){
            itemStack.setType(EmptySlot);
            ItemMeta m = itemStack.getItemMeta();
            m.setDisplayName(" ");
            itemStack.setItemMeta(m);
        }
        ItemStack RealName = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta meta = RealName.getItemMeta();
        meta.setDisplayName("§6Реальное Имя " + player + "`а");
        meta.setLore(new Lore(Balt.getProfils().getConfig().getString(player + ".RealName", "§4Не указано"), 20).getResult());
        RealName.setItemMeta(meta);
        this.inventory.setItem(1, RealName);
        ItemStack Nick = new ItemStack(Material.AXOLOTL_BUCKET);
        meta = Nick.getItemMeta();
        meta.setDisplayName("§6Ник " + player + "`а");
        meta.setLore(new Lore(Balt.getProfils().getConfig().getString(player + ".Nick", "§4Не указано"), 20).getResult());
        Nick.setItemMeta(meta);
        this.inventory.setItem(3, Nick);
        ItemStack DiscordName = new ItemStack(Material.ENDER_PEARL);
        meta = DiscordName.getItemMeta();
        meta.setDisplayName("§6Ник дискорд " + player + "`а");
        meta.setLore(new Lore(Balt.getProfils().getConfig().getString(player + ".DiscordName", "§4Не указано"), 20).getResult());
        DiscordName.setItemMeta(meta);
        this.inventory.setItem(5, DiscordName);
        ItemStack Age = new ItemStack(Material.ARMOR_STAND);
        meta = Age.getItemMeta();
        meta.setDisplayName("§6Возраст " + player + "`а");
        meta.setLore(new Lore(Balt.getProfils().getConfig().getString(player + ".Age", "§4Не указано"), 20).getResult());
        Age.setItemMeta(meta);
        this.inventory.setItem(7, Age);
        ItemStack Cels = new ItemStack(Material.SMALL_DRIPLEAF);
        meta = Cels.getItemMeta();
        meta.setDisplayName("§6Цели " + player + "`а");
        meta.setLore(new Lore(Balt.getProfils().getConfig().getString(player + ".PlayerCels", "§4Не указано"), 20).getResult());
        Cels.setItemMeta(meta);
        this.inventory.setItem(19, Cels);
        ItemStack About = new ItemStack(Material.BOOK);
        meta = About.getItemMeta();
        meta.setDisplayName("§6О " + player + "`а");
        meta.setLore(new Lore(Balt.getProfils().getConfig().getString(player + ".About", "§4Не указано"), 30).getResult());
        About.setItemMeta(meta);
        this.inventory.setItem(21, About);
        ItemStack Status = new ItemStack(Material.NETHER_STAR);
        meta = Status.getItemMeta();
        meta.setDisplayName("§6Положение на сервере " + player + "`а");
        meta.setLore(new Lore(Balt.getProfils().getConfig().getString(player + ".Status", "§4Не указано"), 20).getResult());
        Status.setItemMeta(meta);
        this.inventory.setItem(23, Status);

        return null;
    }
 */
  //  public void remove(TypeID typeID){

   // }
    /**
     * @param stack - Итемстак.
     * @param slot  - Номер слота, от 0 до 9 * line.
     */
    public void setItemClot(ItemStack stack, int slot) {
        this.inventory.setItem(slot, stack);
    }

    public void remove(TypeID typeID){
        this.inventory.setItem(typeID.getNumberSlot() ,EmptySlot);
    }

    public void remove(int NumberSlot){
        this.inventory.setItem(NumberSlot ,EmptySlot);
    }

    public void remove(TypeID typeID, Material UpdateMaterialStack){
        EmptySlot.setType(UpdateMaterialStack);
        this.inventory.setItem(typeID.getNumberSlot() ,EmptySlot);
    }

    public void remove(int NumberSlot, Material UpdateMaterialStack){
        EmptySlot.setType(UpdateMaterialStack);
        this.inventory.setItem(NumberSlot ,EmptySlot);
    }

    public void remove(TypeID typeID, Material UpdateMaterialStack, String NameStack){
        ItemStack EmptySlot = new ItemStack (UpdateMaterialStack);
        ItemMeta m = EmptySlot.getItemMeta();
        m.setDisplayName(NameStack.replace("&", "§"));
        EmptySlot.setItemMeta(m);
        this.inventory.setItem(typeID.getNumberSlot() ,EmptySlot);
    }

    public void remove(int NumberSlot, Material UpdateMaterialStack, String NameStack){
        ItemStack EmptySlot = new ItemStack (UpdateMaterialStack);
        ItemMeta m = EmptySlot.getItemMeta();
        m.setDisplayName(NameStack.replace("&", "§"));
        EmptySlot.setItemMeta(m);
        this.inventory.setItem(NumberSlot ,EmptySlot);
    }

    public void remove(TypeID typeID, Material UpdateMaterialStack, String NameStack, List<String> Lore){
        EmptySlot.setType(UpdateMaterialStack);
        ItemMeta m = EmptySlot.getItemMeta();
        m.setDisplayName(NameStack.replace("&", "§"));
        List<String> lore = new ArrayList<>();
        for(String s : Lore){
            Lore.remove(s);

            lore.add(s.replace("&", "§"));
        }
        m.setLore(lore);
        EmptySlot.setItemMeta(m);
        this.inventory.setItem(typeID.getNumberSlot() ,EmptySlot);
    }

    public void remove(int NumberSlot, Material UpdateMaterialStack, String NameStack, List<String> Lore){
        ItemStack EmptySlot = new ItemStack (UpdateMaterialStack);
        ItemMeta m = EmptySlot.getItemMeta();
        m.setDisplayName(NameStack.replace("&", "§"));
        List<String> lore = new ArrayList<>();
        for(String s : Lore){
            Lore.remove(s);

            lore.add(s.replace("&", "§"));
        }
        m.setLore(lore);
        EmptySlot.setItemMeta(m);
        this.inventory.setItem(NumberSlot ,EmptySlot);
    }

    /**
     * @return - Возвращает инвентарь.
     */
    @Override
    public Inventory getInventory() {
        return this.inventory;
    }

}