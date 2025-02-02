package com.poker.poker.chat.message;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public Message send(Message message) {
        System.out.println("Received message: " + message.getFrom() + " - " + message.getContent());
        return message;
    }

}
