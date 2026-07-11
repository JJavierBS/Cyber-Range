package com.cyberrange.application.service;

import com.cyberrange.application.port.in.CreateGameUseCase;
import com.cyberrange.application.port.in.EnqueueActionUseCase;
import com.cyberrange.application.port.in.GetGameStateUseCase;
import com.cyberrange.application.port.in.ResolveRoundUseCase;
import com.cyberrange.application.port.out.GameRepository;
import com.cyberrange.application.port.out.GameStateBroadcaster;
import com.cyberrange.domain.model.ActionIntent;
import com.cyberrange.domain.model.Game;
import com.cyberrange.domain.model.GameId;
import com.cyberrange.domain.rules.RoundResolution;
import com.cyberrange.domain.rules.RuleEngine;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Orquesta los casos de uso apoyandose en el dominio y en los puertos de
 * salida. No contiene reglas de juego (eso vive en RuleEngine);
 * solo coordina persistencia, motor de reglas y difusion.
 */
@Service
public final class GameApplicationService
        implements CreateGameUseCase, EnqueueActionUseCase, ResolveRoundUseCase, GetGameStateUseCase {

    private final GameRepository gameRepository;
    private final GameStateBroadcaster broadcaster;
    private final RuleEngine ruleEngine;

    public GameApplicationService(GameRepository gameRepository, GameStateBroadcaster broadcaster, RuleEngine ruleEngine) {
        this.gameRepository = Objects.requireNonNull(gameRepository, "gameRepository");
        this.broadcaster = Objects.requireNonNull(broadcaster, "broadcaster");
        this.ruleEngine = Objects.requireNonNull(ruleEngine, "ruleEngine");
    }

    @Override
    public GameId createGame() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void enqueueAction(GameId gameId, ActionIntent action) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public RoundResolution resolveCurrentRound(GameId gameId) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public Game getGameState(GameId gameId) {
        throw new UnsupportedOperationException("TODO");
    }
}
