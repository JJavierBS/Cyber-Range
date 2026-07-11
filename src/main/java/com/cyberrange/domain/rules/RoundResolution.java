package com.cyberrange.domain.rules;

import com.cyberrange.domain.model.CiaState;
import com.cyberrange.domain.model.GameEvent;
import com.cyberrange.domain.model.Role;

import java.util.List;

/**
 * Resultado de resolver una ronda: nuevo estado de la triada, eventos
 * generados y, si procede, el bando ganador y el motivo del fin de partida.
 */
public record RoundResolution(
        CiaState resultingState,
        List<GameEvent> generatedEvents,
        boolean gameOver,
        Role winner) {

    public RoundResolution {
        generatedEvents = generatedEvents == null ? List.of() : List.copyOf(generatedEvents);
    }
}
