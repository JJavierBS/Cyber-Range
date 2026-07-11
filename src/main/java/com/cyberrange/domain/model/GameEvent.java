package com.cyberrange.domain.model;

import java.time.Instant;
import java.util.Objects;

/**
 * Entrada del registro de eventos generado al resolver una ronda.
 * "visibleToDefender" modela que solo las acciones detectadas (por ruido,
 * IDS o revision de logs) aparecen para el defensor.
 */
public record GameEvent(
        int roundNumber,
        String description,
        boolean visibleToDefender,
        Instant occurredAt) {

    public GameEvent {
        Objects.requireNonNull(description, "description");
        Objects.requireNonNull(occurredAt, "occurredAt");
    }
}
