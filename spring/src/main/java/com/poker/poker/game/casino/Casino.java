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

    public GameState addGame(GameLobby gameLobby){
        GameState gameState = new GameState(gameLobby);

        this.gameList.add(gameState);

        return gameState;
    }

    public GameState getGameById(UUID gameId){
        for (GameState gameState : gameList){
            if (gameId == gameState.getId()) return gameState;
        }

        return gameList.getFirst();
    }

    public List<Action> getGameActions(GameState gameState){
        List<Action> actions = List.copyOf(gameState.getActionList());

        gameState.emptyActionList();

        return actions;
    }

    public List<Action> processMessage(GameMessage gameMessage){
        System.out.println("Processing in Casino");

        GameState gameState = getGameById(gameMessage.getGameId());

        gameState.processMessage(gameMessage);

        return getGameActions(gameState);
    }
}
