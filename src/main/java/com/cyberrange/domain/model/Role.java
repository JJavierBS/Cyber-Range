package com.cyberrange.domain.model;

/**
 * Bando de un participante en la partida. El instructor no juega un bando,
 * solo crea y arbitra: se modela aparte, no como Role.
 */
public enum Role {
    ATTACKER,
    DEFENDER
}
