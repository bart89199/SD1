package sd.sd.shops.ShopGUIInventories;

import com.google.common.collect.Lists;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import sd.sd.shops.Shop;
import sd.sd.shops.ShopGUI;
import sd.sd.shops.ShopGUIInventory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static sd.sd.shops.ShopGUI.drafts;

public class CertainShop implements ShopGUIInventory {

    Inventory inventory;


    public CertainShop(){}

    public CertainShop(Player p, Shop shop){
        generateInventory(p, shop);
    }

    @Override
    public ShopGUI.ShopGUIFormat getFormat() {
        return ShopGUI.ShopGUIFormat.CERTAIN_SHOP;
    }

    @Override
    public void generateInventory(Player p, Shop shop) {
        inventory = Bukkit.createInventory(this, 45, Component.text("§9Магазин §6" + shop.getName()));


        ItemStack i;
        ItemMeta m;

        i = new ItemStack(Material.WRITABLE_BOOK);
        m = i.getItemMeta();
        m.setDisplayName("§3Имя §7: §6" + shop.getName());
        m.setLore(Lists.newArrayList("§3Для изменения клик"));
        m.setLocalizedName("name");
        i.setItemMeta(m);
        inventory.setItem(10, i);

        i = new ItemStack(Material.REPEATER);
        m = i.getItemMeta();
        m.setDisplayName("§3Начало магазина §7: §6" + shop.getStart().getX() + " " + shop.getStart().getY() + " " + shop.getStart().getZ());
        m.setLore(Lists.newArrayList("§3Для изменения клик"));
        m.setLocalizedName("start");
        i.setItemMeta(m);
        inventory.setItem(12, i);



        i = new ItemStack(Material.COMPARATOR);
        m = i.getItemMeta();
        m.setDisplayName("§3Конец магазина §7: §6" + shop.getEnd().getX() + " " + shop.getEnd().getY() + " " + shop.getEnd().getZ());
        m.setLore(Lists.newArrayList("§3Для изменения клик"));
        m.setLocalizedName("end");
        i.setItemMeta(m);
        inventory.setItem(14, i);

        i = new ItemStack(Material.BARREL);
        m = i.getItemMeta();
        m.setDisplayName("§3Бочка для складывания магазина §7: §6" + shop.getPut().getX() + " " + shop.getPut().getY() + " " + shop.getPut().getZ());
        m.setLore(Lists.newArrayList("§3Для изменения клик"));
        m.setLocalizedName("put");
        i.setItemMeta(m);
        inventory.setItem(16, i);

        i = new ItemStack(Material.BARREL);
        m = i.getItemMeta();

        m.setDisplayName("§3Бочка получения магазина §7: §6" + shop.getGet().getX() + " " + shop.getGet().getY() + " " + shop.getGet().getZ());
        m.setLore(Lists.newArrayList("§3Для изменения клик"));
        m.setLocalizedName("get");
        i.setItemMeta(m);
        inventory.setItem(18, i);

        List<String> lore;

        i = new ItemStack(Material.IRON_INGOT);
        m = i.getItemMeta();
        m.setDisplayName("§3Товары");
        lore = new ArrayList<>();
        lore.add("§3Для изменения клик");
        m.setLore(lore);
        m.setLocalizedName("items");
        i.setItemMeta(m);
        inventory.setItem(20, i);

        i = new ItemStack(Material.ARMOR_STAND);
        m = i.getItemMeta();
        m.setDisplayName("§3Арморстенды");
        lore = new ArrayList<>();
        if(shop.getArmorStands() != null && !(shop.getArmorStands().length == 0)){

            for (UUID uuid : shop.getArmorStands()){

                lore.add("§6" + uuid.toString());

            }

        } else {
            lore.add("§7Пусто");
        }
        lore.add("§3Для изменения клик");
        m.setLore(lore);
        m.setLocalizedName("armorStands");
        i.setItemMeta(m);
        inventory.setItem(22, i);



//                i = new ItemStack(Material.GREEN_BANNER);
//                BannerMeta bm = (BannerMeta) i.getItemMeta();
//                bm.addPattern(new Pattern(DyeColor.ORANGE, PatternType.BRICKS));
//                bm.setDisplayName("§6Сохранить в черновиках");
//                bm.setLocalizedName("saveToMap");
//                i.setItemMeta(bm);
//                inv.setItem(43, i);

        i = new ItemStack(Material.RED_BANNER);
        BannerMeta bm = (BannerMeta) i.getItemMeta();
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.SKULL));
        bm.addItemFlags(ItemFlag.HIDE_ITEM_SPECIFICS);
        bm.setDisplayName("§4Удалить");
        bm.setLocalizedName("delete");
        i.setItemMeta(bm);
        inventory.setItem(36, i);

        i = new ItemStack(Material.GREEN_BANNER);
        bm = (BannerMeta) i.getItemMeta();
        bm.addPattern(new Pattern(DyeColor.PURPLE, PatternType.MOJANG));
        bm.addItemFlags(ItemFlag.HIDE_ITEM_SPECIFICS);
        bm.setDisplayName("§2Сохранить");
        bm.setLocalizedName("save");
        i.setItemMeta(bm);
        inventory.setItem(44, i);

        i = new ItemStack(Material.NETHERITE_INGOT);
        m = i.getItemMeta();
        m.setDisplayName("§7Назад");
        m.setLocalizedName("back");
        i.setItemMeta(m);
        inventory.setItem(0, i);

        for(int a = 0; a < 45; a++){

            if(inventory.getItem(a) == null || inventory.getItem(a).getType().isEmpty()) inventory.setItem(a, new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE));

        }

        drafts.put(p.getName(), new ShopGUI.EditedInShop(inventory, shop));
    }

    @Override
    public @NotNull Inventory getInventory() {
        return inventory;
    }
}
