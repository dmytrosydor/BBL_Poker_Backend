package com.poker.poker.game.actions;

import com.poker.poker.game.model.Player;

import java.util.UUID;

public class GameStart extends Action {
    private UUID gameId;

    public GameStart(UUID gameId) {
        super(ActionType.GAME_START);

        this.gameId = gameId;
    }

    public UUID getGameId() {
        return gameId;
    }
}
