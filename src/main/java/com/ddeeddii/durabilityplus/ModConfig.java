package com.ddeeddii.durabilityplus;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "durabilityplus")
public class ModConfig
        implements ConfigData {

    @ConfigEntry.BoundedDiscrete(min = 5, max = 80)
    @ConfigEntry.Gui.Tooltip
    public int yellow_style = 66;
    @ConfigEntry.BoundedDiscrete(min = 1, max = 40)
    @ConfigEntry.Gui.Tooltip
    public int red_style = 33;
}
