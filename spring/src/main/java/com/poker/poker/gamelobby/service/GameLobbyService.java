package com.poker.poker.gamelobby.service;

import com.poker.poker.gamelobby.entity.GameLobby;        // For the entity
import com.poker.poker.gamelobby.repository.GameLobbyRepository; // For the repository
import com.poker.poker.gamelobby.dto.GameLobbyResponse;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<GameLobbyResponse> getAllLobbies() {
        return repository.findAll().stream()
                .map(lobby -> new GameLobbyResponse(lobby.getId(), lobby.getLobbyName(), lobby.getPlayerCount()))
                .collect(Collectors.toList());
    }
}

