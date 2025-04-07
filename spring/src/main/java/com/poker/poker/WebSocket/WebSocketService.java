package com.poker.poker.WebSocket;

import com.poker.poker.game.actions.Action;
import com.poker.poker.game.actions.HoleCard;
import com.poker.poker.game.actions.OrdinalPBS;
import com.poker.poker.game.actions.PlayerJoin;
import com.poker.poker.game.casino.Casino;
import com.poker.poker.game.feedback.CallMessage;
import com.poker.poker.game.feedback.GameMessage;
import com.poker.poker.game.model.GameState;
import com.poker.poker.gamelobby.entity.GameLobby;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WebSocketService {
    private final SimpMessagingTemplate messagingTemplate;
    private Casino casino;

    public WebSocketService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;

        casino = new Casino();
    }

    public void sendMessageToGame(UUID gameId, Object message) {
        messagingTemplate.convertAndSend("/topic/games/" + gameId, message);
    }

    public void sendMessageToPlayer(UUID playerId, Object message) {
        messagingTemplate.convertAndSend("/topic/players/" + playerId, message);
    }

    public void onMessageReceived(String gameId, GameMessage message) {
        List<Action> actionList = casino.processMessage(message);

        processActionList(UUID.fromString(gameId), actionList);
    }

    public void processActionList(UUID gameId, List<Action> actionList) {
        for (Action action : actionList) {
            if (action instanceof HoleCard holeCard) sendMessageToPlayer(holeCard.getPlayerId(), holeCard);

            else if (action instanceof OrdinalPBS ordinalPBS) sendMessageToPlayer(ordinalPBS.getPlayerId(), ordinalPBS);

            else sendMessageToGame(gameId, action);
        }
    }

    @EventListener
    public void gameStarted(GameStartEvent event) {
        GameLobby gameLobby = event.getGameLobby();

        GameState gameState = casino.addGame(gameLobby);

        List<Action> actionList = casino.getGameActions(gameState);

        processActionList(gameLobby.getId(), actionList);
    }

    @EventListener
    public void playerJoined(PlayerJoinEvent event){
        sendMessageToGame(event.getGameId(), new PlayerJoin(event.getPlayerId()));
    }
}
