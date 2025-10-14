package com.ddeeddii.durabilityplus;

import net.minecraft.ChatFormatting;

public class TooltipHandler {
    public static ChatFormatting GetFormattingForTooltip(int maxDurability, int currentDurability){
        ModConfig config = DurabilityPlusClient.getConfig();

        if(maxDurability * (config.yellow_style / 100f) <= currentDurability){
            return ChatFormatting.GREEN;
        } else if(maxDurability * (config.red_style / 100f) <= currentDurability){
            return ChatFormatting.YELLOW;
        }

        return ChatFormatting.RED;
    }
}
