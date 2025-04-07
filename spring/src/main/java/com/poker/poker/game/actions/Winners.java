package com.poker.poker.game.actions;

import com.poker.poker.game.model.PlayerInGame;
import com.poker.poker.game.model.WinnerInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Winners extends Action {
    private List<UUID> winnerIds;

    public Winners(WinnerInfo winnerInfo) {
        super(ActionType.WINNERS);

        winnerIds = new ArrayList<>();

        for (PlayerInGame player : winnerInfo.getWinners()){
            winnerIds.add(player.getPlayer().getId());
        }

    }

    public List<UUID> getWinnerIds() {
        return winnerIds;
    }
}
