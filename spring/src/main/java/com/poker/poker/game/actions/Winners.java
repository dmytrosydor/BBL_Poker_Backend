package com.poker.poker.game.actions;

import com.poker.poker.game.model.PlayerInGame;
import com.poker.poker.game.model.WinnerInfo;

import java.util.ArrayList;
import java.util.List;

public class Winners extends Action {
    private List<Winner> winnerList;

    public Winners(WinnerInfo winnerInfo) {
        super(ActionType.WINNERS);

        this.winnerList = new ArrayList<>();

        List<PlayerInGame> pigs = winnerInfo.getWinners();

        for (PlayerInGame pig : pigs) {
            winnerList.add(new Winner(pig));
        }

    }

    public List<Winner> getWinnerList() {
        return winnerList;
    }
}
