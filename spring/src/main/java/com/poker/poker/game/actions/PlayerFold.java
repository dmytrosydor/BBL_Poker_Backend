package com.poker.poker.game.actions;

import java.util.UUID;

public class PlayerFold extends Action {
    private UUID playerId;

    public PlayerFold(UUID playerId) {
        super(ActionType.PLAYER_FOLD);

        this.playerId = playerId;
    }

    public UUID getPlayerId() {
        return playerId;
    }
}
