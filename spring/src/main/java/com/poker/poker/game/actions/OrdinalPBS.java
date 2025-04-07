package com.poker.poker.game.actions;

import com.poker.poker.game.model.PlayerBestHand;

import java.util.UUID;

public class OrdinalPBS extends Action {
    private int ordinal;
    private UUID playerId;

    public OrdinalPBS(PlayerBestHand playerBestHand, UUID playerId) {
        super(ActionType.BEST_HAND);

        this.ordinal = playerBestHand.getCombination().ordinal();
        this.playerId = playerId;

    }

    public int getOrdinal() {
        return ordinal;
    }

    public UUID getPlayerId() {
        return playerId;
    }
}
