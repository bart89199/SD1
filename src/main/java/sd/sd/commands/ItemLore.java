package sd.sd.commands;

import com.google.common.collect.Lists;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import sd.sd.SD;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static sd.sd.metods.Lore.CountInstanceOfChar;

public class ItemLore extends AbstractCommand {

    public ItemLore() {
        super("роспись");
    }


    @Override
    public void execute(CommandSender sender, @NotNull Command cmd, String label, String[] args) {
        if(sender instanceof ConsoleCommandSender){
            sender.sendMessage(SD.prefix + " §4Для росписи надо быть игроком");
            return;
        }
        if(sender instanceof Player){
        Player p = Bukkit.getPlayer(sender.getName());
                if (p.getInventory().getItemInMainHand().equals(new ItemStack(Material.AIR)) || p.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
                    sender.sendMessage(SD.prefix + SD.getMessages().getString("Rospise.NoItem"," §4Нет предмета в руке!"));
                } else {
                    if(args.length > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < args.length; i++) sb.append(args[i]).append(' ');
                        String ro = sb.toString();
                        ro = ro.replace("&", "§");
                        int[] slot = new int[2];
                        int g = (new Random().nextInt(10));
                        double dolg = (ro.length()*g);
                        slot[1] = 0;
                        ItemStack item;
                        ItemMeta m;
                        Damageable d;
                        int count = 0;
                        for (ItemStack it : p.getInventory().getContents()) { // проходимся циклом по вещам и обновляем книги
                            count++;
                            if (it == null) continue;
                            if(it.getType().equals(Material.IRON_SWORD) || it.getType().equals(Material.DIAMOND_SWORD) || it.getType().equals(Material.NETHERITE_SWORD)) {
                                    slot[0] = count;
                                    slot[1] = slot[1] + 1;
                                    m = it.getItemMeta();
                                    item = it;
                                    d = ((Damageable) m);
                                    if (!(dolg == 0)) {
                                        if ((it.getType().getMaxDurability() - d.getDamage()) < dolg) {
                                            dolg = dolg - (it.getType().getMaxDurability() - d.getDamage());
                                            p.getInventory().setItem(count - 1, new ItemStack(Material.AIR));
                                        } else {
                                            ((Damageable) m).setDamage((int) (((Damageable) m).getDamage() + dolg));
                                            it.setItemMeta(m);
                                            dolg = 0;
                                        }
                                    }
                                }
                            }
                        if(slot[1] == 0){
                            sender.sendMessage(SD.prefix + " " + SD.getMessages().getString("Rospise.NoErrorItem", "§4Вам нужен кинжал для росписи"));
                            return;
                        }
                        if(!(dolg == 0)){
                            ro = ro.substring(0, (int) (ro.length() - (dolg/g)));
                        }
                        /**
                         if(slot[1] > 1){
                         int[] s = new int[slot[1]];
                         boolean contain = true;
                         while (contain){


                         ((Damageable) m).setDamage(((Damageable) m).getDamage() + ro.length());
                         if(((Damageable) m).getDamage() > 250){
                         int rem = ((Damageable) m).getDamage() - 250;
                         p.getInventory().setItem(slot[0], new ItemStack(Material.AIR));
                         while (p.getInventory().contains(Material.IRON_HOE)){
                         if(p.getInventory().contains(Material.IRON_HOE)) {
                         slot[0] = 0;
                         for (int i = 1; i < 36; i++) {
                         if (Objects.requireNonNull(p.getInventory().getItem(i)).getType().equals(Material.IRON_HOE)) {
                         slot[0] = i;
                         }
                         }
                         m = Objects.requireNonNull(p.getInventory().getItem(slot[0])).getItemMeta();
                         ((Damageable) m).setDamage(((Damageable) m).getDamage() + rem);
                         }
                         }
                         }
                         */
                        ItemStack r = p.getInventory().getItemInMainHand();
                        if(r.getType().isEmpty()){
                            sender.sendMessage("§9Вы вырисовывали кинжалом на нём же самом и вдруг он сломался! и все ваши труды ушли в некуда!");
                            return;
                        }
                        ItemMeta mri = p.getInventory().getItemInMainHand().getItemMeta();
                        List<String> mrl;
                        if (r.getItemMeta().getLore() == null) {
                            mrl = new ArrayList<>();
                        } else {
                            mrl = r.getItemMeta().getLore();
                        }


                        String StringLore = ro;

                        int Length = 25;

                        String LastColor = "§8§o";

                        int start = 0;

                        StringLore = StringLore.replace("&", "§");

                        int Strings = (int)((double)(StringLore.length() - (CountInstanceOfChar(StringLore, '§')*2))/Length);


                        for(int i = 1; i < Strings+1; i++){

                            String string = StringLore.substring(start, Length + start);

                            if(string.contains("§")){
                                if(i == 1){
                                    string = StringLore.substring(start, Length + start + (CountInstanceOfChar(string, '§')*2));
                                    if(string.lastIndexOf("§") + 2 > string.length()){
                                        mrl.add("§8§o" + sender.getName() + ": " + LastColor + StringLore.substring(start, start +  string.lastIndexOf("§") + 2));
                                        LastColor = StringLore.substring(string.lastIndexOf("§") + start, string.lastIndexOf("§") + 2 + start);
                                        start = start + string.lastIndexOf("§") + 2;
                                    }else{
                                        mrl.add("§8§o" + sender.getName() + ": " + LastColor + string);
                                        LastColor = StringLore.substring(string.lastIndexOf("§") + start, string.lastIndexOf("§") + 2 + start);
                                        start = start+Length+(CountInstanceOfChar(string, '§')*2);
                                    }
                                }else {
                                    string = StringLore.substring(start, Length + start + (CountInstanceOfChar(string, '§') * 2));
                                    if (string.lastIndexOf("§") + 2 > string.length()) {
                                        mrl.add(LastColor + StringLore.substring(start, start + string.lastIndexOf("§") + 2));
                                        LastColor = StringLore.substring(string.lastIndexOf("§") + start, string.lastIndexOf("§") + 2 + start);
                                        start = start + string.lastIndexOf("§") + 2;
                                    } else {
                                        mrl.add(LastColor + string);
                                        LastColor = StringLore.substring(string.lastIndexOf("§") + start, string.lastIndexOf("§") + 2 + start);
                                        start = start + Length + (CountInstanceOfChar(string, '§') * 2);
                                    }
                                }
                            }else{
                                if(i == 1){
                                    mrl.add("§8§o" + sender.getName() + ": " + LastColor + string);
                                    start = start+Length;
                                }else {
                                    mrl.add(LastColor + string);
                                    start = start + Length;
                                }
                            }
                        }
                        if(Strings == 0){
                            mrl.add("§8§o" + sender.getName() + ": " + LastColor + StringLore.substring(start, StringLore.length()));

                        }else {
                            if (start < StringLore.length()) {
                                mrl.add(LastColor + StringLore.substring(start, StringLore.length()));
                            }
                        }
/**
                        int o = 25;
                        int sto = o;
                        String col = "";
                        if (ro.contains("§")) {
                            int e;
                            if (ro.length() > o) {
                                int repe = ro.length() / o;
                                repe = (int) (repe + 1);
                                for (int i = 1; i < repe + 1; i++) {
                                    if (i == 1) {
                                        mrl.add("§8§o" + sender.getName() + ": " + "§5§o" + ro.substring(0, sto-2));

                                        e = ro.substring(0, sto-2).lastIndexOf("§");
                                        if (!(e == -1)) {
                                            col = "§" + String.valueOf(ro.substring(0, sto-2).charAt(e + 1));
                                        }
                                    } else {
                                        o = o + sto-2;
                                        if (o > ro.length()) {
                                            mrl.add("§5§o" + col + ro.substring(o - sto, ro.length()));
                                        } else {
                                            mrl.add("§5§o" + col + ro.substring(o - sto, o));
                                            e = ro.substring(o - sto, o).lastIndexOf("§");
                                            if (!(e == -1)) {
                                                col = "§" + String.valueOf(ro.substring(o - sto, o).charAt(e + 1));
                                            }
                                        }
                                    }
                                }
                            } else {
                                mrl.add("§8§o" + sender.getName() + ": §8§o" + ro);
                            }
                        } else {
                            if (ro.length() > o) {
                                int repe = ro.length() / o;
                                repe = (int) (repe + 1);
                                for (int i = 1; i < repe + 1; i++) {
                                    if (i == 1) {
                                        mrl.add("§8§o" + sender.getName() + ": " + "§5§o" + ro.substring(0, sto - 2));
                                    }else {
                                        o = o + sto-2;
                                        if (o > ro.length()) {
                                            mrl.add(ro.substring(o - sto, ro.length()));
                                        } else {
                                            mrl.add("§5§o" + ro.substring(o - sto, o));
                                        }
                                    }
                                }
                            } else {
                                mrl.add("§8§o" + sender.getName() + ": " + ro);
                            }
                        }
 */
                        mri.setLore(mrl);
                        r.setItemMeta(mri);
                            p.getInventory().setItemInMainHand(r);
                        sender.sendMessage(SD.prefix + " §9Роспись§f " + ro + " §2добавлена");
                    }else {
                        sender.sendMessage(SD.prefix + " " + SD.getMessages().getString("Rospise.viod", "§6Для росписи на предмете введите её после команды, также вы можете добавить ей цвет с помощью &"));
                    }
                }
        }
}
    @Override
    public List<String> complete (CommandSender sender, String[]args){
            return Lists.newArrayList(SD.getString("Rospise.OnTabComplete", "&3роспись"));
}
}

