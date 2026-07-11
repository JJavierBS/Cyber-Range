package com.cyberrange.adapter.websocket;

import com.cyberrange.domain.model.GameId;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Gestiona el ciclo de vida de las conexiones WebSocket de una partida.
 * Cada cliente se conecta a /ws/games/{gameId}
 */
public final class GameWebSocketHandler extends TextWebSocketHandler {

    private final WebSocketSessionRegistry sessionRegistry;

    public GameWebSocketHandler(WebSocketSessionRegistry sessionRegistry) {
        this.sessionRegistry = sessionRegistry;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessionRegistry.register(gameIdFrom(session), session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        sessionRegistry.unregister(gameIdFrom(session), session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        throw new UnsupportedOperationException("TODO: definir mensajes entrantes por WebSocket, si los hay");
    }

    private GameId gameIdFrom(WebSocketSession session) {
        String path = session.getUri() == null ? "" : session.getUri().getPath();
        String rawId = path.substring(path.lastIndexOf('/') + 1);
        return GameId.of(rawId);
    }
}
