package com.poker.poker.game.actions;

import java.util.UUID;

public class PlayerTurn extends Action {
    private UUID playerId;

    public PlayerTurn(UUID playerId) {
        super(ActionType.PLAYER_TURN);

        this.playerId = playerId;
    }
}
