package com.cyberrange.adapter.persistence.memory;

import com.cyberrange.application.port.out.GameRepository;
import com.cyberrange.domain.model.Game;
import com.cyberrange.domain.model.GameId;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public final class InMemoryGameRepository implements GameRepository {

    private final Map<GameId, Game> games = new ConcurrentHashMap<>();

    @Override
    public Game save(Game game) {
        games.put(game.id(), game);
        return game;
    }

    @Override
    public Optional<Game> findById(GameId gameId) {
        return Optional.ofNullable(games.get(gameId));
    }
}
