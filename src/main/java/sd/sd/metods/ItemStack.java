//package sd.sd.metods;
//
//import net.minecraft.server.NBTTagCompound;
//import org.bukkit.Material;
//import org.bukkit.craftbukkit.v1_14_R1.inventory.CraftItemStack;
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//
//public class ItemStack extends org.bukkit.inventory.ItemStack {
//
//    public ItemStack(@NotNull final org.bukkit.inventory.ItemStack stack){
//        super(stack);
//    }
//
//    public ItemStack(@NotNull final Material type, final int amount) {
//        super(type, amount);
//    }
//
//    public ItemStack(@NotNull final Material type) {
//        super(type);
//    }
//
//    @Deprecated
//    public ItemStack(@NotNull final Material type, final int amount, final short damage, @Nullable final Byte data) {
//        super(type, amount, damage, data);
//    }
//
//    @Deprecated // Paper
//    public ItemStack(@NotNull final Material type, final int amount, final short damage) {
//        super(type, amount, damage);
//    }
//
//    public void addNBT(String path, String object) {
//
//
//
//        net.minecraft.server.ItemStack serverItemStack;
//
//        NBTTagCompound tag = serverItemStack.getOrCreateTag();
//
//        tag.setString(path, object);
//
//        serverItemStack.setTag(tag);
//
//        ItemStack i = (ItemStack) CraftItemStack.asBukkitCopy(serverItemStack);
//
//        setItemMeta(i.getItemMeta());
//
//    }
//
//    public void addNBT(String path, int object) {
//
//        net.minecraft.server.v1_14_R1.ItemStack serverItemStack = CraftItemStack.asNMSCopy(this);
//
//        NBTTagCompound tag = serverItemStack.getOrCreateTag();
//
//        tag.setInt(path, object);
//
//        serverItemStack.setTag(tag);
//
//        ItemStack i = (ItemStack) CraftItemStack.asBukkitCopy(serverItemStack);
//
//        setItemMeta(i.getItemMeta());
//
//    }
//
//    public void addNBT(String path, Float object) {
//
//        net.minecraft.server.v1_14_R1.ItemStack serverItemStack = CraftItemStack.asNMSCopy(this);
//
//        NBTTagCompound tag = serverItemStack.getOrCreateTag();
//
//        tag.setFloat(path, object);
//
//        serverItemStack.setTag(tag);
//
//        ItemStack i = (ItemStack) CraftItemStack.asBukkitCopy(serverItemStack);
//
//        setItemMeta(i.getItemMeta());
//
//    }
//
//    public void addNBT(String path, boolean object) {
//
//        net.minecraft.server.v1_14_R1.ItemStack serverItemStack = CraftItemStack.asNMSCopy(this);
//
//        NBTTagCompound tag = serverItemStack.getOrCreateTag();
//
//        tag.setBoolean(path, object);
//
//        serverItemStack.setTag(tag);
//
//        ItemStack i = (ItemStack) CraftItemStack.asBukkitCopy(serverItemStack);
//
//        setItemMeta(i.getItemMeta());
//
//    }
//
//    public void addNBT(String path, int[] object) {
//
//        net.minecraft.server.v1_14_R1.ItemStack serverItemStack = CraftItemStack.asNMSCopy(this);
//
//        NBTTagCompound tag = serverItemStack.getOrCreateTag();
//
//        tag.setIntArray(path, object);
//
//        serverItemStack.setTag(tag);
//
//        ItemStack i = (ItemStack) CraftItemStack.asBukkitCopy(serverItemStack);
//
//        setItemMeta(i.getItemMeta());
//
//    }
//
//    public void addNBT(String path, NBTBase object) {
//
//        net.minecraft.server.v1_14_R1.ItemStack serverItemStack = CraftItemStack.asNMSCopy(this);
//
//        NBTTagCompound tag = serverItemStack.getOrCreateTag();
//
//        tag.set(path, object);
//
//        serverItemStack.setTag(tag);
//
//        ItemStack i = (ItemStack) CraftItemStack.asBukkitCopy(serverItemStack);
//
//        setItemMeta(i.getItemMeta());
//
//    }
//
//}
