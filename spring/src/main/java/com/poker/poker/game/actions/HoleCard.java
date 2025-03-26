package com.poker.poker.game.actions;

import com.poker.poker.game.model.Card;
import com.poker.poker.game.model.Rank;
import com.poker.poker.game.model.Suit;

public class HoleCard extends Action {
    public OrdinalCard ordinalCard;

    public HoleCard(Card card) {
        super(ActionType.HOLE_CARD);

        this.ordinalCard = new OrdinalCard(card);

    }

    public OrdinalCard getOrdinalCard() {
        return ordinalCard;
    }

}
