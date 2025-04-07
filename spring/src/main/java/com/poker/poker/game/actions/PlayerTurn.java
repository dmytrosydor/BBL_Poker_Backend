package com.poker.poker.game.actions;

import java.util.UUID;

public class PlayerTurn extends Action {
    private UUID playerId;
    private int currentBet;

    public PlayerTurn(UUID playerId, int currentBet) {
        super(ActionType.PLAYER_TURN);

        this.playerId = playerId;
        this.currentBet = currentBet;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public int getCurrentBet() {
        return currentBet;
    }
}
