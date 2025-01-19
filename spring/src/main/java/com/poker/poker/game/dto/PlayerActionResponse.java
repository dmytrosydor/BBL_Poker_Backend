package com.poker.poker.game.dto;

import com.poker.poker.game.model.GameState;

public class PlayerActionResponse {
    private boolean success;
    private String message;
    private GameState updatedGameState;

    public PlayerActionResponse(boolean success, String message, GameState updatedGameState) {
        this.success = success;
        this.message = message;
        this.updatedGameState = updatedGameState;
    }


    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public GameState getUpdatedGameState() {
        return updatedGameState;
    }
}
