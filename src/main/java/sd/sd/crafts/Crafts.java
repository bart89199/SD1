package sd.sd.crafts;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.UUID;

public class Crafts {
    private final Material[] woodList = new Material[]{Material.BIRCH_PLANKS, Material.ACACIA_PLANKS, Material.CRIMSON_PLANKS, Material.OAK_PLANKS, Material.DARK_OAK_PLANKS, Material.JUNGLE_PLANKS, Material.SPRUCE_PLANKS, Material.WARPED_PLANKS, Material.MANGROVE_PLANKS};
    public static ItemStack IRON_PALASH;
    public static ItemStack IRON_KNIFE;
    public static ItemStack DIAMOND_PALASH;
    public static ItemStack DIAMOND_KNIFE;
    public static ItemStack STONE_MOLOT;
    public static ItemStack IRON_MOLOT;
    public static ItemStack DIAMOND_MOLOT;
    public static ItemStack IRON_PLASTINA = new ItemStack(Material.GRAY_DYE);
    public static ItemStack GOLD_PLASTINA;
    public static ItemStack DIAMND_PLASTINA;
    public static ItemStack DIAMOND_PLASTINA_BLOCK;
    public static ItemStack DIAMOND_HELMET;
    public static ItemStack DIAMOND_CHESTPLATE;
    public static ItemStack DIAMOND_LEGGINGS;
    public static ItemStack DIAMOND_BOOTS;
    public static ItemStack IRON_HELMET;
    public static ItemStack IRON_CHESTPLATE;
    public static ItemStack IRON_LEGGINGS;
    public static ItemStack IRON_BOOTS;
    public static ItemStack GOLDEN_HELMET;
    public static ItemStack GOLDEN_CHESTPLATE;
    public static ItemStack GOLDEN_LEGGINGS;
    public static ItemStack GOLDEN_BOOTS;
    public static ItemStack money = new ItemStack(Material.GOLD_INGOT);

    public Crafts() {
        AttributeModifier speed;
        AttributeModifier arm;

        Bukkit.removeRecipe(NamespacedKey.minecraft("diamond_boots"));
        Bukkit.removeRecipe(NamespacedKey.minecraft("diamond_leggings"));
        Bukkit.removeRecipe(NamespacedKey.minecraft("diamond_chestplate"));
        Bukkit.removeRecipe(NamespacedKey.minecraft("diamond_helmet"));
        Bukkit.removeRecipe(NamespacedKey.minecraft("diamond_block"));
        Bukkit.removeRecipe(NamespacedKey.minecraft("iron_boots"));
        Bukkit.removeRecipe(NamespacedKey.minecraft("iron_leggings"));
        Bukkit.removeRecipe(NamespacedKey.minecraft("iron_chestplate"));
        Bukkit.removeRecipe(NamespacedKey.minecraft("iron_helmet"));
        Bukkit.removeRecipe(NamespacedKey.minecraft("golden_boots"));
        Bukkit.removeRecipe(NamespacedKey.minecraft("golden_leggings"));
        Bukkit.removeRecipe(NamespacedKey.minecraft("golden_chestplate"));
        Bukkit.removeRecipe(NamespacedKey.minecraft("golden_helmet"));
        Bukkit.removeRecipe(NamespacedKey.minecraft("netherite_ingot"));
        Bukkit.removeRecipe(NamespacedKey.minecraft("gold_block"));
        Bukkit.removeRecipe(NamespacedKey.minecraft("iron_block"));
        Bukkit.removeRecipe(NamespacedKey.minecraft("shield"));
//        Bukkit.removeRecipe(NamespacedKey.minecraft("diamond"));
        Bukkit.removeRecipe(NamespacedKey.minecraft("shulker_box"));
        Bukkit.removeRecipe(NamespacedKey.minecraft("smithing_table"));
        Bukkit.removeRecipe(NamespacedKey.minecraft("enchanting_table"));
        Bukkit.removeRecipe(NamespacedKey.minecraft("beacon"));
        Bukkit.removeRecipe(NamespacedKey.minecraft("blast_furnace"));
        Bukkit.removeRecipe(NamespacedKey.minecraft("smoker"));
        Bukkit.removeRecipe(NamespacedKey.minecraft("furnace"));
        Bukkit.removeRecipe(NamespacedKey.minecraft("stonecutter"));
//        Bukkit.removeRecipe(NamespacedKey.minecraft("iron_ingot"));
//        Bukkit.removeRecipe(NamespacedKey.minecraft("gold_ingot"));
        STONE_MOLOT = new ItemStack(Material.STONE_AXE);
        ItemMeta stone_molot_meta = STONE_MOLOT.getItemMeta();
        stone_molot_meta.setDisplayName(ChatColor.GRAY + "Каменный молот");
        stone_molot_meta.setLocalizedName("STONE_MOLOT");
        stone_molot_meta.setCustomModelData(40060001);
        STONE_MOLOT.setItemMeta(stone_molot_meta);

        DIAMND_PLASTINA = new ItemStack(Material.CYAN_DYE);
        ItemMeta plastina_meta = DIAMND_PLASTINA.getItemMeta();
        plastina_meta.setCustomModelData(40060001);
        plastina_meta.setDisplayName(ChatColor.AQUA + "Алмазная пластина");
        plastina_meta.setLocalizedName("DIAMOND_PLASTINA");
        DIAMND_PLASTINA.setItemMeta(plastina_meta);

        GOLD_PLASTINA = new ItemStack(Material.YELLOW_DYE);
        ItemMeta gold_plastina_meta = GOLD_PLASTINA.getItemMeta();
        gold_plastina_meta.setCustomModelData(40060001);
        gold_plastina_meta.setDisplayName(ChatColor.GOLD + "Золотая пластина");
        gold_plastina_meta.setLocalizedName("GOLD_PLASTINA");
        GOLD_PLASTINA.setItemMeta(gold_plastina_meta);

        IRON_PLASTINA = new ItemStack(Material.GRAY_DYE);
        ItemMeta plastina_iron_meta = IRON_PLASTINA.getItemMeta();
        plastina_iron_meta.setCustomModelData(40060001);
        plastina_iron_meta.setDisplayName(ChatColor.GRAY + "Железная пластина");
        plastina_iron_meta.setLocalizedName("IRON_PLASTINA");
        IRON_PLASTINA.setItemMeta(plastina_iron_meta);

        IRON_MOLOT = new ItemStack(Material.IRON_AXE);
        ItemMeta iron_molot_meta = IRON_MOLOT.getItemMeta();
        iron_molot_meta.setCustomModelData(40060001);
        iron_molot_meta.setDisplayName(ChatColor.GRAY + "Железный молот");
        iron_molot_meta.setLocalizedName("IRON_MOLOT");
        IRON_MOLOT.setItemMeta(iron_molot_meta);

        DIAMOND_MOLOT = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta diamond_molot_meta = DIAMOND_MOLOT.getItemMeta();
        diamond_molot_meta.setCustomModelData(40060001);
        diamond_molot_meta.setDisplayName(ChatColor.AQUA + "Алмазный молот");
        diamond_molot_meta.setLocalizedName("DIAMOND_MOLOT");
        DIAMOND_MOLOT.setItemMeta(diamond_molot_meta);

        IRON_PALASH = new ItemStack(Material.IRON_AXE);
        ItemMeta iron_plash_meta = IRON_PALASH.getItemMeta();
        iron_plash_meta.setCustomModelData(40060002);
        iron_plash_meta.setDisplayName(ChatColor.GRAY + "Железный палаш");
        AttributeModifier damage_iron_plash = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 10.0D, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        iron_plash_meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage_iron_plash);
        AttributeModifier speed_iron_plash = new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", -3.1f, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        iron_plash_meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed_iron_plash);
        AttributeModifier speed_knife = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.1, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HAND);
        iron_plash_meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed_knife);
        iron_plash_meta.setLocalizedName("IRON_PALASH");
        IRON_PALASH.setItemMeta(iron_plash_meta);

        IRON_KNIFE = new ItemStack(Material.IRON_SWORD);
        ItemMeta iron_knife_meta = IRON_KNIFE.getItemMeta();
        iron_knife_meta.setCustomModelData(40060001);
        AttributeModifier damage_iron_knife = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 3.0D, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        iron_knife_meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage_iron_knife);
        iron_knife_meta.setDisplayName(ChatColor.GRAY + "Железный кинжал");
        iron_knife_meta.setLocalizedName("IRON_KNIFE");
        IRON_KNIFE.setItemMeta(iron_knife_meta);

        DIAMOND_KNIFE = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta diamond_knife_meta = DIAMOND_KNIFE.getItemMeta();
        diamond_knife_meta.setCustomModelData(40060001);
        diamond_knife_meta.setDisplayName(ChatColor.AQUA + "Алмазный кинжал");
        AttributeModifier damage_diamond_knife = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 4D, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        diamond_knife_meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage_diamond_knife);
        diamond_knife_meta.setLocalizedName("DIAMOND_KNIFE");
        DIAMOND_KNIFE.setItemMeta(diamond_knife_meta);

        DIAMOND_PALASH = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta diamond_plash_meta = DIAMOND_PALASH.getItemMeta();
        diamond_plash_meta.setCustomModelData(40060002);
        diamond_plash_meta.setDisplayName((ChatColor.AQUA + "Алмазный палаш"));
        AttributeModifier damage_diamond_plash = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 11.0D, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier speed_diamond_plash = new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", -3.1f, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier move_speed_diamond_palash = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.1, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HAND);
        diamond_plash_meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage_diamond_plash);
        diamond_plash_meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, move_speed_diamond_palash);
        diamond_plash_meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed_diamond_plash);
        diamond_plash_meta.setLocalizedName("DIAMOND_PALASH");
        DIAMOND_PALASH.setItemMeta(diamond_plash_meta);

        ItemStack shield = new ItemStack(Material.SHIELD);
        ItemMeta shielm = shield.getItemMeta();
        speed = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.2, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HAND);
        shielm.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
        speed = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.2, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.OFF_HAND);
        shielm.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
        shield.setItemMeta(shielm);

        ItemStack gold_plastina_block = new ItemStack(Material.GOLD_BLOCK);
        ItemMeta gold_plastina_block_meta_ = gold_plastina_block.getItemMeta();
        gold_plastina_block_meta_.setDisplayName((ChatColor.GOLD + "Блок золотых пластин"));
        gold_plastina_block.setItemMeta(gold_plastina_block_meta_);

        ItemStack iron_plastina_block = new ItemStack(Material.IRON_BLOCK);
        ItemMeta plastina_block_meta_ = iron_plastina_block.getItemMeta();
        plastina_block_meta_.setDisplayName((ChatColor.GRAY + "Блок железных пластин"));
        iron_plastina_block.setItemMeta(plastina_block_meta_);

        DIAMOND_PLASTINA_BLOCK = new ItemStack(Material.DIAMOND_BLOCK);
        ItemMeta plastina_block_meta = DIAMOND_PLASTINA_BLOCK.getItemMeta();
        plastina_block_meta.setDisplayName((ChatColor.AQUA + "Блок алмазных пластин"));
        DIAMOND_PLASTINA_BLOCK.setItemMeta(plastina_block_meta);

        StonecuttingRecipe raw_iron_recipe = new StonecuttingRecipe(NamespacedKey.minecraft("raw_iron_from_ore"), new ItemStack(Material.RAW_IRON, 2), Material.IRON_ORE);
        Bukkit.addRecipe(raw_iron_recipe);

        StonecuttingRecipe raw_gold_recipe = new StonecuttingRecipe(NamespacedKey.minecraft("raw_gold_from_ore"), new ItemStack(Material.RAW_GOLD, 2), Material.GOLD_ORE);
        Bukkit.addRecipe(raw_gold_recipe);

//        ShapedRecipe iron_nugget = new ShapedRecipe(NamespacedKey.minecraft("iron_ingot_"), new ItemStack(Material.IRON_INGOT));
//        iron_nugget.shape("")

        ShapedRecipe stone_molot_recipe = new ShapedRecipe(NamespacedKey.minecraft("stone_molot"), STONE_MOLOT);
        stone_molot_recipe.shape("SSS", "STS", " T ");
        stone_molot_recipe.setIngredient('S', Material.COBBLESTONE);
        stone_molot_recipe.setIngredient('T', Material.STICK);
        Bukkit.addRecipe(stone_molot_recipe);

        ShapedRecipe plastina_iron_recipe = new ShapedRecipe(NamespacedKey.minecraft("iron_plastina"), IRON_PLASTINA);
        plastina_iron_recipe.shape("BB ", "BB ", "  1");
        plastina_iron_recipe.setIngredient('B', Material.IRON_INGOT);
        plastina_iron_recipe.setIngredient('1', new RecipeChoice.MaterialChoice(Material.STONE_AXE, Material.IRON_AXE, Material.DIAMOND_AXE, Material.NETHERITE_AXE));
        Bukkit.addRecipe(plastina_iron_recipe);

        ShapedRecipe gold_plastina_recipe = new ShapedRecipe(NamespacedKey.minecraft("gold_plastina"), GOLD_PLASTINA);
        gold_plastina_recipe.shape("BB ", "BB ", "  C");gold_plastina_recipe.setIngredient('B', Material.GOLD_INGOT);
        gold_plastina_recipe.setIngredient('B', Material.GOLD_INGOT);
        gold_plastina_recipe.setIngredient('C', new RecipeChoice.MaterialChoice(Material.IRON_AXE, Material.DIAMOND_AXE, Material.NETHERITE_AXE));
        Bukkit.addRecipe(gold_plastina_recipe);

        ShapedRecipe plastina_recipe = new ShapedRecipe(NamespacedKey.minecraft("diamond_plastina"), DIAMND_PLASTINA);
        plastina_recipe.shape("AB ", "BB ", "  C");
        plastina_recipe.setIngredient('A', Material.IRON_INGOT);
        plastina_recipe.setIngredient('B', Material.DIAMOND);
        plastina_recipe.setIngredient('C', new RecipeChoice.MaterialChoice(Material.IRON_AXE, Material.DIAMOND_AXE, Material.NETHERITE_AXE));
        Bukkit.addRecipe(plastina_recipe);

        ShapedRecipe iron_molot_recipe = new ShapedRecipe(NamespacedKey.minecraft("iron_molot"), IRON_MOLOT);
        iron_molot_recipe.shape("IBI", "ISI", " S ");
        iron_molot_recipe.setIngredient('B', Material.IRON_BLOCK);
        iron_molot_recipe.setIngredient('S', Material.STICK);
        iron_molot_recipe.setIngredient('I', Material.IRON_INGOT);
        Bukkit.addRecipe(iron_molot_recipe);

        ShapedRecipe diamond_molot_recipe = new ShapedRecipe(NamespacedKey.minecraft("diamond_molot_with_plastina"), DIAMOND_MOLOT);
        diamond_molot_recipe.shape("IBI", "ISI", " S ");
        diamond_molot_recipe.setIngredient('B', Material.IRON_BLOCK);
        diamond_molot_recipe.setIngredient('S', Material.STICK);
        diamond_molot_recipe.setIngredient('I', DIAMND_PLASTINA);
        Bukkit.addRecipe(diamond_molot_recipe);


        Bukkit.addRecipe(new CampfireRecipe(NamespacedKey.minecraft("iron_nugget_form_camp_ore"), new ItemStack(Material.IRON_NUGGET, 12), new RecipeChoice.MaterialChoice(Material.IRON_ORE, Material.DEEPSLATE_IRON_ORE), 3, 40 * 20));

        Bukkit.addRecipe(new CampfireRecipe(NamespacedKey.minecraft("iron_nugget_form_camp_raw"), new ItemStack(Material.IRON_NUGGET, 6), Material.RAW_IRON, 2, 35 * 20));


        Bukkit.addRecipe(new CampfireRecipe(NamespacedKey.minecraft("gold_nugget_form_camp_ore"), new ItemStack(Material.GOLD_NUGGET, 12), new RecipeChoice.MaterialChoice(Material.GOLD_ORE, Material.DEEPSLATE_GOLD_ORE, Material.NETHER_GOLD_ORE), 4, 45 * 20));

        Bukkit.addRecipe(new CampfireRecipe(NamespacedKey.minecraft("gold_nugget_form_camp_raw"), new ItemStack(Material.GOLD_NUGGET, 6), Material.RAW_GOLD, 3, 40 * 20));




        Bukkit.addRecipe(new CampfireRecipe(NamespacedKey.minecraft("stone_from_camp"), new ItemStack(Material.STONE), Material.COBBLESTONE, 1, 20 * 20));
        Bukkit.addRecipe(new CampfireRecipe(NamespacedKey.minecraft("smooth_stone_from_camp"), new ItemStack(Material.SMOOTH_STONE), Material.STONE, 2, 30 * 20));
        Bukkit.addRecipe(new CampfireRecipe(NamespacedKey.minecraft("brick_from_camp"), new ItemStack(Material.BRICK), Material.CLAY_BALL, 2, 15 * 20));




        ShapedRecipe shulker_box_recipe = new ShapedRecipe(NamespacedKey.minecraft("shulker_with_plastina"), new ItemStack(Material.SHULKER_BOX));
        shulker_box_recipe.shape("SNS", "PCP", "SLS");
        shulker_box_recipe.setIngredient('S', Material.SHULKER_SHELL);
        shulker_box_recipe.setIngredient('P', Material.PHANTOM_MEMBRANE);
        shulker_box_recipe.setIngredient('N', Material.NAME_TAG);
        shulker_box_recipe.setIngredient('L', GOLD_PLASTINA);
        shulker_box_recipe.setIngredient('C', Material.CHEST);
        Bukkit.addRecipe(shulker_box_recipe);

        ShapedRecipe enchanting_table = new ShapedRecipe(NamespacedKey.minecraft("enchanting_table_with_plastina"), new ItemStack(Material.ENCHANTING_TABLE));
        enchanting_table.shape(" B ", "POP", "OOO");
        enchanting_table.setIngredient('B', Material.BOOK);
        enchanting_table.setIngredient('P', DIAMND_PLASTINA);
        enchanting_table.setIngredient('O', Material.CRYING_OBSIDIAN);
        Bukkit.addRecipe(enchanting_table);

        ShapedRecipe beacon = new ShapedRecipe(NamespacedKey.minecraft("beacon_"), new ItemStack(Material.BEACON));
        beacon.shape("GGG", "GSG", "ONO");
        beacon.setIngredient('G', Material.GLASS);
        beacon.setIngredient('S', Material.NETHER_STAR);
        beacon.setIngredient('N', Material.NETHERITE_INGOT);
        beacon.setIngredient('O', Material.OBSIDIAN);
        Bukkit.addRecipe(beacon);

        ShapedRecipe bundle = new ShapedRecipe(NamespacedKey.minecraft("bundle_with_plastina"), new ItemStack(Material.BUNDLE));
        bundle.shape(" H ", "HPH", "HHH");
        bundle.setIngredient('H', Material.RABBIT_HIDE);
        bundle.setIngredient('P', IRON_PLASTINA);
        Bukkit.addRecipe(bundle);

        ShapedRecipe shield_recipe = new ShapedRecipe(NamespacedKey.minecraft("shield_with_plastina"), shield);
        shield_recipe.shape("WPW", "WWW", " W ");
        shield_recipe.setIngredient('W', new RecipeChoice.MaterialChoice(woodList));
        shield_recipe.setIngredient('P', IRON_PLASTINA);
        Bukkit.addRecipe(shield_recipe);

        ShapedRecipe smithing_table = new ShapedRecipe(NamespacedKey.minecraft("smithing_table_with_plastina"), new ItemStack(Material.SMITHING_TABLE));
        smithing_table.shape("PP", "WW", "WW");
        smithing_table.setIngredient('P', IRON_PLASTINA);
        smithing_table.setIngredient('W', new RecipeChoice.MaterialChoice(woodList));
        Bukkit.addRecipe(smithing_table);

        ShapedRecipe blast_furnace = new ShapedRecipe(NamespacedKey.minecraft("blast_furnace_with_plastina"), new ItemStack(Material.BLAST_FURNACE));
        blast_furnace.shape("PBP", "SFS", "SSS");
        blast_furnace.setIngredient('S', new RecipeChoice.MaterialChoice(Material.SMOOTH_STONE, Material.BRICK_WALL));
        blast_furnace.setIngredient('F', Material.FURNACE);
        blast_furnace.setIngredient('P', IRON_PLASTINA);
        blast_furnace.setIngredient('B', Material.IRON_BLOCK);
        Bukkit.addRecipe(blast_furnace);


        ShapedRecipe smoker = new ShapedRecipe(NamespacedKey.minecraft("smoker_with_plastina"), new ItemStack(Material.SMOKER));
        smoker.shape("PPP", "SFS", "SSS");
        smoker.setIngredient('S', new RecipeChoice.MaterialChoice(Material.ACACIA_WOOD, Material.BIRCH_WOOD, Material.DARK_OAK_WOOD, Material.JUNGLE_WOOD, Material.MANGROVE_WOOD, Material.OAK_WOOD, Material.SPRUCE_WOOD));
        smoker.setIngredient('F', Material.FURNACE);
        smoker.setIngredient('P', IRON_PLASTINA);
        Bukkit.addRecipe(smoker);

        ShapedRecipe furnace = new ShapedRecipe(NamespacedKey.minecraft("furnace_with_plastina"), new ItemStack(Material.FURNACE));
        furnace.shape("PSP", "SCS", "PSP");
        furnace.setIngredient('S', new RecipeChoice.MaterialChoice(Material.SMOOTH_STONE, Material.BRICK_WALL));
        furnace.setIngredient('C', Material.CLAY);
        furnace.setIngredient('P', IRON_PLASTINA);
        Bukkit.addRecipe(furnace);

        ShapedRecipe stonecutter = new ShapedRecipe(NamespacedKey.minecraft("stonecutter_with_plastina"), new ItemStack(Material.STONECUTTER));
        stonecutter.shape(" P ", "SSS");
        stonecutter.setIngredient('S', new RecipeChoice.MaterialChoice (Material.STONE, Material.ANDESITE, Material.DIORITE, Material.GRANITE, Material.DEEPSLATE, Material.POLISHED_ANDESITE, Material.POLISHED_DIORITE, Material.POLISHED_GRANITE, Material.SMOOTH_STONE, Material.BRICK));
        stonecutter.setIngredient('P', IRON_PLASTINA);
        Bukkit.addRecipe(stonecutter);

        ShapedRecipe iron_knife = new ShapedRecipe(NamespacedKey.minecraft("iron_knife_with_plastina"), IRON_KNIFE);
        iron_knife.shape("A", "B");
        iron_knife.setIngredient('A', IRON_PLASTINA);
        iron_knife.setIngredient('B', Material.STICK);
        Bukkit.addRecipe(iron_knife);

        ShapedRecipe netherite_r = new ShapedRecipe(NamespacedKey.minecraft("netherite_ingot_with_plastina"), new ItemStack(Material.NETHERITE_INGOT));
        netherite_r.shape("DGN", "GN ", "N M");
        netherite_r.setIngredient('N', Material.NETHERITE_SCRAP);
        netherite_r.setIngredient('G', GOLD_PLASTINA);
        netherite_r.setIngredient('M', new RecipeChoice.MaterialChoice(Material.DIAMOND_AXE, Material.NETHERITE_AXE));
        netherite_r.setIngredient('D', DIAMND_PLASTINA);
        Bukkit.addRecipe(netherite_r);

        ShapedRecipe iron_plash = new ShapedRecipe(NamespacedKey.minecraft("iron_palash_with_plastina"), IRON_PALASH);
        iron_plash.shape(" AA", "AAA", "BA ");
        iron_plash.setIngredient('A', IRON_PLASTINA);
        iron_plash.setIngredient('B', Material.STICK);
        Bukkit.addRecipe(iron_plash);

        ShapedRecipe diamond_plash = new ShapedRecipe(NamespacedKey.minecraft("diamond_palash_with_plastina"), DIAMOND_PALASH);
        diamond_plash.shape(" AA", "AAA", "BA ");
        diamond_plash.setIngredient('A', DIAMND_PLASTINA);
        diamond_plash.setIngredient('B', Material.STICK);
        Bukkit.addRecipe(diamond_plash);

        ShapedRecipe diamond_knife = new ShapedRecipe(NamespacedKey.minecraft("diamond_knife_with_plastina"), DIAMOND_KNIFE);
        diamond_knife.shape("A", "B");
        diamond_knife.setIngredient('A', DIAMND_PLASTINA);
        diamond_knife.setIngredient('B', Material.STICK);
        Bukkit.addRecipe(diamond_knife);

        {
            speed = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.02, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HEAD);
            arm = new AttributeModifier(UUID.randomUUID(), "generic.armor", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
            IRON_HELMET = new ItemStack(Material.IRON_HELMET);
            ItemMeta IRON_HELMET1m = IRON_HELMET.getItemMeta();
            IRON_HELMET1m.setDisplayName("§7Укреплённый железный шлем");
            IRON_HELMET1m.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
            IRON_HELMET1m.addAttributeModifier(Attribute.GENERIC_ARMOR, arm);
            IRON_HELMET.setItemMeta(IRON_HELMET1m);
            ShapedRecipe helmet_recipei4 = new ShapedRecipe(NamespacedKey.minecraft("iron_plastina_helmet"), IRON_HELMET);
            helmet_recipei4.shape("AAA", "A A");
            helmet_recipei4.setIngredient('A', IRON_PLASTINA);
            Bukkit.addRecipe(helmet_recipei4);

            speed = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.06, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.CHEST);
            arm = new AttributeModifier(UUID.randomUUID(), "generic.armor", 6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
            IRON_CHESTPLATE = new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta IRON_CHESTPLATEm = IRON_CHESTPLATE.getItemMeta();
            IRON_CHESTPLATEm.setDisplayName(("§7Укреплённый железный нагрудник"));
            IRON_CHESTPLATEm.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
            IRON_CHESTPLATEm.addAttributeModifier(Attribute.GENERIC_ARMOR, arm);
            IRON_CHESTPLATE.setItemMeta(IRON_CHESTPLATEm);
            ShapedRecipe chestplate_recipe = new ShapedRecipe(NamespacedKey.minecraft("iron_plastina_chestplate"), IRON_CHESTPLATE);
            chestplate_recipe.shape("A A", "AAA", "AAA");
            chestplate_recipe.setIngredient('A', IRON_PLASTINA);
            Bukkit.addRecipe(chestplate_recipe);

            speed = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.05, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.LEGS);
            arm = new AttributeModifier(UUID.randomUUID(), "generic.armor", 5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
            IRON_LEGGINGS = new ItemStack(Material.IRON_LEGGINGS);
            ItemMeta IRON_LEGGINGSm = IRON_LEGGINGS.getItemMeta();
            IRON_LEGGINGSm.setDisplayName(("§7Укреплённые железные поножи"));
            IRON_LEGGINGSm.addAttributeModifier(Attribute.GENERIC_ARMOR, arm);
            IRON_LEGGINGSm.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
            IRON_LEGGINGS.setItemMeta(IRON_LEGGINGSm);
            ShapedRecipe legginss_recipei = new ShapedRecipe(NamespacedKey.minecraft("iron_plastina_leggings"), IRON_LEGGINGS);
            legginss_recipei.shape("AAA", "A A", "A A");
            legginss_recipei.setIngredient('A', IRON_PLASTINA);
            Bukkit.addRecipe(legginss_recipei);

            speed = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.02, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.FEET);
            arm = new AttributeModifier(UUID.randomUUID(), "generic.armor", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
            IRON_BOOTS = new ItemStack(Material.IRON_BOOTS);
            ItemMeta IRON_BOOTSm = IRON_BOOTS.getItemMeta();
            IRON_BOOTSm.setDisplayName(("§7Укреплённые железные ботинки"));
            IRON_BOOTSm.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
            IRON_BOOTSm.addAttributeModifier(Attribute.GENERIC_ARMOR, arm);
            IRON_BOOTS.setItemMeta(IRON_BOOTSm);
            ShapedRecipe boots_recipei = new ShapedRecipe(NamespacedKey.minecraft("iron_plastina_boots"), IRON_BOOTS);
            boots_recipei.shape("A A", "A A");
            boots_recipei.setIngredient('A', IRON_PLASTINA);
            Bukkit.addRecipe(boots_recipei);
        }
        AttributeModifier arm_prot;
        {
            speed = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.05, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HEAD);
            arm = new AttributeModifier(UUID.randomUUID(), "generic.armor", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
            arm_prot = new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
            DIAMOND_HELMET = new ItemStack(Material.DIAMOND_HELMET);
            ItemMeta DIAMOND_HELMETm = DIAMOND_HELMET.getItemMeta();
            DIAMOND_HELMETm.setDisplayName(("§bУкреплённый алмазный шлем"));
            DIAMOND_HELMETm.addAttributeModifier(Attribute.GENERIC_ARMOR, arm);
            DIAMOND_HELMETm.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, arm_prot);
            DIAMOND_HELMETm.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
            DIAMOND_HELMET.setItemMeta(DIAMOND_HELMETm);
            ShapedRecipe helmet_recipe = new ShapedRecipe(NamespacedKey.minecraft("diamond_plastina_helmet"), DIAMOND_HELMET);
            helmet_recipe.shape("AAA", "A A");
            helmet_recipe.setIngredient('A', DIAMND_PLASTINA);
            Bukkit.addRecipe(helmet_recipe);

            speed = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.1, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.CHEST);
            arm = new AttributeModifier(UUID.randomUUID(), "generic.armor", 8, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
            arm_prot = new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
            DIAMOND_CHESTPLATE = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta DIAMOND_CHESTPLATEm = DIAMOND_CHESTPLATE.getItemMeta();
            DIAMOND_CHESTPLATEm.setDisplayName(("§bУкреплённый алмазный нагрудник"));
            DIAMOND_CHESTPLATEm.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
            DIAMOND_CHESTPLATEm.addAttributeModifier(Attribute.GENERIC_ARMOR, arm);
            DIAMOND_CHESTPLATEm.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, arm_prot);
            DIAMOND_CHESTPLATE.setItemMeta(DIAMOND_CHESTPLATEm);
            ShapedRecipe chestplate_recipe = new ShapedRecipe(NamespacedKey.minecraft("diamond_plastina_chestplate"), DIAMOND_CHESTPLATE);
            chestplate_recipe.shape("A A", "AAA", "AAA");
            chestplate_recipe.setIngredient('A', DIAMND_PLASTINA);
            Bukkit.addRecipe(chestplate_recipe);

            speed = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.09, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.LEGS);
            arm = new AttributeModifier(UUID.randomUUID(), "generic.armor", 6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
            arm_prot = new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
            DIAMOND_LEGGINGS = new ItemStack(Material.DIAMOND_LEGGINGS);
            ItemMeta DIAMOND_LEGGINGSm = DIAMOND_LEGGINGS.getItemMeta();
            DIAMOND_LEGGINGSm.setDisplayName(("§bУкреплённые алмазны поножи"));
            DIAMOND_LEGGINGSm.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
            DIAMOND_LEGGINGSm.addAttributeModifier(Attribute.GENERIC_ARMOR, arm);
            DIAMOND_LEGGINGSm.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, arm_prot);
            DIAMOND_LEGGINGS.setItemMeta(DIAMOND_LEGGINGSm);
            ShapedRecipe legginss_recipe = new ShapedRecipe(NamespacedKey.minecraft("diamond_plastina_leggings"), DIAMOND_LEGGINGS);
            legginss_recipe.shape("AAA", "A A", "A A");
            legginss_recipe.setIngredient('A', DIAMND_PLASTINA);
            Bukkit.addRecipe(legginss_recipe);

            speed = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.06, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.FEET);
            arm = new AttributeModifier(UUID.randomUUID(), "generic.armor", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
            arm_prot = new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
            DIAMOND_BOOTS = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta DIAMOND_BOOTSm = DIAMOND_BOOTS.getItemMeta();
            DIAMOND_BOOTSm.setDisplayName(("§bУкреплённые алмазные ботинки"));
            DIAMOND_BOOTSm.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
            DIAMOND_BOOTSm.addAttributeModifier(Attribute.GENERIC_ARMOR, arm);
            DIAMOND_BOOTSm.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, arm_prot);
            DIAMOND_BOOTS.setItemMeta(DIAMOND_BOOTSm);
            ShapedRecipe boots_recipe = new ShapedRecipe(NamespacedKey.minecraft("diamond_plastina_boots"), DIAMOND_BOOTS);
            boots_recipe.shape("A A", "A A");
            boots_recipe.setIngredient('A', DIAMND_PLASTINA);
            Bukkit.addRecipe(boots_recipe);
        }
        {
            speed = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.04, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HEAD);
            arm = new AttributeModifier(UUID.randomUUID(), "generic.armor", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
            GOLDEN_HELMET = new ItemStack(Material.GOLDEN_HELMET);
            ItemMeta GOLDEN_HELMETm = GOLDEN_HELMET.getItemMeta();
            GOLDEN_HELMETm.setDisplayName(("§6Укреплённый золотой шлем"));
            GOLDEN_HELMETm.addAttributeModifier(Attribute.GENERIC_ARMOR, arm);
            GOLDEN_HELMETm.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
            GOLDEN_HELMET.setItemMeta(GOLDEN_HELMETm);
            ShapedRecipe helmet_recipeg = new ShapedRecipe(NamespacedKey.minecraft("gold_plastina_helmet"), GOLDEN_HELMET);
            helmet_recipeg.shape("AAA", "A A");
            helmet_recipeg.setIngredient('A', GOLD_PLASTINA);
            Bukkit.addRecipe(helmet_recipeg);

            speed = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.09, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.CHEST);
            arm = new AttributeModifier(UUID.randomUUID(), "generic.armor", 5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
            GOLDEN_CHESTPLATE = new ItemStack(Material.GOLDEN_CHESTPLATE);
            ItemMeta GOLDEN_CHESTPLATEm = GOLDEN_CHESTPLATE.getItemMeta();
            GOLDEN_CHESTPLATEm.setDisplayName(("§6Укреплённый золотой нагрудник"));
            GOLDEN_CHESTPLATEm.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
            GOLDEN_CHESTPLATEm.addAttributeModifier(Attribute.GENERIC_ARMOR, arm);
            GOLDEN_CHESTPLATE.setItemMeta(GOLDEN_CHESTPLATEm);
            ShapedRecipe chestplate_recipeg = new ShapedRecipe(NamespacedKey.minecraft("gold_plastina_chestplate"), GOLDEN_CHESTPLATE);
            chestplate_recipeg.shape("A A", "AAA", "AAA");
            chestplate_recipeg.setIngredient('A', GOLD_PLASTINA);
            Bukkit.addRecipe(chestplate_recipeg);

            speed = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.08, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.LEGS);
            arm = new AttributeModifier(UUID.randomUUID(), "generic.armor", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
            GOLDEN_LEGGINGS = new ItemStack(Material.GOLDEN_LEGGINGS);
            ItemMeta GOLDEN_LEGGINGSm = GOLDEN_LEGGINGS.getItemMeta();
            GOLDEN_LEGGINGSm.setDisplayName(("§6Укреплённые золотые поножи"));
            GOLDEN_LEGGINGSm.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
            GOLDEN_LEGGINGSm.addAttributeModifier(Attribute.GENERIC_ARMOR, arm);
            GOLDEN_LEGGINGS.setItemMeta(GOLDEN_LEGGINGSm);
            ShapedRecipe legginss_recipeg = new ShapedRecipe(NamespacedKey.minecraft("gold_plastina_leggings"), GOLDEN_LEGGINGS);
            legginss_recipeg.shape("AAA", "A A", "A A");
            legginss_recipeg.setIngredient('A', GOLD_PLASTINA);
            Bukkit.addRecipe(legginss_recipeg);

            speed = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.04, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.FEET);
            arm = new AttributeModifier(UUID.randomUUID(), "generic.armor", 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
            GOLDEN_BOOTS = new ItemStack(Material.GOLDEN_BOOTS);
            ItemMeta GOLDEN_BOOTSm = GOLDEN_BOOTS.getItemMeta();
            GOLDEN_BOOTSm.setDisplayName(("§6Укреплённые золотые ботинки"));
            GOLDEN_BOOTSm.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
            GOLDEN_BOOTSm.addAttributeModifier(Attribute.GENERIC_ARMOR, arm);
            GOLDEN_BOOTS.setItemMeta(GOLDEN_BOOTSm);
            ShapedRecipe boots_recipeg = new ShapedRecipe(NamespacedKey.minecraft("gold_plastina_boots"), GOLDEN_BOOTS);
            boots_recipeg.shape("A A", "A A");
            boots_recipeg.setIngredient('A', GOLD_PLASTINA);
            Bukkit.addRecipe(boots_recipeg);
        }
        {
            speed = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.01, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HEAD);
            arm = new AttributeModifier(UUID.randomUUID(), "generic.armor", 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
            ItemStack IRON_HELMET = new ItemStack(Material.IRON_HELMET);
            ItemMeta IRON_HELMET1m = IRON_HELMET.getItemMeta();
            IRON_HELMET1m.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
            IRON_HELMET1m.addAttributeModifier(Attribute.GENERIC_ARMOR, arm);
            IRON_HELMET.setItemMeta(IRON_HELMET1m);
            ShapedRecipe helmet_recipei4 = new ShapedRecipe(NamespacedKey.minecraft("iron_helmet_"), IRON_HELMET);
            helmet_recipei4.shape("AAA", "A A");
            helmet_recipei4.setIngredient('A', Material.IRON_INGOT);
            Bukkit.addRecipe(helmet_recipei4);

            speed = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.04, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.CHEST);
            arm = new AttributeModifier(UUID.randomUUID(), "generic.armor", 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
            ItemStack IRON_CHESTPLATE = new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta IRON_CHESTPLATEm = IRON_CHESTPLATE.getItemMeta();
            IRON_CHESTPLATEm.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
            IRON_CHESTPLATEm.addAttributeModifier(Attribute.GENERIC_ARMOR, arm);
            IRON_CHESTPLATE.setItemMeta(IRON_CHESTPLATEm);
            ShapedRecipe chestplate_recipei = new ShapedRecipe(NamespacedKey.minecraft("iron_chestplate_"), IRON_CHESTPLATE);
            chestplate_recipei.shape("A A", "AAA", "AAA");
            chestplate_recipei.setIngredient('A', Material.IRON_INGOT);
            Bukkit.addRecipe(chestplate_recipei);

            speed = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.03, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.LEGS);
            arm = new AttributeModifier(UUID.randomUUID(), "generic.armor", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
            ItemStack IRON_LEGGINGS = new ItemStack(Material.IRON_LEGGINGS);
            ItemMeta IRON_LEGGINGSm = IRON_LEGGINGS.getItemMeta();
            IRON_LEGGINGSm.addAttributeModifier(Attribute.GENERIC_ARMOR, arm);
            IRON_LEGGINGSm.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
            IRON_LEGGINGS.setItemMeta(IRON_LEGGINGSm);
            ShapedRecipe legginss_recipei = new ShapedRecipe(NamespacedKey.minecraft("iron_leggings_"), IRON_LEGGINGS);
            legginss_recipei.shape("AAA", "A A", "A A");
            legginss_recipei.setIngredient('A', Material.IRON_INGOT);
            Bukkit.addRecipe(legginss_recipei);

            speed = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.02, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.FEET);
            arm = new AttributeModifier(UUID.randomUUID(), "generic.armor", 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
            ItemStack IRON_BOOTS = new ItemStack(Material.IRON_BOOTS);
            ItemMeta IRON_BOOTSm = IRON_BOOTS.getItemMeta();
            IRON_BOOTSm.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
            IRON_BOOTSm.addAttributeModifier(Attribute.GENERIC_ARMOR, arm);
            IRON_BOOTS.setItemMeta(IRON_BOOTSm);
            ShapedRecipe boots_recipei = new ShapedRecipe(NamespacedKey.minecraft("iron_boots_"), IRON_BOOTS);
            boots_recipei.shape("A A", "A A");
            boots_recipei.setIngredient('A', Material.IRON_INGOT);
            Bukkit.addRecipe(boots_recipei);
        }
        {
            speed = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.04, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HEAD);
            arm = new AttributeModifier(UUID.randomUUID(), "generic.armor", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
            arm_prot = new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
            ItemStack DIAMOND_HELMET = new ItemStack(Material.DIAMOND_HELMET);
            ItemMeta DIAMOND_HELMETm = DIAMOND_HELMET.getItemMeta();
            DIAMOND_HELMETm.addAttributeModifier(Attribute.GENERIC_ARMOR, arm);
            DIAMOND_HELMETm.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, arm_prot);
            DIAMOND_HELMETm.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
            DIAMOND_HELMET.setItemMeta(DIAMOND_HELMETm);
            ShapedRecipe helmet_recipe = new ShapedRecipe(NamespacedKey.minecraft("diamond_helmet_"), DIAMOND_HELMET);
            helmet_recipe.shape("AAA", "A A");
            helmet_recipe.setIngredient('A', Material.DIAMOND);
            Bukkit.addRecipe(helmet_recipe);

            speed = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.09, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.CHEST);
            arm = new AttributeModifier(UUID.randomUUID(), "generic.armor", 6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
            arm_prot = new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
            ItemStack DIAMOND_CHESTPLATE = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta DIAMOND_CHESTPLATE_m = DIAMOND_CHESTPLATE.getItemMeta();
            DIAMOND_CHESTPLATE_m.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
            DIAMOND_CHESTPLATE_m.addAttributeModifier(Attribute.GENERIC_ARMOR, arm);
            DIAMOND_CHESTPLATE_m.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, arm_prot);
            DIAMOND_CHESTPLATE.setItemMeta(DIAMOND_CHESTPLATE_m);
            ShapedRecipe chestplate_recipe = new ShapedRecipe(NamespacedKey.minecraft("diamond_chestplate_"), DIAMOND_CHESTPLATE);
            chestplate_recipe.shape("A A", "AAA", "AAA");
            chestplate_recipe.setIngredient('A', Material.DIAMOND);
            Bukkit.addRecipe(chestplate_recipe);

            speed = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.08, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.LEGS);
            arm = new AttributeModifier(UUID.randomUUID(), "generic.armor", 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
            arm_prot = new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
            ItemStack DIAMOND_LEGGINGS = new ItemStack(Material.DIAMOND_LEGGINGS);
            ItemMeta DIAMOND_LEGGINGSm = DIAMOND_LEGGINGS.getItemMeta();
            DIAMOND_LEGGINGSm.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
            DIAMOND_LEGGINGSm.addAttributeModifier(Attribute.GENERIC_ARMOR, arm);
            DIAMOND_LEGGINGSm.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, arm_prot);
            DIAMOND_LEGGINGS.setItemMeta(DIAMOND_LEGGINGSm);
            ShapedRecipe legginss_recipe = new ShapedRecipe(NamespacedKey.minecraft("diamond_leggings_"), DIAMOND_LEGGINGS);
            legginss_recipe.shape("AAA", "A A", "A A");
            legginss_recipe.setIngredient('A', Material.DIAMOND);
            Bukkit.addRecipe(legginss_recipe);

            speed = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.04, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.FEET);
            arm = new AttributeModifier(UUID.randomUUID(), "generic.armor", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
            arm_prot = new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
            ItemStack DIAMOND_BOOTS = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta DIAMOND_BOOTSm = DIAMOND_BOOTS.getItemMeta();
            DIAMOND_BOOTSm.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
            DIAMOND_BOOTSm.addAttributeModifier(Attribute.GENERIC_ARMOR, arm);
            DIAMOND_BOOTSm.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, arm_prot);
            DIAMOND_BOOTS.setItemMeta(DIAMOND_BOOTSm);
            ShapedRecipe boots_recipe = new ShapedRecipe(NamespacedKey.minecraft("diamond_boots_"), DIAMOND_BOOTS);
            boots_recipe.shape("A A", "A A");
            boots_recipe.setIngredient('A', Material.DIAMOND);
            Bukkit.addRecipe(boots_recipe);
        }
        {
            speed = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.03, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HEAD);
            arm = new AttributeModifier(UUID.randomUUID(), "generic.armor", 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
            ItemStack GOLDEN_HELMET = new ItemStack(Material.GOLDEN_HELMET);
            ItemMeta GOLDEN_HELMETm = GOLDEN_HELMET.getItemMeta();
            GOLDEN_HELMETm.addAttributeModifier(Attribute.GENERIC_ARMOR, arm);
            GOLDEN_HELMETm.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
            GOLDEN_HELMET.setItemMeta(GOLDEN_HELMETm);
            ShapedRecipe helmet_recipeg = new ShapedRecipe(NamespacedKey.minecraft("gold_helmet_"), GOLDEN_HELMET);
            helmet_recipeg.shape("AAA", "A A");
            helmet_recipeg.setIngredient('A', Material.GOLD_INGOT);
            Bukkit.addRecipe(helmet_recipeg);

            speed = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.08, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.CHEST);
            arm = new AttributeModifier(UUID.randomUUID(), "generic.armor", 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
            ItemStack GOLDEN_CHESTPLATE = new ItemStack(Material.GOLDEN_CHESTPLATE);
            ItemMeta GOLDEN_CHESTPLATEm = GOLDEN_CHESTPLATE.getItemMeta();
            GOLDEN_CHESTPLATEm.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
            GOLDEN_CHESTPLATEm.addAttributeModifier(Attribute.GENERIC_ARMOR, arm);
            GOLDEN_CHESTPLATE.setItemMeta(GOLDEN_CHESTPLATEm);
            ShapedRecipe chestplate_recipeg = new ShapedRecipe(NamespacedKey.minecraft("gold_chestplate_"), GOLDEN_CHESTPLATE);
            chestplate_recipeg.shape("A A", "AAA", "AAA");
            chestplate_recipeg.setIngredient('A', Material.GOLD_INGOT);
            Bukkit.addRecipe(chestplate_recipeg);

            speed = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.06, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.LEGS);
            arm = new AttributeModifier(UUID.randomUUID(), "generic.armor", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
            ItemStack GOLDEN_LEGGINGS = new ItemStack(Material.GOLDEN_LEGGINGS);
            ItemMeta GOLDEN_LEGGINGSm = GOLDEN_LEGGINGS.getItemMeta();
            GOLDEN_LEGGINGSm.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
            GOLDEN_LEGGINGSm.addAttributeModifier(Attribute.GENERIC_ARMOR, arm);
            GOLDEN_LEGGINGS.setItemMeta(GOLDEN_LEGGINGSm);
            ShapedRecipe legginss_recipeg = new ShapedRecipe(NamespacedKey.minecraft("gold_leggings_"), GOLDEN_LEGGINGS);
            legginss_recipeg.shape("AAA", "A A", "A A");
            legginss_recipeg.setIngredient('A', Material.GOLD_INGOT);
            Bukkit.addRecipe(legginss_recipeg);

            speed = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", -0.03, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.FEET);
            arm = new AttributeModifier(UUID.randomUUID(), "generic.armor", 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
            ItemStack GOLDEN_BOOTS = new ItemStack(Material.GOLDEN_BOOTS);
            ItemMeta GOLDEN_BOOTSm = GOLDEN_BOOTS.getItemMeta();
            GOLDEN_BOOTSm.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
            GOLDEN_BOOTSm.addAttributeModifier(Attribute.GENERIC_ARMOR, arm);
            GOLDEN_BOOTS.setItemMeta(GOLDEN_BOOTSm);
            ShapedRecipe boots_recipeg = new ShapedRecipe(NamespacedKey.minecraft("gold_boots_"), GOLDEN_BOOTS);
            boots_recipeg.shape("A A", "A A");
            boots_recipeg.setIngredient('A', Material.GOLD_INGOT);
            Bukkit.addRecipe(boots_recipeg);
        }

        ShapedRecipe gold_block_recipe = new ShapedRecipe(NamespacedKey.minecraft("gold_block_with_plastina"), gold_plastina_block);
        gold_block_recipe.shape("AA", "AA");
        gold_block_recipe.setIngredient('A', GOLD_PLASTINA);
        Bukkit.addRecipe(gold_block_recipe);

        ShapedRecipe iron_block_recipe = new ShapedRecipe(NamespacedKey.minecraft("iron_block_with_plastina"), iron_plastina_block);
        iron_block_recipe.shape("AA", "AA");
        iron_block_recipe.setIngredient('A', IRON_PLASTINA);
        Bukkit.addRecipe(iron_block_recipe);

        GOLD_PLASTINA.setAmount(4);
        ShapedRecipe gold_block_recipe_ = new ShapedRecipe(NamespacedKey.minecraft("gold_plastina_"), GOLD_PLASTINA);
        gold_block_recipe_.shape("A");
        gold_block_recipe_.setIngredient('A', Material.GOLD_BLOCK);
        Bukkit.addRecipe(gold_block_recipe_);

        ShapedRecipe plastina_block_recipe = new ShapedRecipe(NamespacedKey.minecraft("diamond_plastina_block_with_plastina"), DIAMOND_PLASTINA_BLOCK);
        plastina_block_recipe.shape("AA", "AA");
        plastina_block_recipe.setIngredient('A', DIAMND_PLASTINA);
        Bukkit.addRecipe(plastina_block_recipe);

        IRON_PLASTINA.setAmount(4);
        ShapedRecipe plastina_block_recipe_iron = new ShapedRecipe(NamespacedKey.minecraft("iron_plastina_"), IRON_PLASTINA);
        plastina_block_recipe_iron.shape("A");
        plastina_block_recipe_iron.setIngredient('A', Material.IRON_BLOCK);
        Bukkit.addRecipe(plastina_block_recipe_iron);

        DIAMND_PLASTINA.setAmount(4);
        ShapedRecipe plasina_block_recipe_ = new ShapedRecipe(NamespacedKey.minecraft("diamond_plastina_"), DIAMND_PLASTINA);
        plasina_block_recipe_.shape("A");
        plasina_block_recipe_.setIngredient('A', Material.DIAMOND_BLOCK);
        Bukkit.addRecipe(plasina_block_recipe_);

        DIAMND_PLASTINA.setAmount(1);
        ShapedRecipe d_recipe = new ShapedRecipe(NamespacedKey.minecraft("diamond_with_plastina"), new ItemStack(Material.DIAMOND, 3));
        d_recipe.shape("A");
        d_recipe.setIngredient('A', DIAMND_PLASTINA);
        Bukkit.addRecipe(d_recipe);

        IRON_PLASTINA.setAmount(1);
        ShapedRecipe i_recipe = new ShapedRecipe(NamespacedKey.minecraft("iron_ingot_with_plastina"), new ItemStack(Material.IRON_INGOT, 4));
        i_recipe.shape("A");
        i_recipe.setIngredient('A', IRON_PLASTINA);
        Bukkit.addRecipe(i_recipe);

        GOLD_PLASTINA.setAmount(1);
        ShapedRecipe g_recipe = new ShapedRecipe(NamespacedKey.minecraft("gold_ingot_with_plastina"), new ItemStack(Material.GOLD_INGOT, 4));
        g_recipe.shape("A");
        g_recipe.setIngredient('A', GOLD_PLASTINA);
        Bukkit.addRecipe(g_recipe);

    }

}
