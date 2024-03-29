package io.izzel.arclight.common.mixin.core.world.entity.monster;

import io.izzel.arclight.common.bridge.core.entity.MobEntityBridge;
import net.minecraft.world.entity.monster.Phantom;
import org.bukkit.event.entity.EntityTargetEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.minecraft.world.entity.monster.Phantom$PhantomAttackPlayerTargetGoal")
public abstract class Phantom_AttackPlayerTargetGoalMixin {
    @SuppressWarnings("target")
    @Shadow(aliases = {"this$0", "f_33191_", "field_7319"}, remap = false)
    private Phantom outerThis;

    @Inject(method = "canUse", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/monster/Phantom;setTarget(Lnet/minecraft/world/entity/LivingEntity;)V"))
    private void arclight$reason(CallbackInfoReturnable<Boolean> cir) {
        ((MobEntityBridge) outerThis).bridge$pushGoalTargetReason(EntityTargetEvent.TargetReason.CLOSEST_PLAYER, true);
    }
}