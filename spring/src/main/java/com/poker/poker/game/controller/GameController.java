package com.poker.poker.game.controller;

import com.poker.poker.game.model.*;
import com.poker.poker.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/api/game")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    /*@PostMapping("/create")
    public ResponseEntity<GameState> createGame(@RequestBody List<PlayerInGame> players) {
        GameState newGame = gameService.createGame(players);
        return ResponseEntity.ok(newGame);
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<GamePhase> getGamePhase(@PathVariable UUID gameId) {
        Optional<GamePhase> gamePhase = gameService.getGamePhaseById(gameId);

        return gamePhase.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{gameId}")
    public ResponseEntity<String> updateGameState(@PathVariable UUID gameId, @RequestBody GameState updatedState) {
        boolean updated = gameService.updateGameState(gameId, updatedState);

        if (updated) {
            return ResponseEntity.ok("Game state updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

    @DeleteMapping("/removePlayer/{gameId}/{lobbyId}/{playerId}")
    public ResponseEntity<String> removePlayer(@PathVariable UUID gameId,
                                               @PathVariable UUID lobbyId,
                                               @PathVariable UUID playerId) {
        boolean removed = gameService.removePlayerCompletely(gameId, lobbyId, playerId);

        if (removed) {
            return ResponseEntity.ok("Player removed from game and lobby.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player not found in game.");
        }
    }

}
