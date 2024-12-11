package com.poker.poker.gamelobby.service;

import com.poker.poker.gamelobby.entity.GameLobby;        // For the entity
import com.poker.poker.gamelobby.repository.GameLobbyRepository; // For the repository

import org.springframework.stereotype.Service;

@Service
public class GameLobbyService {
    private final GameLobbyRepository repository;

    public GameLobbyService(GameLobbyRepository repository) {
        this.repository = repository;
    }

    public GameLobby createLobby(String lobbyName) {
        GameLobby newLobby = new GameLobby(lobbyName);
        return repository.save(newLobby);
    }
}

