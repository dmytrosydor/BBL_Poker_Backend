package com.poker.poker.game.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Player {
    private UUID id;
    private String nickname;
    private int balance; // Баланс гравця
    private List<Card> hand; // Карти, які має гравець

    public Player(UUID id, String nickname, int balance) {
        this.id = id;
        this.nickname = nickname;
        this.balance = balance;
        this.hand = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void addCards(List<Card> cards) {
        this.hand.addAll(cards);
    }
}
