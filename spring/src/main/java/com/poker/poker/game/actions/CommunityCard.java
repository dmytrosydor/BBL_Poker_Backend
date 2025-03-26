package com.poker.poker.game.actions;

import com.poker.poker.game.model.Card;

public class CommunityCard extends Action {
    public OrdinalCard ordinalCard;

    public CommunityCard(Card card) {
        super(ActionType.COMMUNITY_CARD);

        this.ordinalCard = new OrdinalCard(card);

    }

    public OrdinalCard getOrdinalCard() {
        return ordinalCard;
    }
}
