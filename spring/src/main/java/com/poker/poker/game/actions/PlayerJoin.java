package com.poker.poker.game.actions;

import java.util.UUID;

public class PlayerJoin extends Action {
    private UUID playerId;

    public PlayerJoin(UUID playerId) {
        super(ActionType.PLAYER_JOIN);

        this.playerId = playerId;
    }

    public UUID getPlayerId() {
        return playerId;
    }
}
