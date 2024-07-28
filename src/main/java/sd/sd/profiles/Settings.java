package sd.sd.profiles;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import sd.sd.SD;
import sd.sd.metods.ChangeName;
import sd.sd.metods.Lore;

import java.util.ArrayList;
import java.util.List;

public class Settings implements InventoryHolder {
    private Inventory inventory;
    private ItemStack EmptySlot;
    private int NumberSlots;

    public Settings(Player player, Material EmptySlot) {
        this.NumberSlots = 9 * 5;
        this.inventory = Bukkit.createInventory(this, NumberSlots, "§6Настройки Вашего профиля");
        for (int i = 0; i < NumberSlots; i++) {
            ItemStack itemStack = new ItemStack(EmptySlot);
            ItemMeta m = itemStack.getItemMeta();
            m.setDisplayName(" ");
            itemStack.setItemMeta(m);
            this.inventory.setItem(i, itemStack);
            this.EmptySlot = itemStack;
        }
        ItemMeta m;
        List<String> lore;

        ItemStack StatusProfile = new ItemStack(Material.NETHERITE_SCRAP);
        m = StatusProfile.getItemMeta();
        String status = SD.getProfils().getConfig().getString(player.getName() + ".ProfilStatus", "close").replace("close", "§cзакрыт").replace("open", "§2открыт");
        m.setDisplayName("§6Статус вашего профиля: " + status);

        lore = new ArrayList<>();
        lore.add("§7Для смены статуса клик на предмет");
        m.setLore(lore);

        StatusProfile.setItemMeta(m);

        this.inventory.setItem(1, StatusProfile);

        List<String> LoreAdd = new ArrayList<>();

        LoreAdd.add("§7Для настройки клик на предмет");

        ItemStack RealName = new ItemStack(Material.PLAYER_HEAD);
        m = RealName.getItemMeta();
        m.setDisplayName("§6Ваше реальное имя");
        m.setLocalizedName("ProfileData_RealName");
        m.setLore(new Lore(SD.getProfils().getConfig().getString(player.getName() + ".RealName", "§4Не указано"), 20, LoreAdd).getResult());
        RealName.setItemMeta(m);
        if(SD.getInstance().getConfig().getBoolean("Profil." + "RealName", false))
            this.inventory.setItem(10, RealName);
        ItemStack Nick = new ItemStack(Material.AXOLOTL_BUCKET);
        m = Nick.getItemMeta();
        m.setDisplayName("§6Ваш ник");
        m.setLocalizedName("ProfileData_Nick");
        m.setLore(new Lore(SD.getProfils().getConfig().getString(player.getName() + ".Nick", "§4Не указано"), 20, LoreAdd).getResult());
        Nick.setItemMeta(m);
        if(SD.getInstance().getConfig().getBoolean("Profil." + "Nick", false))
            this.inventory.setItem(12, Nick);
        ItemStack DiscordName = new ItemStack(Material.ENDER_PEARL);
        m = DiscordName.getItemMeta();
        m.setDisplayName("§6Ваш ник дискорд");
        m.setLocalizedName("ProfileData_DiscordName");
        m.setLore(new Lore(SD.getProfils().getConfig().getString(player.getName() + ".DiscordName", "§4Не указано"), 20, LoreAdd).getResult());
        DiscordName.setItemMeta(m);
        if(SD.getInstance().getConfig().getBoolean("Profil." + "DiscordName", false))
            this.inventory.setItem(14, DiscordName);
        ItemStack Age = new ItemStack(Material.ARMOR_STAND);
        m = Age.getItemMeta();
        m.setDisplayName("§6Ваш возраст");
        m.setLocalizedName("ProfileData_Age");
        m.setLore(new Lore(SD.getProfils().getConfig().getString(player.getName() + ".Age", "§4Не указано"), 20, LoreAdd).getResult());
        Age.setItemMeta(m);
        if(SD.getInstance().getConfig().getBoolean("Profil." + "Age", false))
            this.inventory.setItem(16, Age);
        ItemStack Cels = new ItemStack(Material.SMALL_DRIPLEAF);
        m = Cels.getItemMeta();
        m.setDisplayName("§6Ваши цели");
        m.setLocalizedName("ProfileData_PlayerCels");
        m.setLore(new Lore(SD.getProfils().getConfig().getString(player.getName() + ".PlayerCels", "§4Не указано"), 20, LoreAdd).getResult());
        Cels.setItemMeta(m);
        if(SD.getInstance().getConfig().getBoolean("Profil." + "Cels", false))
            this.inventory.setItem(28, Cels);
        ItemStack About = new ItemStack(Material.BOOK);
        m = About.getItemMeta();
        m.setDisplayName("§6О вас");
        m.setLocalizedName("ProfileData_About");
        m.setLore(new Lore(SD.getProfils().getConfig().getString(player.getName() + ".About", "§4Не указано"), 30, LoreAdd).getResult());
        About.setItemMeta(m);
        if(SD.getInstance().getConfig().getBoolean("Profil." + "About", false))
            this.inventory.setItem(30, About);
        ItemStack LorePlayer = new ItemStack(Material.PAPER);
        m = LorePlayer.getItemMeta();
        m.setDisplayName("§6Лор вашего персонажа");
        m.setLore(new Lore(SD.getProfils().getConfig().getString(player.getName() + ".LorePlayer", "§4Не указано"), 40).getResult());
        LorePlayer.setItemMeta(m);
        if(SD.getInstance().getConfig().getBoolean("Profil." + "LorePlayer", false))
            this.inventory.setItem(32, LorePlayer);
        ItemStack Status = new ItemStack(Material.NETHER_STAR);
        m = Status.getItemMeta();
        m.setDisplayName("§6Ваше положение на сервере");
        m.setLore(new Lore(SD.getProfils().getConfig().getString(player.getName() + ".Status", "§4Не указано"), 20).getResult());
        Status.setItemMeta(m);
    }

    public Settings(Player player, Material EmptySlot, String TypeSet, ChangeName label) {
        this.NumberSlots = 9 * 3;
        this.inventory = Bukkit.createInventory(this, NumberSlots, "§6Настройки §5" + label.getMy());
        for (int i = 0; i < NumberSlots; i++) {
            ItemStack itemStack = new ItemStack(EmptySlot);
            ItemMeta m = itemStack.getItemMeta();
            m.setDisplayName(" ");
            itemStack.setItemMeta(m);
            this.inventory.setItem(i, itemStack);
            this.EmptySlot = itemStack;
        }
        ItemMeta m;
        List<String> lore;

        ItemStack StatusProfile = new ItemStack(label.getIcon());
        m = StatusProfile.getItemMeta();
        String status = SD.getProfils().getConfig().getString(TypeSet, "&4Не указано").replace("&", "§");
        m.setDisplayName("§6Статус " + label.getWhose() + " : ");

        m.setLocalizedName("ProfileData_" + label.getProfileData());

        m.setLore(new Lore(status, 20).getResult());

        StatusProfile.setItemMeta(m);

        this.inventory.setItem(13, StatusProfile);

        ItemStack Edit = new ItemStack(Material.WRITABLE_BOOK);

        m = Edit.getItemMeta();
        m.setDisplayName("§9Изменить " + label.getMy());
        m.setLocalizedName("ProfileData_" + label.getProfileData());
        Edit.setItemMeta(m);

        this.inventory.setItem(11, Edit);

        List<String> LoreAdd = new ArrayList<>();

        LoreAdd.add("§7Для изменения клик на предмет");

    }


    public void setItemClot(ItemStack stack, int slot) {
        this.inventory.setItem(slot, stack);
    }

    @Override
    public Inventory getInventory() {
        return this.inventory;
    }

}
