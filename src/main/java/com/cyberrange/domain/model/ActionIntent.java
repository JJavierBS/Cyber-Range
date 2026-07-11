package com.cyberrange.domain.model;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * Intencion de accion encolada por un participante para la ronda actual.
 * "noisy" distingue acciones ruidosas (detectables por IDS/logs) de
 * silenciosas, base de la mecanica de deteccion.
 */
public record ActionIntent(
        UUID id,
        Role team,
        String actionType,
        Map<String, String> parameters,
        boolean noisy) {

    public ActionIntent {
        Objects.requireNonNull(id, "id");
        Objects.requireNonNull(team, "team");
        Objects.requireNonNull(actionType, "actionType");
        parameters = parameters == null ? Map.of() : Map.copyOf(parameters);
    }
}
