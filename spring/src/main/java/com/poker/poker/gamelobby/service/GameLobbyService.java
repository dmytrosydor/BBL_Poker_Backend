package com.poker.poker.gamelobby.service;

import com.poker.poker.gamelobby.entity.GameLobby;        // For the entity

import com.poker.poker.notifications.dto.LobbyUpdateRequest;
import com.poker.poker.notifications.entities.LobbyUpdate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
public class GameLobbyService {
    private List<GameLobby> lobbyList;

    public GameLobbyService() {
        this.lobbyList = new ArrayList<>();
    }

    public GameLobby createLobby(String lobbyName) {
        GameLobby newLobby = new GameLobby(lobbyName);
        this.lobbyList.add(newLobby);

        return newLobby;
    }

    public List<GameLobby> getAllLobbies() {
        return lobbyList;
    }

    /*

    public LobbyUpdate processUpdate(LobbyUpdateRequest request){
        return new LobbyUpdate();
    }

    /*public GameLobby joinLobby(Long lobbyId, String playerName) {
        Optional<GameLobby> lobbyOpt = repository.findById(lobbyId);
        if (lobbyOpt.isPresent()) {
            GameLobby lobby = lobbyOpt.get();
            lobby.addPlayer(playerName);
            return repository.save(lobby);
        }
        throw new RuntimeException("Lobby not found");
    }

    public GameLobby leaveLobby(Long lobbyId, String playerName) {
        Optional<GameLobby> lobbyOpt = repository.findById(lobbyId);
        if (lobbyOpt.isPresent()) {
            GameLobby lobby = lobbyOpt.get();
            lobby.removePlayer(playerName);
            return repository.save(lobby);
        }
        throw new RuntimeException("Lobby not found");
    }*/
}


