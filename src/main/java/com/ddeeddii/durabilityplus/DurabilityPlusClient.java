package com.ddeeddii.durabilityplus;

import net.fabricmc.api.ClientModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DurabilityPlusClient implements ClientModInitializer {
    public static final Logger LOGGER = LogManager.getLogger("DurabilityPlus");

    @Override
    public void onInitializeClient() {
        LOGGER.info("Mod loaded!");
    }
}
