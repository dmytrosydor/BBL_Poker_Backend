package com.poker.poker.game.actions;

import java.util.UUID;

public class PlayerCall extends Action {
    private UUID playerId;
    private int amount;
    private int newPot;

    public PlayerCall(UUID playerId, int amount, int newPot) {
        super(ActionType.PLAYER_CALL);

        this.playerId = playerId;
        this.amount = amount;
        this.newPot = newPot;
    }

    public UUID getPlayerId() {
        return playerId;
    }
    public int getAmount() {
        return amount;
    }

    public int getNewPot(){
        return newPot;
    }

}
