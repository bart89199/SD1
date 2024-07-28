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

import static sd.sd.SD.listOfShops;
import static sd.sd.shops.ShopGUI.drafts;

public class MainMenu implements ShopGUIInventory {

    Inventory inventory;

    public MainMenu(){}

    public MainMenu(Player p){
        generateInventory(p);
    }

    public void generateInventory(Player p) {


        inventory = Bukkit.createInventory(this, 54, Component.text("§9Главное меню магазинов"));


        ItemStack i;
        ItemMeta m;

        if (listOfShops != null && !listOfShops.isEmpty()) {

            int line = 0;
            int slot = 0;
            int number = 0;

            ArrayList<ItemStack[]> listOfShopsInItems = new ArrayList<>();





            for (int b=0; b < listOfShops.size(); b++) {

                Shop[] shops = listOfShops.get(b);

                listOfShopsInItems.add(b, new ItemStack[shops.length]);

                for(int i1=0; i1 < shops.length; i1++) {

                    Shop sh = shops[i1];

                    if (sh == null) continue;

                    i = new ItemStack(Material.CHEST);
                    m = i.getItemMeta();

                    m.setDisplayName("§9" + sh.getName());
                    m.setLore(Lists.newArrayList("§3Для выбора клик"));
                    m.setLocalizedName(String.valueOf(b));
                    i.setItemMeta(m);

                    listOfShopsInItems.get(b)[i1] = i;

                }

            }



            slot = 0;

            for (int a = 0; a < listOfShopsInItems.size(); a++) {

                ItemStack[] items = listOfShopsInItems.get(a);

                if (a < 4) {

                    for (int s = 0; s < items.length; s++) {

                        inventory.setItem((10 + slot++ + a*2), items[s]);

                    }

                } else {

                    i = new ItemStack(Material.CANDLE);
                    m = i.getItemMeta();
                    m.setDisplayName("§6Вверх");
                    m.setLocalizedName("up");
                    i.setItemMeta(m);

                    inventory.setItem(6, i);
                    break;

                }

            }

        }

        i = new ItemStack(Material.GREEN_BANNER);
        BannerMeta bm = (BannerMeta) i.getItemMeta();
        bm.addPattern(new Pattern(DyeColor.LIGHT_BLUE, PatternType.HALF_HORIZONTAL));
        bm.addPattern(new Pattern(DyeColor.ORANGE, PatternType.SKULL));
        bm.addItemFlags(ItemFlag.HIDE_ITEM_SPECIFICS);
        bm.setDisplayName("§6Продолжить редактировать");
        bm.setLocalizedName("continue");
        i.setItemMeta(bm);
        if(drafts.containsKey(p.getName()))
            inventory.setItem(52, i);

        i = new ItemStack(Material.GREEN_BANNER);
        bm = (BannerMeta) i.getItemMeta();
        bm.addPattern(new Pattern(DyeColor.LIGHT_BLUE, PatternType.PIGLIN));
        bm.addItemFlags(ItemFlag.HIDE_ITEM_SPECIFICS);
        bm.setDisplayName("§2Создать магазин");
        bm.setLocalizedName("create");
        i.setItemMeta(bm);
        inventory.setItem(53, i);

        for(int a = 0; a < 54; a++){

            if(inventory.getItem(a) == null || inventory.getItem(a).getType().isEmpty()) inventory.setItem(a, new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE));

        }
    }

    @Override
    public ShopGUI.ShopGUIFormat getFormat() {
        return ShopGUI.ShopGUIFormat.MAIN_MENU;
    }

    @Deprecated
    @Override
    public void generateInventory(Player p, Shop shop) {
        generateInventory(p);
    }

    @Override
    public @NotNull Inventory getInventory() {
        return inventory;
    }
}
