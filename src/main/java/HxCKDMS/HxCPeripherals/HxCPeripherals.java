package HxCKDMS.HxCPeripherals;

import HxCKDMS.HxCPeripherals.blocks.BlockSmartLight;
import HxCKDMS.HxCPeripherals.proxies.CommonProxy;
import HxCKDMS.HxCPeripherals.tileEntities.TileEntitySmartLight;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import dan200.computercraft.api.ComputerCraftAPI;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

@Mod(modid = HxCPeripherals.MODID, version = HxCPeripherals.VERSION)
public class HxCPeripherals
{

    public static final String MODID = "hxcperipherals";
    public static final String VERSION = "1.0";

    public static final CreativeTabs tabHxCPeripherals = new CreativeTabs("tabHxCPeripherals") {
        @Override
        public Item getTabIconItem() {
            return smartLight.getItemDropped(1,null,1);
        }
    };

    @SidedProxy(clientSide = "HxCKDMS.HxCPeripherals.proxies.ClientProxy", serverSide = "HxCKDMS.HxCPeripherals.proxies.CommonProxy")
    public static CommonProxy proxy;

    public static BlockSmartLight smartLight = new BlockSmartLight();


    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        GameRegistry.registerBlock(smartLight, "smartLight");
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        GameRegistry.registerTileEntity(TileEntitySmartLight.class, "tileSmartLight");
        ComputerCraftAPI.registerPeripheralProvider(smartLight);
        proxy.registerRenders();
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(smartLight,1),
                "aaa",
                "beb",
                "cdc",
                'a', "blockStainedGlass",
                'b', Blocks.redstone_lamp,
                'c', "blockStone",
                'd', GameRegistry.findItemStack("ComputerCraft", "CC-Cable", 1),
                'e', "blockRedstone"
        ));
    }
}
