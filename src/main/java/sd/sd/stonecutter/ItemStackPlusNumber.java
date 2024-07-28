package sd.sd.stonecutter;

import org.bukkit.inventory.ItemStack;

public class ItemStackPlusNumber {

    private int Number;
    private ItemStack itemStack;

    public ItemStackPlusNumber(ItemStack itemStack, int Number){
        this.Number = Number;
        this.itemStack = itemStack;
    }

    public int getNumber(){
        return  Number;
    }

    public ItemStack getItemStack(){
        return  itemStack;
    }

}
