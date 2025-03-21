package com.poker.poker.chat.message;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import java.util.UUID;

@Controller
public class ChatController {

    private final ChatMessageService chatMessageService;

    public ChatController(ChatMessageService chatMessageService) {
        this.chatMessageService = chatMessageService;
    }

    @MessageMapping("/sendMessage/{lobbyId}")
    @SendTo("/topic/messages/{lobbyId}")
    public Message send(Message message, @org.springframework.messaging.handler.annotation.DestinationVariable UUID lobbyId) {
        System.out.println("Received message: " + message.getFrom() + " - " + message.getContent());
        chatMessageService.addMessage(lobbyId, message);
        return message;
    }

}
