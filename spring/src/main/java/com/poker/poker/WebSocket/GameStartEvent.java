package com.poker.poker.WebSocket;

import com.poker.poker.gamelobby.entity.GameLobby;
import org.springframework.context.ApplicationEvent;


public class GameStartEvent extends ApplicationEvent {
    private final GameLobby gameLobby;

    public GameStartEvent(Object source, GameLobby gameLobby) {
        super(source);

        this.gameLobby = gameLobby;
    }

    public GameLobby getGameLobby() {
        return gameLobby;
    }
}
