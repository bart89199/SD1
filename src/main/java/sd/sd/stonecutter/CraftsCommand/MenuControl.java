package sd.sd.stonecutter.CraftsCommand;

import com.google.common.collect.Lists;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import sd.sd.SD;
import sd.sd.stonecutter.Disk;
import sd.sd.stonecutter.GUI;

import java.util.ArrayList;
import java.util.List;

import static sd.sd.SD.stoneCutterCrafts;
import static sd.sd.stonecutter.Disk.DiskIdentify;

public class MenuControl implements Listener {

    @EventHandler
    public void onTimer(InventoryClickEvent e) {


        if(e.getView().getTitle().equalsIgnoreCase("§6Меню управления крафтами")) if(!(e.getInventory().getItem(0) == null)) if(e.getInventory().getItem(0).hasItemMeta()) if(e.getInventory().getItem(0).getItemMeta().hasLocalizedName()) if(e.getInventory().getItem(0).getItemMeta().getLocalizedName().equalsIgnoreCase("1")){
            Player p = (Player) e.getView().getPlayer();
            if(e.getCurrentItem() == null) return;
            e.setCancelled(true);
            if(e.getCurrentItem().getType().equals(Material.POINTED_DRIPSTONE)) if(e.getCurrentItem().hasItemMeta()) if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§6Вниз")){
                List<Integer> slots = Lists.newArrayList(1,2,3,4,5,6,7,10,11,12,13,14,15,16,19,20,21,22,23,24,25,28,29,30,31,32,33,34,37,38,39,40,41,42,43);
                List<ItemStack> itemStacks = new ArrayList<>();
                if(SD.getCrafts().getStringList("Crafts") == null || SD.getCrafts().getStringList("Crafts").isEmpty() || SD.getCrafts().getStringList("Crafts").size() / 7 < 5 || (SD.getCrafts().getStringList("Crafts").size() / 7 <= 5 && SD.getCrafts().getStringList("Crafts").size() == (SD.getCrafts().getStringList("Crafts").size() / 7) * 7))return;
                for(String ln : SD.getCrafts().getStringList("Crafts")){

                    ItemStack[] CraftIngredient = new ItemStack[7];

                    CraftIngredient[6] = DiskIdentify(Integer.valueOf(ln.substring(ln.lastIndexOf("NeedDisk") + 10, ln.lastIndexOf("Result1") - 1))).getItemStack();

                    CraftIngredient[3] = new ItemStack(Material.matchMaterial(ln.substring(ln.lastIndexOf("Result1") + 9, ln.lastIndexOf("Amount1") - 1)), Integer.valueOf(ln.substring(ln.lastIndexOf("Amount1") + 9, ln.lastIndexOf("Result2") - 1)));

                    CraftIngredient[4] = new ItemStack(Material.matchMaterial(ln.substring(ln.lastIndexOf("Result2") + 9, ln.lastIndexOf("Amount2") - 1)), Integer.valueOf(ln.substring(ln.lastIndexOf("Amount2") + 9, ln.lastIndexOf("Result3") - 1)));

                    CraftIngredient[5] = new ItemStack(Material.matchMaterial(ln.substring(ln.lastIndexOf("Result3") + 9, ln.lastIndexOf("Amount3") - 1)), Integer.valueOf(ln.substring(ln.lastIndexOf("Amount3") + 9, ln.lastIndexOf("Need1") - 1)));

                    CraftIngredient[0] = new ItemStack(Material.matchMaterial(ln.substring(ln.lastIndexOf("Need1") + 7, ln.lastIndexOf("NeedA1") - 1)), Integer.valueOf(ln.substring(ln.lastIndexOf("NeedA1") + 8, ln.lastIndexOf("Need2") - 1)));
                    CraftIngredient[1] = new ItemStack(Material.matchMaterial(ln.substring(ln.lastIndexOf("Need2") + 7, ln.lastIndexOf("NeedA2") - 1)), Integer.valueOf(ln.substring(ln.lastIndexOf("NeedA2") + 8, ln.lastIndexOf("Need3") - 1)));
                    CraftIngredient[2] = new ItemStack(Material.matchMaterial(ln.substring(ln.lastIndexOf("Need3") + 7, ln.lastIndexOf("NeedA3") - 1)), Integer.valueOf(ln.substring(ln.lastIndexOf("NeedA3") + 8, ln.length())));

                    itemStacks.add(stoneCutterCrafts.setResultOnItem(CraftIngredient[3], CraftIngredient[4], CraftIngredient[5], CraftIngredient[0], CraftIngredient[1], CraftIngredient[2], Disk.DiskIdentify(CraftIngredient[6])));
                }

                ItemStack it = e.getInventory().getItem(0);
                ItemMeta meta = it.getItemMeta();
                meta.setLocalizedName(String.valueOf((Integer.parseInt(meta.getLocalizedName())) + 1));
                it.setItemMeta(meta);
                e.getInventory().setItem(0, it);

                int numberCount = Integer.parseInt(e.getInventory().getItem(0).getItemMeta().getLocalizedName());

                int x = itemStacks.size() / 7;
                int size = itemStacks.size();

                List<ItemStack[]> gropedRecipes = new ArrayList<>();

                List<ItemStack> itemStacks2 = new ArrayList<>(itemStacks);
                List<ItemStack> itemStacks3 = new ArrayList<>(itemStacks);

                for(int i = 0; i < x; i++) {
                    ItemStack[] groupOfCrafts = new ItemStack[7];
                    for(int c = 0; c < 7; c++) {
                        groupOfCrafts[c] = itemStacks2.get(0);
                        itemStacks2.remove(0);
                    }
                    gropedRecipes.add(groupOfCrafts);

                }
                if(!((size - 7*x) == 0)){
                    ItemStack[] groupOfCrafts = new ItemStack[7];
                    for(int i = 0; i < size - 7*x; i++){
                        groupOfCrafts[i] = itemStacks3.get(0);
                        itemStacks3.remove(0);
                    }
                    gropedRecipes.add(groupOfCrafts);
                }

                if(numberCount+4 == gropedRecipes.size()){
                    it = e.getInventory().getItem(0);
                    meta = it.getItemMeta();
                    meta.setLocalizedName(String.valueOf((Integer.parseInt(meta.getLocalizedName())) - 1));
                    it.setItemMeta(meta);
                    return;
                }

                for(ItemStack itemStack : gropedRecipes.get(numberCount)){
                    e.getInventory().setItem(slots.get(0), itemStack);
                    slots.remove(0);
                }
                for(ItemStack itemStack : gropedRecipes.get(numberCount+1)){
                    e.getInventory().setItem(slots.get(0), itemStack);
                    slots.remove(0);
                }
                for(ItemStack itemStack : gropedRecipes.get(numberCount+2)){
                    e.getInventory().setItem(slots.get(0), itemStack);
                    slots.remove(0);
                }
                for(ItemStack itemStack : gropedRecipes.get(numberCount+3)){
                    e.getInventory().setItem(slots.get(0), itemStack);
                    slots.remove(0);
                }
                for(ItemStack itemStack : gropedRecipes.get(numberCount+4)){
                    e.getInventory().setItem(slots.get(0), itemStack);
                    slots.remove(0);
                }

            }

            if(e.getCurrentItem().getType().equals(Material.CANDLE)) if(e.getCurrentItem().hasItemMeta()) if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§6Вверх")) {
                ItemStack it = e.getInventory().getItem(0);
                ItemMeta meta = it.getItemMeta();
                meta.setLocalizedName(String.valueOf((Integer.parseInt(meta.getLocalizedName())) - 1));
                it.setItemMeta(meta);

                e.getInventory().setItem(0, it);

                int numberCount = Integer.parseInt(e.getInventory().getItem(0).getItemMeta().getLocalizedName());
                if(!(numberCount < 0 || SD.getCrafts().getStringList("Crafts") == null || SD.getCrafts().getStringList("Crafts").isEmpty() || SD.getCrafts().getStringList("Crafts").size() / 7 < 5 || (SD.getCrafts().getStringList("Crafts").size() / 7 <= 5 && SD.getCrafts().getStringList("Crafts").size() == (SD.getCrafts().getStringList("Crafts").size() / 7) * 7))){
                    List<Integer> slots = Lists.newArrayList(1,2,3,4,5,6,7,10,11,12,13,14,15,16,19,20,21,22,23,24,25,28,29,30,31,32,33,34,37,38,39,40,41,42,43);
                    List<ItemStack> itemStacks = new ArrayList<>();
                    for(String ln : SD.getCrafts().getStringList("Crafts")){

                        ItemStack[] CraftIngredient = new ItemStack[7];

                        CraftIngredient[6] = DiskIdentify(Integer.valueOf(ln.substring(ln.lastIndexOf("Disk") + 10, ln.lastIndexOf("Result1") - 1))).getItemStack();

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

                    for(int i = 0; i < x; i++) {
                        ItemStack[] groupOfCrafts = new ItemStack[7];
                        for(int c = 0; c < 7; c++) {
                            groupOfCrafts[c] = itemStacks2.get(0);
                            itemStacks2.remove(0);
                        }
                        gropedRecipes.add(groupOfCrafts);

                    }
                    if(!((size - 7*x) == 0)){
                        ItemStack[] groupOfCrafts = new ItemStack[7];
                        for(int i = 0; i < size - 7*x; i++){
                            groupOfCrafts[i] = itemStacks3.get(0);
                            itemStacks3.remove(0);
                        }
                        gropedRecipes.add(groupOfCrafts);
                    }

                    for(ItemStack itemStack : gropedRecipes.get(numberCount)){
                        e.getInventory().setItem(slots.get(0), itemStack);
                        slots.remove(0);
                    }
                    for(ItemStack itemStack : gropedRecipes.get(numberCount+1)){
                        e.getInventory().setItem(slots.get(0), itemStack);
                        slots.remove(0);
                    }
                    for(ItemStack itemStack : gropedRecipes.get(numberCount+2)){
                        e.getInventory().setItem(slots.get(0), itemStack);
                        slots.remove(0);
                    }
                    for(ItemStack itemStack : gropedRecipes.get(numberCount+3)){
                        e.getInventory().setItem(slots.get(0), itemStack);
                        slots.remove(0);
                    }
                    for(ItemStack itemStack : gropedRecipes.get(numberCount+4)){
                        e.getInventory().setItem(slots.get(0), itemStack);
                        slots.remove(0);
                    }
                }else{
                    it = e.getInventory().getItem(0);
                    meta = it.getItemMeta();
                    meta.setLocalizedName(String.valueOf((Integer.parseInt(meta.getLocalizedName())) + 1));
                    it.setItemMeta(meta);
                    e.getInventory().setItem(0, it);
                }
            }
            if(e.getCurrentItem().hasItemMeta()) if(e.getCurrentItem().getItemMeta().hasLocalizedName()) if(e.getCurrentItem().getItemMeta().getLocalizedName().contains("Type:RecipeWithDisk")){
                p.openInventory(GUI.EditRecipe(e.getCurrentItem()));
            }
        }

        if(e.getView().getTitle().equalsIgnoreCase("§3Меню редактирования крафта")) if(!(e.getInventory().getItem(1) == null)) if(e.getInventory().getItem(1).hasItemMeta()) if(e.getInventory().getItem(1).getItemMeta().hasLocalizedName()) if(e.getInventory().getItem(1).getItemMeta().getLocalizedName().equalsIgnoreCase("1")) {
            if(e.getCurrentItem() == null) return;
            if(!e.getCurrentItem().hasItemMeta()) return;
            if(!e.getCurrentItem().getItemMeta().hasLocalizedName()) return; else{
                String localizedName = e.getCurrentItem().getItemMeta().getLocalizedName();
                if(localizedName.equalsIgnoreCase("1") || localizedName.equalsIgnoreCase("NoTouch")) {
                    e.setCancelled(true);
                    return;
                }
                if(localizedName.equalsIgnoreCase("back")){
                    e.setCancelled(true);
                    e.getView().getPlayer().openInventory(GUI.EditCrafts());
                    return;
                }
                if(localizedName.equalsIgnoreCase("createnew")){
                    e.setCancelled(true);
                    List<String> list = SD.getCrafts().getConfig().getStringList("Crafts");
                    ItemStack[] RecipeIng = new ItemStack[6];
                    RecipeIng[0] = e.getInventory().getItem(28);
                    RecipeIng[1] = e.getInventory().getItem(29);
                    RecipeIng[2] = e.getInventory().getItem(30);
                    RecipeIng[3] = e.getInventory().getItem(32);
                    RecipeIng[4] = e.getInventory().getItem(33);
                    RecipeIng[5] = e.getInventory().getItem(34);
                    String[] MaterialType = new String[6];
                    int[] Amount = new int[6];
                    for(int i=0;i<6;i++){
                        if(RecipeIng[i] == null){
                            MaterialType[i] = "AIR";
                            Amount[i] = 1;
                        }else{
                            MaterialType[i] = String.valueOf(RecipeIng[i].getType());
                            Amount[i] = RecipeIng[i].getAmount();
                        }
                    }

                    list.add("Disk: " + DiskIdentify(e.getInventory().getItem(31)).getNumber() + " Result1: " + MaterialType[0] + " Amount1: " + Amount[0] + " Result2: " + MaterialType[1] + " Amount2: " + Amount[1] + " Result3: " + MaterialType[2] + " Amount3: " + Amount[2] + " Need1: " + MaterialType[3] + " NeedA1: " + Amount[3] + " Need2: " + MaterialType[4] + " NeedA2: " + Amount[4] + " Need3: " + MaterialType[5] + " NeedA3: " + Amount[5]);
                    SD.getCrafts().getConfig().set("Crafts", list);
                    SD.getCrafts().save();
                    e.getView().getPlayer().openInventory(GUI.EditRecipe(stoneCutterCrafts.setResultOnItem(e.getInventory().getItem(28), e.getInventory().getItem(29), e.getInventory().getItem(30), e.getInventory().getItem(32), e.getInventory().getItem(33), e.getInventory().getItem(34), DiskIdentify(e.getInventory().getItem(31)))));
                    return;
                }
                if(localizedName.contains("Delete")) {
                    localizedName = localizedName.substring(localizedName.indexOf("Delete") + 8, localizedName.length());
                    e.setCancelled(true);
                    List<String> list = SD.getCrafts().getConfig().getStringList("Crafts");
                   if(SD.getCrafts().getConfig().getStringList("Crafts").contains(localizedName)){
                       list.remove(localizedName);
                       SD.getCrafts().getConfig().set("Crafts", list);
                       SD.getCrafts().save();
                       Bukkit.getConsoleSender().sendMessage("Крафт удалён");
                   } else{
                       Bukkit.getConsoleSender().sendMessage("Крафт не найден");
                   }
                }
            }
        }

        }



}
