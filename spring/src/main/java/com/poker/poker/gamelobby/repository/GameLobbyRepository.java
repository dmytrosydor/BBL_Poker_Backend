package com.poker.poker.gamelobby.repository;

import com.poker.poker.gamelobby.entity.GameLobby;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

@Repository
public class GameLobbyRepository {
    private final List<GameLobby> lobbies = new ArrayList<GameLobby>();
    private long nextId = 1;

    public GameLobby save(GameLobby lobby) {
        lobby.setId(nextId++);

        lobbies.add(lobby);

        System.out.println(lobby.getLobbyName());
        System.out.println(lobby.getId());
        System.out.println(lobby.getPlayerCount());

        return lobby;
    }
}

