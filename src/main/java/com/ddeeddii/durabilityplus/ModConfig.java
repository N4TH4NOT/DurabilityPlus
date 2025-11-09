package com.ddeeddii.durabilityplus;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import net.minecraft.world.InteractionResult;

@Config(name = "durabilityplus")
public class ModConfig
        implements ConfigData {

    @ConfigEntry.BoundedDiscrete(min = 5, max = 80)
    @ConfigEntry.Gui.Tooltip
    public int yellow_style = 66;
    @ConfigEntry.BoundedDiscrete(min = 1, max = 40)
    @ConfigEntry.Gui.Tooltip
    public int red_style = 33;

    @Override
    public void validatePostLoad() {
        if (this.yellow_style < this.red_style) this.yellow_style = this.red_style + 5;
    }

    public static InteractionResult validateBeforeSave(ConfigHolder<ModConfig> man, ModConfig config) {
        config.validatePostLoad();
        return InteractionResult.PASS;
    }
}
