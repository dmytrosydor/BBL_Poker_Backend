package com.poker.poker.gamelobby.dto;

import java.util.UUID;

public class PlayerJoinResponse {
    private final UUID playerId;
    private final UUID lobbyId;

    public PlayerJoinResponse(UUID playerId, UUID lobbyId) {
        this.playerId = playerId;
        this.lobbyId = lobbyId;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public UUID getLobbyId() {
        return lobbyId;
    }
}
