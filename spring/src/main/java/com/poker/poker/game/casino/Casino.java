package com.poker.poker.game.casino;

import com.poker.poker.WebSocket.WebSocketService;
import com.poker.poker.game.actions.Action;
import com.poker.poker.game.actions.ActionType;
import com.poker.poker.game.model.GameState;
import com.poker.poker.gamelobby.entity.GameLobby;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class Casino {
    private final WebSocketService webSocketService;
    private List<GameState> gameList;

    public Casino(WebSocketService webSocketService) {
        this.webSocketService = webSocketService;

        gameList = new ArrayList<>();
    }

    public void addGame(GameLobby gameLobby){
        GameState gameState = new GameState(gameLobby);

        this.gameList.add(gameState);
    }

    public GameState getGameById(String gameId){
        UUID uuid = UUID.fromString(gameId);
        for (GameState gameState : gameList){
            if (uuid == gameState.getId()) return gameState;
        }

        return null;
    }

    public Action prepareResponse(Action action){
        /*switch (action.getActionType()){

        }*/

        return new Action(ActionType.HOLE_CARD);
    }

    //public void processMessage()
}
