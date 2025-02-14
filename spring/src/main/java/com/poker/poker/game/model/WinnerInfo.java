package com.poker.poker.game.model;

import java.util.List;

public class WinnerInfo {
    int winnerCount;
    List<PlayerInGame> winners;

    WinnerInfo(int winnerCount, List<PlayerInGame> winners) {
        this.winnerCount = winnerCount;
        this.winners = winners;
    }
}

