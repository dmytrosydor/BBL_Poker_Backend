package com.poker.poker.gamelobby.entity;

import com.poker.poker.game.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GameLobby {
    private UUID id;
    private String lobbyName;
    private int playerCount;
    private int playerRequirement;
    private int restartCount;
    private List<Player> players;
    private boolean gameInProgress;

    public GameLobby(String lobbyName, int playerRequirement) {
        this.id = UUID.randomUUID();
        this.lobbyName = lobbyName;
        this.playerCount = 0;
        this.playerRequirement = playerRequirement;
        this.restartCount = 0;
        this.players = new ArrayList<>();
        this.gameInProgress = false;
    }


    public UUID getId() {
        return id;
    }

    public String getLobbyName() {
        return lobbyName;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public int getPlayerRequirement() {
        return playerRequirement;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);

        this.playerCount++;
    }

    public void setGameInProgress(boolean gameInProgress) {
        this.gameInProgress = gameInProgress;
    }

    public boolean isGameInProgress() {
        return gameInProgress;
    }

    public int getRestartCount() {
        return restartCount;
    }

    public int incrementRestartCount() {
        restartCount++;
        return restartCount;
    }

    public void decreasePlayerCount() {
        playerCount--;
    }
}