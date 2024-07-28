package sd.sd.stonecutter;

import com.google.common.collect.Lists;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import sd.sd.SD;
import sd.sd.metods.Menu;

import java.util.ArrayList;
import java.util.List;

import static sd.sd.SD.stoneCutterCrafts;
import static sd.sd.stonecutter.Disk.DiskIdentify;

public class GUI {

    public static Inventory EditCrafts(){
        Inventory menu = new Menu(5, "§6Меню управления крафтами").getInventory();
        for (int i = 0; i < 45; i++) {
            ItemStack v = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemMeta m = v.getItemMeta();
            m.setDisplayName(" ");
            v.setItemMeta(m);
            menu.setItem(i, v);
        }
        ItemStack v = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta m = v.getItemMeta();
        m.setDisplayName(" ");
        m.setLocalizedName("1");
        v.setItemMeta(m);
        menu.setItem(0, v);

        v = new ItemStack(Material.POINTED_DRIPSTONE);
        m = v.getItemMeta();
        m.setDisplayName("§6Вниз");
        v.setItemMeta(m);
        menu.setItem(35, v);

        v = new ItemStack(Material.CANDLE);
        m = v.getItemMeta();
        m.setDisplayName("§6Вверх");
        v.setItemMeta(m);
        menu.setItem(17, v);

        if(SD.getCrafts().getStringList("Crafts") == null || SD.getCrafts().getStringList("Crafts").isEmpty()){
            return menu;
        }

        List<Integer> slots = Lists.newArrayList(1,2,3,4,5,6,7,10,11,12,13,14,15,16,19,20,21,22,23,24,25,28,29,30,31,32,33,34,37,38,39,40,41,42,43);
        List<ItemStack> itemStacks = new ArrayList<>();
        for(String ln : SD.getCrafts().getStringList("Crafts")){

            ItemStack[] CraftIngredient = new ItemStack[7];

            CraftIngredient[6] = DiskIdentify(Integer.valueOf(ln.substring(ln.lastIndexOf("Disk") + 6, ln.lastIndexOf("Result1") - 1))).getItemStack();

            CraftIngredient[3] = new ItemStack(Material.matchMaterial(ln.substring(ln.lastIndexOf("Result1") + 9, ln.lastIndexOf("Amount1") - 1)), Integer.valueOf(ln.substring(ln.lastIndexOf("Amount1") + 9, ln.lastIndexOf("Result2") - 1)));

            CraftIngredient[4] = new ItemStack(Material.matchMaterial(ln.substring(ln.lastIndexOf("Result2") + 9, ln.lastIndexOf("Amount2") - 1)), Integer.valueOf(ln.substring(ln.lastIndexOf("Amount2") + 9, ln.lastIndexOf("Result3") - 1)));

            CraftIngredient[5] = new ItemStack(Material.matchMaterial(ln.substring(ln.lastIndexOf("Result3") + 9, ln.lastIndexOf("Amount3") - 1)), Integer.valueOf(ln.substring(ln.lastIndexOf("Amount3") + 9, ln.lastIndexOf("Need1") - 1)));

            CraftIngredient[0] = new ItemStack(Material.matchMaterial(ln.substring(ln.lastIndexOf("Need1") + 7, ln.lastIndexOf("NeedA1") - 1)), Integer.valueOf(ln.substring(ln.lastIndexOf("NeedA1") + 8, ln.lastIndexOf("Need2") - 1)));
            CraftIngredient[1] = new ItemStack(Material.matchMaterial(ln.substring(ln.lastIndexOf("Need2") + 7, ln.lastIndexOf("NeedA2") - 1)), Integer.valueOf(ln.substring(ln.lastIndexOf("NeedA2") + 8, ln.lastIndexOf("Need3") - 1)));
            CraftIngredient[2] = new ItemStack(Material.matchMaterial(ln.substring(ln.lastIndexOf("Need3") + 7, ln.lastIndexOf("NeedA3") - 1)), Integer.valueOf(ln.substring(ln.lastIndexOf("NeedA3") + 8, ln.length())));

            itemStacks.add(stoneCutterCrafts.setResultOnItem(CraftIngredient[3], CraftIngredient[4], CraftIngredient[5], CraftIngredient[0], CraftIngredient[1], CraftIngredient[2], Disk.DiskIdentify(CraftIngredient[6])));
        }



        int x = itemStacks.size() / 7;
        int size = itemStacks.size();

        List<ItemStack[]> gropedRecipes = new ArrayList<>();

        List<ItemStack> itemStacks2 = new ArrayList<>(itemStacks);
        List<ItemStack> itemStacks3 = new ArrayList<>(itemStacks);
        Bukkit.getConsoleSender().sendMessage("4");

        for(int i = 0; i < x; i++) {
            ItemStack[] groupOfCrafts = new ItemStack[7];
            for(int c = 0; c < 7; c++) {
                groupOfCrafts[c] = itemStacks2.get(0);
                itemStacks2.remove(0);
            }
            gropedRecipes.add(groupOfCrafts);

        }
        Bukkit.getConsoleSender().sendMessage("5");
        if(!((size - 7*x) == 0)){
            ItemStack[] groupOfCrafts = new ItemStack[7];
            for(int i = 0; i < size - 7*x; i++){
                groupOfCrafts[i] = itemStacks3.get(0);
                itemStacks3.remove(0);
            }
            gropedRecipes.add(groupOfCrafts);
        }
        Bukkit.getConsoleSender().sendMessage("6");

        v = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        m = v.getItemMeta();
        m.setDisplayName(" ");
        v.setItemMeta(m);

        if(gropedRecipes.size() >= 5) {
            for (ItemStack itemStack : gropedRecipes.get(0)) {
                menu.setItem(slots.get(0), itemStack);
                slots.remove(0);
            }
            for (ItemStack itemStack : gropedRecipes.get(1)) {
                menu.setItem(slots.get(0), itemStack);
                slots.remove(0);
            }
            for (ItemStack itemStack : gropedRecipes.get(2)) {
                menu.setItem(slots.get(0), itemStack);
                slots.remove(0);
            }
            for (ItemStack itemStack : gropedRecipes.get(3)) {
                menu.setItem(slots.get(0), itemStack);
                slots.remove(0);
            }
            for (ItemStack itemStack : gropedRecipes.get(4)) {
                if(itemStack == null) itemStack = v;
                menu.setItem(slots.get(0), itemStack);
                slots.remove(0);
            }
        }else{
            for(ItemStack[] gropedRecipe : gropedRecipes){
                for(ItemStack recipe : gropedRecipe){
                    if(recipe == null) recipe = v;
                    menu.setItem(slots.get(0), recipe);
                    slots.remove(0);
                }
            }
        }
        return menu;
    }

    public static Inventory EditRecipe(ItemStack item){
        Inventory menu = new Menu(5, "§3Меню редактирования крафта").getInventory();

        for (int i = 0; i < 45; i++) {
            ItemStack v = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemMeta m = v.getItemMeta();
            m.setDisplayName(" ");
            m.setLocalizedName("1");
            v.setItemMeta(m);
            menu.setItem(i, v);
        }
        ItemStack i = new ItemStack(Material.BARRIER);
        ItemMeta m = i.getItemMeta();
        m.setDisplayName("§4Удалить предмет");
        m.setLocalizedName("Delete: " + item.getItemMeta().getLocalizedName().substring(item.getItemMeta().getLocalizedName().indexOf(",") + 1, item.getItemMeta().getLocalizedName().length()));
        Bukkit.getConsoleSender().sendMessage(item.getItemMeta().getLocalizedName().substring(item.getItemMeta().getLocalizedName().indexOf(",") + 1, item.getItemMeta().getLocalizedName().length()));
        i.setItemMeta(m);
        menu.setItem(36, i);

        i = new ItemStack(Material.GREEN_BANNER);
        m = i.getItemMeta();
        m.setDisplayName("§aСохранить§7(§8без тегов§7)");
        m.setLocalizedName("save, Old:" + item.getItemMeta().getLocalizedName().substring(item.getItemMeta().getLocalizedName().indexOf(",") + 1, item.getItemMeta().getLocalizedName().length()));
        i.setItemMeta(m);
        menu.setItem(44, i);

        i = new ItemStack(Material.LIME_BANNER);
        m = i.getItemMeta();
        m.setDisplayName("§aСоздать новый крафт");
        m.setLocalizedName("createnew");
        i.setItemMeta(m);
        menu.setItem(43, i);

        i = new ItemStack(Material.ARROW);
        m = i.getItemMeta();
        m.setDisplayName("§7Назад");
        m.setLocalizedName("back");
        i.setItemMeta(m);
        menu.setItem(40, i);

        ItemStack[] ingredients = stoneCutterCrafts.getResultOnItem(item);

        for(ItemStack it : ingredients){
            if(it == null) it = new ItemStack(Material.AIR);
        }

        if(!ingredients[0].getType().equals(Material.STRUCTURE_VOID)){
            menu.setItem(28, ingredients[0]);
        }else{
            menu.setItem(28, null);
        }
        if(!ingredients[1].getType().equals(Material.STRUCTURE_VOID)){
            menu.setItem(29, ingredients[1]);
        }else{
            menu.setItem(29, null);
        }
        if(!ingredients[2].getType().equals(Material.STRUCTURE_VOID)){
            menu.setItem(30, ingredients[2]);
        }else{
            menu.setItem(30, null);
        }
        menu.setItem(31, ingredients[6]);
        menu.setItem(32, ingredients[3]);
        menu.setItem(33, ingredients[4]);
        menu.setItem(34, ingredients[5]);

        for(ItemStack it : ingredients){
            if(it.getType().isEmpty()){
                it.setType(Material.STRUCTURE_VOID);
            }
            m = it.getItemMeta();
            m.setLocalizedName("NoTouch");
            it.setItemMeta(m);
        }

        menu.setItem(10, ingredients[0]);
        menu.setItem(11, ingredients[1]);
        menu.setItem(12, ingredients[2]);
        menu.setItem(13, ingredients[6]);
        menu.setItem(14, ingredients[3]);
        menu.setItem(15, ingredients[4]);
        menu.setItem(16, ingredients[5]);

        return menu;
    }

}
