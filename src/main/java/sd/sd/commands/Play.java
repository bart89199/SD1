package sd.sd.commands;

import com.google.common.collect.Lists;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import sd.sd.SD;

import java.util.List;

import static sd.sd.SD.admin_perm;
import static sd.sd.SD.reg_perm;


public class Play extends AbstractCommand {
    //    public String log = "§8[§9§lS§8§lD§8]";

    public Play() {
        super("play");
    }
    @Override
    public void execute(CommandSender sender, @NotNull Command cmd, String label, String[] args) {

        if(sender instanceof Player p){
            if(!SD.isHub){
                p.sendMessage(SD.prefix + " §3Вы уже в Реальносте Спасения");
                return;
            }
            if(p.hasPermission(reg_perm) || p.hasPermission(admin_perm)){
                if(!p.performCommand(SD.getInstance().getConfig().getString("CmdToTp", "server The-Reality-of-Spasenia"))){
                    p.sendMessage(SD.prefix + " §4Что-то пошло не так, попробуйте прописать §6/server The-Reality-of-Spasenia §4вручную");
                }
            }else{
                p.sendMessage(SD.prefix + "§3Для начала игры вам надо быть игроком, если вы ещё не подали заявку, то переходите в наш дискорд https://discord.gg/sd-mc и там подаёте заявку, если ваше заявку уже приняли, то введите код, который вам выдали /sd login <код> если вам его не дали, напишите batr#7749");
            }
        }else{
            sender.sendMessage(SD.prefix + " §4Для этого надо быть игроком");
        }


    }


    @Override
    public List<String> complete (CommandSender sender, String[]args){
        return Lists.newArrayList();
    }


}