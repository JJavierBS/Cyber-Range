package com.cyberrange.domain.rules;

import com.cyberrange.domain.model.Game;
import com.cyberrange.domain.model.Round;
import org.springframework.stereotype.Component;

/**
 * Implementacion por defecto del motor de reglas. Pendiente de definir:
 * kill chain, defensa en profundidad, deteccion (ruido/IDS/logs) y catch-up.
 */
@Component
public final class DefaultRuleEngine implements RuleEngine {

    @Override
    public RoundResolution resolveRound(Game game, Round round) {
        throw new UnsupportedOperationException("TODO: aplicar reglas de resolucion de ronda");
    }
}
