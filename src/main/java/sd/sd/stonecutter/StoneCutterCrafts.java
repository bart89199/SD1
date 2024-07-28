package sd.sd.stonecutter;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static sd.sd.stonecutter.Disk.DiskIdentify;

public class StoneCutterCrafts {

    private Inventory inv;
    public static List<ItemStack> recipes = new ArrayList<>();
    private Player pl;

    public StoneCutterCrafts(){
    }

    public void setPlayer(Player p){
        this.pl = p;
    }

    public void add(Disk NeedDisk, ItemStack FirstItem, ItemStack SecondItem, ItemStack ThirdItem, ItemStack Result1, ItemStack Result2,  ItemStack Result3){
        if(!NeedDisk.equal_pl(inv.getItem(14))){
            return;
        }
        List<Integer> CraftSlots = new ArrayList<>(); CraftSlots.add(10); CraftSlots.add(11); CraftSlots.add(12);

        boolean cont;

        if(Result1.getType().isEmpty()) {
            Result1.setType(Material.STRUCTURE_VOID);
        }
        if(Result2.getType().isEmpty()) {
            Result2.setType(Material.STRUCTURE_VOID);
        }
        if(Result3.getType().isEmpty()) {
            Result3.setType(Material.STRUCTURE_VOID);
        }

        List<ItemStack> NeedItems = new ArrayList<>(); NeedItems.add(FirstItem); NeedItems.add(SecondItem); NeedItems.add(ThirdItem);
        for(Integer slot : CraftSlots){
            cont = false;
            int c = 0;
            for(ItemStack r : NeedItems){
                if(cont) continue;
                c++;
                if(inv.getItem(slot) == null){
                    if(r.getType().isEmpty()) {
                        cont = true;
                    }
                    continue;
                }
                if (r.getType().equals(inv.getItem(slot).getType())) if (inv.getItem(slot).getAmount() >= r.getAmount()) {
                    cont = true;
                }

            }
            if(cont){
                NeedItems.remove(c-1);
            }
        }

        if(NeedItems.isEmpty()){
            recipes.add(setResultOnItem(Result1, Result2, Result3, FirstItem, SecondItem, ThirdItem));
        }

    }


    public boolean checkCraft(ItemStack FirstItem, ItemStack SecondItem, ItemStack ThirdItem){
        List<Integer> CraftSlots = new ArrayList<>(); CraftSlots.add(10); CraftSlots.add(11); CraftSlots.add(12);

        boolean cont;

        List<ItemStack> NeedItems = new ArrayList<>(); NeedItems.add(FirstItem); NeedItems.add(SecondItem); NeedItems.add(ThirdItem);
        for(Integer slot : CraftSlots){
            cont = false;
            int c = 0;
            for(ItemStack r : NeedItems){
                if(cont) continue;
                c++;
                if(inv.getItem(slot) == null){
                    if(r.getType().isEmpty()) {
                        cont = true;
                    }
                    continue;
                }
                if (r.getType().equals(inv.getItem(slot).getType())) if (inv.getItem(slot).getAmount() >= r.getAmount()) {
                    cont = true;
                }

            }
            if(cont){
                NeedItems.remove(c-1);
            }
        }

        if(NeedItems.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public ItemStack[] checkCraftRemainder(ItemStack FirstItem, ItemStack SecondItem, ItemStack ThirdItem){
        int[] CraftSlots = new int[3]; CraftSlots[0] = 10; CraftSlots[1] = 11; CraftSlots[2] = 12;

        ItemStack[] remainder = new ItemStack[3];

        boolean cont;

        List<ItemStackPlusNumber> NeedItems = new ArrayList<>(); NeedItems.add(new ItemStackPlusNumber(FirstItem, 0)); NeedItems.add(new ItemStackPlusNumber(SecondItem, 1)); NeedItems.add(new ItemStackPlusNumber(ThirdItem, 2));
        for(Integer slot : CraftSlots){
            cont = false;
            int c = 0;
            for(ItemStackPlusNumber r : NeedItems){
                if(cont) continue;
                c++;
                if(inv.getItem(slot) == null){
                    if(r.getItemStack().getType().isEmpty()) {
                        cont = true;
                        remainder[r.getNumber()] = null;
                    }
                    continue;
                }
                if (r.getItemStack().getType().equals(inv.getItem(slot).getType())) if (inv.getItem(slot).getAmount() >= r.getItemStack().getAmount()) {
                    cont = true;
                    r.getItemStack().setAmount(inv.getItem(slot).getAmount() - r.getItemStack().getAmount());
                    remainder[r.getNumber()] = r.getItemStack();
                }
            }
            if(cont){
                NeedItems.remove(c-1);
            }
        }

        if(!NeedItems.isEmpty()){
            return new ItemStack[1];
        }

        return remainder;

    }


    public ItemStack[] checkCraftRemainderMax(ItemStack FirstItem, ItemStack SecondItem, ItemStack ThirdItem, Player p){
        int[] CraftSlots = new int[3]; CraftSlots[0] = 10; CraftSlots[1] = 11; CraftSlots[2] = 12;

        ItemStack[] remainder = new ItemStack[4];
        int[] x = new int[5];

        boolean cont;

        List<ItemStackPlusNumber> NeedItems = new ArrayList<>(); NeedItems.add(new ItemStackPlusNumber(FirstItem, 0)); NeedItems.add(new ItemStackPlusNumber(SecondItem, 1)); NeedItems.add(new ItemStackPlusNumber(ThirdItem, 2));
        for(Integer slot : CraftSlots){
            cont = false;
            int c = 0;
            for(ItemStackPlusNumber r : NeedItems){
                if(cont) continue;
                c++;
                if(inv.getItem(slot) == null){
                    if(r.getItemStack().getType().isEmpty()) {
                        cont = true;
                        x[r.getNumber()] = 64;
                    }
                    continue;
                }
                if (r.getItemStack().getType().equals(inv.getItem(slot).getType())) if (inv.getItem(slot).getAmount() >= r.getItemStack().getAmount()) {
                    cont = true;
                    p.sendMessage(String.valueOf(inv.getItem(slot).getAmount() / r.getItemStack().getAmount()));
                    x[r.getNumber()] =inv.getItem(slot).getAmount() / r.getItemStack().getAmount();
                }
            }
            if(cont){
                NeedItems.remove(c-1);
            }
        }

        if(!NeedItems.isEmpty()){
            return new ItemStack[1];
        }

        x[3] = (int)Math.ceil(((double) (inv.getItem(14).getType().getMaxDurability() - ((Damageable)inv.getItem(14).getItemMeta()).getDamage())) / DiskIdentify(inv.getItem(14)).getDecrease());

        x[4] = Math.min(x[0], x[1]);
        x[4] = Math.min(x[4], x[2]);
        x[4] = Math.min(x[4], x[3]);

        NeedItems = new ArrayList<>(); NeedItems.add(new ItemStackPlusNumber(FirstItem, 0)); NeedItems.add(new ItemStackPlusNumber(SecondItem, 1)); NeedItems.add(new ItemStackPlusNumber(ThirdItem, 2));
        for(Integer slot : CraftSlots){
            cont = false;
            int c = 0;
            for(ItemStackPlusNumber r : NeedItems){
                if(cont) continue;
                c++;
                if(inv.getItem(slot) == null){
                    if(r.getItemStack().getType().isEmpty()) {
                        cont = true;
                        remainder[r.getNumber()] = null;
                    }
                    continue;
                }
                if (r.getItemStack().getType().equals(inv.getItem(slot).getType())) if (inv.getItem(slot).getAmount() >= r.getItemStack().getAmount()) {
                    cont = true;
                    r.getItemStack().setAmount(inv.getItem(slot).getAmount() - x[4] * r.getItemStack().getAmount());
                    remainder[r.getNumber()] = r.getItemStack();
                }
            }
            if(cont){
                NeedItems.remove(c-1);
            }
        }

        remainder[3] = new ItemStack(Material.STRUCTURE_VOID);

        remainder[3].setAmount(x[4]);

        return remainder;

    }


    public ItemStack setResultOnItem(ItemStack result1, ItemStack result2, ItemStack result3, ItemStack Need1, ItemStack Need2, ItemStack Need3){
        if(result1 == null){
            result1 = new ItemStack(Material.AIR);
        }
        if(result2 == null){
            result2 = new ItemStack(Material.AIR);
        }
        if(result3 == null){
            result3 = new ItemStack(Material.AIR);
        }
        if(Need1 == null){
            Need1 = new ItemStack(Material.AIR);
        }
        if(Need2 == null){
            Need2 = new ItemStack(Material.AIR);
        }
        if(Need3 == null){
            Need3 = new ItemStack(Material.AIR);
        }
        ItemMeta m = result1.getItemMeta();
        m.setLocalizedName("Type:recipe,Result1: " + result1.getType() + " Amount1: " + result1.getAmount() + " Result2: " + result2.getType() + " Amount2: " + result2.getAmount() + " Result3: " + result3.getType()  + " Amount3: " + result3.getAmount() + " Need1: " + Need1.getType() + " NeedA1: " + Need1.getAmount() + " Need2: " + Need2.getType()  + " NeedA2: " + Need2.getAmount() + " Need3: " + Need3.getType()  + " NeedA3: " + Need3.getAmount());
        result1.setItemMeta(m);
        return result1;
    }

    public ItemStack setResultOnItem(ItemStack result1, ItemStack result2, ItemStack result3, ItemStack Need1, ItemStack Need2, ItemStack Need3, Disk NeedDisk){
        if(result1 == null){
            result1 = new ItemStack(Material.AIR);
        }
        if(result2 == null){
            result2 = new ItemStack(Material.AIR);
        }
        if(result3 == null){
            result3 = new ItemStack(Material.AIR);
        }
        if(Need1 == null){
            Need1 = new ItemStack(Material.AIR);
        }
        if(Need2 == null){
            Need2 = new ItemStack(Material.AIR);
        }
        if(Need3 == null){
            Need3 = new ItemStack(Material.AIR);
        }
        ItemMeta m = result1.getItemMeta();
        m.setLocalizedName("Type:RecipeWithDisk,Disk: " + NeedDisk.getNumber() + " Result1: " + result1.getType() + " Amount1: " + result1.getAmount() + " Result2: " + result2.getType() + " Amount2: " + result2.getAmount() + " Result3: " + result3.getType()  + " Amount3: " + result3.getAmount() + " Need1: " + Need1.getType() + " NeedA1: " + Need1.getAmount() + " Need2: " + Need2.getType()  + " NeedA2: " + Need2.getAmount() + " Need3: " + Need3.getType()  + " NeedA3: " + Need3.getAmount());
        result1.setItemMeta(m);
        return result1;
    }

    public ItemStack setResultOnItem(ItemStack[] itemStacks){
        for(ItemStack checkItem : itemStacks){
            if(checkItem == null){
                checkItem = new ItemStack(Material.AIR);
            }
        }
        if(itemStacks.length == 7) if(itemStacks[6] == null){
            ItemMeta m = itemStacks[0].getItemMeta();
            m.setLocalizedName("Type:result,Result1: " + itemStacks[0].getType() + " Amount1: " + itemStacks[0].getAmount() + " Result2: " + itemStacks[1].getType() + " Amount2: " + itemStacks[1].getAmount() + " Result3: " + itemStacks[2].getType() + " Amount3: " + itemStacks[2].getAmount() + " Need1: " + itemStacks[3].getType() + " NeedA1: " + itemStacks[3].getAmount() + " Need2: " + itemStacks[4].getType() + " NeedA2: " + itemStacks[4].getAmount() + " Need3: " + itemStacks[5].getType() + " NeedA3: " + itemStacks[5].getAmount());
            itemStacks[0].setItemMeta(m);
            return itemStacks[0];
        }else {
            ItemMeta m = itemStacks[0].getItemMeta();
            m.setLocalizedName("Type:RecipeWithDisk,Disk: " +  DiskIdentify(itemStacks[6]).getNumber() + " Result1: " + itemStacks[0].getType() + " Amount1: " + itemStacks[0].getAmount() + " Result2: " + itemStacks[1].getType() + " Amount2: " + itemStacks[1].getAmount() + " Result3: " + itemStacks[2].getType() + " Amount3: " + itemStacks[2].getAmount() + " Need1: " + itemStacks[3].getType() + " NeedA1: " + itemStacks[3].getAmount() + " Need2: " + itemStacks[4].getType() + " NeedA2: " + itemStacks[4].getAmount() + " Need3: " + itemStacks[5].getType() + " NeedA3: " + itemStacks[5].getAmount());
            itemStacks[0].setItemMeta(m);
            return itemStacks[0];
        }

        ItemMeta m = itemStacks[0].getItemMeta();
        m.setLocalizedName("Type:recipe,Result1: " + itemStacks[0].getType() + " Amount1: " + itemStacks[0].getAmount() + " Result2: " + itemStacks[1].getType() + " Amount2: " + itemStacks[1].getAmount() + " Result3: " + itemStacks[2].getType() + " Amount3: " + itemStacks[2].getAmount() + " Need1: " + itemStacks[3].getType() + " NeedA1: " + itemStacks[3].getAmount() + " Need2: " + itemStacks[4].getType() + " NeedA2: " + itemStacks[4].getAmount() + " Need3: " + itemStacks[5].getType() + " NeedA3: " + itemStacks[5].getAmount());
        itemStacks[0].setItemMeta(m);
        return itemStacks[0];
    }

    public ItemStack setResultOnItem(ItemStack[] itemStacks, ItemStack target){
        if(itemStacks.length == 7) if(itemStacks[6] == null){
            ItemMeta m = target.getItemMeta();
            m.setLocalizedName("Type:result,Result1: " + itemStacks[0].getType() + " Amount1: " + itemStacks[0].getAmount() + " Result2: " + itemStacks[1].getType() + " Amount2: " + itemStacks[1].getAmount() + " Result3: " + itemStacks[2].getType() + " Amount3: " + itemStacks[2].getAmount() + " Need1: " + itemStacks[3].getType() + " NeedA1: " + itemStacks[3].getAmount() + " Need2: " + itemStacks[4].getType() + " NeedA2: " + itemStacks[4].getAmount() + " Need3: " + itemStacks[5].getType() + " NeedA3: " + itemStacks[5].getAmount());
            target.setItemMeta(m);
            return target;
        }else {
            ItemMeta m = target.getItemMeta();
            m.setLocalizedName("Type:RecipeWithDisk,Disk: " +  DiskIdentify(itemStacks[6]).getNumber() + " Result1: " + " Amount1: " + itemStacks[0].getAmount() + " Result2: " + itemStacks[1].getType() + " Amount2: " + itemStacks[1].getAmount() + " Result3: " + itemStacks[2].getType() + " Amount3: " + itemStacks[2].getAmount() + " Need1: " + itemStacks[3].getType() + " NeedA1: " + itemStacks[3].getAmount() + " Need2: " + itemStacks[4].getType() + " NeedA2: " + itemStacks[4].getAmount() + " Need3: " + itemStacks[5].getType() + " NeedA3: " + itemStacks[5].getAmount());
            target.setItemMeta(m);
            return target;
        }

        ItemMeta m = target.getItemMeta();
        m.setLocalizedName("Type:recipe,Result1: " + itemStacks[0].getType() + " Amount1: " + itemStacks[0].getAmount() + " Result2: " + itemStacks[1].getType() + " Amount2: " + itemStacks[1].getAmount() + " Result3: " + itemStacks[2].getType() + " Amount3: " + itemStacks[2].getAmount() + " Need1: " + itemStacks[3].getType() + " NeedA1: " + itemStacks[3].getAmount() + " Need2: " + itemStacks[4].getType() + " NeedA2: " + itemStacks[4].getAmount() + " Need3: " + itemStacks[5].getType() + " NeedA3: " + itemStacks[5].getAmount());
        target.setItemMeta(m);
        return target;
    }

    public ItemStack[] getResultOnItem(ItemStack i){
        ItemStack[] Flist = new ItemStack[3];
        ItemStack v = new ItemStack(Material.STRUCTURE_VOID);
        ItemMeta m = v.getItemMeta();
        m.setDisplayName("§7");
        v.setItemMeta(m);
        Flist[0] = v; Flist[1] = v; Flist[2] = v;
        if(i == null) {
            return Flist;
        }
        if(!i.hasItemMeta()) {
            return Flist;
        }
        if(!i.getItemMeta().hasLocalizedName()) {
            return Flist;
        }
        if(!i.getItemMeta().getLocalizedName().contains("Type:recipe")) if(!i.getItemMeta().getLocalizedName().contains("Type:RecipeWithDisk")) if(!i.getItemMeta().getLocalizedName().contains("Type:result")) {
            return Flist;
        }
        ItemStack[] list = new ItemStack[6];

        if(i.getItemMeta().getLocalizedName().contains("Type:recipe") ){
            list = new ItemStack[6];
        }
        if(i.getItemMeta().getLocalizedName().contains("Type:result")) {
            list = new ItemStack[7];
        }
        if(i.getItemMeta().getLocalizedName().contains("Type:RecipeWithDisk")) {
            list = new ItemStack[7];
            String ln = i.getItemMeta().getLocalizedName();
            list[6] = DiskIdentify(Integer.valueOf(ln.substring(ln.lastIndexOf("Disk") + 6, ln.lastIndexOf("Result1") - 1))).getItemStack();
        }


        v = new ItemStack(Material.STRUCTURE_VOID);
        m = v.getItemMeta();
        m.setDisplayName(" ");
        v.setItemMeta(m);

        String ln = i.getItemMeta().getLocalizedName();
        String addln = i.getItemMeta().getLocalizedName().replace("Type:recipe", "Type:result");
        i = new ItemStack(Material.matchMaterial(ln.substring(ln.lastIndexOf("Result1") + 9, ln.lastIndexOf("Amount1") - 1)), Integer.valueOf(ln.substring(ln.lastIndexOf("Amount1") + 9, ln.lastIndexOf("Result2") - 1)));
        m = i.getItemMeta();
        if(m == null) {
            i = v;
            m = i.getItemMeta();
        }
        m.setLocalizedName(addln);
        i.setItemMeta(m);
        list[0] = i;

//        getTags().getConfig().set("item", ln.substring(ln.lastIndexOf("Result2") + 9, ln.lastIndexOf("Result3")));


        i = new ItemStack(Material.matchMaterial(ln.substring(ln.lastIndexOf("Result2") + 9, ln.lastIndexOf("Amount2") - 1)), Integer.valueOf(ln.substring(ln.lastIndexOf("Amount2") + 9, ln.lastIndexOf("Result3") - 1)));
        m = i.getItemMeta();
        if(m == null) {
            i = v;
            m = i.getItemMeta();
        }        m.setLocalizedName(addln);
        i.setItemMeta(m);

        list[1] = i;

        i = new ItemStack(Material.matchMaterial(ln.substring(ln.lastIndexOf("Result3") + 9, ln.lastIndexOf("Amount3") - 1)), Integer.valueOf(ln.substring(ln.lastIndexOf("Amount3") + 9, ln.lastIndexOf("Need1") - 1)));
        m = i.getItemMeta();
        if(m == null) {
            i = v;
            m = i.getItemMeta();
        }
        m.setLocalizedName(addln);
        i.setItemMeta(m);

        list[2] = i;

        list[3] = new ItemStack(Material.matchMaterial(ln.substring(ln.lastIndexOf("Need1") + 7, ln.lastIndexOf("NeedA1") - 1)), Integer.valueOf(ln.substring(ln.lastIndexOf("NeedA1") + 8, ln.lastIndexOf("Need2") - 1)));
        list[4] = new ItemStack(Material.matchMaterial(ln.substring(ln.lastIndexOf("Need2") + 7, ln.lastIndexOf("NeedA2") - 1)), Integer.valueOf(ln.substring(ln.lastIndexOf("NeedA2") + 8, ln.lastIndexOf("Need3") - 1)));
        list[5] = new ItemStack(Material.matchMaterial(ln.substring(ln.lastIndexOf("Need3") + 7, ln.lastIndexOf("NeedA3") - 1)), Integer.valueOf(ln.substring(ln.lastIndexOf("NeedA3") + 8, ln.length())));

        return list;
    }

    public ItemStack[] getResultOnItemForExample(ItemStack i){
        ItemStack[] Flist = new ItemStack[3];
        ItemStack v = new ItemStack(Material.STRUCTURE_VOID);
        ItemMeta m = v.getItemMeta();
        m.setDisplayName("§7");
        v.setItemMeta(m);
        Flist[0] = v; Flist[1] = v; Flist[2] = v;
        if(i == null) {
            return Flist;
        }
        if(!i.hasItemMeta()) {
            return Flist;
        }
        if(!i.getItemMeta().hasLocalizedName()) {
            return Flist;
        }
        if(!i.getItemMeta().getLocalizedName().contains("Type:recipe")) if(!i.getItemMeta().getLocalizedName().contains("Type:RecipeWithDisk")) if(!i.getItemMeta().getLocalizedName().contains("Type:result")) {
            return Flist;
        }
        ItemStack[] list = new ItemStack[6];

        if(i.getItemMeta().getLocalizedName().contains("Type:recipe") ){
            list = new ItemStack[6];
        }
        if(i.getItemMeta().getLocalizedName().contains("Type:result")) {
            list = new ItemStack[7];
        }
        if(i.getItemMeta().getLocalizedName().contains("Type:RecipeWithDisk")) {
            list = new ItemStack[7];
            String ln = i.getItemMeta().getLocalizedName();
            list[6] = DiskIdentify(Integer.valueOf(ln.substring(ln.lastIndexOf("Disk") + 6, ln.lastIndexOf("Result1") - 1))).getItemStack();
        }


        String ln = i.getItemMeta().getLocalizedName();
        String addln = i.getItemMeta().getLocalizedName().replace("Type:recipe", "Type:result");
        i = new ItemStack(Material.matchMaterial(ln.substring(ln.lastIndexOf("Result1") + 9, ln.lastIndexOf("Amount1") - 1)), Integer.valueOf(ln.substring(ln.lastIndexOf("Amount1") + 9, ln.lastIndexOf("Result2") - 1)));
        m = i.getItemMeta();
        m.setLocalizedName(addln);
        i.setItemMeta(m);
        list[0] = i;

//        getTags().getConfig().set("item", ln.substring(ln.lastIndexOf("Result2") + 9, ln.lastIndexOf("Result3")));


        i = new ItemStack(Material.matchMaterial(ln.substring(ln.lastIndexOf("Result2") + 9, ln.lastIndexOf("Amount2") - 1)), Integer.valueOf(ln.substring(ln.lastIndexOf("Amount2") + 9, ln.lastIndexOf("Result3") - 1)));
        m = i.getItemMeta();
        if(m == null){
            i = new ItemStack(Material.STRUCTURE_VOID);
            m = i.getItemMeta();
        }
        m.setLocalizedName(addln);
        i.setItemMeta(m);

        list[1] = i;

        i = new ItemStack(Material.matchMaterial(ln.substring(ln.lastIndexOf("Result3") + 9, ln.lastIndexOf("Amount3") - 1)), Integer.valueOf(ln.substring(ln.lastIndexOf("Amount3") + 9, ln.lastIndexOf("Need1") - 1)));
        m = i.getItemMeta();
        if(m == null){
            i = new ItemStack(Material.STRUCTURE_VOID);
            m = i.getItemMeta();
        }
        m.setLocalizedName(addln);
        i.setItemMeta(m);

        list[2] = i;

        list[3] = new ItemStack(Material.matchMaterial(ln.substring(ln.lastIndexOf("Need1") + 7, ln.lastIndexOf("NeedA1") - 1)), Integer.valueOf(ln.substring(ln.lastIndexOf("NeedA1") + 8, ln.lastIndexOf("Need2") - 1)));
        list[4] = new ItemStack(Material.matchMaterial(ln.substring(ln.lastIndexOf("Need2") + 7, ln.lastIndexOf("NeedA2") - 1)), Integer.valueOf(ln.substring(ln.lastIndexOf("NeedA2") + 8, ln.lastIndexOf("Need3") - 1)));
        list[5] = new ItemStack(Material.matchMaterial(ln.substring(ln.lastIndexOf("Need3") + 7, ln.lastIndexOf("NeedA3") - 1)), Integer.valueOf(ln.substring(ln.lastIndexOf("NeedA3") + 8, ln.length())));

        return list;
    }



    public void setInventory(Inventory inv){
        this.inv= inv;
    }

    public Inventory getInventory(){
        return inv;
    }


}


