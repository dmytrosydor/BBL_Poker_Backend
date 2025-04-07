package com.poker.poker.gamelobby.dto;

public class CreateLobbyRequest {
    private String lobbyName;
    private int playerRequirement;

    public String getLobbyName() {
        return lobbyName;
    }

    public int getPlayerRequirement() {
        return playerRequirement;
    }
}

