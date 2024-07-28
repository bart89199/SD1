package sd.sd.Files;

import com.google.common.base.Charsets;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import sd.sd.SD;
import sd.sd.shops.Shop;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import static sd.sd.SD.listOfShops;
import static sd.sd.SD.shops;


public class Shops {


    public static String NameFile;
    private File configFile;
    Logger logger = SD.getInstance().getLogger();
    private FileConfiguration newConfig;

    public Shops(String name){
        this.NameFile = name;
        this.configFile = new File(SD.getInstance().getDataFolder(), NameFile);
        if (!configFile.exists()) {
            saveResource(NameFile, false);
        }
        reloadConfig();
    }

    public void saveResource(@NotNull String resourcePath, boolean replace) {
        if (resourcePath == null || resourcePath.equals("")) {
            throw new IllegalArgumentException("ResourcePath cannot be null or empty");
        }

        resourcePath = resourcePath.replace('\\', '/');
        InputStream in = getResource(resourcePath);
        if (in == null) {
            throw new IllegalArgumentException("The embedded resource '" + resourcePath + "' cannot be found in ");
        }

        File outFile = new File(SD.getInstance().getDataFolder(), resourcePath);
        int lastIndex = resourcePath.lastIndexOf('/');
        File outDir = new File(SD.getInstance().getDataFolder(), resourcePath.substring(0, lastIndex >= 0 ? lastIndex : 0));

        if (!outDir.exists()) {
            outDir.mkdirs();
        }

        try {
            if (!outFile.exists() || replace) {
                OutputStream out = new FileOutputStream(outFile);
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                out.close();
                in.close();
            } else {
                logger.log(Level.WARNING, "Could not save " + outFile.getName() + " to " + outFile + " because " + outFile.getName() + " already exists.");
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not save " + outFile.getName() + " to " + outFile, ex);
        }
    }

    public InputStream getResource(@NotNull String filename) {
        if (filename == null) {
            throw new IllegalArgumentException("Filename cannot be null");
        }

        try {
            URL url = this.getClass().getClassLoader().getResource(filename);

            if (url == null) {
                return null;
            }

            URLConnection connection = url.openConnection();
            connection.setUseCaches(false);
            return connection.getInputStream();
        } catch (IOException ex) {
            return null;
        }
    }

    public void reloadConfig() {
        newConfig = YamlConfiguration.loadConfiguration(configFile);

        final InputStream defConfigStream = getResource(NameFile);
        if (defConfigStream == null) {
            return;
        }

        newConfig.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(defConfigStream, Charsets.UTF_8)));
    }

    public FileConfiguration getConfig(){
        return newConfig;
    }

    public void save() {
        try {
            newConfig.save(configFile);
        } catch (IOException e){
            throw new RuntimeException("Ошибка при создании " + NameFile, e);
        }
    }

    public List<Shop> getShops(){

        List<?> list = newConfig.getList("Shops", new ArrayList<>());

        if(!list.isEmpty()) {

            List<Shop> shops = new ArrayList<>();

            for (Object o : list) {

                if (o instanceof Shop s) {

                    shops.add(s);

                }
            }
            return shops;

        } else {
            return new ArrayList<>();
        }

    }

    public Shop getShop(UUID id){

        for(Shop shop : getShops()){

            if(shop != null && shop.getId().equals(id)) return shop;

        }

        return null;

    }

    public void addShop(String name, Location start, Location end, Location get, Location put){


        List<Shop> list = getShops();
        list.add(new Shop(name, start, end, get, put, new ItemStack[0], new UUID[0]));
        newConfig.set("Shops", list);
        newConfig.set("test", new Shop(name, start, end, get, put, new ItemStack[0], new UUID[0]));
        save();

    }

    public void addShop(Shop shop){


        List<Shop> list = getShops();
        list.add(shop);
        newConfig.set("Shops", list);
        newConfig.set("test", shop);
        save();

    }

    public boolean removeShop(String name){

        List<Shop> list = getShops();

        for(int i = 0; i < list.size(); i++){

            if(list.get(i).getName().equals(name)){

                if(list.remove(list.get(i))){
                    newConfig.set("Shops", list);
                    save();
                    SD.shops = list;
                    listOfShops = new ArrayList<>();
                    listOfShops.add(new Shop[7]);

                    int line = 0;
                    int slot = 0;

                    for(Shop shop : shops){

                        if(slot >= 6){

                            slot = 0;
                            listOfShops.add(++line, new Shop[7]);

                        }

                        listOfShops.get(line)[slot++] = shop;

                    }
                    return true;
                }

            }

        }

        return false;

    }

}
