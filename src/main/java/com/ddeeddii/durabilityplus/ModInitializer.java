package com.ddeeddii.durabilityplus;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ModInitializer
    implements ClientModInitializer {

    public static final Logger LOGGER = LogManager.getLogger("DurabilityPlus");
    private static ModConfig CONFIG;

    @Override
    public void onInitializeClient() {
        AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);
        LOGGER.info("Mod loaded!");
    }

    public static ModConfig getConfig() {
        if (CONFIG == null) {
            return CONFIG = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
        }
        return CONFIG;
    }
}
