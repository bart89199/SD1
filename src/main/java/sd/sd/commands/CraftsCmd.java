package sd.sd.commands;

import com.google.common.collect.Lists;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import sd.sd.SD;
import sd.sd.stonecutter.GUI;

import java.util.List;

import static sd.sd.SD.admin_perm;

public class CraftsCmd extends AbstractCommand {

    public CraftsCmd() {
        super("crafts");
    }

    @Override
    public void execute(CommandSender sender, @NotNull Command cmd, String label, String[] args) {
        if(sender instanceof ConsoleCommandSender) {
            sender.sendMessage("§4Команда не поддерживает консоль");
        }
        if(sender instanceof Player) {
            if (sender.hasPermission(admin_perm)) {
                Player p = Bukkit.getPlayer(sender.getName());

                if (args.length == 0) {

                    p.openInventory(GUI.EditCrafts());

                }

            }
        }else{
            sender.sendMessage(SD.prefix + " §4Не достаточно прав");
        }
    }

    @Override
    public List<String> complete(CommandSender sender, String[] args) {
        return Lists.newArrayList();
    }
}
