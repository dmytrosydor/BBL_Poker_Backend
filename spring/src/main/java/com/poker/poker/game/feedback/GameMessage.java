package com.poker.poker.game.feedback;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "actionType"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CallMessage.class, name = "3"),
        @JsonSubTypes.Type(value = FoldMessage.class, name = "4")
})

public abstract class GameMessage {
    private int actionType;
    private UUID playerId;
    private UUID gameId;

    public int getActionType() {
        return actionType;
    }

    public void setActionType(int actionType) {
        this.actionType = actionType;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public void setPlayerId(UUID playerId) {
        this.playerId = playerId;
    }

    public UUID getGameId() {
        return gameId;
    }

    public void setGameId(UUID gameId) {
        this.gameId = gameId;
    }
}

