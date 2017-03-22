package HxCKDMS.HxCPeripherals.proxies;

import HxCKDMS.HxCPeripherals.tileEntities.TileEntitySmartLight;
import HxCKDMS.HxCPeripherals.tileRender.TileRenderSmartLight;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenders() {
        super.registerRenders();
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySmartLight.class, new TileRenderSmartLight());
    }
}
