package com.poker.poker.game.actions;

import com.poker.poker.game.model.Card;
import com.poker.poker.game.model.Rank;
import com.poker.poker.game.model.Suit;

import java.util.UUID;

public class HoleCard extends Action {
    private UUID playerId;
    private OrdinalCard ordinalCard;

    public HoleCard(UUID playerId, Card card) {
        super(ActionType.HOLE_CARD);

        this.playerId = playerId;
        this.ordinalCard = new OrdinalCard(card);

    }

    public OrdinalCard getOrdinalCard() {
        return ordinalCard;
    }

    public UUID getPlayerId() {
        return playerId;
    }

}
