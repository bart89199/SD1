package sd.sd.crafts;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import sd.sd.SD;

import java.util.UUID;

public class CraftsOld implements Listener {

    private SD plugin;

    public CraftsOld(SD plugin) {
        this.plugin = plugin;
    }



    @EventHandler
    public void onCraft(CraftItemEvent e) {

        if(e.getRecipe().getResult().equals(new ItemStack(Material.IRON_BLOCK)) && !e.getRecipe().getResult().hasItemMeta()) {
            e.getRecipe().getResult().setType(Material.AIR);
        }
        if(e.getRecipe().getResult().equals(new ItemStack(Material.IRON_INGOT)) && !e.getRecipe().getResult().hasItemMeta()) {
            e.getRecipe().getResult().setType(Material.AIR);
        }

        if(e.getInventory().getResult() != null && e.getInventory().getResult().getAmount() == 1 && (e.getInventory().getResult().hasItemMeta() && (e.getInventory().getResult().getItemMeta().hasLocalizedName() && e.getInventory().getResult().getItemMeta().getLocalizedName().contains("PLASTINA")))){
            if(e.getInventory().getItem(9) != null && e.getInventory().getItem(9).hasItemMeta() && e.getInventory().getItem(9).getItemMeta().hasLocalizedName() && e.getInventory().getItem(9).getItemMeta().getLocalizedName().contains("MOLOT")){
                switch (e.getInventory().getItem(9).getItemMeta().getLocalizedName()){
                    case "STONE_MOLOT":
                        onCraft(e, Material.STONE_AXE.getMaxDurability(), 44, 0, 1, 3, 4);
                        return;
                    case "IRON_MOLOT":
                        onCraft(e, Material.IRON_AXE.getMaxDurability(), 7, 0, 1, 3, 4);
                        return;
                    case "DIAMOND_MOLOT":
                        onCraft(e, Material.DIAMOND_AXE.getMaxDurability(), 8, 0, 1, 3, 4);
                        return;
                    case "NETHERITE_MOLOT":
                        onCraft(e, Material.NETHERITE_AXE.getMaxDurability(), 8, 0, 1, 3, 4);
                        return;
                }

            }else{
                e.getInventory().setResult(null);
                e.setCancelled(true);
            }
        }
     if(e.getInventory().getResult() != null && e.getInventory().getResult().getType().equals(Material.NETHERITE_INGOT)){

         for(ItemStack item : e.getInventory().getMatrix()){

             if(item != null && !item.getType().isEmpty() && item.getType().equals(Material.NETHERITE_BLOCK)) return;

         }

         if(e.getInventory().getItem(9) != null && e.getInventory().getItem(9).hasItemMeta() && e.getInventory().getItem(9).getItemMeta().hasLocalizedName() && e.getInventory().getItem(9).getItemMeta().getLocalizedName().contains("MOLOT")) {
             switch (e.getInventory().getItem(9).getItemMeta().getLocalizedName()){
                 case "DIAMOND_MOLOT":
                     onCraft(e, Material.DIAMOND_AXE.getMaxDurability(), 100, 0, 1, 2, 3, 4, 6);
                     return;
                 case "NETHERITE_MOLOT":
                     onCraft(e, Material.NETHERITE_AXE.getMaxDurability(), 100, 0, 1, 2, 3, 4, 6);
                     return;
             }
         }else{
             e.getInventory().setResult(null);
             e.setCancelled(true);
         }
         }

        }

    public void onPlastinaCraft(CraftItemEvent e, int Durability, int Damage){
        ItemStack[] matrix = new ItemStack[9];
        ItemStack result = new ItemStack(e.getInventory().getResult());
        for(int i = 0; i < 9; i++){
            if(e.getInventory().getMatrix()[i] != null)
                matrix[i] = new ItemStack(e.getInventory().getMatrix()[i]);
        }
        ItemMeta m = matrix[8].getItemMeta();
        if(((Damageable) m).getDamage() >= (Durability - Damage)){
            return;
        }else{
            e.setCancelled(true);
            if(e.isShiftClick()){
                int a;
                for(a=0; a < min(matrix[0].getAmount(), matrix[1].getAmount(), matrix[3].getAmount(), matrix[4].getAmount()); a++){
                    if(!(((Damageable) m).getDamage() >= (Durability - Damage))){
                        ((Damageable) m).setDamage(((Damageable) m).getDamage() + Damage);
                    }else{
                        matrix[8].setType(Material.AIR);
                        a++;
                        break;
                    }
                }

                for(int i = 0; i < 36; i++){
                    ItemStack item = e.getView().getPlayer().getInventory().getItem(i);
                    if(item == null){
                        updateIngredients(new ItemStack[]{matrix[0], matrix[1], matrix[3], matrix[4]}, result, matrix[8], a, Damage);
                        e.getInventory().setMatrix(matrix);
                        e.getView().getPlayer().getInventory().addItem(result);
                        return;
                    }
                    if(item.getType().equals(result.getType()) && item.hasItemMeta() && item.getItemMeta().hasLocalizedName() && item.getItemMeta().equals(result.getItemMeta()) && item.getAmount() < 64) {
                        if ((a + item.getAmount() - 64) > 0) {
                            a = a - (64 - item.getAmount());
                            updateIngredients(new ItemStack[]{matrix[0], matrix[1], matrix[3], matrix[4]}, result, matrix[8], 64 - item.getAmount(), Damage);
                            e.getInventory().setMatrix(matrix);
                            e.getView().getPlayer().getInventory().addItem(result);
                        } else {
                            updateIngredients(new ItemStack[]{matrix[0], matrix[1], matrix[3], matrix[4]}, result, matrix[8], a, Damage);
                            e.getInventory().setMatrix(matrix);
                            e.getView().getPlayer().getInventory().addItem(result);
                            return;
                        }
                    }
                }
                return;
            }
            updateIngredients(new ItemStack[]{matrix[0], matrix[1], matrix[3], matrix[4]}, result, matrix[8], 1, Damage);

            if(e.getView().getCursor() == null || e.getView().getCursor().getType().isEmpty()) {
                e.getInventory().setMatrix(matrix);
                e.getView().setCursor(result);
                return;
            }else{
                if(e.getView().getCursor().getType().equals(result.getType()) && e.getView().getCursor().getItemMeta().equals(result.getItemMeta()) && e.getView().getCursor().getAmount() < 64){
                    e.getInventory().setMatrix(matrix);
                    result.setAmount(result.getAmount() + e.getView().getCursor().getAmount());
                    e.getView().setCursor(result);
                    return;
                }
                return;
            }
        }
    }

    public void onNetheriteCraft(CraftItemEvent e, int Durability, int Damage){
        ItemStack[] matrix = new ItemStack[9];
        ItemStack result = new ItemStack(e.getInventory().getResult());
        for(int i = 0; i < 9; i++){
            if(e.getInventory().getMatrix()[i] != null)
                matrix[i] = new ItemStack(e.getInventory().getMatrix()[i]);
        }
        ItemMeta m = matrix[8].getItemMeta();
        if(((Damageable) m).getDamage() >= (Durability - Damage)){
            return;
        }else{
            e.setCancelled(true);
            if(e.isShiftClick()){
                int a;
                for(a=0; a < min(matrix[0].getAmount(), matrix[1].getAmount(), matrix[2].getAmount(), matrix[3].getAmount(), matrix[4].getAmount(), matrix[6].getAmount()); a++){
                    if(!(((Damageable) m).getDamage() >= (Durability - Damage))){
                        ((Damageable) m).setDamage(((Damageable) m).getDamage() + Damage);
                    }else{
                        matrix[8].setType(Material.AIR);
                        a++;
                        break;
                    }
                }

                for(int i = 0; i < 36; i++){
                    ItemStack item = e.getView().getPlayer().getInventory().getItem(i);
                    if(item == null){
                        updateIngredients(new ItemStack[]{matrix[0], matrix[1], matrix[2], matrix[3], matrix[4] , matrix[6]}, result, matrix[8], a, Damage);
                        e.getInventory().setMatrix(matrix);
                        e.getView().getPlayer().getInventory().addItem(result);
                        return;
                    }
                    if(item.getType().equals(result.getType()) && !item.hasItemMeta() && item.getAmount() < 64) {
                        if ((a + item.getAmount() - 64) > 0) {
                            a = a - (64 - item.getAmount());
                            updateIngredients(new ItemStack[]{matrix[0], matrix[1], matrix[2], matrix[3], matrix[4], matrix[6]}, result, matrix[8], 64 - item.getAmount(), Damage);
                            e.getInventory().setMatrix(matrix);
                            e.getView().getPlayer().getInventory().addItem(result);
                        } else {
                            updateIngredients(new ItemStack[]{matrix[0], matrix[1], matrix[2], matrix[3], matrix[4] , matrix[6]}, result, matrix[8], a, Damage);
                            e.getInventory().setMatrix(matrix);
                            e.getView().getPlayer().getInventory().addItem(result);
                            return;
                        }
                    }
                }
                return;
            }
            updateIngredients(new ItemStack[]{matrix[0], matrix[1], matrix[2], matrix[3], matrix[4], matrix[6]}, result, matrix[8], 1, Damage);

            if(e.getView().getCursor() == null || e.getView().getCursor().getType().isEmpty()) {
                e.getInventory().setMatrix(matrix);
                e.getView().setCursor(result);
                return;
            }else{
                if(e.getView().getCursor().getType().equals(result.getType()) && e.getView().getCursor().getItemMeta().getLocalizedName().equals(result.getItemMeta().getLocalizedName()) && e.getView().getCursor().getAmount() < 64){
                    e.getInventory().setMatrix(matrix);
                    result.setAmount(result.getAmount() + e.getView().getCursor().getAmount());
                    e.getView().setCursor(result);
                    return;
                }
                return;
            }
        }
    }

    public void onCraft(CraftItemEvent e, int Durability, int Damage, Integer... slots_num){
        ItemStack[] matrix = new ItemStack[9];
        ItemStack result = new ItemStack(e.getInventory().getResult());
        for(int i = 0; i < 9; i++){
            if(e.getInventory().getMatrix()[i] != null)
                matrix[i] = new ItemStack(e.getInventory().getMatrix()[i]);
        }
        ItemStack[] slots = new ItemStack[slots_num.length];
        for(int i=0; i < slots_num.length; i++){
            slots[i] = matrix[slots_num[i]];
        }
        ItemMeta m = matrix[8].getItemMeta();
        if(((Damageable) m).getDamage() >= (Durability - Damage)){
            return;
        }else{
            e.setCancelled(true);
//            for(Integer i : slots_num) {
//                e.getView().getPlayer().sendMessage(i + "");
//            }
            if(e.isShiftClick()){
                int a;
                for(a=0; a < min(matrix, slots_num); a++){
                    if(!(((Damageable) m).getDamage() >= (Durability - Damage))){
                        ((Damageable) m).setDamage(((Damageable) m).getDamage() + Damage);
                    }else{
                        a++;
                        break;
                    }
                }

                for(int i = 0; i < 36; i++){
                    ItemStack item = e.getView().getPlayer().getInventory().getItem(i);
                    if(item == null){
                        updateIngredients(slots, result, matrix[8], a, Damage);
                        e.getInventory().setMatrix(matrix);
                        e.getView().getPlayer().getInventory().addItem(result);
                        return;
                    }
                    if(((result.hasItemMeta()) && item.getType().equals(result.getType()) && item.hasItemMeta() && item.getItemMeta().hasLocalizedName() && item.getItemMeta().equals(result.getItemMeta()) && item.getAmount() < 64) || !result.hasItemMeta() && (item.getType().equals(result.getType()) && !item.hasItemMeta() && item.getAmount() < 64)) {
                        if ((a + item.getAmount() - 64) > 0) {
                            a = a - (64 - item.getAmount());
                            updateIngredients(slots, result, matrix[8], 64 - item.getAmount(), Damage);
                            e.getInventory().setMatrix(matrix);
                            e.getView().getPlayer().getInventory().addItem(result);
                        } else {
                            updateIngredients(slots, result, matrix[8], a, Damage);
                            e.getInventory().setMatrix(matrix);
                            e.getView().getPlayer().getInventory().addItem(result);
                            return;
                        }
                    }
                }
                return;
            }
            updateIngredients(slots, result, matrix[8], 1, Damage);

            if(e.getView().getCursor() == null || e.getView().getCursor().getType().isEmpty()) {
                e.getInventory().setMatrix(matrix);
                e.getView().setCursor(result);
                return;
            }else{
                if(e.getView().getCursor().getType().equals(result.getType()) && e.getView().getCursor().getItemMeta().equals(result.getItemMeta()) && e.getView().getCursor().getAmount() < 64){
                    e.getInventory().setMatrix(matrix);
                    result.setAmount(result.getAmount() + e.getView().getCursor().getAmount());
                    e.getView().setCursor(result);
                    return;
                }
                return;
            }
        }
    }

    public int min(Integer... numbers){
        int min = 65;
        for(int i : numbers){
            min = Math.min(min, i);
        }
        return min;
    }

    public int min(ItemStack[] matrix, Integer... slots){
        Integer[] numbers = new Integer[slots.length];
        for(int i=0; i < slots.length; i++){
            numbers[i] = matrix[slots[i]].getAmount();
        }
        int min = 65;
        for(int i : numbers){
            min = Math.min(min, i);
        }
        return min;
    }

    public void updateIngredients(ItemStack[] ingredients, ItemStack result, ItemStack instrument, int low, int damage){
        for(ItemStack item : ingredients) {
            if (item.getAmount() != low) {
                item.setAmount(item.getAmount() - low);
            } else {
                item.setType(Material.AIR);
            }
        }
        result.setAmount(low);
        if(instrument.getType().getMaxDurability() > (((Damageable) instrument.getItemMeta()).getDamage() + damage * low)){
            ItemMeta m = instrument.getItemMeta();
            ((Damageable) m).setDamage(((Damageable) m).getDamage() + (damage * low));
            instrument.setItemMeta(m);
        }else{
            instrument.setType(Material.AIR);
        }
    }

    @EventHandler
    public void onCraft(PrepareItemCraftEvent e) {
        if (e.getInventory().getResult() == null) return;
        if(e.getRecipe() instanceof ShapedRecipe) {
            String key = ((ShapedRecipe) e.getRecipe()).getKey().asString();
            if(key.equals("minecraft:iron_plastina") || key.equals("minecraft:diamond_plastina") || key.equals("minecraft:gold_plastina")){
                if(e.getInventory().getItem(9) == null || !e.getInventory().getItem(9).hasItemMeta() || !e.getInventory().getItem(9).getItemMeta().hasLocalizedName() || !e.getInventory().getItem(9).getItemMeta().getLocalizedName().contains("MOLOT")) {
                    e.getInventory().setResult(null);
                }
            }
            if(key.contains("plastina")){
            for(ItemStack item : e.getInventory().getMatrix()){
                if(item != null && !item.getType().isEmpty()) if(item.getType().equals(Material.CYAN_DYE) || item.getType().equals(Material.YELLOW_DYE) || item.getType().equals(Material.GRAY_DYE))
                    if(!item.hasItemMeta() || !item.getItemMeta().hasLocalizedName() || !item.getItemMeta().getLocalizedName().contains("PLASTINA")){
                        e.getInventory().setResult(null);
                        return;
                    }
            }
            }
        }
    }
//    @EventHandler
//    public void onSmelting(FurnaceSmeltEvent e){
//        if(e.getResult().getType().equals(Material.IRON_NUGGET) && e.getResult().getAmount() > 1){
//            switch (e.getRecipe().getInput().getType()){
//                case IRON_ORE:
//                    e.setResult(new ItemStack(Material.IRON_NUGGET, new Random().nextInt(6) + 7));
//                    return;
//                case RAW_IRON:
//                    e.setResult(new ItemStack(Material.IRON_NUGGET, new Random().nextInt(6) + 2));
//                    return;
//            }
//        }
//        if(e.getResult().getType().equals(Material.GOLD_NUGGET) && e.getResult().getAmount() > 1){
//            switch (e.getRecipe().getInput().getType()){
//                case GOLD_ORE:
//                    e.setResult(new ItemStack(Material.GOLD_NUGGET, new Random().nextInt(6) + 7));
//                    return;
//                case RAW_GOLD:
//                    e.setResult(new ItemStack(Material.GOLD_NUGGET, new Random().nextInt(6) + 2));
//                    return;
//            }
//        }
//        }

    @EventHandler
    public void onInteract(InventoryClickEvent e){
        if(e.getCurrentItem() != null && ((e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasLocalizedName()))) {
            if (e.getCurrentItem().getType().equals(Material.NETHERITE_SWORD) && e.getCurrentItem().getItemMeta().getLocalizedName().equals("DIAMOND_KNIFE")) {
                ItemMeta m = e.getCurrentItem().getItemMeta();
                m.setDisplayName(ChatColor.DARK_GRAY + "Незеритовый кинжал");
                m.setLocalizedName("NETHERITE_KNIFE");
                AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 1.0D, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                m.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
                e.getCurrentItem().setItemMeta(m);
                return;
            }

            if (e.getCurrentItem().getType().equals(Material.NETHERITE_AXE) && e.getCurrentItem().getItemMeta().getLocalizedName().equals("DIAMOND_PALASH")) {
                ItemMeta m = e.getCurrentItem().getItemMeta();
                m.setDisplayName(ChatColor.DARK_GRAY + "Незеритовый палаш");
                m.setLocalizedName("NETHERITE_PALASH");
                AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 1.0D, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                m.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
                e.getCurrentItem().setItemMeta(m);
                return;
            }

            if (e.getCurrentItem().getType().equals(Material.NETHERITE_AXE) && e.getCurrentItem().getItemMeta().getLocalizedName().equals("DIAMOND_MOLOT")) {
                ItemMeta m = e.getCurrentItem().getItemMeta();
                m.setDisplayName(ChatColor.DARK_GRAY + "Незеритовый молот");
                m.setLocalizedName("NETHERITE_MOLOT");
                e.getCurrentItem().setItemMeta(m);
                return;
            }
        }
    }




    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if(e.getDamager() instanceof Player){
            Player p = (Player) e.getDamager();
            if((p.getInventory().getItemInMainHand() != null && p.getInventory().getItemInOffHand() != null) && ((p.getInventory().getItemInMainHand().hasItemMeta() && p.getInventory().getItemInOffHand().hasItemMeta()) && (p.getInventory().getItemInMainHand().getItemMeta().hasLocalizedName() && p.getInventory().getItemInOffHand().getItemMeta().hasLocalizedName()))){
                if(p.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().contains("KNIFE") && p.getInventory().getItemInOffHand().getItemMeta().getLocalizedName().contains("KNIFE")){
                    e.setDamage(e.getDamage() + 3.5);
                    ItemMeta m = p.getInventory().getItemInOffHand().getItemMeta();
                    ((Damageable) m).setDamage(((Damageable) m).getDamage() + 1);
                    p.getInventory().getItemInOffHand().setItemMeta(m);
                    m = p.getInventory().getItemInMainHand().getItemMeta();
                    ((Damageable) m).setDamage(((Damageable) m).getDamage() + 1);
                    p.getInventory().getItemInMainHand().setItemMeta(m);
                }
            }
            if(e.getEntity() instanceof Player){
                Player t = ((Player) e.getEntity());
                if(p.getInventory().getItemInMainHand() != null && (p.getInventory().getItemInMainHand().hasItemMeta() && (p.getInventory().getItemInMainHand().getItemMeta().hasLocalizedName() && p.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().contains("PALASH")))) {
                    if (t.getInventory().getItemInMainHand() != null && t.getInventory().getItemInMainHand().getType().equals(Material.SHIELD)) {
                        ItemMeta m = t.getInventory().getItemInMainHand().getItemMeta();
                        if (((Damageable) m).getDamage() >= 224) {
                            t.getInventory().setItemInMainHand(null);
                            return;
                        }
                        ((Damageable) m).setDamage(((Damageable) m).getDamage() + 112);
                        t.getInventory().getItemInMainHand().setItemMeta(m);
                        t.getWorld().dropItem(t.getLocation(), t.getInventory().getItemInMainHand());
                        t.getInventory().setItemInMainHand(null);
                        return;
                    }
                    if (t.getInventory().getItemInOffHand() != null && t.getInventory().getItemInOffHand().getType().equals(Material.SHIELD)) {
                        ItemMeta m = t.getInventory().getItemInOffHand().getItemMeta();
                        if (((Damageable) m).getDamage() >= 224) {
                            t.getInventory().setItemInOffHand(null);
                            return;
                        }
                        ((Damageable) m).setDamage(((Damageable) m).getDamage() + 112);
                        t.getInventory().getItemInOffHand().setItemMeta(m);
                        t.getWorld().dropItem(t.getLocation(), t.getInventory().getItemInOffHand());
                        t.getInventory().setItemInOffHand(null);
                        return;
                    }
                }
            }
        }
    }


    @EventHandler
    public void onArmorChange(PlayerArmorChangeEvent e){
        if(e.getNewItem() == null) return;
        ItemStack item = e.getNewItem();
        if (!(item.hasItemMeta() && item.getItemMeta().hasAttributeModifiers())) {
            ItemMeta m = e.getNewItem().getItemMeta();
            switch (item.getType()) {
                case IRON_HELMET -> {
                    m.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.01, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HEAD));
                    m.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "generic.armor", 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD));
                    item.setItemMeta(m);
                }
                case IRON_CHESTPLATE -> {
                    m.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.04, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.CHEST));
                    m.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "generic.armor", 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST));
                    item.setItemMeta(m);
                }
                case IRON_LEGGINGS -> {
                    m.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.03, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.LEGS));
                    m.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "generic.armor", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS));
                    item.setItemMeta(m);
                }
                case IRON_BOOTS -> {
                    m.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.02, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.FEET));
                    m.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "generic.armor", 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET));
                    item.setItemMeta(m);
                }
                case CHAINMAIL_HELMET -> {
                    m.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.01, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HEAD));
                    m.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "generic.armor", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD));
                    item.setItemMeta(m);
                }
                case CHAINMAIL_CHESTPLATE -> {
                    m.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.04, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.CHEST));
                    m.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "generic.armor", 5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST));
                    item.setItemMeta(m);
                }
                case CHAINMAIL_LEGGINGS -> {
                    m.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.03, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.LEGS));
                    m.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "generic.armor", 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS));
                    item.setItemMeta(m);
                }
                case CHAINMAIL_BOOTS -> {
                    m.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.01, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.FEET));
                    m.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "generic.armor", 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET));
                    item.setItemMeta(m);
                }
                case GOLDEN_HELMET -> {
                    m.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.03, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HEAD));
                    m.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "generic.armor", 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD));
                    item.setItemMeta(m);
                }
                case GOLDEN_CHESTPLATE -> {
                    m.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.08, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.CHEST));
                    m.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "generic.armor", 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST));
                    item.setItemMeta(m);
                }
                case GOLDEN_LEGGINGS -> {
                    m.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.06, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.LEGS));
                    m.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "generic.armor", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS));
                    item.setItemMeta(m);
                }
                case GOLDEN_BOOTS -> {
                    m.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.03, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.FEET));
                    m.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "generic.armor", 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET));
                    item.setItemMeta(m);
                }
                case DIAMOND_HELMET -> {
                    m.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.04, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HEAD));
                    m.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "generic.armor", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD));
                    m.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD));
                    item.setItemMeta(m);
                }
                case DIAMOND_CHESTPLATE -> {
                    m.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.09, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.CHEST));
                    m.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "generic.armor", 6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST));
                    m.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST));
                    item.setItemMeta(m);
                }
                case DIAMOND_LEGGINGS -> {
                    m.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.08, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.LEGS));
                    m.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "generic.armor", 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS));
                    m.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS));
                    item.setItemMeta(m);
                }
                case DIAMOND_BOOTS -> {
                    m.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.04, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.FEET));
                    m.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "generic.armor", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET));
                    m.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET));
                    item.setItemMeta(m);
                }
                case NETHERITE_HELMET -> {
                    m.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.05, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HEAD));
                    m.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "generic.armor", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD));
                    m.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD));
                    m.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 0.1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD));
                    item.setItemMeta(m);
                }
                case NETHERITE_CHESTPLATE -> {
                    m.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.1, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.CHEST));
                    m.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "generic.armor", 8, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST));
                    m.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST));
                    m.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 0.1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST));
                    item.setItemMeta(m);
                }
                case NETHERITE_LEGGINGS -> {
                    m.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.09, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.LEGS));
                    m.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "generic.armor", 6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS));
                    m.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS));
                    m.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 0.1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS));
                    item.setItemMeta(m);
                }
                case NETHERITE_BOOTS -> {
                    m.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.06, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.FEET));
                    m.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "generic.armor", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET));
                    m.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET));
                    m.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 0.1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET));
                    item.setItemMeta(m);
                }
            }
            switch (e.getSlotType()){
                case FEET:
                    e.getPlayer().getInventory().setBoots(item);
                    return;
                case LEGS:
                    e.getPlayer().getInventory().setLeggings(item);
                    return;
                case CHEST:
                    e.getPlayer().getInventory().setChestplate(item);
                    return;
                case HEAD:
                    e.getPlayer().getInventory().setHelmet(item);
                    return;

            }
        }
    }



}
