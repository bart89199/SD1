package sd.sd.species;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import sd.sd.SD;

import java.util.List;


public class SpecieListener implements Listener {

        @EventHandler
        public void onJoin(PlayerJoinEvent e) {
            if (SD.isHub) return;
//            if (e.getPlayer().getName().equalsIgnoreCase("BATR_PRO")) return;
            Species s = Species.getSpecie(e.getPlayer());
            if (s != null) {

                Bukkit.getScheduler().scheduleSyncDelayedTask(SD.getInstance(), () -> {
                    s.addEffectsTo(e.getPlayer());
                    s.addAttributesTo(e.getPlayer());
                }, 10);

            }

        }

        @EventHandler
        public void onClickBlocks(PlayerInteractEvent e) {
            if (SD.isHub) return;
//            if (e.getPlayer().getName().equalsIgnoreCase("BATR_PRO")) return;
            Species s = Species.getSpecie(e.getPlayer());


            if (s == null) return;

            if (e.getClickedBlock() != null && e.getAction().isRightClick()) {

                switch (e.getClickedBlock().getType()) {
                    case ENCHANTING_TABLE -> {
                        if (!s.hasEnchantingBlockUse()) e.setCancelled(true);
                    }
                    case SMITHING_TABLE -> {
                        if (!s.hasSmithingTable()) e.setCancelled(true);
                    }
                    case GRINDSTONE -> {
                        if (!s.hasGrindstoneUse()) e.setCancelled(true);
                    }
                    case ANVIL, CHIPPED_ANVIL, DAMAGED_ANVIL -> {
                        if (!s.hasAnvilUse()) e.setCancelled(true);
                    }
                    case BREWING_STAND -> {
                        if (!s.hasBrewingStandUse()) e.setCancelled(true);
                    }
                    case BEACON -> {
                        if (!s.hasBeaconUse()) e.setCancelled(true);
                    }
                    case CARTOGRAPHY_TABLE -> {
                        if (!s.hasCartographyTableUse()) e.setCancelled(true);
                    }
                    case LOOM -> {
                        if (!s.hasLoomUse()) e.setCancelled(true);
                    }

                }

            }

        }

        @EventHandler
        public void onDead(PlayerRespawnEvent e) {
            if (SD.isHub) return;
//            if (e.getPlayer().getName().equalsIgnoreCase("BATR_PRO")) return;
            Species s = Species.getSpecie(e.getPlayer());
            if (s != null) {

                Bukkit.getScheduler().scheduleSyncDelayedTask(SD.getInstance(), () -> {
                    s.addEffectsTo(e.getPlayer());
                    s.addAttributesTo(e.getPlayer());
                }, 10);

            }

        }
        @EventHandler
        public void onCraft(CraftItemEvent e) {
            if (SD.isHub) return;
//            if (((Player) e.getView().getPlayer()).getName().equalsIgnoreCase("BATR_PRO")) return;

            if (e.getInventory().getResult() == null) return;
            e.setCancelled(checkCraftAces(e.getInventory().getResult(), (Player) e.getView().getPlayer()));


        }

        @EventHandler
        public void onCraft(PrepareItemCraftEvent e) {
//            if (((Player) e.getView().getPlayer()).getName().equalsIgnoreCase("BATR_PRO")) return;
            if (SD.isHub) return;
            if (e.getInventory().getResult() == null) return;
            if (e.getRecipe() != null)
                if (checkCraftAces(e.getInventory().getResult(), (Player) e.getView().getPlayer())) {
                    e.getInventory().setResult(new ItemStack(Material.AIR));
                }
        }

        public boolean checkCraftAces(ItemStack itemStack, Player p){
            Species specie = Species.getSpecie(p);
            for(SpecieItems item : SpecieItems.values()) {
                List<ItemStack> list = List.of(item.getItem());
                if(list.contains(itemStack)) {
                    for (SpecieItems i : specie.getItems()) {
                        List<ItemStack> l = List.of(i.getItem());
                        if (l.contains(itemStack)){
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;

        }
//        @EventHandler
//        public void onCraft(CraftItemEvent e) {
//            if (SD.isHub) return;
//            if (((Player) e.getView().getPlayer()).getName().equalsIgnoreCase("BATR_PRO")) return;
//
//            if (e.getInventory().getResult() == null) return;
//            if (e.getRecipe() instanceof ShapedRecipe)
//                e.setCancelled(checkCraftAces(e.getInventory().getResult().getType(), ((ShapedRecipe) e.getRecipe()).getKey().getKey(), (Player) e.getView().getPlayer()));
//
//        }
//
//        @EventHandler
//        public void onCraft(PrepareItemCraftEvent e) {
//            if (((Player) e.getView().getPlayer()).getName().equalsIgnoreCase("BATR_PRO")) return;
//            if (SD.isHub) return;
//            if (e.getInventory().getResult() == null) return;
//            if (e.getRecipe() != null && e.getRecipe() instanceof ShapedRecipe)
//                if (checkCraftAces(e.getInventory().getResult().getType(), ((ShapedRecipe) e.getRecipe()).getKey().getKey(), (Player) e.getView().getPlayer())) {
//                    e.getInventory().setResult(new ItemStack(Material.AIR));
//                }
//
//        }
//
//        public boolean checkCraftAces(Material material, String key, Player p) {
//            switch (material) {
//                case DIAMOND_SWORD, DIAMOND_AXE, NETHERITE_INGOT, DIAMOND_PICKAXE,
//                        DIAMOND_SHOVEL, DIAMOND_HOE, DIAMOND_BLOCK, JUKEBOX -> {
//                    return checkCraftPerm(p, "all_diamond");
//                }
//                case CYAN_DYE -> {
//                    if (key.equalsIgnoreCase("diamond_plastina")) {
//                        return checkCraftPerm(p, "all_diamond");
//                    }
//                }
//                case IRON_HELMET, IRON_CHESTPLATE, IRON_LEGGINGS, IRON_BOOTS, GOLDEN_HELMET, GOLDEN_CHESTPLATE, GOLDEN_LEGGINGS, GOLDEN_BOOTS, DIAMOND_BOOTS, DIAMOND_LEGGINGS,
//                        DIAMOND_CHESTPLATE, DIAMOND_HELMET, NETHERITE_HELMET, NETHERITE_CHESTPLATE, NETHERITE_LEGGINGS, NETHERITE_BOOTS -> {
//
//                    switch (material) {
//                        case DIAMOND_BOOTS, DIAMOND_LEGGINGS, DIAMOND_CHESTPLATE, DIAMOND_HELMET -> {
//                            if (checkCraftPerm(p, "all_diamond")) {
//                                return true;
//                            } else if (key.contains("plastina")) {
//                                return checkCraftPerm(p, "plastina_armor");
//                            }
//                        }
//                        default -> {
//
//                            if (key.contains("plastina")) {
//
//                                return checkCraftPerm(p, "plastina_armor");
//
//                            }
//                        }
//                    }
//                }
//                case DISPENSER, DROPPER, REPEATER, REDSTONE_TORCH,
//                        REDSTONE_BLOCK, PISTON, POWERED_RAIL, COMPASS,
//                        CLOCK, TARGET -> {
//
//                    return checkCraftPerm(p, "all_red_stone");
//
//                }
//
//            }
//            return false;
//        }
//
//        public boolean checkCraftPerm(Player p, String category) {
//            Specie s = Specie.getSpecie(p);
//
//            if (s == null || s.getKeysOfCrafts() == null) return true;
//
//            for (String key : s.getKeysOfCrafts()) {
//
//                if (key.equalsIgnoreCase(category)) return false;
//
//            }
//
//            return true;
//        }


        @EventHandler
        public void onEating(PlayerItemConsumeEvent e) {
            if (SD.isHub) return;
//            if (e.getPlayer().getName().equalsIgnoreCase("BATR_PRO")) return;

            Species s = Species.getSpecie(e.getPlayer());
            if (s != null) {

                Bukkit.getScheduler().scheduleSyncDelayedTask(SD.getInstance(), () -> {
                    s.addEffectsTo(e.getPlayer());
                    s.addAttributesTo(e.getPlayer());
                }, 10);

            }
            if (s == null) return;

            if (s.equals(Species.ЗВЕРОЛЮДИ) || s.equals(Species.ДРАКОНИДЫ)) {
                switch (e.getItem().getType()) {
                    case ROTTEN_FLESH, CHICKEN -> {
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SD.getInstance(), () -> {
                            e.getPlayer().removePotionEffect(PotionEffectType.HUNGER);
                        }, 6);
                    }
                }
            }

//        if(getSpecie(e.getPlayer()).equals(Species.Дворфы)){
//            e.getPlayer().removePotionEffect(PotionEffectType.POISON);
//        }

        }


        @EventHandler
        public void onSwim(PlayerMoveEvent e) {
            if (SD.isHub) return;
//            if (e.getPlayer().getName().equalsIgnoreCase("BATR_PRO")) return;
            Species s = Species.getSpecie(e.getPlayer());
            if (s == null) return;

            if (s.equals(Species.ДЕМОНЫ) && e.getPlayer().isInWater()) {
                if(SD.playersSpecies.get(e.getPlayer().getName()).edited.containsKey("noWaterDamage")) return;
                if (!e.getPlayer().hasPotionEffect(PotionEffectType.WITHER)) {
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 7 * 20, 1));
                }
            }
        }
//    @EventHandler
//    public void onPoison(PotionSplashEvent e){
//        if(e.getPotion().getPotionMeta().get)
//        for(Entity entity : e.getAffectedEntities()) {
//
//            if(entity instanceof Player p) {
//
//                if (getSpecie(p).equals(Species.Дворфы)) {
//                    p.removePotionEffect(PotionEffectType.POISON);
//                }
//            }
//        }
//    }

        @EventHandler
        public void onDamage(EntityDamageEvent e) {
            if (SD.isHub) return;

            if (e.getEntity() instanceof Player p) {

//                if (p.getName().equalsIgnoreCase("BATR_PRO")) return;

                Species s = Species.getSpecie(p);
                if (s == null) return;
                if (e.getCause().equals(EntityDamageEvent.DamageCause.FALL) && (s.equals(Species.СЛАЙМЫ))) {
                    e.setDamage(e.getDamage() - e.getDamage() * 0.5);
                }

                if (e.getCause().equals(EntityDamageEvent.DamageCause.POISON) && s.equals(Species.ДВОРФЫ)) {
                    p.removePotionEffect(PotionEffectType.POISON);
                    e.setCancelled(true);
                }

                if (s.equals(Species.ДЕМОНЫ) && p.isInWater()) {
                    if(SD.playersSpecies.get(p.getName()).edited.containsKey("noWaterDamage")) return;
                    p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 5 * 20, 1));
                }

            }

        }


    }

