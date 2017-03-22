package HxCKDMS.HxCPeripherals.tileRender;

import HxCKDMS.HxCPeripherals.HxCPeripherals;
import HxCKDMS.HxCPeripherals.tileEntities.TileEntitySmartLight;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
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
        wr.startDrawingQuads();
        wr.setNormal(0, 1, 0);
        wr.addVertexWithUV(1, 1, 1, 0.0, 1.0);
        wr.addVertexWithUV(1, 1, 0, 1.0, 1.0);
        wr.addVertexWithUV(0, 1, 0, 1.0, 0.0);
        wr.addVertexWithUV(0, 1, 1, 0.0, 0.0);

        wr.setNormal(1, 0, 0);
        wr.addVertexWithUV(1, 1, 1, 0.0, 1.0);
        wr.addVertexWithUV(1, 0, 1, 1.0, 1.0);
        wr.addVertexWithUV(1, 0, 0, 1.0, 0.0);
        wr.addVertexWithUV(1, 1, 0, 0.0, 0.0);

        wr.setNormal(0, 0, -1);
        wr.addVertexWithUV(1, 1, 0, 0.0, 1.0);
        wr.addVertexWithUV(1, 0, 0, 1.0, 1.0);
        wr.addVertexWithUV(0, 0, 0, 1.0, 0.0);
        wr.addVertexWithUV(0, 1, 0, 0.0, 0.0);

        wr.setNormal(-1, 0, 0);
        wr.addVertexWithUV(0, 1, 0, 0.0, 1.0);
        wr.addVertexWithUV(0, 0, 0, 1.0, 1.0);
        wr.addVertexWithUV(0, 0, 1, 1.0, 0.0);
        wr.addVertexWithUV(0, 1, 1, 0.0, 0.0);

        wr.setNormal(0, 0, 1);
        wr.addVertexWithUV(0, 1, 1, 0.0, 1.0);
        wr.addVertexWithUV(0, 0, 1, 1.0, 1.0);
        wr.addVertexWithUV(1, 0, 1, 1.0, 0.0);
        wr.addVertexWithUV(1, 1, 1, 0.0, 0.0);

        wr.setNormal(0, -1, 0);
        wr.addVertexWithUV(0, 0, 1, 0.0, 1.0);
        wr.addVertexWithUV(0, 0, 0, 1.0, 1.0);
        wr.addVertexWithUV(1, 0, 0, 1.0, 0.0);
        wr.addVertexWithUV(1, 0, 1, 0.0, 0.0);

        Tessellator.instance.draw();
        GL11.glPopMatrix();

    }
}
