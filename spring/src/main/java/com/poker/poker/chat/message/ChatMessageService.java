package com.poker.poker.chat.message;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class ChatMessageService {

    private final Map<UUID, List<Message>> chatHistory = new ConcurrentHashMap<>();

    public void addMessage(UUID lobbyId, Message message) {
        chatHistory
                .computeIfAbsent(lobbyId, k -> new CopyOnWriteArrayList<>())
                .add(message);
    }

    public List<Message> getChatHistory(UUID lobbyId) {
        return chatHistory.getOrDefault(lobbyId, new ArrayList<>());
    }
}
