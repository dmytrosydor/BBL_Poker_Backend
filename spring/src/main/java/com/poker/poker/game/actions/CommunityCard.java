package com.poker.poker.game.actions;

import com.poker.poker.game.model.Card;

public class CommunityCard extends Action {
    public OrdinalCard ordinalCard;

    public CommunityCard(ActionType actionType, Card card) {
        super(actionType);

        this.ordinalCard = new OrdinalCard(card);

    }

    public OrdinalCard getOrdinalCard() {
        return ordinalCard;
    }
}
