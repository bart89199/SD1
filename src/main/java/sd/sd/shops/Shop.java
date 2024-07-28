package sd.sd.shops;

import org.bukkit.Location;
import org.bukkit.block.Barrel;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import sd.sd.SD;

import java.util.*;

public class Shop implements ConfigurationSerializable {

    private UUID id;
    private String name;
    private Location start;
    private Location end;
    private Location get;
    private Location put;
    private ItemStack[] items;
    private UUID[] armorStands;



    public Shop(String name, Location start, Location end, Location get, Location put, ItemStack[] items, UUID[] armorStands) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.start = start;
        this.end = end;
        this.get = get;
        this.put = put;
        this.items = items;
        this.armorStands = armorStands;
    }

    public Shop(UUID id, String name, Location start, Location end, Location get, Location put, ItemStack[] items, UUID[] armorStands) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.end = end;
        this.get = get;
        this.put = put;
        this.items = items;
        this.armorStands = armorStands;
    }

    public Shop(UUID id, String name, Location start, Location end, Location get, Location put, List<ItemStack> items, List<UUID> armorStands) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.end = end;
        this.get = get;
        this.put = put;

        ItemStack[] its = new ItemStack[items.size()];

        for (int i = 0; i < items.size(); i++) {
            its[i] = items.get(i);
        }

        this.items = its;

        UUID[] uuids = new UUID[armorStands.size()];

        for (int i = 0; i < armorStands.size(); i++) {
            uuids[i] = armorStands.get(i);
        }

        this.armorStands = uuids;
    }

    public UUID getId() {
        return id;
    }

    public ItemStack[] getItems() {
        return items;
    }

    public void setItems(ItemStack[] items) {
        this.items = items;
    }

    public UUID[] getArmorStands() {
        return armorStands;
    }

    public void setArmorStands(UUID[] armorStands) {
        this.armorStands = armorStands;
    }

    public Barrel getPutBarrel(){

        return (Barrel) put.getWorld().getBlockAt(put).getState();

    }

    public Barrel getGetBarrel(){

        return (Barrel) get.getWorld().getBlockAt(get).getState();

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStart(Location start) {
        this.start = start;
    }

    public void setEnd(Location end) {
        this.end = end;
    }

    public void setGet(Location get) {
        this.get = get;
    }

    public void setPut(Location put) {
        this.put = put;
    }



    public String getName() {
        return name;
    }

    public Location getStart() {
        return start;
    }

    public Location getEnd() {
        return end;
    }

    public Location getGet() {
        return get;
    }

    public Location getPut() {
        return put;
    }



    @Override
    public @NotNull Map<String, Object> serialize() {
        Map<String, Object> data = new HashMap<String, Object>();

        data.put("id", this.id);
        data.put("name", this.name);
        data.put("shopStart", this.start);
        data.put("shopEnd", this.end);
        data.put("getBarrel", this.get);
        data.put("putBarrel", this.put);
        data.put("shopItems", this.items);
        data.put("armorStands", this.armorStands);

        return data;
    }

    @NotNull
    public static Shop deserialize(@NotNull Map<String, Object> args) {


        List<?> list = (List<?>) args.get("shopItems");

        List<ItemStack> shopItems = new ArrayList<>();
        if (!list.isEmpty()) {




            for (Object o : list) {

                if (o instanceof ItemStack i) {

                    shopItems.add(i);

                }
            }


        }

        list = (List<?>) args.get("armorStands");
        List<UUID> armorStands = new ArrayList<>();
        if (!list.isEmpty()) {




            for (Object o : list) {

                if (o instanceof UUID u) {

                    armorStands.add(u);

                }
            }


        }

        return new Shop((UUID) args.get("id"), (String) args.get("name"), (Location) args.get("shopStart"), (Location) args.get("shopEnd"), (Location) args.get("getBarrel"),
                (Location) args.get("putBarrel"),  shopItems, armorStands);
    }

    public static class ShopListener implements Listener {

        @EventHandler
        public void onClick(PlayerArmorStandManipulateEvent e) {

            ArmorStand en = e.getRightClicked();
            Player p = e.getPlayer();
            UUID id = en.getUniqueId();

            if(SD.shops == null || SD.shops.isEmpty()) return;

            for (Shop shop : SD.shops) {

                if(shop.getArmorStands() == null || shop.getArmorStands().length == 0) continue;

                for (UUID shopId : shop.getArmorStands()) {

                    if (id.equals(shopId)) {


                        if(!e.getPlayerItem().getType().isEmpty()) {
                            e.setCancelled(true);
                            return;
                        }

                        if(e.getArmorStandItem().getType().isEmpty()){
                            e.setCancelled(true);
                            return;
                        }



                    }

                }
            }

        }

    }

}
