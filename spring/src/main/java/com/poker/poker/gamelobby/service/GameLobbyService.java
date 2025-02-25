package com.poker.poker.gamelobby.service;

import com.poker.poker.game.model.Player;
import com.poker.poker.gamelobby.dto.PlayerJoinResponse;
import com.poker.poker.gamelobby.entity.GameLobby;        // For the entity

import com.poker.poker.notifications.dto.LobbyUpdateRequest;
import com.poker.poker.notifications.entities.LobbyUpdate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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

    public GameLobby getLobby(UUID id) {
        GameLobby gl = null;

        for (GameLobby gameLobby : this.lobbyList) {
            if (gameLobby.getId().equals(id)) {
                gl = gameLobby;
            }
        }

        return gl;
    }

    public List<GameLobby> getAllLobbies() {
        return lobbyList;
    }

    public PlayerJoinResponse joinLobby(UUID lobbyId, String playerName) {
        GameLobby gl = null;

        for (GameLobby gameLobby : this.lobbyList) {
            if (gameLobby.getId().equals(lobbyId)) {
                gl = gameLobby;
            }
        }

        Player p = new Player(playerName);

        gl.addPlayer(p);

        return new PlayerJoinResponse(p.getId(), gl.getId());
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


