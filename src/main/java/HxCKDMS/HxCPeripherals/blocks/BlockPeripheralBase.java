package HxCKDMS.HxCPeripherals.blocks;


import HxCKDMS.HxCPeripherals.HxCPeripherals;
import HxCKDMS.HxCPeripherals.tileEntities.TileEntitySmartLight;
import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.peripheral.IPeripheralProvider;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPeripheralBase extends Block implements IPeripheralProvider {
    protected BlockPeripheralBase() {
        super(Material.redstoneLight);
        this.setHardness(0.3f);
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
