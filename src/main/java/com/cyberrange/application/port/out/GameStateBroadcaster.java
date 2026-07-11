package com.cyberrange.application.port.out;

import com.cyberrange.domain.model.Game;
import com.cyberrange.domain.model.GameEvent;
import com.cyberrange.domain.model.GameId;

import java.util.List;

/**
 * Puerto de salida: difusion en tiempo real del estado y de los eventos
 * de una partida a los participantes conectados (instructor, atacante,
 * defensor).
 */
public interface GameStateBroadcaster {

    void broadcastState(GameId gameId, Game game);

    void broadcastEvents(GameId gameId, List<GameEvent> events);
}
