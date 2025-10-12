package com.ddeeddii.durabilityplus;

import net.minecraft.ChatFormatting;

public class TooltipHandler {
    public static ChatFormatting GetFormattingForTooltip(int maxDurability, int currentDurability){
        if(maxDurability * 0.66f <= currentDurability){
            return ChatFormatting.GREEN;
        } else if(maxDurability * 0.33f <= currentDurability){
            return ChatFormatting.YELLOW;
        }

        return ChatFormatting.RED;
    }
}
