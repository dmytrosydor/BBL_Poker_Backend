package com.poker.poker.gamelobby.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GameLobby {
    @Id
    private Long id;
    private String lobbyName;
    private Integer playerCount;

    public GameLobby() {
        this.playerCount = 0;
    }

    public GameLobby(String lobbyName) {
        this.lobbyName = lobbyName;
        this.playerCount = 0;
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

    public void setPlayerCount(Integer playerCount) {
        this.playerCount = playerCount;
    }


}

