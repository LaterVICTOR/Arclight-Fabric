package io.izzel.arclight.common.bridge.core.world.server;

import net.minecraft.server.level.Ticket;
import net.minecraft.server.level.TicketType;
import net.minecraft.world.level.ChunkPos;

public interface TicketManagerBridge {

    <T> boolean bridge$addTicketAtLevel(TicketType<T> type, ChunkPos pos, int level, T value);

    <T> boolean bridge$removeTicketAtLevel(TicketType<T> type, ChunkPos pos, int level, T value);

    boolean bridge$addTicket(long chunkPos, Ticket<?> ticket);

    boolean bridge$removeTicket(long chunkPos, Ticket<?> ticket);

    void bridge$tick();

    <T> void bridge$removeAllTicketsFor(TicketType<T> ticketType, int ticketLevel, T ticketIdentifier);

    default boolean bridge$platform$isTicketForceTick(Ticket<?> ticket) {
        return false;
    }

    default void bridge$forge$addForcedTicket(long chunkPosIn, Ticket<?> ticketIn) {}

    default void bridge$forge$removeForcedTicket(long chunkPosIn, Ticket<?> ticketIn) {}
}
