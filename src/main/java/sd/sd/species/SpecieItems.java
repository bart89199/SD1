package sd.sd.species;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import sd.sd.crafts.Crafts;

public enum SpecieItems {
    DIAMOND_PICKAXE(new ItemStack(Material.DIAMOND_PICKAXE)), DIAMOND_AXE(new ItemStack(Material.DIAMOND_AXE)), DIAMOND_SHOVEL(new ItemStack(Material.DIAMOND_SHOVEL)),
    DIAMOND_HOE(new ItemStack(Material.DIAMOND_HOE)), DIAMOND_SWORD(new ItemStack(Material.DIAMOND_SWORD)), DIAMOND_MOLOT(Crafts.DIAMOND_MOLOT), DIAMOND_KNIFE(Crafts.DIAMOND_KNIFE),
    DIAMOND_PALASH(Crafts.DIAMOND_PALASH), IRON_MOLOT(Crafts.IRON_MOLOT), IRON_KNIFE(Crafts.IRON_KNIFE), IRON_PALASH(Crafts.IRON_PALASH), DIAMOND_ARMOR(new ItemStack(Material.DIAMOND_HELMET),
            new ItemStack(Material.DIAMOND_CHESTPLATE), new ItemStack(Material.DIAMOND_LEGGINGS), new ItemStack(Material.DIAMOND_BOOTS)), RECOVERY_COMPASS(new ItemStack(Material.RECOVERY_COMPASS)),
    BEACON(new ItemStack(Material.BEACON)), END_CRYSTAL(new ItemStack(Material.END_CRYSTAL)), TNT(new ItemStack(Material.TNT)), CROSSBOW(new ItemStack(Material.CROSSBOW)),
    NETHERITE_INGOT(new ItemStack(Material.NETHERITE_INGOT)), ENDER_EYE(new ItemStack(Material.ENDER_EYE)), ALL_REDSTONE(new ItemStack(Material.REDSTONE_TORCH), new ItemStack(Material.REPEATER),
            new ItemStack(Material.COMPARATOR), new ItemStack(Material.TARGET), new ItemStack(Material.TRIPWIRE_HOOK), new ItemStack(Material.DAYLIGHT_DETECTOR), new ItemStack(Material.PISTON),
            new ItemStack(Material.STICKY_PISTON), new ItemStack(Material.DISPENSER), new ItemStack(Material.DROPPER), new ItemStack(Material.REDSTONE), new ItemStack(Material.HOPPER), new ItemStack(Material.OBSERVER),
            new ItemStack(Material.NOTE_BLOCK), new ItemStack(Material.POWERED_RAIL), new ItemStack(Material.DETECTOR_RAIL), new ItemStack(Material.ACTIVATOR_RAIL), new ItemStack(Material.REDSTONE_LAMP)),
    SMOKER(new ItemStack(Material.SMOKER)), BLAST_FURNACE(new ItemStack(Material.BLAST_FURNACE)), CONDUIT(new ItemStack(Material.CONDUIT)), SHULKER_BOX(new ItemStack(Material.SHULKER_BOX)),
    ENDER_CHEST(new ItemStack(Material.ENDER_CHEST)), IRON_IMPROVED_ARMOR(Crafts.IRON_HELMET, Crafts.IRON_CHESTPLATE, Crafts.IRON_LEGGINGS, Crafts.IRON_BOOTS),
    DIAMOND_IMPROVED_ARMOR(Crafts.DIAMOND_HELMET, Crafts.DIAMOND_CHESTPLATE, Crafts.DIAMOND_LEGGINGS, Crafts.DIAMOND_BOOTS);

    public final ItemStack[] item;
    SpecieItems(ItemStack... item) {
        this.item = item;
    }

    public ItemStack[] getItem() {
        return item;
    }
}
