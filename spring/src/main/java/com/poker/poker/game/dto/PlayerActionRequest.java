package com.poker.poker.game.dto;

import com.poker.poker.game.model.PlayerAction;
import java.util.UUID;

public class PlayerActionRequest {
    private UUID gameId;
    private UUID playerId;
    private PlayerAction action;
    private int amount;


    public UUID getGameId() {
        return gameId;
    }

    public void setGameId(UUID gameId) {
        this.gameId = gameId;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public void setPlayerId(UUID playerId) {
        this.playerId = playerId;
    }

    public PlayerAction getAction() {
        return action;
    }

    public void setAction(PlayerAction action) {
        this.action = action;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
