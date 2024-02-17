package io.izzel.arclight.common.mod.server.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.Projectile;
import org.bukkit.craftbukkit.v.CraftServer;
import org.bukkit.craftbukkit.v.entity.CraftProjectile;

public class ArclightModProjectile extends CraftProjectile {

    public ArclightModProjectile(CraftServer server, Entity entity) {
        super(server, (Projectile) entity);
    }
}
