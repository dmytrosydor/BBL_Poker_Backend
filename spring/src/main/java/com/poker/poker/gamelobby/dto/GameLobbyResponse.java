package com.poker.poker.gamelobby.dto;

public class GameLobbyResponse {
    private Long id;
    private String lobbyName;
    private Integer playerCount;

    public GameLobbyResponse(Long id, String lobbyName, Integer playerCount) {
        this.id = id;
        this.lobbyName = lobbyName;
        this.playerCount = playerCount;
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
}
