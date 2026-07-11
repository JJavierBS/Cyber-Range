package com.cyberrange.adapter.rest.controller;

import com.cyberrange.adapter.rest.dto.CreateGameResponse;
import com.cyberrange.adapter.rest.dto.EnqueueActionRequest;
import com.cyberrange.adapter.rest.dto.GameStateResponse;
import com.cyberrange.application.port.in.CreateGameUseCase;
import com.cyberrange.application.port.in.EnqueueActionUseCase;
import com.cyberrange.application.port.in.GetGameStateUseCase;
import com.cyberrange.application.port.in.ResolveRoundUseCase;
import com.cyberrange.domain.model.ActionIntent;
import com.cyberrange.domain.model.CiaPillar;
import com.cyberrange.domain.model.Game;
import com.cyberrange.domain.model.GameId;
import com.cyberrange.domain.model.Role;
import com.cyberrange.domain.rules.RoundResolution;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/games")
public class GameController {

    private final CreateGameUseCase createGameUseCase;
    private final EnqueueActionUseCase enqueueActionUseCase;
    private final ResolveRoundUseCase resolveRoundUseCase;
    private final GetGameStateUseCase getGameStateUseCase;

    public GameController(
            CreateGameUseCase createGameUseCase,
            EnqueueActionUseCase enqueueActionUseCase,
            ResolveRoundUseCase resolveRoundUseCase,
            GetGameStateUseCase getGameStateUseCase) {
        this.createGameUseCase = createGameUseCase;
        this.enqueueActionUseCase = enqueueActionUseCase;
        this.resolveRoundUseCase = resolveRoundUseCase;
        this.getGameStateUseCase = getGameStateUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateGameResponse createGame() {
        GameId gameId = createGameUseCase.createGame();
        return new CreateGameResponse(gameId.toString());
    }

    @GetMapping("/{gameId}")
    public GameStateResponse getGameState(@PathVariable String gameId) {
        Game game = getGameStateUseCase.getGameState(GameId.of(gameId));
        return toResponse(game);
    }

    @PostMapping("/{gameId}/actions")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void enqueueAction(@PathVariable String gameId, @RequestBody EnqueueActionRequest request) {
        ActionIntent action = new ActionIntent(
                UUID.randomUUID(),
                Role.valueOf(request.team()),
                request.actionType(),
                request.parameters(),
                request.noisy());
        enqueueActionUseCase.enqueueAction(GameId.of(gameId), action);
    }

    @PostMapping("/{gameId}/rounds/resolve")
    public ResponseEntity<Void> resolveRound(@PathVariable String gameId) {
        RoundResolution resolution = resolveRoundUseCase.resolveCurrentRound(GameId.of(gameId));
        return resolution.gameOver() ? ResponseEntity.ok().build() : ResponseEntity.accepted().build();
    }

    private GameStateResponse toResponse(Game game) {
        Map<String, Integer> ciaLevels = new LinkedHashMap<>();
        for (CiaPillar pillar : CiaPillar.values()) {
            ciaLevels.put(pillar.name(), game.ciaState().levelOf(pillar));
        }
        return new GameStateResponse(
                game.id().toString(),
                game.phase().name(),
                ciaLevels,
                game.rounds().size());
    }
}
