package com.poker.poker.gamelobby.entity;

import com.poker.poker.game.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GameLobby {
    private UUID id;
    private String lobbyName;
    private Integer playerCount;
    private List<Player> players;
    private boolean gameInProgress;

    public GameLobby(String lobbyName) {
        this.id = UUID.randomUUID();
        this.lobbyName = lobbyName;
        this.playerCount = 0;
        this.players = new ArrayList<Player>();
        this.gameInProgress = false;
    }


    public UUID getId() {
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

    public void setPlayerCount(Integer playerCount) {
        this.playerCount = playerCount;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void setGameInProgress(boolean gameInProgress) {
        this.gameInProgress = gameInProgress;
    }

    public boolean isGameInProgress() {
        return gameInProgress;
    }
}

