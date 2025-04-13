package com.poker.poker.WebSocket;

import org.springframework.context.ApplicationEvent;

import java.util.UUID;

public class PlayerJoinEvent extends ApplicationEvent {
    private UUID gameId;
    private UUID playerId;

    public PlayerJoinEvent(Object source, UUID gameId, UUID playerId) {
        super(source);

        this.gameId = gameId;
        this.playerId = playerId;
    }

    public UUID getGameId() {
        return gameId;
    }

    public UUID getPlayerId() {
        return playerId;
    }
    
}
