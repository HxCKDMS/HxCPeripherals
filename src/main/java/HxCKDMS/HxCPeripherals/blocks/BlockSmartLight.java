package HxCKDMS.HxCPeripherals.blocks;

import HxCKDMS.HxCPeripherals.HxCPeripherals;
import HxCKDMS.HxCPeripherals.tileEntities.TileEntitySmartLight;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import scala.Int;

public class BlockSmartLight extends BlockPeripheralBase implements ITileEntityProvider{

    IIcon icon;
    public BlockSmartLight() {
        super();
        this.setBlockName("smartLight");
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int getLightOpacity() {
        return 15;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntitySmartLight();
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public int getRenderColor(int p_149741_1_) {
        return Int.MaxValue();
    }

    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z) {
        TileEntitySmartLight light = (TileEntitySmartLight)world.getTileEntity(x,y,z);
        return light.LightLevel;
    }


    @Override
    public boolean hasTileEntity(int metadata) {
        return true;
    }

    @Override
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
        return  icon;
    }

    @Override
    public String getItemIconName() {
        return HxCPeripherals.MODID + ":SmartLightIcon";
    }

    @Override
    public void registerBlockIcons(IIconRegister reg) {
        icon = reg.registerIcon(HxCPeripherals.MODID + ":SmartLightIcon");
    }

    @Override
    public boolean canPlaceBlockOnSide(World p_149707_1_, int p_149707_2_, int p_149707_3_, int p_149707_4_, int p_149707_5_) {
        return true;
    }

    @Override
    public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side) {
        return true;
    }
}
