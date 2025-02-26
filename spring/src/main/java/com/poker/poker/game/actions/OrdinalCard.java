package com.poker.poker.game.actions;

import com.poker.poker.game.model.Card;

public class OrdinalCard {
    public int rank;
    public int suit;

    public OrdinalCard(Card card) {
        this.rank = card.getRank().ordinal();
        this.suit = card.getSuit().ordinal();
    }

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }
}
