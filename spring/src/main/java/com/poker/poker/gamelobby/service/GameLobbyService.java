package com.poker.poker.gamelobby.service;

import com.poker.poker.WebSocket.GameStartEvent;
import com.poker.poker.WebSocket.PlayerJoinEvent;
import com.poker.poker.game.model.Player;
import com.poker.poker.gamelobby.dto.PlayerJoinResponse;
import com.poker.poker.gamelobby.entity.GameLobby;        // For the entity

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class GameLobbyService {
    private List<GameLobby> lobbyList;
    private final ApplicationEventPublisher eventPublisher;

    public GameLobbyService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
        this.lobbyList = new ArrayList<>();
    }

    public GameLobby createLobby(String lobbyName, int playerRequirement) {
        GameLobby newLobby = new GameLobby(lobbyName, playerRequirement);
        this.lobbyList.add(newLobby);

        System.out.println("Lobby created: " + newLobby.getLobbyName() + " player_req: " + newLobby.getPlayerRequirement());

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

    public void sendGameStartEvent(GameLobby gameLobby) {
        eventPublisher.publishEvent(new GameStartEvent(this, gameLobby));
    }

    public void sendPlayerJoinEvent(GameLobby gameLobby, Player player) {
        eventPublisher.publishEvent(new PlayerJoinEvent(this, gameLobby.getId(), player.getId()));
    }

    public PlayerJoinResponse joinLobby(UUID lobbyId, String playerName, int avatar) {
        GameLobby gl = null;

        for (GameLobby gameLobby : lobbyList) {
            if (gameLobby.getId().equals(lobbyId)) {
                gl = gameLobby;
            }
        }

        Player p = new Player(playerName, avatar);

        gl.addPlayer(p);

        PlayerJoinResponse response = new PlayerJoinResponse(p.getId(), gl.getId());

        GameLobby finalGl = gl;

        if (finalGl.getPlayerCount() > 1) {
            sendPlayerJoinEvent(finalGl, p);;
        }

        //RETARDED

        if (finalGl.getPlayerCount() == finalGl.getPlayerRequirement()){
            CompletableFuture.runAsync(() -> {
                {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    sendGameStartEvent(finalGl);
                }
            });
        }

        return response;
    }

    public void leaveLobby(UUID lobbyId, UUID playerId) {
        GameLobby gl = null;

        for (GameLobby gameLobby : lobbyList) {
            if (gameLobby.getId().equals(lobbyId)) {
                gl = gameLobby;
            }
        }

        List<Player> playerList = gl.getPlayers();

        Player p = null;

        for (Player player : playerList) {
            if (player.getId().equals(playerId)) {
                p = player;
            }
        }

        playerList.remove(p);

        sendPlayerJoinEvent(gl, p);

        if (gl.getPlayerCount() == 0) {
            lobbyList.remove(gl);
        }
    }

    public void restartLobby(UUID lobbyId) {
        GameLobby gl = null;

        for (GameLobby gameLobby : lobbyList) {
            if (gameLobby.getId().equals(lobbyId)) {
                gl = gameLobby;
            }
        }

        int r = gl.incrementRestartCount();

        GameLobby finalGl = gl;

        if (r == gl.getPlayerCount()) {
            CompletableFuture.runAsync(() -> {
                {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    sendGameStartEvent(finalGl);
                }
            });
        }
    }
}