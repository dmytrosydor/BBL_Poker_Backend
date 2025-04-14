package com.poker.poker.gamelobby.controller;

import com.poker.poker.gamelobby.dto.PlayerJoinRequest;
import com.poker.poker.gamelobby.dto.PlayerJoinResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

import com.poker.poker.gamelobby.service.GameLobbyService;
import com.poker.poker.gamelobby.dto.CreateLobbyRequest;
import com.poker.poker.gamelobby.entity.GameLobby;

@CrossOrigin(origins = {"https://bblpoker.win", "http://localhost:5173"})
@RestController
@RequestMapping("/api/games")
public class GameLobbyController {
    private final GameLobbyService service;

    public GameLobbyController(GameLobbyService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<GameLobby> createGameLobby(@RequestBody CreateLobbyRequest request) {
        GameLobby createdLobby = service.createLobby(request.getLobbyName(), request.getPlayerRequirement());
        return ResponseEntity.ok(createdLobby);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<GameLobby>> getAllGameLobbies() {
        List<GameLobby> lobbies = service.getAllLobbies();
        return ResponseEntity.ok(lobbies);
    }

    @GetMapping("/get/{lobbyId}")
    public ResponseEntity<GameLobby> getGameLobby(@PathVariable UUID lobbyId) {
        GameLobby gameLobby = service.getLobby(lobbyId);
        return ResponseEntity.ok(gameLobby);
    }

    @PostMapping("/join/{lobbyId}")
    public ResponseEntity<PlayerJoinResponse> joinLobby(@PathVariable UUID lobbyId, @RequestBody PlayerJoinRequest request) {
        PlayerJoinResponse updatedLobby = service.joinLobby(lobbyId, request.getPlayerName(), request.getPlayerAvatar());
        return ResponseEntity.ok(updatedLobby);
    }

    @PostMapping("restart/{lobbyId}")
    public void restartLobby(@PathVariable UUID lobbyId) {
        service.restartLobby(lobbyId);
    }

    @PostMapping("leave/{lobbyId}/{playerId}")
    public void leaveLobby(@PathVariable UUID lobbyId, @PathVariable UUID playerId) {
        service.leaveLobby(lobbyId, playerId);
    }
}
