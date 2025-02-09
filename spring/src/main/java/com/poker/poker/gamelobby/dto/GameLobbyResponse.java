package com.poker.poker.gamelobby.dto;

import com.poker.poker.game.model.Player;

import java.util.List;
import java.util.Set;

public class GameLobbyResponse {
    private Long id;
    private String lobbyName;
    private Integer playerCount;
    private List<Player> players;

    public GameLobbyResponse(Long id, String lobbyName, Integer playerCount, List<Player> players) {
        this.id = id;
        this.lobbyName = lobbyName;
        this.playerCount = playerCount;
        this.players = players;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
