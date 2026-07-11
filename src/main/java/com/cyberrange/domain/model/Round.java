package com.cyberrange.domain.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Una ronda de la partida: acciones encoladas por ambos bandos y eventos
 * generados al resolverla.
 */
public final class Round {

    private final int number;
    private final List<ActionIntent> queuedActions = new ArrayList<>();
    private final List<GameEvent> events = new ArrayList<>();

    public Round(int number) {
        this.number = number;
    }

    public int number() {
        return number;
    }

    public List<ActionIntent> queuedActions() {
        return List.copyOf(queuedActions);
    }

    public List<GameEvent> events() {
        return List.copyOf(events);
    }

    public void enqueue(ActionIntent action) {
        throw new UnsupportedOperationException("TODO: validar presupuesto y encolar accion");
    }

    public void recordEvent(GameEvent event) {
        throw new UnsupportedOperationException("TODO");
    }
}
