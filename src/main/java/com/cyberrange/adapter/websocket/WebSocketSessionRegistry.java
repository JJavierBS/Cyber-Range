package com.cyberrange.adapter.websocket;

import com.cyberrange.domain.model.GameId;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Registro de sesiones WebSocket abiertas por partida. Pura contabilidad
 * de conexiones, sin logica de negocio: lo usan el handler (para
 * registrar/desregistrar) y el broadcaster (para saber a quien enviar).
 */
@Component
public final class WebSocketSessionRegistry {

    private final Map<GameId, Set<WebSocketSession>> sessionsByGame = new ConcurrentHashMap<>();

    public void register(GameId gameId, WebSocketSession session) {
        sessionsByGame
                .computeIfAbsent(gameId, id -> ConcurrentHashMap.newKeySet())
                .add(session);
    }

    public void unregister(GameId gameId, WebSocketSession session) {
        Set<WebSocketSession> sessions = sessionsByGame.get(gameId);
        if (sessions != null) {
            sessions.remove(session);
        }
    }

    public Set<WebSocketSession> sessionsFor(GameId gameId) {
        return Collections.unmodifiableSet(sessionsByGame.getOrDefault(gameId, Set.of()));
    }
}
