package io.izzel.arclight.common.mixin.core.world.entity.monster;

import io.izzel.arclight.common.bridge.core.entity.LivingEntityBridge;
import net.minecraft.world.entity.monster.Illusioner;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "net.minecraft.world.entity.monster.Illusioner$IllusionerBlindnessSpellGoal")
public class Illusioner_BlindnessSpellGoalMixin {
    @SuppressWarnings("target")
    @Shadow(aliases = {"this$0", "f_32941_", "field_7299"}, remap = false)
    private Illusioner outerThis;

    @Inject(method = "performSpellCasting", at = @At("HEAD"))
    private void arclight$reason(CallbackInfo ci) {
        ((LivingEntityBridge) outerThis).bridge$pushEffectCause(EntityPotionEffectEvent.Cause.ATTACK);
    }
}