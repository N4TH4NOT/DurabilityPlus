package com.ddeeddii.durabilityplus.mixins;

import com.ddeeddii.durabilityplus.TooltipHandler;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
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
    @Shadow public abstract boolean isDamageableItem();
    @Shadow public abstract int getDamageValue();

    @Redirect(method = "addDetailsToTooltip", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;isDamaged()Z"))
    boolean isDamaged(ItemStack item) {
        return false;
    }

    @Inject(method = "addDetailsToTooltip", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/TooltipFlag;isAdvanced()Z"))
    void appendDamageTooltip(Item.TooltipContext context, TooltipDisplay display, Player player, TooltipFlag flags, Consumer<Component> components, CallbackInfo ci) {
        if (this.isDamageableItem()) {
            int damage = this.getMaxDamage() - this.getDamageValue();
            components.accept(Component.translatable("item.durability", Component.literal(String.valueOf(damage)).withStyle(TooltipHandler.GetFormattingForTooltip(this.getMaxDamage(), damage)), this.getMaxDamage()));
        }
    }
}
