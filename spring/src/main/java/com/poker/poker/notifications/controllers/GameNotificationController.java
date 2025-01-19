package com.poker.poker.notifications.controllers;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.handler.annotation.MessageMapping;

@Controller
public class GameNotificationController {
    @MessageMapping("/game/events/{tableId}")
    @SendTo("/topic/table/{tableId}/events")
    public GameEvent handleGameEvents(@DestinationVariable Long tableId) {
        return gameService.getLastEvent(tableId);
    }
}
