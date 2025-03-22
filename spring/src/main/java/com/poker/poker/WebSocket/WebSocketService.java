package com.poker.poker.WebSocket;

import com.poker.poker.game.actions.Action;
import com.poker.poker.game.casino.Casino;
import com.poker.poker.game.feedback.GameMessage;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WebSocketService {
    private final SimpMessagingTemplate messagingTemplate;
    private Casino casino;

    public WebSocketService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendMessageToGame(UUID gameId, Object message) {
        messagingTemplate.convertAndSend("/topic/games/" + gameId, message);
    }

    public void sendMessageToPlayer(UUID playerId, Object message) {
        messagingTemplate.convertAndSend("/topic/players/" + playerId, message);
    }

    public void onMessageReceived(String gameId, GameMessage message) {
        System.out.println("Message received for game " + gameId + ": " + message);
    }
}
