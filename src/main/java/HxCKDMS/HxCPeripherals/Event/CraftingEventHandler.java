package HxCKDMS.HxCPeripherals.Event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class CraftingEventHandler {
    @SubscribeEvent
    public void onCrafted(PlayerEvent.ItemCraftedEvent event){
       /* if(event.crafting.getItem() == new ItemStack(HxCPeripherals.smartLight).getItem()){
            if(event.craftMatrix.getStackInSlot(7) != null && event.craftMatrix.getStackInSlot(7).getItem() == Items.dye){
                int colorIndex = event.craftMatrix.getStackInSlot(7).getItemDamage();
                NBTTagCompound compound = new NBTTagCompound();
                compound.setDouble("fRed", HxCPeripherals.DyeColorTable[colorIndex][0]);
                compound.setDouble("fGreen", HxCPeripherals.DyeColorTable[colorIndex][1]);
                compound.setDouble("fBlue", HxCPeripherals.DyeColorTable[colorIndex][2]);
                event.crafting.setTagCompound(compound);
            }
        }*/
    }
}
