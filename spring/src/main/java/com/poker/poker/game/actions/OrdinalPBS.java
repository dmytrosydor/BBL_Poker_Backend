package com.poker.poker.game.actions;

import com.poker.poker.game.model.Card;
import com.poker.poker.game.model.PlayerBestHand;

import java.util.ArrayList;
import java.util.List;

public class OrdinalPBS extends Action {
    public List<OrdinalCard> ordinalPBS;

    public OrdinalPBS(PlayerBestHand playerBestHand) {
        super(ActionType.BEST_HAND);

        this.ordinalPBS = new ArrayList<>();

        List<Card> cards = playerBestHand.getCards();

        for (Card card : cards) {
            ordinalPBS.add(new OrdinalCard(card));
        }
    }

    public List<OrdinalCard> getOrdinalPBS() {
        return ordinalPBS;
    }
}
