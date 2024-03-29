package io.izzel.arclight.forge.mod.event;

import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.bukkit.craftbukkit.v.event.CraftEventFactory;

public class ItemEntityEventDispatcher {

    @SubscribeEvent(receiveCanceled = true)
    public void onExpire(ItemExpireEvent event) {
        event.setCanceled(CraftEventFactory.callItemDespawnEvent(event.getEntity()).isCancelled());
    }
}
