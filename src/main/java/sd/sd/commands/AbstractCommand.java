package sd.sd.commands;


import org.bukkit.command.*;
import org.jetbrains.annotations.NotNull;
import sd.sd.SD;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCommand implements CommandExecutor, TabCompleter {

    public AbstractCommand(String command){
        PluginCommand pluginCommand = SD.getInstance().getCommand(command);
        if(pluginCommand != null) {
            pluginCommand.setExecutor(this);
            pluginCommand.setTabCompleter(this);
        }}

    public abstract void execute(CommandSender sender, @NotNull Command cmd, String lable, String[] args);

    public List<String> complete(CommandSender sender, String[] args) {
        return null;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String lable, String[] args) {
        execute(sender, cmd, lable, args);
        return true;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, String[] args) {
        return filter(complete(sender, args), args);
    }

    private List<String> filter(List<String> list, String[] args) {
        if(list == null) return null;
        String last = args[args.length - 1];
        List<String> result = new ArrayList<>();
        for(String arg : list){
            if(arg.toLowerCase().startsWith(last.toLowerCase())) result.add(arg);
        }

        return result;
    }

}