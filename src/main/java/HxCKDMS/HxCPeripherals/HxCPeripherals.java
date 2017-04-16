package HxCKDMS.HxCPeripherals;

import HxCKDMS.HxCPeripherals.Event.CraftingEventHandler;
import HxCKDMS.HxCPeripherals.blocks.BlockSmartLight;
import HxCKDMS.HxCPeripherals.proxies.CommonProxy;
import HxCKDMS.HxCPeripherals.tileEntities.TileEntitySmartLight;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import dan200.computercraft.api.ComputerCraftAPI;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.ShapedOreRecipe;

@Mod(modid = HxCPeripherals.MODID, version = HxCPeripherals.VERSION)
public class HxCPeripherals
{

    public static final String MODID = "hxcperipherals";
    public static final String VERSION = "1.0";
    //color order:  white, orange, magenta, lblue, yellow, lime, pink, gray, lgrag, cyan, purple, blue, brown, green, red, black
    public static final float[][] DyeColorTable = new float[][] {{1.0F, 1.0F, 1.0F}, {0.85F, 0.5F, 0.2F}, {0.7F, 0.3F, 0.85F}, {0.4F, 0.6F, 0.85F}, {0.9F, 0.9F, 0.2F}, {0.5F, 0.8F, 0.1F}, {0.95F, 0.5F, 0.65F}, {0.3F, 0.3F, 0.3F}, {0.6F, 0.6F, 0.6F}, {0.3F, 0.5F, 0.6F}, {0.5F, 0.25F, 0.7F}, {0.2F, 0.3F, 0.7F}, {0.4F, 0.3F, 0.2F}, {0.4F, 0.5F, 0.2F}, {0.6F, 0.2F, 0.2F}, {0.1F, 0.1F, 0.1F}};
    public static Config configInstance;

    public static final CreativeTabs tabHxCPeripherals = new CreativeTabs("tabHxCPeripherals") {
        @Override
        public Item getTabIconItem() {
            return smartLight.getItemDropped(1,null,1);
        }
    };

    @SidedProxy(clientSide = "HxCKDMS.HxCPeripherals.proxies.ClientProxy", serverSide = "HxCKDMS.HxCPeripherals.proxies.CommonProxy")
    public static CommonProxy proxy;

    public static BlockSmartLight smartLight = new BlockSmartLight();
    public static CraftingEventHandler craftingEventHandler = new CraftingEventHandler();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        GameRegistry.registerBlock(smartLight, "smartLight");
        configInstance = new Config(event.getSuggestedConfigurationFile());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(craftingEventHandler);
        FMLCommonHandler.instance().bus().register(craftingEventHandler);
        GameRegistry.registerTileEntity(TileEntitySmartLight.class, "tileSmartLight");
        ComputerCraftAPI.registerPeripheralProvider(smartLight);
        proxy.registerRenders();
        if(configInstance.enableSmartLight) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(smartLight, 1),
                    "aaa",
                    "RGB",
                    "ded",
                    'a', "paneGlass",
                    'b', "glowstone",
                    'd', "ingotIron",
                    'e', "blockRedstone",
                    'R', "dyeRed",
                    'G', "dyeGreen",
                    'B', "dyeBlue"
            ));
            registerColoredLightRecipe("White", 0);
            registerColoredLightRecipe("Orange", 1);
            registerColoredLightRecipe("Magenta", 2);
            registerColoredLightRecipe("LightBlue", 3);
            registerColoredLightRecipe("Yellow", 4);
            registerColoredLightRecipe("Lime", 5);
            registerColoredLightRecipe("Pink", 6);
            registerColoredLightRecipe("Gray", 7);
            registerColoredLightRecipe("LightGray", 8);
            registerColoredLightRecipe("Cyan", 9);
            registerColoredLightRecipe("Purple", 10);
            registerColoredLightRecipe("Blue", 11);
            registerColoredLightRecipe("Brown", 12);
            registerColoredLightRecipe("Green", 13);
            registerColoredLightRecipe("Red", 14);
            registerColoredLightRecipe("Black", 15);
        }
    }

    private static void registerColoredLightRecipe(String colorName, int colorIndex){
        ItemStack framedLightStack = new ItemStack(smartLight, 1, colorIndex-1);
        GameRegistry.addRecipe(new ShapedOreRecipe(framedLightStack,
                "aaa",
                "aBa",
                "aca",
                'a', "stickWood",
                'B', smartLight,
                'c', "dye"+colorName
        ));
    }
}