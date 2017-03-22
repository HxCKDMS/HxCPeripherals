package HxCKDMS.HxCPeripherals;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;

public class Config {
    public Configuration config;

    public boolean enableSmartLight = true;

    public Config(File file){
        config = new Configuration(file);
        syncConfig();
    }

    public void syncConfig() {
        try {
            // Load config
            config.load();

            Property enableSmartLightProp = config.get(Configuration.CATEGORY_GENERAL,
                    "enableSmartLight",
                    "true",
                    "Are Smart Light peripherals craftable?");

            enableSmartLight = enableSmartLightProp.getBoolean(); // Get the boolean value, also set the property value to boolean
        } catch (Exception e) {
            // Failed reading/writing, just continue
        } finally {
            // Save props to config IF config changed
            if (config.hasChanged()) config.save();
        }
    }
}