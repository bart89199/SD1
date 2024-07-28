package sd.sd.commands;

import com.google.common.collect.Lists;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import sd.sd.SD;

import java.util.HashMap;
import java.util.List;

public class MoneyCommand extends AbstractCommand {
    //    public String log = "§8[§9§lS§8§lD§8]";

    public static HashMap<Integer, Integer> codes = new HashMap();
    //                    код       кол-во
    //ты должен сделать команду, которая имеет такой функциАНАЛ
    //Аргументы:
    //1. give - конкретно ты и я могут выдавать неогран. кол-во монет кому угодно. Другие же(админы и не консоль) могут выдавать только имея код.
    //2. set - могут писать мы и по кодам
    //3. clear - свободно можем пользоваться мы и по кодам
    //4. без аргументов - показывается баланс игрока
    //5. [ник] - показывается баланс игрока(только админы и консоль)

    //1, 2, 3 должно добавляться в логи через
    public MoneyCommand() {
        super("money");
    }
    @Override
    public void execute(CommandSender sender, @NotNull Command cmd, String label, String[] args) {



        if(args.length >= 1 && args[0].equalsIgnoreCase("give") && sender.isOp()){

            if(args.length == 1){
                sender.sendMessage(SD.prefix + " §6Формат§7: §3/" + label + " give [код(если есть разрешение на свободное использование, то просто кол-во] (оповещение)[да|нет]");
                return;
            }



        }

            if(sender instanceof Player p){

                if(args.length == 0){
                    openDonateMenu(p);
                }
                SD.getLogs().addLog("&7[&4clear&7]", "&6Игрок &1" + p.getName() + " &3отчистил монеты " );

                if(SD.isHub){

                }

            }else{
                sender.sendMessage(SD.prefix + " §4Для этого надо быть игроком");
                return;
            }

        sender.sendMessage(SD.prefix + "\u00a74 Команда введена не верно!");

    }

    public void openDonateMenu(Player p){



    }


    @Override
    public List<String> complete (CommandSender sender, String[]args){
        return Lists.newArrayList();
    }


}