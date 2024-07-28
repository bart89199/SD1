package sd.sd.stonecutter;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public enum Disk {
    Wooden(1, 59, 2, 30), Stone(2, 131, 3, 43), Iron(3, 250, 3, 83), Iron_Diamond(5, 250, 2, 125), Golden(4, 32, 1, 32), Diamond(6, 1561, 6, 260), Diamond_Netherite(7, 1561, 4, 390), Netherite(8, 2031, 3, 677), Error(301, 301, 301, 301);


    Disk(int number, int durability, int decrease, int FactDurability) {
        this.number = number;
        this.durability = durability;
        this.decrease = decrease;
        ItemMeta m;
        if (number == 1) {
            itemStack = new ItemStack(Material.WOODEN_PICKAXE);
            m = itemStack.getItemMeta();
            m.setCustomModelData(40060001);
            m.setDisplayName("§rДеревянный диск");
            m.setLocalizedName("WoodenDisk");
            itemStack.setItemMeta(m);
        }
        if (number == 2) {
            itemStack = new ItemStack(Material.STONE_PICKAXE);
            m = itemStack.getItemMeta();
            m.setCustomModelData(40060001);
            m.setDisplayName("§rКаменный диск");
            m.setLocalizedName("StoneDisk");
            itemStack.setItemMeta(m);
        }
        if (number == 3) {
            itemStack = new ItemStack(Material.IRON_PICKAXE);
            m = itemStack.getItemMeta();
            m.setCustomModelData(40060001);
            m.setDisplayName("§rЖелезный диск");
            m.setLocalizedName("IronDisk");
            itemStack.setItemMeta(m);
        }
        if (number == 4) {
            itemStack = new ItemStack(Material.IRON_PICKAXE);
            itemStack.addEnchantment(Enchantment.DURABILITY, 3);
            m = itemStack.getItemMeta();
            m.setCustomModelData(40060002);
            m.setDisplayName("§rЖелезный диск с алмазным напылением");
            m.setLocalizedName("IronDisk+");
            itemStack.setItemMeta(m);
        }
        if (number == 5) {
            itemStack = new ItemStack(Material.GOLDEN_PICKAXE);
            m = itemStack.getItemMeta();
            m.setCustomModelData(40060001);
            m.setDisplayName("§rЗолотой диск");
            m.setLocalizedName("GoldenDisk");
            itemStack.setItemMeta(m);
        }
        if (number == 6) {
            itemStack = new ItemStack(Material.DIAMOND_PICKAXE);
            m = itemStack.getItemMeta();
            m.setCustomModelData(40060001);
            m.setDisplayName("§rАлмазный диск");
            m.setLocalizedName("DiamondDisk");
            itemStack.setItemMeta(m);
        }
        if (number == 7) {
            itemStack = new ItemStack(Material.DIAMOND_PICKAXE);
            itemStack.addEnchantment(Enchantment.DURABILITY, 3);
            m = itemStack.getItemMeta();
            m.setCustomModelData(40060001);
            m.setDisplayName("§rАлмазный диск с незеритовым напылением");
            m.setLocalizedName("DiamondDisk+");
            itemStack.setItemMeta(m);
        }
        if (number == 8) {
            itemStack = new ItemStack(Material.NETHERITE_PICKAXE);
            m = itemStack.getItemMeta();
            m.setCustomModelData(40060001);
            m.setDisplayName("§rНезеритовый диск");
            m.setLocalizedName("NetheriteDisk");
            itemStack.setItemMeta(m);
        }
    }

    private ItemStack itemStack;
    private int durability;
    private int number;
    private int decrease;

    public ItemStack getItemStack() {
        return itemStack;
    }

    public int getDurability() {
        return durability;
    }

    public int getNumber() {
        return number;
    }

    public int getDecrease() {
        return decrease;
    }

    public boolean equal(ItemStack itemStack) {
        return DiskIdentify(itemStack).getNumber() == number;
    }

    public boolean equal_pl(ItemStack itemStack) {
        if(DiskIdentify(itemStack).getNumber() == 301){
            return false;
        }
        return number <= DiskIdentify(itemStack).getNumber();
    }

    public static Disk DiskIdentify(ItemStack identifyItem) {
        if (identifyItem == null || identifyItem.getType().isAir() || !identifyItem.hasItemMeta()) {
            return Disk.Error;
        }
        if (identifyItem.getItemMeta().getLocalizedName().equalsIgnoreCase(Disk.Wooden.getItemStack().getItemMeta().getLocalizedName())) {
            return Disk.Wooden;
        }

        if (identifyItem.getItemMeta().getLocalizedName().equalsIgnoreCase(Disk.Stone.getItemStack().getItemMeta().getLocalizedName())) {
            return Disk.Stone;
        }
        if (identifyItem.getItemMeta().getLocalizedName().equalsIgnoreCase(Disk.Iron.getItemStack().getItemMeta().getLocalizedName())) {
            return Disk.Iron;
        }
        if (identifyItem.getItemMeta().getLocalizedName().equalsIgnoreCase(Disk.Iron_Diamond.getItemStack().getItemMeta().getLocalizedName())) {
            return Disk.Iron_Diamond;
        }
        if (identifyItem.getItemMeta().getLocalizedName().equalsIgnoreCase(Disk.Golden.getItemStack().getItemMeta().getLocalizedName())) {
            return Disk.Golden;
        }
        if (identifyItem.getItemMeta().getLocalizedName().equalsIgnoreCase(Disk.Diamond.getItemStack().getItemMeta().getLocalizedName())) {
            return Disk.Diamond;
        }
        if (identifyItem.getItemMeta().getLocalizedName().equalsIgnoreCase(Disk.Diamond_Netherite.getItemStack().getItemMeta().getLocalizedName())) {
            return Disk.Diamond_Netherite;
        }
        if (identifyItem.getItemMeta().getLocalizedName().equalsIgnoreCase(Disk.Netherite.getItemStack().getItemMeta().getLocalizedName())) {
            return Disk.Netherite;
        }
        return Disk.Error;
    }
        public static Disk DiskIdentify(int number) {
            List<Disk> disks = new ArrayList<>(); disks.add(Disk.Wooden); disks.add(Disk.Stone); disks.add(Disk.Iron); disks.add(Disk.Golden); disks.add(Disk.Iron_Diamond); disks.add(Disk.Diamond); disks.add(Disk.Diamond_Netherite); disks.add(Disk.Netherite);
            for(Disk disk : disks){
                if(disk.getNumber() == number){
                    return disk;
                }
            }
            return Disk.Error;
        }

}
