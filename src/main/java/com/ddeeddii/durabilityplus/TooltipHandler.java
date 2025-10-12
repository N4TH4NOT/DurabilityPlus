package com.ddeeddii.durabilityplus;

import net.minecraft.util.Formatting;

public class TooltipHandler {
    public static Formatting GetFormattingForTooltip(int maxDurability, int currentDurability){
        if(maxDurability * 0.66f <= currentDurability){
            return Formatting.GREEN;
        } else if(maxDurability * 0.33f <= currentDurability){
            return Formatting.YELLOW;
        }

        return Formatting.RED;
    }
}
