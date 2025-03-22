package com.poker.poker.game.feedback;

public class CallMessage extends GameMessage {
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
