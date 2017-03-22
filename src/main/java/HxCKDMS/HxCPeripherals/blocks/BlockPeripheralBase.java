package HxCKDMS.HxCPeripherals.blocks;


import HxCKDMS.HxCPeripherals.HxCPeripherals;
import HxCKDMS.HxCPeripherals.tileEntities.TileEntitySmartLight;
import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.peripheral.IPeripheralProvider;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Util;
import net.minecraft.world.World;
import sun.plugin2.util.ColorUtil;

public class BlockPeripheralBase extends Block implements IPeripheralProvider {
    protected BlockPeripheralBase() {
        super(Material.redstoneLight);
        this.setCreativeTab(HxCPeripherals.tabHxCPeripherals);
    }

    @Override
    public IPeripheral getPeripheral(World world, int x, int y, int z, int side) {
        TileEntity entity = world.getTileEntity(x, y, z);
        if (entity instanceof TileEntitySmartLight) {
            return (IPeripheral)entity;
        }
        return null;
    }
}
