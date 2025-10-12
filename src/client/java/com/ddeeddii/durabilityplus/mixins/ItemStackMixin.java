package com.ddeeddii.durabilityplus.mixins;

import com.ddeeddii.durabilityplus.TooltipHandler;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @Shadow public abstract int getMaxDamage();
    @Shadow public abstract int getDamage();
    @Shadow public abstract boolean isDamageable();

    @Redirect(method = "appendTooltip", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isDamaged()Z"))
    boolean isDamaged(ItemStack item) {
        return false;
    }

    @Inject(method = "appendTooltip", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/tooltip/TooltipType;isAdvanced()Z"))
    void appendDamageTooltip(Item.TooltipContext context, TooltipDisplayComponent displayComponent, PlayerEntity player, TooltipType type, Consumer<Text> textConsumer, CallbackInfo ci) {
        if (this.isDamageable()) {
            int damage = this.getMaxDamage() - this.getDamage();
            textConsumer.accept(Text.translatable("item.durability", Text.literal(String.valueOf(damage)).formatted(TooltipHandler.GetFormattingForTooltip(this.getMaxDamage(), damage)), this.getMaxDamage()));
        }
    }
}
