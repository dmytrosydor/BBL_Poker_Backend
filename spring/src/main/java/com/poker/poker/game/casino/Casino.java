package com.poker.poker.game.casino;

import com.poker.poker.WebSocket.WebSocketService;
import com.poker.poker.game.actions.Action;
import com.poker.poker.game.actions.ActionType;
import com.poker.poker.game.feedback.GameMessage;
import com.poker.poker.game.model.GameState;
import com.poker.poker.gamelobby.entity.GameLobby;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Casino {
    private List<GameState> gameList;

    public Casino() {
        gameList = new ArrayList<>();
    }

    public void addGame(GameLobby gameLobby){
        GameState gameState = new GameState(gameLobby);

        this.gameList.add(gameState);
    }

    public GameState getGameById(UUID gameId){
        for (GameState gameState : gameList){
            if (gameId == gameState.getId()) return gameState;
        }

        return null;
    }

    public List<Action> processMessage(GameMessage gameMessage){
        GameState gameState = getGameById(gameMessage.getGameId());

        gameState.processMessage(gameMessage);

        List<Action> actions = gameState.getActionList();

        return new ArrayList<>();
    }
}
