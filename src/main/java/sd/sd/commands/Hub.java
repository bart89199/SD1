package sd.sd.commands;

import com.google.common.collect.Lists;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import sd.sd.SD;

import java.util.List;


public class Hub extends AbstractCommand {
//    public String log = "§8[§9§lS§8§lD§8]";
    public ItemStack e;
    public static ItemStack trick;
    public  ItemMeta e_meta;
    private ConsoleCommandSender console = Bukkit.getConsoleSender();

    public Hub() {
        super("hub");
    }
    @Override
    public void execute(CommandSender sender, @NotNull Command cmd, String label, String[] args) {
        if(SD.getInstance().getConfig().getLocation("Spawn.Location") != null) {
            Location spawnloc = SD.getInstance().getConfig().getLocation("Spawn.Location");
            ((Player) sender).teleport(spawnloc);
            sender.sendMessage(SD.prefix + " §3Вы перемещены в хаб");
            int max = 1;
            int[] cou = new int[7]; cou[0] = 0; cou[1] = 0; cou[2] = 0; cou[3] = 0; cou[4] = 0; cou[5] = 0; cou[6] = 0;

            for(int slot=0; slot < 36; slot++){
                ItemStack item = ((Player)sender).getInventory().getItem(slot);
                if(item == null) continue;
                if((!item.hasItemMeta() && !item.getType().equals(Material.COOKIE)) || ((!item.getType().equals(Material.COOKIE)) && (!item.getType().equals(Material.CARROT_ON_A_STICK)) && (!item.getItemMeta().hasLocalizedName() || !(item.getItemMeta().getLocalizedName().contains("пасхалка") || item.getItemMeta().getLocalizedName().contains("расходник"))))){
                    ((Player)sender).getInventory().setItem(slot, new ItemStack(Material.AIR));
//                        if(item.hasItemMeta() && item.getItemMeta().hasDisplayName()) NearPlayer.sendMessage(item.getItemMeta().getDisplayName());
                }else{
                    if(item.getType().equals(Material.CARROT_ON_A_STICK)){
                        if(!item.getItemMeta().hasItemFlag(ItemFlag.HIDE_DYE))
                            ((Player)sender).getInventory().setItem(slot, new ItemStack(Material.AIR));

                    }

                    if(item.getItemMeta().getLocalizedName().equalsIgnoreCase("пасхалка_огнеупорность")){
                        if(cou[0] >= max){
                            ((Player)sender).getInventory().setItem(slot, new ItemStack(Material.AIR));
                        }else{
                            cou[0]++;
                        }
                    }
                    if(item.getItemMeta().getLocalizedName().equalsIgnoreCase("пасхалка_позорная_труба")){
                        if(cou[1] >= max){
                            ((Player)sender).getInventory().setItem(slot, new ItemStack(Material.AIR));
                        }else{
                            cou[1]++;
                        }
                    }
                    if(item.getItemMeta().getLocalizedName().equalsIgnoreCase("пасхалка_ключ")){
                        if((cou[2] + item.getAmount()) > max){
                            if(cou[2] == max){
                                ((Player)sender).getInventory().setItem(slot, new ItemStack(Material.AIR));
                                continue;
                            }
                            item.setAmount(max - cou[2]);
                            ((Player)sender).getInventory().setItem(slot, item);
                            cou[2] = max;
                        }else{
                            cou[2] = cou[2] + item.getAmount();
                        }

                    }
                    if(item.getItemMeta().getLocalizedName().equalsIgnoreCase("пасхалка_снежок")){

                        if((cou[3] + item.getAmount()) > max){
                            if(cou[3] == max){
                                ((Player)sender).getInventory().setItem(slot, new ItemStack(Material.AIR));
                                continue;
                            }
                            item.setAmount(max - cou[3]);
                            ((Player)sender).getInventory().setItem(slot, item);
                            cou[3] = max;
                        }else{
                            cou[3] = cou[3] + item.getAmount();
                        }

                    }
                    if(item.getItemMeta().getLocalizedName().equalsIgnoreCase("пасхалка_книга")){
                        if(cou[4] >= max){
                            ((Player)sender).getInventory().setItem(slot, new ItemStack(Material.AIR));
                        }else{
                            cou[4]++;
                        }
                    }
                    if(item.getItemMeta().getLocalizedName().equalsIgnoreCase("пасхалка_плавного_падения")){
                        if(cou[5] >= max){
                            ((Player)sender).getInventory().setItem(slot, new ItemStack(Material.AIR));
                        }else{
                            cou[5]++;
                        }
                    }
                    if(item.getItemMeta().getLocalizedName().equalsIgnoreCase("расходник_деревянная_кирка")){
                        if(cou[6] >= max){
                            ((Player)sender).getInventory().setItem(slot, new ItemStack(Material.AIR));
                        }else{
                            cou[6]++;
                        }
                    }
                }
            }
            return;
        }else{
            sender.sendMessage(SD.prefix + " §4Точка спавна не установлена");
        }
    }

    @Override
    public List<String> complete (CommandSender sender, String[]args){
        return Lists.newArrayList();
    }


}