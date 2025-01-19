package com.poker.poker.notifications.controllers;

import com.poker.poker.gamelobby.service.GameLobbyService;
import com.poker.poker.notifications.dto.LobbyUpdateRequest;
import com.poker.poker.notifications.entities.LobbyUpdate;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.handler.annotation.MessageMapping;


@Controller
public class LobbyNotificationController {
    private final GameLobbyService gameLobbyService;

    public LobbyNotificationController(GameLobbyService gameLobbyService) {
        this.gameLobbyService = gameLobbyService;
    }

    @MessageMapping("/table/updates")
    @SendTo("/topic/table/updates")
    public LobbyUpdate handleTableUpdates(LobbyUpdateRequest request) {
        return gameLobbyService.processUpdate(request);
    }
}
