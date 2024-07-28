package sd.sd.metods;

import com.google.common.collect.Lists;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.chat.ComponentSerializer;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Messages {

    Change, create;

    private List<String> msg;

    @SuppressWarnings("unchecked")
    public static void load(FileConfiguration c){
        for(Messages messages : Messages.values()){
            Object obj = c.get("messages." + messages.name().replace("_", "."));
            if(obj instanceof List){
                messages.msg = (List<String>) obj;
            }else {
                messages.msg = Lists.newArrayList((String) obj);
            }
        }
    }

    public Sender replace(String from, String to){
        Sender sender = new Sender();
        return sender.replace(from, to);
    }

    public void send(CommandSender player){
        new Sender().send(player);
    }

    public class Sender{
        private final Map<String, String> plaseholders = new HashMap<>();

        public void send(CommandSender player){
            for(String message : Messages.this.msg){
                sendMessage(player, replacePlaceholder(message));
            }
        }

        public Sender replace(String from, String to){
            plaseholders.put(from, to);
            return this;
        }

        public void sendMessage(CommandSender player, String message){
            if(message.startsWith("json:")){
                player.sendMessage(new TextComponent(ComponentSerializer.parse(message.substring(3))));
            }else{
                player.sendMessage(message);
            }
        }

        private String replacePlaceholder(String message){
            message = ChatColor.translateAlternateColorCodes('&', message);
            if(!message.contains("{")) return  message;
            for(Map.Entry<String, String> entry : plaseholders.entrySet()){
                message = message.replace(entry.getKey(), entry.getValue());
            }
            return message;
        }
    }

}
