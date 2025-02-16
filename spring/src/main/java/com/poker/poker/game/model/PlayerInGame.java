package com.poker.poker.game.model;

import java.util.ArrayList;
import java.util.List;

public class PlayerInGame {
    private final Player player;
    private List<Card> hand;
    private PlayerBestHand pbh;
    private int balance;

    public PlayerInGame(Player player) {
        this.player = player;
        this.hand = new ArrayList<>();
        this.balance = 1000;
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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}