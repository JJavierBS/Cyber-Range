package com.cyberrange.adapter.websocket;

import com.cyberrange.application.port.out.GameStateBroadcaster;
import com.cyberrange.domain.model.Game;
import com.cyberrange.domain.model.GameEvent;
import com.cyberrange.domain.model.GameId;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Implementacion del puerto de salida de difusion en tiempo real sobre
 * WebSocket.
 */
@Component
public final class GameStateWebSocketBroadcaster implements GameStateBroadcaster {

    private final WebSocketSessionRegistry sessionRegistry;

    public GameStateWebSocketBroadcaster(WebSocketSessionRegistry sessionRegistry) {
        this.sessionRegistry = sessionRegistry;
    }

    @Override
    public void broadcastState(GameId gameId, Game game) {
        throw new UnsupportedOperationException("TODO: serializar y enviar el estado a sessionRegistry.sessionsFor(gameId)");
    }

    @Override
    public void broadcastEvents(GameId gameId, List<GameEvent> events) {
        throw new UnsupportedOperationException("TODO: serializar y enviar los eventos a sessionRegistry.sessionsFor(gameId)");
    }
}
