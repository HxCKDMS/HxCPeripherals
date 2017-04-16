package HxCKDMS.HxCPeripherals.tileRender;

import HxCKDMS.HxCPeripherals.HxCPeripherals;
import HxCKDMS.HxCPeripherals.tileEntities.TileEntitySmartLight;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TileRenderSmartLight extends TileEntitySpecialRenderer{

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float partialTick) {
        TileEntitySmartLight smartLight = (TileEntitySmartLight)(tileEntity);
        GL11.glPushMatrix();
        GL11.glTranslated(x, y, z);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        bindTexture(new ResourceLocation(HxCPeripherals.MODID + ":textures/blocks/SmartLight.png"));
        GL11.glColor3d(smartLight.Red, smartLight.Green, smartLight.Blue);
        Tessellator wr = Tessellator.instance;
        switch (smartLight.Style){
            case 0:
                drawCube(wr, 0,0,0,1,1,1);
                break;
            case 1:
                drawCube(wr, 0.005,0.005,0.005,0.995,0.995,0.995);
                bindTexture(new ResourceLocation(HxCPeripherals.MODID + ":textures/blocks/SmartLightFrame.png"));
                GL11.glColor3d(HxCPeripherals.DyeColorTable[smartLight.FrameColor+2][0],HxCPeripherals.DyeColorTable[smartLight.FrameColor+2][1],HxCPeripherals.DyeColorTable[smartLight.FrameColor+2][2]);
                drawCube(wr, 0,0,0,1,1,1);
                break;
        }
        GL11.glPopMatrix();

    }

    public void drawCube(Tessellator wr, double x1, double y1, double z1, double x2, double y2, double z2){
        wr.startDrawingQuads();
        wr.setNormal(0, 1, 0);
        wr.addVertexWithUV(x2, y2, z2, 0.0, 1.0);
        wr.addVertexWithUV(x2, y2, z1, 1.0, 1.0);
        wr.addVertexWithUV(x1, y2, z1, 1.0, 0.0);
        wr.addVertexWithUV(x1, y2, z2, 0.0, 0.0);

        wr.setNormal(1, 0, 0);
        wr.addVertexWithUV(x2, y2, z2, 0.0, 1.0);
        wr.addVertexWithUV(x2, y1, z2, 1.0, 1.0);
        wr.addVertexWithUV(x2, y1, z1, 1.0, 0.0);
        wr.addVertexWithUV(x2, y2, z1, 0.0, 0.0);

        wr.setNormal(0, 0, -1);
        wr.addVertexWithUV(x2, y2, z1, 0.0, 1.0);
        wr.addVertexWithUV(x2, y1, z1, 1.0, 1.0);
        wr.addVertexWithUV(x1, y1, z1, 1.0, 0.0);
        wr.addVertexWithUV(x1, y2, z1, 0.0, 0.0);

        wr.setNormal(-1, 0, 0);
        wr.addVertexWithUV(x1, y2, z1, 0.0, 1.0);
        wr.addVertexWithUV(x1, y1, z1, 1.0, 1.0);
        wr.addVertexWithUV(x1, y1, z2, 1.0, 0.0);
        wr.addVertexWithUV(x1, y2, z2, 0.0, 0.0);

        wr.setNormal(0, 0, 1);
        wr.addVertexWithUV(x1, y2, z2, 0.0, 1.0);
        wr.addVertexWithUV(x1, y1, z2, 1.0, 1.0);
        wr.addVertexWithUV(x2, y1, z2, 1.0, 0.0);
        wr.addVertexWithUV(x2, y2, z2, 0.0, 0.0);

        wr.setNormal(0, -1, 0);
        wr.addVertexWithUV(x1, y1, z2, 0.0, 1.0);
        wr.addVertexWithUV(x1, y1, z1, 1.0, 1.0);
        wr.addVertexWithUV(x2, y1, z1, 1.0, 0.0);
        wr.addVertexWithUV(x2, y1, z2, 0.0, 0.0);
        Tessellator.instance.draw();
    }
}
