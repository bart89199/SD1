package sd.sd.species;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public enum Species {
    ЛЮДИ("people", new PotionEffect[]{new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 999999, 0, false, false)},
            new Attribute[]{Attribute.GENERIC_MAX_HEALTH}, new int[]{20}, false, false,
            false, false, false, false, true, true, SpecieItems.SMOKER, SpecieItems.CONDUIT,
            SpecieItems.CROSSBOW, SpecieItems.TNT, SpecieItems.DIAMOND_AXE, SpecieItems.DIAMOND_HOE, SpecieItems.DIAMOND_SHOVEL, SpecieItems.IRON_KNIFE),
    ЗВЕРОЛЮДИ("animal-like", new PotionEffect[]{new PotionEffect(PotionEffectType.LUCK, 999999, 0, false, false)},
            new Attribute[]{Attribute.GENERIC_MAX_HEALTH}, new int[]{22}, true, false,
            false, false, true, true, true, true, SpecieItems.SMOKER, SpecieItems.DIAMOND_HOE,
            SpecieItems.DIAMOND_SHOVEL, SpecieItems.IRON_KNIFE, SpecieItems.DIAMOND_ARMOR, SpecieItems.BEACON, SpecieItems.DIAMOND_KNIFE, SpecieItems.IRON_MOLOT),
    СЛАЙМЫ("slime", new PotionEffect[]{new PotionEffect(PotionEffectType.REGENERATION, 999999, 0, false, false),
            new PotionEffect(PotionEffectType.JUMP, 999999, 0, false, false)},
            new Attribute[]{Attribute.GENERIC_MAX_HEALTH}, new int[]{17}, true, false,
            true, false, true, true, false, false, SpecieItems.BEACON, SpecieItems.ENDER_EYE,
            SpecieItems.ENDER_CHEST, SpecieItems.END_CRYSTAL, SpecieItems.ALL_REDSTONE, SpecieItems.RECOVERY_COMPASS),
    АЗАРИ("asari", new PotionEffect[]{new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 0, false, false),
            new PotionEffect(PotionEffectType.SLOW_DIGGING, 999999, 0, false, false)},
            new Attribute[]{Attribute.GENERIC_MAX_HEALTH}, new int[]{18}, true, true,
            false, true, true, true, true, true, SpecieItems.IRON_MOLOT, SpecieItems.SMOKER,
            SpecieItems.END_CRYSTAL, SpecieItems.TNT, SpecieItems.ENDER_EYE, SpecieItems.IRON_IMPROVED_ARMOR, SpecieItems.DIAMOND_AXE, SpecieItems.ENDER_CHEST, SpecieItems.BEACON),
    ДВОРФЫ("dwarf", new PotionEffect[]{new PotionEffect(PotionEffectType.LUCK, 999999, 1, false, false),
            new PotionEffect(PotionEffectType.FAST_DIGGING, 999999, 0, false, false)}
            , new Attribute[]{Attribute.GENERIC_MAX_HEALTH}, new int[]{12},
            false, true, true, true, false, false, false, false,
            SpecieItems.IRON_IMPROVED_ARMOR, SpecieItems.SMOKER, SpecieItems.NETHERITE_INGOT, SpecieItems.IRON_PALASH, SpecieItems.DIAMOND_PICKAXE, SpecieItems.DIAMOND_MOLOT,
            SpecieItems.BLAST_FURNACE, SpecieItems.IRON_KNIFE, SpecieItems.DIAMOND_KNIFE, SpecieItems.DIAMOND_PALASH, SpecieItems.DIAMOND_ARMOR, SpecieItems.CROSSBOW, SpecieItems.IRON_MOLOT),
    ДЕМОНЫ("demon", new PotionEffect[]{new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999, 0, false, false),
            new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 0, false, false),
            new PotionEffect(PotionEffectType.SLOW_DIGGING, 999999, 0, false, false)}, new Attribute[]{Attribute.GENERIC_MAX_HEALTH},
            new int[]{23}, false, true,
            false, true, false, false, false, false, SpecieItems.IRON_IMPROVED_ARMOR, SpecieItems.IRON_MOLOT,
            SpecieItems.IRON_PALASH, SpecieItems.IRON_KNIFE),
    ДРАКОНИДЫ("dragon", new PotionEffect[]{new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 0, false, false),
            new PotionEffect(PotionEffectType.SLOW_FALLING, 999999, 0, false, false)},
            new Attribute[]{Attribute.GENERIC_MAX_HEALTH}, new int[]{18}, true, false,
            false, false, false, true, false, false, SpecieItems.ENDER_EYE, SpecieItems.BEACON,
            SpecieItems.ENDER_CHEST, SpecieItems.SHULKER_BOX, SpecieItems.END_CRYSTAL, SpecieItems.RECOVERY_COMPASS);

    private final String specieName;
    private final PotionEffect[] effects;
    private final Attribute[] attributes;
    private final int[] attributesValues;
    private final boolean beaconUse;
    private final boolean cartographyTableUse;


    private final boolean loomUse;
    private final SpecieItems[] items;
    private final boolean enchantingBlockUse;
    private final boolean smithingTable;
    private final boolean grindstoneUse;
    private final boolean anvilUse;
    private final boolean brewingStandUse;

    Species(String specieName, PotionEffect[] effects, Attribute[] attributes, int[] attributesValues, boolean enchantingBlockUse,
            boolean smithingTableUse, boolean grindstoneUse, boolean anvilUse, boolean brewingStandUse, boolean beaconUse, boolean cartographyTableUse,
            boolean loomUse, SpecieItems... items){//, String[] KeysOfCrafts
        this.effects = effects;
        this.attributes = attributes;
        this.attributesValues = attributesValues;
        this.specieName = specieName;
        this.beaconUse = beaconUse;
        this.cartographyTableUse = cartographyTableUse;
        this.loomUse = loomUse;
        this.items = items;
        this.enchantingBlockUse = enchantingBlockUse;
        this.smithingTable = smithingTableUse;
        this.grindstoneUse = grindstoneUse;
        this.anvilUse = anvilUse;
        this.brewingStandUse = brewingStandUse;
    }

    public void setSpecieTo(Player p){

        removeSpecieFrom(p);

        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set sd.specie." + specieName + " true server=hub server=the-reality-of-spasenia");
        addEffectsTo(p);
        addAttributesTo(p);
    }

    public static void removeSpecieFrom(Player p){
        Species specie = getSpecie(p);
        if(specie != null){
            removeEffectsFrom(p, specie);
            removeAttributesFrom(p, specie);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission unset sd.specie." + specie.getSpecieName());
        }
    }

    public void addAttributesTo(Player p){
        if(attributes != null){
            for(int i = 0; i < attributes.length; i++){
                p.getAttribute(attributes[i]).setBaseValue(attributesValues[i]);
            }
        }
    }

    public void addEffectsTo(Player p){
        if(effects != null){
            for(PotionEffect effect : effects){

                p.addPotionEffect(effect);
            }
        }
    }

    public void removeEffectsFrom(Player p){
        if(effects != null){
            for(PotionEffect effect : effects){
                p.removePotionEffect(effect.getType());
            }
        }
    }

    public static void removeEffectsFrom(Player p, Species specie){
        if(specie.getEffects() != null){
            for(PotionEffect effect : specie.getEffects()){
                p.removePotionEffect(effect.getType());
            }
        }
    }

    public void removeAttributesFrom(Player p){
        if(attributes != null){
            for(int i = 0; i < attributes.length; i++){
                p.getAttribute(attributes[i]).setBaseValue(p.getAttribute(attributes[i]).getDefaultValue());
            }
        }
    }


    public static void removeAttributesFrom(Player p, Species specie){
        if(specie.getAttributes() != null){
            for(int i = 0; i < specie.getAttributes().length; i++){
                p.getAttribute(specie.getAttributes()[i]).setBaseValue(p.getAttribute(specie.getAttributes()[i]).getDefaultValue());
            }
        }
    }

    public boolean hasEnchantingBlockUse() {
        return enchantingBlockUse;
    }

    public boolean hasSmithingTable() {
        return smithingTable;
    }

    public boolean hasGrindstoneUse() {
        return grindstoneUse;
    }

    public boolean hasAnvilUse() {
        return anvilUse;
    }

    public boolean hasBrewingStandUse() {
        return brewingStandUse;
    }
    public boolean hasBeaconUse() {
        return beaconUse;
    }

    public boolean hasCartographyTableUse() {
        return cartographyTableUse;
    }

    public boolean hasLoomUse() {
        return loomUse;
    }

    public String getSpecieName() {
        return specieName;
    }

    public PotionEffect[] getEffects() {
        return effects;
    }

    public Attribute[] getAttributes() {
        return attributes;
    }

    public int[] getAttributesValues() {
        return attributesValues;
    }

    public SpecieItems[] getItems() {
        return items;
    }

    public static Species getSpecie(Player p){

        if(p.hasPermission("sd.specie.people")){
            return Species.ЛЮДИ;
        }
        if(p.hasPermission("sd.specie.animal-like")){
            return Species.ЗВЕРОЛЮДИ;
        }
        if(p.hasPermission("sd.specie.slime")){
            return Species.СЛАЙМЫ;
        }
        if(p.hasPermission("sd.specie.asari")){
            return Species.АЗАРИ;
        }
        if(p.hasPermission("sd.specie.dwarf")){
            return Species.ДВОРФЫ;
        }
        if(p.hasPermission("sd.specie.demon")){
            return Species.ДЕМОНЫ;
        }
        if(p.hasPermission("sd.specie.dragon")){
            return Species.ДРАКОНИДЫ;
        }

        return null;
    }
    public static Species getSpecie(String specieName){

        if(specieName == null){
            return null;
        }

        if(specieName.equalsIgnoreCase("people")){
            return Species.ЛЮДИ;
        }
        if(specieName.equalsIgnoreCase("animal-like")){
            return Species.ЗВЕРОЛЮДИ;
        }
        if(specieName.equalsIgnoreCase("slime")){
            return Species.СЛАЙМЫ;
        }
        if(specieName.equalsIgnoreCase("asari")){
            return Species.АЗАРИ;
        }
        if(specieName.equalsIgnoreCase("dwarf")){
            return Species.ДВОРФЫ;
        }
        if(specieName.equalsIgnoreCase("demon")){
            return Species.ДЕМОНЫ;
        }
        if(specieName.equalsIgnoreCase("dragon")){
            return Species.ДРАКОНИДЫ;
        }

        if(specieName.equalsIgnoreCase("люди")){
            return Species.ЛЮДИ;
        }
        if(specieName.equalsIgnoreCase("звероподобные")){
            return Species.ЗВЕРОЛЮДИ;
        }
        if(specieName.equalsIgnoreCase("слаймы")){
            return Species.СЛАЙМЫ;
        }
        if(specieName.equalsIgnoreCase("азари")){
            return Species.АЗАРИ;
        }
        if(specieName.equalsIgnoreCase("дворфы")){
            return Species.ДВОРФЫ;
        }
        if(specieName.equalsIgnoreCase("демоны")){
            return Species.ДЕМОНЫ;
        }
        if(specieName.equalsIgnoreCase("дракониды")){
            return Species.ДРАКОНИДЫ;
        }

        return null;
    }

    public static String getSpecieName(String specieName){

        if(specieName == null){
            return null;
        }

        if(specieName.equalsIgnoreCase("people")){
            return "люди";
        }
        if(specieName.equalsIgnoreCase("animal-like")){
            return "звероподобные";
        }
        if(specieName.equalsIgnoreCase("slime")){
            return "слаймы";
        }
        if(specieName.equalsIgnoreCase("asari")){
            return "азари";
        }
        if(specieName.equalsIgnoreCase("dwarf")){
            return "дворфы";
        }
        if(specieName.equalsIgnoreCase("demon")){
            return "демоны";
        }
        if(specieName.equalsIgnoreCase("dragon")){
            return "дракониды";
        }


        if(specieName.equalsIgnoreCase("люди")){
            return "people";
        }
        if(specieName.equalsIgnoreCase("звероподобные")){
            return "animal-like";
        }
        if(specieName.equalsIgnoreCase("слаймы")){
            return "slime";
        }
        if(specieName.equalsIgnoreCase("азари")){
            return "asari";
        }
        if(specieName.equalsIgnoreCase("дворфы")){
            return "dwarf";
        }
        if(specieName.equalsIgnoreCase("демоны")){
            return "demon";
        }
        if(specieName.equalsIgnoreCase("дракониды")){
            return "dragon";
        }

        return null;
    }

}
