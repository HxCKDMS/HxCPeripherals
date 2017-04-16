package HxCKDMS.HxCPeripherals.tileEntities;

import dan200.computercraft.api.lua.ILuaContext;
import dan200.computercraft.api.lua.LuaException;
import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.peripheral.IPeripheral;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySmartLight extends TileEntity implements IPeripheral{

    public int LightLevel = 255;
    public double Red = 255;
    public double Green = 255;
    public double Blue = 255;
    public int FrameColor = 0;
    public byte Style = 0; // 0: plain, 1: frame
    private boolean dirty = false;

    @Override
    public String getType() {
        return "smartlight";
    }

    @Override
    public String[] getMethodNames() {
        return new String[]{
                "set"
        };
    }

    @Override
    public Object[] callMethod(IComputerAccess computer, ILuaContext context, int method, Object[] arguments) throws LuaException, InterruptedException {
        boolean success = false;
        int argl = arguments.length;
        if(method == 0){
            if(argl<4){
                throw new LuaException("Too few argument (Takes 4).");
            }
            if(argl>4){
                throw new LuaException("Too many argument (Takes 4).");
            }
            if(argl==4){
                if(!(arguments[0] instanceof Double)){
                    throw new LuaException("Bad Argument #1 (expected number 0-255)");
                }
                if(!(arguments[1] instanceof Double)){
                    throw new LuaException("Bad Argument #2 (expected number 0-255)");
                }
                if(!(arguments[2] instanceof Double)){
                    throw new LuaException("Bad Argument #3 (expected number 0-255)");
                }
                if(!(arguments[3] instanceof Double)){
                    throw new LuaException("Bad Argument #4 (expected number 0-255)");
                }
            }
            this.LightLevel = Math.min(Math.max((int)((Double.parseDouble(arguments[3].toString())/255)*14), 0), 14);
            this.Red = Math.min(Math.max(Double.parseDouble(arguments[0].toString())/255,0),255);
            this.Green = Math.min(Math.max(Double.parseDouble(arguments[1].toString())/255,0),255);
            this.Blue = Math.min(Math.max(Double.parseDouble(arguments[2].toString())/255,0),255);
            //System.out.println(FrameRed + ", " + FrameGreen + ", " + FrameBlue);
            dirty = true;
            markDirty();
            success = true;
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        }

        return new Object[]{success};
    }


    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        LightLevel = tag.getInteger("lightLevel");
        Red = tag.getDouble("red");
        Green = tag.getDouble("green");
        Blue = tag.getDouble("blue");
        FrameColor = tag.getInteger("fColor");
        Style = tag.getByte("style");
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setInteger("lightLevel", LightLevel);
        tag.setDouble("red", Red);
        tag.setDouble("green", Green);
        tag.setDouble("blue", Blue);
        tag.setInteger("fColor", FrameColor);
        tag.setByte("style", Style);
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        this.writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
        readFromNBT(packet.func_148857_g());
    }

    @Override
    public void attach(IComputerAccess computer) {
    }

    @Override
    public void detach(IComputerAccess computer) {
    }

    @Override
    public boolean equals(IPeripheral other) {
        return false;
    }

    @Override
    public void updateEntity() {
       // if(dirty) {
       //     dirty = false;

       // }
    }
}
