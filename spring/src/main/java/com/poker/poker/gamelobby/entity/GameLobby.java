package com.poker.poker.gamelobby.entity;


import com.poker.poker.game.model.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameLobby {

    private Long id;
    private String lobbyName;
    private Integer playerCount;


    private List<Player> players;


    public GameLobby(String lobbyName) {
        this.lobbyName = lobbyName;
        this.playerCount = 0;
        this.players = new ArrayList<>();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getLobbyName() {
        return lobbyName;
    }

    public void setLobbyName(String lobbyName) {
        this.lobbyName = lobbyName;
    }

    public Integer getPlayerCount() {
        return playerCount;
    }

    public List<Player> getPlayers() {
        return players;
    }


}

