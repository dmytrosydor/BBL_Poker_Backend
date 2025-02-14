package com.poker.poker.game.model;

import com.poker.poker.gamelobby.entity.GameLobby;

import java.util.*;

public class GameState {
    private UUID gameId;
    private List<PlayerInGame> players;
    private GamePhase phase;
    private Deck deck;
    private int pot;
    private List<Card> communityCards;
    private WinnerInfo winnerInfo;

    public GameState(GameLobby gl) {
        this.gameId = UUID.randomUUID();
        this.players = new ArrayList<>();

        List<Player> lobbyList = gl.getPlayers();

        for (Player player : lobbyList) {
            this.players.add(new PlayerInGame(player));
        }
        this.deck = new Deck();
        this.deck.shuffle();
        this.pot = 0;
        this.communityCards = new ArrayList<>();
    }

    public UUID getGameId() {
        return gameId;
    }

    public void setGameId(UUID gameId) {
        this.gameId = gameId;
    }

    public List<PlayerInGame> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerInGame> players) {
        this.players = players;
    }

    public GamePhase getPhase() {
        return phase;
    }

    public void setPhase(GamePhase phase) {
        this.phase = phase;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public int getPot() {
        return pot;
    }

    public void addToPot(int amount) {
        this.pot += amount;
    }

    public List<Card> getCommunityCards() {
        return communityCards;
    }

    public void addCard(Card card) {
        this.communityCards.add(card);
    }

    public void setWinnerInfo(WinnerInfo winnerInfo) {
        this.winnerInfo = winnerInfo;
    }
}
