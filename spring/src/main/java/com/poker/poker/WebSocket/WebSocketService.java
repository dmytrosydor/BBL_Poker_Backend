package com.poker.poker.WebSocket;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WebSocketService {

    private final SimpMessagingTemplate messagingTemplate;

    public WebSocketService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendMessageToGame(UUID gameId, String message) {
        messagingTemplate.convertAndSend("/topic/games/" + gameId, message);
    }

    public void sendMessageToPlayer(UUID playerId, String message) {
        messagingTemplate.convertAndSend("/topic/players/" + playerId, message);
    }

    public void onMessageReceived(String gameId, String message) {
        // You can filter messages based on the gameId and print them
        System.out.println("Message received for game " + gameId + ": " + message);
    }
}
