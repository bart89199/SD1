package sd.sd.metods;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Lore {
    private List<String> mrl = new ArrayList<>();

    public Lore(String StringLore, int Length){

        String LastColor = "§7";

        int start = 0;

        StringLore = StringLore.replace("&", "§");

        int Strings = (int)((double)(StringLore.length() - (CountInstanceOfChar(StringLore, '§')*2))/Length);


        for(int i = 1; i < Strings+1; i++){

            String string = StringLore.substring(start, Length + start);

            if(string.contains("§")){
                string = StringLore.substring(start, Length + start + (CountInstanceOfChar(string, '§')*2));
                if(string.lastIndexOf("§") + 2 > string.length()){
                    mrl.add(LastColor + StringLore.substring(start, start +  string.lastIndexOf("§") + 2));
                    LastColor = StringLore.substring(string.lastIndexOf("§") + start, string.lastIndexOf("§") + 2 + start);
                    start = start + string.lastIndexOf("§") + 2;
                }else{
                    mrl.add(LastColor + string);
                    LastColor = StringLore.substring(string.lastIndexOf("§") + start, string.lastIndexOf("§") + 2 + start);
                    start = start+Length+(CountInstanceOfChar(string, '§')*2);
                }
            }else{
                mrl.add(LastColor + string);
                start = start+Length;
            }
        }

        if(start < StringLore.length()){
            mrl.add(LastColor + StringLore.substring(start, StringLore.length()));
        }
    }

    public Lore(String StringLore, int Length, CommandSender player){

        String LastColor = "§7";

        int start = 0;
        
        StringLore = StringLore.replace("&", "§");

        int Strings = (int)((double)(StringLore.length() - (CountInstanceOfChar(StringLore, '§')*2))/Length);

        for(int i = 1; i < Strings+1; i++){

            String string = StringLore.substring(start, Length + start);

            if(string.contains("§")){
                string = StringLore.substring(start, Length + start + (CountInstanceOfChar(string, '§')*2));
                if(string.lastIndexOf("§") + 2 > string.length()){
                     mrl.add(LastColor + StringLore.substring(start, start +  string.lastIndexOf("§") + 2));
                    LastColor = StringLore.substring(string.lastIndexOf("§") + start, string.lastIndexOf("§") + 2 + start);
                    start = start + string.lastIndexOf("§") + 2;
                }else{
                    mrl.add(LastColor + string);
                    LastColor = StringLore.substring(string.lastIndexOf("§") + start, string.lastIndexOf("§") + 2 + start);
                    start = start+Length+(CountInstanceOfChar(string, '§')*2);
                 }
            }else{
                mrl.add(LastColor + string);
                start = start+Length;
            }
        }

        if(start < StringLore.length()){
            mrl.add(LastColor + StringLore.substring(start, StringLore.length()));
        }

    }

    public Lore(String StringLore, int Length, List<String> addtolore){

        String LastColor = "§7";

        int start = 0;

        StringLore = StringLore.replace("&", "§");

        int Strings = (int)((double)(StringLore.length() - (CountInstanceOfChar(StringLore, '§')*2))/Length);

        for(int i = 1; i < Strings+1; i++){

            String string = StringLore.substring(start, Length + start);

            if(string.contains("§")){
                string = StringLore.substring(start, Length + start + (CountInstanceOfChar(string, '§')*2));
                if(string.lastIndexOf("§") + 2 > string.length()){
                    mrl.add(LastColor + StringLore.substring(start, start +  string.lastIndexOf("§") + 2));
                    LastColor = StringLore.substring(string.lastIndexOf("§") + start, string.lastIndexOf("§") + 2 + start);
                    start = start + string.lastIndexOf("§") + 2;
                }else{
                    mrl.add(LastColor + string);
                    LastColor = StringLore.substring(string.lastIndexOf("§") + start, string.lastIndexOf("§") + 2 + start);
                    start = start+Length+(CountInstanceOfChar(string, '§')*2);
                }
            }else{
                mrl.add(LastColor + string);
                start = start+Length;
            }
        }

        if(start < StringLore.length()){
            mrl.add(LastColor + StringLore.substring(start, StringLore.length()));
        }
        mrl.addAll(addtolore);
    }

    public static int CountInstanceOfChar(String text, char character) {
        char[] listOfChars = text.toCharArray();
        int total = 0 ;
        for(int charIndex = 0 ; charIndex < listOfChars.length ; charIndex++)
            if(listOfChars[charIndex] == character)
                total++;
        return total;
    }

    public List<String> getResult(){
        return this.mrl;
    }
}
