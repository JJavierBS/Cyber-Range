package com.cyberrange.domain.model;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

/**
 * Nivel de salud de cada pilar de la triada CIA (0 = derribado, 100 = intacto).
 * El calculo de impacto de una accion es una regla de juego y vive en el
 * motor de reglas, no aqui: este tipo solo modela el estado resultante.
 */
public final class CiaState {

    private final Map<CiaPillar, Integer> levels;

    public CiaState(Map<CiaPillar, Integer> levels) {
        this.levels = new EnumMap<>(Objects.requireNonNull(levels, "levels"));
    }

    public static CiaState intact() {
        throw new UnsupportedOperationException("TODO: estado inicial de la triada CIA");
    }

    public int levelOf(CiaPillar pillar) {
        throw new UnsupportedOperationException("TODO");
    }

    public boolean isPillarDown(CiaPillar pillar) {
        throw new UnsupportedOperationException("TODO");
    }

    public CiaState withImpact(CiaPillar pillar, int delta) {
        throw new UnsupportedOperationException("TODO: aplicar impacto de una accion sobre un pilar");
    }
}
