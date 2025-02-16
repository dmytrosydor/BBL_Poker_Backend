/*package com.poker.poker.notifications.controllers;

import com.poker.poker.game.service.GameService;
import com.poker.poker.notifications.entities.GameEvent;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.handler.annotation.MessageMapping;

@Controller
public class GameNotificationController {
    private final GameService gameService;

    public GameNotificationController(GameService gameService) {
        this.gameService = gameService;
    }

    @MessageMapping("/game/events/{lobbyId}")
    @SendTo("/topic/lobby/{lobbyId}/events")
    public GameEvent handleGameEvents(@DestinationVariable Long lobbyId) {
        return gameService.getLastEvent(lobbyId);
    }
}*/
