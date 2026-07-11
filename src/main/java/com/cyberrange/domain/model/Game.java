package com.cyberrange.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Raiz de agregado: una partida completa (fase, triada CIA y rondas).
 * El servidor es la unica fuente de verdad del estado del juego.
 */
public final class Game {

    private final GameId id;
    private GamePhase phase;
    private CiaState ciaState;
    private final List<Round> rounds = new ArrayList<>();

    public Game(GameId id, GamePhase phase, CiaState ciaState) {
        this.id = Objects.requireNonNull(id, "id");
        this.phase = Objects.requireNonNull(phase, "phase");
        this.ciaState = Objects.requireNonNull(ciaState, "ciaState");
    }

    public static Game start() {
        throw new UnsupportedOperationException("TODO: crear partida nueva en fase de preparacion");
    }

    public GameId id() {
        return id;
    }

    public GamePhase phase() {
        return phase;
    }

    public CiaState ciaState() {
        return ciaState;
    }

    public List<Round> rounds() {
        return List.copyOf(rounds);
    }

    public Round currentRound() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Cierra la fase de preparacion y arranca la primera ronda.
     */
    public void beginFirstRound() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Avanza a la siguiente ronda tras resolver la actual.
     */
    public void advanceRound() {
        throw new UnsupportedOperationException("TODO");
    }

    public boolean isOver() {
        throw new UnsupportedOperationException("TODO");
    }
}
