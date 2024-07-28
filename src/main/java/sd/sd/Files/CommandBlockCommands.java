package sd.sd.Files;

import com.google.common.base.Charsets;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;
import sd.sd.SD;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CommandBlockCommands {


    public static String NameFile;
    private File configFile;
    Logger logger = SD.getInstance().getLogger();
    private FileConfiguration newConfig;

    public CommandBlockCommands(String name){
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

    public String getString(String way){
        return newConfig.getString(way).replace("<prefix>", SD.prefix).replace("&", "§").replace("<discord>", SD.getInstance().getConfig().getString("info.discord", ""));
    }

    public String getString(String way, String def){
        return newConfig.getString(way, def).replace("<prefix>", SD.prefix).replace("&", "§").replace("<discord>", SD.getInstance().getConfig().getString("info.discord", ""));
    }

    public List<String> getStringList(String way){
        List<String> getList = getConfig().getStringList(way);
        List<String> endList = new ArrayList<>();
        for (String abouts : getList) {
            endList.add(abouts.replace("<prefix>", SD.prefix).replace("&", "§").replace("<discord>", SD.getInstance().getConfig().getString("info.discord", "")));
        }
        return endList;
    }
}
