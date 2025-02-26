package com.poker.poker.game.actions;

public class Action {
    public int actionType;

    public Action (ActionType actionType) {
        this.actionType = actionType.ordinal();
    }

    public int getActionType() {
        return actionType;
    }
}
