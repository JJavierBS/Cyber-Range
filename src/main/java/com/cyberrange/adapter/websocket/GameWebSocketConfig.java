package com.cyberrange.adapter.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Registra el endpoint WebSocket /ws/games/{gameId}. El CORS de origenes
 * permitidos se ajustara cuando se defina el dominio del frontend.
 */
@Configuration
@EnableWebSocket
public class GameWebSocketConfig implements WebSocketConfigurer {

    private final WebSocketSessionRegistry sessionRegistry;

    public GameWebSocketConfig(WebSocketSessionRegistry sessionRegistry) {
        this.sessionRegistry = sessionRegistry;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new GameWebSocketHandler(sessionRegistry), "/ws/games/{gameId}")
                .setAllowedOrigins("*");
    }
}
