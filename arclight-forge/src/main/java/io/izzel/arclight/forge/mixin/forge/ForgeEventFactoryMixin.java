package io.izzel.arclight.forge.mixin.forge;

import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.common.util.BlockSnapshot;
import net.minecraftforge.event.ForgeEventFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import io.izzel.arclight.common.mod.util.ArclightCaptures;

import java.util.List;

@Mixin(ForgeEventFactory.class)
public class ForgeEventFactoryMixin {

    @Inject(method = "onBlockPlace", remap = false, at = @At("HEAD"))
    private static void arclight$captureDirection(Entity entity, BlockSnapshot blockSnapshot, Direction direction, CallbackInfoReturnable<Boolean> cir) {
        ArclightCaptures.capturePlaceEventDirection(direction);
    }

    @Inject(method = "onMultiBlockPlace", remap = false, at = @At("HEAD"))
    private static void arclight$captureDirection(Entity entity, List<BlockSnapshot> blockSnapshots, Direction direction, CallbackInfoReturnable<Boolean> cir) {
        ArclightCaptures.capturePlaceEventDirection(direction);
    }
}
