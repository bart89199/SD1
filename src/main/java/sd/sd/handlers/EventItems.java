package sd.sd.handlers;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import sd.sd.SD;

import java.util.*;

import static org.bukkit.event.block.Action.RIGHT_CLICK_AIR;
import static org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK;

public class EventItems implements Listener {


    private SD plugin;

    public EventItems(SD plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onTimer(PlayerArmorChangeEvent e) {
        Player p = e.getPlayer();
        ItemStack helmet = e.getNewItem();
        assert helmet != null;
        if (helmet.getType().equals(Material.SKELETON_SKULL)) if (helmet.getItemMeta().getDisplayName().equalsIgnoreCase("§9Голова охотника за головами")) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 99999, 2));
                p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999, 1));
        }
        if (helmet.getType().equals(Material.SKELETON_SKULL)) if (helmet.getItemMeta().getDisplayName().equalsIgnoreCase("§9Голова охотника за головами")) {
                p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
                p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
        }
        if(e.getNewItem().getType() == Material.JACK_O_LANTERN) {
            if (e.getNewItem().hasItemMeta()) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 99999, 1));
            }
        }
        if(Objects.requireNonNull(e.getOldItem()).getType() == Material.JACK_O_LANTERN) {
            if (e.getOldItem().hasItemMeta()) {
                p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
            }
        }
        if (helmet.getType().equals(Material.CHAINMAIL_CHESTPLATE)) if (helmet.getItemMeta().getDisplayName().equalsIgnoreCase("§5Одежда мага")) {
            if (e.getNewItem().hasItemMeta()) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 2));
            }
        }
        if (helmet.getType().equals(Material.CHAINMAIL_CHESTPLATE)) if (helmet.getItemMeta().getDisplayName().equalsIgnoreCase("§5Одежда мага")) {
                p.removePotionEffect(PotionEffectType.SPEED);
        }
    }



    @EventHandler
    public void onTimer(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        ItemStack helmet = p.getInventory().getHelmet();
         {
            if(!(helmet == null)) {
                if (helmet.getType().equals(Material.JACK_O_LANTERN)) {
                    if (Objects.requireNonNull(p.getInventory().getHelmet()).hasItemMeta()) {
                        p.spawnParticle(Particle.SOUL, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 2, 0.001, 1, 0, 1);
                    }
                }
                if (helmet.getType().equals(Material.CHAINMAIL_CHESTPLATE)) if (helmet.getItemMeta().getDisplayName().equalsIgnoreCase("§5Одежда мага")) {
                        //PlayEffect.play(VisualEffect.<effect>, <location>, <параметры>);
                        //ParticleBuilder(Particle.SOUL, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 2);
                        p.spawnParticle(Particle.END_ROD, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 2, 0.001, 1, 0, 1);

                }
            }
        }
    }

    @EventHandler
    public void onTimer(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Action a = e.getAction();
        ItemStack i = new ItemStack(Material.AIR);
        if(a == RIGHT_CLICK_AIR || a == RIGHT_CLICK_BLOCK) {
            if(p.getInventory().getItemInMainHand().getType().equals(Material.ORANGE_DYE)) if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lTrick or Treat")){
                    if(!(p.getInventory().getItemInMainHand().getAmount() == 1)) {
                        p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount() - 1);
                    }else {
                        p.getInventory().setItemInMainHand(i);
                    }

                AttributeModifier s;

                    ItemStack tr_n = new ItemStack(Material.GRAY_DYE);
                ItemMeta mn = tr_n.getItemMeta();
                mn.setDisplayName("§4Не повезло");
                List<String> l = new ArrayList<>();
                l.add("§7Использованый Trick or Treat");
                mn.setLore(l);
                tr_n.setItemMeta(mn);

                ItemStack tr_far = new ItemStack(Material.GREEN_DYE);
                ItemMeta mf = tr_far.getItemMeta();
                mf.setDisplayName("§2Повезло");
                mf.setLore(l);
                tr_far.setItemMeta(mf);

                ItemStack tr_vf = new ItemStack(Material.PURPLE_DYE);
                ItemMeta mv = tr_vf.getItemMeta();
                mv.setDisplayName("§5Очень повезло");
                mv.setLore(l);
                tr_vf.setItemMeta(mv);

                ItemStack tr_nd = new ItemStack(Material.LIGHT_GRAY_DYE);
                ItemMeta md = tr_nd.getItemMeta();
                md.setDisplayName("§6Ну хотябы не убило...");
                md.setLore(l);
                tr_nd.setItemMeta(md);

                ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                ItemMeta m;
                m = chestplate.getItemMeta();
                l = new ArrayList<>();
                m.setDisplayName("§5Одежда мага");
                s = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.2f, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.CHEST);
                m.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, s);
                m.addEnchant(Enchantment.DURABILITY, 4, true);
                m.addEnchant(Enchantment.THORNS, 4, true);
                m.addEnchant(Enchantment.PROTECTION_PROJECTILE, 5, true);
                m.addEnchant(Enchantment.PROTECTION_FIRE, 4, true);
                m.setLore(l);
                chestplate.setItemMeta(m);

                ItemStack skull = new ItemStack(Material.SKELETON_SKULL);
                m = skull.getItemMeta();
                l = new ArrayList<>();
                m.setDisplayName("§9Голова охотника за головами");
                m.setLore(l);
                chestplate.setItemMeta(m);


                ItemStack hoe = new ItemStack(Material.DIAMOND_HOE);
                m = hoe.getItemMeta();
                l = new ArrayList<>();
                m.setDisplayName("§5Срезатель голов");
                m.addEnchant(Enchantment.KNOCKBACK, 4, true);
                m.addEnchant(Enchantment.DAMAGE_ALL, 6, true);
                m.addEnchant(Enchantment.MENDING, 5, true);
                m.addEnchant(Enchantment.LOOT_BONUS_MOBS, 4, true);
                s = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1f, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HAND);
                m.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, s);
                m.setLore(l);
                hoe.setItemMeta(m);

                ItemStack coin = new ItemStack(Material.PRISMARINE_SHARD);
                m = coin.getItemMeta();
                m.setCustomModelData(5);
                m.setDisplayName(ChatColor.GOLD + "Перво проходец");
                l = new ArrayList<>();
                l.add(ChatColor.YELLOW + "Это уникальный предмет");
                l.add(ChatColor.YELLOW + "С открытия сервера");
                m.setLore(l);
                coin.setItemMeta(m);

        //            String f = " minecraft:gray_dye{display:{Name:'{\"text\":\"Trick or Treat не повезло\",\"color\":\"#e01010\",\"bold\":true}',Lore:['{\"text\":\"Использованный Helloween Trick or Treat\",\"color\":\"#4d2e07\",\"underlined\":false,\"bold\":true}']}}";
          //          String l = " minecraft:gray_dye{display:{Name:'{\"text\":\"Trick or Treat повезло\",\"color\":\"#34cf23\",\"bold\":true}',Lore:['{\"text\":\"Использованный Helloween Trick or Treat\",\"color\":\"#4d2e07\",\"underlined\":false,\"bold\":true}']}}";
          //          String lp = " minecraft:gray_dye{display:{Name:'{\"text\":\"Trick or Treat очень повезло\",\"color\":\"#65ff54\",\"bold\":true}',Lore:['{\"text\":\"Использованный Helloween Trick or Treat\",\"color\":\"#4d2e07\",\"underlined\":false,\"bold\":true}']}}";
          //          String q = " minecraft:gray_dye{display:{Name:'{\"text\":\"Trick or Treat ну хоть не убило..\",\"color\":\"#ba9718\",\"bold\":true}',Lore:['{\"text\":\"Использованный Helloween Trick or Treat\",\"color\":\"#4d2e07\",\"underlined\":false,\"bold\":true}']}}";
          //          String lpp = " minecraft:gray_dye{display:{Name:'{\"text\":\"Trick or Treat ВАУ как повезло\",\"color\":\"#9b24e0\",\"bold\":true}',Lore:['{\"text\":\"Использованный Helloween Trick or Treat\",\"color\":\"#4d2e07\",\"underlined\":false,\"bold\":true}']}}";
                   // String chainmail_chestplate = " minecraft:chainmail_chestplate{helloween:true,Enchantments:[{id:\"minecraft:unbreaking\",lvl:4},{id:\"minecraft:thorns\",lvl:4},{id:\"minecraft:mending\",lvl:10},{id:\"minecraft:protection\",lvl:5},{id:\"minecraft:fire_protection\",lvl:5}],display:{Name:'{\"text\":\"Helloween Chestplate\",\"color\":\"#a3660a\",\"bold\":true}',Lore:['{\"text\":\"Уникальный предмет с Helloweenа, он даёт интересные вещи\",\"color\":\"#4d2e07\",\"bold\":true}']}}";
                  //  String skeleton_skull = " minecraft:skeleton_skull{display:{Name:'{\"text\":\"Helloween Skull\",\"color\":\"#a3660a\",\"bold\":true}',Lore:['{\"text\":\"Череп helloween монстра. Он обладает волшебными свойствами\",\"color\":\"#4d2e07\"}']}}";
                 //   String diamond_hoe = " minecraft:diamond_hoe{Enchantments:[{id:\"minecraft:unbreaking\",lvl:4},{id:\"minecraft:sharpness\",lvl:6},{id:\"minecraft:mending\",lvl:10},{id:\"minecraft:looting\",lvl:5},{id:\"minecraft:knockback\",lvl:3}],display:{Name:'{\"text\":\"Коса голов\",\"color\":\"#a3660a\",\"bold\":true}',Lore:['{\"text\":\"Оружие охотника за головами\",\"color\":\"#562da8\"}','{\"text\":\"Его можно было приобрести в Helloween\",\"color\":\"#4d2e07\",\"underlined\":false,\"bold\":true}']}}";
                //    String coin = " minecraft:prismarine_shard{display:{Name:'{\"text\":\"Helloween Coin\",\"color\":\"#a3660a\",\"bold\":true}',Lore:['{\"text\":\"Уникальный предмет для торговли с путешественниками на\",\"color\":\"#562da8\"}','{\"text\":\"Helloween\",\"color\":\"#4d2e07\",\"underlined\":true,\"bold\":true}']}}";
                    ItemStack v = new ItemStack(Material.AIR);

                    //   q = q.replace("q", '"');
                    Random random = new Random();
                    int count_sec = random.nextInt(26);
                    //   p.sendMessage(Balt.sd + String.valueOf(count_sec));
                    if(count_sec == 0){
                        p.getWorld ().dropItem (p.getLocation(), tr_n);
                        p.sendMessage(SD.prefix + ChatColor.RED + " Тебе не повезло, ты умер");
                        p.setHealth(0);
                        p.spawnParticle(Particle.CRIT, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 40, 0.001, 1, 0, 5);
                    }
                    if(count_sec == 1){
                        p.getWorld ().dropItem (p.getLocation(), tr_far);
                        p.sendMessage(SD.prefix + ChatColor.GREEN + " Вау! Вот это везение!");
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack( Material.DIAMOND, 16));
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack( Material.JACK_O_LANTERN, 4));
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack( Material.PUMPKIN_SEEDS, 16));
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack( Material.PUMPKIN_PIE, 5));
                        p.spawnParticle(Particle.NOTE, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 40, 0.001, 1, 0, 5);
                    }
                    if(count_sec == 2){
                        p.getWorld ().dropItem (p.getLocation(), tr_far);
                        p.sendMessage(SD.prefix + ChatColor.RED + " Ой-ой-ой! Чуть не умер!");
                        p.setHealth(1);
                        p.spawnParticle(Particle.SPIT, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 40, 0.001, 1, 0, 5);
                    }
                    if(count_sec == 3){
                        p.getWorld ().dropItem (p.getLocation(), tr_nd);
                        p.sendMessage(SD.prefix + ChatColor.BLUE + " Вот блин весь инвентарь засорили...");
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack( Material.COBBLESTONE, 800));
                        p.spawnParticle(Particle.ENCHANTMENT_TABLE, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 40, 0.001, 1, 0, 5);
                    }
                    if(count_sec == 4){
                        p.getWorld ().dropItem (p.getLocation(), tr_far);
                        p.sendMessage(SD.prefix + ChatColor.LIGHT_PURPLE + " Спасибо за сладости!");
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack( Material.PUMPKIN_PIE, 4));
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack( Material.CAKE, 6));
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack(Material.COOKIE, 8));
                        p.spawnParticle(Particle.END_ROD, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 40, 0.001, 1, 0, 5);
                    }
                    if(count_sec == 5){
                        p.getWorld ().dropItem (p.getLocation(), tr_n);
                        p.sendMessage(SD.prefix + ChatColor.RED + " Ой а куда оно делось...");
                        p.spawnParticle(Particle.ENCHANTMENT_TABLE, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 40, 0.001, 1, 0, 5);
                        int item = random.nextInt(36) + 1;
                        if(!Objects.requireNonNull(p.getInventory().getItem(item)).getType().isAir()) {
                            p.getInventory().setItem(item, new ItemStack(Material.AIR));
                            return;
                        }
                        int item1 = random.nextInt(36) + 1;
                        if(!Objects.requireNonNull(p.getInventory().getItem(item1)).getType().isAir()) {
                            p.getInventory().setItem(item1, new ItemStack(Material.AIR));
                            return;
                        }
                        int item2 = random.nextInt(36) + 1;
                        if(!Objects.requireNonNull(p.getInventory().getItem(item2)).getType().isAir()) {
                            p.getInventory().setItem(item2, new ItemStack(Material.AIR));
                            return;
                        }
                        int item3 = random.nextInt(36) + 1;
                        if(!Objects.requireNonNull(p.getInventory().getItem(item3)).getType().isAir()) {
                            p.getInventory().setItem(item3, new ItemStack(Material.AIR));
                            return;
                        }
                        p.sendMessage(SD.prefix + ChatColor.GREEN + "Тебе повезло, вещь не пропала!");
                    }
                    if(count_sec == 6){
                        p.getWorld ().dropItem (p.getLocation(), tr_vf);
                        p.sendMessage(SD.prefix + ChatColor.DARK_PURPLE + " Вау! Как раз собирался купить");
                        p.getWorld ().dropItem (p.getLocation(), chestplate);
                        p.spawnParticle(Particle.SOUL, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 15, 0.001, 1, 0, 1);
                    }
                    if(count_sec == 7){
                        p.getWorld ().dropItem (p.getLocation(), tr_vf);
                        p.sendMessage(SD.prefix + ChatColor.GREEN + " Незнал, что люди бывают столь дружелюбными!");
                        p.setHealth(35);
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack( Material.PUMPKIN_PIE, 4));
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack( Material.CAKE, 6));
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack( Material.COOKIE, 8));
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack( Material.DIAMOND, 16));
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack( Material.NETHERITE_SCRAP, 3));
                        p.spawnParticle(Particle.HEART, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 15, 0.001, 1, 0, 1);
                    }
                    if(count_sec == 8){
                        p.getWorld ().dropItem (p.getLocation(), skull);
                        p.spawnParticle(Particle.FIREWORKS_SPARK, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 15, 0.001, 1, 0, 1);
                        p.sendMessage(SD.prefix + ChatColor.YELLOW + " Недумал что ещё смогу получить!");
                        p.getWorld ().dropItem (p.getLocation(), tr_vf);
                    }
                    if(count_sec == 9){
                        p.getWorld ().dropItem (p.getLocation(), tr_n);
                        int item = random.nextInt(36) + 1;
                        p.getInventory().setItem(item, new ItemStack(Material.PAPER));
                        p.sendMessage(SD.prefix + ChatColor.DARK_BLUE + " Откуда эта бумажка и где моя кирка?!");
                        p.spawnParticle(Particle.SMOKE_LARGE, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 15, 0.001, 1, 0, 1);
                    }
                    if(count_sec == 10){
                        p.getWorld ().dropItem (p.getLocation(), tr_vf);
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 1));
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack(Material.TOTEM_OF_UNDYING, 2));
                        p.sendMessage(SD.prefix + ChatColor.GOLD + " Опа подгончик!");
                        p.spawnParticle(Particle.TOTEM, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 15, 0.001, 1, 0, 1);

                    }
                    if(count_sec == 11){
                        p.getWorld ().dropItem (p.getLocation(), tr_nd);
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack(Material.SPIDER_EYE, 5));
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack(Material.PUFFERFISH, 2));
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack(Material.POISONOUS_POTATO, 3));
                        p.sendMessage(SD.prefix + ChatColor.DARK_RED + " Фу! Это же несъедобно!");
                        p.spawnParticle(Particle.FALLING_HONEY, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 15, 0.001, 1, 0, 1);
                    }
                    if(count_sec == 12){
                        p.getWorld ().dropItem (p.getLocation(), hoe);
                        p.spawnParticle(Particle.FLASH, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 15, 0.001, 1, 0, 1);
                        p.sendMessage(SD.prefix + ChatColor.GOLD + " А говорили что я щанс упустил!");
                        p.getWorld ().dropItem (p.getLocation(), tr_vf);
                    }
                    if(count_sec == 13){
                        p.spawnParticle(Particle.VILLAGER_ANGRY, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 15, 0.001, 1, 0, 1);
                        p.sendMessage(SD.prefix + ChatColor.GOLD + " Пусто лучше чем смерть");
                        p.getWorld ().dropItem (p.getLocation(), tr_nd);
                    }
                    if(count_sec == 14){
                        p.spawnParticle(Particle.CAMPFIRE_COSY_SMOKE, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 15, 0.001, 1, 0, 1);
                        p.sendMessage(SD.prefix + ChatColor.GOLD + " Ой-ой-ой! Всё рассыпалось!");
                        p.getWorld ().dropItem (p.getLocation(), tr_nd);
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(1)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(2)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(3)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(4)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(5)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(6)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(7)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(8)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(9)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(10)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(11)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(12)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(13)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(14)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(15)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(16)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(17)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(18)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(19)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(20)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(21)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(22)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(23)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(24)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(25)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(26)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(27)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(28)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(29)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(30)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(31)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(32)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(33)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(34)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(35)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItem(36)));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getHelmet()));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getBoots()));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getChestplate()));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getLeggings()));
                        p.getWorld ().dropItem (p.getLocation(), Objects.requireNonNull(p.getInventory().getItemInOffHand()));

                        p.getInventory().clear();

                    }
                    if(count_sec == 15){
                        p.getWorld ().dropItem (p.getLocation(), coin);
                        p.spawnParticle(Particle.FLASH, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 15, 0.001, 1, 0, 1);
                        p.sendMessage(SD.prefix + ChatColor.GREEN + " О возврат оформили!");
                        p.getWorld ().dropItem (p.getLocation(), tr_vf);
                    }
                    if(count_sec == 16){
                        int armor = random.nextInt(5);
                        if(armor == 0){
                            p.getInventory().setItemInOffHand(new ItemStack(Material.AIR));
                            p.sendMessage(SD.prefix + ChatColor.RED + " Куда пропал мой тотем из левой руки?");
                            p.spawnParticle(Particle.LAVA, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 15, 0.001, 1, 0, 1);
                            p.getWorld ().dropItem (p.getLocation(), tr_nd);
                        }
                        if(armor == 1){
                            p.getInventory().setBoots(new ItemStack(Material.AIR));
                            p.sendMessage(SD.prefix + ChatColor.RED + " Куда пропали мои ботинки?");
                            p.spawnParticle(Particle.LAVA, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 15, 0.001, 1, 0, 1);
                            p.getWorld ().dropItem (p.getLocation(), tr_nd);
                        }
                        if(armor == 2){
                            p.getInventory().setLeggings(new ItemStack(Material.AIR));
                            p.sendMessage(SD.prefix + ChatColor.RED + " Где мои кожаные штаны?!");
                            p.spawnParticle(Particle.LAVA, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 15, 0.001, 1, 0, 1);
                            p.getWorld ().dropItem (p.getLocation(), tr_nd);
                        }
                        if(armor == 3){
                            p.getInventory().setChestplate(new ItemStack(Material.AIR));
                            p.sendMessage(SD.prefix + ChatColor.RED + " Непонял, сначала кирку, а теперь нагрудник?!?");
                            p.spawnParticle(Particle.LAVA, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 15, 0.001, 1, 0, 1);
                            p.getWorld ().dropItem (p.getLocation(), tr_nd);
                        }
                        if(armor == 4){
                            p.getInventory().setHelmet(new ItemStack(Material.AIR));
                            p.sendMessage(SD.prefix + ChatColor.RED + " Ну это край.. Это моя любимая тыква!");
                            p.spawnParticle(Particle.LAVA, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 15, 0.001, 1, 0, 1);
                            p.getWorld ().dropItem (p.getLocation(), tr_nd);
                        }
                    }
                    if(count_sec == 17){
                        p.sendMessage(SD.prefix + ChatColor.RED + " А если админ спалит...");
                        p.spawnParticle(Particle.SOUL_FIRE_FLAME, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 15, 0.001, 1, 0, 1);
                        p.getWorld ().dropItem (p.getLocation(), tr_vf);
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack(Material.ZOMBIE_HORSE_SPAWN_EGG));
                    }
                    if(count_sec == 18){
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack(Material.SPIDER_EYE, 5));
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack(Material.PUFFERFISH, 2));
                        p.getWorld ().spawnEntity (p.getLocation(), EntityType.BEE);
                        p.getWorld ().spawnEntity (p.getLocation(), EntityType.BEE);
                        p.getWorld ().spawnEntity (p.getLocation(), EntityType.BEE);
                        p.getWorld ().spawnEntity (p.getLocation(), EntityType.RABBIT);
                        p.getWorld ().spawnEntity (p.getLocation(), EntityType.RABBIT);
                        p.sendMessage(SD.prefix + ChatColor.AQUA + " Милашки!");
                        p.spawnParticle(Particle.CLOUD, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 15, 0.001, 1, 0, 1);
                        p.getWorld ().dropItem (p.getLocation(), tr_far);
                    }
                    if(count_sec == 19){
                        p.spawnParticle(Particle.DOLPHIN, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 40, 0.001, 1, 0, 5);
                        p.getWorld ().dropItem (p.getLocation(), tr_nd);
                        p.sendMessage(SD.prefix + ChatColor.GRAY + " И что теперь мне с этим делать?");
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack(Material.GLOBE_BANNER_PATTERN));
                    }
                    if(count_sec == 20){
                        p.getWorld ().dropItem (p.getLocation(), tr_n);
                        p.sendMessage(SD.prefix + ChatColor.RED + " Аааа!!!");
                        p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20, 2));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20, 255));
                        p.getWorld ().spawnEntity (p.getLocation(), EntityType.ZOMBIE);
                        p.getWorld ().spawnEntity (p.getLocation(), EntityType.ZOMBIE);
                        p.getWorld ().spawnEntity (p.getLocation(), EntityType.ZOMBIE);
                        p.spawnParticle(Particle.DOLPHIN, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 40, 0.001, 1, 0, 5);
                    }
                    if(count_sec == 21){
                        p.getWorld ().dropItem (p.getLocation(), tr_far);
                        p.sendMessage(SD.prefix + ChatColor.LIGHT_PURPLE + " Спасибо за сладости!");
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack( Material.PUMPKIN_PIE, 4));
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack( Material.CAKE, 6));
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack(Material.COOKIE, 8));
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack(Material.GOLDEN_APPLE, 8));
                        p.spawnParticle(Particle.END_ROD, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 40, 0.001, 1, 0, 5);
                    }
                    if(count_sec == 22){
                        p.getWorld ().dropItem (p.getLocation(), tr_far);
                        p.sendMessage(SD.prefix + ChatColor.LIGHT_PURPLE + " Спасибо за сладости!");
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack( Material.PUMPKIN_PIE, 4));
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack( Material.CAKE, 6));
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack(Material.COOKIE, 8));
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack(Material.GOLDEN_CARROT, 8));
                        p.spawnParticle(Particle.END_ROD, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 40, 0.001, 1, 0, 5);
                    }
                    if(count_sec == 23){
                        p.getWorld ().dropItem (p.getLocation(), tr_far);
                        p.sendMessage(SD.prefix + ChatColor.LIGHT_PURPLE + " Спасибо за сладости!");
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack( Material.PUMPKIN_PIE, 4));
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack( Material.CAKE, 6));
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack(Material.COOKIE, 8));
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack(Material.DIAMOND, 3));
                        p.spawnParticle(Particle.END_ROD, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 40, 0.001, 1, 0, 5);
                    }
                    if(count_sec == 24){
                        p.getWorld ().dropItem (p.getLocation(), tr_vf);
                        p.sendMessage(SD.prefix + ChatColor.GREEN + " Незнал, что люди бывают столь дружелюбными!");
                        p.setHealth(35);
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack( Material.PUMPKIN_PIE, 4));
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack( Material.CAKE, 6));
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack( Material.COOKIE, 8));
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack( Material.DIAMOND, 16));
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack( Material.NETHERITE_SCRAP, 3));
                        p.spawnParticle(Particle.HEART, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 15, 0.001, 1, 0, 1);
                    }
                    if(count_sec == 25){
                        p.getWorld ().dropItem (p.getLocation(), tr_nd);
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack(Material.SPIDER_EYE, 5));
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack(Material.PUFFERFISH, 2));
                        p.getWorld ().dropItem (p.getLocation(), new ItemStack(Material.POISONOUS_POTATO, 3));
                        p.sendMessage(SD.prefix + ChatColor.DARK_RED + " Фу! Это же несъедобно!");
                        p.spawnParticle(Particle.FALLING_HONEY, p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 15, 0.001, 1, 0, 1);
                    }

            }
            if(a.equals(RIGHT_CLICK_AIR)) {
                if (p.getInventory().getItemInMainHand().getType() == Material.JACK_O_LANTERN) {
                    ItemStack k = p.getInventory().getItemInMainHand();
                    ItemStack old = p.getInventory().getHelmet();
                    p.getInventory().setHelmet(k);
                    p.getInventory().setItemInMainHand(old);
                }
            }
        }
    }


}
