package com.poker.poker.gamelobby.service;

import com.poker.poker.WebSocket.WebSocketService;
import com.poker.poker.game.model.Player;
import com.poker.poker.gamelobby.dto.PlayerJoinResponse;
import com.poker.poker.gamelobby.entity.GameLobby;        // For the entity

import com.poker.poker.notifications.dto.LobbyUpdateRequest;
import com.poker.poker.notifications.entities.LobbyUpdate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.client.WebSocketClient;
import com.poker.poker.WebSocket.WebSocketService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.Optional;
import java.util.UUID;

@Service
public class GameLobbyService {
    private List<GameLobby> lobbyList;

    /*public GameLobbyService() {
        this.lobbyList = new ArrayList<>();
    }*/

    private final WebSocketService webSocketService;

    public GameLobbyService(WebSocketService webSocketService) {
        this.webSocketService = webSocketService;
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

    public int WebSocketTest(UUID gameId, UUID playerId) {
        String jsonString = "{\"firstName\":\"Vladyslav\",\"lastName\":\"Pushak\"}";

        webSocketService.sendMessageToGame(gameId, jsonString);

        webSocketService.sendMessageToPlayer(playerId, jsonString);



        return 1;
    }

    /*

    public LobbyUpdate processUpdate(LobbyUpdateRequest request){
        return new LobbyUpdate();
    }

    public GameLobby joinLobby(Long lobbyId, String playerName) {
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

    public boolean removePlayerFromLobby(UUID lobbyId, UUID playerId) {
        Optional<GameLobby> lobbyOpt = lobbyList.stream()
                .filter(lobby -> lobby.getId().equals(lobbyId))
                .findFirst();

        if (lobbyOpt.isPresent()) {
            GameLobby lobby = lobbyOpt.get();

            boolean removed = lobby.getPlayers().removeIf(player -> player.getId().equals(playerId));

            lobby.setPlayerCount(lobby.getPlayers().size());

            return removed;
        } else {
            throw new RuntimeException("Lobby not found");
        }
    }

}


