package com.poker.poker.WebSocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")
                .setAllowedOrigins("http://13.37.225.112", "http://localhost:5173");

        registry.addEndpoint("/chat").setAllowedOrigins("http://13.37.225.112", "http://localhost:5173").withSockJS();

        registry.addEndpoint("/games/{gameId}").setAllowedOrigins("http://13.37.225.112", "http://localhost:5173");
        registry.addEndpoint("/players/{playerId}").setAllowedOrigins("http://13.37.225.112", "http://localhost:5173");
    }
}
