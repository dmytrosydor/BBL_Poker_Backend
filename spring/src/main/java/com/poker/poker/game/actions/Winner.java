package com.poker.poker.game.actions;

import com.poker.poker.game.model.Player;
import com.poker.poker.game.model.PlayerInGame;

import java.util.UUID;

public class Winner {
    private UUID playerId;
    private int combination;

    public Winner(PlayerInGame playerInGame) {
        this.playerId = playerInGame.getPlayer().getId();
        this.combination = playerInGame.getBestHand().getCombination().ordinal();
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public int getCombination() {
        return combination;
    }
}
