package sd.sd.stonecutter;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import sd.sd.SD;
import sd.sd.metods.Lore;

import java.util.ArrayList;
import java.util.List;

import static sd.sd.SD.ListOfRecipesSlots;
import static sd.sd.SD.stoneCutterCrafts;
import static sd.sd.stonecutter.Disk.DiskIdentify;
import static sd.sd.stonecutter.StoneCutterCrafts.recipes;

public class Update implements Listener, InventoryHolder {


    private Inventory guyed;

    @EventHandler
    public void onTimer(InventoryClickEvent e) {
        if(e.getView().getTitle().equalsIgnoreCase("Камнерез") && (!(e.getInventory().getItem(5) == null))) if(e.getInventory().getItem(5).hasItemMeta()) if(e.getInventory().getItem(5).getItemMeta().getLocalizedName().equalsIgnoreCase("StoneCutter")){

            Player p = ((Player) e.getView().getPlayer()).getPlayer();

            Inventory i = e.getInventory();

            List<ItemStack> OldResult = new ArrayList<>(); OldResult.add(e.getInventory().getItem(16)); OldResult.add(e.getInventory().getItem(25)); OldResult.add(e.getInventory().getItem(34));
            boolean ActualResult = false;

            recipes.clear();
            if(Disk.Error.equal(i.getItem(14))){
                if(!(i.getItem(14) == null)) {
                    e.getView().getPlayer().getWorld().dropItem(e.getView().getPlayer().getLocation(), i.getItem(14));
                    e.getInventory().setItem(14, new ItemStack(Material.AIR));
                }
                ItemStack v = new ItemStack(Material.BARRIER);
                ItemMeta m = v.getItemMeta();
                m.setDisplayName("§4Требуется диск!");
                v.setItemMeta(m);
                e.getInventory().setItem(16, v);
                e.getInventory().setItem(25, v);
                e.getInventory().setItem(34, v);
                v = new ItemStack(Material.BARRIER);
                m = v.getItemMeta();
                m.setDisplayName("§4Нет вариантов обработки");
                v.setItemMeta(m);
                for(Integer n : ListOfRecipesSlots){
                    e.getInventory().setItem(n, v);
                }
            }else{
                if((i.getItem(10) == null) && (i.getItem(11) == null) && (i.getItem(12) == null)){
                    ItemStack v = new ItemStack(Material.BARRIER);
                    ItemMeta m = v.getItemMeta();
                    m.setDisplayName("§4Нечего обрабатывать");
                    v.setItemMeta(m);
                    e.getInventory().setItem(16, v);
                    e.getInventory().setItem(25, v);
                    e.getInventory().setItem(34, v);
                    v = new ItemStack(Material.BARRIER);
                    m = v.getItemMeta();
                    m.setDisplayName("§4Нет вариантов обработки");
                    v.setItemMeta(m);
                    for(Integer n : ListOfRecipesSlots){
                        e.getInventory().setItem(n, v);
                    }
                }else{
                    stoneCutterCrafts.setInventory(e.getInventory());

                    ItemStack v = new ItemStack(Material.STRUCTURE_VOID);
                    ItemMeta m = v.getItemMeta();
                    m.setDisplayName("§7");
                    v.setItemMeta(m);
                    ItemStack air = new ItemStack(Material.AIR);


                    ItemStack[] item = stoneCutterCrafts.getResultOnItem(e.getCurrentItem());


                    if(item.length == 6){
                        e.setCancelled(true);
                    }else{
                        if(item.length == 7){
                            e.setCancelled(true);
                            if(p.isSneaking()){
                                p.sendMessage("1");
                                ItemStack[] remainder = stoneCutterCrafts.checkCraftRemainderMax(item[3], item[4], item[5], p);

                                if(remainder.length == 4) {

                                    if (!item[0].getType().equals(Material.STRUCTURE_VOID)){
                                        item[0].setAmount(item[0].getAmount() * remainder[3].getAmount());
                                        item[0].setItemMeta(null);
                                        p.getWorld().dropItem(p.getLocation(), item[0]);
                                    }
                                    if (!item[1].getType().equals(Material.STRUCTURE_VOID)){
                                        item[1].setItemMeta(null);
                                        item[1].setAmount(item[1].getAmount() * remainder[3].getAmount());
                                        p.getWorld().dropItem(p.getLocation(), item[1]);
                                    }
                                    if (!item[2].getType().equals(Material.STRUCTURE_VOID)){
                                        item[2].setItemMeta(null);
                                        item[2].setAmount(item[2].getAmount() * remainder[3].getAmount());
                                        p.getWorld().dropItem(p.getLocation(), item[2]);
                                    }

                                    e.getInventory().setItem(10, remainder[0]);
                                    e.getInventory().setItem(11, remainder[1]);
                                    e.getInventory().setItem(12, remainder[2]);

                                    m = e.getInventory().getItem(14).getItemMeta();

                                    ((Damageable) m).setDamage(((Damageable) m).getDamage() + (DiskIdentify(e.getInventory().getItem(14)).getDecrease() * remainder[3].getAmount()));

                                    if(((Damageable) m).getDamage() >= e.getInventory().getItem(14).getType().getMaxDurability()){
                                        e.getInventory().setItem(14, null);
                                    }else{
                                        e.getInventory().getItem(14).setItemMeta(m);
                                    }

                                }
                            }else{
                                ItemStack[] remainder = stoneCutterCrafts.checkCraftRemainder(item[3], item[4], item[5]);

                                if(remainder.length == 3) {

                                    if (!item[0].getType().equals(Material.STRUCTURE_VOID)) {
                                        item[0].setItemMeta(null);
                                        p.getWorld().dropItem(p.getLocation(), item[0]);
                                    }
                                    if (!item[1].getType().equals(Material.STRUCTURE_VOID)) {
                                        item[1].setItemMeta(null);
                                        p.getWorld().dropItem(p.getLocation(), item[1]);
                                    }
                                    if (!item[2].getType().equals(Material.STRUCTURE_VOID)) {
                                        item[2].setItemMeta(null);
                                        p.getWorld().dropItem(p.getLocation(), item[2]);
                                    }
                                    m = e.getInventory().getItem(14).getItemMeta();

                                    ((Damageable) m).setDamage(((Damageable) m).getDamage() + (DiskIdentify(e.getInventory().getItem(14)).getDecrease()));

                                    if(((Damageable) m).getDamage() >= e.getInventory().getItem(14).getType().getMaxDurability()){
                                        e.getInventory().setItem(14, null);
                                    }else{
                                        e.getInventory().getItem(14).setItemMeta(m);
                                    }

                                    e.getInventory().setItem(10, remainder[0]);
                                    e.getInventory().setItem(11, remainder[1]);
                                    e.getInventory().setItem(12, remainder[2]);
                                }
                            }
                        }

                    }

                    for(String ln : SD.getCrafts().getStringList("Crafts")){

                        ItemStack[] CraftIngredient = new ItemStack[7];

                        CraftIngredient[6] = DiskIdentify(Integer.valueOf(ln.substring(ln.lastIndexOf("NeedDisk") + 10, ln.lastIndexOf("Result1") - 1))).getItemStack();

                        CraftIngredient[3] = new ItemStack(Material.matchMaterial(ln.substring(ln.lastIndexOf("Result1") + 9, ln.lastIndexOf("Amount1") - 1)), Integer.valueOf(ln.substring(ln.lastIndexOf("Amount1") + 9, ln.lastIndexOf("Result2") - 1)));

                        CraftIngredient[4] = new ItemStack(Material.matchMaterial(ln.substring(ln.lastIndexOf("Result2") + 9, ln.lastIndexOf("Amount2") - 1)), Integer.valueOf(ln.substring(ln.lastIndexOf("Amount2") + 9, ln.lastIndexOf("Result3") - 1)));

                        CraftIngredient[5] = new ItemStack(Material.matchMaterial(ln.substring(ln.lastIndexOf("Result3") + 9, ln.lastIndexOf("Amount3") - 1)), Integer.valueOf(ln.substring(ln.lastIndexOf("Amount3") + 9, ln.lastIndexOf("Need1") - 1)));

                        CraftIngredient[0] = new ItemStack(Material.matchMaterial(ln.substring(ln.lastIndexOf("Need1") + 7, ln.lastIndexOf("NeedA1") - 1)), Integer.valueOf(ln.substring(ln.lastIndexOf("NeedA1") + 8, ln.lastIndexOf("Need2") - 1)));
                        CraftIngredient[1] = new ItemStack(Material.matchMaterial(ln.substring(ln.lastIndexOf("Need2") + 7, ln.lastIndexOf("NeedA2") - 1)), Integer.valueOf(ln.substring(ln.lastIndexOf("NeedA2") + 8, ln.lastIndexOf("Need3") - 1)));
                        CraftIngredient[2] = new ItemStack(Material.matchMaterial(ln.substring(ln.lastIndexOf("Need3") + 7, ln.lastIndexOf("NeedA3") - 1)), Integer.valueOf(ln.substring(ln.lastIndexOf("NeedA3") + 8, ln.length())));

                        stoneCutterCrafts.add(DiskIdentify(CraftIngredient[6]), CraftIngredient[0], CraftIngredient[1], CraftIngredient[2], CraftIngredient[3], CraftIngredient[4], CraftIngredient[5]);

                    }

                    if(!(item.length == 6)) {

                        for (ItemStack it : recipes) {
                            ItemStack[] itemStacks = stoneCutterCrafts.getResultOnItem(it);
                            if (itemStacks.length == 6)
                                if (itemStacks[0].equals(e.getInventory().getItem(16)) && itemStacks[1].equals(e.getInventory().getItem(25)) && itemStacks[2].equals(e.getInventory().getItem(34))) {
                                    if (stoneCutterCrafts.checkCraft(itemStacks[3], itemStacks[4], itemStacks[5]))
                                        ActualResult = true;
                                }
                        }
                        if (!ActualResult) {
                            e.getInventory().setItem(16, item[0]);
                            e.getInventory().setItem(25, item[1]);
                            e.getInventory().setItem(34, item[2]);
                        }
                    }else{
                        e.getInventory().setItem(16, item[0]);
                        e.getInventory().setItem(25, item[1]);
                        e.getInventory().setItem(34, item[2]);
                    }
                }
            }

            ItemStack v = new ItemStack(Material.BARRIER);
            ItemMeta m = v.getItemMeta();
            m.setDisplayName("§4Нет вариантов обработки");
            v.setItemMeta(m);
            for(Integer n : ListOfRecipesSlots){
                e.getInventory().setItem(n, v);
            }

            int c = 0;
            for(ItemStack recipe : recipes){
                e.getInventory().setItem(ListOfRecipesSlots.get(c), recipe);
                c++;
            }

            if(e.getCurrentItem() == null) return;

            //      if(e.getCurrentItem().hasItemMeta()) if(e.getCurrentItem().getItemMeta().hasLocalizedName()) {
            //        e.setCancelled(true);
            //      return;
            //}

            ItemMeta item = e.getCurrentItem().getItemMeta();
             v = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
             m = v.getItemMeta();
            m.setDisplayName(" ");
            v.setItemMeta(m);
            if(item.equals(m)){
                e.setCancelled(true);
                return;
            }

            if(item.getDisplayName().equalsIgnoreCase(" ")){
                e.setCancelled(true);
                return;
            }

            if(e.getCurrentItem().getType().equals(Material.STRUCTURE_VOID)){
                e.setCancelled(true);
                return;
            }

            v = new ItemStack(Material.BARRIER);
            m = v.getItemMeta();
            m.setDisplayName("§4Нет вариантов обработки");
            v.setItemMeta(m);
            if(item.equals(m)){
                e.setCancelled(true);
                return;
            }


            v = new ItemStack(Material.BARRIER);
            m = v.getItemMeta();
            m.setDisplayName("§4Нечего обрабатывать");
            v.setItemMeta(m);
            if(item.equals(m)){
                e.setCancelled(true);
                return;
            }


            v = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            m = v.getItemMeta();
            m.setDisplayName("§6Результат");
            v.setItemMeta(m);
            if(item.equals(m)){
                e.setCancelled(true);
                return;
            }


            v = new ItemStack(Material.BARRIER);
            m = v.getItemMeta();
            m.setDisplayName("§4Требуется диск!");
            v.setItemMeta(m);
            if(item.equals(m)){
                e.setCancelled(true);
                return;
            }


            v = new ItemStack(Material.SEAGRASS);
            m = v.getItemMeta();
            m.setDisplayName("§6Обновить");
            v.setItemMeta(m);
            if(item.equals(m)){
                e.setCancelled(true);
                return;
            }


            ItemStack guyed = new ItemStack(Material.WRITABLE_BOOK);
            m = guyed.getItemMeta();
            m.setDisplayName("§6Гайд");
            List<String> lore = new ArrayList<>();
            lore.add("§7Как работает этот камнерез?");
            lore.add("§7Какие рецепты есть теперь?");
            m.setLore(lore);
            m.setLocalizedName("StoneCutter");
            guyed.setItemMeta(m);
            if(item.equals(m)){
                p.openInventory(Guyed());
                e.setCancelled(true);
                return;
            }


        }
        if(e.getView().getTitle().equalsIgnoreCase("Камнерез гайд")) {
            if (e.getCurrentItem() == null) return;
            ItemMeta item = e.getCurrentItem().getItemMeta();
            ItemStack v = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemMeta m = v.getItemMeta();
            m.setDisplayName(" ");
            v.setItemMeta(m);
            if (item.equals(m)) {
                e.setCancelled(true);
                return;
            }


            ItemStack i = new ItemStack(Material.WRITTEN_BOOK);
            m = i.getItemMeta();
            m.setDisplayName("§6Новый камнерез!");
            List<String> l = new ArrayList<>();
            m.setLore(new Lore("§7Новый камнерез представляет собой \"Верстак\", в нём есть 3 слота для предметов, туда можно поместить например камень и внизу появятся варианты обработки, выбрав один из них в правом слоте(-ах) появится результат", 35).getResult());
            i.setItemMeta(m);
            if (item.equals(m)) {
                e.setCancelled(true);
                return;
            }
        }

    }

    @EventHandler
    public void onTimer(InventoryCloseEvent e) {
        if(e.getView().getTitle().equalsIgnoreCase("Камнерез") && (!(e.getInventory().getItem(5) == null))) if(e.getInventory().getItem(5).hasItemMeta()) if(e.getInventory().getItem(5).getItemMeta().getLocalizedName().equalsIgnoreCase("StoneCutter")){
            Inventory i = e.getInventory();
            if(!(i.getItem(10) == null)) {
                e.getView().getPlayer().getWorld().dropItem(e.getView().getPlayer().getLocation(), i.getItem(10));
                e.getInventory().setItem(10, new ItemStack(Material.AIR));
            }
            if(!(i.getItem(11) == null)) {
                e.getView().getPlayer().getWorld().dropItem(e.getView().getPlayer().getLocation(), i.getItem(11));
                e.getInventory().setItem(11, new ItemStack(Material.AIR));
            }
            if(!(i.getItem(12) == null)) {
                e.getView().getPlayer().getWorld().dropItem(e.getView().getPlayer().getLocation(), i.getItem(12));
                e.getInventory().setItem(12, new ItemStack(Material.AIR));
            }
            if(!(i.getItem(14) == null)) {
                e.getView().getPlayer().getWorld().dropItem(e.getView().getPlayer().getLocation(), i.getItem(14));
                e.getInventory().setItem(14, new ItemStack(Material.AIR));
            }
        }
    }



    public Inventory Guyed(){
        guyed = Bukkit.createInventory( this, 9*5, "Камнерез гайд");
        for (int i = 0; i < 45; i++) {
            ItemStack v = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemMeta m = v.getItemMeta();
            m.setDisplayName(" ");
            v.setItemMeta(m);
            guyed.setItem(i, v);
        }

        ItemStack i = new ItemStack(Material.WRITTEN_BOOK);
        ItemMeta m = i.getItemMeta();
        m.setDisplayName("§6Новый камнерез!");
        m.setLore(new Lore("§7Новый камнерез представляет собой \"Верстак\", в нём есть 3 слота для предметов, туда можно поместить например камень и внизу появятся варианты обработки, выбрав один из них в правом слоте(-ах) появится результат", 35).getResult());
        i.setItemMeta(m);
        guyed.setItem(4, i);

        return guyed;
    }

    @Override
    public @NotNull Inventory getInventory() {
        return null;
    }
}
