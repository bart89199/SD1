package sd.sd.metods;

import org.bukkit.Material;

public class ChangeName {

    private String my;
    private String his;
    private String whose;
    private String New;
    private Material MaterialOfIcon;
    private String ProfileData;

    public ChangeName(String my, String whose, String New){
        this.my = my;
        //    this.his = his;
        this.whose = whose;
        this.New = New;
    }

    public ChangeName(String my, String whose, String New, String profileData){
        this.my = my;
        //    this.his = his;
        this.whose = whose;
        this.New = New;
        this.ProfileData = profileData;
    }

    public ChangeName(String my, String whose, String New, Material materialOfIcon){
        this.my = my;
        //    this.his = his;
        //      this.whose = whose;
        this.New = New;
        this.MaterialOfIcon = materialOfIcon;
    }

    public ChangeName(String my, String whose, String New, Material materialOfIcon, String  profileData){
        this.my = my;
        //    this.his = his;
        //      this.whose = whose;
        this.New = New;
        this.MaterialOfIcon = materialOfIcon;
        this.ProfileData = profileData;
    }

    public void setMy(String newMy){
        this.my = newMy;
    }
 /**
    public void setHis(String newHis){
        this.his = newHis;
    }
  */
    public void setWhose(String newWhose){
        this.whose = newWhose;
    }

    public void setNew(String newNew){
        this.New = newNew;
    }

    public void setIconWhitProfiles(){
        if(my.contains("еальное")){
            this.MaterialOfIcon = Material.PLAYER_HEAD;
        }
        if(my.contains("ик")){
            this.MaterialOfIcon = Material.AXOLOTL_BUCKET;
        }
        if(my.contains("дискорд")){
            this.MaterialOfIcon = Material.ENDER_PEARL;
        }
        if(my.contains("озраст")){
            this.MaterialOfIcon = Material.ARMOR_STAND;
        }
        if(my.contains("ели")){
            this.MaterialOfIcon = Material.SMALL_DRIPLEAF;
        }
        if(my.contains("вас")){
            this.MaterialOfIcon = Material.BOOK;
        }
        if(my.contains("ор") && my.contains("персонажа")){
            this.MaterialOfIcon = Material.PAPER;
        }
    }

    public void setProfileDataAutomatic(){
        if(my.contains("еальное")){
            this.ProfileData = "RealName";
        }
        if(my.contains("ик")){
            this.ProfileData = "Nick";
        }
        if(my.contains("дискорд")){
            this.ProfileData = "DiscordName";
        }
        if(my.contains("озраст")){
            this.ProfileData = "Age";
        }
        if(my.contains("ели")){
            this.ProfileData = "PlayerCels";
        }
        if(my.contains("вас")){
            this.ProfileData = "About";
        }
    }

    public String getMy(){
        return this.my;
    }

    public Material getIcon(){
        return this.MaterialOfIcon;
    }
/**
    public String getHis(){
        return this.his;
    }
 */
    public String getWhose(){
        return this.whose;
    }

    public String getNew(){
        return this.New;
    }

    public String getProfileData(){
        return this.ProfileData;
    }
}
