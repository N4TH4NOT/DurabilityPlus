package com.ddeeddii.durabilityplus;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "durabilityplus")
public class ModConfig
        implements ConfigData {
    @ConfigEntry.BoundedDiscrete(min = 5, max = 80)
    int yellow_style = 66;
    @ConfigEntry.BoundedDiscrete(min = 1, max = 40)
    int red_style = 33;
}
