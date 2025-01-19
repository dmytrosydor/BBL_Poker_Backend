package com.poker.poker.game.service;

import com.poker.poker.game.model.*;
import com.poker.poker.notifications.entities.GameEvent;
import com.poker.poker.notifications.entities.LobbyUpdate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class GameService {
    private final Map<UUID, GameState> gameStore = new ConcurrentHashMap<>();

    public GameState createGame(List<Player> players) {
        UUID gameId = UUID.randomUUID();
        Deck deck = new Deck();
        deck.shuffle();

        GameState gameState = new GameState(gameId, players, GamePhase.WAITING, deck);

        gameStore.put(gameId, gameState);

        return gameState;
    }

    public Optional<GamePhase> getGamePhaseById(UUID gameId) {
        return Optional.ofNullable(gameStore.get(gameId))
                .map(GameState::getPhase);
    }

    public boolean updateGameState(UUID gameId, GameState updatedState) {
        if (gameStore.containsKey(gameId)) {
            GameState existingState = gameStore.get(gameId);

            existingState.setPhase(updatedState.getPhase());

            gameStore.put(gameId, existingState);
            return true;
        }
        return false;
    }

    public GameEvent getLastEvent(Long lobbyId) {}
}
