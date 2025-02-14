package com.poker.poker.game.model;

import java.util.ArrayList;
import java.util.List;

public class PlayerInGame {
    private final Player player;
    private List<Card> hand;
    private PlayerBestHand pbh;

    public PlayerInGame(Player player) {
        this.player = player;
        this.hand = new ArrayList<>();
    }

    public Player getPlayer() {
        return player;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void addCards(Card card) {
        this.hand.add(card);
    }

    public void setBestHand(PlayerBestHand pb) {
        this.pbh = pb;
    }

    public PlayerBestHand getBestHand() {
        return pbh;
    }
}